package gov.naco.soch.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the facility_stock_adjustment_type_reasons database
 * table.
 * 
 */
@Entity
@GenericGenerator(name = "facility_stock_adjustment_type_reasons", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "facility_stock_adjustment_type_reasons_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Table(name = "facility_stock_adjustment_type_reasons")
@NamedQuery(name = "FacilityStockAdjustmentTypeReason.findAll", query = "SELECT f FROM FacilityStockAdjustmentTypeReason f")
public class FacilityStockAdjustmentTypeReason implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "facility_stock_adjustment_type_reasons")
	private Long id;

	@Column(name = "created_by")
	private Long createdBy;

	@Column(name = "created_time")
	private Timestamp createdTime;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "modified_by")
	private Long modifiedBy;

	@Column(name = "modified_time")
	private Timestamp modifiedTime;

	@Column(name = "stock_adjustment_reason")
	private String stockAdjustmentReason;

	// bi-directional many-to-one association to FacilityStockAdjustment
	@OneToMany(mappedBy = "facilityStockAdjustmentTypeReason")
	private Set<FacilityStockAdjustment> facilityStockAdjustments;

	// bi-directional many-to-one association to FacilityStockAdjustmentTypeMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "adjust_type")
	private FacilityStockAdjustmentTypeMaster facilityStockAdjustmentTypeMaster;

	public FacilityStockAdjustmentTypeReason() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
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

	public Long getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getModifiedTime() {
		return this.modifiedTime;
	}

	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getStockAdjustmentReason() {
		return this.stockAdjustmentReason;
	}

	public void setStockAdjustmentReason(String stockAdjustmentReason) {
		this.stockAdjustmentReason = stockAdjustmentReason;
	}

	public Set<FacilityStockAdjustment> getFacilityStockAdjustments() {
		return this.facilityStockAdjustments;
	}

	public void setFacilityStockAdjustments(Set<FacilityStockAdjustment> facilityStockAdjustments) {
		this.facilityStockAdjustments = facilityStockAdjustments;
	}

	public FacilityStockAdjustment addFacilityStockAdjustment(FacilityStockAdjustment facilityStockAdjustment) {
		getFacilityStockAdjustments().add(facilityStockAdjustment);
		facilityStockAdjustment.setFacilityStockAdjustmentTypeReason(this);

		return facilityStockAdjustment;
	}

	public FacilityStockAdjustment removeFacilityStockAdjustment(FacilityStockAdjustment facilityStockAdjustment) {
		getFacilityStockAdjustments().remove(facilityStockAdjustment);
		facilityStockAdjustment.setFacilityStockAdjustmentTypeReason(null);

		return facilityStockAdjustment;
	}

	public FacilityStockAdjustmentTypeMaster getFacilityStockAdjustmentTypeMaster() {
		return this.facilityStockAdjustmentTypeMaster;
	}

	public void setFacilityStockAdjustmentTypeMaster(
			FacilityStockAdjustmentTypeMaster facilityStockAdjustmentTypeMaster) {
		this.facilityStockAdjustmentTypeMaster = facilityStockAdjustmentTypeMaster;
	}

}