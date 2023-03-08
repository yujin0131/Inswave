package com.project.inswave.emp.vo;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import com.inswave.elfw.exception.ElException;
import com.inswave.elfw.annotation.ElDto;
import com.inswave.elfw.annotation.ElDtoField;
import com.inswave.elfw.annotation.ElVoField;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.inswave.elfw.log.AppLog;

@JsonFilter("elExcludeFilter")
@ElDto(FldYn = "Y", delimeterYn = "", logicalName = "사원 List정보")
public class EmpListVo extends com.project.inswave.cmmn.InswaveCommVO {
    private static final long serialVersionUID = 1L;

    private int _offset;

    public EmpListVo(){
        this._offset = 0;
    }

    public EmpListVo(int iOffset){
        this._offset = iOffset;
    }

    @ElDtoField(logicalName = "사원카운트", physicalName = "empCnt", type = "int", typeKind = "", fldYn = "Yes", delimeterYn = "", cryptoGbn = "", cryptoKind = "", length = 10, dotLen = 0, baseValue = "", desc = "")
    private int empCnt;

    @ElDtoField(logicalName = "사원List", physicalName = "empVoList", type = "", typeKind = "List", fldYn = "Yes", delimeterYn = "", cryptoGbn = "", cryptoKind = "", length = 0, dotLen = 0, baseValue = "empCnt", desc = "")
    private java.util.List<com.project.inswave.emp.vo.EmpVo> empVoList;

    @ElDtoField(logicalName = "부서정보", physicalName = "deptVoList", type = "", typeKind = "List", fldYn = "No", delimeterYn = "", cryptoGbn = "", cryptoKind = "", length = 0, dotLen = 0, baseValue = "", desc = "")
    private java.util.List<com.project.inswave.emp.vo.DeptVo> deptVoList;

    @ElDtoField(logicalName = "데모사원정보", physicalName = "empVo", type = "", typeKind = "Vo", fldYn = "No", delimeterYn = "", cryptoGbn = "", cryptoKind = "", length = 0, dotLen = 0, baseValue = "", desc = "")
    private com.project.inswave.emp.vo.EmpVo empVo;

    @ElVoField(physicalName = "empCnt")
    public int getEmpCnt(){
        return empVoList != null ? empVoList.size() : 0 ;
    }

    @ElVoField(physicalName = "empVoList")
    public java.util.List<com.project.inswave.emp.vo.EmpVo> getEmpVoList(){
        return empVoList;
    }

    @ElVoField(physicalName = "empVoList")
    public void setEmpVoList(java.util.List<com.project.inswave.emp.vo.EmpVo> empVoList){
        this.empVoList = empVoList;
    }

    @ElVoField(physicalName = "deptVoList")
    public java.util.List<com.project.inswave.emp.vo.DeptVo> getDeptVoList(){
        return deptVoList;
    }

    @ElVoField(physicalName = "deptVoList")
    public void setDeptVoList(java.util.List<com.project.inswave.emp.vo.DeptVo> deptVoList){
        this.deptVoList = deptVoList;
    }

    @ElVoField(physicalName = "empVo")
    public com.project.inswave.emp.vo.EmpVo getEmpVo(){
        return empVo;
    }

    @ElVoField(physicalName = "empVo")
    public void setEmpVo(com.project.inswave.emp.vo.EmpVo empVo){
        this.empVo = empVo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EmpListVo [");
        sb.append("empCnt").append("=").append(empCnt).append(",");
        sb.append("empVoList").append("=").append(empVoList).append(",");
        sb.append("deptVoList").append("=").append(deptVoList).append(",");
        sb.append("empVo").append("=").append(empVo);
        sb.append("]");
        return sb.toString();

    }

    public boolean isFixedLengthVo() {
        return true;
    }

    public byte[] marshalFld() throws IOException{
        return marshalFld( com.inswave.elfw.ElConfig.getFldEncode() ); 
    }

	public byte[] marshalFld(String encode) throws IOException{
    	ByteArrayOutputStream bout = new ByteArrayOutputStream();
        DataOutputStream out = null;
        try {
            out = new DataOutputStream(bout);
            out.write( com.inswave.elfw.util.TypeConversionUtil.intToBytes(this.empVoList==null ? 0 : this.empVoList.size() , 10) );
            for( int i=0 ; empVoList != null && i < empVoList.size() ; i++ ) {
                com.project.inswave.emp.vo.EmpVo vo = (com.project.inswave.emp.vo.EmpVo)empVoList.get(i);
                out.write( vo.marshalFld(encode) );
            }
        } catch (IOException e) {
                AppLog.error("marshalFld Error:["+ toString()+"]", e);
                throw e;
        } finally {
            try	{
                if (out != null) out.close();
           } catch (IOException ie) {
                AppLog.error("marshalFld out close Error", ie);
           }
            try	{
                if (bout != null) bout.close();
           } catch (IOException ie) {
                AppLog.error("marshalFld bout close Error", ie);
           }
        }
        return bout.toByteArray();
    }

    public void unMarshalFld( byte[] bytes ) throws ElException{
        unMarshalFld( bytes, com.inswave.elfw.ElConfig.getFldEncode() ); 
    }

    public void unMarshalFld( byte[] bytes , String encode) throws ElException{
        try{ 
             this.empCnt = com.inswave.elfw.util.TypeConversionUtil.bytesToInt( bytes, _offset, 10, encode );
             _offset += 10;

             {
                 java.util.List<com.project.inswave.emp.vo.EmpVo> alList = new java.util.ArrayList<com.project.inswave.emp.vo.EmpVo>();
                 for( int i=0 ; i < empCnt ; i++ ) {
                     com.project.inswave.emp.vo.EmpVo vo = new com.project.inswave.emp.vo.EmpVo(_offset);
                     vo.unMarshalFld( bytes , encode );
                     alList.add( vo );
                     _offset = vo.getOffset();
                 }
                 this.empVoList = alList;
             }

        }catch(ElException e) { 
            String errorLine = com.inswave.elfw.util.TypeConversionUtil.getTrimmedString( bytes, 0, bytes.length, encode );
            AppLog.error("unMarshalFld Error:["+ errorLine+"]", e);
            throw e;
        } 
    }

    public int getOffset(){
        return _offset;
    }

    @Override
    public void _xStreamEnc() {
        for( int i=0 ; empVoList != null && i < empVoList.size() ; i++ ) {
            com.project.inswave.emp.vo.EmpVo vo = (com.project.inswave.emp.vo.EmpVo)empVoList.get(i);
            vo._xStreamEnc();	 
        }
        for( int i=0 ; deptVoList != null && i < deptVoList.size() ; i++ ) {
            com.project.inswave.emp.vo.DeptVo vo = (com.project.inswave.emp.vo.DeptVo)deptVoList.get(i);
            vo._xStreamEnc();	 
        }
        if( this.empVo != null ) this.empVo._xStreamEnc();
    }


    @Override
    public void _xStreamDec() {
        for( int i=0 ; empVoList != null && i < empVoList.size() ; i++ ) {
            com.project.inswave.emp.vo.EmpVo vo = (com.project.inswave.emp.vo.EmpVo)empVoList.get(i);
            vo._xStreamDec();	 
        }
        for( int i=0 ; deptVoList != null && i < deptVoList.size() ; i++ ) {
            com.project.inswave.emp.vo.DeptVo vo = (com.project.inswave.emp.vo.DeptVo)deptVoList.get(i);
            vo._xStreamDec();	 
        }
        if( this.empVo != null ) this.empVo._xStreamDec();
    }


}
