package application.web;


import application.model.Category;
import application.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods= {GET, POST, PUT, DELETE})
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getCategorys(){
        
        return categoryService.getAll();
        
    }
    
    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable("id") int id){
        
        return categoryService.getCategory(id);
        
    }

    @PostMapping("/save")
    @ResponseStatus(CREATED)
    public Category save(@RequestBody Category category){
        
        return categoryService.save(category);
        
    }
    
    @PutMapping("/update")
    @ResponseStatus(CREATED)
    public Category update(@RequestBody Category category) {
        
        return categoryService.update(category);
        
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public boolean delete(@PathVariable("id") int idCategory) {
        
        return categoryService.deleteCategory( idCategory);
        
    }
}
