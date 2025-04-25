package kr.or.ktpn.dao;

import java.util.List;

import kr.or.ktpn.dto.MrInventoryDto;
import kr.or.ktpn.dto.ProductionDto;

public interface DAO_dsboard {
	public List<MrInventoryDto> selectMrList(MrInventoryDto dto);
	public List<ProductionDto> selectProductionList(String productName);
	public List<ProductionDto> selectTodayWorkOrders(String today);
}
