package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
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
@Entity
@Table(name = "beneficiary_facility_mapping")
@NamedQuery(name = "BeneficiaryFacilityMapping.findAll", query = "SELECT b FROM BeneficiaryFacilityMapping b")
public class BeneficiaryFacilityMapping extends Auditable<Long> implements Serializable {
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

	@Column(name="mapping_updated_date")
	private LocalDate mappingUpdatedDate;

	@Column(name = "pre_art_number")
	private String preArtNumber;

	@Column(name = "art_number")
	private String artNumber;

	@Column(name = "pid")
	private String pid;

	@Column(name = "mapping_date")
	private LocalDate mappingDate;
	
	@Column(name = "art_previous_clinic")
	private String artPreviousClinic;
	
	@Column(name = "registration_date")
	private LocalDate registrationDate;
	
	// bi-directional many-to-one association to Beneficiary
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "beneficiary_id")
	private Beneficiary beneficiary;

	// bi-directional many-to-one association to Facility
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "facility_id")
	private Facility facility;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "previous_not_transferred_art_id")
	private Facility previousNotTransferredArtId;
	
	public BeneficiaryFacilityMapping() {
	}

	public BeneficiaryFacilityMapping(Long benFacId, Boolean benFacIsActive, Boolean benFacIsDelete,
		Long benFacFacilityId, Long benFacFacilityType,Long benFacBenId) {
	    
	    this.id=benFacId;
	    this.isActive=benFacIsActive;
	    this.isDelete=benFacIsDelete;
	    this.facility=new Facility(benFacFacilityId,benFacFacilityType);
	    this.beneficiary=new Beneficiary(benFacBenId);
	    
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Beneficiary getBeneficiary() {
		return this.beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public String getPreArtNumber() {
		return preArtNumber;
	}

	public void setPreArtNumber(String preArtNumber) {
		this.preArtNumber = preArtNumber;
	}

	public Boolean getIsTransferred() {
	    return isTransferred;
	}

	public void setIsTransferred(Boolean isTransferred) {
	    this.isTransferred = isTransferred;
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

	public LocalDate getMappingDate() {
		return mappingDate;
	}

	public void setMappingDate(LocalDate mappingDate) {
		this.mappingDate = mappingDate;
	}

	public String getArtPreviousClinic() {
		return artPreviousClinic;
	}

	public void setArtPreviousClinic(String artPreviousClinic) {
		this.artPreviousClinic = artPreviousClinic;
	}

	public Facility getPreviousNotTransferredArtId() {
		return previousNotTransferredArtId;
	}

	public void setPreviousNotTransferredArtId(Facility previousNotTransferredArtId) {
		this.previousNotTransferredArtId = previousNotTransferredArtId;
	}

	public Boolean getTransferred() {
		return isTransferred;
	}

	public void setTransferred(Boolean transferred) {
		isTransferred = transferred;
	}


	public LocalDate getMappingUpdatedDate() {
		return mappingUpdatedDate;
	}

	public void setMappingUpdatedDate(LocalDate mappingUpdatedDate) {
		this.mappingUpdatedDate = mappingUpdatedDate;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

//	public BeneficiaryVisitRegister getVisitRegister() {
//		return visitRegister;
//	}
//
//	public void setVisitRegister(BeneficiaryVisitRegister visitRegister) {
//		this.visitRegister = visitRegister;
//	}


}
