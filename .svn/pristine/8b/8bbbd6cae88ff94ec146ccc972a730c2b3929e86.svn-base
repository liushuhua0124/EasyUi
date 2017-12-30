package cn.et.student.controller;

import java.io.File;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.et.student.entity.Result;
import cn.et.student.entity.Student;
import cn.et.student.servlet.StudentService;
import cn.et.student.utils.PageTools;

@Controller
public class StudentController {

	@Autowired
	StudentService studentService;

	// 查询方法
	@ResponseBody
	@RequestMapping(value = "/queryStudent", method = RequestMethod.GET)
	public PageTools queryStudent(String stuname, Integer page, Integer rows) {
		PageTools queryStudent = studentService.queryStudent(stuname, page,
				rows);
		return queryStudent;
	}

	// 删除方法
	@ResponseBody
	@RequestMapping(value = "/student/{stuid}", method = RequestMethod.DELETE)
	public Result deleteStudent(@PathVariable String stuid) {
		String[] split = stuid.split(",");
		Result Result = new Result();
		Result.setCode(1);
		try {
			for(int i = 0;i<split.length;i++){
				studentService.deleteStudent(Integer.parseInt(split[i]));
			}
		} catch (Exception e) {
			Result.setCode(0);
			Result.setMessage(e.getMessage());
		}
		return Result;
	}

	// 修改方法
	@ResponseBody
	@RequestMapping(value = "/student/{stuid}", method = RequestMethod.PUT)
	public Result updateStudent(@PathVariable Integer stuid, Student student) {
		student.setStuid(stuid);
		Result Result = new Result();
		Result.setCode(1);
		try {
			studentService.updateStudent(student);
		} catch (Exception e) {
			Result.setCode(0);
			Result.setMessage(e);
		}
		return Result;
	}

	// 新增方法
	@ResponseBody
	@RequestMapping(value = "/savestudent", method = RequestMethod.POST)
	public Result saveStudent(Student student,MultipartFile myImage) {
		Result Result = new Result();
		Result.setCode(1);
		try {
			//获取上传的文件名
			String fileName = myImage.getOriginalFilename();
			//文件存储的位置
			File destFile = new File("E:\\image\\"+fileName);
			myImage.transferTo(destFile);
			student.setPicture(fileName);
			studentService.saveStudent(student);
		} catch (Exception e) {
			Result.setCode(0);
			Result.setMessage(e);
		}
		return Result;
	}
	
	@RequestMapping("/query")
	public String add(){
		return "crud.html";
	}
}
