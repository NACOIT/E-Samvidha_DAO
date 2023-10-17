package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;
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
 * The persistent class for the ti_ost_prescription database table.
 * 
 */

@GenericGenerator(name = "tiOstPrescription", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "ti_ost_prescription_id_seq"),
		@Parameter(name = "increment_size", value = "1"),
		@Parameter(name = "optimizer", value = "hilo") })

@Entity
@Table(name = "ti_ost_prescription")
@NamedQuery(name = "TiOstPrescription.findAll", query = "SELECT t FROM TiOstPrescription t")
public class TiOstPrescription extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "tiOstPrescription")
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
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "substitution_drug")
	private MasterDrug product;

	// bi-directional many-to-one association to TiOstDispensationItem
	@OneToMany(mappedBy = "tiOstPrescription")
	private Set<TiOstDispensationItem> tiOstDispensationItems;

	// bi-directional many-to-one association to Facility
	@ManyToOne(fetch = FetchType.LAZY)
	private Facility facility;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ost_assessment_id")
	private TiOstAssessment tiOstAssessment;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ost_follow_up_id")
	private TiOstFollowUp tiOstFollowUp;
	
	// bi-directional many-to-one association to TiOstBeneficiary
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ti_ost_beneficiary_id")
    private TiOstBeneficiary tiOstBeneficiary;


	public TiOstPrescription() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getDosageQty() {
		return this.dosageQty;
	}

	public void setDosageQty(Double dosageQty) {
		this.dosageQty = dosageQty;
	}

	public TiOstAssessment getTiOstAssessment() {
		return tiOstAssessment;
	}

	public void setTiOstAssessment(TiOstAssessment tiOstAssessment) {
		this.tiOstAssessment = tiOstAssessment;
	}

	public TiOstFollowUp getTiOstFollowUp() {
		return tiOstFollowUp;
	}

	public void setTiOstFollowUp(TiOstFollowUp tiOstFollowUp) {
		this.tiOstFollowUp = tiOstFollowUp;
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

	public LocalDate getOstPrescriptionDate() {
		return this.ostPrescriptionDate;
	}

	public void setOstPrescriptionDate(LocalDate ostPrescriptionDate) {
		this.ostPrescriptionDate = ostPrescriptionDate;
	}

	public MasterDrug getProduct() {
		return this.product;
	}

	public void setProduct(MasterDrug product) {
		this.product = product;
	}

	// public Set<TiOstDispensationItem> getTiOstDispensationItems() {
	// return this.tiOstDispensationItems;
	// }
	//
	// public void setTiOstDispensationItems(Set<TiOstDispensationItem>
	// tiOstDispensationItems) {
	// this.tiOstDispensationItems = tiOstDispensationItems;
	// }
	//
	// public TiOstDispensationItem addTiOstDispensationItem(TiOstDispensationItem
	// tiOstDispensationItem) {
	// getTiOstDispensationItems().add(tiOstDispensationItem);
	// tiOstDispensationItem.setTiOstPrescription(this);
	//
	// return tiOstDispensationItem;
	// }
	//
	// public TiOstDispensationItem
	// removeTiOstDispensationItem(TiOstDispensationItem tiOstDispensationItem) {
	// getTiOstDispensationItems().remove(tiOstDispensationItem);
	// tiOstDispensationItem.setTiOstPrescription(null);
	//
	// return tiOstDispensationItem;
	// }

	
	public Facility getFacility() {
		return this.facility;
	}

	public TiOstBeneficiary getTiOstBeneficiary() {
		return tiOstBeneficiary;
	}

	public void setTiOstBeneficiary(TiOstBeneficiary tiOstBeneficiary) {
		this.tiOstBeneficiary = tiOstBeneficiary;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public Set<TiOstDispensationItem> getTiOstDispensationItems() {
		return tiOstDispensationItems;
	}

	public void setTiOstDispensationItems(Set<TiOstDispensationItem> tiOstDispensationItems) {
		this.tiOstDispensationItems = tiOstDispensationItems;
	}

	public TiOstDispensationItem addTiOstDispensationItem(TiOstDispensationItem tiOstDispensationItem) {
		getTiOstDispensationItems().add(tiOstDispensationItem);
		tiOstDispensationItem.setTiOstPrescription(this);

		return tiOstDispensationItem;
	}

	public TiOstDispensationItem removeTiOstDispensationItem(TiOstDispensationItem tiOstDispensationItem) {
		getTiOstDispensationItems().remove(tiOstDispensationItem);
		tiOstDispensationItem.setTiOstPrescription(null);

		return tiOstDispensationItem;
	}

}