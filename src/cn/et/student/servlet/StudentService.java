package cn.et.student.servlet;

import java.util.List;

import cn.et.student.entity.Student;
import cn.et.student.entity.StudentExample;
import cn.et.student.utils.PageTools;

public interface StudentService {
	// 查询学生信息
	public PageTools queryStudent(String stuname, Integer page, Integer rows);

	// 查询总条数
	public Integer queryStudentCount(StudentExample studentExample);

	// 删除学生信息
	public void deleteStudent(Integer stuid);

	// 修改方法
	public void updateStudent(Student student);

	// 新增方法
	public void saveStudent(Student student);
}
