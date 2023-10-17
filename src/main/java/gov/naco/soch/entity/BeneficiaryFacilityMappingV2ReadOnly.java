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

@GenericGenerator(name = "beneficiaryFacilityMappingV2ReadOnly", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "beneficiary_facility_mapping_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity(name="BeneficiaryFacilityMappingV2ReadOnly")
@Table(name = "beneficiary_facility_mapping")
@Immutable
public class BeneficiaryFacilityMappingV2ReadOnly extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( generator = "beneficiaryFacilityMappingV2ReadOnly")
	private Long id;
	
	@Column(name="is_transferred")
	private Boolean isTransferred;
	
	@Column(name = "is_active")
	private Boolean isActive;

	@ManyToOne
	private FacilityReadOnly facility;
	@ManyToOne
	@JoinColumn(name = "beneficiary_id")
	private BeneficiaryV2ReadOnly beneficiary;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Boolean getIsTransferred() {
		return isTransferred;
	}
	public void setIsTransferred(Boolean isTransferred) {
		this.isTransferred = isTransferred;
	}
	public FacilityReadOnly getFacility() {
		return facility;
	}
	public void setFacility(FacilityReadOnly facility) {
		this.facility = facility;
	}
	public BeneficiaryV2ReadOnly getBeneficiary() {
		return beneficiary;
	}
	public void setBeneficiary(BeneficiaryV2ReadOnly beneficiary) {
		this.beneficiary = beneficiary;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
}
