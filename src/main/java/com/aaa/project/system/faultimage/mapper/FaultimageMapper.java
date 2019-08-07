package com.aaa.project.system.faultimage.mapper;

import com.aaa.project.system.faultimage.domain.Faultimage;
import java.util.List;	

/**
 * 隐患图片 数据层
 * 
 * @author toneySong
 * @date 2019-08-06
 */
public interface FaultimageMapper 
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

	public List<Faultimage> selectFaultimageByfaultId(int faultId);
	
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
	 * 根据fault_id更新信息
	 * @param faultimage
	 * @return
	 */
	public int updateFaultImageByFaulitInfoId(Faultimage faultimage);
	
	/**
     * 删除隐患图片
     * 
     * @param id 隐患图片ID
     * @return 结果
     */
	public int deleteFaultimageById(Integer id);
	
	/**
     * 批量删除隐患图片
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteFaultimageByIds(String[] ids);
	
}