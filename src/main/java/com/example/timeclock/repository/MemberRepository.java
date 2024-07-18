package com.example.timeclock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.timeclock.entity.Member;

/**
 * 此為資料庫操作介面
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{
	Member findByUsername(String username);
	Member findByEmail(String email);
}

