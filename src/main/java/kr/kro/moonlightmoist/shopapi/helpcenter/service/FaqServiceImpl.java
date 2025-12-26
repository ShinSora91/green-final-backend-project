package kr.kro.moonlightmoist.shopapi.helpcenter.service;

import kr.kro.moonlightmoist.shopapi.helpcenter.domain.Faq;
import kr.kro.moonlightmoist.shopapi.helpcenter.dto.FaqDTO;
import kr.kro.moonlightmoist.shopapi.helpcenter.dto.FaqRequestDTO;
import kr.kro.moonlightmoist.shopapi.helpcenter.repository.FaqRepository;
import kr.kro.moonlightmoist.shopapi.user.domain.User;
import kr.kro.moonlightmoist.shopapi.user.exception.UserNotFoundException;
import kr.kro.moonlightmoist.shopapi.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class FaqServiceImpl implements FaqService {

    private final FaqRepository faqRepository;
    private final UserRepository userRepository;

    @Override
    public List<FaqDTO> getAllFaqs() {
        return faqRepository.findAll().stream()
                .map(faq -> FaqDTO.builder()
                        .id(faq.getId())
                        .inquiryType(faq.getInquiryType().name())
                        .title(faq.getTitle())
                        .answer(faq.getAnswer())
                        .createdAt(faq.getCreatedAt())
                        .updatedAt(faq.getUpdatedAt())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public void createFaq(String loginId, FaqRequestDTO faqRequestDTO) {

        User admin = userRepository.findByLoginId(loginId)
                .orElseThrow(() -> new UserNotFoundException());

        Faq newFaq = Faq.builder()
                .inquiryType(faqRequestDTO.getInquiryType())
                .title(faqRequestDTO.getTitle())
                .answer(faqRequestDTO.getAnswer())
                .user(admin)
                .build();

        faqRepository.save(newFaq);

    }

    @Override
    public void updateFaq(@PathVariable Long id, @RequestBody FaqRequestDTO requestDTO) {
        Faq faq = faqRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 FAQ를 찾을 수 없습니다."));

        faq.setInquiryType(requestDTO.getInquiryType());
        faq.setTitle(requestDTO.getTitle());
        faq.setAnswer(requestDTO.getAnswer());

    }

    @Override
    public void deleteFaq(@PathVariable Long id) {
        if (!faqRepository.existsById(id)) {
            throw new RuntimeException("해당 FAQ가 존재하지 않습니다.");
        }
        faqRepository.deleteById(id);
    }
}
