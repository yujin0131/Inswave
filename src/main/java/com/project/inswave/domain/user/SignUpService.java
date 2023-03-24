package com.project.inswave.domain.user;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import com.inswave.elfw.log.AppLog;
import com.project.inswave.util.exception.NotFoundException;

import lombok.RequiredArgsConstructor;

@Service(value="SignUpService")
@Configuration
@EnableJpaRepositories(basePackages = "com.project.inswave")
@RequiredArgsConstructor // final 필드에 대해 생성자 기본 생성
//@NoArgsConstructor
public class SignUpService {

	@Resource(name="SignUpRepository")
	private final SignUpRepository signUpRepository;

	public String existsByInsNum(int insNum) {
		
		JSONObject json = new JSONObject();
		boolean exists = signUpRepository.existsByInsNum(insNum);
		
		if(exists){
			json.put("resCode", "fail"); // 이미 존재한 사원 resCode 추후 변경
			
		}else{
			json.put("resCode", "succ"); // 이미 존재한 사원 resCode 추후 변경
			json.put("insNum", insNum);
		}
		
		return json.toString();
	}
	
	public String existsByInsId(String insId) {
		
		JSONObject json = new JSONObject();
		boolean exists = signUpRepository.existsByInsId(insId);
		
		if(exists){
			json.put("resCode", "fail"); // 이미 존재한 사원 resCode 추후 변경
			
		}else{
			json.put("resCode", "succ"); // 이미 존재한 사원 resCode 추후 변경
			json.put("insId", insId);
		}
		
		//return ResponseEntity.ok(item1);
		return json.toString();

	}
	
	public String save(User User) {
		AppLog.info("#####################100413.service####################" + User.getInsName());
		
		JSONObject json = new JSONObject();
		
		int insNum = User.getInsNum();
		String insName = User.getInsName();
		String insId = User.getInsId();
		String insPwd = User.getInsPwd();
		AppLog.info("insIdx : " + User.getInsIdx() + " insNum : " + insNum + " insName : " + insName  + " insId : " + insId + " insPwd : " + insPwd );
		
		User id = signUpRepository.save(User);
		
		AppLog.info("###########fin#############" + id.getInsName() + " idx : " + id.getInsIdx());
		
		return id.getInsName();
	}

}
