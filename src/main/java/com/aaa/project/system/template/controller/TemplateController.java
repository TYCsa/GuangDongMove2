package com.aaa.project.system.template.controller;

import java.util.Date;
import java.util.List;

import com.aaa.project.system.standard.domain.Standard;
import com.aaa.project.system.standard.mapper.StandardMapper;
import com.aaa.project.system.standard.service.IStandardService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import com.aaa.framework.aspectj.lang.annotation.Log;
import com.aaa.framework.aspectj.lang.enums.BusinessType;
import com.aaa.project.system.template.domain.Template;
import com.aaa.project.system.template.service.ITemplateService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 模版管理 信息操作处理
 *
 * @author teacherChen
 * @date 2019-07-30
 */
@Controller
@RequestMapping("/system/template")
public class TemplateController extends BaseController {
    private String prefix = "system/template";

    @Autowired
    private ITemplateService templateService;

    @Resource
    private StandardMapper standardService;
    @RequiresPermissions("system:template:view")
    @GetMapping()
    public String template() {
        return prefix + "/template";
    }

    /**
     * 查询模版管理列表
     */
    @RequiresPermissions("system:template:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Template template) {
        startPage();
        List<Template> list = templateService.selectTemplateList(template);
        return getDataTable(list);
    }


    /**
     * 导出模版管理列表
     */
    @RequiresPermissions("system:template:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Template template) {
        List<Template> list = templateService.selectTemplateList(template);
        ExcelUtil<Template> util = new ExcelUtil<Template>(Template.class);
        return util.exportExcel(list, "template");
    }

    /**
     * 新增模版管理
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        List<Standard> standards = standardService.selectStandardListDist(null);
        mmap.put("standards",standards);
        return prefix + "/add";
    }

    /**
     * 新增保存模版管理
     */
    @RequiresPermissions("system:template:add")
    @Log(title = "模版管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Template template) {
        Date date=new Date();
        template.setTemplateTime(date);
        return toAjax(templateService.insertTemplate(template));
    }


    /**
     * 修改模版管理
     */
    @GetMapping("/edit/{templateId}")
    public String edit(@PathVariable("templateId") Integer templateId, ModelMap mmap) {

        Template template = templateService.selectTemplateById(templateId);
        Integer standardId = template.getStandardId();
        mmap.put("template", template);
        Standard standard=new Standard();
        standard.setStandardId( standardId);
        List<Standard> standards = standardService.selectStandardList(standard);
        mmap.put("standards", standards);
        return prefix + "/edit";
    }

    /**
     * 修改保存模版管理
     */
    @RequiresPermissions("system:template:edit")
    @Log(title = "模版管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Template template) {

        Date date=new Date();
        template.setTemplateTime(date);
        return toAjax(templateService.updateTemplate(template));
    }

    /**
     * 删除模版管理
     */
    @RequiresPermissions("system:template:remove")
    @Log(title = "模版管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(templateService.deleteTemplateByIds(ids));
    }

}
