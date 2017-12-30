package cn.et.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.et.student.entity.Dept;
import cn.et.student.entity.TreeNode;
import cn.et.student.servlet.DeptService;

@Controller
public class DeptController {

	@Autowired
	DeptService deptService;

	@ResponseBody
	@RequestMapping("/queryDept")
	public List<TreeNode> queryDept(Integer id) {
		if (id == null) {
			id = 0;
		}
		List<TreeNode> queryTreeNode = deptService.queryTreeNode(id);
		return queryTreeNode;
	}
	
	@ResponseBody
	@RequestMapping("/queryDeptAll")
	public List<Dept> query(){
		List<Dept> queryDept = deptService.queryDept();
		return queryDept;
	}
	
	@ResponseBody
	@RequestMapping("/query")
	public String queryAll(){
		return null;
	}
}
