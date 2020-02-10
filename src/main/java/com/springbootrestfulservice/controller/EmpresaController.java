package com.springbootrestfulservice.controller;

import com.springbootrestfulservice.exceptions.RecordNotFoundException;
import com.springbootrestfulservice.model.Empresa;
import com.springbootrestfulservice.services.EmpresaService;
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
 * @author david
 */
@RestController
@RequestMapping("/empresa")
public class EmpresaController {
    
    @Autowired
    EmpresaService service;
    
    @GetMapping
    public ResponseEntity<List<Empresa>> getAllEmpresas() {
        List<Empresa> list = service.getAllEmpresas();
        return new ResponseEntity<List<Empresa>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Empresa> getEmpresaById(@PathVariable("id") Long id)throws RecordNotFoundException {
    	Empresa entity = service.getEmpresaById(id);
        return new ResponseEntity<Empresa>(entity, new HttpHeaders(), HttpStatus.OK);
    }
    
    @GetMapping("/search/{name}")
    public ResponseEntity<List<Empresa>> getEmpresasByNombre(@PathVariable("name") String name) {
    	List<Empresa> list = service.getEmpresasByNombre(name);
        return new ResponseEntity<List<Empresa>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Empresa> createEmpresa(@Valid @RequestBody Empresa myEmpresa){
    	Empresa created = service.createEmpresa(myEmpresa);
        return new ResponseEntity<Empresa>(created, new HttpHeaders(), HttpStatus.OK);
    }
    
    @PutMapping
    public ResponseEntity<Empresa> UpdateEmpresa(@Valid @RequestBody Empresa myEmpresa)throws RecordNotFoundException {
    	Youtuber updated = service.createYoutuber(myYoutuber);
        return new ResponseEntity<Youtuber>(updated, new HttpHeaders(), HttpStatus.OK);
    }
    
    
}
