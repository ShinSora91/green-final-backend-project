package kr.kro.moonlightmoist.shopapi.helpcenter.dto;


import kr.kro.moonlightmoist.shopapi.helpcenter.domain.InquiryType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FaqRequestDTO {

    private InquiryType inquiryType;

    private String title;

    private String answer;


}
