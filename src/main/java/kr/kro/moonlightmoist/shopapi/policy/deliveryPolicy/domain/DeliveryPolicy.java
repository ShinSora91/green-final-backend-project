package kr.kro.moonlightmoist.shopapi.policy.deliveryPolicy.domain;

import jakarta.persistence.*;
import kr.kro.moonlightmoist.shopapi.common.domain.BaseTimeEntity;
import lombok.*;
import org.hibernate.annotations.Check;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Check(constraints = "policy_type IN ('PAID','CONDITIONAL_FREE','FREE')")
@Table(name = "delivery_policies")
public class DeliveryPolicy extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(name = "policy_type",nullable = false)
    private String policyType;
    //기본 배송료
    @Column(nullable = false)
    private int basicDeliveryFee;
    //배송료 무료 조건
    @Column(nullable = true)
    private int freeConditionAmount;
    //기본 배송비 정책인지
    @Column(name = "is_default",nullable = false)
    private boolean defaultPolicy;
    //삭제된 정책인지
    @Column(name = "is_deleted",nullable = false)
    private boolean deleted;

}
