package application.service;

import application.model.Category;
import application.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        
        return  categoryRepository.getAll();
        
    }
    
    public Optional<Category> getCategory(int id){
        
        return categoryRepository.getCategory(id);
        
    }

    public Category save(Category categoria){
        
        if(categoria.getId()==null){
            
            return categoryRepository.save(categoria);
            
        }
        
        else{
            
            Optional<Category> paux=categoryRepository.getCategory(categoria.getId());
            
            if(!paux.isPresent()){
                
                return categoryRepository.save(categoria);
                
            }
            else{
                
                return categoria;
                
            }
        }
    }
    
    public Category update(Category categoria){
        
        if(categoria.getId()!=null){
            
            Optional<Category>g=categoryRepository.getCategory(categoria.getId());
            
            if(!g.isEmpty()){
                
                if(categoria.getDescription()!=null){
                    
                    g.get().setDescription(categoria.getDescription());
                    
                }
                
                if(categoria.getName()!=null){
                    
                    g.get().setName(categoria.getName());
                    
                }
                
                return categoryRepository.save(g.get());
                
            }
        }
        return categoria;
    }
    
    public boolean deleteCategory(int categoriaId){
        
        Boolean d=getCategory(categoriaId).map(categoria -> {
            
            categoryRepository.delete(categoria);
            
            return true;
        }).orElse(false);
        return d;
    }
}
