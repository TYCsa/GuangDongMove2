package com.aaa.project.system.api;


import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.project.system.plan.domain.Plan;
import com.aaa.project.system.plan.service.IPlanService;
import com.aaa.project.system.planfacility.domain.Planfacility;
import com.aaa.project.system.planfacility.service.IPlanfacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author:林培钦
 * @Dsscription:
 * @Date:Created in 19:58 2019/8/3
 * @Modified By:
 */
@RestController
@RequestMapping("/api/plan")
public class ApiPlanController {
    @Autowired
    private IPlanService planService;
    @Autowired
    private IPlanfacilityService planfacilityService;
    /**
     * 查询已审核通过的计划
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAllList")
    @ResponseBody
    public List<Plan> findALlList() throws Exception{
        List<Plan> allList = planService.findAllList();
        return allList;
    }
    /*@RequestMapping("/selectFacility")
    @ResponseBody
    public List<Planfacility> selectPlanfacilityByStatus(Planfacility planfacility){
        List<Planfacility> list = planfacilityService.selectPlanfacilityList(planfacility);
        return list;
    }*/
    /**
     * 根据计划ID资源编号查询站点名称
     */

    @RequestMapping("/selectFacility/{status}")
    @ResponseBody
    public List<Planfacility> selectPlanfacilityByStatus(@PathVariable("status") Integer status){
        List<Planfacility> list = planfacilityService.selectPlanfacilityByStatus(status);
        return list;
    }

    /**
     * 根据计划ID资源编号更改巡检状态
     */
    @RequestMapping("/updateStatus/{id}")
    @ResponseBody
    public AjaxResult updateStatus(@PathVariable("id") Integer id){
        AjaxResult ajaxResult = new AjaxResult();
        planfacilityService.updateStatus(id);
        ajaxResult.put("code",0);
        ajaxResult.put("msg","修改成功");
        ajaxResult.put("id",id);
        return ajaxResult;
    }

}
