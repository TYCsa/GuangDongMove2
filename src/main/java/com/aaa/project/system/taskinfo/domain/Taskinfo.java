package com.aaa.project.system.taskinfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 巡检资源关系表 taskinfo
 * 
 * @author toneySong
 * @date 2019-08-03
 */
public class Taskinfo extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 资源编号 */
	private String resId;
	/**资源名称*/
	private String resName;
	/** 所在城市*/
	private String resCity;
	/** 经纬度 */
	private String longitudelatitude;
	/** 驻点编号 */
	private Integer stagId;
	/**驻点名称*/
	private String stagName;
	/** 派发人 */
	private String taskAuthor;
	/** 分配状态 */
	private String taskStatus;

	public void setResId(String resId) 
	{
		this.resId = resId;
	}

	public String getResId() 
	{
		return resId;
	}
	public void setStagId(Integer stagId) 
	{
		this.stagId = stagId;
	}

	public Integer getStagId() 
	{
		return stagId;
	}
	public void setTaskAuthor(String taskAuthor) 
	{
		this.taskAuthor = taskAuthor;
	}

	public String getTaskAuthor() 
	{
		return taskAuthor;
	}
	public void setTaskStatus(String taskStatus) 
	{
		this.taskStatus = taskStatus;
	}

	public String getTaskStatus() 
	{
		return taskStatus;
	}

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public String getResCity() {
		return resCity;
	}

	public void setResCity(String resCity) {
		this.resCity = resCity;
	}

	public String getLongitudelatitude() {
		return longitudelatitude;
	}

	public void setLongitudelatitude(String longitudelatitude) {
		this.longitudelatitude = longitudelatitude;
	}

	public String getStagName() {
		return stagName;
	}

	public void setStagName(String stagName) {
		this.stagName = stagName;
	}



	@Override
	public String toString() {
		return "Taskinfo{" +
				"resId='" + resId + '\'' +
				", resName='" + resName + '\'' +
				", resCity='" + resCity + '\'' +
				", longitudelatitude='" + longitudelatitude + '\'' +
				", stagId=" + stagId +
				", stagName='" + stagName + '\'' +
				", taskAuthor='" + taskAuthor + '\'' +
				", taskStatus='" + taskStatus + '\'' +
				'}';
	}
}
