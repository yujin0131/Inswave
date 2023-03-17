package com.project.inswave.domain.user;

import javax.annotation.Resource;

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

	public boolean existsByInsNum(int insNum) {
		AppLog.info("#####################100413.service####################" + insNum);
		return signUpRepository.existsByInsNum(insNum);
	}
	
	public boolean existsByInsId(String insId) {
		AppLog.info("#####################100413.service####################" + insId);
		return signUpRepository.existsByInsId(insId);
	}
	
	public Long save(User user) {
		AppLog.info("#####################100413.service####################" + user.getInsName());
		return signUpRepository.save(user.builder()
					.insName(user.getInsName())
					.insNum(user.getInsNum())
					.insId(user.getInsId())
					.insPwd(user.getInsPwd()).build()).getInsIdx();
	}

}
