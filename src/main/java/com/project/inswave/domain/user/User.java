package com.project.inswave.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFilter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@JsonFilter("elExcludeFilter")
@Entity(name="User")
@NoArgsConstructor //파라미터가 없는 기본 생성자를 생성
@AllArgsConstructor //모든 필드 값을 파라미터로 받는 생성자를 만듦
//@RequiredArgsConstructor
@Table(name = "INS_USER")
public class User {


	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long insIdx;
	
	@Column(unique = true)
	private int insNum;
	
	@Column
	private String insName;
	
	@Column(unique = true)
	private String insId;
	
	@Column
	private String insPwd;


	
	
}
