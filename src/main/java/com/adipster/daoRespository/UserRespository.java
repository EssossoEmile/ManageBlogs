package com.adipster.daoRespository;

import com.adipster.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRespository extends JpaRepository <User, Integer>{
    List<User> findByTitleContainingOrContentContaining(String text, String textAgain);
}
