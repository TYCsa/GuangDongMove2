package com.aaa.project.system.plans.service;

import com.aaa.project.system.plans.domain.Plans;
import java.util.List;

/**
 * 代维计划 服务层
 * 
 * @author teacherChen
 * @date 2019-07-30
 */
public interface IPlansService 
{
	/**
     * 查询代维计划信息
     * 
     * @param planId 代维计划ID
     * @return 代维计划信息
     */
	public Plans selectPlansById(Integer planId);
	
	/**
     * 查询代维计划列表
     * 
     * @param plans 代维计划信息
     * @return 代维计划集合
     */
	public List<Plans> selectPlansList(Plans plans);
	
	/**
     * 新增代维计划
     * 
     * @param plans 代维计划信息
     * @return 结果
     */
	public int insertPlans(Plans plans);
	
	/**
     * 修改代维计划
     * 
     * @param plans 代维计划信息
     * @return 结果
     */
	public int updatePlans(Plans plans);
		
	/**
     * 删除代维计划信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deletePlansByIds(String ids);
	
}
