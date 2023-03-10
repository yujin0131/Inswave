package com.project.inswave.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
//@RequiredArgsConstructor @RequiredArgsConstructor
@Table(name = "INS_USER")
public class User {


	@Id @GeneratedValue
	private long insIdx;
	
	@Column(unique = true)
	private int insNum;
	
	@Column(unique = true)
	private String insId;
	
	@Column
	private String insPwd;
	
	@Column
	private String insName;
	
	@Column
	private int insCheck;


	public Long getInsIdx() {
        return this.insIdx;
    }
    
    public int getInsNum() {
        return this.insNum;
    }
    
    public String getInsId() {
        return this.insId;
    }
    
    public String getInsPwd() {
        return this.insPwd;
    }
    
    public String getInsName() {
        return this.insName;
    }

    public int insCheck() {
        return this.insCheck;
    }
	
	
}
