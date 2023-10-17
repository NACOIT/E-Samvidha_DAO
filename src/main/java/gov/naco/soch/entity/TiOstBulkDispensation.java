package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
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
 * The persistent class for the ti_ost_bulk_dispensation database table.
 * 
 */

@GenericGenerator(name = "tiOstBulkDispensation", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "ti_ost_bulk_dispensation_ost_bulk_dispensation_id_seq"),
		@Parameter(name = "increment_size", value = "1"),
		@Parameter(name = "optimizer", value = "hilo") })

@Entity
@Table(name = "ti_ost_bulk_dispensation")
@NamedQuery(name = "TiOstBulkDispensation.findAll", query = "SELECT t FROM TiOstBulkDispensation t")
public class TiOstBulkDispensation extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "tiOstBulkDispensation")
	@Column(name="ost_bulk_dispensation_id")
	private Long ostBulkDispensationId;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_deleted")
	private Boolean isDeleted;

	@Column(name = "ost_bulk_dispensation_date")
	private LocalDate ostBulkDispensationDate;

	// bi-directional many-to-one association to Facility
	@ManyToOne(fetch = FetchType.LAZY)
	private Facility facility;

	// bi-directional many-to-one association to Product
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "substitution_drug")
	private MasterDrug masterDrug;

	// bi-directional many-to-one association to TiOstDispensation
	@OneToMany(mappedBy = "tiOstBulkDispensation", cascade = CascadeType.ALL)
	private Set<TiOstDispensation> tiOstDispensations;

	// bi-directional many-to-one association to TiOstDispensationItem
	@OneToMany(mappedBy = "tiOstBulkDispensation")
	private Set<TiOstDispensationItem> tiOstDispensationItems;

	public TiOstBulkDispensation() {
	}

	
	public Long getOstBulkDispensationId() {
		return ostBulkDispensationId;
	}

	public void setOstBulkDispensationId(Long ostBulkDispensationId) {
		this.ostBulkDispensationId = ostBulkDispensationId;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public LocalDate getOstBulkDispensationDate() {
		return this.ostBulkDispensationDate;
	}

	public void setOstBulkDispensationDate(LocalDate ostBulkDispensationDate) {
		this.ostBulkDispensationDate = ostBulkDispensationDate;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public MasterDrug getMasterDrug() {
		return masterDrug;
	}

	public void setMasterDrug(MasterDrug masterDrug) {
		this.masterDrug = masterDrug;
	}

	public Set<TiOstDispensation> getTiOstDispensations() {
		return this.tiOstDispensations;
	}

	public void setTiOstDispensations(Set<TiOstDispensation> tiOstDispensations) {
		this.tiOstDispensations = tiOstDispensations;
	}

	public TiOstDispensation addTiOstDispensation(TiOstDispensation tiOstDispensation) {
		getTiOstDispensations().add(tiOstDispensation);
		tiOstDispensation.setTiOstBulkDispensation(this);

		return tiOstDispensation;
	}

	public TiOstDispensation removeTiOstDispensation(TiOstDispensation tiOstDispensation) {
		getTiOstDispensations().remove(tiOstDispensation);
		tiOstDispensation.setTiOstBulkDispensation(null);

		return tiOstDispensation;
	}

	public Set<TiOstDispensationItem> getTiOstDispensationItems() {
		return this.tiOstDispensationItems;
	}

	public void setTiOstDispensationItems(Set<TiOstDispensationItem> tiOstDispensationItems) {
		this.tiOstDispensationItems = tiOstDispensationItems;
	}

	public TiOstDispensationItem addTiOstDispensationItem(TiOstDispensationItem tiOstDispensationItem) {
		getTiOstDispensationItems().add(tiOstDispensationItem);
		tiOstDispensationItem.setTiOstBulkDispensation(this);

		return tiOstDispensationItem;
	}

	public TiOstDispensationItem removeTiOstDispensationItem(TiOstDispensationItem tiOstDispensationItem) {
		getTiOstDispensationItems().remove(tiOstDispensationItem);
		tiOstDispensationItem.setTiOstBulkDispensation(null);

		return tiOstDispensationItem;
	}

}