package in.strikes.CRUDspringBootDemo.service;

import in.strikes.CRUDspringBootDemo.entity.Student;
import in.strikes.CRUDspringBootDemo.repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Tells that this is a service class which contains business logic.
public class StudentService {
    private StudentRepository repository;
    public StudentService(StudentRepository repository)
    {
        this.repository = repository;
    }
    public Student createStudent(Student studentReq)
    {
    Student studentResp = repository.save(studentReq);
    return studentResp;
    }

    public Student getStudent(Long id) {
        Optional<Student> studentResp = repository.findById(id);
        if(studentResp.isPresent())
        {
            return studentResp.get();
        }
        return null;
    }
    public List<Student> getAllStudent()
    {
        List<Student> studentList = repository.findAll();
        return studentList;
    }

    public Student updateStudent(Long id, Student studentReq)
    {
        Optional<Student> existingStudent = repository.findById(id);
        if(existingStudent.isEmpty())
        {
            return null;
        }
        Student studentToSave = existingStudent.get();
        studentToSave.setName(studentReq.getName());
        studentToSave.setRollNo(studentReq.getRollNo());
        studentToSave.setSubject(studentReq.getSubject());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setEmail(studentReq.getEmail());

        return repository.save(studentToSave);
    }
    public Boolean deleteStudent(Long id)
    {
        Boolean isStudent = repository.existsById(id);
        if(!isStudent)
            return false;
        repository.deleteById(id);
        return true;
    }
}
