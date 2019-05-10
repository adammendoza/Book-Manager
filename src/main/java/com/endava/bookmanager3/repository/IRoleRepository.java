package com.endava.bookmanager3.repository;

import com.endava.bookmanager3.model.Role;
import com.endava.bookmanager3.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(RoleName roleName);
}
