package com.aaa.project.system.taskinfo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.taskinfo.mapper.TaskinfoMapper;
import com.aaa.project.system.taskinfo.domain.Taskinfo;
import com.aaa.project.system.taskinfo.service.ITaskinfoService;
import com.aaa.common.support.Convert;

/**
 * 巡检资源关系 服务层实现
 * 
 * @author toneySong
 * @date 2019-08-03
 */
@Service
public class TaskinfoServiceImpl implements ITaskinfoService 
{
	@Autowired
	private TaskinfoMapper taskinfoMapper;

	/**
     * 查询巡检资源关系信息
     * 
     * @param resId 巡检资源关系ID
     * @return 巡检资源关系信息
     */
    @Override
	public Taskinfo selectTaskinfoById(String resId)
	{
	    return taskinfoMapper.selectTaskinfoById(resId);
	}
	
	/**
     * 查询巡检资源关系列表
     * 
     * @param taskinfo 巡检资源关系信息
     * @return 巡检资源关系集合
     */
	@Override
	public List<Taskinfo> selectTaskinfoList(Taskinfo taskinfo)
	{
	    return taskinfoMapper.selectTaskinfoList(taskinfo);
	}
	
    /**
     * 新增巡检资源关系
     * 
     * @param taskinfo 巡检资源关系信息
     * @return 结果
     */
	@Override
	public int insertTaskinfo(Taskinfo taskinfo)
	{
	    return taskinfoMapper.insertTaskinfo(null);
	}
	
	/**
     * 修改巡检资源关系
     * 
     * @param taskinfo 巡检资源关系信息
     * @return 结果
     */
	@Override
	public int updateTaskinfo(Taskinfo taskinfo)
	{
	    return taskinfoMapper.updateTaskinfo(taskinfo);
	}

	/**
     * 删除巡检资源关系对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTaskinfoByIds(String ids)
	{
		return taskinfoMapper.deleteTaskinfoByIds(Convert.toStrArray(ids));
	}
	
}
