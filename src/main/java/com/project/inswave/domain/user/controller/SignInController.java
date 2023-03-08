package com.project.inswave.domain.user.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.json.Json;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inswave.elfw.annotation.ElDescription;
import com.inswave.elfw.annotation.ElService;
import com.inswave.elfw.annotation.ElValidator;
import com.inswave.elfw.log.AppLog;
import com.project.inswave.domain.user.SignInService;
import com.project.inswave.domain.user.User;
import com.project.inswave.util.ApiUrlUtils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Controller //responseBody + controller
@ResponseBody
@Getter
@RequiredArgsConstructor
public class SignInController {

	@Resource(name="SignInService")
	private final SignInService signInService;
	
	@ElService(key = ApiUrlUtils.SIGNUP_NUM)    
	@RequestMapping(value = ApiUrlUtils.SIGNUP_NUM, method = RequestMethod.POST)
	@ElDescription(sub = "사번 중복 체크 화면", desc = "사번 중복 체크를 처리합니다.")
	@ElValidator(errUrl = "")    
	public JSONObject login(JSONObject jsonobj, HttpServletRequest request ) throws Exception {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("maria");		
//		EntityManager entityManager = emf.createEntityManager();	
//		EntityTransaction tx = entityManager.getTransaction();
//		tx.begin();
//		
//		try {
//			User user = new User();	
//			user = entityManager.find(User.class, userVO.getInsId());
//			
//			tx.commit();
//		
//		} catch (Exception e) {
//			tx.rollback();
//		
//		} finally {
//			
//			entityManager.close();
//		}
//		emf.close();
		
		AppLog.info("login_controller");
		
		BufferedReader input = new BufferedReader(new InputStreamReader(request.getInputStream()));
        StringBuilder builder = new StringBuilder();
        String buffer;
        while ((buffer = input.readLine()) != null) {
            if (builder.length() > 0) {
                builder.append("\n");
            }
            builder.append(buffer);
        }
		AppLog.info(builder.toString());
		
		AppLog.info("###################user select###################");
		//User user = signInService.getUserInfo();
		AppLog.info(jsonobj.toString());
		JSONObject json = new JSONObject();
		json.put("getInsPwd", "ssss");
		json.put("getInsName", "yujin");
		AppLog.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@here!!!!!!!!!!!!!!!!!!!!!!!!!!! : " + ResponseEntity.ok(json));
		AppLog.info("###########json type : " + json.getClass().getTypeName());
		AppLog.info("###########json value : " + json.getString("getInsPwd") + " / " + json.getString("getInsName"));
	    
		//return ResponseEntity.ok(item1);
		return json;
	}
}
