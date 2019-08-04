package com.aaa.project.system.plan.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 计划表 plan
 * 
 * @author teacherChen
 * @date 2019-08-02
 */
public class Plan extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 编号 */
	private Integer id;
	/** 名称 */
	private String name;
	/** 制定时间 */
	private String makeTime;
	/** 驻点编号 */
	private Integer stationaryPoint;
	/** 巡检数量 */
	private Integer checkCount;
	/** 状态(0未制定,1已制定,2审核中,3失败) */
	private Integer status;
	/** 类型(0制定,1模板) */
	private Integer type;
	/** 负责人 */
	private String dutyMan;
	/** 负责时间 */
	private Date dutyTime;
	/** 审核人 */
	private String checkMan;
	/** 审核时间 */
	private Date checkTime;
	/** 原因 */
	private String cause;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public void setMakeTime(String makeTime) 
	{
		this.makeTime = makeTime;
	}

	public String getMakeTime() 
	{
		return makeTime;
	}
	public void setStationaryPoint(Integer stationaryPoint) 
	{
		this.stationaryPoint = stationaryPoint;
	}

	public Integer getStationaryPoint() 
	{
		return stationaryPoint;
	}
	public void setCheckCount(Integer checkCount) 
	{
		this.checkCount = checkCount;
	}

	public Integer getCheckCount() 
	{
		return checkCount;
	}
	public void setStatus(Integer status) 
	{
		this.status = status;
	}

	public Integer getStatus() 
	{
		return status;
	}
	public void setType(Integer type) 
	{
		this.type = type;
	}

	public Integer getType() 
	{
		return type;
	}
	public void setDutyMan(String dutyMan) 
	{
		this.dutyMan = dutyMan;
	}

	public String getDutyMan() 
	{
		return dutyMan;
	}
	public void setDutyTime(Date dutyTime) 
	{
		this.dutyTime = dutyTime;
	}

	public Date getDutyTime() 
	{
		return dutyTime;
	}
	public void setCheckMan(String checkMan) 
	{
		this.checkMan = checkMan;
	}

	public String getCheckMan() 
	{
		return checkMan;
	}
	public void setCheckTime(Date checkTime) 
	{
		this.checkTime = checkTime;
	}

	public Date getCheckTime() 
	{
		return checkTime;
	}
	public void setCause(String cause) 
	{
		this.cause = cause;
	}

	public String getCause() 
	{
		return cause;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("makeTime", getMakeTime())
            .append("stationaryPoint", getStationaryPoint())
            .append("checkCount", getCheckCount())
            .append("status", getStatus())
            .append("type", getType())
            .append("dutyMan", getDutyMan())
            .append("dutyTime", getDutyTime())
            .append("checkMan", getCheckMan())
            .append("checkTime", getCheckTime())
            .append("cause", getCause())
            .toString();
    }
}
