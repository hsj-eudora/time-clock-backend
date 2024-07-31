package com.example.timeclock.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.timeclock.dto.ProjectTypeRequest;
import com.example.timeclock.entity.ProjectType;
import com.example.timeclock.repository.ProjectTypeRepository;


@Service
public class ProjectTypeService {

	// 取得當前member id
	private Long getCurrentMemberId() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
			Long memberId = (UserDetails.principal.getMemberId());
		}
	}
	
	
	private ProjectTypeRepository projectTypeRepository;
	
	public ProjectTypeService(ProjectTypeRepository projectTypeRepository) {
		this.projectTypeRepository = projectTypeRepository;
	}
	
	
	public ProjectType createProjectType(ProjectTypeRequest projectTypeRequest) {
		if(projectTypeRepository.findByMemberAndType(null, null))
		return null;
		
	}
	
}
