package kr.kro.moonlightmoist.shopapi.order.repository;

import kr.kro.moonlightmoist.shopapi.order.domain.Order;
import kr.kro.moonlightmoist.shopapi.policy.deliveryPolicy.domain.DeliveryPolicy;
import kr.kro.moonlightmoist.shopapi.policy.deliveryPolicy.repository.DeliveryPolicyRepository;
import kr.kro.moonlightmoist.shopapi.user.domain.User;
import kr.kro.moonlightmoist.shopapi.user.domain.UserGrade;
import kr.kro.moonlightmoist.shopapi.user.repository.UserGradeRepository;
import kr.kro.moonlightmoist.shopapi.user.repository.UserRepository;
import kr.kro.moonlightmoist.shopapi.util.EntityFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
@EnableJpaAuditing
class OrderRepositoryUnitTest {
    @Autowired
    UserGradeRepository userGradeRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    DeliveryPolicyRepository deliveryPolicyRepository;

    @Autowired
    OrderRepository orderRepository;


    @Test
    @DisplayName("주문 등록 테스트")
    public void registerOrder() {
        UserGrade userGrade = EntityFactory.createUserGrade();
        UserGrade savedUserGrade = userGradeRepository.save(userGrade);

        User user = EntityFactory.createUser(savedUserGrade);
        User savedUser = userRepository.save(user);

        DeliveryPolicy deliveryPolicy = EntityFactory.createDeliveryPolicy();
        DeliveryPolicy savedDeliveryPolicy = deliveryPolicyRepository.save(deliveryPolicy);

        Order order = EntityFactory.createOrder(savedUser, savedDeliveryPolicy);
        Order savedOrder = orderRepository.save(order);

        assertThat(savedOrder.getId()).isNotNull();
        assertThat(savedOrder.getUser()).isNotNull();
        assertThat(savedOrder.getOrderNumber()).isEqualTo("주문번호");
        assertThat(savedOrder.getPaymentMethod()).isEqualTo("CARD");
        assertThat(savedOrder.getDeliveryPolicy()).isNotNull();
        assertThat(savedOrder.getDeliveryFee()).isEqualTo(savedOrder.getDeliveryPolicy().getBasicDeliveryFee());
        assertThat(savedOrder.getExpectedDeliveryDate()).isEqualTo(LocalDate.of(2025,01,01));
        assertThat(savedOrder.getTotalProductAmount()).isEqualTo(30000);
        assertThat(savedOrder.getDiscountAmount()).isEqualTo(3000);
        assertThat(savedOrder.getUsedpoints()).isEqualTo(3000);
        assertThat(savedOrder.getFinalAmount()).isEqualTo(30000);
        assertThat(savedOrder.getRecipientName()).isEqualTo("이름");
        assertThat(savedOrder.getRecipientPhone()).isEqualTo("01012345678");
        assertThat(savedOrder.getPostalCode()).isEqualTo("123456");
        assertThat(savedOrder.getStreetAddress()).isEqualTo("도로명주소");
        assertThat(savedOrder.getDetailedAddress()).isEqualTo("상세주소");
        assertThat(savedOrder.getDeliveryRequest()).isEqualTo("배송요청사항");
        assertThat(savedOrder.getCreatedAt()).isNotNull();
        assertThat(savedOrder.getUpdatedAt()).isNotNull();
    }

}