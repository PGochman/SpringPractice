package com.practice.practice.service.implementation;

import com.practice.practice.dto.mapper.StudentMapper;
import com.practice.practice.dto.request.StudentCourseRequestDTO;
import com.practice.practice.dto.request.StudentRequestDTO;
import com.practice.practice.dto.response.StudentResponseDTO;
import com.practice.practice.exception.ExceptionDeletedData;
import com.practice.practice.exception.ExceptionNotFound;
import com.practice.practice.model.Course;
import com.practice.practice.model.Student;
import com.practice.practice.repository.StudentRepository;
import com.practice.practice.service.StudentService;
import com.practice.practice.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImplementation implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final CourseService courseService;
    public StudentServiceImplementation(StudentRepository studentRepository, StudentMapper studentMapper, CourseService courseService){
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
        this.courseService = courseService;
    }

    @Override
    public StudentResponseDTO createAlumno(StudentRequestDTO studentRequestDTO) throws ExceptionNotFound {
        Student objStudent = studentMapper.requestToStudent(studentRequestDTO);

        if(studentRequestDTO.getCoursesId() != null){
            List<Course> courses = courseService.getAllCoursesByIds(studentRequestDTO.getCoursesId());
            objStudent.setCourses(courses);
        }

        studentRepository.save(objStudent);
        return studentMapper.studentToResponse(objStudent);
    }
    @Override
    public Student getStudentById(Long studentId) throws ExceptionNotFound {
        return studentRepository.findById(studentId).orElseThrow(() -> new ExceptionNotFound("Alumno", "ID", studentId.toString()));
    }

    @Override
    public StudentResponseDTO asignStudentToCourse(StudentCourseRequestDTO studentCourseRequestDTO) throws ExceptionNotFound {
        Student objStudent = getStudentById(studentCourseRequestDTO.getStudentId());
        Course objCourse = courseService.getCourseById(studentCourseRequestDTO.getCourseId());

        objStudent.addCourse(objCourse);
        studentRepository.save(objStudent);
        return studentMapper.studentToResponse(objStudent);
    }

    @Override
    public StudentResponseDTO findStudentById(Long id) throws ExceptionNotFound{
        Student objStudent = getStudentById(id);
        return studentMapper.studentToResponse(objStudent);
    }

    @Override
    public List<StudentResponseDTO> findAllStudents(){
        List<Student> students = studentRepository.findAll();
        return studentMapper.studentListToResponseList(students);
    }

    @Override
    public StudentResponseDTO updateStudent(Long id, StudentRequestDTO studentRequestDTO) throws ExceptionNotFound {
        Student objStudent = getStudentById(id);

        if(studentRequestDTO.getCoursesId() != null){
            List<Course> courses = courseService.getAllCoursesByIds(studentRequestDTO.getCoursesId());
            objStudent.setCourses(courses);
        }
        objStudent.setAddress(studentRequestDTO.getAddress());
        objStudent.setDni(studentRequestDTO.getDni().toString());
        objStudent.setBirthDate(studentRequestDTO.getBirthDate());
        objStudent.setLastName(studentRequestDTO.getLastName());
        objStudent.setName(studentRequestDTO.getName());

        studentRepository.save(objStudent);
        return studentMapper.studentToResponse(objStudent);
    }

    @Override
    public StudentResponseDTO deleteStudent(Long id) throws ExceptionNotFound{
        Student objStudent = getStudentById(id);
        if(objStudent.getActive()){
            objStudent.setActive(false);
        } else {
            throw new ExceptionDeletedData("Ya esta eliminado el  estudiante con el ID: " + id, id, "Student");
        }
        return studentMapper.studentToResponse(objStudent);
    }
}
