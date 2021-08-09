package com.pluralsite.conferencedemo.controllers;

import java.util.List;
import com.pluralsite.conferencedemo.models.Session;
import com.pluralsite.conferencedemo.repositories.SessionRepository;
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
@RequestMapping("/api/v1/sessions") //lets spring mvc know these are controllers
public class SessionsController {
    @Autowired
    private SessionRepository sessionRepository; //inject sessions repository

    @GetMapping
    public List<Session> list() {
        return sessionRepository.findAll(); //returns all sessions when called
    }

    @GetMapping
    @RequestMapping("{id}") //get session by id
    public Session get(@PathVariable Long id){
        return sessionRepository.getById(id);
    }

    @PostMapping //creates a new session in db
    // @ResponseStatus(HttpStatus.CREATED) //Specify exact response when method executes and finishes
    public Session create(@RequestBody final Session session){
        return sessionRepository.saveAndFlush(session);
    }

    @RequestMapping(value="{id}", method=RequestMethod.DELETE) //deletes session from db
    public void delete(@PathVariable Long id) {
        //Also need to check for chidren records before deleting
        sessionRepository.deleteById(id);
    }

    @RequestMapping(value="{id}", method = RequestMethod.PUT) //updates session in db
    public Session update(@PathVariable Long id, @RequestBody Session session){
        // becasue this is a PUT, we expect all attributes to be passed in, A PATCH would only need what
        // Add validation that all attributes are passed in, otherwise return a 400 bad payload
        Session existingSession = sessionRepository.getById(id);
        BeanUtils.copyProperties(session, existingSession, "session_id");
        return sessionRepository.saveAndFlush(existingSession);
    }

}
