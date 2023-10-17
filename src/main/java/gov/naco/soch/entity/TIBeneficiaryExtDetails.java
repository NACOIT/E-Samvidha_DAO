package gov.naco.soch.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;



@GenericGenerator(name = "benExtSequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "ti_ben_ext_details_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "ti_ben_ext_details")
public class TIBeneficiaryExtDetails extends Auditable<Long>   implements Serializable {

private static final long serialVersionUID = 1L;


@Id
@GeneratedValue(generator = "benExtSequence")
private Long id;

@Column(name = "within_the_district_no_of_times")
private String withinTheDistrictNoOfTimes;

@Column(name = "within_the_district_no_of_days")
private String withinTheDistrictNoOfDays;

@Column(name = "within_the_state_no_of_times")
private String withinTheStateNoOfTimes;

@Column(name = "within_the_state_no_of_days")
private String withinTheStateNoOfDays;

@Column(name = "outside_the_state_no_of_times")
private String outsideTheStateNoOfTimes;

@Column(name = "outside_the_state_no_of_days")
private String outsideTheStateNoOfDays;

@Column(name = "monday_avbl")
private Boolean mondayAvbl;

@Column(name = "tuesday_avbl")
private Boolean tuesdayAvbl;

@Column(name = "wednesday_avbl")
private Boolean wednesdayAvbl;

@Column(name = "thursday_avbl")
private Boolean thursdayAvbl;

@Column(name = "friday_avbl")
private Boolean fridayAvbl;

@Column(name = "saturday_avbl")
private Boolean saturdayAvbl;

@Column(name = "sunday_avbl")
private Boolean sundayAvbl;

@Column(name = "referred_facility")
private String referredFacility;

@Column(name = "referred_to")
private String referredTo;

@Column(name = "referral_status")
private String referralStatus;

@Column(name = "is_outward_referal")
private Boolean isOutwardReferal;

@Column(name = "guardian_name")
private String guardianName;

@Column(name = "relation")
private String relation;

@Column(name = "guardian_contact_number")
private String guardianContactNumber;

//bi-directional many-to-one association to Facility
@ManyToOne(fetch = FetchType.LAZY)
private Facility facility;

@OneToOne
@JoinColumn(name = "beneficiary_id")
private TIBeneficiary beneficiary; 


@OneToMany(mappedBy="tiBeneficiaryExtDetails",cascade = CascadeType.ALL)
private Set<ExtDetailsTimeAvailabilityMapping> extDetailsTimeAvailabilityMapping;


public TIBeneficiaryExtDetails() {

}

public TIBeneficiaryExtDetails(TIBeneficiaryExtDetails tiBeneficiaryExtDetails) {
   this.id=tiBeneficiaryExtDetails.getId();
   this.facility=tiBeneficiaryExtDetails.getFacility();
   this.beneficiary=tiBeneficiaryExtDetails.getBeneficiary();
}

public TIBeneficiaryExtDetails(Long extId, String wDistCountTimes, String wDistCountDays, String wStateCountTimes,
	String wStateCountDays, String oStateCountTimes, String oStateCountDays, Boolean monday, Boolean tuesday,
	Boolean wednesday, Boolean thursday, Boolean friday, Boolean saturday, Boolean sunday ,String extReferredFrom,
	String extReferredTo, String referralStatus2, String guardianContact, String guardianName2,
	Boolean isOutwardRef, String relation2, Long extFacId, Long extBenId, Long timeAvailId,
	Boolean timeAvailisActive, Boolean timeAvailisDelete, Long timeAvailExtId, Long masterTimeId,
	String masterTimeName) {
   this.id=extId;
   this.withinTheDistrictNoOfTimes=wDistCountTimes;
   this.withinTheDistrictNoOfDays=wDistCountDays;
   this.withinTheStateNoOfTimes=wStateCountTimes;
   this.withinTheStateNoOfDays=wStateCountDays;
   this.outsideTheStateNoOfTimes=oStateCountTimes;
   this.outsideTheStateNoOfDays=oStateCountDays;
   this.mondayAvbl=monday;
   this.tuesdayAvbl=tuesday;
   this.wednesdayAvbl=wednesday;
   this.thursdayAvbl=thursday;
   this.fridayAvbl=friday;
   this.saturdayAvbl=saturday;
   this.sundayAvbl=sunday;
   this.referredFacility=extReferredFrom;
   this.referredTo=extReferredTo;
   this.referralStatus=referralStatus2;
   this.guardianContactNumber=guardianContact;
   this.guardianName=guardianName2;
   this.isOutwardReferal=isOutwardRef;
   this.relation=relation2;
   this.facility=new Facility(extFacId);
   this.beneficiary=new TIBeneficiary(extBenId);
   this.extDetailsTimeAvailabilityMapping=new  HashSet<>();
   this.extDetailsTimeAvailabilityMapping.add(new ExtDetailsTimeAvailabilityMapping(timeAvailId,
	   timeAvailisActive,timeAvailisDelete,timeAvailExtId, masterTimeId,
		masterTimeName));
}

public TIBeneficiaryExtDetails(Long timeAvailExtId) {
this.id=timeAvailExtId;
}

// jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getWithinTheDistrictNoOfTimes() {
	return withinTheDistrictNoOfTimes;
}

public void setWithinTheDistrictNoOfTimes(String withinTheDistrictNoOfTimes) {
	this.withinTheDistrictNoOfTimes = withinTheDistrictNoOfTimes;
}

public String getWithinTheDistrictNoOfDays() {
	return withinTheDistrictNoOfDays;
}

public void setWithinTheDistrictNoOfDays(String withinTheDistrictNoOfDays) {
	this.withinTheDistrictNoOfDays = withinTheDistrictNoOfDays;
}

public String getWithinTheStateNoOfTimes() {
	return withinTheStateNoOfTimes;
}

public void setWithinTheStateNoOfTimes(String withinTheStateNoOfTimes) {
	this.withinTheStateNoOfTimes = withinTheStateNoOfTimes;
}

public String getWithinTheStateNoOfDays() {
	return withinTheStateNoOfDays;
}

public void setWithinTheStateNoOfDays(String withinTheStateNoOfDays) {
	this.withinTheStateNoOfDays = withinTheStateNoOfDays;
}

public String getOutsideTheStateNoOfTimes() {
	return outsideTheStateNoOfTimes;
}

public void setOutsideTheStateNoOfTimes(String outsideTheStateNoOfTimes) {
	this.outsideTheStateNoOfTimes = outsideTheStateNoOfTimes;
}

public String getOutsideTheStateNoOfDays() {
	return outsideTheStateNoOfDays;
}

public void setOutsideTheStateNoOfDays(String outsideTheStateNoOfDays) {
	this.outsideTheStateNoOfDays = outsideTheStateNoOfDays;
}

public Boolean getMondayAvbl() {
	return mondayAvbl;
}

public void setMondayAvbl(Boolean mondayAvbl) {
	this.mondayAvbl = mondayAvbl;
}

public Boolean getTuesdayAvbl() {
	return tuesdayAvbl;
}

public void setTuesdayAvbl(Boolean tuesdayAvbl) {
	this.tuesdayAvbl = tuesdayAvbl;
}

public Boolean getWednesdayAvbl() {
	return wednesdayAvbl;
}

public void setWednesdayAvbl(Boolean wednesdayAvbl) {
	this.wednesdayAvbl = wednesdayAvbl;
}

public Boolean getThursdayAvbl() {
	return thursdayAvbl;
}

public void setThursdayAvbl(Boolean thursdayAvbl) {
	this.thursdayAvbl = thursdayAvbl;
}

public Boolean getFridayAvbl() {
	return fridayAvbl;
}

public void setFridayAvbl(Boolean fridayAvbl) {
	this.fridayAvbl = fridayAvbl;
}

public Boolean getSaturdayAvbl() {
	return saturdayAvbl;
}

public void setSaturdayAvbl(Boolean saturdayAvbl) {
	this.saturdayAvbl = saturdayAvbl;
}

public Boolean getSundayAvbl() {
	return sundayAvbl;
}

public void setSundayAvbl(Boolean sundayAvbl) {
	this.sundayAvbl = sundayAvbl;
}

public String getReferredFacility() {
	return referredFacility;
}

public void setReferredFacility(String referredFacility) {
	this.referredFacility = referredFacility;
}

public String getReferredTo() {
	return referredTo;
}

public void setReferredTo(String referredTo) {
	this.referredTo = referredTo;
}

public String getReferralStatus() {
	return referralStatus;
}

public void setReferralStatus(String referralStatus) {
	this.referralStatus = referralStatus;
}

public Boolean getIsOutwardReferal() {
	return isOutwardReferal;
}

public void setIsOutwardReferal(Boolean isOutwardReferal) {
	this.isOutwardReferal = isOutwardReferal;
}

public String getGuardianName() {
	return guardianName;
}

public void setGuardianName(String guardianName) {
	this.guardianName = guardianName;
}

public String getRelation() {
	return relation;
}

public void setRelation(String relation) {
	this.relation = relation;
}

public String getGuardianContactNumber() {
	return guardianContactNumber;
}

public void setGuardianContactNumber(String guardianContactNumber) {
	this.guardianContactNumber = guardianContactNumber;
}

public TIBeneficiary getBeneficiary() {
	return beneficiary;
}

public void setBeneficiary(TIBeneficiary beneficiary) {
	this.beneficiary = beneficiary;
}

public Facility getFacility() {
	return facility;
}

public void setFacility(Facility facility) {
	this.facility = facility;
}

public Set<ExtDetailsTimeAvailabilityMapping> getExtDetailsTimeAvailabilityMapping() {
	return extDetailsTimeAvailabilityMapping;
}

public void setExtDetailsTimeAvailabilityMapping(
		Set<ExtDetailsTimeAvailabilityMapping> extDetailsTimeAvailabilityMapping) {
	this.extDetailsTimeAvailabilityMapping = extDetailsTimeAvailabilityMapping;
	if (extDetailsTimeAvailabilityMapping != null) {
		for (ExtDetailsTimeAvailabilityMapping extDetailsTimeAvailabilityMapper : extDetailsTimeAvailabilityMapping) {
			this.extDetailsTimeAvailabilityMapping.add(addTiOstFollowUpBy(extDetailsTimeAvailabilityMapper));
		}
	}
}

public ExtDetailsTimeAvailabilityMapping addTiOstFollowUpBy(ExtDetailsTimeAvailabilityMapping extDetailsTimeAvailabilityMapping) {
	getExtDetailsTimeAvailabilityMapping().add(extDetailsTimeAvailabilityMapping);
	extDetailsTimeAvailabilityMapping.setTiBeneficiaryExtDetails(this);
	return extDetailsTimeAvailabilityMapping;
}

public ExtDetailsTimeAvailabilityMapping removeTiOstFollowUpBy(ExtDetailsTimeAvailabilityMapping extDetailsTimeAvailabilityMapping) {
	getExtDetailsTimeAvailabilityMapping().remove(extDetailsTimeAvailabilityMapping);
	extDetailsTimeAvailabilityMapping.setTiBeneficiaryExtDetails(null);
	return extDetailsTimeAvailabilityMapping;
}

}



