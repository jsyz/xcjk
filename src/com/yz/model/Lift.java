package com.yz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lift", schema = "dbo", catalog = "xcjk")
public class Lift implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer projectId;
	private Integer DTUnumber;
	private String attendanceData;
	private Boolean hoistingAlarm;
	private Boolean squattingAlarm;

	public Lift() {

	}

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "projectId")
	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	@Column(name = "DTUnumber")
	public Integer getDTUnumber() {
		return DTUnumber;
	}

	public void setDTUnumber(Integer unumber) {
		DTUnumber = unumber;
	}

	@Column(name = "attendanceData", length = 30)
	public String getAttendanceData() {
		return attendanceData;
	}

	public void setAttendanceData(String attendanceData) {
		this.attendanceData = attendanceData;
	}
	@Column(name = "hoistingAlarm")
	public Boolean getHoistingAlarm() {
		return hoistingAlarm;
	}

	public void setHoistingAlarm(Boolean hoistingAlarm) {
		this.hoistingAlarm = hoistingAlarm;
	}
	@Column(name = "squattingAlarm")
	public Boolean getSquattingAlarm() {
		return squattingAlarm;
	}

	public void setSquattingAlarm(Boolean squattingAlarm) {
		this.squattingAlarm = squattingAlarm;
	}

}
