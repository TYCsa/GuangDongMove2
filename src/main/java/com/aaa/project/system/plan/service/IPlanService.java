package com.aaa.project.system.plan.service;

import com.aaa.project.system.plan.domain.Plan;
import java.util.List;

/**
 * 计划 服务层
 * 
 * @author teacherChen
 * @date 2019-08-02
 */
public interface IPlanService 
{
	/**
     * 查询计划信息
     * 
     * @param id 计划ID
     * @return 计划信息
     */
	public Plan selectPlanById(Integer id);

	/**
	 * 查询已审核过的计划
	 * @return
	 */
	List<Plan> findAllList();
	
	/**
     * 查询计划列表
     * 
     * @param plan 计划信息
     * @return 计划集合
     */
	public List<Plan> selectPlanList(Plan plan);
	
	/**
     * 新增计划
     * 
     * @param plan 计划信息
     * @return 结果
     */
	public int insertPlan(Plan plan);
	
	/**
     * 修改计划
     * 
     * @param plan 计划信息
     * @return 结果
     */
	public int updatePlan(Plan plan);
		
	/**
     * 删除计划信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deletePlanByIds(String ids);
	
}
