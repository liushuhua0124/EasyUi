package cn.et.student.servlet;

import java.util.List;

import cn.et.student.entity.Student;
import cn.et.student.entity.StudentExample;
import cn.et.student.utils.PageTools;

public interface StudentService {
	// ��ѯѧ����Ϣ
	public PageTools queryStudent(String stuname, Integer page, Integer rows);

	// ��ѯ������
	public Integer queryStudentCount(StudentExample studentExample);

	// ɾ��ѧ����Ϣ
	public void deleteStudent(Integer stuid);

	// �޸ķ���
	public void updateStudent(Student student);

	// ��������
	public void saveStudent(Student student);
}