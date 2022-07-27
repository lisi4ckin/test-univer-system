package com.example.services;

import com.example.entities.Groups;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class GroupService {

    public void addGroup(Groups group){
        Groups.addGroup(group);
    }

    public void deleteGroup(Long id){
        Groups.deleteGroup(id);
    }

    public List<Groups> getAllGroups(){
        return Groups.listAll();
    }
}
