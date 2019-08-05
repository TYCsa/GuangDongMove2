package com.aaa.project.system.planfacility.mapper;

import com.aaa.project.system.planfacility.domain.Planfacility;
import java.util.List;	

/**
 * 计划_设备 数据层
 * 
 * @author teacherChen
 * @date 2019-08-02
 */
public interface PlanfacilityMapper 
{
	/**
     * 查询计划_设备信息
     * 
     * @param id 计划_设备ID
     * @return 计划_设备信息
     */
	public Planfacility selectPlanfacilityById(Integer id);
	
	/**
     * 查询计划_设备列表
     * 
     * @param planfacility 计划_设备信息
     * @return 计划_设备集合
     */
	public List<Planfacility> selectPlanfacilityList(Planfacility planfacility);

	/**
	 * 根据状态查询
	 * @param status
	 * @return
	 */
	List<Planfacility> selectPlanfacilityByStatus(Integer status);

	/**
     * 新增计划_设备
     * 
     * @param planfacility 计划_设备信息
     * @return 结果
     */
	public int insertPlanfacility(Planfacility planfacility);
	
	/**
     * 修改计划_设备
     * 
     * @param planfacility 计划_设备信息
     * @return 结果
     */
	public int updatePlanfacility(Planfacility planfacility);

	/**
	 * 根据id更改状态
	 * @param id
	 * @return
	 */
	int updateStatus(Integer id);
	
	/**
     * 删除计划_设备
     * 
     * @param id 计划_设备ID
     * @return 结果
     */
	public int deletePlanfacilityById(Integer id);
	
	/**
     * 批量删除计划_设备
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deletePlanfacilityByIds(String[] ids);
	
}