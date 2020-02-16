package com.springbootrestfulservice.services;

import com.springbootrestfulservice.exceptions.RecordNotFoundException;
import com.springbootrestfulservice.model.Empresa;
import com.springbootrestfulservice.repositories.EmpresaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author david
 */
@Service
public class EmpresaService {
    
    @Autowired
    EmpresaRepository repository;
    
    public List<Empresa> getAllEmpresas() {
        List<Empresa> empresaList = repository.findAll();
         
        if(empresaList.size() > 0) {
            return empresaList;
        } else {
            return new ArrayList<Empresa>();
        }
    }
     
    public Empresa getEmpresaById(Long id) throws RecordNotFoundException {
        Optional<Empresa> empresa = repository.findById(id);
         
        if(empresa.isPresent()) {
            return empresa.get();
        } else {
            throw new RecordNotFoundException("No hay ninguna empresa con ID: ",id);
        }
    }
    
    public Empresa createEmpresa(Empresa entity){
        entity = repository.save(entity);
        return entity;
    }
    
    public Empresa UpdateEmpresa(Empresa entity) throws RecordNotFoundException {
    	    	
    	if(entity.getId()!=null) {
    	  Optional<Empresa> empresa = repository.findById(entity.getId());
        
            if(empresa.isPresent()) {
                Empresa newEntity = empresa.get();
                newEntity.setNombre(entity.getNombre());
                newEntity.setDireccion(entity.getDireccion());
                newEntity.setYoutuber(entity.getYoutuber());
                newEntity = repository.save(newEntity);

                return newEntity;
            } else {
                throw new RecordNotFoundException("La empresa no se ha encontrado. ID: ",entity.getId());
            }
        } else {
            throw new RecordNotFoundException("No se proporciona un ID de la emrpesa",0l);
    	}	    
    }
     
    public void deleteEmpresaById(Long id) throws RecordNotFoundException {
        Optional<Empresa> empresa = repository.findById(id);
         
        if(empresa.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No hay ninguna empresa con ID: ",id);
        }
    }

    public List<Empresa> getEmpresasByNombre(String nombre) {
        List<Empresa> empresaList = repository.getByNombre(nombre);
         
        if(empresaList.size() > 0) {
            return empresaList;
        } else {
            return new ArrayList<Empresa>();
        }
    }
    
}
