package com.project.inswave.emp.vo;

import com.inswave.elfw.annotation.ElDto;
import com.inswave.elfw.annotation.ElDtoField;
import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("elExcludeFilter")
@ElDto(FldYn = "", logicalName = "부서List정보")
public class DeptListVo extends com.project.inswave.cmmn.InswaveCommVO {
	private static final long serialVersionUID = 1L;
	
    @ElDtoField(logicalName = "부서List", physicalName = "deptVoList", type = "", typeKind = "List", fldYn = "", length = 0, dotLen = 0, baseValue = "", desc = "")
    private java.util.List<com.project.inswave.emp.vo.DeptVo> deptVoList;


    public java.util.List<com.project.inswave.emp.vo.DeptVo> getDeptVoList(){
        return deptVoList;
    }

    public void setDeptVoList(java.util.List<com.project.inswave.emp.vo.DeptVo> deptVoList){
        this.deptVoList = deptVoList;
    }

  
    @Override
    public String toString() {
        return "DeptListVo [deptVoList=" + deptVoList + "]";
    }

    public boolean isFixedLengthVo() {
        return false;
    }

}
