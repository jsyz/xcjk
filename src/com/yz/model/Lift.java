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
	 * 升降机
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer projectId;
	private Integer DTUnumber;
	private String attendanceData;
	
	
	private Boolean hoistingAlarm;//1：升降机冲顶报警 0：正常
	private Boolean squattingAlarm;//1：升降机蹲底报警 0：正常

	private Boolean faceDetectionError;//1：人脸识别设备正被拆除 0：正常
	private Boolean controlSignalError;//1：控制信号被短接 0：正常
	private Boolean singleDoorError;//	1：单开门限位开关损坏 0：正常
	private Boolean DoubleDoorError;//1：双开门限位开关损坏 0：正常
	private Boolean topDoorError;//1：顶开门限位开关损坏 0：正常
	
	
	

	
	


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
	@Column(name = "faceDetectionError")
	public Boolean getFaceDetectionError() {
		return faceDetectionError;
	}

	public void setFaceDetectionError(Boolean faceDetectionError) {
		this.faceDetectionError = faceDetectionError;
	}
	@Column(name = "controlSignalError")
	public Boolean getControlSignalError() {
		return controlSignalError;
	}

	public void setControlSignalError(Boolean controlSignalError) {
		this.controlSignalError = controlSignalError;
	}
	@Column(name = "singleDoorError")
	public Boolean getSingleDoorError() {
		return singleDoorError;
	}

	public void setSingleDoorError(Boolean singleDoorError) {
		this.singleDoorError = singleDoorError;
	}

	public Boolean getDoubleDoorError() {
		return DoubleDoorError;
	}
	@Column(name = "doubleDoorError")
	public void setDoubleDoorError(Boolean doubleDoorError) {
		DoubleDoorError = doubleDoorError;
	}

	public Boolean getTopDoorError() {
		return topDoorError;
	}
	@Column(name = "topDoorError")
	public void setTopDoorError(Boolean topDoorError) {
		this.topDoorError = topDoorError;
	}

}
