package com.batchScheduling.CompanyDetail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.batchScheduling.CompanyDetail.entity.UserDetails;
@Repository
public interface UserRepository extends JpaRepository<UserDetails, Integer> {

}
