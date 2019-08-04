package com.aaa.project.system.planfacility.controller;

import java.util.Date;
import java.util.List;

import com.aaa.project.system.plan.domain.Plan;
import com.aaa.project.system.plan.service.IPlanService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.aaa.framework.aspectj.lang.annotation.Log;
import com.aaa.framework.aspectj.lang.enums.BusinessType;
import com.aaa.project.system.planfacility.domain.Planfacility;
import com.aaa.project.system.planfacility.service.IPlanfacilityService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;

/**
 * 计划_设备 信息操作处理
 * 
 * @author teacherChen
 * @date 2019-08-02
 */
@Controller
@RequestMapping("/system/planfacility")
public class PlanfacilityController extends BaseController
{
    private String prefix = "system/planfacility";
	
	@Autowired
	private IPlanfacilityService planfacilityService;
	@Autowired
	private IPlanService planService;
	
	@RequiresPermissions("system:planfacility:view")
	@GetMapping()
	public String planfacility()
	{
	    return prefix + "/planfacility";
	}
	
	/**
	 * 查询计划_设备列表
	 */
	@RequiresPermissions("system:planfacility:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Planfacility planfacility)
	{
		startPage();
        List<Planfacility> list = planfacilityService.selectPlanfacilityList(planfacility);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出计划_设备列表
	 */
	@RequiresPermissions("system:planfacility:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Planfacility planfacility)
    {
    	List<Planfacility> list = planfacilityService.selectPlanfacilityList(planfacility);
        ExcelUtil<Planfacility> util = new ExcelUtil<Planfacility>(Planfacility.class);
        return util.exportExcel(list, "planfacility");
    }
	
	/**
	 * 新增计划_设备
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存计划_设备
	 */
	@RequiresPermissions("system:planfacility:add")
	@Log(title = "计划_设备", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Planfacility planfacility)
	{		
		return toAjax(planfacilityService.insertPlanfacility(planfacility));
	}

	/**
	 * 修改计划_设备
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Planfacility planfacility = planfacilityService.selectPlanfacilityById(id);
		mmap.put("planfacility", planfacility);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存计划_设备
	 */
	@RequiresPermissions("system:planfacility:edit")
	@Log(title = "计划_设备", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Planfacility planfacility)
	{		
		return toAjax(planfacilityService.updatePlanfacility(planfacility));
	}

	/**
	 * 修改保存计划_设备
	 */
	@RequiresPermissions("system:planfacility:edit")
	@Log(title = "计划_设备", businessType = BusinessType.UPDATE)
	@RequestMapping("/edits")
	@ResponseBody
	public AjaxResult editSave(@RequestBody List<Planfacility> planfacilities)
	{
		Plan plan = new Plan();
		//对应管理员
		plan.setDutyMan("小明");
		plan.setDutyTime(new Date());
		plan.setStatus(1);

		for (Planfacility planfacility : planfacilities) {
			if (plan.getId() == null){
				plan.setId(planfacilityService.selectPlanfacilityById(planfacility.getId()).getPlanId());
			}

			planfacility.setStatus(1);
			planfacilityService.updatePlanfacility(planfacility);
		}
		planService.updatePlan(plan);
		return toAjax(1);
	}
	
	/**
	 * 删除计划_设备
	 */
	@RequiresPermissions("system:planfacility:remove")
	@Log(title = "计划_设备", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(planfacilityService.deletePlanfacilityByIds(ids));
	}
	
}
