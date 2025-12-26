package kr.kro.moonlightmoist.shopapi.helpcenter.repository;

import kr.kro.moonlightmoist.shopapi.helpcenter.domain.Faq;
import kr.kro.moonlightmoist.shopapi.helpcenter.domain.InquiryType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FaqRepository extends JpaRepository<Faq, Long> {

    List<Faq> findByInquiryType (InquiryType inquiryType);
}