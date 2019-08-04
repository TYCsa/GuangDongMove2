package com.aaa.project.system.planfacility.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.planfacility.mapper.PlanfacilityMapper;
import com.aaa.project.system.planfacility.domain.Planfacility;
import com.aaa.project.system.planfacility.service.IPlanfacilityService;
import com.aaa.common.support.Convert;

/**
 * 计划_设备 服务层实现
 * 
 * @author teacherChen
 * @date 2019-08-02
 */
@Service
public class PlanfacilityServiceImpl implements IPlanfacilityService 
{
	@Autowired
	private PlanfacilityMapper planfacilityMapper;

	/**
     * 查询计划_设备信息
     * 
     * @param id 计划_设备ID
     * @return 计划_设备信息
     */
    @Override
	public Planfacility selectPlanfacilityById(Integer id)
	{
	    return planfacilityMapper.selectPlanfacilityById(id);
	}
	
	/**
     * 查询计划_设备列表
     * 
     * @param planfacility 计划_设备信息
     * @return 计划_设备集合
     */
	@Override
	public List<Planfacility> selectPlanfacilityList(Planfacility planfacility)
	{
	    return planfacilityMapper.selectPlanfacilityList(planfacility);
	}
	
    /**
     * 新增计划_设备
     * 
     * @param planfacility 计划_设备信息
     * @return 结果
     */
	@Override
	public int insertPlanfacility(Planfacility planfacility)
	{
	    return planfacilityMapper.insertPlanfacility(planfacility);
	}
	
	/**
     * 修改计划_设备
     * 
     * @param planfacility 计划_设备信息
     * @return 结果
     */
	@Override
	public int updatePlanfacility(Planfacility planfacility)
	{
	    return planfacilityMapper.updatePlanfacility(planfacility);
	}

	/**
     * 删除计划_设备对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deletePlanfacilityByIds(String ids)
	{
		return planfacilityMapper.deletePlanfacilityByIds(Convert.toStrArray(ids));
	}
	
}
