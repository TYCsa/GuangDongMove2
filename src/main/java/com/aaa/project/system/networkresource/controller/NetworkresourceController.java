package com.aaa.project.system.networkresource.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

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
import com.aaa.project.system.networkresource.domain.Networkresource;
import com.aaa.project.system.networkresource.service.INetworkresourceService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;

/**
 * 网络资源 信息操作处理
 * 
 * @author toneySong
 * @date 2019-08-02
 */
@Controller
@RequestMapping("/system/networkresource")
public class NetworkresourceController extends BaseController
{
    private String prefix = "system/networkresource";
	
	@Autowired
	private INetworkresourceService networkresourceService;
	
	@RequiresPermissions("system:networkresource:view")
	@GetMapping()
	public String networkresource()
	{
	    return prefix + "/networkresource";
	}
	
	/**
	 * 查询网络资源列表
	 */
	@RequiresPermissions("system:networkresource:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Networkresource networkresource)
	{
		networkresource.setEnable(1);
		startPage();
        List<Networkresource> list = networkresourceService.selectNetworkresourceList(networkresource);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出网络资源列表
	 */
	@RequiresPermissions("system:networkresource:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Networkresource networkresource)
    {
    	List<Networkresource> list = networkresourceService.selectNetworkresourceList(networkresource);
        ExcelUtil<Networkresource> util = new ExcelUtil<Networkresource>(Networkresource.class);
        return util.exportExcel(list, "networkresource");
    }
	
	/**
	 * 新增网络资源
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存网络资源
	 */
	@RequiresPermissions("system:networkresource:add")
	@Log(title = "网络资源", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Networkresource networkresource)
	{
		//设置资源id，保证不重复
		networkresource.setResId(UUID.randomUUID().toString());
		//设置时间，获取当时时间
		networkresource.setResTime(new Date());
		networkresource.setEnable(1);
		return toAjax(networkresourceService.insertNetworkresource(networkresource));
	}

	/**
	 * 修改网络资源
	 */
	@GetMapping("/edit/{resId}")
	public String edit(@PathVariable("resId") String resId, ModelMap mmap)
	{
		Networkresource networkresource = networkresourceService.selectNetworkresourceById(resId);
		mmap.put("networkresource", networkresource);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存网络资源
	 */
	@RequiresPermissions("system:networkresource:edit")
	@Log(title = "网络资源", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Networkresource networkresource)
	{		
		return toAjax(networkresourceService.updateNetworkresource(networkresource));
	}
	
	/**
	 * 删除网络资源
	 */
	@RequiresPermissions("system:networkresource:remove")
	@Log(title = "网络资源", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(networkresourceService.deleteNetworkresourceByIds(ids));
	}
	
}
