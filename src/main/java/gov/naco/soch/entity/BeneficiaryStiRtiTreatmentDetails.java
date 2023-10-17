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


@GenericGenerator(name = "beneficiaryStiRtiTreatmentDetails", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "beneficiaryStiRtiTreatmentDetails_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "beneficiary_sti_rti_treatment_details")
public class BeneficiaryStiRtiTreatmentDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "beneficiaryStiRtiTreatmentDetails")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clinical_treatment_id")
	private BeneficiaryClinicalTreatment beneficiaryClinicalTreatment;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clinical_treatment_type_id")
	private MasterClinicalTreatmentType masterClinicalTreatmentType;
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sti_rti_diagnosis_type_id")
	private MasterStiRtiDiagnosisType masterStiRtiDiagnosisType;*/
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sti_rti_diagnosis_type_id")
	private MasterDiagnosisType masterDiagnosisType;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "facility_id")
	private Facility facility;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="sti_rti_prod_id")
	private Product product;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "facility_stock_id")
	private FacilityStock facilityStock;
	
	@Column(name = "followup_date")
	private LocalDate followupDate;

	@Column(name = "next_followup_date")
	private LocalDate nextFollowupDate;
	
	@Column(name = "followup_cycle_count")
	private Long FollowupCycleCount;
	
	@Column(name = "batch_number")
	private String batchNumber;
	
	@Column(name = "available_qty")
	private Long availableQty;
	
	@Column(name = "dispense_qty")
	private Long dispenseQty;
	
	@Column(name = "is_partner_notified")
	private Boolean isPartnerNotified;
	
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
	

	@Column(name = "is_rescheduled")
	private Boolean isRescheduled;
	
	@Column(name = "treatment_record_count")
	private Long treatmentRecordCount;
	
	@Column(name = "refer_to")
	private Long referTo;
	
	@Column(name = "test_type_conducted")
	private Long testTypeConducted;
	
	public BeneficiaryStiRtiTreatmentDetails() {
	}

	public Long getTreatmentRecordCount() {
		return treatmentRecordCount;
	}

	public void setTreatmentRecordCount(Long treatmentRecordCount) {
		this.treatmentRecordCount = treatmentRecordCount;
	}

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

	/*public MasterStiRtiDiagnosisType getMasterStiRtiDiagnosisType() {
		return masterStiRtiDiagnosisType;
	}

	public void setMasterStiRtiDiagnosisType(MasterStiRtiDiagnosisType masterStiRtiDiagnosisType) {
		this.masterStiRtiDiagnosisType = masterStiRtiDiagnosisType;
	}*/

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public FacilityStock getFacilityStock() {
		return facilityStock;
	}

	public void setFacilityStock(FacilityStock facilityStock) {
		this.facilityStock = facilityStock;
	}

	public LocalDate getFollowupDate() {
		return followupDate;
	}

	public void setFollowupDate(LocalDate followupDate) {
		this.followupDate = followupDate;
	}

	public LocalDate getNextFollowupDate() {
		return nextFollowupDate;
	}

	public void setNextFollowupDate(LocalDate nextFollowupDate) {
		this.nextFollowupDate = nextFollowupDate;
	}

	public Long getFollowupCycleCount() {
		return FollowupCycleCount;
	}

	public void setFollowupCycleCount(Long followupCycleCount) {
		FollowupCycleCount = followupCycleCount;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public Long getAvailableQty() {
		return availableQty;
	}

	public void setAvailableQty(Long availableQty) {
		this.availableQty = availableQty;
	}

	public Long getDispenseQty() {
		return dispenseQty;
	}

	public void setDispenseQty(Long dispenseQty) {
		this.dispenseQty = dispenseQty;
	}

	public Boolean getIsPartnerNotified() {
		return isPartnerNotified;
	}

	public void setIsPartnerNotified(Boolean isPartnerNotified) {
		this.isPartnerNotified = isPartnerNotified;
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

	public Boolean getIsRescheduled() {
		return isRescheduled;
	}

	public void setIsRescheduled(Boolean isRescheduled) {
		this.isRescheduled = isRescheduled;
	}

	public MasterDiagnosisType getMasterDiagnosisType() {
		return masterDiagnosisType;
	}

	public void setMasterDiagnosisType(MasterDiagnosisType masterDiagnosisType) {
		this.masterDiagnosisType = masterDiagnosisType;
	}

	public Long getReferTo() {
		return referTo;
	}

	public void setReferTo(Long referTo) {
		this.referTo = referTo;
	}

	public Long getTestTypeConducted() {
		return testTypeConducted;
	}

	public void setTestTypeConducted(Long testTypeConducted) {
		this.testTypeConducted = testTypeConducted;
	}
	
	
	
}
