package com.aaa.project.system.standard.mapper;

import com.aaa.project.system.standard.domain.Standard;
import java.util.List;	

/**
 * 资源管理规范 数据层
 * 
 * @author teacherChen
 * @date 2019-07-31
 */
public interface StandardMapper 
{
	/**
     * 查询资源管理规范信息
     * 
     * @param standardNum 资源管理规范ID
     * @return 资源管理规范信息
     */
	public Standard selectStandardById(Integer standardNum);

	/**
	 * 查询巡检项目
	 * @return
	 */
	public List<Standard> selectStandardfindAll();
	
	/**
     * 查询资源管理规范列表
     * 
     * @param standard 资源管理规范信息
     * @return 资源管理规范集合
     */
	public List<Standard> selectStandardList(Standard standard);
	
	/**
     * 新增资源管理规范
     * 
     * @param standard 资源管理规范信息
     * @return 结果
     */
	public int insertStandard(Standard standard);
	
	/**
     * 修改资源管理规范
     * 
     * @param standard 资源管理规范信息
     * @return 结果
     */
	public int updateStandard(Standard standard);
	
	/**
     * 删除资源管理规范
     * 
     * @param standardNum 资源管理规范ID
     * @return 结果
     */
	public int deleteStandardById(Integer standardNum);
	
	/**
     * 批量删除资源管理规范
     * 
     * @param standardNums 需要删除的数据ID
     * @return 结果
     */
	public int deleteStandardByIds(String[] standardNums);
	
}