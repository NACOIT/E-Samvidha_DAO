package gov.naco.soch.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "beneficiaryOpioidOverdoseTreatmentDetails", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "beneficiaryOpioidOverdoseTreatmentDetails_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "beneficiary_opioid_overdose_treatment_details")
public class BeneficiaryOpioidOverdoseTreatmentDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "beneficiaryOpioidOverdoseTreatmentDetails")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clinical_treatment_id")
	private BeneficiaryClinicalTreatment beneficiaryClinicalTreatment;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clinical_treatment_type_id")
	private MasterClinicalTreatmentType masterClinicalTreatmentType;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "opioid_overdose_reasons_id")
	private MasterOpioidOverdoseReasons masterOpioidOverdoseReasons;
	
	@Column(name = "followup_date")
	private LocalDate followupDate;
	
	@Column(name = "is_taken_to_hospital")
	private Boolean isTakenToHospital;
	
	@Column(name = "is_attended_by_TI_staffs")
	private Boolean isAttendedByTIStaffs;

	@Column(name = "is_intervention_by_peers")
	private Boolean isInterventionByPeers;
	
	@Column(name = "is_intervention_by_family_members")
	private Boolean isInterventionByFamilyMembers;
	

	@Column(name = "is_left_unattended_at_time_of_overdose")
	private Boolean isLeftUnattendedAtTimeOfOverdose;
	

	@Column(name = "is_placed_in_recovery_position")
	private Boolean isPlacedInRecoveryPosition;
	

	@Column(name = "is_given_mouth_to_mouth_resuscitation")
	private Boolean isGivenMouthToMouthResuscitation;
	

	@Column(name = "is_given_naloxone")
	private Boolean isGivenNaloxone;
	

	@Column(name = "is_self_recovered")
	private Boolean isSelfRecovered;
	
	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "created_by")
	private Integer createdBy;

	@Column(name = "created_time")
	private Timestamp createdTime;

	@Column(name = "modified_by")
	private Integer modifiedBy;

	@Column(name = "modified_time")
	private Timestamp modifiedTime;
	
	@Column(name = "is_treatment_completed")
	private Boolean isTreatmentCompleted;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BeneficiaryClinicalTreatment getBeneficiaryClinicalTreatment() {
		return beneficiaryClinicalTreatment;
	}

	public void setBeneficiaryClinicalTreatment(BeneficiaryClinicalTreatment beneficiaryClinicalTreatment) {
		this.beneficiaryClinicalTreatment = beneficiaryClinicalTreatment;
	}

	public MasterClinicalTreatmentType getMasterClinicalTreatmentType() {
		return masterClinicalTreatmentType;
	}

	public void setMasterClinicalTreatmentType(MasterClinicalTreatmentType masterClinicalTreatmentType) {
		this.masterClinicalTreatmentType = masterClinicalTreatmentType;
	}

	public MasterOpioidOverdoseReasons getMasterOpioidOverdoseReasons() {
		return masterOpioidOverdoseReasons;
	}

	public void setMasterOpioidOverdoseReasons(MasterOpioidOverdoseReasons masterOpioidOverdoseReasons) {
		this.masterOpioidOverdoseReasons = masterOpioidOverdoseReasons;
	}

	public LocalDate getFollowupDate() {
		return followupDate;
	}

	public void setFollowupDate(LocalDate followupDate) {
		this.followupDate = followupDate;
	}

	public Boolean getIsTakenToHospital() {
		return isTakenToHospital;
	}

	public void setIsTakenToHospital(Boolean isTakenToHospital) {
		this.isTakenToHospital = isTakenToHospital;
	}

	public Boolean getIsAttendedByTIStaffs() {
		return isAttendedByTIStaffs;
	}

	public void setIsAttendedByTIStaffs(Boolean isAttendedByTIStaffs) {
		this.isAttendedByTIStaffs = isAttendedByTIStaffs;
	}

	public Boolean getIsInterventionByPeers() {
		return isInterventionByPeers;
	}

	public void setIsInterventionByPeers(Boolean isInterventionByPeers) {
		this.isInterventionByPeers = isInterventionByPeers;
	}

	public Boolean getIsInterventionByFamilyMembers() {
		return isInterventionByFamilyMembers;
	}

	public void setIsInterventionByFamilyMembers(Boolean isInterventionByFamilyMembers) {
		this.isInterventionByFamilyMembers = isInterventionByFamilyMembers;
	}

	public Boolean getIsLeftUnattendedAtTimeOfOverdose() {
		return isLeftUnattendedAtTimeOfOverdose;
	}

	public void setIsLeftUnattendedAtTimeOfOverdose(Boolean isLeftUnattendedAtTimeOfOverdose) {
		this.isLeftUnattendedAtTimeOfOverdose = isLeftUnattendedAtTimeOfOverdose;
	}

	public Boolean getIsPlacedInRecoveryPosition() {
		return isPlacedInRecoveryPosition;
	}

	public void setIsPlacedInRecoveryPosition(Boolean isPlacedInRecoveryPosition) {
		this.isPlacedInRecoveryPosition = isPlacedInRecoveryPosition;
	}

	public Boolean getIsGivenMouthToMouthResuscitation() {
		return isGivenMouthToMouthResuscitation;
	}

	public void setIsGivenMouthToMouthResuscitation(Boolean isGivenMouthToMouthResuscitation) {
		this.isGivenMouthToMouthResuscitation = isGivenMouthToMouthResuscitation;
	}

	public Boolean getIsGivenNaloxone() {
		return isGivenNaloxone;
	}

	public void setIsGivenNaloxone(Boolean isGivenNaloxone) {
		this.isGivenNaloxone = isGivenNaloxone;
	}

	public Boolean getIsSelfRecovered() {
		return isSelfRecovered;
	}

	public void setIsSelfRecovered(Boolean isSelfRecovered) {
		this.isSelfRecovered = isSelfRecovered;
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

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public Boolean getIsTreatmentCompleted() {
		return isTreatmentCompleted;
	}

	public void setIsTreatmentCompleted(Boolean isTreatmentCompleted) {
		this.isTreatmentCompleted = isTreatmentCompleted;
	}
	
}
