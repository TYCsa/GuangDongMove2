package com.aaa.project.system.emp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.emp.mapper.EmpMapper;
import com.aaa.project.system.emp.domain.Emp;
import com.aaa.project.system.emp.service.IEmpService;
import com.aaa.common.support.Convert;

/**
 * 代维公司代维人员 服务层实现
 * 
 * @author teacherChen
 * @date 2019-07-31
 */
@Service
public class EmpServiceImpl implements IEmpService 
{
	@Autowired
	private EmpMapper empMapper;

	/**
     * 查询代维公司代维人员信息
     * 
     * @param empno 代维公司代维人员ID
     * @return 代维公司代维人员信息
     */
    @Override
	public Emp selectEmpById(Integer empno)
	{
	    return empMapper.selectEmpById(empno);
	}

	/**
	 * 巡检人员根据手机号和密码登录
	 * @param phone
	 * @param password
	 * @return
	 */
	@Override
	public boolean empLogin(String phone, String password) {
		Emp emp = new Emp();
		emp.setPhone(phone);
		emp.setPassword(password);
		Emp emp1 = empMapper.selectEmp(emp);
		if (emp1 != null){
			return true;
		}
		return false;
	}

	@Override
	public Emp selectEmpByphone(String phone) {
		return empMapper.selectEmpByphone(phone);
	}

	/**
     * 查询代维公司代维人员列表
     * 
     * @param emp 代维公司代维人员信息
     * @return 代维公司代维人员集合
     */
	@Override
	public List<Emp> selectEmpList(Emp emp)
	{
	    return empMapper.selectEmpList(emp);
	}
	
    /**
     * 新增代维公司代维人员
     * 
     * @param emp 代维公司代维人员信息
     * @return 结果
     */
	@Override
	public int insertEmp(Emp emp)
	{
	    return empMapper.insertEmp(emp);
	}
	
	/**
     * 修改代维公司代维人员
     * 
     * @param emp 代维公司代维人员信息
     * @return 结果
     */
	@Override
	public int updateEmp(Emp emp)
	{
	    return empMapper.updateEmp(emp);
	}

	/**
     * 删除代维公司代维人员对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteEmpByIds(String ids)
	{
		return empMapper.deleteEmpByIds(Convert.toStrArray(ids));
	}
	
}
