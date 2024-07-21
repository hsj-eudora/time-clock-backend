package com.example.timeclock.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "task")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "task_id")
	private Long taskId;
	
	@Column(name = "project_id", nullable = false)
	private Long projectId;
	
	@Column(name = "task_name", nullable = false)
	private String taskName;
	
	@Column(name = "task_desc")
	private String taskDesc;
	
	@Column(name ="est_time")
	private Long estTime;
	
	@Column(name = "est_comp")
	private Long estComp;
	
	@Column(name= "est_ave_comp")
	private Long estAveComp;
	
	@Column(name = "act_total_time")
	private Long actTotalTime;
	
	@Column(name = "act_ave_comp")
	private Long actAveComp;

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDesc() {
		return taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}

	public Long getEstTime() {
		return estTime;
	}

	public void setEstTime(Long estTime) {
		this.estTime = estTime;
	}

	public Long getEstComp() {
		return estComp;
	}

	public void setEstComp(Long estComp) {
		this.estComp = estComp;
	}

	public Long getEstAveComp() {
		return estAveComp;
	}

	public void setEstAveComp(Long estAveComp) {
		this.estAveComp = estAveComp;
	}

	public Long getActTotalTime() {
		return actTotalTime;
	}

	public void setActTotalTime(Long actTotalTime) {
		this.actTotalTime = actTotalTime;
	}

	public Long getActAveComp() {
		return actAveComp;
	}
 
	public void setActAveComp(Long actAveComp) {
		this.actAveComp = actAveComp;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", projectId=" + projectId + ", taskName=" + taskName + ", taskDesc="
				+ taskDesc + ", estTime=" + estTime + ", estComp=" + estComp + ", estAveComp=" + estAveComp
				+ ", actTotalTime=" + actTotalTime + ", actAveComp=" + actAveComp + "]";
	}
	
	
}
