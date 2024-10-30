package com.dua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dua.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	Role findByNome(String name);
}
