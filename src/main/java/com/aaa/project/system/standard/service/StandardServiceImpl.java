package com.aaa.project.system.standard.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.standard.mapper.StandardMapper;
import com.aaa.project.system.standard.domain.Standard;
import com.aaa.project.system.standard.service.IStandardService;
import com.aaa.common.support.Convert;

/**
 * 资源管理规范 服务层实现
 * 
 * @author teacherChen
 * @date 2019-07-31
 */
@Service("standardServiceImpl")
public class StandardServiceImpl implements IStandardService 
{
	@Autowired
	private StandardMapper standardMapper;

	/**
     * 查询资源管理规范信息
     * 
     * @param standardNum 资源管理规范ID
     * @return 资源管理规范信息
     */
    @Override
	public Standard selectStandardById(Integer standardNum)
	{
	    return standardMapper.selectStandardById(standardNum);
	}

	@Override
	public List<Standard> selectStandardfindAll() {
		return standardMapper.selectStandardfindAll();
	}


	/**
     * 查询资源管理规范列表
     * 
     * @param standard 资源管理规范信息
     * @return 资源管理规范集合
     */
	@Override
	public List<Standard> selectStandardList(Standard standard)
	{
	    return standardMapper.selectStandardList(standard);
	}
	
    /**
     * 新增资源管理规范
     * 
     * @param standard 资源管理规范信息
     * @return 结果
     */
	@Override
	public int insertStandard(Standard standard)
	{
	    return standardMapper.insertStandard(standard);
	}
	
	/**
     * 修改资源管理规范
     * 
     * @param standard 资源管理规范信息
     * @return 结果
     */
	@Override
	public int updateStandard(Standard standard)
	{
	    return standardMapper.updateStandard(standard);
	}

	/**
     * 删除资源管理规范对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteStandardByIds(String ids)
	{
		return standardMapper.deleteStandardByIds(Convert.toStrArray(ids));
	}
	
}
