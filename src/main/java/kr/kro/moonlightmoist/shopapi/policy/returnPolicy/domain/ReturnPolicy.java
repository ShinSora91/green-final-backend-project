package kr.kro.moonlightmoist.shopapi.policy.returnPolicy.domain;

import jakarta.persistence.*;
import kr.kro.moonlightmoist.shopapi.common.domain.BaseTimeEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "return_policies")
public class ReturnPolicy extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String applyMethod;
    @Column(nullable = false)
    private String applyPeriod;
    @Column(nullable = false)
    private String costInfo;
    @Column(nullable = false)
    private String notAllowedCondition;
    @Column(nullable = false)
    private String customerServiceNumber;

}
