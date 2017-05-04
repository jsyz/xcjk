package com.yz.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Data212 {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer projectId;
	private String DTUnumber;
	private String NoiseData;
	private String DustData;
	private String reportedTime;
	
	
	
	public Data212() {
		
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
	
	@Column(name = "DTUnumber",length = 30)
	public String getDTUnumber() {
		return DTUnumber;
	}
	public void setDTUnumber(String unumber) {
		DTUnumber = unumber;
	}
	
	@Column(name = "noiseData", length = 30)
	public String getNoiseData() {
		return NoiseData;
	}
	public void setNoiseData(String noiseData) {
		NoiseData = noiseData;
	}
	@Column(name = "dustData", length = 30)
	public String getDustData() {
		return DustData;
	}
	public void setDustData(String dustData) {
		DustData = dustData;
	}
	@Column(name = "reportedTime", length = 30)
	public String getReportedTime() {
		return reportedTime;
	}
	public void setReportedTime(String reportedTime) {
		this.reportedTime = reportedTime;
	}
	
	
}
