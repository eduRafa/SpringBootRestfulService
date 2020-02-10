/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springbootrestfulservice.controller;

import com.springbootrestfulservice.exceptions.RecordNotFoundException;
import com.springbootrestfulservice.model.Categoria;
import com.springbootrestfulservice.services.CategoriaService;
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

/**
 *
 * @author Juan Antonio
 */
@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaService service;

    @GetMapping
    public ResponseEntity<List<Categoria>> getAllCategorias() {
        List<Categoria> categorias = service.getAllCategorias();
        return new ResponseEntity<List<Categoria>>(categorias, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(path="/{id}", produces = "application/json")
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        Categoria entity = service.getCategoriaById(id);
        return new ResponseEntity<Categoria>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Categoria> createCategoria(@Valid @RequestBody Categoria miCategoria) {
        Categoria created = service.createCategoria(miCategoria);
        return new ResponseEntity<Categoria>(created, new HttpHeaders(), HttpStatus.OK);
    }
    
        @GetMapping("/search/{title}")
    public ResponseEntity<List<Categoria>> getCategoriaByName(@PathVariable("title") String title) {
    	List<Categoria> list = service.getItemsByTitle(title);
 
        return new ResponseEntity<List<Categoria>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Categoria> UpdateCategoria(@Valid @RequestBody Categoria miCategoria)
            throws RecordNotFoundException {
        Categoria updated = service.createCategoria(miCategoria);
        return new ResponseEntity<Categoria>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteCategoriaById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        service.deleteCategoriaById(id);
        return HttpStatus.ACCEPTED;
    }
}
