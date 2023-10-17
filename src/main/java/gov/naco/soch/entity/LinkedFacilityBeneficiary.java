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

@GenericGenerator(name = "facility_linked_facility_beneficiary", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "facility_linked_facility_beneficiary_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "facility_linked_facility_beneficiary")
@NamedQuery(name = "LinkedFacilityBeneficiary.findAll", query = "SELECT n FROM LinkedFacilityBeneficiary n")
public class LinkedFacilityBeneficiary extends Auditable<Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "facility_linked_facility_beneficiary")
	private Long id;

	@Column(name = "is_linked")
	private Boolean isLinked;

	@Column(name = "link_date")
	private LocalDate linkDate;

	@Column(name = "unlink_date")
	private LocalDate unlinkDate;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ost_beneficiary_id")
	private TiOstBeneficiary tiOstBeneficiary;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "beneficiary_id")
	private Beneficiary beneficiary;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_facility_id")
	private Facility parentFacility;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "linked_facility_id")
	private Facility linkedFacility;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "facility_type")
	private FacilityType facilityType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public TiOstBeneficiary getTiOstBeneficiary() {
		return tiOstBeneficiary;
	}

	public void setTiOstBeneficiary(TiOstBeneficiary tiOstBeneficiary) {
		this.tiOstBeneficiary = tiOstBeneficiary;
	}

	public Facility getParentFacility() {
		return parentFacility;
	}

	public void setParentFacility(Facility parentFacility) {
		this.parentFacility = parentFacility;
	}

	public Facility getLinkedFacility() {
		return linkedFacility;
	}

	public void setLinkedFacility(Facility linkedFacility) {
		this.linkedFacility = linkedFacility;
	}

	public FacilityType getFacilityType() {
		return facilityType;
	}

	public void setFacilityType(FacilityType facilityType) {
		this.facilityType = facilityType;
	}

	public Beneficiary getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

}
