package com.aaa.project.system.emp.mapper;

import com.aaa.project.system.emp.domain.Emp;
import java.util.List;	

/**
 * 代维公司代维人员 数据层
 * 
 * @author teacherChen
 * @date 2019-07-31
 */
public interface EmpMapper 
{
	/**
     * 查询代维公司代维人员信息
     * 
     * @param empno 代维公司代维人员ID
     * @return 代维公司代维人员信息
     */
	public Emp selectEmpById(Integer empno);
	
	/**
     * 查询代维公司代维人员列表
     * 
     * @param emp 代维公司代维人员信息
     * @return 代维公司代维人员集合
     */
	public List<Emp> selectEmpList(Emp emp);

	/**
	 * 登录
	 * @param emp
	 * @return
	 */
	Emp selectEmp(Emp emp);

	/**
	 * 根据巡检人员的手机号查询他的信息
	 * @param phone
	 * @return
	 */
	Emp selectEmpByphone(String phone);
	/**
     * 新增代维公司代维人员
     * 
     * @param emp 代维公司代维人员信息
     * @return 结果
     */
	public int insertEmp(Emp emp);
	
	/**
     * 修改代维公司代维人员
     * 
     * @param emp 代维公司代维人员信息
     * @return 结果
     */
	public int updateEmp(Emp emp);
	
	/**
     * 删除代维公司代维人员
     * 
     * @param empno 代维公司代维人员ID
     * @return 结果
     */
	public int deleteEmpById(Integer empno);
	
	/**
     * 批量删除代维公司代维人员
     * 
     * @param empnos 需要删除的数据ID
     * @return 结果
     */
	public int deleteEmpByIds(String[] empnos);
	
}