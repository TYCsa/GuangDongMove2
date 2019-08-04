package com.aaa.project.system.plan.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.plan.mapper.PlanMapper;
import com.aaa.project.system.plan.domain.Plan;
import com.aaa.project.system.plan.service.IPlanService;
import com.aaa.common.support.Convert;

/**
 * 计划 服务层实现
 * 
 * @author teacherChen
 * @date 2019-08-02
 */
@Service
public class PlanServiceImpl implements IPlanService 
{
	@Autowired
	private PlanMapper planMapper;

	/**
     * 查询计划信息
     * 
     * @param id 计划ID
     * @return 计划信息
     */
    @Override
	public Plan selectPlanById(Integer id)
	{
	    return planMapper.selectPlanById(id);
	}
	
	/**
     * 查询计划列表
     * 
     * @param plan 计划信息
     * @return 计划集合
     */
	@Override
	public List<Plan> selectPlanList(Plan plan)
	{
	    return planMapper.selectPlanList(plan);
	}
	
    /**
     * 新增计划
     * 
     * @param plan 计划信息
     * @return 结果
     */
	@Override
	public int insertPlan(Plan plan)
	{
	    return planMapper.insertPlan(plan);
	}
	
	/**
     * 修改计划
     * 
     * @param plan 计划信息
     * @return 结果
     */
	@Override
	public int updatePlan(Plan plan)
	{
	    return planMapper.updatePlan(plan);
	}

	/**
     * 删除计划对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deletePlanByIds(String ids)
	{
		return planMapper.deletePlanByIds(Convert.toStrArray(ids));
	}
	
}
