package ru.system.student.controller;

import ru.system.student.dto.DeleteStudentDTO;
import ru.system.student.dto.GetStudentDTO;
import ru.system.student.dto.SaveStudentDTO;
import ru.system.student.model.Faculty;
import ru.system.student.service.Impl.StudentServiceImpl;
import ru.system.student.service.StudentService;

import static ru.system.student.database.Database.FACULTIES;
import static ru.system.student.validation.StudentValidation.validateSeriaAndNumber;

public class StudentController {

    StudentService studentService = new StudentServiceImpl();

    public String getStudent(GetStudentDTO getStudentDTO) {
        String validationMess = validateSeriaAndNumber(getStudentDTO.getNumber(), getStudentDTO.getSeria());
        if (validationMess == null) {
            return studentService.getStudent(getStudentDTO.getSeria(), getStudentDTO.getNumber());
        } else {
            return validationMess;
        }
    }

    public boolean deleteStudent(DeleteStudentDTO deleteStudentDTO) {
        if (deleteStudentDTO.getSeria().length() != 4) {
            return false;
        }
        if (deleteStudentDTO.getNumber().length() != 6) {
            return false;
        }
        return studentService.deleteStudent(deleteStudentDTO.getSeria(), deleteStudentDTO.getNumber());
    }

    public boolean saveStudent(SaveStudentDTO saveStudentDTO) {
        Faculty faculty = FACULTIES
                .stream()
                .filter(facValue -> facValue.getName().equals(saveStudentDTO.getFacultyName()))
                .findFirst()
                .orElse(null);
        if (faculty != null) {
        return studentService.saveStudent(saveStudentDTO.getName(), saveStudentDTO.getLastName(),
                saveStudentDTO.getSeria(), saveStudentDTO.getNumber(), saveStudentDTO.getBirthDate(),
                saveStudentDTO.getBirthPlace(), faculty, saveStudentDTO.getPhoneNumber(),
                saveStudentDTO.getEMail(),  saveStudentDTO.getAddress());
        } else {
            return false;
        }
    }
}
