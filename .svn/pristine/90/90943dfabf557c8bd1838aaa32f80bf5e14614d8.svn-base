package cn.et.student.servlet.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.student.dao.EmpMapper;
import cn.et.student.entity.Emp;
import cn.et.student.entity.EmpExample;
import cn.et.student.entity.EmpExample.Criteria;
import cn.et.student.servlet.EmpService;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpMapper empMapper;

	// 查询员工信息
	public List<Emp> queryEmp(Integer did) {
		EmpExample EmpExample = new EmpExample();
		Criteria createCriteria = EmpExample.createCriteria();
		if (did != null) {
			createCriteria.andDidEqualTo(did);
		}
		List<Emp> selectByExample = empMapper.selectByExample(EmpExample);
		return selectByExample;
	}

	// 删除员工信息
	public void deleteEmp(Integer eid) {
		empMapper.deleteByPrimaryKey(eid);
	}

	// 新增员工信息
	public void saveEmp(Emp emp) {
		empMapper.insert(emp);
	}

	// 修改员工信息
	public void updateEmp(Emp emp) {
		empMapper.updateByPrimaryKey(emp);
	}

}
