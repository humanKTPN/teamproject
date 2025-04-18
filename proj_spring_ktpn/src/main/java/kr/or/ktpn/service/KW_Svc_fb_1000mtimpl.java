package kr.or.ktpn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ktpn.dao.KW_DAO_fboard_1000mt;
import kr.or.ktpn.dto.KW_DTO_BR_1000MT;

@Service
public class KW_Svc_fb_1000mtimpl implements KW_Svc_fb_1000mt {

	@Autowired
	KW_DAO_fboard_1000mt mfb;
	
	@Override
	public List<KW_DTO_BR_1000MT> getfboardlist(){
		List list = mfb.selectFBoard();
		return list;
	}
}
