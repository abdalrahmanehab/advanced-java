package com.pioneers.rest.utils.mappers;

import com.pioneers.rest.models.dtos.responses.StudentResponse;
import com.pioneers.rest.models.entities.Student;

public final class StudentMapper {
    private StudentMapper() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static StudentResponse toStudentResponse(final Student student) {
        return new StudentResponse(student.getFullName(), student.getAge(), student.getEmail());
    }
}
