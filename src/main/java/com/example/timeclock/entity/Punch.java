package com.example.timeclock.entity;

import java.time.ZonedDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "punch")
public class Punch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "punch_id")
	private Long punchId;
	
	@Column(name = "task_id", nullable = false)
	private Long taskId;
	
	@Column(name = "start_at", nullable = false)
	private ZonedDateTime startAt;   
	
	@Column(name = "end_at")
	private ZonedDateTime endAt;

	@Column(name = "time_count")
	private Long timeCount;


	public void punch() {
		this.startAt = ZonedDateTime.now();
	}
	
	public Long getPunchId() {
		return punchId;
	}

	public void setPunchId(Long punchId) {
		this.punchId = punchId;
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public ZonedDateTime getStartAt() {
		return startAt;
	}

	public void setStartAt(ZonedDateTime startAt) {
		this.startAt = startAt;
	}

	public ZonedDateTime getEndAt() {
		return endAt;
	}

	public void setEndAt(ZonedDateTime endAt) {
		this.endAt = endAt;
	}

	public Long getTimeCount() {
		return timeCount;
	}

	public void setTimeCount(Long timeCount) {
		this.timeCount = timeCount;
	}

	@Override
	public String toString() {
		return "Punch [punchId=" + punchId + ", taskId=" + taskId + ", startAt=" + startAt + ", endAt=" + endAt
				+ ", timeCount=" + timeCount + "]";
	}
}
