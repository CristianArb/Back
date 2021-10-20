/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.repository;

import application.model.Message;
import java.util.List;
import java.util.Optional;
import application.model.Quadbike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import application.repository.crud.QuadbikeCrudRepository;

/**
 *
 * @author cterr
 */
@Repository
public class QuadbikeRepository{
    
    //Que hace esa etiqueta
    @Autowired
    private QuadbikeCrudRepository quadbikeCrudRepository;
    
    public List<Quadbike> getAll(){
    
        return (List<Quadbike>) quadbikeCrudRepository.findAll();
    
    }
    
    public Optional<Quadbike> getQuadbike(Integer id){
    
        return quadbikeCrudRepository.findById(id);
    
    }
    
    public Quadbike save(Quadbike quadbike){
    
        return quadbikeCrudRepository.save(quadbike);
    
    }
    
    public void delete(Quadbike quadbike){
        
        quadbikeCrudRepository.delete(quadbike);
        
    }
    
}
