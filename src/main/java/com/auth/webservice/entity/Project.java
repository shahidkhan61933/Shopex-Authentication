package com.auth.webservice.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "eshopee_project")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "prid_generator")
	@SequenceGenerator(name = "prid_generator", initialValue = 1, allocationSize = 1, sequenceName = "id_seq")
	@Column(name="project_id")
	private long id;
	
	@Column(name = "name")
	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
