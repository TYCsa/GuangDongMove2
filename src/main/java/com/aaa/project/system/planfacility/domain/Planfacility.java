package com.aaa.project.system.planfacility.domain;

import com.aaa.project.system.networkresource.domain.Networkresource;
import com.aaa.project.system.plan.domain.Plan;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 计划_设备表 planfacility
 * 
 * @author teacherChen
 * @date 2019-08-02
 */
public class Planfacility extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 编号 */
	private Integer id;
	/** 设备编号 */
	private String facilityId;
	private Networkresource networkresource;
	/** 计划编号 */
	private Integer planId;
	private Plan plan;
	/** 状态(0正常,1异常) */
	private Integer status;
	/** 签到时间 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8:00")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date signTime;
	/** 计划时间 */
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8:00")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date planTime;
	/** 巡检员 */
	private String dutyMan;
	/** 图片路径 */
	private String url;

	public Networkresource getNetworkresource() {
		return networkresource;
	}

	public void setNetworkresource(Networkresource networkresource) {
		this.networkresource = networkresource;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setFacilityId(String facilityId)
	{
		this.facilityId = facilityId;
	}

	public String getFacilityId()
	{
		return facilityId;
	}
	public void setPlanId(Integer planId) 
	{
		this.planId = planId;
	}

	public Integer getPlanId() 
	{
		return planId;
	}
	public void setStatus(Integer status) 
	{
		this.status = status;
	}

	public Integer getStatus() 
	{
		return status;
	}
	public void setSignTime(Date signTime) 
	{
		this.signTime = signTime;
	}

	public Date getSignTime() 
	{
		return signTime;
	}
	public void setPlanTime(Date planTime) 
	{
		this.planTime = planTime;
	}

	public Date getPlanTime() 
	{
		return planTime;
	}
	public void setDutyMan(String dutyMan) 
	{
		this.dutyMan = dutyMan;
	}

	public String getDutyMan() 
	{
		return dutyMan;
	}
	public void setUrl(String url) 
	{
		this.url = url;
	}

	public String getUrl() 
	{
		return url;
	}


}
