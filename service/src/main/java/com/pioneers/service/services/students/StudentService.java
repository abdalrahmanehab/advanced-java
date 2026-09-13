package com.pioneers.service.services.students;

import com.pioneers.service.errors.exceptions.StudentException;
import com.pioneers.service.models.dtos.requests.StudentUpdate;
import com.pioneers.service.models.dtos.responses.StudentResponse;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface StudentService {

    List<StudentResponse> findAllSortedByAge() throws StudentException;

    StudentResponse findById(UUID id) throws StudentException;

    Collection<StudentResponse> findAllSucceeded() throws StudentException;

    void update(UUID id, StudentUpdate studentUpdateRequest) throws StudentException;

    void deleteById(UUID id) throws StudentException;

    void deleteAll();
}
