package com.project.inswave.domain.tech.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inswave.elfw.annotation.ElDescription;
import com.inswave.elfw.annotation.ElService;
import com.inswave.elfw.annotation.ElValidator;
import com.inswave.elfw.login.LoginInfo;
import com.inswave.elfw.login.LoginProcessor;

@Controller
public class MainController {

	@ElService(key = "main")    
	@RequestMapping(value = "main")   
	@ElDescription(sub = "메인화면", desc = "메인화면을 처리합니다.")
	@ElValidator(errUrl = "")           
	public void main(HttpServletRequest request ) throws Exception {

	}
}
