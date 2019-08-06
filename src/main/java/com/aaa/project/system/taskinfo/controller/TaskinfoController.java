package com.aaa.project.system.taskinfo.controller;

import java.util.ArrayList;
import java.util.List;

import com.aaa.project.system.networkresource.service.INetworkresourceService;
import com.aaa.project.system.stagnationpoint.domain.Stagnationpoint;
import com.aaa.project.system.stagnationpoint.service.IStagnationpointService;
import com.aaa.project.system.taskinfo.mapper.TaskinfoMapper;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.aaa.framework.aspectj.lang.annotation.Log;
import com.aaa.framework.aspectj.lang.enums.BusinessType;
import com.aaa.project.system.taskinfo.domain.Taskinfo;
import com.aaa.project.system.taskinfo.service.ITaskinfoService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;

import javax.annotation.Resource;

/**
 * 巡检资源关系 信息操作处理
 * 
 * @author toneySong
 * @date 2019-08-03
 */
@Controller
@RequestMapping("/system/taskinfo")
public class TaskinfoController extends BaseController
{
    private String prefix = "system/taskinfo";
	
	@Autowired
	private ITaskinfoService taskinfoService;

	@Resource
	private TaskinfoMapper taskinfoMapper;


	@Autowired
	private IStagnationpointService stagnationpointService;

	/**
	 * 去到资源分配页面
	 * @return
	 */
	@RequestMapping("/distributeResource")
	public String toDistributeResourcePage(){
		return prefix + "/distributeResource";
	}


	/**
	 * 显示资源分配信息
	 * @param taskinfo
	 * @return
	 */
	@RequestMapping("/listResource")
	@ResponseBody
	public TableDataInfo listResource(Taskinfo taskinfo)
	{
		startPage();
		List<Taskinfo> taskinfos = taskinfoMapper.selectDistributeResource(null);
		return getDataTable(taskinfos);
	}



	@RequiresPermissions("system:taskinfo:view")
	@GetMapping()
	public String taskinfo()
	{
	    return prefix + "/taskinfo";
	}
	
	/**
	 * 查询巡检资源关系列表
	 */
	@RequiresPermissions("system:taskinfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Taskinfo taskinfo)
	{
		startPage();
        List<Taskinfo> list = taskinfoService.selectTaskinfoList(taskinfo);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出巡检资源关系列表
	 */
	@RequiresPermissions("system:taskinfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Taskinfo taskinfo)
    {
    	List<Taskinfo> list = taskinfoService.selectTaskinfoList(taskinfo);
        ExcelUtil<Taskinfo> util = new ExcelUtil<Taskinfo>(Taskinfo.class);
        return util.exportExcel(list, "taskinfo");
    }
	
	/**
	 * 去到分配资源的页面
	 */
	@GetMapping("/add/{ids}")
	public String add(@PathVariable("ids") String ids,ModelMap mmap)
	{
		mmap.put("resId",ids);
		String[] resIds=ids.split(",");
		List<Stagnationpoint> stagnationpoints = stagnationpointService.selectStagnationpointList(null);
		mmap.put("stagnationpoints",stagnationpoints);
		mmap.put("resIds",resIds);
		return prefix + "/add";
	}
	
	/**
	 * 批量分配基站
	 */
	@RequiresPermissions("system:taskinfo:add")
	@Log(title = "巡检资源关系", businessType = BusinessType.INSERT)
	@Transactional
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Taskinfo taskinfo)
	{
		List<Taskinfo> list=new ArrayList<>();
		String resId = taskinfo.getResId();
		String[] resIds = resId.split(",");
		Integer stagId = taskinfo.getStagId();
		for(int i=0;i<resIds.length;i++){
			Taskinfo taskinfo1=new Taskinfo();
			taskinfo1.setResId(resIds[i]);
			taskinfo1.setStagId(stagId);
			list.add(taskinfo1);
		}
		return toAjax(taskinfoMapper.insertTaskinfo(list));
	}


	/**
	 * 修改巡检资源关系
	 */
	@GetMapping("/edit/{resId}")
	public String edit(@PathVariable("resId") String resId, ModelMap mmap)
	{
		Taskinfo taskinfo = taskinfoService.selectTaskinfoById(resId);
		mmap.put("taskinfo", taskinfo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存巡检资源关系,同时为对应驻点的巡检资源数量加一
	 */
	@RequiresPermissions("system:taskinfo:edit")
	@Log(title = "巡检资源关系", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Taskinfo taskinfo)
	{		
		return toAjax(taskinfoService.updateTaskinfo(taskinfo));
	}
	
	/**
	 * 释放分配的资源
	 */
	@RequiresPermissions("system:taskinfo:remove")
	@Log(title = "巡检资源关系", businessType = BusinessType.DELETE)
//	@Transactional
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{
		Taskinfo taskinfo=new Taskinfo();
		String[] split = ids.split(",");
		taskinfo.setResId(split[0]);
		taskinfo.setStagId(Integer.parseInt(split[1]));
		return toAjax(taskinfoMapper.deleteTaskinfoById(taskinfo));
	}
	
}
