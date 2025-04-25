package kr.or.ktpn.service;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ktpn.dao.DAO_dsboard;
import kr.or.ktpn.dto.MrInventoryDto;
import kr.or.ktpn.dto.ProductionDto;

@Service
public class Svc_dsboardImpl implements Svc_dsboard{
	
	@Autowired
	DAO_dsboard mdDAO;
	
	@Override
	public List<MrInventoryDto> getMrList(MrInventoryDto dto) {
		// TODO Auto-generated method stub
		 List<MrInventoryDto> list = mdDAO.selectMrList(dto);
	        return list;

	}
    @Override
    public List<ProductionDto> getProductionList(String productName) {
        // productName이 null·빈 문자열이면 전체, 그렇지 않으면 해당 제품만 필터
        return mdDAO.selectProductionList(productName);
    }
    
    
    @Override
    public List<ProductionDto> getTodayWorkOrders() {
        // 오늘 날짜(YYYYMMDD)로 DAO에 넘겨 주면,
        // "TB_PR_1000MT" 같은 테이블에서 필터링해서 가져오는 식으로 구현
        String today = new SimpleDateFormat("yyyyMMdd").format(new Date());
        System.out.println(today);
        return mdDAO.selectTodayWorkOrders(today);
    }

}
