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

@GenericGenerator(name = "beneficiarySyphilisTreatmentDetails", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "beneficiarySyphilisTreatmentDetails_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name="beneficiary_syphilis_treatment_details")
public class BeneficiarySyphilisTreatmentDetails implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "beneficiarySyphilisTreatmentDetails")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clinical_treatment_id")
	private BeneficiaryClinicalTreatment beneficiaryClinicalTreatment;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clinical_treatment_type_id")
	private MasterClinicalTreatmentType masterClinicalTreatmentType;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "syphilis_test_type_id")
	private MasterSyphilisTestType masterSyphilisTestType;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "syphilis_test_result_id")
	private MasterSyphilisTestResult masterSyphilisTestResult;
	
	@Column(name = "titre")
	private String titre;
	
	@Column(name = "Is_hiv_test_done")
	private Boolean isHivTestDone;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hiv_status_id")
	private MasterHivStatus hivStatusId;
	
	@Column(name = "syphilis_followup_date")
	private LocalDate syphilisFollowupDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "facility_stock_id")
	private FacilityStock facilityStock;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "facility_id")
	private Facility facility;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "syphilis_prod_id")
	private Product product;
	
	@Column(name = "batch_number")
	private String batchNumber;
	
	@Column(name = "available_qty")
	private Long availableQty;
	
	@Column(name = "dispense_qty")
	private Long dispenseQty;
	
	@Column(name = "is_treatment_completed")
	private Boolean isTreatmentCompleted;
	
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

	@Column(name = "is_rescheduled")
	private Boolean isRescheduled;

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

	public MasterSyphilisTestType getMasterSyphilisTestType() {
		return masterSyphilisTestType;
	}

	public void setMasterSyphilisTestType(MasterSyphilisTestType masterSyphilisTestType) {
		this.masterSyphilisTestType = masterSyphilisTestType;
	}

	public MasterSyphilisTestResult getMasterSyphilisTestResult() {
		return masterSyphilisTestResult;
	}

	public void setMasterSyphilisTestResult(MasterSyphilisTestResult masterSyphilisTestResult) {
		this.masterSyphilisTestResult = masterSyphilisTestResult;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Boolean getIsHivTestDone() {
		return isHivTestDone;
	}

	public void setIsHivTestDone(Boolean isHivTestDone) {
		this.isHivTestDone = isHivTestDone;
	}

	public MasterHivStatus getHivStatusId() {
		return hivStatusId;
	}

	public void setHivStatusId(MasterHivStatus hivStatusId) {
		this.hivStatusId = hivStatusId;
	}

	public LocalDate getSyphilisFollowupDate() {
		return syphilisFollowupDate;
	}

	public void setSyphilisFollowupDate(LocalDate syphilisFollowupDate) {
		this.syphilisFollowupDate = syphilisFollowupDate;
	}

	public FacilityStock getFacilityStock() {
		return facilityStock;
	}

	public void setFacilityStock(FacilityStock facilityStock) {
		this.facilityStock = facilityStock;
	}

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

	public Boolean getIsTreatmentCompleted() {
		return isTreatmentCompleted;
	}

	public void setIsTreatmentCompleted(Boolean isTreatmentCompleted) {
		this.isTreatmentCompleted = isTreatmentCompleted;
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

	public Boolean getIsRescheduled() {
		return isRescheduled;
	}

	public void setIsRescheduled(Boolean isRescheduled) {
		this.isRescheduled = isRescheduled;
	}
	
	
}
