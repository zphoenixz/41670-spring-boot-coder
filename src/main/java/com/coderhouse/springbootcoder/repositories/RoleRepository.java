package com.coderhouse.springbootcoder.repositories;

import com.coderhouse.springbootcoder.entity.documents.authJwtModels.Role;
import com.coderhouse.springbootcoder.entity.documents.enums.ERole;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}

