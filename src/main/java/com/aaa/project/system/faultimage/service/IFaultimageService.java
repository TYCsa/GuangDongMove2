package com.aaa.project.system.faultimage.service;

import com.aaa.project.system.faultimage.domain.Faultimage;
import org.apache.tomcat.util.http.fileupload.FileUploadBase;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * 隐患图片 服务层
 * 
 * @author toneySong
 * @date 2019-08-06
 */
public interface IFaultimageService 
{
	/**
     * 查询隐患图片信息
     * 
     * @param id 隐患图片ID
     * @return 隐患图片信息
     */
	public Faultimage selectFaultimageById(Integer id);
	
	/**
     * 查询隐患图片列表
     * 
     * @param faultimage 隐患图片信息
     * @return 隐患图片集合
     */
	public List<Faultimage> selectFaultimageList(Faultimage faultimage);
	
	/**
     * 新增隐患图片
     * 
     * @param faultimage 隐患图片信息
     * @return 结果
     */
	public int insertFaultimage(Faultimage faultimage);
	
	/**
     * 修改隐患图片
     * 
     * @param faultimage 隐患图片信息
     * @return 结果
     */
	public int updateFaultimage(Faultimage faultimage);
		
	/**
     * 删除隐患图片信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteFaultimageByIds(String ids);

	/**
	 * 更新隐患图片信息
	 * @param faultId 唯一标识
	 * @param file 文件
	 * @return
	 * @throws FileUploadBase.FileSizeLimitExceededException
	 * @throws IOException
	 */
	public String updateFaultImageByFaulitInfoId(Integer faultId, MultipartFile file) throws FileUploadBase.FileSizeLimitExceededException,IOException;

}
