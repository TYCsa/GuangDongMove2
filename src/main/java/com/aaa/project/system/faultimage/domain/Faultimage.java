package com.aaa.project.system.faultimage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;

/**
 * 隐患图片表 faultimage
 * 
 * @author toneySong
 * @date 2019-08-06
 */
public class Faultimage extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 编号 */
	private Integer id;
	/** 隐患编号 */
	private Integer faultId;
	/** imageUrl */
	private String imageurl;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setFaultId(Integer faultId) 
	{
		this.faultId = faultId;
	}

	public Integer getFaultId() 
	{
		return faultId;
	}
	public void setImageurl(String imageurl) 
	{
		this.imageurl = imageurl;
	}

	public String getImageurl() 
	{
		return imageurl;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("faultId", getFaultId())
            .append("imageurl", getImageurl())
            .toString();
    }
}
