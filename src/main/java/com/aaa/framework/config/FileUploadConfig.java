package com.aaa.framework.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author:林培钦
 * @Dsscription:
 * @Date:Created in 15:57 2019/8/3
 * @Modified By:
 */
@Component
@ConfigurationProperties(prefix = "upload")
public class FileUploadConfig {
    //基站照片上传路径
    private String uploadStationImape;

    public String getUploadStationImape() {
        return uploadStationImape;
    }

    public void setUploadStationImape(String uploadStationImape) {
        this.uploadStationImape = uploadStationImape;
    }
}
