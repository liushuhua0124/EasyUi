package cn.et.student.servlet.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.student.dao.StudentMapper;
import cn.et.student.entity.Student;
import cn.et.student.entity.StudentExample;
import cn.et.student.entity.StudentExample.Criteria;
import cn.et.student.servlet.StudentService;
import cn.et.student.utils.PageTools;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentMapper studentMapper;

	public PageTools queryStudent(String stuname, Integer page, Integer rows) {
		if (stuname == null) {
			stuname = "";
		}
		StudentExample studentExample = new StudentExample();
		Criteria createCriteria = studentExample.createCriteria();
		createCriteria.andStunameLike("%" + stuname + "%");
		// 查询总记录数
		Integer queryStudentCount = queryStudentCount(studentExample);
		PageTools PageTools = new PageTools(page, queryStudentCount, rows);
		RowBounds RowBounds = new RowBounds(PageTools.getStartIndex() - 1, rows);
		List<Student> selectByExampleWithRowbounds = studentMapper
				.selectByExampleWithRowbounds(studentExample, RowBounds);
		PageTools.setRows(selectByExampleWithRowbounds);
		return PageTools;
	}

	// 查询总条数
	public Integer queryStudentCount(StudentExample studentExample) {
		Integer countByExample = studentMapper.countByExample(studentExample);
		return countByExample;
	}

	// 删除方法
	public void deleteStudent(Integer stuid) {
		studentMapper.deleteByPrimaryKey(stuid);
	}

	// 修改方法
	public void updateStudent(Student student) {
		studentMapper.updateByPrimaryKey(student);
	}

	// 新增方法
	public void saveStudent(Student student) {
		studentMapper.insert(student);
	}
}
