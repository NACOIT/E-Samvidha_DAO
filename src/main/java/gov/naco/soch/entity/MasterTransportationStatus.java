package gov.naco.soch.entity;

import java.io.Serializable;
import java.util.Set;

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
 * The persistent class for the master_transportation_status database table.
 * 
 */
@GenericGenerator(name = "master_transportation_status", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "master_transportation_status_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "master_transportation_status")
@NamedQuery(name = "MasterTransportationStatus.findAll", query = "SELECT m FROM MasterTransportationStatus m")
public class MasterTransportationStatus extends Auditable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "master_transportation_status")
	private Long id;

	private String code;

	private String name;

	private String description;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;
	
	@OneToMany(mappedBy = "masterTransportationStatus")
	private Set<FacilityDispatchTransportDetails> facilityDispatchTransportDetails;

	public Long getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Set<FacilityDispatchTransportDetails> getFacilityDispatchTransportDetails() {
		return facilityDispatchTransportDetails;
	}

	public void setFacilityDispatchTransportDetails(
			Set<FacilityDispatchTransportDetails> facilityDispatchTransportDetails) {
		this.facilityDispatchTransportDetails = facilityDispatchTransportDetails;
	}
	
	public FacilityDispatchTransportDetails addFacilityDispatchTransportDetails(FacilityDispatchTransportDetails facilityDispatchTransportDetails) {
		getFacilityDispatchTransportDetails().add(facilityDispatchTransportDetails);
		facilityDispatchTransportDetails.setMasterTransportationStatus(this);
		return facilityDispatchTransportDetails;
	}

	public FacilityDispatchTransportDetails removeFacilityDispatchTransportDetails(FacilityDispatchTransportDetails facilityDispatchTransportDetails) {
		getFacilityDispatchTransportDetails().remove(facilityDispatchTransportDetails);
		facilityDispatchTransportDetails.setMasterTransportationStatus(null);
		return facilityDispatchTransportDetails;
	}

}
