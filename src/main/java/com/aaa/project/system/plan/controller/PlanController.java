package com.aaa.project.system.plan.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.aaa.common.utils.security.ShiroUtils;
import com.aaa.project.system.networkresource.domain.Networkresource;
import com.aaa.project.system.networkresource.service.INetworkresourceService;
import com.aaa.project.system.planfacility.domain.Planfacility;
import com.aaa.project.system.planfacility.service.IPlanfacilityService;
import com.aaa.project.system.stagnationpoint.domain.Stagnationpoint;
import com.aaa.project.system.stagnationpoint.service.IStagnationpointService;
import com.aaa.project.system.taskinfo.domain.Taskinfo;
import com.aaa.project.system.taskinfo.service.ITaskinfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.aaa.framework.aspectj.lang.annotation.Log;
import com.aaa.framework.aspectj.lang.enums.BusinessType;
import com.aaa.project.system.plan.domain.Plan;
import com.aaa.project.system.plan.service.IPlanService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * 计划 信息操作处理
 * 
 * @author teacherChen
 * @date 2019-08-02
 */
@Controller
@RequestMapping("/system/plan")
public class PlanController extends BaseController
{
    private String prefix = "system/plan";
	
	@Autowired
	private IPlanService planService;

	@Autowired
	private IPlanfacilityService planfacilityService;
	@Autowired
	private ITaskinfoService taskinfoService;
	@Autowired
	private INetworkresourceService networkresourceService;
	@Autowired
	private IStagnationpointService stagnationpointService;

	@RequiresPermissions("system:plan:view")
	@GetMapping()
	public String plan(ModelMap mmap)
	{
		List<Stagnationpoint> stagnationpoints = stagnationpointService.selectStagnationpointList(null);
		mmap.put("stagnationpoints",stagnationpoints);
	    return prefix + "/plan";
	}

	@GetMapping("checkPlan")
	public String checkPlan()
	{
		return prefix + "/checkPlan";
	}
	@GetMapping("checkEdit/{id}")
	public String checkEdit(@PathVariable("id") Integer id, ModelMap mmap)
	{

		Plan plan = planService.selectPlanById(id);
		mmap.put("plan", plan);

		return prefix + "/checkEdit";
	}
	
	/**
	 * 查询计划列表
	 */
	@RequiresPermissions("system:plan:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Plan plan)
	{
		startPage();
        List<Plan> list = planService.selectPlanList(plan);
		return getDataTable(list);
	}


	@GetMapping("/show/{id}")
	public String show(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Plan plan = planService.selectPlanById(id);
		mmap.put("plan", plan);
		return prefix + "/showPlan";
	}
	
	
	/**
	 * 导出计划列表
	 */
	@RequiresPermissions("system:plan:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Plan plan)
    {
    	List<Plan> list = planService.selectPlanList(plan);
        ExcelUtil<Plan> util = new ExcelUtil<Plan>(Plan.class);
        return util.exportExcel(list, "plan");
    }
	
	/**
	 * 新增计划
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap)
	{
		Taskinfo taskinfo = new Taskinfo();
		taskinfo.setStagId(10002);
		List<Taskinfo> taskinfos = taskinfoService.selectTaskinfoList(taskinfo);
		List<Networkresource> networkresources = new ArrayList<>();
		for (Taskinfo task : taskinfos) {
			networkresources.add(networkresourceService.selectNetworkresourceById(task.getResId()));
		}

		mmap.put("networkresources",networkresources);
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存计划
	 */
	@RequiresPermissions("system:plan:add")
	@Log(title = "计划", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Plan plan)
	{


		//对用公司创建的计划
		plan.setStationaryPoint(10002);
		Taskinfo taskinfo = new Taskinfo();
		taskinfo.setStagId(10002);
		List<Taskinfo> taskinfos = taskinfoService.selectTaskinfoList(taskinfo);
		List<Networkresource> networkresources = new ArrayList<>();
		for (Taskinfo task : taskinfos) {
			networkresources.add(networkresourceService.selectNetworkresourceById(task.getResId()));
		}
		plan.setCheckCount(networkresources.size());
		planService.insertPlan(plan);
		for (Networkresource n: networkresources){
			Planfacility planfacility = new Planfacility();
			planfacility.setPlanId(plan.getId());
			planfacility.setFacilityId(n.getResId());
			planfacilityService.insertPlanfacility(planfacility);
		}
		return toAjax(1);
	}

	/**
	 * 修改计划
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Plan plan = planService.selectPlanById(id);
		Planfacility planfacility = new Planfacility();
		planfacility.setPlanId(id);
		List<Planfacility> planfacilities = planfacilityService.selectPlanfacilityList(planfacility);
		for (Planfacility pf : planfacilities) {
			Networkresource site = networkresourceService.selectNetworkresourceById(pf.getFacilityId());
			pf.setNetworkresource(site);
		}

		mmap.put("plan", plan);
		mmap.put("planfacilities",planfacilities);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存计划
	 */

	@Log(title = "计划", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Plan plan,String checkStatus)
	{
		switch (plan.getStatus()){
			case 0:
				plan.setStatus(1);
				plan.setDutyMan(ShiroUtils.getSysUser().getUserName());
				plan.setDutyTime(new Date());
				plan.setCause("");
				break;
			case 1:
				if (checkStatus!= null && checkStatus.equals("on")){
					plan.setStatus(2);
					plan.setCheckMan(ShiroUtils.getSysUser().getUserName());
					plan.setCheckTime(new Date());
				}else{
					plan.setStatus(3);
					plan.setCheckMan(ShiroUtils.getSysUser().getUserName());
					plan.setCheckTime(new Date());
				}
				break;
		}

		return toAjax(planService.updatePlan(plan));
	}
	
	/**
	 * 删除计划
	 */
	@RequiresPermissions("system:plan:remove")
	@Log(title = "计划", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(planService.deletePlanByIds(ids));
	}
	
}
