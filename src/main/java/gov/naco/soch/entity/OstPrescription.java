package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import gov.naco.soch.entity.MasterDrug;
import gov.naco.soch.entity.OstBeneficiaryReadOnly;

@Entity(name = "OstPrescription")
@Table(name = "ti_ost_prescription")
@Immutable
public class OstPrescription implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@Column(name = "dosage_qty")
	private Double dosageQty;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "ost_prescription_date")
	private LocalDate ostPrescriptionDate;

	// bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name = "substitution_drug")
	private MasterDrug product;

	// bi-directional many-to-one association to Facility
	@Column(name = "facility_id")
	private Long facilityId;

	// bi-directional many-to-one association to TiOstBeneficiary
	@ManyToOne
	@JoinColumn(name = "ti_ost_beneficiary_id")
	private OstBenSubEntity tiOstBeneficiary;

//	@ManyToOne
//	@JoinColumn(name = "ti_ost_beneficiary_id")
//	private OstBeneficiaryReadOnly tiOstBen;
	
	@ManyToOne
	@JoinColumn(name = "ost_assessment_id")
	private OstAssessment tiOstAssessment;
	
	@ManyToOne
	@JoinColumn(name = "ost_follow_up_id")
	private OstFollowUp tiOstFollowUp;

	public OstPrescription() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getDosageQty() {
		return dosageQty;
	}

	public void setDosageQty(Double dosageQty) {
		this.dosageQty = dosageQty;
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

	public LocalDate getOstPrescriptionDate() {
		return ostPrescriptionDate;
	}

	public void setOstPrescriptionDate(LocalDate ostPrescriptionDate) {
		this.ostPrescriptionDate = ostPrescriptionDate;
	}
	public OstFollowUp getTiOstFollowUp() {
	    return tiOstFollowUp;
	}

	public void setTiOstFollowUp(OstFollowUp tiOstFollowUp) {
	    this.tiOstFollowUp = tiOstFollowUp;
	}

	public MasterDrug getProduct() {
		return product;
	}

	public void setProduct(MasterDrug product) {
		this.product = product;
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public OstBenSubEntity getTiOstBeneficiary() {
		return tiOstBeneficiary;
	}

	public void setTiOstBeneficiary(OstBenSubEntity tiOstBeneficiary) {
		this.tiOstBeneficiary = tiOstBeneficiary;
	}

//	public OstBeneficiaryReadOnly getTiOstBen() {
//		return tiOstBen;
//	}
//
//	public void setTiOstBen(OstBeneficiaryReadOnly tiOstBen) {
//		this.tiOstBen = tiOstBen;
//	}

	public OstAssessment getTiOstAssessment() {
		return tiOstAssessment;
	}

	public void setTiOstAssessment(OstAssessment tiOstAssessment) {
		this.tiOstAssessment = tiOstAssessment;
	}
	
	

}