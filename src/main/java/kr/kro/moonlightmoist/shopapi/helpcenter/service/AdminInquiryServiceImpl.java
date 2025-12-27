package kr.kro.moonlightmoist.shopapi.helpcenter.service;

import kr.kro.moonlightmoist.shopapi.helpcenter.dto.InquiryDTO;
import kr.kro.moonlightmoist.shopapi.helpcenter.repository.InquiryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminInquiryServiceImpl implements AdminInquiryService {

    private final InquiryRepository inquiryRepository;


    @Override
    public List<InquiryDTO> readInquiryList() {
        return inquiryRepository.findAll().stream()
                .map( inquiry -> InquiryDTO.builder()
                        .inquiryType(inquiry.getInquiryType())
                        .title(inquiry.getTitle())
                        .content(inquiry.getContent())
                        .answerContent(inquiry.getContent())
                        .answered(inquiry.isAnswered())
                        .emailAgreement(inquiry.isEmailAgreement())
                        .smsAgreement(inquiry.isSmsAgreement())
                        .createdAt(inquiry.getCreatedAt())
                        .updatedAt(inquiry.getUpdatedAt())
                        .answerCreatedAt(inquiry.getAnswerCreatedAt())
                        .build())
                .collect(Collectors.toList());
    }
}
