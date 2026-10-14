package in.strikes.CRUDspringBootDemo.controller;

import in.strikes.CRUDspringBootDemo.entity.Student;
import in.strikes.CRUDspringBootDemo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Tells sb that this is a controller class.It contains @Component.
@RestController //Tells that this is a controller class, which handles web request and returns response.
@RequestMapping("/api/students") //Sets a common url prefix for all endpoints in the class.
public class StudentController  {

    private StudentService studentService;
    public StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }
    //Create student
    //For the parameter, inside post parameter..the create is given right , whenever a post request will be sent
    //we will have to give /create at the end of the request in order to run the given method.
    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student)
    {
        System.out.println("Inside student controller.");
        Student createStudent = studentService.createStudent(student);
        System.out.println("Exiting student controller.");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createStudent);
    }
    //Read student.
    @GetMapping("/get/{id}")
public ResponseEntity<Student> getStudent(@PathVariable Long id)
{
    Student studentResp = studentService.getStudent(id);

    if(studentResp == null){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    return ResponseEntity.ok(studentResp);

}

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudent()
    {
        List<Student> studentList = studentService.getAllStudent();

        if(studentList.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentList);

    }
    //Update Student.
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student)
    {

        Student studentResp = studentService.updateStudent(id,student);

        if(studentResp == null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentResp);
    }
    //Delete Student.
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id)
    {
        Boolean isDeleted = studentService.deleteStudent(id);
        if(!isDeleted)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Record deleted.");
    }
}
