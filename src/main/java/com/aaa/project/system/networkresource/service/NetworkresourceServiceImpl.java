package com.aaa.project.system.networkresource.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.networkresource.mapper.NetworkresourceMapper;
import com.aaa.project.system.networkresource.domain.Networkresource;
import com.aaa.project.system.networkresource.service.INetworkresourceService;
import com.aaa.common.support.Convert;

/**
 * 网络资源 服务层实现
 * 
 * @author toneySong
 * @date 2019-08-02
 */
@Service("networkresourceServiceImpl")
public class NetworkresourceServiceImpl implements INetworkresourceService 
{
	@Autowired
	private NetworkresourceMapper networkresourceMapper;

	/**
     * 查询网络资源信息
     * 
     * @param resId 网络资源ID
     * @return 网络资源信息
     */
    @Override
	public Networkresource selectNetworkresourceById(String resId)
	{
	    return networkresourceMapper.selectNetworkresourceById(resId);
	}
	
	/**
     * 查询网络资源列表
     * 
     * @param networkresource 网络资源信息
     * @return 网络资源集合
     */
	@Override
	public List<Networkresource> selectNetworkresourceList(Networkresource networkresource)
	{
	    return networkresourceMapper.selectNetworkresourceList(networkresource);
	}
	
    /**
     * 新增网络资源
     * 
     * @param networkresource 网络资源信息
     * @return 结果
     */
	@Override
	public int insertNetworkresource(Networkresource networkresource)
	{
	    return networkresourceMapper.insertNetworkresource(networkresource);
	}
	
	/**
     * 修改网络资源
     * 
     * @param networkresource 网络资源信息
     * @return 结果
     */
	@Override
	public int updateNetworkresource(Networkresource networkresource)
	{
	    return networkresourceMapper.updateNetworkresource(networkresource);
	}

	/**
     * 删除网络资源对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteNetworkresourceByIds(String ids)
	{
		return networkresourceMapper.deleteNetworkresourceByIds(Convert.toStrArray(ids));
	}
	
}
