package com.springbootrestfulservice.services;

import com.springbootrestfulservice.exceptions.RecordNotFoundException;
import com.springbootrestfulservice.model.Video;
import com.springbootrestfulservice.services.VideoService;
import com.springbootrestfulservice.repositories.VideoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
public class VideoService {
    
    @Autowired
    VideoRepository repository;
     
    public List<Video> getAllVideos()
    {
        List<Video> itemList = repository.findAll();
         
        if(itemList.size() > 0) {
            return itemList;
        } else {
            return new ArrayList<Video>();
        }
    }
     
    public Video getVideoById(Long id) throws RecordNotFoundException
    {
        Optional<Video> item = repository.findById(id);
         
        if(item.isPresent()) {
            return item.get();
        } else {
            throw new RecordNotFoundException("No item record exist for given id",id);
        }
    }
    public Video createVideo(Video entity){
        entity = repository.save(entity);
        return entity;
    }
    public Video UpdateVideo(Video entity) throws RecordNotFoundException
    {
    	    	
    	if(entity.getId()!=null)
    	{
    	       Optional<Video> item = repository.findById(entity.getId());
        
            if(item.isPresent())
            {
                Video newEntity = item.get();
                //newEntity.setId(entity.getId());
                newEntity.setVisualizaciones(entity.getVisualizaciones());
                newEntity.setLikes(entity.getLikes());
                newEntity.setDislikes(entity.getDislikes());
                newEntity.setYoutuber(entity.getYoutuber());
                newEntity.setCategoria(entity.getCategoria());
                newEntity = repository.save(newEntity);

                return newEntity;
            } else {
                throw new RecordNotFoundException("Video not found",entity.getId());
            }
        }else{
    		throw new RecordNotFoundException("No id of item given",0l);
    	}	    
 }
     
    public void deleteVideoById(Long id) throws RecordNotFoundException
    {
        Optional<Video> item = repository.findById(id);
         
        if(item.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No item record exist for given id",id);
        }
    }

    public List<Video> getVideosByVisitas(int quantity) {
        List<Video> itemList = repository.findByVisualizaciones(quantity);
         
        if(itemList.size() > 0) {
            return itemList;
        } else {
            return new ArrayList<Video>();
        }
    }
}
