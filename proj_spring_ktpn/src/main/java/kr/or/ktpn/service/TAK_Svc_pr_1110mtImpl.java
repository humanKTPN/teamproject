package kr.or.ktpn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ktpn.dao.TAK_PR_1110MTDAO;
import kr.or.ktpn.dto.TAK_PR_1100MTDTO;
import kr.or.ktpn.dto.TAK_PR_1110MTDTO;
//테스트
@Service
public class TAK_Svc_pr_1110mtImpl implements TAK_Svc_pr_1110mt {

	@Autowired 
	TAK_PR_1110MTDAO tb_pr_1110MTDAO;
	
	@Override
	public List selectDAO() {
		List PR_1110MTSVC = tb_pr_1110MTDAO.selectDTO();
		System.out.println("PR_1110MTSVC : "+PR_1110MTSVC);
		return PR_1110MTSVC;
	}

//	insert
	@Override
	public int insertDAO(TAK_PR_1110MTDTO dto) {
		int PR_1100MTSVC_insert = tb_pr_1110MTDAO.insertDTO(dto);
		System.out.println("PR_1100MTSVC_insert : "+PR_1100MTSVC_insert);
		return PR_1100MTSVC_insert;
	}
	
//	pr_popup 수정
	@Override
	public int updateDAO(TAK_PR_1110MTDTO dto) {
		int PR_1100MTSVC_update = tb_pr_1110MTDAO.updateDTO(dto);
		System.out.println("PR_1100MTSVC_update : "+PR_1100MTSVC_update);
		return PR_1100MTSVC_update;
	}
//	pr_popup 완료
	@Override
	public int completeDAO(TAK_PR_1110MTDTO dto) {
		int PR_1100MTSVC_update = tb_pr_1110MTDAO.completeDTO(dto);
		System.out.println("PR_1100MTSVC_update : "+PR_1100MTSVC_update);
		return PR_1100MTSVC_update;
	}
	
	@Override
    public List<TAK_PR_1110MTDTO> searchByDateRange(TAK_PR_1110MTDTO dto) {
        return tb_pr_1110MTDAO.findByDateRange(dto);
    }
}

