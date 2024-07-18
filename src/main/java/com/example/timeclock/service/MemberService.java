package com.example.timeclock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.timeclock.entity.Member;
import com.example.timeclock.repository.MemberRepository;

@Service
public class MemberService {
	
	private MemberRepository memberRepository;
	
	@Autowired
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;	
	}
	
	 //setId return member
	public Member createMember(Member member) {
		
		if(memberRepository.findByUsername(member.getUsername())!= null) {
			throw new IllegalArgumentException("用戶名稱重複");
		}
		if(memberRepository.findByEmail(member.getEmail())!= null) {
			throw new IllegalArgumentException("Email重複");
		}
		member.setId(null);
		return memberRepository.save(member);		
	}
	
	 //getusermane return member 傳入的參數使用者名稱和密碼並進行驗證
	public Member loginMember(String username, String password) {
        Member member = memberRepository.findByUsername(username); 	
        if (member != null && member.getPassword().equals(password)) {
        	return member;        	
        } else {
        	return null;
        }
        
	}
	
	 //return members
	public List<Member> listMembers() {
		return memberRepository.findAll();		
	}
		
}
