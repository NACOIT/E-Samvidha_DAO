package gov.naco.soch.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

/**
 * The persistent class for the facility_stock_adjustment_type_master database
 * table.
 * 
 */
@Entity
@Table(name = "facility_stock_adjustment_type_master")
@NamedQuery(name = "FacilityStockAdjustmentTypeMaster.findAll", query = "SELECT f FROM FacilityStockAdjustmentTypeMaster f")
public class FacilityStockAdjustmentTypeMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	private String type;

	// bi-directional many-to-one association to FacilityStockAdjustment
	@OneToMany(mappedBy = "facilityStockAdjustmentTypeMaster")
	private Set<FacilityStockAdjustment> facilityStockAdjustments;

	// bi-directional many-to-one association to FacilityStockAdjustmentTypeReason
	@OneToMany(mappedBy = "facilityStockAdjustmentTypeMaster")
	private Set<FacilityStockAdjustmentTypeReason> facilityStockAdjustmentTypeReasons;

	public FacilityStockAdjustmentTypeMaster() {
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<FacilityStockAdjustment> getFacilityStockAdjustments() {
		return this.facilityStockAdjustments;
	}

	public void setFacilityStockAdjustments(Set<FacilityStockAdjustment> facilityStockAdjustments) {
		this.facilityStockAdjustments = facilityStockAdjustments;
	}

	public FacilityStockAdjustment addFacilityStockAdjustment(FacilityStockAdjustment facilityStockAdjustment) {
		getFacilityStockAdjustments().add(facilityStockAdjustment);
		facilityStockAdjustment.setFacilityStockAdjustmentTypeMaster(this);

		return facilityStockAdjustment;
	}

	public FacilityStockAdjustment removeFacilityStockAdjustment(FacilityStockAdjustment facilityStockAdjustment) {
		getFacilityStockAdjustments().remove(facilityStockAdjustment);
		facilityStockAdjustment.setFacilityStockAdjustmentTypeMaster(null);

		return facilityStockAdjustment;
	}

	public Set<FacilityStockAdjustmentTypeReason> getFacilityStockAdjustmentTypeReasons() {
		return this.facilityStockAdjustmentTypeReasons;
	}

	public void setFacilityStockAdjustmentTypeReasons(
			Set<FacilityStockAdjustmentTypeReason> facilityStockAdjustmentTypeReasons) {
		this.facilityStockAdjustmentTypeReasons = facilityStockAdjustmentTypeReasons;
	}

	public FacilityStockAdjustmentTypeReason addFacilityStockAdjustmentTypeReason(
			FacilityStockAdjustmentTypeReason facilityStockAdjustmentTypeReason) {
		getFacilityStockAdjustmentTypeReasons().add(facilityStockAdjustmentTypeReason);
		facilityStockAdjustmentTypeReason.setFacilityStockAdjustmentTypeMaster(this);

		return facilityStockAdjustmentTypeReason;
	}

	public FacilityStockAdjustmentTypeReason removeFacilityStockAdjustmentTypeReason(
			FacilityStockAdjustmentTypeReason facilityStockAdjustmentTypeReason) {
		getFacilityStockAdjustmentTypeReasons().remove(facilityStockAdjustmentTypeReason);
		facilityStockAdjustmentTypeReason.setFacilityStockAdjustmentTypeMaster(null);

		return facilityStockAdjustmentTypeReason;
	}

}