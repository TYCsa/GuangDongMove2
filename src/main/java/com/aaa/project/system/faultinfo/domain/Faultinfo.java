package com.aaa.project.system.faultinfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;

/**
 * 隐患表 faultinfo
 * 
 * @author toneySong
 * @date 2019-08-07
 */
public class Faultinfo extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer id;
	/** 资源id号 */
	private String resId;
	/** 隐患发现者工号 */
	private String empno;
	/** 规范编号 */
	private String standardId;
	/** 严重程度 */
	private String severty;
	/** 问题描述 */
	private String problem;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setResId(String resId) 
	{
		this.resId = resId;
	}

	public String getResId() 
	{
		return resId;
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
	public void setSeverty(String severty) 
	{
		this.severty = severty;
	}

	public String getSeverty() 
	{
		return severty;
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
            .append("id", getId())
            .append("resId", getResId())
            .append("empno", getEmpno())
            .append("standardId", getStandardId())
            .append("severty", getSeverty())
            .append("problem", getProblem())
            .toString();
    }
}
