package gov.naco.soch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "BeneficiaryFacilityMappingGlobalReadOnly", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "beneficiary_facility_mapping_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity(name="BeneficiaryFacilityMappingGlobalReadOnly")
@Table(name = "beneficiary_facility_mapping")
@Immutable
public class BeneficiaryFacilityMappingGlobalReadOnly  extends Auditable<Long> implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( generator = "BeneficiaryFacilityMappingGlobalReadOnly")
	private Long id;
	

  	@ManyToOne
	@JoinColumn(name = "beneficiary_id")
	private BeneficiaryGlobalReadOnly beneficiary;
  	
  	@ManyToOne
	private FacilityReadOnly facility;
  	
  	@Column(name = "is_active")
	private Boolean isActive;
  	
	@Column(name = "is_delete")
	private Boolean isDelete;
  	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public BeneficiaryGlobalReadOnly getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(BeneficiaryGlobalReadOnly beneficiary) {
		this.beneficiary = beneficiary;
	}

	public FacilityReadOnly getFacility() {
		return facility;
	}

	public void setFacility(FacilityReadOnly facility) {
		this.facility = facility;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}
}
