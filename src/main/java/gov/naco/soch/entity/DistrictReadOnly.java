package gov.naco.soch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;


/**
 * The persistent class for the district database table.
 * 
 */
@Entity(name="DistrictReadOnly")
@Table(name="district")
@Immutable
public class DistrictReadOnly implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String name;

	@Column(name="alternate_name")
	private String alternateName;

	public DistrictReadOnly() {
	}


	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
	    return name;
	}


	public void setName(String name) {
	    this.name = name;
	}


	public String getAlternateName() {
		return alternateName;
	}


	public void setAlternateName(String alternateName) {
		this.alternateName = alternateName;
	}

	
}