package com.aaa.project.system.faultimage.service;

import java.io.IOException;
import java.util.List;

import com.aaa.common.exception.file.FileNameLengthLimitExceededException;
import com.aaa.framework.config.FileUploadConfig;
import org.apache.tomcat.util.http.fileupload.FileUploadBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.faultimage.mapper.FaultimageMapper;
import com.aaa.project.system.faultimage.domain.Faultimage;
import com.aaa.project.system.faultimage.service.IFaultimageService;
import com.aaa.common.support.Convert;
import org.springframework.web.multipart.MultipartFile;

import static com.aaa.common.utils.file.FileUploadUtils.upload;

/**
 * 隐患图片 服务层实现
 * 
 * @author toneySong
 * @date 2019-08-06
 */
@Service
public class FaultimageServiceImpl implements IFaultimageService 
{
	@Autowired
	private FaultimageMapper faultimageMapper;
	@Autowired
	private FileUploadConfig config;

	/**
     * 查询隐患图片信息
     * 
     * @param id 隐患图片ID
     * @return 隐患图片信息
     */
    @Override
	public Faultimage selectFaultimageById(Integer id)
	{
	    return faultimageMapper.selectFaultimageById(id);
	}
	
	/**
     * 查询隐患图片列表
     * 
     * @param faultimage 隐患图片信息
     * @return 隐患图片集合
     */
	@Override
	public List<Faultimage> selectFaultimageList(Faultimage faultimage)
	{
	    return faultimageMapper.selectFaultimageList(faultimage);
	}
	
    /**
     * 新增隐患图片
     * 
     * @param faultimage 隐患图片信息
     * @return 结果
     */
	@Override
	public int insertFaultimage(Faultimage faultimage)
	{
	    return faultimageMapper.insertFaultimage(faultimage);
	}
	
	/**
     * 修改隐患图片
     * 
     * @param faultimage 隐患图片信息
     * @return 结果
     */
	@Override
	public int updateFaultimage(Faultimage faultimage)
	{
	    return faultimageMapper.updateFaultimage(faultimage);
	}

	/**
     * 删除隐患图片对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteFaultimageByIds(String ids)
	{
		return faultimageMapper.deleteFaultimageByIds(Convert.toStrArray(ids));
	}

	@Override
	public String updateFaultImageByFaulitInfoId(Integer faultId, MultipartFile file) throws FileUploadBase.FileSizeLimitExceededException, IOException {
		//得到文件路径
		try {
			String url = config.getFaultImageDir() + upload(config.getUploadStationImape(),file,".jpg");
			//组合一个faultimage
			Faultimage faultimage = new Faultimage();
			faultimage.setFaultId(faultId);
			faultimage.setImageurl(url);
			//判断是否有已有信息对象
			List<Faultimage> faultimages = faultimageMapper.selectFaultimageByfaultId(faultId);
			if (faultimages.size()<4){
				faultimageMapper.insertFaultimage(faultimage);
				return "插入成功";
			}else{
				faultimages.get(0).setImageurl(faultimage.getImageurl());
				faultimageMapper.updateFaultimage(faultimages.get(0));
				return "更新成功";
			}
		} catch (FileNameLengthLimitExceededException e) {
			e.printStackTrace();
		}
		return null;
	}

}
