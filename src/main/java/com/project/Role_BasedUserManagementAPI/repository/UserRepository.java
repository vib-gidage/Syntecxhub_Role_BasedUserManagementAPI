package com.project.Role_BasedUserManagementAPI.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.Role_BasedUserManagementAPI.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	 Optional<User> findByEmail(String email);

}