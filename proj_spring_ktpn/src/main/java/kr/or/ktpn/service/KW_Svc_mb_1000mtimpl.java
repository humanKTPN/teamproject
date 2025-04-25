package kr.or.ktpn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ktpn.dao.KW_DAO_mb_1000mt;
import kr.or.ktpn.dto.KW_DTO_MB_1000MT;

@Service
public class KW_Svc_mb_1000mtimpl implements KW_Svc_mb_1000mt {

	@Autowired
	KW_DAO_mb_1000mt mb;
	
	@Override
	public List<KW_DTO_MB_1000MT> getMemberlist() {
		List list = mb.selectMember();
		return list;
	}
	
	@Override
	public KW_DTO_MB_1000MT getMemberId(String id) {
		KW_DTO_MB_1000MT result = mb.selectMemberId(id);
		return result;
	}
	
	@Override
	public int updateMember(KW_DTO_MB_1000MT dto) {
		int cn = mb.update(dto);
		return cn;
	}
	
	@Override
	public int delete(String id) {
        return mb.delete(id);
    }

	
	
	
	// 작업자(일반회원) 가져오는 메소드
	@Override
	public List getWorker() {
		// TODO Auto-generated method stub
			
		System.out.println("service member");
		List list = mb.selectWorker();
		System.out.println("all Worker : " + list);
			
		return list;
	}
}
