/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springbootrestfulservice.controller;

import com.springbootrestfulservice.exceptions.RecordNotFoundException;
import com.springbootrestfulservice.model.Youtuber;
import com.springbootrestfulservice.services.YoutuberService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rafae
 */
@RestController
@RequestMapping("/youtuber")
public class YoutuberController {

    @Autowired
    YoutuberService service;

    @GetMapping
    public ResponseEntity<List<Youtuber>> getAllYoutubers() {
        List<Youtuber> list = service.getAllYoutubers();
        return new ResponseEntity<List<Youtuber>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping(path="/{id}", produces = "application/json")
    public ResponseEntity<Youtuber> getYoutuberById(@PathVariable("id") Long id)throws RecordNotFoundException {
    	Youtuber entity = service.getYoutuberById(id);
        return new ResponseEntity<Youtuber>(entity, new HttpHeaders(), HttpStatus.OK);
    }
    
    @GetMapping(path="/search/{name}", produces = "application/json")
    public ResponseEntity<List<Youtuber>> getYoutubersByTitle(@PathVariable("name") String name) {
        List<Youtuber> list = service.getYoutubersByName(name);
        return new ResponseEntity<List<Youtuber>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Youtuber> createYoutuber(@Valid @RequestBody Youtuber myYoutuber) {
        Youtuber created = service.createYoutuber(myYoutuber);
        return new ResponseEntity<Youtuber>(created, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Youtuber> UpdateYoutuber(@Valid @RequestBody Youtuber myYoutuber) throws RecordNotFoundException {
        Youtuber updated = service.createYoutuber(myYoutuber);
        return new ResponseEntity<Youtuber>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping(path="/{id}", produces = "application/json")
    public HttpStatus deleteYoutuberById(@PathVariable("id") Long id)throws RecordNotFoundException {
        service.deleteYoutuberById(id);
        return HttpStatus.ACCEPTED;
    }
}
