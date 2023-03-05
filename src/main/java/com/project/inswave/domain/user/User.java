package com.project.inswave.domain.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@Entity
@NoArgsConstructor //파라미터가 없는 기본 생성자를 생성
@AllArgsConstructor //모든 필드 값을 파라미터로 받는 생성자를 만듦
//@RequiredArgsConstructor @RequiredArgsConstructor
@Table(name = "INS_USER")
public class User {

	@Id @GeneratedValue
	private long insIdx;
	private int insNum;
	private String insId;
	private String insPwd;
	private String insName;
	private String insCheck;
	public long getInsIdx() {
		return insIdx;
	}
	public void setInsIdx(long insIdx) {
		this.insIdx = insIdx;
	}
	public int getInsNum() {
		return insNum;
	}
	public void setInsNum(int insNum) {
		this.insNum = insNum;
	}
	public String getInsId() {
		return insId;
	}
	public void setInsId(String insId) {
		this.insId = insId;
	}
	public String getInsPwd() {
		return insPwd;
	}
	public void setInsPwd(String insPwd) {
		this.insPwd = insPwd;
	}
	public String getInsName() {
		return insName;
	}
	public void setInsName(String insName) {
		this.insName = insName;
	}
	public String getInsCheck() {
		return insCheck;
	}
	public void setInsCheck(String insCheck) {
		this.insCheck = insCheck;
	}
	
	
	
	
}
