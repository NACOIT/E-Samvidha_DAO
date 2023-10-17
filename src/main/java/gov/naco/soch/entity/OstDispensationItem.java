package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import gov.naco.soch.entity.FacilityReadOnly;



@GenericGenerator(name = "OstDispensationItem", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "ost_dispensation_item_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })

@NamedEntityGraph(name = "OstDispensationItem", attributeNodes = {
		@NamedAttributeNode("tiOstBeneficiary"),
		@NamedAttributeNode("tiOstPrescription")})
@Entity(name = "OstDispensationItem")
@Table(name = "ti_ost_dispensation_item")
public class OstDispensationItem implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ost_dispensation_item_id")
	@GeneratedValue(generator = "OstDispensationItem")
	private Long id;
	
	@Column(name = "dispensation_date")
	private LocalDate dispensationDate;
	
	@Column(name = "dispensed_qty")
	private Double dispensedQty;

	@Column(name = "dosage_qty")
	private Double dosageQty;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_deleted")
	private Boolean isDeleted;
	
	@Column(name="take_home_days")
	private Integer takeHomeDays;
	
	@Column(name="take_home_date")
	private LocalDate takeHomeDate;
	
	@ManyToOne
	@JoinColumn(name = "ti_ost_beneficiary_id")
	private OstBenSubEntity tiOstBeneficiary;
	
	@ManyToOne
	@JoinColumn(name = "ti_ost_prescription_id")
	private OstPrescription tiOstPrescription;
	
	@ManyToOne
	private FacilityReadOnly  facility;
	
	
	@Column(name = "last_dispensation_date")
	private LocalDate lastDispensationDate;
	
	public OstDispensationItem() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDispensationDate() {
		return dispensationDate;
	}

	public void setDispensationDate(LocalDate dispensationDate) {
		this.dispensationDate = dispensationDate;
	}

	public Double getDispensedQty() {
		return dispensedQty;
	}

	public void setDispensedQty(Double dispensedQty) {
		this.dispensedQty = dispensedQty;
	}

	public Double getDosageQty() {
		return dosageQty;
	}

	public void setDosageQty(Double dosageQty) {
		this.dosageQty = dosageQty;
	}
	
	public LocalDate getTakeHomeDate() {
	    return takeHomeDate;
	}

	public void setTakeHomeDate(LocalDate takeHomeDate) {
	    this.takeHomeDate = takeHomeDate;
	}

	public Integer getTakeHomeDays() {
	    return takeHomeDays;
	}

	public void setTakeHomeDays(Integer takeHomeDays) {
	    this.takeHomeDays = takeHomeDays;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	
	public OstBenSubEntity getTiOstBeneficiary() {
		return tiOstBeneficiary;
	}

	public void setTiOstBeneficiary(OstBenSubEntity tiOstBeneficiary) {
		this.tiOstBeneficiary = tiOstBeneficiary;
	}

	public OstPrescription getTiOstPrescription() {
		return tiOstPrescription;
	}

	public void setTiOstPrescription(OstPrescription tiOstPrescription) {
		this.tiOstPrescription = tiOstPrescription;
	}

	public FacilityReadOnly getFacility() {
		return facility;
	}

	public void setFacility(FacilityReadOnly facility) {
		this.facility = facility;
	}

	public LocalDate getLastDispensationDate() {
		return lastDispensationDate;
	}

	public void setLastDispensationDate(LocalDate lastDispensationDate) {
		this.lastDispensationDate = lastDispensationDate;
	}
	
	
}
