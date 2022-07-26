package com.example.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Groups extends PanacheEntity {

    private String groupName;
    private String levelName;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Profile> studentsId;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public List<Profile> getStudentsId() {
        return studentsId;
    }

    public void setStudentsId(List<Profile> studentsId) {
        this.studentsId = studentsId;
    }
}