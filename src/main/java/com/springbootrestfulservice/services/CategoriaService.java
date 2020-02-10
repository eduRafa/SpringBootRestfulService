/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springbootrestfulservice.services;

import com.springbootrestfulservice.exceptions.RecordNotFoundException;
import com.springbootrestfulservice.model.Categoria;
import com.springbootrestfulservice.repositories.CategoriaRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Antonio
 */
@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repository;

    public List<Categoria> getAllCategorias() {
        List<Categoria> categorias = repository.findAll();
        return categorias;
    }

    public Categoria getCategoriaById(Long id) {
        Optional<Categoria> categoria = repository.findById(id);

        if (categoria.isPresent()) {
            return categoria.get();
        } else {
            throw new RecordNotFoundException("No item record exist for given id", id);
        }
    }

    public Categoria createCategoria(Categoria entity) {
        entity = repository.save(entity);
        return entity;
    }

    public Categoria UpdateCategoria(Categoria entity) throws RecordNotFoundException {
        if (entity.getId() != null) {
            Optional<Categoria> categoria = repository.findById(entity.getId());

            if (categoria.isPresent()) {
                Categoria newEntity = categoria.get();
                //newEntity.setId(entity.getId());
                newEntity.setNombre(entity.getNombre());
                newEntity.setVideoSet(entity.getVideoSet());
                newEntity = repository.save(newEntity);

                return newEntity;
            } else {
                throw new RecordNotFoundException("Item not found", Long.valueOf(entity.getId()));
            }
        } else {
            throw new RecordNotFoundException("No id of item given", 0l);
        }
    }

    public void deleteCategoriaById(Long id) throws RecordNotFoundException {
        Optional<Categoria> categoria = repository.findById(id);

        if (categoria.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No item record exist for given id", id);
        }
    }
    
 public List<Categoria> getItemsByTitle(String title) {
        List<Categoria> itemList = repository.getByName(title);
         
        if(itemList.size() > 0) {
            return itemList;
        } else {
            return new ArrayList<Categoria>();
        }
    }

}
