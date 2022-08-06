package com.example.services;

import com.example.entities.Profile;
import com.example.entities.Student;
import com.example.errors.CustomException;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@ApplicationScoped
public class ProfileService {

    @ConfigProperty(name = "error.usernotfound")
    String userNotFound;
    @Inject
    EntityManager em;

    @Inject
    StudentService studentService;

    public void deleteProfile(Profile profile) throws CustomException {
        Query studentList = em.createQuery("SELECT stud from Student stud where stud.profileId = :profile_id");
        studentList.setParameter("profile_id", profile);
        List<Student> students = studentList.getResultList();
        if (students.size() == 0){
            throw new CustomException(userNotFound);
        }
        studentService.deleteStudent(students.get(0).id);
        Profile.deleteProfile(profile);
    }
}
