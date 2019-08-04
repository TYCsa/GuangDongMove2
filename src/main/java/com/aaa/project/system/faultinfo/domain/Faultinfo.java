package com.aaa.project.system.faultinfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 隐患表 faultinfo
 * 
 * @author toneySong
 * @date 2019-08-03
 */
public class Faultinfo extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 隐患编号 */
	private Integer faultId;
	/** 资源id号 */
	private String resId;
	/** 隐患发现时间 */
	private Date faultTime;
	/** 隐患发现者工号 */
	private String empno;
	/** 规范编号 */
	private String standardId;
	/** 发现地址 */
	private String address;
	/** 严重程度 */
	private String severity;
	/** 图片 */
	private String picture;
	/** 问题描述 */
	private String problem;

	public void setFaultId(Integer faultId) 
	{
		this.faultId = faultId;
	}

	public Integer getFaultId() 
	{
		return faultId;
	}
	public void setResId(String resId) 
	{
		this.resId = resId;
	}

	public String getResId() 
	{
		return resId;
	}
	public void setFaultTime(Date faultTime) 
	{
		this.faultTime = faultTime;
	}

	public Date getFaultTime() 
	{
		return faultTime;
	}
	public void setEmpno(String empno) 
	{
		this.empno = empno;
	}

	public String getEmpno() 
	{
		return empno;
	}
	public void setStandardId(String standardId) 
	{
		this.standardId = standardId;
	}

	public String getStandardId() 
	{
		return standardId;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}

	public String getAddress() 
	{
		return address;
	}
	public void setSeverity(String severity) 
	{
		this.severity = severity;
	}

	public String getSeverity() 
	{
		return severity;
	}
	public void setPicture(String picture) 
	{
		this.picture = picture;
	}

	public String getPicture() 
	{
		return picture;
	}
	public void setProblem(String problem) 
	{
		this.problem = problem;
	}

	public String getProblem() 
	{
		return problem;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("faultId", getFaultId())
            .append("resId", getResId())
            .append("faultTime", getFaultTime())
            .append("empno", getEmpno())
            .append("standardId", getStandardId())
            .append("address", getAddress())
            .append("severity", getSeverity())
            .append("picture", getPicture())
            .append("problem", getProblem())
            .toString();
    }
}
