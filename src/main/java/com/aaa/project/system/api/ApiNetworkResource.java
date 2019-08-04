package com.aaa.project.system.api;

import com.aaa.project.system.networkresource.domain.Networkresource;
import com.aaa.project.system.networkresource.service.INetworkresourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author:林培钦
 * @Dsscription:
 * @Date:Created in 16:18 2019/8/4
 * @Modified By:
 */
@RestController
@RequestMapping("/api/netresources")
public class ApiNetworkResource {

    @Autowired
    private INetworkresourceService networkresourceService;

    @RequestMapping("/list")
    public List<Networkresource> list(Networkresource networkresource){
        List<Networkresource> list = networkresourceService.selectNetworkresourceList(networkresource);
        return list;
    }
}
