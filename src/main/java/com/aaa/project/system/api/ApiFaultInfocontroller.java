package com.aaa.project.system.api;

/**
 * @Author:林培钦
 * @Dsscription:
 * @Date:Created in 16:46 2019/8/3
 * @Modified By:
 */

import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.project.system.faultimage.service.IFaultimageService;
import com.aaa.project.system.faultinfo.domain.Faultinfo;
import com.aaa.project.system.faultinfo.service.IFaultinfoService;
import org.apache.tomcat.util.http.fileupload.FileUploadBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 基站隐患接口
 */
@RestController
@RequestMapping("/api/fault")
public class ApiFaultInfocontroller {
    @Autowired
    private IFaultinfoService faultinfoService;
    @Autowired
    private IFaultimageService faultimageService;
    /**
     * 新增或者修改隐患信息
     * @param faultinfo
     * @return
     */
    @RequestMapping(value = "/setFaultInfo",method = RequestMethod.POST)
    public AjaxResult setFaultInfo(Faultinfo faultinfo){
        AjaxResult ajaxResult = new AjaxResult();
        if (faultinfo.getId()==null){
            faultinfoService.insertFaultinfo(faultinfo);
            ajaxResult.put("msg","添加成功");
        }else{
            faultinfoService.updateFaultinfo(faultinfo);
            ajaxResult.put("msg","更新成功");
        }
        return ajaxResult;
    }
    /**
     * 设置基站照片
     * @param faultId
     * @param file
     * @return
     * @throws FileUploadBase.FileSizeLimitExceededException
     * @throws IOException
     */
    @RequestMapping("/setFaultImage")
    public AjaxResult setFaultImage(@RequestParam(value = "faultId") int faultId,@RequestParam(value = "file") MultipartFile file)
    throws FileUploadBase.FileSizeLimitExceededException,IOException{
        AjaxResult ajaxResult = new AjaxResult();
        String result = faultimageService.updateFaultImageByFaulitInfoId(faultId, file);
        ajaxResult.put("code",0);
        ajaxResult.put("msg",result);
        return ajaxResult;
    }

    /**
     * 根据隐患编号获取实体
     * @param faultId
     * @return
     */
    /*@RequestMapping("/getFaultInfo")
    public AjaxResult getFaultInfo(@RequestParam("faultId") Integer faultId ) {
        AjaxResult ajaxResult = new AjaxResult();
        Faultinfo faultinfo = faultinfoService.selectFaultinfoById(faultId);
        ajaxResult.put("code",0);
        ajaxResult.put("faultinfo",faultinfo);
        return ajaxResult;
    }*/
}
