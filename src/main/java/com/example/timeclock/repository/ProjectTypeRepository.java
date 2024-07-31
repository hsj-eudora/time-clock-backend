package com.example.timeclock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.timeclock.entity.ProjectType;

public interface ProjectTypeRepository extends JpaRepository<ProjectType, Long> {
	ProjectType findByMemberAndType(Long memberId, String typeName); // 根據member id跟project type name查找project type
	ProjectType findDefaultByMember(Long memberId); // 根據member id查找預設的project type
}
