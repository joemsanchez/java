package com.emrops.cdecodes.controllers;

import java.util.List;
import com.emrops.cdecodes.models.GroupModel;
import com.emrops.cdecodes.Repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/groups")
public class GroupsController {
    @Autowired
    private GroupRepository groupRepository;

    @GetMapping
    public List<GroupModel> list(){
        return groupRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public GroupModel get(@PathVariable Long id){
        return groupRepository.getById(id);
    }

}
