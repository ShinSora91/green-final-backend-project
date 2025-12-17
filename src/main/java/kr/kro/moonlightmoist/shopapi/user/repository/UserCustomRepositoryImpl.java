package kr.kro.moonlightmoist.shopapi.user.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import kr.kro.moonlightmoist.shopapi.user.domain.QUser;
import kr.kro.moonlightmoist.shopapi.user.domain.User;
import kr.kro.moonlightmoist.shopapi.user.dto.UserSearchCondition;

import java.time.LocalTime;
import java.util.List;

public class UserCustomRepositoryImpl implements UserCustomRepository{

    private JPAQueryFactory queryFactory;

    public UserCustomRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<User> search(UserSearchCondition condition) {
        QUser user = QUser.user;

        List<User> userList = queryFactory
                .selectFrom(user)
                .where(
                        searchFilter(condition.getSearchType(), condition.getSearchKeyword()),
                        dateFilter(
                                condition.getStartDate() != null ? condition.getStartDate().atStartOfDay() : null,
                                condition.getEndDate() != null ? condition.getEndDate().atTime(LocalTime.MAX) : null
                        ),
                        gradeFilter(condition.getUserGrade()),
                        smsAgreementFilter(condition.getSmsAgreement())
                        emailAgreementFilter(condition.getEmailAgreement())
                        deletedFilter(condition.getUserStatuses())
                )
                .fetch();

        return userList;
    }
}
