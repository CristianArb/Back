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

    public Category save(Category category){
        
        if(category.getId()==null){
            
            return categoryRepository.save(category);
            
        }
        
        else{
            
            var paux=categoryRepository.getCategory(category.getId());
            
            if(paux.isEmpty()){
                
                return categoryRepository.save(category);
                
            }
            else{
                
                return category;
                
            }
        }
    }
    
    public Category update(Category category){
        
        if(category.getId()!=null){
            
            var g=categoryRepository.getCategory(category.getId());
            
            if(!g.isEmpty()){
                
                if(category.getDescription()!=null){
                    
                    g.get().setDescription(category.getDescription());
                    
                }
                
                if(category.getName()!=null){
                    
                    g.get().setName(category.getName());
                    
                }
                
                return categoryRepository.save(g.get());
                
            }
        }
        return category;
    }
    
    public boolean deleteCategory(int categoriaId){
        
        var d=getCategory(categoriaId).map(categoria -> {
            
            categoryRepository.delete(categoria);
            
            return true;
        }).orElse(false);
        return d;
    }
}
