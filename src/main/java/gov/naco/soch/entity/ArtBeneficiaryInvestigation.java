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

/**
 * The persistent class for the art_beneficiary_investigation database table.
 * 
 */
@GenericGenerator(name = "art_beneficiary_investigation", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "art_beneficiary_investigation_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })

@Entity
@Table(name = "art_beneficiary_investigation")
@NamedQuery(name = "ArtBeneficiaryInvestigation.findAll", query = "SELECT a FROM ArtBeneficiaryInvestigation a")
public class ArtBeneficiaryInvestigation extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "art_beneficiary_investigation")
	private Long id;

	@Column(name = "investigation_date")
	private LocalDate investigationDate;

	@Column(name = "investigation_value")
	private String investigationValue;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "visit_register_id")
	private Long visitRegisterId;

	// bi-directional many-to-one association to Beneficiary
	@ManyToOne(fetch = FetchType.LAZY)
	private Beneficiary beneficiary;

	// bi-directional many-to-one association to Facility
	@ManyToOne(fetch = FetchType.LAZY)
	private Facility facility;

	// bi-directional many-to-one association to MasterInvestigation
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "investigation_id")
	private MasterInvestigation masterInvestigation;

	public ArtBeneficiaryInvestigation() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getInvestigationDate() {
		return this.investigationDate;
	}

	public void setInvestigationDate(LocalDate investigationDate) {
		this.investigationDate = investigationDate;
	}


	public String getInvestigationValue() {
		return investigationValue;
	}

	public void setInvestigationValue(String investigationValue) {
		this.investigationValue = investigationValue;
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

	public Long getVisitRegisterId() {
		return this.visitRegisterId;
	}

	public void setVisitRegisterId(Long visitRegisterId) {
		this.visitRegisterId = visitRegisterId;
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

	public MasterInvestigation getMasterInvestigation() {
		return this.masterInvestigation;
	}

	public void setMasterInvestigation(MasterInvestigation masterInvestigation) {
		this.masterInvestigation = masterInvestigation;
	}

}