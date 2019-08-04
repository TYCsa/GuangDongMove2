package com.aaa.project.system.faultinfo.mapper;

import com.aaa.project.system.faultinfo.domain.Faultinfo;
import java.util.List;	

/**
 * 隐患 数据层
 * 
 * @author toneySong
 * @date 2019-08-03
 */
public interface FaultinfoMapper 
{
	/**
     * 查询隐患信息
     * 
     * @param faultId 隐患ID
     * @return 隐患信息
     */
	public Faultinfo selectFaultinfoById(Integer faultId);
	
	/**
     * 查询隐患列表
     * 
     * @param faultinfo 隐患信息
     * @return 隐患集合
     */
	public List<Faultinfo> selectFaultinfoList(Faultinfo faultinfo);
	
	/**
     * 新增隐患
     * 
     * @param faultinfo 隐患信息
     * @return 结果
     */
	public int insertFaultinfo(Faultinfo faultinfo);
	
	/**
     * 修改隐患
     * 
     * @param faultinfo 隐患信息
     * @return 结果
     */
	public int updateFaultinfo(Faultinfo faultinfo);
	
	/**
     * 删除隐患
     * 
     * @param faultId 隐患ID
     * @return 结果
     */
	public int deleteFaultinfoById(Integer faultId);
	
	/**
     * 批量删除隐患
     * 
     * @param faultIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteFaultinfoByIds(String[] faultIds);
	
}