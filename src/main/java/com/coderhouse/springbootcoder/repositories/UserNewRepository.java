package com.coderhouse.springbootcoder.repositories;

import com.coderhouse.springbootcoder.entity.documents.authJwtModels.UserNew;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserNewRepository extends MongoRepository<UserNew, Long> {
    Optional<UserNew> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}


