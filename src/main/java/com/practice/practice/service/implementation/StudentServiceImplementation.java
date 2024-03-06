package com.practice.practice.service.implementation;

import com.practice.practice.dto.mapper.StudentMapper;
import com.practice.practice.dto.request.StudentCourseRequestDTO;
import com.practice.practice.dto.request.StudentRequestDTO;
import com.practice.practice.dto.response.StudentResponseDTO;
import com.practice.practice.exception.ExceptionNotFound;
import com.practice.practice.model.Course;
import com.practice.practice.model.Student;
import com.practice.practice.repository.StudentRepository;
import com.practice.practice.service.StudentService;
import com.practice.practice.service.CourseService;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        //List<Course> courses = new ArrayList<>();
        if(studentRequestDTO.getCoursesId() != null){
            List<Course> courses = courseService.getAllCoursesByIds(studentRequestDTO.getCoursesId());
            objStudent.setCourses(courses);
        }
        studentRepository.save(objStudent);
        return studentMapper.studentToResponse(objStudent);
    }
    @Override
    public Student findStudentById(Long studentId) throws ExceptionNotFound {
        return studentRepository.findById(studentId).orElseThrow(() -> new ExceptionNotFound("Alumno", "ID", studentId.toString()));
    }

    @Override
    public StudentResponseDTO asignStudentToCourse(StudentCourseRequestDTO studentCourseRequestDTO) throws ExceptionNotFound {
        Student objStudent = findStudentById(studentCourseRequestDTO.getStudentId());
        Course objCourse = courseService.findCourseById(studentCourseRequestDTO.getCourseId());
        //objCourse.getStudents().add(objStudent);
        objStudent.addCourse(objCourse);
        studentRepository.save(objStudent);
        return studentMapper.studentToResponse(objStudent);
    }

    @Override
    public List<Student> getAllStudentsByIds(List<Long> studentsIds) throws ExceptionNotFound {
        List<Student> students = new ArrayList<>();
        for (Long id: studentsIds){
            Student student = findStudentById(id);
            if(student.getId() != null){
                students.add(student);
            }
        }
        return students;
    }

    @Override
    public List<StudentResponseDTO> getAllStudentsByCourseId(Long id) throws ExceptionNotFound{
        List<Student> students = new ArrayList<>();
        for(Student student : studentRepository.findAll()){
            for(Course course : student.getCourses()){
                if(Objects.equals(course.getId(), id)){
                    students.add(student);
                }
            }
        }
        return studentMapper.studentListToResponseList(students);
    }
}
