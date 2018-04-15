import dao.StudentMapper;
import entity.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        InputStream in = Main.class.getResourceAsStream("resource/mybatis-cfg.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session =factory.openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);

        Student student = new Student();
//        student.setId(3);
//        student.setName("没想法的岁月");
//        student.setNumber(1995);
//        mapper.insertStudent(student);
//        mapper.selectStudentId(1);
        List<Student> students = mapper.selectAllStudent();
        session.commit();
        session.close();
    }
}
