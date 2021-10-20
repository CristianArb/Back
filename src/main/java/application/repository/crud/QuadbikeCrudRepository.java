 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.repository.crud;

import application.model.Quadbike;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author cterr
 */
public interface QuadbikeCrudRepository extends CrudRepository<Quadbike, Integer> {
    
}
