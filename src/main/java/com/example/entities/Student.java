package com.example.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.transaction.Transactional;

@Entity
public class Student extends PanacheEntity {
    //main info about user
    private String username;
    private String password;

    //one to one connection for user Profile
    @OneToOne
    @JoinColumn(name = "profile_id")
    private Profile profileId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile getProfileId() {
        return profileId;
    }

    public void setProfileId(Profile profileId) {
        this.profileId = profileId;
    }

    @Transactional
    public static void addStudent(Student student){
        Profile profile = new Profile();
        profile.persist();
        student.setProfileId(profile);
        student.persist();
    }

    @Transactional
    public static void deleteStudent(Long id){
        Student.deleteById(id);
    }

    @Transactional
    public static void updateStudent(Student student){
        Student updateStudent = Student.findById(student.id);
        updateStudent.persist();
    }
}
