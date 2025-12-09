package kr.kro.moonlightmoist.shopapi.pointHistory.scheduler;

import kr.kro.moonlightmoist.shopapi.pointHistory.service.PointExpireService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PointExpireScheduler {

    private final PointExpireService pointExpireService;

    // cron 표현식 04시 00분 00초
    @Scheduled(cron = "0 0 4 * * *")
    public void expirePointsDaily() {
        log.info("포인트 만료 처리 스케줄러 시작");

        try {
            int cnt = pointExpireService.expirePoints();
            log.info("포인트 만료 처리 {} 개 완료", cnt);
        } catch (Exception e) {
            log.error("포인트 만료 처리 중 오류 발생", e);
        }
        log.info("포인트 만료 처리 스케줄러 종료");
    }

    // 개발 중 테스트용 (1분마다 실행)
//     @Scheduled(cron = "0 */1 * * * *")
//     public void expirePointsForTest() {
//         log.info("포인트 만료 처리 스케줄러 시작");
//
//         try {
//             int cnt = pointExpireService.expirePoints();
//             log.info("포인트 만료 처리 {} 개 완료", cnt);
//         } catch (Exception e) {
//             log.error("포인트 만료 처리 중 오류 발생", e);
//         }
//         log.info("포인트 만료 처리 스케줄러 종료");
//     }
}
