package gov.naco.soch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the mapping_lab_facility database table.
 * 
 */
@GenericGenerator(name = "mapping_lab_facility", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "mapping_lab_facility_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "mapping_lab_facility")
@NamedQuery(name = "MappingLabFacility.findAll", query = "SELECT l FROM MappingLabFacility l")
public class MappingLabFacility extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "mapping_lab_facility")
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(name = "is_delete")
	private Boolean isDelete;

	// bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name = "facility_id")
	private Facility facility;

	// bi-directional many-to-one association to Lab
	@ManyToOne
	@JoinColumn(name = "lab_id")
	private Facility lab;

	public MappingLabFacility() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public Facility getLab() {
		return lab;
	}

	public void setLab(Facility lab) {
		this.lab = lab;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}