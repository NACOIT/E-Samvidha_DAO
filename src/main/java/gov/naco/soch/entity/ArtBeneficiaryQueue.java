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
 * The persistent class for the art_beneficiary_queue database table.
 * 
 */
@GenericGenerator(name = "art_beneficiary_queue", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "art_beneficiary_queue_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "art_beneficiary_queue")
@NamedQuery(name = "ArtBeneficiaryQueue.findAll", query = "SELECT a FROM ArtBeneficiaryQueue a")
public class ArtBeneficiaryQueue extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "art_beneficiary_queue")
	private Long id;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "is_visited")
	private Boolean isVisited;

	@Column(name = "visit_date")
	private LocalDate visitDate;

	// bi-directional many-to-one association to Beneficiary
	@ManyToOne(fetch = FetchType.LAZY)
	private Beneficiary beneficiary;

	// bi-directional many-to-one association to BeneficiaryVisitRegister
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "visit_register_id")
	private BeneficiaryVisitRegister beneficiaryVisitRegister;

	// bi-directional many-to-one association to Facility
	@ManyToOne(fetch = FetchType.LAZY)
	private Facility facility;

	// bi-directional many-to-one association to UserMaster
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "assigned_to")
	private UserMaster assignedToUser;

	// bi-directional many-to-one association to UserMaster
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "entry_user")
	private UserMaster entryUser;

	public ArtBeneficiaryQueue() {
	}

	public Long getId() {
		return id;
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

	public Boolean getIsVisited() {
		return this.isVisited;
	}

	public void setIsVisited(Boolean isVisited) {
		this.isVisited = isVisited;
	}

	public Beneficiary getBeneficiary() {
		return this.beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	public BeneficiaryVisitRegister getBeneficiaryVisitRegister() {
		return this.beneficiaryVisitRegister;
	}

	public void setBeneficiaryVisitRegister(BeneficiaryVisitRegister beneficiaryVisitRegister) {
		this.beneficiaryVisitRegister = beneficiaryVisitRegister;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public UserMaster getAssignedToUser() {
		return this.assignedToUser;
	}

	public void setAssignedToUser(UserMaster assignedToUser) {
		this.assignedToUser = assignedToUser;
	}

	public UserMaster getEntryUser() {
		return this.entryUser;
	}

	public void setEntryUser(UserMaster entryUser) {
		this.entryUser = entryUser;
	}

	public LocalDate getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(LocalDate visitDate) {
		this.visitDate = visitDate;
	}

}