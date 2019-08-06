package com.aaa.project.system.taskinfo.mapper;

import com.aaa.project.system.taskinfo.domain.Taskinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 巡检资源关系 数据层
 * 
 * @author toneySong
 * @date 2019-08-03
 */
public interface TaskinfoMapper 
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
	 * 查看分配资源
	 * @param taskinfo
	 * @return
	 */
	public List<Taskinfo> selectDistributeResource(Taskinfo taskinfo);


	/**
	 * 分配资源，巡检资源数量加1
	 * @param stagId
	 * @return
	 */
	public int addStagCountById(Integer stagId);

	/**
	 * 释放资源，巡检资源数量减1
	 * @param stagId
	 * @return
	 */
	public int subtractStagCountById(Integer stagId);

	/**
     * 新增巡检资源关系
     * 
     * @param list 巡检资源关系信息
     * @return 结果
     */
	public int insertTaskinfo(List<Taskinfo> list);
	
	/**
     * 修改巡检资源关系
     * 
     * @param taskinfo 巡检资源关系信息
     * @return 结果
     */
	public int updateTaskinfo(Taskinfo taskinfo);
	
	/**
     * 删除巡检资源关系
     * 
     * @param resId 巡检资源关系ID
     * @return 结果
     */
	public int deleteTaskinfoById(Taskinfo taskinfo);
	
	/**
     * 批量删除巡检资源关系
     * 
     * @param resIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTaskinfoByIds(String[] resIds);


	
}