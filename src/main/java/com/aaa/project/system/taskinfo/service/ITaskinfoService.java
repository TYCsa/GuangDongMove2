package com.aaa.project.system.taskinfo.service;

import com.aaa.project.system.taskinfo.domain.Taskinfo;
import java.util.List;

/**
 * 巡检资源关系 服务层
 * 
 * @author toneySong
 * @date 2019-08-03
 */
public interface ITaskinfoService 
{
	/**
     * 查询巡检资源关系信息
     * 
     * @param resId 巡检资源关系ID
     * @return 巡检资源关系信息
     */
	public Taskinfo selectTaskinfoById(String resId);
	
	/**
     * 查询巡检资源关系列表
     * 
     * @param taskinfo 巡检资源关系信息
     * @return 巡检资源关系集合
     */
	public List<Taskinfo> selectTaskinfoList(Taskinfo taskinfo);
	
	/**
     * 新增巡检资源关系
     * 
     * @param taskinfo 巡检资源关系信息
     * @return 结果
     */
	public int insertTaskinfo(Taskinfo taskinfo);
	
	/**
     * 修改巡检资源关系
     * 
     * @param taskinfo 巡检资源关系信息
     * @return 结果
     */
	public int updateTaskinfo(Taskinfo taskinfo);
		
	/**
     * 删除巡检资源关系信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTaskinfoByIds(String ids);
	
}
