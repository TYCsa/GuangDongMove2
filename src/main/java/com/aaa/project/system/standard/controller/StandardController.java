package com.aaa.project.system.standard.controller;

import java.util.Date;
import java.util.List;
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
import com.aaa.project.system.standard.domain.Standard;
import com.aaa.project.system.standard.service.IStandardService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;

/**
 * 资源管理规范 信息操作处理
 * 
 * @author toneySong
 * @date 2019-07-31
 */
@Controller
@RequestMapping("/system/standard")
public class StandardController extends BaseController
{
    private String prefix = "system/standard";
	
	@Autowired
	private IStandardService standardService;
	
	@RequiresPermissions("system:standard:view")
	@GetMapping()
	public String standard()
	{
	    return prefix + "/standard";
	}
	
	/**
	 * 查询资源管理规范列表
	 */
	@RequiresPermissions("system:standard:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Standard standard)
	{
		startPage();
        List<Standard> list = standardService.selectStandardList(standard);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出资源管理规范列表
	 */
	@RequiresPermissions("system:standard:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Standard standard)
    {
    	List<Standard> list = standardService.selectStandardList(standard);
        ExcelUtil<Standard> util = new ExcelUtil<Standard>(Standard.class);
        return util.exportExcel(list, "standard");
    }
	
	/**
	 * 新增资源管理规范
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存资源管理规范
	 */
	@RequiresPermissions("system:standard:add")
	@Log(title = "资源管理规范", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Standard standard)
	{
		Date date=new Date();
		standard.setStandardTime(date);
		return toAjax(standardService.insertStandard(standard));
	}

	/**
	 * 修改资源管理规范
	 */
	@GetMapping("/edit/{standardNum}")
	public String edit(@PathVariable("standardNum") Integer standardNum, ModelMap mmap)
	{
		Standard standard = standardService.selectStandardById(standardNum);
		mmap.put("standard", standard);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存资源管理规范
	 */
	@RequiresPermissions("system:standard:edit")
	@Log(title = "资源管理规范", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Standard standard)
	{
		Date date=new Date();
		standard.setStandardTime(date);
		return toAjax(standardService.updateStandard(standard));
	}
	
	/**
	 * 删除资源管理规范
	 */
	@RequiresPermissions("system:standard:remove")
	@Log(title = "资源管理规范", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(standardService.deleteStandardByIds(ids));
	}
	
}
