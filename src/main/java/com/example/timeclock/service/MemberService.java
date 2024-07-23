package com.example.timeclock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.timeclock.dto.RegisterRequest;
import com.example.timeclock.entity.Member;
import com.example.timeclock.repository.MemberRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MemberService {
	
	private MemberRepository memberRepository;
//	private PasswordEncoder passwordEncoder;
    private final BCryptPasswordEncoder pw = new BCryptPasswordEncoder();

	@Autowired
//	public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
//		this.memberRepository = memberRepository;	
//		this.passwordEncoder = passwordEncoder;
//	}
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}	
	public List<Member> listMembers() {
		return memberRepository.findAll();		
	}
	
	public Optional<Member> member(Long id) {
		return memberRepository.findById(id);		
	}
	
	public Member updateMember(Long id, Member memberInfo) {
		Optional<Member> optionalMember = memberRepository.findById(id); // 查找要更新的會員
		if (optionalMember.isPresent()) {

			Member member = optionalMember.get(); // 若存在則取得此會員
			member.setUsername(memberInfo.getUsername());
			member.setPassword(pw.encode(memberInfo.getPassword()));
			member.setEmail(memberInfo.getEmail());
	
		return memberRepository.save(member);
		} else {
			throw new EntityNotFoundException("Member not found!!");
		}
	}
	
	public Member createMember(RegisterRequest registerRequest) {		
		if(memberRepository.findByUsername(registerRequest.getUsername())!= null) {
			throw new IllegalArgumentException("用戶名稱重複");
		}
		if(memberRepository.findByEmail(registerRequest.getEmail())!= null) {
			throw new IllegalArgumentException("Email重複");
		}

		Member member = new Member();
		member.setUsername(registerRequest.getUsername());
		member.setPassword(pw.encode(registerRequest.getPassword()));
		member.setEmail(registerRequest.getEmail());
		
		return memberRepository.save(member);		
	}
	
	public Member loginMember(String username, String password) {
        Member member = memberRepository.findByUsername(username); 	
//        if (member != null && member.getPassword().equals(password)) {
    	System.out.println("password:"+ password);
    	System.out.println("member.getPassword:"+ member.getPassword());
        if (member != null && pw.matches(password, member.getPassword())) {
        	return member;        	
        } else {
        	return null;
        }
        
	}
	
//	public Member loginMember(String username, String password) {
//        Member member = memberRepository.findByUsername(username);
//    	System.out.println("password: " + password);
//    	System.out.println("member.getPassword: " + member.getPassword());
//        if (member != null && passwordEncoder.matches(password, member.getPassword())) {
//        	System.out.println("Password match");
//        	return member;
//        } else {
//        	System.out.println("Password mismatch");
//        	return null;
//        }
//	}
}
