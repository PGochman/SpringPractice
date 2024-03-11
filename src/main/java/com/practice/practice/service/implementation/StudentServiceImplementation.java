package com.practice.practice.service.implementation;

import com.practice.practice.dto.mapper.StudentMapper;
import com.practice.practice.dto.request.StudentCourseRequestDTO;
import com.practice.practice.dto.request.StudentRequestDTO;
import com.practice.practice.dto.response.StudentResponseDTO;
import com.practice.practice.exception.ExceptionAlreadyExists;
import com.practice.practice.exception.ExceptionDeletedData;
import com.practice.practice.exception.ExceptionNotFound;
import com.practice.practice.model.Course;
import com.practice.practice.model.Grade;
import com.practice.practice.model.Student;
import com.practice.practice.repository.StudentRepository;
import com.practice.practice.service.StudentService;
import com.practice.practice.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public StudentResponseDTO createStudent(StudentRequestDTO studentRequestDTO) throws ExceptionNotFound {
        Student objStudent = studentMapper.requestToStudent(studentRequestDTO);

        objStudent.setActive(true);
        if(studentRequestDTO.getCoursesId() != null){
            Set<Course> courses = courseService.getAllCoursesByIds(studentRequestDTO.getCoursesId());
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
    public StudentResponseDTO assignStudentToCourse(StudentCourseRequestDTO studentCourseRequestDTO) throws ExceptionNotFound, ExceptionAlreadyExists {
        Student objStudent = getStudentById(studentCourseRequestDTO.getStudentId());
        Course objCourse = courseService.getCourseById(studentCourseRequestDTO.getCourseId());

        if(!objStudent.getCourses().add(objCourse)){
            throw new ExceptionAlreadyExists();
        }

        objStudent.getCourses().add(objCourse);

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
    public StudentResponseDTO updateStudent(StudentRequestDTO studentRequestDTO) throws ExceptionNotFound {
        if(!getStudentById(studentRequestDTO.getId()).getActive()){
            throw new ExceptionDeletedData("El estudiante con ID: " + studentRequestDTO.getId() + " se encuentra desactivado", studentRequestDTO.getId(), "Student");
        }

        Student objStudentUpdate = studentMapper.requestToStudent(studentRequestDTO);

        if(studentRequestDTO.getCoursesId() != null){
            Set<Course> courses = courseService.getAllCoursesByIds(studentRequestDTO.getCoursesId());
            objStudentUpdate.setCourses(courses);
        }
        objStudentUpdate.setActive(true);

        studentRepository.save(objStudentUpdate);
        return studentMapper.studentToResponse(objStudentUpdate);
    }

    @Override
    public void deactivateStudent(Long id) throws ExceptionNotFound{
        Student objStudent = getStudentById(id);
        if(!objStudent.getActive()){
            throw new ExceptionDeletedData("Ya esta eliminado el  estudiante con el ID: " + id, id, "Student");
        }

        Set<Grade> grades = new HashSet<>();
        for(Grade grade : objStudent.getGrades()) {
            grade.setActive(false);
            grades.add(grade);
        }
        objStudent.setGrades(grades);

        objStudent.setCourses(new HashSet<>());
        objStudent.setActive(false);
        studentRepository.save(objStudent);
    }

    @Override
    public void restoreStudent(Long id) throws ExceptionNotFound{
        Student objStudent = getStudentById(id);
        if(objStudent.getActive()){
            throw new ExceptionDeletedData("Ya esta activado el  estudiante con el ID: " + id, id, "Student");
        }

        objStudent.setActive(true);
        studentRepository.save(objStudent);
    }
}
