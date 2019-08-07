package com.aaa.project.system.faultinfo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.faultinfo.mapper.FaultinfoMapper;
import com.aaa.project.system.faultinfo.domain.Faultinfo;
import com.aaa.project.system.faultinfo.service.IFaultinfoService;
import com.aaa.common.support.Convert;

/**
 * 隐患 服务层实现
 * 
 * @author toneySong
 * @date 2019-08-07
 */
@Service
public class FaultinfoServiceImpl implements IFaultinfoService 
{
	@Autowired
	private FaultinfoMapper faultinfoMapper;

	/**
     * 查询隐患信息
     * 
     * @param id 隐患ID
     * @return 隐患信息
     */
    @Override
	public Faultinfo selectFaultinfoById(Integer id)
	{
	    return faultinfoMapper.selectFaultinfoById(id);
	}
	
	/**
     * 查询隐患列表
     * 
     * @param faultinfo 隐患信息
     * @return 隐患集合
     */
	@Override
	public List<Faultinfo> selectFaultinfoList(Faultinfo faultinfo)
	{
	    return faultinfoMapper.selectFaultinfoList(faultinfo);
	}
	
    /**
     * 新增隐患
     * 
     * @param faultinfo 隐患信息
     * @return 结果
     */
	@Override
	public int insertFaultinfo(Faultinfo faultinfo)
	{
	    return faultinfoMapper.insertFaultinfo(faultinfo);
	}
	
	/**
     * 修改隐患
     * 
     * @param faultinfo 隐患信息
     * @return 结果
     */
	@Override
	public int updateFaultinfo(Faultinfo faultinfo)
	{
	    return faultinfoMapper.updateFaultinfo(faultinfo);
	}

	/**
     * 删除隐患对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteFaultinfoByIds(String ids)
	{
		return faultinfoMapper.deleteFaultinfoByIds(Convert.toStrArray(ids));
	}
	
}
