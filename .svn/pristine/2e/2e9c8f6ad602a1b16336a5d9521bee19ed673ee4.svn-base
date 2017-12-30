package cn.et.student.servlet.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.student.dao.DeptMapper;
import cn.et.student.entity.Dept;
import cn.et.student.entity.DeptExample;
import cn.et.student.entity.TreeNode;
import cn.et.student.entity.DeptExample.Criteria;
import cn.et.student.servlet.DeptService;

@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	DeptMapper deptMapper;

	public List<TreeNode> queryTreeNode(Integer pid) {
		DeptExample DeptExample = new DeptExample();
		Criteria createCriteria = DeptExample.createCriteria();
		createCriteria.andPidEqualTo(pid);
		List<Dept> selectByExample = deptMapper.selectByExample(DeptExample);
		List<TreeNode> deptList = new ArrayList<TreeNode>();
		for (Dept dept : selectByExample) {
			TreeNode TreeNode = new TreeNode();
			TreeNode.setId(dept.getDid());
			TreeNode.setText(dept.getDname());
			// /判断当前节点下是否还存在子节点
			if (queryTreeNode(dept.getDid()).size() == 0) {
				TreeNode.setState("open");
			}
			deptList.add(TreeNode);
		}
		return deptList;
	}

	public List<Dept> queryDept() {
		List<Dept> queryDept = deptMapper.queryDept();
		return queryDept;
	}
}
