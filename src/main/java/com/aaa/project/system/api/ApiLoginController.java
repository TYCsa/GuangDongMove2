package com.aaa.project.system.api;

import com.aaa.project.system.emp.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:林培钦
 * @Dsscription:
 * @Date:Created in 11:54 2019/8/6
 * @Modified By:
 */
@RestController
@RequestMapping("/api/emp")
public class ApiLoginController {
    @Autowired
    private IEmpService empService;
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
}
