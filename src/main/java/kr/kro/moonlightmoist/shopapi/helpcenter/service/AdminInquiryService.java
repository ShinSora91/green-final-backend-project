package kr.kro.moonlightmoist.shopapi.helpcenter.service;

import kr.kro.moonlightmoist.shopapi.helpcenter.dto.InquiryDTO;

import java.util.List;

public interface AdminInquiryService {
    List<InquiryDTO> readInquiryList ();

}
