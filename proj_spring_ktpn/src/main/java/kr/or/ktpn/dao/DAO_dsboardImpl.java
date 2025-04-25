package kr.or.ktpn.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.ktpn.dto.MrInventoryDto;
import kr.or.ktpn.dto.ProductionDto;

@Repository
public class DAO_dsboardImpl implements DAO_dsboard {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<MrInventoryDto> selectMrList(MrInventoryDto dto) {
        List<MrInventoryDto> result = sqlSession.selectList("mapper.dsboard.selectMr", dto);
//        System.out.println("result : " + result);
        return result;
    }
	
    @Override
    public List<ProductionDto> selectProductionList(String productName) {
        Map<String,Object> params = new HashMap();
        params.put("productName", productName);
        return sqlSession.selectList("mapper.dsboard.selectProductionList", params);
    }
    
    @Override
    public List<ProductionDto> selectTodayWorkOrders(String today) {
    	System.out.println(sqlSession.selectList("mapper.dsboard.selectTodayWorkOrders",today));
        return sqlSession.selectList(
            "mapper.dsboard.selectTodayWorkOrders",
            today
        );
    }
}
