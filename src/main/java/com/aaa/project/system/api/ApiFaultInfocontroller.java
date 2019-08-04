package com.aaa.project.system.api;

/**
 * @Author:林培钦
 * @Dsscription:
 * @Date:Created in 16:46 2019/8/3
 * @Modified By:
 */

import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.project.system.faultinfo.domain.Faultinfo;
import com.aaa.project.system.faultinfo.service.IFaultinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 基站隐患接口
 */
@RestController
@RequestMapping("/api/fault")
public class ApiFaultInfocontroller {
    @Autowired
    private IFaultinfoService faultinfoService;

    @RequestMapping("/add")
    public AjaxResult setFaultInfo(Faultinfo faultinfo){
        AjaxResult ajaxResult = new AjaxResult();
        if (faultinfo.getFaultId()==null){
             faultinfoService.insertFaultinfo(faultinfo);
             ajaxResult.put("msg","添加成功");
        }else{
            faultinfoService.updateFaultinfo(faultinfo);
            ajaxResult.put("msg","修改成功");
        }
        ajaxResult.put("code",0);
        ajaxResult.put("faultinfo",faultinfo);
        return ajaxResult;
    }

}
