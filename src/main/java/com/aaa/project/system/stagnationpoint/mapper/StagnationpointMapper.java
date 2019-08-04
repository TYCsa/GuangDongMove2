package com.aaa.project.system.stagnationpoint.mapper;

import com.aaa.project.system.stagnationpoint.domain.Stagnationpoint;
import java.util.List;	

/**
 * 驻点管理 数据层
 * 
 * @author teacherChen
 * @date 2019-07-30
 */
public interface StagnationpointMapper 
{
	/**
     * 查询驻点管理信息
     * 
     * @param stagId 驻点管理ID
     * @return 驻点管理信息
     */
	public Stagnationpoint selectStagnationpointById(Integer stagId);
	
	/**
     * 查询驻点管理列表
     * 
     * @param stagnationpoint 驻点管理信息
     * @return 驻点管理集合
     */
	public List<Stagnationpoint> selectStagnationpointList(Stagnationpoint stagnationpoint);
	
	/**
     * 新增驻点管理
     * 
     * @param stagnationpoint 驻点管理信息
     * @return 结果
     */
	public int insertStagnationpoint(Stagnationpoint stagnationpoint);
	
	/**
     * 修改驻点管理
     * 
     * @param stagnationpoint 驻点管理信息
     * @return 结果
     */
	public int updateStagnationpoint(Stagnationpoint stagnationpoint);

	/**
     * 删除驻点管理
     * 
     * @param stagId 驻点管理ID
     * @return 结果
     */
	public int deleteStagnationpointById(Integer stagId);
	
	/**
     * 批量删除驻点管理
     * 
     * @param stagIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteStagnationpointByIds(String[] stagIds);
	
}