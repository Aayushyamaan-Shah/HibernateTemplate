package sem_5.service;

import org.springframework.stereotype.Service;
import sem_5.dao.Student.StudentDAO;
import sem_5.model.Student;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentDAO studentDAO;

    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

//    @Override
    @Transactional
    public void addStudent(Student p) {
        this.studentDAO.addStudent(p);
    }

  //  @Override
    @Transactional
    public void updateStudent(Student p) {
        this.studentDAO.updateStudent(p);
    }

    //@Override
    @Transactional
    public List<Student> listStudents() {
        return this.studentDAO.listStudents();
    }

//    @Override
    @Transactional
    public Student getStudentById(int id) {
        return this.studentDAO.getStudentById(id);
    }

    //@Override
    @Transactional
    public void removeStudent(int id) {
        this.studentDAO.removeStudent(id);
    }
}
