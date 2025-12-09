package kr.kro.moonlightmoist.shopapi.pointHistory.service;

import kr.kro.moonlightmoist.shopapi.pointHistory.domain.PointHistory;

import java.util.List;

public interface PointExpireService {
    List<PointHistory> getExpiredPoints();
    int expirePoints();
}
