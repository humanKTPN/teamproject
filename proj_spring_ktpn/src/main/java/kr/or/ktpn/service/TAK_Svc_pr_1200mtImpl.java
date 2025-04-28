package kr.or.ktpn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ktpn.dao.TAK_PR_1110MTDAO;
import kr.or.ktpn.dao.TAK_PR_1200MTDAO;
import kr.or.ktpn.dto.TAK_PR_1100MTDTO;
import kr.or.ktpn.dto.TAK_PR_1110MTDTO;

@Service
public class TAK_Svc_pr_1200mtImpl implements TAK_Svc_pr_1200mt {

	@Autowired
	TAK_PR_1200MTDAO tb_pr_1200MTDAO;
	
//	@Override
//	public List selectDayDAO() {
//		List PR_1200MTSVC = tb_pr_1200MTDAO.selectDayDTO();
//		System.out.println("PR_1200MTSVC : "+PR_1200MTSVC);
//		return PR_1200MTSVC;
//	}

	//라인별호기 금일 셀렉
	@Override
	public TAK_PR_1100MTDTO selectLineA1DAO() {
		TAK_PR_1100MTDTO PR_1200MTSVC = tb_pr_1200MTDAO.selectLineA1DTO();
		System.out.println("PR_1200MTSVC : "+PR_1200MTSVC);
		return PR_1200MTSVC;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineA2DAO() {
		TAK_PR_1100MTDTO PR_1200MTSVC = tb_pr_1200MTDAO.selectLineA2DTO();
		System.out.println("PR_1200MTSVC : "+PR_1200MTSVC);
		return PR_1200MTSVC;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineA3DAO() {
		TAK_PR_1100MTDTO PR_1200MTSVC = tb_pr_1200MTDAO.selectLineA3DTO();
		System.out.println("PR_1200MTSVC : "+PR_1200MTSVC);
		return PR_1200MTSVC;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineB1DAO() {
		TAK_PR_1100MTDTO PR_1200MTSVC = tb_pr_1200MTDAO.selectLineB1DTO();
		System.out.println("PR_1200MTSVC : "+PR_1200MTSVC);
		return PR_1200MTSVC;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineB2DAO() {
		TAK_PR_1100MTDTO PR_1200MTSVC = tb_pr_1200MTDAO.selectLineB2DTO();
		System.out.println("PR_1200MTSVC : "+PR_1200MTSVC);
		return PR_1200MTSVC;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineB3DAO() {
		TAK_PR_1100MTDTO PR_1200MTSVC = tb_pr_1200MTDAO.selectLineB3DTO();
		System.out.println("PR_1200MTSVC : "+PR_1200MTSVC);
		return PR_1200MTSVC;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineC1DAO() {
		TAK_PR_1100MTDTO PR_1200MTSVC = tb_pr_1200MTDAO.selectLineC1DTO();
		System.out.println("PR_1200MTSVC : "+PR_1200MTSVC);
		return PR_1200MTSVC;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineC2DAO() {
		TAK_PR_1100MTDTO PR_1200MTSVC = tb_pr_1200MTDAO.selectLineC2DTO();
		System.out.println("PR_1200MTSVC : "+PR_1200MTSVC);
		return PR_1200MTSVC;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineC3DAO() {
		TAK_PR_1100MTDTO PR_1200MTSVC = tb_pr_1200MTDAO.selectLineC3DTO();
		System.out.println("PR_1200MTSVC : "+PR_1200MTSVC);
		return PR_1200MTSVC;
	}

	//라인별호기 금주 셀렉
	@Override
	public TAK_PR_1100MTDTO selectLineA1_weekDAO() {
		TAK_PR_1100MTDTO PR_1200MTSVC = tb_pr_1200MTDAO.selectLineA1_weekDTO();
		System.out.println("PR_1200MTSVC_week : "+PR_1200MTSVC);
		return PR_1200MTSVC;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineA2_weekDAO() {
		TAK_PR_1100MTDTO PR_1200MTSVC = tb_pr_1200MTDAO.selectLineA2_weekDTO();
		System.out.println("PR_1200MTSVC_week : "+PR_1200MTSVC);
		return PR_1200MTSVC;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineA3_weekDAO() {
		TAK_PR_1100MTDTO PR_1200MTSVC = tb_pr_1200MTDAO.selectLineA3_weekDTO();
		System.out.println("PR_1200MTSVC_week : "+PR_1200MTSVC);
		return PR_1200MTSVC;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineB1_weekDAO() {
		TAK_PR_1100MTDTO PR_1200MTSVC = tb_pr_1200MTDAO.selectLineB1_weekDTO();
		System.out.println("PR_1200MTSVC_week : "+PR_1200MTSVC);
		return PR_1200MTSVC;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineB2_weekDAO() {
		TAK_PR_1100MTDTO PR_1200MTSVC = tb_pr_1200MTDAO.selectLineB2_weekDTO();
		System.out.println("PR_1200MTSVC_week : "+PR_1200MTSVC);
		return PR_1200MTSVC;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineB3_weekDAO() {
		TAK_PR_1100MTDTO PR_1200MTSVC = tb_pr_1200MTDAO.selectLineB3_weekDTO();
		System.out.println("PR_1200MTSVC_week : "+PR_1200MTSVC);
		return PR_1200MTSVC;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineC1_weekDAO() {
		TAK_PR_1100MTDTO PR_1200MTSVC = tb_pr_1200MTDAO.selectLineC1_weekDTO();
		System.out.println("PR_1200MTSVC_week : "+PR_1200MTSVC);
		return PR_1200MTSVC;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineC2_weekDAO() {
		TAK_PR_1100MTDTO PR_1200MTSVC = tb_pr_1200MTDAO.selectLineC2_weekDTO();
		System.out.println("PR_1200MTSVC_week : "+PR_1200MTSVC);
		return PR_1200MTSVC;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineC3_weekDAO() {
		TAK_PR_1100MTDTO PR_1200MTSVC = tb_pr_1200MTDAO.selectLineC3_weekDTO();
		System.out.println("PR_1200MTSVC_week : "+PR_1200MTSVC);
		return PR_1200MTSVC;
	}

	
	//라인별호기 금월 셀렉
	@Override
	public TAK_PR_1100MTDTO selectLineA1_monthDAO() {
		TAK_PR_1100MTDTO PR_1200MTSVC = tb_pr_1200MTDAO.selectLineA1_monthDTO();
		System.out.println("PR_1200MTSVC_month : "+PR_1200MTSVC);
		return PR_1200MTSVC;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineA2_monthDAO() {
		TAK_PR_1100MTDTO PR_1200MTSVC = tb_pr_1200MTDAO.selectLineA2_monthDTO();
		System.out.println("PR_1200MTSVC_month : "+PR_1200MTSVC);
		return PR_1200MTSVC;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineA3_monthDAO() {
		TAK_PR_1100MTDTO PR_1200MTSVC = tb_pr_1200MTDAO.selectLineA3_monthDTO();
		System.out.println("PR_1200MTSVC_month : "+PR_1200MTSVC);
		return PR_1200MTSVC;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineB1_monthDAO() {
		TAK_PR_1100MTDTO PR_1200MTSVC = tb_pr_1200MTDAO.selectLineB1_monthDTO();
		System.out.println("PR_1200MTSVC_month : "+PR_1200MTSVC);
		return PR_1200MTSVC;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineB2_monthDAO() {
		TAK_PR_1100MTDTO PR_1200MTSVC = tb_pr_1200MTDAO.selectLineB2_monthDTO();
		System.out.println("PR_1200MTSVC_month : "+PR_1200MTSVC);
		return PR_1200MTSVC;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineB3_monthDAO() {
		TAK_PR_1100MTDTO PR_1200MTSVC = tb_pr_1200MTDAO.selectLineB3_monthDTO();
		System.out.println("PR_1200MTSVC_month : "+PR_1200MTSVC);
		return PR_1200MTSVC;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineC1_monthDAO() {
		TAK_PR_1100MTDTO PR_1200MTSVC = tb_pr_1200MTDAO.selectLineC1_monthDTO();
		System.out.println("PR_1200MTSVC_month : "+PR_1200MTSVC);
		return PR_1200MTSVC;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineC2_monthDAO() {
		TAK_PR_1100MTDTO PR_1200MTSVC = tb_pr_1200MTDAO.selectLineC2_weekDTO();
		System.out.println("PR_1200MTSVC_week : "+PR_1200MTSVC);
		return PR_1200MTSVC;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineC3_monthDAO() {
		TAK_PR_1100MTDTO PR_1200MTSVC = tb_pr_1200MTDAO.selectLineC3_monthDTO();
		System.out.println("PR_1200MTSVC_month : "+PR_1200MTSVC);
		return PR_1200MTSVC;
	}

	//라인별호기 금월 불량률 셀렉
	@Override
	public TAK_PR_1100MTDTO selectLineA1_month_DRDAO() {
		TAK_PR_1100MTDTO PR_1200MTSVC = tb_pr_1200MTDAO.selectLineA1_month_DRDTO();
		System.out.println("PR_1200MTSVC_month_DR : "+PR_1200MTSVC);
		return PR_1200MTSVC;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineA2_month_DRDAO() {
		TAK_PR_1100MTDTO PR_1200MTSVC = tb_pr_1200MTDAO.selectLineA2_month_DRDTO();
		System.out.println("PR_1200MTSVC_month_DR : "+PR_1200MTSVC);
		return PR_1200MTSVC;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineA3_month_DRDAO() {
		TAK_PR_1100MTDTO PR_1200MTSVC = tb_pr_1200MTDAO.selectLineA3_month_DRDTO();
		System.out.println("PR_1200MTSVC_month_DR : "+PR_1200MTSVC);
		return PR_1200MTSVC;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineB1_month_DRDAO() {
		TAK_PR_1100MTDTO PR_1200MTSVC = tb_pr_1200MTDAO.selectLineB1_month_DRDTO();
		System.out.println("PR_1200MTSVC_month_DR : "+PR_1200MTSVC);
		return PR_1200MTSVC;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineB2_month_DRDAO() {
		TAK_PR_1100MTDTO PR_1200MTSVC = tb_pr_1200MTDAO.selectLineB2_month_DRDTO();
		System.out.println("PR_1200MTSVC_month_DR : "+PR_1200MTSVC);
		return PR_1200MTSVC;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineB3_month_DRDAO() {
		TAK_PR_1100MTDTO PR_1200MTSVC = tb_pr_1200MTDAO.selectLineB3_month_DRDTO();
		System.out.println("PR_1200MTSVC_month_DR : "+PR_1200MTSVC);
		return PR_1200MTSVC;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineC1_month_DRDAO() {
		TAK_PR_1100MTDTO PR_1200MTSVC = tb_pr_1200MTDAO.selectLineC1_month_DRDTO();
		System.out.println("PR_1200MTSVC_month_DR : "+PR_1200MTSVC);
		return PR_1200MTSVC;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineC2_month_DRDAO() {
		TAK_PR_1100MTDTO PR_1200MTSVC = tb_pr_1200MTDAO.selectLineC2_month_DRDTO();
		System.out.println("PR_1200MTSVC_month_DR : "+PR_1200MTSVC);
		return PR_1200MTSVC;
	}
	@Override
	public TAK_PR_1100MTDTO selectLineC3_month_DRDAO() {
		TAK_PR_1100MTDTO PR_1200MTSVC = tb_pr_1200MTDAO.selectLineC3_month_DRDTO();
		System.out.println("PR_1200MTSVC_month_DR : "+PR_1200MTSVC);
		return PR_1200MTSVC;
	}
	

}

