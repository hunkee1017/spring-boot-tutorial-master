package com.skcc.content.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skcc.content.vo.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public List<User> findByEmail(String email);

}
