package io.swagger.api.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.model.Admin;



// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface AdminRepository extends CrudRepository<Admin, Integer> {
    @Query(value ="SELECT a FROM Admin a WHERE a.email =?1 AND a.password = ?2")
    @ResponseBody Iterable<Admin> findAdminByEmailAndPassword(@RequestParam String email,@RequestParam String password);
    
    @Query(value ="SELECT a FROM Admin a WHERE a.id =?1")
    @ResponseBody Admin findAdminById(@RequestParam Integer id);
    
    @Query(value ="SELECT a FROM Admin a WHERE a.userName =?1")
    @ResponseBody Admin findAdminByUserName(@RequestParam String userName);
}
