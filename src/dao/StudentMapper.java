package dao;

import entity.Student;

import java.util.List;

/**
 * 这是一个查询数据库的接口
 * Created by 平凡的世界 on 2018/4/15.
 */
public interface StudentMapper {
    //修改数据库
    int insertStudent(Student student) throws Exception;
    //查询一条数据的情况
    Student selectStudentId(int i) throws Exception;
    //查询出多条数据的情况
    List<Student> selectAllStudent();

}
