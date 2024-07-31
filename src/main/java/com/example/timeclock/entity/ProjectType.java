package com.example.timeclock.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "project_type")
public class ProjectType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "type_id")
	private Long typeId;
	
//	@Column(name = "member_id", nullable = false)
//	private Long memberId;
	
	@Column(name = "type_name", nullable = false)
	private String typeName;
	
	@Column(name = "isDefault", nullable = false, columnDefinition = "TINYINT")
	private Integer isDefaultInt;
	
	@ManyToOne
	@JoinColumn(name = "member_id", nullable = false)
	private Member member;

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

//	public Long getMemberId() {
//		return memberId;
//	}
//
//	public void setMemberId(Long memberId) {
//		this.memberId = memberId;
//	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Boolean getIsDefault() {
		return isDefaultInt == 1;
	}

	public void setIsDefault(Boolean getIsDefault) {
		this.isDefaultInt = getIsDefault ? 1 : 0;
	}

	@Override
	public String toString() {
		return "ProjectType [typeId=" + typeId + ", typeName=" + typeName + ", isDefaultInt=" + isDefaultInt
				+ ", member=" + member + "]";
	}

}
