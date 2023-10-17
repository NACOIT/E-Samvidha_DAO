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
 * The persistent class for the facility_stock_adjustment database table.
 * 
 */
@Entity
@GenericGenerator(name = "facility_stock_adjustment", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "facility_stock_adjustment_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Table(name = "facility_stock_adjustment")
@NamedQuery(name = "FacilityStockAdjustment.findAll", query = "SELECT f FROM FacilityStockAdjustment f")
public class FacilityStockAdjustment extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "facility_stock_adjustment")
	private Long id;

	@Column(name = "adjust_stock_quantity")
	private Long adjustStockQuantity;

	@Column(name = "current_quantity")
	private Long currentQuantity;

	@Column(name = "batch_number")
	private String batchNumber;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	private String remark;

	@Column(name = "date_of_addition_or_consupmtion")
	private LocalDate dateOfAdditionOrConsumption;

	@Column(name = "bulk_dispense_quantity")
	private Long bulkDispenseQuantity;

	@Column(name = "wastage_quantity")
	private Long wastageQuantity;

	@Column(name = "testing_quantity")
	private Long testingQuantity;

	@Column(name = "qa_quantity")
	private Long qaQuantity;

	@Column(name = "control_quantity")
	private Long controlQuantity;

	@Column(name = "beneficiary_quantity")
	private Long beneficiaryQuantity;

	@Column(name = "other_quantity")
	private Long otherQuantity;

	@Column(name = "total_quantity")
	private Long totalQuantity;

	// bi-directional many-to-one association to Facility
	@ManyToOne(fetch=FetchType.LAZY)
	private Facility facility;

	// bi-directional many-to-one association to FacilityStockAdjustmentTypeMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "type")
	private FacilityStockAdjustmentTypeMaster facilityStockAdjustmentTypeMaster;

	// bi-directional many-to-one association to FacilityStockAdjustmentTypeReason
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "reason_code")
	private FacilityStockAdjustmentTypeReason facilityStockAdjustmentTypeReason;

	// bi-directional many-to-one association to Product
	@ManyToOne(fetch=FetchType.LAZY)
	private Product product;

	public FacilityStockAdjustment() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAdjustStockQuantity() {
		return this.adjustStockQuantity;
	}

	public void setAdjustStockQuantity(Long adjustStockQuantity) {
		this.adjustStockQuantity = adjustStockQuantity;
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

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public FacilityStockAdjustmentTypeMaster getFacilityStockAdjustmentTypeMaster() {
		return this.facilityStockAdjustmentTypeMaster;
	}

	public void setFacilityStockAdjustmentTypeMaster(
			FacilityStockAdjustmentTypeMaster facilityStockAdjustmentTypeMaster) {
		this.facilityStockAdjustmentTypeMaster = facilityStockAdjustmentTypeMaster;
	}

	public FacilityStockAdjustmentTypeReason getFacilityStockAdjustmentTypeReason() {
		return this.facilityStockAdjustmentTypeReason;
	}

	public void setFacilityStockAdjustmentTypeReason(
			FacilityStockAdjustmentTypeReason facilityStockAdjustmentTypeReason) {
		this.facilityStockAdjustmentTypeReason = facilityStockAdjustmentTypeReason;
	}

	public Product getProduct() {
		return this.product;
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

	public Long getCurrentQuantity() {
		return currentQuantity;
	}

	public void setCurrentQuantity(Long currentQuantity) {
		this.currentQuantity = currentQuantity;
	}

	public LocalDate getDateOfAdditionOrConsumption() {
		return dateOfAdditionOrConsumption;
	}

	public void setDateOfAdditionOrConsumption(LocalDate dateOfAdditionOrConsumption) {
		this.dateOfAdditionOrConsumption = dateOfAdditionOrConsumption;
	}

	public Long getBulkDispenseQuantity() {
		return bulkDispenseQuantity;
	}

	public void setBulkDispenseQuantity(Long bulkDispenseQuantity) {
		this.bulkDispenseQuantity = bulkDispenseQuantity;
	}

	public Long getWastageQuantity() {
		return wastageQuantity;
	}

	public void setWastageQuantity(Long wastageQuantity) {
		this.wastageQuantity = wastageQuantity;
	}

	public Long getTestingQuantity() {
		return testingQuantity;
	}

	public void setTestingQuantity(Long testingQuantity) {
		this.testingQuantity = testingQuantity;
	}

	public Long getQaQuantity() {
		return qaQuantity;
	}

	public void setQaQuantity(Long qaQuantity) {
		this.qaQuantity = qaQuantity;
	}

	public Long getControlQuantity() {
		return controlQuantity;
	}

	public void setControlQuantity(Long controlQuantity) {
		this.controlQuantity = controlQuantity;
	}

	public Long getBeneficiaryQuantity() {
		return beneficiaryQuantity;
	}

	public void setBeneficiaryQuantity(Long beneficiaryQuantity) {
		this.beneficiaryQuantity = beneficiaryQuantity;
	}

	public Long getOtherQuantity() {
		return otherQuantity;
	}

	public void setOtherQuantity(Long otherQuantity) {
		this.otherQuantity = otherQuantity;
	}

	public Long getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(Long totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

}