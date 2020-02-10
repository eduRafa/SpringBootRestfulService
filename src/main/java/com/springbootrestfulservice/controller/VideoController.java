package com.springbootrestfulservice.controller;

import com.springbootrestfulservice.exceptions.RecordNotFoundException;
import com.springbootrestfulservice.model.Video;
import com.springbootrestfulservice.services.VideoService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/video")
public class VideoController {
    
    @Autowired
    VideoService service;
 
    @GetMapping
    public ResponseEntity<List<Video>> getAllVideos() {
        List<Video> list = service.getAllVideos();
        return new ResponseEntity<List<Video>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping(path="/{id}", produces = "application/json")
    public ResponseEntity<Video> getVideoById(@PathVariable("id") Long id)throws RecordNotFoundException {
    	Video entity = service.getVideoById(id);
        return new ResponseEntity<Video>(entity, new HttpHeaders(), HttpStatus.OK);
    }
    
    @GetMapping(path="/search/{quant}", produces = "application/json")
    public ResponseEntity<List<Video>> getVideosByVisitas(@PathVariable("quant") int quant) {
    	List<Video> list = service.getVideosByVisitas(quant);
        return new ResponseEntity<List<Video>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
   @PostMapping
    public ResponseEntity<Video> createVideo(@Valid @RequestBody Video myVideo){
    	Video created = service.createVideo(myVideo);
        return new ResponseEntity<Video>(created, new HttpHeaders(), HttpStatus.OK);
    }
    
    @PutMapping
    public ResponseEntity<Video> UpdateVideo(@Valid @RequestBody Video myVideo)throws RecordNotFoundException {
    	Video updated = service.createVideo(myVideo);
        return new ResponseEntity<Video>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping(path="/{id}", produces = "application/json")
    public HttpStatus deleteVideoById(@PathVariable("id") Long id)throws RecordNotFoundException {
        service.deleteVideoById(id);
        return HttpStatus.ACCEPTED;
    }
}
