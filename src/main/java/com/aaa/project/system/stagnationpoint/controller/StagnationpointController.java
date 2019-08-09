package com.aaa.project.system.stagnationpoint.controller;

import java.util.List;

import com.aaa.project.system.stagnationpoint.mapper.StagnationpointMapper;
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
import com.aaa.project.system.stagnationpoint.domain.Stagnationpoint;
import com.aaa.project.system.stagnationpoint.service.IStagnationpointService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;

import javax.annotation.Resource;

/**
 * 驻点管理 信息操作处理
 * 
 * @author toneySong
 * @date 2019-07-30
 */
@Controller
@RequestMapping("/system/stagnationpoint")
public class StagnationpointController extends BaseController
{
    private String prefix = "system/stagnationpoint";
	
	@Autowired
	private IStagnationpointService stagnationpointService;

	@Resource
	private StagnationpointMapper stagnationpointMapper;
	@RequiresPermissions("system:stagnationpoint:view")
	@GetMapping()
	public String stagnationpoint()
	{
	    return prefix + "/stagnationpoint";
	}

	/**
	 * 查询驻点管理列表
	 */
	@RequiresPermissions("system:stagnationpoint:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Stagnationpoint stagnationpoint)
	{
		startPage();
        List<Stagnationpoint> list = stagnationpointService.selectStagnationpointList(stagnationpoint);
		return getDataTable(list);
	}

	/**
	 * 去到省统计页面
	 * @return
	 */
	@RequestMapping("/toStatisticsPage")
	public String toStatisticsPage(ModelMap mmap)
	{
		//驻点的数量
		int stagnationpointCount = stagnationpointMapper.selectStagnationpointCount();
		mmap.put("stagnationpointCount",stagnationpointCount);
		//基站数量
		int networkersourceCount = stagnationpointMapper.selectNetworkersourceCount();
		mmap.put("networkersourceCount",networkersourceCount);
		//已分配基站数量
		int taskinfoCount = stagnationpointMapper.selectTaskinfoCount();
		mmap.put("taskinfoCount",taskinfoCount);
		int faultinfoCount = stagnationpointMapper.selectFaultinfoCount();
		mmap.put("faultinfoCount",faultinfoCount);
		return prefix + "/statistics2";
	}

	/**
	 * 去到市统计页面
	 * @param mmap
	 * @return
	 */
	@RequestMapping("/toStatisticsCityPage")
	public String toStatisticsCityPage(ModelMap mmap)
	{
		//按条件驻点的数量
		int stagnationpointCount = stagnationpointMapper.selectStagnationpointCountByCondition();
		mmap.put("stagnationpointCount",stagnationpointCount);
		//基站数量
		int networkersourceCount = stagnationpointMapper.selectNetworkersourceCountByCondition();
		mmap.put("networkersourceCount",networkersourceCount);
		//已分配基站数量
		int taskinfoCount = stagnationpointMapper.selectTaskinfoCountByCondition();
		mmap.put("taskinfoCount",taskinfoCount);
		/**
		 *隐患数量
		 */
		int faultinfoCount = stagnationpointMapper.selectFaultinfoCountByCondition();
		mmap.put("faultinfoCount",faultinfoCount);
		return prefix + "/statisticsByCity2";
	}

	/**
	 * 查询驻点管理列表
	 */
	@RequiresPermissions("system:stagnationpoint:list")
	@PostMapping("/list2")
	@ResponseBody
	public TableDataInfo listByCity(Stagnationpoint stagnationpoint)
	{
		stagnationpoint.setStagAddress("广东省深圳市");
		startPage();
		List<Stagnationpoint> list = stagnationpointService.selectStagnationpointList(stagnationpoint);
		return getDataTable(list);
	}
	
	/**
	 * 导出驻点管理列表
	 */
	@RequiresPermissions("system:stagnationpoint:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Stagnationpoint stagnationpoint)
    {
    	List<Stagnationpoint> list = stagnationpointService.selectStagnationpointList(stagnationpoint);
        ExcelUtil<Stagnationpoint> util = new ExcelUtil<Stagnationpoint>(Stagnationpoint.class);
        return util.exportExcel(list, "stagnationpoint");
    }
	
	/**
	 * 新增驻点管理
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存驻点管理
	 */
	@RequiresPermissions("system:stagnationpoint:add")
	@Log(title = "驻点管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Stagnationpoint stagnationpoint)
	{		
		return toAjax(stagnationpointService.insertStagnationpoint(stagnationpoint));
	}

	/**
	 * 修改驻点管理
	 */
	@GetMapping("/edit/{stagId}")
	public String edit(@PathVariable("stagId") Integer stagId, ModelMap mmap)
	{
		Stagnationpoint stagnationpoint = stagnationpointService.selectStagnationpointById(stagId);
		mmap.put("stagnationpoint", stagnationpoint);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存驻点管理
	 */
	@RequiresPermissions("system:stagnationpoint:edit")
	@Log(title = "驻点管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Stagnationpoint stagnationpoint)
	{		
		return toAjax(stagnationpointService.updateStagnationpoint(stagnationpoint));
	}
	
	/**
	 * 删除驻点管理
	 */
	@RequiresPermissions("system:stagnationpoint:remove")
	@Log(title = "驻点管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(stagnationpointService.deleteStagnationpointByIds(ids));
	}
	
}
