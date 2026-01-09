package com.security.SpringSecurityUserEx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.security.SpringSecurityUserEx.entity.Users;

@Repository
public interface UserRespository extends JpaRepository<Users, Integer> {

	Users findByName(String name);
}
