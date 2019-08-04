package com.aaa.project.system.emp.controller;

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
import com.aaa.project.system.emp.domain.Emp;
import com.aaa.project.system.emp.service.IEmpService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;

/**
 * 代维公司代维人员 信息操作处理
 * 
 * @author teacherChen
 * @date 2019-07-31
 */
@Controller
@RequestMapping("/system/emp")
public class EmpController extends BaseController
{
    private String prefix = "system/emp";
	
	@Autowired
	private IEmpService empService;
	
	@RequiresPermissions("system:emp:view")
	@GetMapping()
	public String emp()
	{
	    return prefix + "/emp";
	}
	
	/**
	 * 查询代维公司代维人员列表
	 */

	//@PostMapping("/list")
	@RequestMapping("/list")
	@ResponseBody
	public TableDataInfo list(Emp emp)
	{
		startPage();
        List<Emp> list = empService.selectEmpList(emp);
		return getDataTable(list);
	}

	/**
	 * 手机端的用户登录
	 */
	@PostMapping("/login")
	@ResponseBody
	 public boolean login(String phone,String password){
		System.out.println("微信小程序调用接口！！用户名为"+phone+"密码为"+password);
		boolean login = empService.empLogin(phone, password);
		if (login){
			return true;
		}
		return false;
	}
	
	/**
	 * 导出代维公司代维人员列表
	 */
	@RequiresPermissions("system:emp:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Emp emp)
    {
    	List<Emp> list = empService.selectEmpList(emp);
        ExcelUtil<Emp> util = new ExcelUtil<Emp>(Emp.class);
        return util.exportExcel(list, "emp");
    }
	
	/**
	 * 新增代维公司代维人员
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存代维公司代维人员
	 */
	@RequiresPermissions("system:emp:add")
	@Log(title = "代维公司代维人员", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Emp emp) {

		return toAjax(empService.insertEmp(emp));
	}

	/**
	 * 修改代维公司代维人员
	 */
	@GetMapping("/edit/{empno}")
	public String edit(@PathVariable("empno") Integer empno, ModelMap mmap)
	{
		Emp emp = empService.selectEmpById(empno);
		mmap.put("emp", emp);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存代维公司代维人员
	 */
	@RequiresPermissions("system:emp:edit")
	@Log(title = "代维公司代维人员", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Emp emp)
	{		
		return toAjax(empService.updateEmp(emp));
	}
	
	/**
	 * 删除代维公司代维人员
	 */
	@RequiresPermissions("system:emp:remove")
	@Log(title = "代维公司代维人员", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(empService.deleteEmpByIds(ids));
	}
	
}
