import dao.StudentMapper;
import dao.TeacherMapper;
import entity.Student;
import entity.Teacher;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        //使用流的形式读取数据资源resource/mybatis-cfg.xml 文件信息
        InputStream in = Main.class.getResourceAsStream("resource/mybatis-cfg.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session =factory.openSession();
//        StudentMapper mapper = session.getMapper(StudentMapper.class);
//        Student student = new Student();
//        student.setId(3);
//        student.setName("没想法的岁月");
//        student.setNumber(1995);
//        mapper.insertStudent(student);
//        mapper.selectStudentId(1);
        //一对一查询
//         Student student1 = mapper.selectByPrimaryKeyWithTeacher(1);
        //一对多查询
//        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
//        Teacher teacher = new Teacher();
//        teacher = mapper.selectByPrimaryKeyWithStudent(1);
        //插入返回主键
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);

        TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);

//        Teacher  teacher = new Teacher();
//        teacher.setTeacherName("我是老师");
//        teacher.setPassword("cww123456");
//        teacherMapper.insertSelective(teacher);
//        Student student = new Student();
//        student.setStudentName("我是学生");
//        student.setStudentNumber(7788);
//        student.setsId(teacher.gettId());
//        studentMapper.insertSelective(student);
        //传入一个集合查询参数
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        List<Teacher> teachers = teacherMapper.selectByTids(ids);
        session.commit();
        session.close();
    }
}
