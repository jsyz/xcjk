package com.yz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "noise", schema = "dbo", catalog = "xcjk")
public class Noise implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer projectId;
	
	private Integer DTUnumber;
	
	private String data;

	public Noise() {

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

	@Column(name = "data", length = 30)
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
