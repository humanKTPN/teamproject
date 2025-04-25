package kr.or.ktpn.service;

import java.util.List;

import kr.or.ktpn.dto.MrInventoryDto;
import kr.or.ktpn.dto.ProductionDto;

public interface Svc_dsboard {
	public List<MrInventoryDto> getMrList(MrInventoryDto dto);
	public List<ProductionDto> getProductionList(String productName);
	public List<ProductionDto> getTodayWorkOrders();
}
