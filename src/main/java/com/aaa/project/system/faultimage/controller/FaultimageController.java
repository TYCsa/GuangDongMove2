package com.aaa.project.system.faultimage.controller;

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
import com.aaa.project.system.faultimage.domain.Faultimage;
import com.aaa.project.system.faultimage.service.IFaultimageService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;

/**
 * 隐患图片 信息操作处理
 * 
 * @author toneySong
 * @date 2019-08-06
 */
@Controller
@RequestMapping("/system/faultimage")
public class FaultimageController extends BaseController
{
    private String prefix = "system/faultimage";
	
	@Autowired
	private IFaultimageService faultimageService;
	
	@RequiresPermissions("system:faultimage:view")
	@GetMapping()
	public String faultimage()
	{
	    return prefix + "/faultimage";
	}
	
	/**
	 * 查询隐患图片列表
	 */
	@RequiresPermissions("system:faultimage:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Faultimage faultimage)
	{
		startPage();
        List<Faultimage> list = faultimageService.selectFaultimageList(faultimage);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出隐患图片列表
	 */
	@RequiresPermissions("system:faultimage:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Faultimage faultimage)
    {
    	List<Faultimage> list = faultimageService.selectFaultimageList(faultimage);
        ExcelUtil<Faultimage> util = new ExcelUtil<Faultimage>(Faultimage.class);
        return util.exportExcel(list, "faultimage");
    }
	
	/**
	 * 新增隐患图片
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存隐患图片
	 */
	@RequiresPermissions("system:faultimage:add")
	@Log(title = "隐患图片", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Faultimage faultimage)
	{		
		return toAjax(faultimageService.insertFaultimage(faultimage));
	}

	/**
	 * 修改隐患图片
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Faultimage faultimage = faultimageService.selectFaultimageById(id);
		mmap.put("faultimage", faultimage);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存隐患图片
	 */
	@RequiresPermissions("system:faultimage:edit")
	@Log(title = "隐患图片", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Faultimage faultimage)
	{		
		return toAjax(faultimageService.updateFaultimage(faultimage));
	}
	
	/**
	 * 删除隐患图片
	 */
	@RequiresPermissions("system:faultimage:remove")
	@Log(title = "隐患图片", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(faultimageService.deleteFaultimageByIds(ids));
	}
	
}
