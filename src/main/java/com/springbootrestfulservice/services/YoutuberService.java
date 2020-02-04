/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springbootrestfulservice.services;

import com.springbootrestfulservice.exceptions.RecordNotFoundException;
import com.springbootrestfulservice.model.Youtuber;
import com.springbootrestfulservice.repositories.YoutuberRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rafae
 */
@Service
public class YoutuberService {

    @Autowired
    YoutuberRepository repository;

    public List<Youtuber> getAllYoutubers() {
        List<Youtuber> itemList = repository.findAll();

        if (itemList.size() > 0) {
            return itemList;
        } else {
            return new ArrayList<>();
        }
    }

    public Youtuber getYoutuberById(Long id) throws RecordNotFoundException {
        Optional<Youtuber> item = repository.findById(id);

        if (item.isPresent()) {
            return item.get();
        } else {
            throw new RecordNotFoundException("No item record exist for given id", id);
        }
    }

    public Youtuber createYoutuber(Youtuber entity) {
        entity = repository.save(entity);
        return entity;
    }

    public Youtuber UpdateYoutuber(Youtuber entity) throws RecordNotFoundException {

        if (entity.getId() != null) {
            Optional<Youtuber> item = repository.findById(entity.getId());

            if (item.isPresent()) {
                Youtuber newEntity = item.get();
                //newEntity.setId(entity.getId());
               // newEntity.setTitle(entity.getTitle());
                //newEntity.setDescription(entity.getDescription());

                newEntity = repository.save(newEntity);

                return newEntity;
            } else {
                throw new RecordNotFoundException("Youtuber not found", entity.getId());
            }
        } else {
            throw new RecordNotFoundException("No id of item given", 0l);
        }
    }

    public void deleteYoutuberById(Long id) throws RecordNotFoundException {
        Optional<Youtuber> item = repository.findById(id);

        if (item.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No item record exist for given id", id);
        }
    }

    public List<Youtuber> getYoutubersByTitle(String title) {
        /*List<Youtuber> itemList = repository.getByTitle(title);

        if (itemList.size() > 0) {
            return itemList;
        } else {
            return new ArrayList<Youtuber>();
        }*/
        return null;
    }
}
