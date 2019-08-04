package com.aaa.project.system.faultinfo.controller;

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
import com.aaa.project.system.faultinfo.domain.Faultinfo;
import com.aaa.project.system.faultinfo.service.IFaultinfoService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;

/**
 * 隐患 信息操作处理
 * 
 * @author toneySong
 * @date 2019-08-03
 */
@Controller
@RequestMapping("/system/faultinfo")
public class FaultinfoController extends BaseController
{
    private String prefix = "system/faultinfo";
	
	@Autowired
	private IFaultinfoService faultinfoService;
	
	@RequiresPermissions("system:faultinfo:view")
	@GetMapping()
	public String faultinfo()
	{
	    return prefix + "/faultinfo";
	}
	
	/**
	 * 查询隐患列表
	 */
	@RequiresPermissions("system:faultinfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Faultinfo faultinfo)
	{
		startPage();
        List<Faultinfo> list = faultinfoService.selectFaultinfoList(faultinfo);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出隐患列表
	 */
	@RequiresPermissions("system:faultinfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Faultinfo faultinfo)
    {
    	List<Faultinfo> list = faultinfoService.selectFaultinfoList(faultinfo);
        ExcelUtil<Faultinfo> util = new ExcelUtil<Faultinfo>(Faultinfo.class);
        return util.exportExcel(list, "faultinfo");
    }
	
	/**
	 * 新增隐患
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存隐患
	 */
	@RequiresPermissions("system:faultinfo:add")
	@Log(title = "隐患", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Faultinfo faultinfo)
	{		
		return toAjax(faultinfoService.insertFaultinfo(faultinfo));
	}

	/**
	 * 修改隐患
	 */
	@GetMapping("/edit/{faultId}")
	public String edit(@PathVariable("faultId") Integer faultId, ModelMap mmap)
	{
		Faultinfo faultinfo = faultinfoService.selectFaultinfoById(faultId);
		mmap.put("faultinfo", faultinfo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存隐患
	 */
	@RequiresPermissions("system:faultinfo:edit")
	@Log(title = "隐患", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Faultinfo faultinfo)
	{		
		return toAjax(faultinfoService.updateFaultinfo(faultinfo));
	}
	
	/**
	 * 删除隐患
	 */
	@RequiresPermissions("system:faultinfo:remove")
	@Log(title = "隐患", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(faultinfoService.deleteFaultinfoByIds(ids));
	}
	
}
