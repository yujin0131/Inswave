package com.project.inswave.domain.user.controller;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inswave.elfw.annotation.ElDescription;
import com.inswave.elfw.annotation.ElService;
import com.inswave.elfw.annotation.ElValidator;
import com.inswave.elfw.log.AppLog;
import com.project.inswave.domain.user.SignUpService;
import com.project.inswave.domain.user.User;
import com.project.inswave.util.ApiUrlUtils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Controller //responseBody + controller
@ResponseBody
@Getter
@RequiredArgsConstructor
public class SignUpController {

	@Resource(name="SignUpService")
	private final SignUpService signUpService;
	
	@ElService(key = ApiUrlUtils.SIGNUP_NUM)    
	@RequestMapping(value = ApiUrlUtils.SIGNUP_NUM, method = RequestMethod.POST)
	@ElDescription(sub = "사번 중복 체크 화면", desc = "사번 중복 체크를 처리합니다.")
	@ElValidator(errUrl = "")    
	public String insNum(User user) throws Exception {
		
		int insNum = user.getInsNum();
		//return ResponseEntity.ok(item1);
		return signUpService.existsByInsNum(insNum);
	}
	
	@ElService(key = ApiUrlUtils.SIGNUP_ID)    
	@RequestMapping(value = ApiUrlUtils.SIGNUP_ID, method = RequestMethod.POST)
	@ElDescription(sub = "아이디 중복 체크 화면", desc = "아이디 중복 체크를 처리합니다.")
	@ElValidator(errUrl = "")    
	public String insId(User user) throws Exception {

		String insId = user.getInsId();
		return signUpService.existsByInsId(insId);
	}
	
	@ElService(key = ApiUrlUtils.SIGNUP_REQ)    
	@RequestMapping(value = ApiUrlUtils.SIGNUP_REQ, method = RequestMethod.POST)
	@ElDescription(sub = "회원가입 화면", desc = "입력된 정보들로 회원가입을 진행합니다.")
	@ElValidator(errUrl = "")    
	public String signReq(User User) throws Exception {
		
		//return ResponseEntity.ok(item1);
		return signUpService.save(User);
	}
}
