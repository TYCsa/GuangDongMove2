package com.aaa.project.system.api;

import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.project.system.standard.domain.Standard;
import com.aaa.project.system.standard.service.IStandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author:林培钦
 * @Dsscription:
 * @Date:Created in 10:21 2019/8/7
 * @Modified By:
 */
@RestController
@RequestMapping("/api/standard")
public class ApiStandardController {
    @Autowired
    private IStandardService standardService;

    @RequestMapping("/selectStandard")
    @ResponseBody
    public List<Standard> selectStandard(){
        List<Standard> standardList = standardService.selectStandardfindAll();
        System.out.println(standardList);
        return standardList;
    }
}
