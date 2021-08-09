package com.pluralsite.conferencedemo.controllers;

import java.util.List;

import com.pluralsite.conferencedemo.models.Speaker;
import com.pluralsite.conferencedemo.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/api/v1/speakers") //lets spring mvc know these are controllers
public class SpeakersController {
    @Autowired
    private SpeakerRepository speakerRepository; //inject speaker repository

    @GetMapping
    public List<Speaker> list() {
        return speakerRepository.findAll(); //returns all speakers when called
    }

    @GetMapping
    @RequestMapping("{id}") //get speaker by id
    public Speaker get(@PathVariable Long id){
        return speakerRepository.getById(id);
    }

    @PostMapping //creates a new speaker in db
    // @ResponseStatus(HttpStatus.CREATED) //Specify exact response when method executes and finishes
    public Speaker create(@RequestBody final Speaker speaker){
        return speakerRepository.saveAndFlush(speaker);
    }

    @RequestMapping(value="{id}", method=RequestMethod.DELETE) //deletes speaker from db
    public void delete(@PathVariable Long id) {
        //Also need to check for chidren records before deleting
        speakerRepository.deleteById(id);
    }

    @RequestMapping(value="{id}", method = RequestMethod.PUT) //updates speaker in db
    public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker){
        // becasue this is a PUT, we expect all attributes to be passed in, A PATCH would only need what
        // Add validation that all attributes are passed in, otherwise return a 400 bad payload
        Speaker existingSpeaker = speakerRepository.getById(id);
        BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
        return speakerRepository.saveAndFlush(existingSpeaker);
    }

}
