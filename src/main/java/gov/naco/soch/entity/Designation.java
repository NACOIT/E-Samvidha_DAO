package gov.naco.soch.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the designation database table.
 * 
 */
@GenericGenerator(name = "designation", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "designation_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "designation")
@NamedQuery(name = "Designation.findAll", query = "SELECT d FROM Designation d")
public class Designation extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( generator = "designation")
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(length = 99)
	private String description;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(length = 99)
	private String title;

	// bi-directional many-to-one association to DesignationFacilityTypeMapping
	@OneToMany(mappedBy = "designation", cascade = CascadeType.ALL)
	private Set<DesignationFacilityTypeMapping> designationFacilityTypeMappings;

	public Designation() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<DesignationFacilityTypeMapping> getDesignationFacilityTypeMappings() {
		return designationFacilityTypeMappings;
	}

	public void setDesignationFacilityTypeMappings(
			Set<DesignationFacilityTypeMapping> designationFacilityTypeMappings) {
		this.designationFacilityTypeMappings = designationFacilityTypeMappings;
	}

}