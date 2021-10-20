package application.repository;

import application.model.Category;
import application.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import application.repository.crud.CategoryCrudRepository;

@Repository
public class CategoryRepository {
    
    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    public List<Category> getAll(){
        
        return (List<Category>) categoryCrudRepository.findAll();
    
    }
   
    public Optional<Category>getCategory(int id){
        
        return categoryCrudRepository.findById(id);
        
    }
    
    public Category save(Category category){
        
        return categoryCrudRepository.save(category);
        
    }
    
    public void delete(Category category){
        
        categoryCrudRepository.delete(category);
        
    }
}
