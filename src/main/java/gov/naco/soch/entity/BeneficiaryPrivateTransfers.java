package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "beneficiary_private_transfers", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "beneficiary_private_transfers_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })

@Entity
@Table(name = "beneficiary_private_transfers")
@NamedQuery(name = "BeneficiaryPrivateTransfers.findAll", query = "SELECT a FROM BeneficiaryPrivateTransfers a")
public class BeneficiaryPrivateTransfers extends Auditable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "beneficiary_private_transfers")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "source_facility_id")
	private Facility sourceFacility;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "source_facility_type_id")
	private FacilityType sourceFacilityType;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "beneficiary_id")
	private Beneficiary beneficiary;
	
	@Column(name = "transfer_date")
	private LocalDate transferDate;
	
	@Column(name = "transfer_to_private_facility_name")
	private String privateFacilityName;
	
	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;
	
	public BeneficiaryPrivateTransfers() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Facility getSourceFacility() {
		return sourceFacility;
	}

	public void setSourceFacility(Facility sourceFacility) {
		this.sourceFacility = sourceFacility;
	}

	public FacilityType getSourceFacilityType() {
		return sourceFacilityType;
	}

	public void setSourceFacilityType(FacilityType sourceFacilityType) {
		this.sourceFacilityType = sourceFacilityType;
	}

	public Beneficiary getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	public LocalDate getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(LocalDate transferDate) {
		this.transferDate = transferDate;
	}

	public String getPrivateFacilityName() {
		return privateFacilityName;
	}

	public void setPrivateFacilityName(String privateFacilityName) {
		this.privateFacilityName = privateFacilityName;
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
