package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the beneficiary_facility_mapping database table.
 * 
 */

@GenericGenerator(name = "beneficiary_facility_mapping", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "beneficiary_facility_mapping_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity(name="BeneficiaryFacilityMappingReadOnly")
@Table(name = "beneficiary_facility_mapping")
@Immutable
public class BeneficiaryFacilityMappingReadOnly extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( generator = "beneficiary_facility_mapping")
	private Long id;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name="is_transferred")
	private Boolean isTransferred;

	@Column(name = "pre_art_number")
	private String preArtNumber;

	@Column(name = "art_number")
	private String artNumber;

	@Column(name = "pid")
	private String pid;

	@Column(name = "registration_date")
	private LocalDate registrationDate;
	
	// bi-directional many-to-one association to Beneficiary
	@ManyToOne
	@JoinColumn(name = "beneficiary_id")
	private BeneficiaryReadOnly beneficiary;

	// bi-directional many-to-one association to Facility
	@ManyToOne
	private FacilityReadOnly facility;
	

	public BeneficiaryFacilityMappingReadOnly() {
	}


	public Long getId() {
	    return id;
	}


	public void setId(Long id) {
	    this.id = id;
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


	public Boolean getIsTransferred() {
	    return isTransferred;
	}


	public void setIsTransferred(Boolean isTransferred) {
	    this.isTransferred = isTransferred;
	}


	public String getPreArtNumber() {
	    return preArtNumber;
	}


	public void setPreArtNumber(String preArtNumber) {
	    this.preArtNumber = preArtNumber;
	}


	public String getArtNumber() {
	    return artNumber;
	}


	public void setArtNumber(String artNumber) {
	    this.artNumber = artNumber;
	}


	public String getPid() {
	    return pid;
	}


	public void setPid(String pid) {
	    this.pid = pid;
	}


	public LocalDate getRegistrationDate() {
	    return registrationDate;
	}


	public void setRegistrationDate(LocalDate registrationDate) {
	    this.registrationDate = registrationDate;
	}


	public BeneficiaryReadOnly getBeneficiary() {
	    return beneficiary;
	}


	public void setBeneficiary(BeneficiaryReadOnly beneficiary) {
	    this.beneficiary = beneficiary;
	}


	public FacilityReadOnly getFacility() {
	    return facility;
	}


	public void setFacility(FacilityReadOnly facility) {
	    this.facility = facility;
	}













	

}
