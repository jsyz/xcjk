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
	 * 塔基
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer projectId;
	private Integer DTUnumber;
	
	private String weight;
	private String weightPercent;
	private String torque;
	private String torquePercent;
	private String startHeight;
	private String endHeight;
	private String startAngle;
	private String endAngle;
	
	private String attendanceData;//考勤人员

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
	private Boolean antiCollisionAlarm;
	private Boolean zoneLimitAlarm;

	public Crane() {

	}

	@Column(name = "angleAlarm")
	public Boolean getAngleAlarm() {
		return angleAlarm;
	}

	@Column(name = "angleWarning")
	public Boolean getAngleWarning() {
		return angleWarning;
	}

	@Column(name = "antiCollisionAlarm")
	public Boolean getAntiCollisionAlarm() {
		return antiCollisionAlarm;
	}

	@Column(name = "attendanceData", length = 30)
	public String getAttendanceData() {
		return attendanceData;
	}

	@Column(name = "DTUnumber", length = 30)
	public Integer getDTUnumber() {
		return DTUnumber;
	}

	@Column(name = "heightAlarm")
	public Boolean getHeightAlarm() {
		return heightAlarm;
	}

	@Column(name = "heightWarning")
	public Boolean getHeightWarning() {
		return heightWarning;
	}

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	@Column(name = "inclinationAlarm")
	public Boolean getInclinationAlarm() {
		return inclinationAlarm;
	}

	@Column(name = "inclinationWarning")
	public Boolean getInclinationWarning() {
		return inclinationWarning;
	}

	@Column(name = "projectId")
	public Integer getProjectId() {
		return projectId;
	}

	@Column(name = "relaysWarning")
	public Boolean getRelaysWarning() {
		return relaysWarning;
	}

	@Column(name = "torqueAlarm")
	public Boolean getTorqueAlarm() {
		return torqueAlarm;
	}

	@Column(name = "weightAlarm")
	public Boolean getWeightAlarm() {
		return weightAlarm;
	}

	@Column(name = "weightWarning")
	public Boolean getWeightWarning() {
		return weightWarning;
	}

	@Column(name = "widthAlarm")
	public Boolean getWidthAlarm() {
		return widthAlarm;
	}

	@Column(name = "widthWarning")
	public Boolean getWidthWarning() {
		return widthWarning;
	}

	@Column(name = "windAlarm")
	public Boolean getWindAlarm() {
		return windAlarm;
	}

	@Column(name = "windWarning")
	public Boolean getWindWarning() {
		return windWarning;
	}

	@Column(name = "zoneLimitAlarm")
	public Boolean getZoneLimitAlarm() {
		return zoneLimitAlarm;
	}

	public void setAngleAlarm(Boolean angleAlarm) {
		this.angleAlarm = angleAlarm;
	}

	public void setAngleWarning(Boolean angleWarning) {
		this.angleWarning = angleWarning;
	}

	public void setAntiCollisionAlarm(Boolean antiCollisionAlarm) {
		this.antiCollisionAlarm = antiCollisionAlarm;
	}

	public void setAttendanceData(String attendanceData) {
		this.attendanceData = attendanceData;
	}

	public void setDTUnumber(Integer unumber) {
		DTUnumber = unumber;
	}

	public void setHeightAlarm(Boolean heightAlarm) {
		this.heightAlarm = heightAlarm;
	}

	public void setHeightWarning(Boolean heightWarning) {
		this.heightWarning = heightWarning;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setInclinationAlarm(Boolean inclinationAlarm) {
		this.inclinationAlarm = inclinationAlarm;
	}

	public void setInclinationWarning(Boolean inclinationWarning) {
		this.inclinationWarning = inclinationWarning;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public void setRelaysWarning(Boolean relaysWarning) {
		this.relaysWarning = relaysWarning;
	}

	public void setTorqueAlarm(Boolean torqueAlarm) {
		this.torqueAlarm = torqueAlarm;
	}

	public void setWeightAlarm(Boolean weightAlarm) {
		this.weightAlarm = weightAlarm;
	}

	public void setWeightWarning(Boolean weightWarning) {
		this.weightWarning = weightWarning;
	}

	public void setWidthAlarm(Boolean widthAlarm) {
		this.widthAlarm = widthAlarm;
	}

	public void setWidthWarning(Boolean widthWarning) {
		this.widthWarning = widthWarning;
	}

	public void setWindAlarm(Boolean windAlarm) {
		this.windAlarm = windAlarm;
	}

	public void setWindWarning(Boolean windWarning) {
		this.windWarning = windWarning;
	}

	public void setZoneLimitAlarm(Boolean zoneLimitAlarm) {
		this.zoneLimitAlarm = zoneLimitAlarm;
	}

	public String getWeight() {
		return weight;
	}
	@Column(name = "weight", length = 30)
	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getWeightPercent() {
		return weightPercent;
	}
	@Column(name = "weightPercent", length = 30)
	public void setWeightPercent(String weightPercent) {
		this.weightPercent = weightPercent;
	}

	public String getTorque() {
		return torque;
	}
	@Column(name = "torque", length = 30)
	public void setTorque(String torque) {
		this.torque = torque;
	}

	public String getTorquePercent() {
		return torquePercent;
	}
	@Column(name = "torquePercent", length = 30)
	public void setTorquePercent(String torquePercent) {
		this.torquePercent = torquePercent;
	}

	public String getStartHeight() {
		return startHeight;
	}
	@Column(name = "startHeight", length = 30)
	public void setStartHeight(String startHeight) {
		this.startHeight = startHeight;
	}

	public String getEndHeight() {
		return endHeight;
	}
	@Column(name = "endHeight", length = 30)
	public void setEndHeight(String endHeight) {
		this.endHeight = endHeight;
	}

	public String getStartAngle() {
		return startAngle;
	}
	@Column(name = "startAngle", length = 30)
	public void setStartAngle(String startAngle) {
		this.startAngle = startAngle;
	}

	public String getEndAngle() {
		return endAngle;
	}
	@Column(name = "endAngle", length = 30)
	public void setEndAngle(String endAngle) {
		this.endAngle = endAngle;
	}
	
	

}
