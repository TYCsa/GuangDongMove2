package com.aaa.project.system.networkresource.mapper;

import com.aaa.project.system.networkresource.domain.Networkresource;
import java.util.List;	

/**
 * 网络资源 数据层
 * 
 * @author toneySong
 * @date 2019-08-02
 */
public interface NetworkresourceMapper 
{
	/**
     * 查询网络资源信息
     * 
     * @param resId 网络资源ID
     * @return 网络资源信息
     */
	public Networkresource selectNetworkresourceById(String resId);
	
	/**
     * 查询网络资源列表
     * 
     * @param networkresource 网络资源信息
     * @return 网络资源集合
     */
	public List<Networkresource> selectNetworkresourceList(Networkresource networkresource);

	/**
     * 新增网络资源
     * 
     * @param networkresource 网络资源信息
     * @return 结果
     */
	public int insertNetworkresource(Networkresource networkresource);
	
	/**
     * 修改网络资源
     * 
     * @param networkresource 网络资源信息
     * @return 结果
     */
	public int updateNetworkresource(Networkresource networkresource);
	
	/**
     * 删除网络资源
     * 
     * @param resId 网络资源ID
     * @return 结果
     */
	public int deleteNetworkresourceById(String resId);
	
	/**
     * 批量删除网络资源
     * 
     * @param resIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteNetworkresourceByIds(String[] resIds);
	
}