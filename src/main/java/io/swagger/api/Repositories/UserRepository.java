package io.swagger.api.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.model.User;



// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {
    @Query(value ="SELECT a FROM User a WHERE a.email =?1 AND a.password = ?2")
    @ResponseBody Iterable<User> findUserByEmailAndPassword(@RequestParam String email,@RequestParam String password);

    @Query(value ="SELECT a FROM User a, Client b WHERE a.userName =?1 AND b.id = a.Client_id AND b.id = ?2")
    @ResponseBody User findUserByUserName(@RequestParam String userName, @RequestParam Integer Client_id);

    @Query(value ="SELECT a FROM User a, Client b WHERE a.id =?1 AND b.id =?2 AND b.id = a.Client_id")
    @ResponseBody User findUserById(@RequestParam Integer id, @RequestParam Integer Client_id);

    @Query(value ="SELECT a FROM User a, Client b WHERE b.id = a.Client_id AND b.id = ?1")
    @ResponseBody Iterable<User> findAllUserOfClient(@RequestParam Integer Client_id);
}