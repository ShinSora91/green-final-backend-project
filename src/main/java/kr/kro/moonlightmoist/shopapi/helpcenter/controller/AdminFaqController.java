package kr.kro.moonlightmoist.shopapi.helpcenter.controller;

import kr.kro.moonlightmoist.shopapi.helpcenter.dto.FaqDTO;
import kr.kro.moonlightmoist.shopapi.helpcenter.dto.FaqRequestDTO;
import kr.kro.moonlightmoist.shopapi.helpcenter.service.FaqService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/admin/posts")
@RequiredArgsConstructor
public class AdminFaqController {

    private final FaqService faqService;

    @GetMapping("/list") // 조회
    public ResponseEntity<List<FaqDTO>> getFapList() {
        log.info("여기는 자주묻는질문 조회 ");
        return ResponseEntity.ok(faqService.getAllFaqs());
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")// 등록
    public ResponseEntity<String> addFaq (@AuthenticationPrincipal UserDetails userDetails ,
                                          @RequestBody FaqRequestDTO requestDTO) {

        faqService.createFaq(userDetails.getUsername(), requestDTO);
        return ResponseEntity.ok("등록 완료");
    }

    @PutMapping("/modify/{id}")// 수정
    public ResponseEntity<String> modifyFaq (@PathVariable Long id, @RequestBody FaqRequestDTO requestDTO) {
        faqService.updateFaq(id,requestDTO);
        return ResponseEntity.ok("수정 완료");
    }

    @DeleteMapping("/delete/{id}")// 삭제
    public ResponseEntity<String> removeFaq(@PathVariable Long id) {
        faqService.deleteFaq(id);
        return ResponseEntity.ok("삭제 완료");
    }

}
