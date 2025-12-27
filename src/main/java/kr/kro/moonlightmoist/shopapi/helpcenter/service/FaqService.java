package kr.kro.moonlightmoist.shopapi.helpcenter.service;

import kr.kro.moonlightmoist.shopapi.helpcenter.dto.FaqDTO;
import kr.kro.moonlightmoist.shopapi.helpcenter.dto.FaqRequestDTO;
import kr.kro.moonlightmoist.shopapi.user.domain.User;

import java.util.List;

public interface FaqService {
    List<FaqDTO> getAllFaqs();
    void createFaq(String loginId, FaqRequestDTO faqRequestDTO);
    void updateFaq(Long id, FaqRequestDTO requestDTO);
    void deleteFaq(Long id);
}
