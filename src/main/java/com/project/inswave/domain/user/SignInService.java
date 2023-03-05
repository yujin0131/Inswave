package com.project.inswave.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.inswave.util.exception.NotFoundException;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // final 필드에 대해 생성자 기본 생성
//@NoArgsConstructor
public class SignInService {

	@Autowired
	private final SignInRepository signRepository;

	public User getUserInfo(int insNum) {
		return signRepository.findByInsnum(insNum).orElseThrow(() -> new NotFoundException("유저가 존재하지 않습니다."));
	}
}
