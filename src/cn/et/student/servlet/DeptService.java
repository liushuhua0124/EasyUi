package cn.et.student.servlet;

import java.util.List;

import cn.et.student.entity.Dept;
import cn.et.student.entity.TreeNode;

public interface DeptService {
	public List<TreeNode> queryTreeNode(Integer pid);
	
	public List<Dept> queryDept();
}
