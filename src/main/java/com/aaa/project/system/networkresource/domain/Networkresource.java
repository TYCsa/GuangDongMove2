package com.aaa.project.system.networkresource.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 网络资源表 networkresource
 * 
 * @author toneySong
 * @date 2019-08-02
 */
public class Networkresource extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 资源编号 */
	private String resId;
	/** 资源名称 */
	private String resName;
	/** 资源所在市 */
	private String resCity;
	/** 入网时间 */
	private Date resTime;
	/** 经纬度 */
	private String longitudelatitude;
	/** 是否禁用 */
	private Integer enable;

	private Integer status;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setResId(String resId)
	{
		this.resId = resId;
	}

	public String getResId() 
	{
		return resId;
	}
	public void setResName(String resName) 
	{
		this.resName = resName;
	}

	public String getResName() 
	{
		return resName;
	}
	public void setResCity(String resCity) 
	{
		this.resCity = resCity;
	}

	public String getResCity() 
	{
		return resCity;
	}
	public void setResTime(Date resTime) 
	{
		this.resTime = resTime;
	}

	public Date getResTime() 
	{
		return resTime;
	}
	public void setLongitudelatitude(String longitudelatitude) 
	{
		this.longitudelatitude = longitudelatitude;
	}

	public String getLongitudelatitude() 
	{
		return longitudelatitude;
	}
	public void setEnable(Integer enable) 
	{
		this.enable = enable;
	}

	public Integer getEnable() 
	{
		return enable;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("resId", getResId())
            .append("resName", getResName())
            .append("resCity", getResCity())
            .append("resTime", getResTime())
            .append("longitudelatitude", getLongitudelatitude())
            .append("enable", getEnable())
            .toString();
    }
}
