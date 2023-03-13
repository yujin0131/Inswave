package com.project.inswave.domain.user.controller;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
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

		AppLog.info("###################login_controller insNum###################");
	
		JSONObject json = new JSONObject();
		int insNum = user.getInsNum();
		boolean exists = signUpService.existsByInsNum(insNum);
		AppLog.info("###########insNum : " + insNum + " exists : " + exists);
		
		if(exists){
			json.put("resCode", "fail"); // 이미 존재한 사원 resCode 추후 변경
			
		}else{
			json.put("resCode", "succ"); // 이미 존재한 사원 resCode 추후 변경
			json.put("insNum", insNum);
		}
		
		//return ResponseEntity.ok(item1);
		return json.toString();
	}
	
	@ElService(key = ApiUrlUtils.SIGNUP_ID)    
	@RequestMapping(value = ApiUrlUtils.SIGNUP_ID, method = RequestMethod.POST)
	@ElDescription(sub = "아이디 중복 체크 화면", desc = "아이디 중복 체크를 처리합니다.")
	@ElValidator(errUrl = "")    
	public String insId(User user) throws Exception {

		AppLog.info("###################login_controller insId###################");
	
		JSONObject json = new JSONObject();
		String insId = user.getInsId();
		boolean exists = signUpService.existsByInsId(insId);
		AppLog.info("###########insNum : " + insId + " exists : " + exists);
		
		if(exists){
			json.put("resCode", "fail"); // 이미 존재한 사원 resCode 추후 변경
			
		}else{
			json.put("resCode", "succ"); // 이미 존재한 사원 resCode 추후 변경
			json.put("insId", insId);
		}
		
		//return ResponseEntity.ok(item1);
		return json.toString();
	}
}
