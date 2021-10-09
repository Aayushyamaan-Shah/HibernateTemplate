package sem_5.dao.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import sem_5.model.Student;

import java.util.List;


@Repository
public class StudentDAOImpl implements StudentDAO {

    private static final Logger logger = LoggerFactory.getLogger(StudentDAOImpl.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //@Override
    public void addStudent(Student p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("Student Record Inserted Successfully " + p);
    }

    //@Override
    public void updateStudent(Student p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("Successfully Updated ... "+p);
    }

    //@Override
    public List<Student> listStudents() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Student> studentsList = session.createQuery("from Student").list();

        return studentsList;
    }

    //@Override
    public Student getStudentById(int id) {
        Session session = this.sessionFactory.getCurrentSession();

        return (Student) session.load(Student.class,new Integer(id));
    }

    //@Override
    public void removeStudent(int id) {
        Session session = this.sessionFactory.getCurrentSession();

        Student st =  (Student) session.load(Student.class, new Integer(id));

        session.delete(st);
        logger.info("Successfully Removed ..!!" + id);
    }
}
