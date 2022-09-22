package com.coderhouse.springbootcoder.repositories;

import com.coderhouse.springbootcoder.models.documents.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

}
