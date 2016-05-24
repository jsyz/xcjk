package com.yz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "crane", schema = "dbo", catalog = "xcjk")
public class Crane implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer projectId;
	private Integer DTUnumber;
	private String attendanceData;

	private Boolean weightWarning;
	private Boolean heightWarning;
	private Boolean widthWarning;
	private Boolean angleWarning;
	private Boolean windWarning;
	private Boolean inclinationWarning;
	private Boolean relaysWarning;

	private Boolean weightAlarm;
	private Boolean torqueAlarm;
	private Boolean heightAlarm;
	private Boolean widthAlarm;
	private Boolean angleAlarm;
	private Boolean windAlarm;
	private Boolean inclinationAlarm;

	public Crane() {

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

	@Column(name = "DTUnumber", length = 30)
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

	@Column(name = "weightWarning")
	public Boolean getWeightWarning() {
		return weightWarning;
	}

	public void setWeightWarning(Boolean weightWarning) {
		this.weightWarning = weightWarning;
	}

	@Column(name = "heightWarning")
	public Boolean getHeightWarning() {
		return heightWarning;
	}

	public void setHeightWarning(Boolean heightWarning) {
		this.heightWarning = heightWarning;
	}

	@Column(name = "widthWarning")
	public Boolean getWidthWarning() {
		return widthWarning;
	}

	public void setWidthWarning(Boolean widthWarning) {
		this.widthWarning = widthWarning;
	}

	@Column(name = "angleWarning")
	public Boolean getAngleWarning() {
		return angleWarning;
	}

	public void setAngleWarning(Boolean angleWarning) {
		this.angleWarning = angleWarning;
	}

	@Column(name = "windWarning")
	public Boolean getWindWarning() {
		return windWarning;
	}

	public void setWindWarning(Boolean windWarning) {
		this.windWarning = windWarning;
	}

	@Column(name = "inclinationWarning")
	public Boolean getInclinationWarning() {
		return inclinationWarning;
	}

	public void setInclinationWarning(Boolean inclinationWarning) {
		this.inclinationWarning = inclinationWarning;
	}

	@Column(name = "relaysWarning")
	public Boolean getRelaysWarning() {
		return relaysWarning;
	}

	public void setRelaysWarning(Boolean relaysWarning) {
		this.relaysWarning = relaysWarning;
	}

	@Column(name = "weightAlarm")
	public Boolean getWeightAlarm() {
		return weightAlarm;
	}

	public void setWeightAlarm(Boolean weightAlarm) {
		this.weightAlarm = weightAlarm;
	}

	@Column(name = "torqueAlarm")
	public Boolean getTorqueAlarm() {
		return torqueAlarm;
	}

	public void setTorqueAlarm(Boolean torqueAlarm) {
		this.torqueAlarm = torqueAlarm;
	}

	@Column(name = "heightAlarm")
	public Boolean getHeightAlarm() {
		return heightAlarm;
	}

	public void setHeightAlarm(Boolean heightAlarm) {
		this.heightAlarm = heightAlarm;
	}

	@Column(name = "widthAlarm")
	public Boolean getWidthAlarm() {
		return widthAlarm;
	}

	public void setWidthAlarm(Boolean widthAlarm) {
		this.widthAlarm = widthAlarm;
	}

	@Column(name = "angleAlarm")
	public Boolean getAngleAlarm() {
		return angleAlarm;
	}

	public void setAngleAlarm(Boolean angleAlarm) {
		this.angleAlarm = angleAlarm;
	}

	@Column(name = "windAlarm")
	public Boolean getWindAlarm() {
		return windAlarm;
	}

	public void setWindAlarm(Boolean windAlarm) {
		this.windAlarm = windAlarm;
	}

	@Column(name = "inclinationAlarm")
	public Boolean getInclinationAlarm() {
		return inclinationAlarm;
	}

	public void setInclinationAlarm(Boolean inclinationAlarm) {
		this.inclinationAlarm = inclinationAlarm;
	}

}
