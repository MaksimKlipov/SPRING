package com.klipov.string_boot.springboot.repository;


import com.klipov.string_boot.springboot.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role getRoleById(Long id);
}
