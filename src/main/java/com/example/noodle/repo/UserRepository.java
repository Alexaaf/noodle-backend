package com.example.noodle.repo;

import com.example.noodle.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long > {

    //Optional findById(String ID);
    @Query("SELECT e FROM User e WHERE e.id = :id")
    public List<User> findStudentById(@Param("id") long id);
    @Override
    User save (User user);

    @Query("SELECT e FROM User e WHERE e.email =: email")
    public List<User> verificarepulaMea(@Param("email") String email);

    @Query("SELECT e FROM User e WHERE e.email = :id")
    public List<User> findStudentByEmail(@Param("id") String id);}
