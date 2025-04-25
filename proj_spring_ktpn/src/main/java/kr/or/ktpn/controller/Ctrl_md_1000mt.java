package kr.or.ktpn.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.client.ResponseActions;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ktpn.dto.DTO_md_1000mt;
import kr.or.ktpn.service.Svc_md_1000mt;

 
@Controller
public class Ctrl_md_1000mt {
	
	@Autowired
	Svc_md_1000mt svcMd;
	
	@RequestMapping(value="/md", method = RequestMethod.GET)
	public String list(DTO_md_1000mt dto,
					   Model model,
					   HttpServletRequest req) {
		
		List<DTO_md_1000mt> list = svcMd.getMdList(dto);
//		System.out.println(map);
		
		model.addAttribute("list", list);
		
		return "masterdataManage_main_kwak.tiles";
	}
	
	@RequestMapping(value="/mdDetail", method = RequestMethod.GET)
	public String listDetail(DTO_md_1000mt dto,
			Model model,
			HttpServletRequest req) {
		
		List<DTO_md_1000mt> li = svcMd.getMdList(dto);
//		System.out.println(map);
		
		model.addAttribute("list", li);
		
		return "masterdataManage_select_kwak.tiles";
	}
	
	@RequestMapping(value="/mdAdd", method = RequestMethod.GET)
	public String listForm() {
		
		return "masterdataManage_add_kwak.tiles";
	}
	
	@RequestMapping(value="/mdAdd", method = RequestMethod.POST)
	public String joinMdPost(
			@RequestParam("file1") MultipartFile file1,
			DTO_md_1000mt dto, 
			HttpServletRequest req) throws IOException {
		
		
		 String uploadDir = "C:/temp/upload";
		 
		 if(!(file1.getOriginalFilename().isEmpty())) {
		  File dir = new File(uploadDir);
		  if (!dir.exists()) dir.mkdirs();
		  
		  

		
		  // 2) 원본 이름으로 저장하되, 충돌 방지를 위해 타임스탬프 추가
		  String original = file1.getOriginalFilename();
		  String savedName = System.currentTimeMillis() + "_" + original;
		  File dest = new File(dir, savedName);
		  file1.transferTo(dest);
		
		  // 3) DTO에 파일경로 세팅 (DB에 저장할 상대경로)
		  dto.setIMG_PATH_ADR(savedName);

		 }
		
		
		
		
		
		
		
	    // 전달받은 데이터를 출력 후 db입력
	    System.out.println("[POST] joinEmp empDTO : " + dto);
	    int count = svcMd.addMd(dto);
	    System.out.println("추가 결과 : " + count);
	    
	    return "redirect:/md";
	}
	
	
	@RequestMapping(value="/mdMod", method = RequestMethod.GET)
	public String mdMod(DTO_md_1000mt dto,
			Model model,
			HttpServletRequest req) {
		
		List<DTO_md_1000mt> li = svcMd.getMdList(dto);
		
		model.addAttribute("dt", li);
		
		return "masterdataManage_mod_kwak.tiles";
	}
	
	@RequestMapping(value="/mdMod", method = RequestMethod.POST)
	public String modMdPost(
			@RequestParam("file1") MultipartFile file1,
			HttpServletRequest req,
			DTO_md_1000mt dto) {
		System.out.println(file1.getOriginalFilename().isEmpty());
		if(!(file1.getOriginalFilename().isEmpty())) {
			
			String uploadDir = "C:/temp/upload";
			File dir = new File(uploadDir);
			if (!dir.exists()) dir.mkdirs();
			
			
			
			
			// 2) 원본 이름으로 저장하되, 충돌 방지를 위해 타임스탬프 추가
			String original = file1.getOriginalFilename();
			String savedName = System.currentTimeMillis() + "_" + original;
			File dest = new File(dir, savedName);
			try {
				file1.transferTo(dest);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// 3) DTO에 파일경로 세팅 (DB에 저장할 상대경로)
			
			dto.setIMG_PATH_ADR(savedName);
			
		} else {
			dto.setIMG_PATH_ADR(req.getParameter("oldImg"));
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	    // 전달받은 데이터를 출력 후 db입력
	    System.out.println("[POST] joinEmp empDTO : " + dto);
	    int count = svcMd.modMd(dto);
	    System.out.println("업데이트 결과 : " + count);
	    
	    return "redirect:/md";
	}
	
	@RequestMapping(value="/mdDel", method = RequestMethod.POST)
	public String DelMdPost(DTO_md_1000mt dto) {
	    // 전달받은 데이터를 출력 후 db입력
	    System.out.println("[POST] del : " + dto);
	    int count = svcMd.delMd(dto);
	    System.out.println("삭제 결과 : " + count);
	    
	    return "redirect:/md";
	}
	


	
}
