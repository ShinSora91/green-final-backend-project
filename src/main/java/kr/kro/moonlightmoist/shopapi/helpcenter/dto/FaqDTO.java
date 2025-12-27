package kr.kro.moonlightmoist.shopapi.helpcenter.dto;

import kr.kro.moonlightmoist.shopapi.common.domain.BaseTimeEntity;
import kr.kro.moonlightmoist.shopapi.helpcenter.domain.InquiryType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class FaqDTO  {

    private Long id;

    private String inquiryType;

    private String title;

    private String answer;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
