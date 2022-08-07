package com.example.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import javax.transaction.Transactional;
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



    @Transactional
    public static void addGroup(Groups group){
        group.persist();
    }

    @Transactional
    public static void deleteGroup(Long id){
        Groups.deleteById(id);
    }

    @Transactional
    public static void updateGroup(Groups group){
        Groups updateGroup = Groups.findById(group.id);
        updateGroup.persist();
    }
}
