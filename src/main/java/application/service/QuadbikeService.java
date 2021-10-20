/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.service;

import java.util.List;
import java.util.Optional;
import application.model.Quadbike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import application.repository.QuadbikeRepository;


/**
 *
 * @author cterr
 */
@Service
public class QuadbikeService {
    
    @Autowired
    private QuadbikeRepository quadbikeRepository;
    
    public List<Quadbike> getAll(){
    
        return  quadbikeRepository.getAll();
    
    }
    
    public Optional<Quadbike> getQuadbike(Integer id){
    
        return quadbikeRepository.getQuadbike(id);
    
    }
        
    public Quadbike save(Quadbike quadbike){
    
        if(quadbike.getId()==null){
            
            return quadbikeRepository.save(quadbike);
            
        }
        
        else{
        
            Optional<Quadbike> quadbikeAux= quadbikeRepository.getQuadbike(
                    quadbike.getId()
            );
            
            if(!quadbikeAux.isPresent()){
                
                return quadbikeRepository.save(quadbike);
                
            }
            
            else{
            
            return quadbike;
                
            }   
        }
    } 
    
    public Quadbike update(Quadbike quadbike){
        
        if(quadbike.getId()!=null){
            
            Optional<Quadbike> e=quadbikeRepository.getQuadbike(quadbike.getId());
            
            if(!e.isEmpty()){
                
                if(quadbike.getName()!=null){
                    
                    e.get().setName(quadbike.getName());
                   
                }
                
                if(quadbike.getBrand()!=null){
                    
                    e.get().setBrand(quadbike.getBrand());
                    
                }
                
                if(quadbike.getYear()!=null){
                    
                    e.get().setYear(quadbike.getYear());
                    
                }
                
                if(quadbike.getDescription()!=null){
                    
                    e.get().setDescription(quadbike.getDescription());
                    
                }
                
                /*if(quadbike.getCategory()!=null){
                    
                    e.get().setCategory(quadbike.getCategory());
                    
                }*/
                
                quadbikeRepository.save(e.get());
                
                return e.get();
                
            }
            
            else{
                
                return quadbike;
                
            }
            
        }
        
        else{
            
            return quadbike;
            
        }
    }

    public boolean deleteQuadbike(int idQuadbike) {
        
        Boolean aBoolean = getQuadbike(idQuadbike).map(bike -> {            
            quadbikeRepository.delete(bike);     
            return true;            
        }).orElse(false);
        
        return aBoolean;
    }
}
