package gov.naco.soch.entity;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.time.LocalDate;

/**
 * The persistent class for the facility_linked_facility_beneficiary database
 * table.
 * 
 */
@GenericGenerator(name = "facility_linked_facility_beneficiary", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "facility_linked_facility_beneficiary_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "facility_linked_facility_beneficiary")
@NamedQuery(name = "FacilityLinkedFacilityBeneficiary.findAll", query = "SELECT f FROM FacilityLinkedFacilityBeneficiary f")
public class FacilityLinkedFacilityBeneficiary extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "facility_linked_facility_beneficiary")
	private Long id;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "is_linked")
	private Boolean isLinked;

	@Column(name = "link_date")
	private LocalDate linkDate;

	@Column(name = "unlink_date")
	private LocalDate unlinkDate;

	// bi-directional many-to-one association to Facility
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "linked_facility_id")
	private Facility linkedFacilityId;

	// bi-directional many-to-one association to Facility
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_facility_id")
	private Facility parentFacility;

	// bi-directional many-to-one association to FacilityType
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "facility_type")
	private FacilityType facilityTypeBean;

	// bi-directional many-to-one association to TiOstBeneficiary
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ost_beneficiary_id")
	private TiOstBeneficiary tiOstBeneficiary;

	// bi-directional many-to-one association to TiOstBeneficiary
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "beneficiary_id")
	private Beneficiary beneficiary;

	public FacilityLinkedFacilityBeneficiary() {
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

	public Boolean getIsLinked() {
		return isLinked;
	}

	public void setIsLinked(Boolean isLinked) {
		this.isLinked = isLinked;
	}

	public LocalDate getLinkDate() {
		return linkDate;
	}

	public void setLinkDate(LocalDate linkDate) {
		this.linkDate = linkDate;
	}

	public LocalDate getUnlinkDate() {
		return unlinkDate;
	}

	public void setUnlinkDate(LocalDate unlinkDate) {
		this.unlinkDate = unlinkDate;
	}

	public Facility getLinkedFacilityId() {
		return linkedFacilityId;
	}

	public void setLinkedFacilityId(Facility linkedFacilityId) {
		this.linkedFacilityId = linkedFacilityId;
	}

	public Facility getParentFacility() {
		return parentFacility;
	}

	public void setParentFacility(Facility parentFacility) {
		this.parentFacility = parentFacility;
	}

	public FacilityType getFacilityTypeBean() {
		return facilityTypeBean;
	}

	public void setFacilityTypeBean(FacilityType facilityTypeBean) {
		this.facilityTypeBean = facilityTypeBean;
	}

	public TiOstBeneficiary getTiOstBeneficiary() {
		return tiOstBeneficiary;
	}

	public void setTiOstBeneficiary(TiOstBeneficiary tiOstBeneficiary) {
		this.tiOstBeneficiary = tiOstBeneficiary;
	}

	public Beneficiary getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

}
