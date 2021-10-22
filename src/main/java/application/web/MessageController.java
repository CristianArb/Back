
package application.web;

import application.model.Message;
import application.service.MessageService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods= {GET, POST, PUT, DELETE})

public class MessageController {
    
    @Autowired
    private MessageService messageService;
    
    @GetMapping("/all")
    public List<Message> getMessages(){
        
        return messageService.getAll();
        
    }

    @GetMapping("/{id}")
    public Optional<Message> getMessage(@PathVariable("id") int messageId) {
        
        return messageService.getMessage(messageId);
        
    }

    @PostMapping("/save")
    @ResponseStatus(CREATED)
    public Message save(@RequestBody Message message) {
        
        return messageService.save(message);
    }
    
    @PutMapping("/update")
    @ResponseStatus(CREATED)
    public Message update(@RequestBody Message message) {
        
        return messageService.update(message);
        
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public boolean delete(@PathVariable("id") int messageId) {
        
        return messageService.deleteMessage(messageId);
        
    }
    
}
