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

@Entity(name = "OstPrescriptionVCReadOnly")
@Table(name = "ti_ost_prescription")
@Immutable
public class OstPrescriptionVCReadOnly  implements Serializable,Comparable<OstPrescriptionVCReadOnly>{
	
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@Column(name = "dosage_qty")
	private Double dosageQty;
	
	@Column(name = "ost_prescription_date")
	private LocalDate ostPrescriptionDate;
	
	@ManyToOne
	@JoinColumn(name = "substitution_drug")
	private MasterDrug product;
	
	@ManyToOne
	@JoinColumn(name = "ti_ost_beneficiary_id")
	private OstBenSubEntityVCReadOnly tiOstBeneficiary;

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

	public LocalDate getOstPrescriptionDate() {
		return ostPrescriptionDate;
	}

	public void setOstPrescriptionDate(LocalDate ostPrescriptionDate) {
		this.ostPrescriptionDate = ostPrescriptionDate;
	}

	public MasterDrug getProduct() {
		return product;
	}

	public void setProduct(MasterDrug product) {
		this.product = product;
	}

	public OstBenSubEntityVCReadOnly getTiOstBeneficiary() {
		return tiOstBeneficiary;
	}

	public void setTiOstBeneficiary(OstBenSubEntityVCReadOnly tiOstBeneficiary) {
		this.tiOstBeneficiary = tiOstBeneficiary;
	}

	@Override
	public int compareTo(OstPrescriptionVCReadOnly arg0) {
	    // TODO Auto-generated method stub
	    return 0;
	}
}
