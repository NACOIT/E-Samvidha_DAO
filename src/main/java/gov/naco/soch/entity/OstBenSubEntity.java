package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "OstBenSubEntity", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "ti_ost_beneficiary_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })

@NamedEntityGraph(name = "OstBenSubEntity", attributeNodes = { @NamedAttributeNode("tiOstPrescriptions"),
		@NamedAttributeNode("ostStatus"), @NamedAttributeNode("ostAssess"), @NamedAttributeNode("ostFollowUp"),
		@NamedAttributeNode("tiOstDispensationItems") })
@Entity(name = "OstBenSubEntity")
@Table(name = "ti_ost_beneficiary")
@Immutable
public class OstBenSubEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Long id;

	@Column(name = "ost_code")
	private String ostCode;

	@Size(max = 25)
	@Column(name = "ost_number")
	private String ostNumber;

	@Column(name = "consent_documented")
	private Boolean consentDocumented;

	@Column(name = "registration_date")
	private LocalDate registrationDate;

	@Column(name = "followups")
	private Integer followups;

	@Column(name = "consent_taken_date")
	private LocalDate consentTakenDate;

	@ManyToOne
	@JoinColumn(name = "ost_status_id")
	private MasterBeneficiaryOstStatus ostStatus;

	@ManyToOne
	private MasterBenSubEntity beneficiary;

	@OneToMany(mappedBy = "tiOstBeneficiary")
	private Set<OstPrescription> tiOstPrescriptions;

	@OneToMany(mappedBy = "tiOstBeneficiary")
	private Set<OstAssessment> ostAssess;

	@ManyToOne
	@JoinColumn(name = "status_id")
	private MasterOstClientStatus status;

	@Column(name = "facility_id")
	private Long facilityId;

	@Column(name = "is_transit")
	private Boolean isTransit;

	@Column(name = "linked_facility_id")
	private Long linkedFacilityId;

	@ManyToOne
	@JoinColumn(name = "referred_from_id")
	private MasterReferredfrom referredFrom;

	@OneToMany(mappedBy = "tiOstBeneficiary", cascade = CascadeType.ALL)
	private Set<BeneficiaryTransitFacilityReadOnly> transitFacilities;

	@OneToMany(mappedBy = "tiOstBeneficiary")
	private Set<OstDispensationItem> tiOstDispensationItems;

	@OneToMany(mappedBy = "tiOstBeneficiary")
	private Set<OstFollowUp> ostFollowUp;

	@Column(name = "transit_end_date")
	private LocalDate transitEndDate;

	@Column(name = "transit_start_date")
	private LocalDate transitStartDate;
	
    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_delete")
    private Boolean isDeleted;

	public OstBenSubEntity() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOstCode() {
		return ostCode;
	}

	public void setOstCode(String ostCode) {
		this.ostCode = ostCode;
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public String getOstNumber() {
		return ostNumber;
	}

	public void setOstNumber(String ostNumber) {
		this.ostNumber = ostNumber;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public MasterOstClientStatus getStatus() {
		return status;
	}

	public void setStatus(MasterOstClientStatus status) {
		this.status = status;
	}

	public Boolean getConsentDocumented() {
		return consentDocumented;
	}

	public void setConsentDocumented(Boolean consentDocumented) {
		this.consentDocumented = consentDocumented;
	}

	public MasterReferredfrom getReferredFrom() {
		return referredFrom;
	}

	public void setReferredFrom(MasterReferredfrom referredFrom) {
		this.referredFrom = referredFrom;
	}

	public Integer getFollowups() {
		return followups;
	}

	public void setFollowups(Integer followups) {
		this.followups = followups;
	}

	public LocalDate getConsentTakenDate() {
		return consentTakenDate;
	}

	public void setConsentTakenDate(LocalDate consentTakenDate) {
		this.consentTakenDate = consentTakenDate;
	}

	public MasterBeneficiaryOstStatus getOstStatus() {
		return ostStatus;
	}

	public void setOstStatus(MasterBeneficiaryOstStatus ostStatus) {
		this.ostStatus = ostStatus;
	}

	public MasterBenSubEntity getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(MasterBenSubEntity beneficiary) {
		this.beneficiary = beneficiary;
	}

	public Set<OstPrescription> getTiOstPrescriptions() {
		return tiOstPrescriptions;
	}

	public void setTiOstPrescriptions(Set<OstPrescription> tiOstPrescriptions) {
		this.tiOstPrescriptions = tiOstPrescriptions;
	}

	public Set<OstAssessment> getOstAssess() {
		return ostAssess;
	}

	public void setOstAssess(Set<OstAssessment> ostAssess) {
		this.ostAssess = ostAssess;
	}

	public Boolean getIsTransit() {
		return isTransit;
	}

	public void setIsTransit(Boolean isTransit) {
		this.isTransit = isTransit;
	}

	public Long getLinkedFacilityId() {
		return linkedFacilityId;
	}

	public void setLinkedFacilityId(Long linkedFacilityId) {
		this.linkedFacilityId = linkedFacilityId;
	}

	public Set<BeneficiaryTransitFacilityReadOnly> getTransitFacilities() {
		return transitFacilities;
	}

	public void setTransitFacilities(Set<BeneficiaryTransitFacilityReadOnly> transitFacilities) {
		this.transitFacilities = transitFacilities;
	}

	public Set<OstDispensationItem> getTiOstDispensationItems() {
		return tiOstDispensationItems;
	}

	public void setTiOstDispensationItems(Set<OstDispensationItem> tiOstDispensationItems) {
		this.tiOstDispensationItems = tiOstDispensationItems;
	}

	public Set<OstFollowUp> getOstFollowUp() {
		return ostFollowUp;
	}

	public void setOstFollowUp(Set<OstFollowUp> ostFollowUp) {
		this.ostFollowUp = ostFollowUp;
	}

	public LocalDate getTransitEndDate() {
		return transitEndDate;
	}

	public void setTransitEndDate(LocalDate transitEndDate) {
		this.transitEndDate = transitEndDate;
	}

	public LocalDate getTransitStartDate() {
		return transitStartDate;
	}

	public void setTransitStartDate(LocalDate transitStartDate) {
		this.transitStartDate = transitStartDate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	

}
