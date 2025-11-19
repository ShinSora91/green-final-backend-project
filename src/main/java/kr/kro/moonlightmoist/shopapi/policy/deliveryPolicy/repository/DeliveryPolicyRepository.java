package kr.kro.moonlightmoist.shopapi.policy.deliveryPolicy.repository;

import kr.kro.moonlightmoist.shopapi.policy.deliveryPolicy.domain.DeliveryPolicy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryPolicyRepository extends JpaRepository<DeliveryPolicy,Long> {
}
