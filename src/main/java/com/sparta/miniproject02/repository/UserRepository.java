package com.sparta.miniproject02.repository;

import com.sparta.miniproject02.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
