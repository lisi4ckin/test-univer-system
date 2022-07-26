package com.example.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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
}
