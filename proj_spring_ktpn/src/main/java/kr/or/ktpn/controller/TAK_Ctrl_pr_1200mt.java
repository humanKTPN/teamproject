package kr.or.ktpn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ktpn.dto.TAK_PR_1100MTDTO;
import kr.or.ktpn.dto.TAK_PR_1110MTDTO;
import kr.or.ktpn.service.TAK_Svc_pr_1100mt;
import kr.or.ktpn.service.TAK_Svc_pr_1110mt;
import kr.or.ktpn.service.TAK_Svc_pr_1200mt;

@Controller
public class TAK_Ctrl_pr_1200mt {

	@Autowired
	TAK_Svc_pr_1200mt svc_pr_1200mt;

	
	@RequestMapping(value="/tb_pr_mt2", method = RequestMethod.GET)
	public String viewPr_1200mt(Model model) {
		
//		List<TAK_PR_1100MTDTO> selectDayList = svc_pr_1200mt.selectDayDAO();
		
		//가동현황 데이터
		List selectNY = svc_pr_1200mt.selectNYDAO();
		System.out.println("selectNY : " + selectNY);
		
		//원형 그래프 데이터
		TAK_PR_1100MTDTO selectSS = svc_pr_1200mt.selectSSDAO();
		TAK_PR_1100MTDTO selectSS_IQ = svc_pr_1200mt.selectSS_IQDAO();
		TAK_PR_1100MTDTO selectSS_DR = svc_pr_1200mt.selectSS_DRDAO();

		
		//품목별 그래프 데이터
		TAK_PR_1100MTDTO selectSSG = svc_pr_1200mt.selectSSGDAO();
		TAK_PR_1100MTDTO selectSSG_week = svc_pr_1200mt.selectSSG_weekDAO();
		TAK_PR_1100MTDTO selectSSG_month = svc_pr_1200mt.selectSSG_monthDAO();
		TAK_PR_1100MTDTO selectHH = svc_pr_1200mt.selectHHDAO();
		TAK_PR_1100MTDTO selectHH_week = svc_pr_1200mt.selectHH_weekDAO();
		TAK_PR_1100MTDTO selectHH_month = svc_pr_1200mt.selectHH_monthDAO();
		
		
		//라인별 호기 금일 셀렉
		TAK_PR_1100MTDTO selectLineA1 = svc_pr_1200mt.selectLineA1DAO();
		TAK_PR_1100MTDTO selectLineA2 = svc_pr_1200mt.selectLineA2DAO();
		TAK_PR_1100MTDTO selectLineA3 = svc_pr_1200mt.selectLineA3DAO();
		TAK_PR_1100MTDTO selectLineB1 = svc_pr_1200mt.selectLineB1DAO();
		TAK_PR_1100MTDTO selectLineB2 = svc_pr_1200mt.selectLineB2DAO();
		TAK_PR_1100MTDTO selectLineB3 = svc_pr_1200mt.selectLineB3DAO();
		TAK_PR_1100MTDTO selectLineC1 = svc_pr_1200mt.selectLineC1DAO();
		TAK_PR_1100MTDTO selectLineC2 = svc_pr_1200mt.selectLineC2DAO();
		TAK_PR_1100MTDTO selectLineC3 = svc_pr_1200mt.selectLineC3DAO();
		
		
		//라인별 호기 금주 셀렉
		TAK_PR_1100MTDTO selectLineA1_week = svc_pr_1200mt.selectLineA1_weekDAO();
		TAK_PR_1100MTDTO selectLineA2_week = svc_pr_1200mt.selectLineA2_weekDAO();
		TAK_PR_1100MTDTO selectLineA3_week = svc_pr_1200mt.selectLineA3_weekDAO();
		TAK_PR_1100MTDTO selectLineB1_week = svc_pr_1200mt.selectLineB1_weekDAO();
		TAK_PR_1100MTDTO selectLineB2_week = svc_pr_1200mt.selectLineB2_weekDAO();
		TAK_PR_1100MTDTO selectLineB3_week = svc_pr_1200mt.selectLineB3_weekDAO();
		TAK_PR_1100MTDTO selectLineC1_week = svc_pr_1200mt.selectLineC1_weekDAO();
		TAK_PR_1100MTDTO selectLineC2_week = svc_pr_1200mt.selectLineC2_weekDAO();
		TAK_PR_1100MTDTO selectLineC3_week = svc_pr_1200mt.selectLineC3_weekDAO();

		
		//라인별 호기 금월 셀렉
		TAK_PR_1100MTDTO selectLineA1_month = svc_pr_1200mt.selectLineA1_monthDAO();
		TAK_PR_1100MTDTO selectLineA2_month = svc_pr_1200mt.selectLineA2_monthDAO();
		TAK_PR_1100MTDTO selectLineA3_month = svc_pr_1200mt.selectLineA3_monthDAO();
		TAK_PR_1100MTDTO selectLineB1_month = svc_pr_1200mt.selectLineB1_monthDAO();
		TAK_PR_1100MTDTO selectLineB2_month = svc_pr_1200mt.selectLineB2_monthDAO();
		TAK_PR_1100MTDTO selectLineB3_month = svc_pr_1200mt.selectLineB3_monthDAO();
		TAK_PR_1100MTDTO selectLineC1_month = svc_pr_1200mt.selectLineC1_monthDAO();
		TAK_PR_1100MTDTO selectLineC2_month = svc_pr_1200mt.selectLineC2_monthDAO();
		TAK_PR_1100MTDTO selectLineC3_month = svc_pr_1200mt.selectLineC3_monthDAO();

		//라인별 호기 금월 불량률 셀렉
		TAK_PR_1100MTDTO selectLineA1_month_DR = svc_pr_1200mt.selectLineA1_month_DRDAO();
		TAK_PR_1100MTDTO selectLineA2_month_DR = svc_pr_1200mt.selectLineA2_month_DRDAO();
		TAK_PR_1100MTDTO selectLineA3_month_DR = svc_pr_1200mt.selectLineA3_month_DRDAO();
		TAK_PR_1100MTDTO selectLineB1_month_DR = svc_pr_1200mt.selectLineB1_month_DRDAO();
		TAK_PR_1100MTDTO selectLineB2_month_DR = svc_pr_1200mt.selectLineB2_month_DRDAO();
		TAK_PR_1100MTDTO selectLineB3_month_DR = svc_pr_1200mt.selectLineB3_month_DRDAO();
		TAK_PR_1100MTDTO selectLineC1_month_DR = svc_pr_1200mt.selectLineC1_month_DRDAO();
		TAK_PR_1100MTDTO selectLineC2_month_DR = svc_pr_1200mt.selectLineC2_month_DRDAO();
		TAK_PR_1100MTDTO selectLineC3_month_DR = svc_pr_1200mt.selectLineC3_month_DRDAO();
		
		
		
		
//		model.addAttribute("pr_1200mt", selectDayList);
		
		//가동현황 데이터
		model.addAttribute("selectNY", selectNY);
		
		
		//원형 그래프 데이터
		model.addAttribute("selectSS", selectSS);
		model.addAttribute("selectSS_IQ", selectSS_IQ);
		model.addAttribute("selectSS_DR", selectSS_DR);
		
		//품목별 그래프 데이터
		model.addAttribute("selectSSG", selectSSG);
		model.addAttribute("selectSSG_week", selectSSG_week);
		model.addAttribute("selectSSG_month", selectSSG_month);
		model.addAttribute("selectHH", selectHH);
		model.addAttribute("selectHH_week", selectHH_week);
		model.addAttribute("selectHH_month", selectHH_month);
		
		
		//라인별 호기 금일 셀렉
		model.addAttribute("LineA1", selectLineA1);
		model.addAttribute("LineA2", selectLineA2);
		model.addAttribute("LineA3", selectLineA3);
		model.addAttribute("LineB1", selectLineB1);
		model.addAttribute("LineB2", selectLineB2);
		model.addAttribute("LineB3", selectLineB3);
		model.addAttribute("LineC1", selectLineC1);
		model.addAttribute("LineC2", selectLineC2);
		model.addAttribute("LineC3", selectLineC3);

		//라인별 호기 금주 셀렉
		model.addAttribute("LineA1_week", selectLineA1_week);
		model.addAttribute("LineA2_week", selectLineA2_week);
		model.addAttribute("LineA3_week", selectLineA3_week);
		model.addAttribute("LineB1_week", selectLineB1_week);
		model.addAttribute("LineB2_week", selectLineB2_week);
		model.addAttribute("LineB3_week", selectLineB3_week);
		model.addAttribute("LineC1_week", selectLineC1_week);
		model.addAttribute("LineC2_week", selectLineC2_week);
		model.addAttribute("LineC3_week", selectLineC3_week);

		//라인별 호기 금월 셀렉
		model.addAttribute("LineA1_month", selectLineA1_month);
		model.addAttribute("LineA2_month", selectLineA2_month);
		model.addAttribute("LineA3_month", selectLineA3_month);
		model.addAttribute("LineB1_month", selectLineB1_month);
		model.addAttribute("LineB2_month", selectLineB2_month);
		model.addAttribute("LineB3_month", selectLineB3_month);
		model.addAttribute("LineC1_month", selectLineC1_month);
		model.addAttribute("LineC2_month", selectLineC2_month);
		model.addAttribute("LineC3_month", selectLineC3_month);

		//라인별 호기 금월 불량률 셀렉
		model.addAttribute("LineA1_month_DR", selectLineA1_month_DR);
		model.addAttribute("LineA2_month_DR", selectLineA2_month_DR);
		model.addAttribute("LineA3_month_DR", selectLineA3_month_DR);
		model.addAttribute("LineB1_month_DR", selectLineB1_month_DR);
		model.addAttribute("LineB2_month_DR", selectLineB2_month_DR);
		model.addAttribute("LineB3_month_DR", selectLineB3_month_DR);
		model.addAttribute("LineC1_month_DR", selectLineC1_month_DR);
		model.addAttribute("LineC2_month_DR", selectLineC2_month_DR);
		model.addAttribute("LineC3_month_DR", selectLineC3_month_DR);
		
		//		System.out.println("selectDayList : "+selectDayList);
		
		return "Production reporting_tak.tiles";
	}
	
	
}
