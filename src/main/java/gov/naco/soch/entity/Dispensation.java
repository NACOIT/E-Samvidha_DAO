package gov.naco.soch.entity;

import java.io.Serializable;
import javax.persistence.*;


import java.sql.Timestamp;
import java.time.LocalDate;


/**
 * The persistent class for the dispensation database table.
 * 
 */
@Entity
@NamedQuery(name="Dispensation.findAll", query="SELECT d FROM Dispensation d")
public class Dispensation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="created_by")
	private String createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="dispense_date")
	private LocalDate dispenseDate;
	
	@Column(name = "product_dispense")
	private String productDispense;
	
	@Column (name = "remaining_pills")
	private int remainingPills;
	
	@Column (name = "adherence")
	private String adherence;
	
	@Column(name = "dispensed_qty")
	private int dispensedQty;
	
	@Column(name = "visit_date")
    private LocalDate visitDate;
	
	@Column(name="dispensed_to")
	private String dispensedTo;

	@Column(name="fac_prod_stock_trans_id")
	private String facProdStockTransId;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="modified_by")
	private String modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	//bi-directional many-to-one association to Beneficiary
	@ManyToOne
	private Beneficiary beneficiary;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	private Facility facility;

	public Dispensation() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	

	public Timestamp getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}





	public LocalDate getDispenseDate() {
		return dispenseDate;
	}

	public void setDispenseDate(LocalDate dispenseDate) {
		this.dispenseDate = dispenseDate;
	}

	public LocalDate getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(LocalDate visitDate) {
		this.visitDate = visitDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDispensedTo() {
		return this.dispensedTo;
	}

	public void setDispensedTo(String dispensedTo) {
		this.dispensedTo = dispensedTo;
	}

	public String getFacProdStockTransId() {
		return this.facProdStockTransId;
	}

	public void setFacProdStockTransId(String facProdStockTransId) {
		this.facProdStockTransId = facProdStockTransId;
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

	public String getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getModifiedTime() {
		return this.modifiedTime;
	}

	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public Beneficiary getBeneficiary() {
		return this.beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public String getProductDispense() {
		return productDispense;
	}

	public void setProductDispense(String productDispense) {
		this.productDispense = productDispense;
	}

	public int getRemainingPills() {
		return remainingPills;
	}

	public void setRemainingPills(int remainingPills) {
		this.remainingPills = remainingPills;
	}

	public String getAdherence() {
		return adherence;
	}

	public void setAdherence(String adherence) {
		this.adherence = adherence;
	}

	public int getDispensedQty() {
		return dispensedQty;
	}

	public void setDispensedQty(int dispensedQty) {
		this.dispensedQty = dispensedQty;
	}

}