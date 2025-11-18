package kr.kro.moonlightmoist.shopapi.order.domain;

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
@Table(name = "order_requests")
public class OrderRequest extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_product_id",nullable = false)
    private OrderProduct orderProduct;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RequestType requestType;
    @Column(nullable = false)
    private String reason;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RequestStatus requestStatus;
    @Column(nullable = true)
    private LocalDateTime processedAt;
}
