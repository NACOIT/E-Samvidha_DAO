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
 * The persistent class for the art_dispensation database table.
 * 
 */

@Entity
@GenericGenerator(name = "art_dispensation", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "art_dispensation_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Table(name = "art_dispensation")
@NamedQuery(name = "ArtDispensation.findAll", query = "SELECT a FROM ArtDispensation a")
public class ArtDispensation extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "art_dispensation")
	private Long id;

	@Column(name = "dispense_date")
	private LocalDate dispenseDate;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "is_transit")
	private Boolean isTransit;

	// bi-directional many-to-one association to Beneficiary
	@ManyToOne(fetch = FetchType.LAZY)
	private Beneficiary beneficiary;

	// bi-directional many-to-one association to BeneficiaryVisitRegister
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "visit_register_id")
	private BeneficiaryVisitRegister beneficiaryVisitRegister;

	// bi-directional many-to-one association to Facility
	@ManyToOne(fetch = FetchType.LAZY)
	private Facility facility;

	// bi-directional many-to-one association to UserMaster
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "entry_user")
	private UserMaster userMaster;

	// bi-directional many-to-one association to ArtDispensationItem
	@OneToMany(mappedBy = "artDispensation", cascade = CascadeType.ALL)
	private Set<ArtDispensationItem> artDispensationItems;

	// bi-directional many-to-one association to MasterModeOfDispensation
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mode_of_dispensation")
	private MasterModeOfDispensation masterModeOfDispensation;

	// bi-directional many-to-one association to ArtBeneficiaryDueList
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "art_beneficiary_due_list_id")
	private ArtBeneficiaryDueList artBeneficiaryDueList;

	public ArtDispensation() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDispenseDate() {
		return this.dispenseDate;
	}

	public void setDispenseDate(LocalDate dispenseDate) {
		this.dispenseDate = dispenseDate;
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

	public Beneficiary getBeneficiary() {
		return this.beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	public BeneficiaryVisitRegister getBeneficiaryVisitRegister() {
		return this.beneficiaryVisitRegister;
	}

	public void setBeneficiaryVisitRegister(BeneficiaryVisitRegister beneficiaryVisitRegister) {
		this.beneficiaryVisitRegister = beneficiaryVisitRegister;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public UserMaster getUserMaster() {
		return this.userMaster;
	}

	public void setUserMaster(UserMaster userMaster) {
		this.userMaster = userMaster;
	}

	public Set<ArtDispensationItem> getArtDispensationItems() {
		return this.artDispensationItems;
	}

	public void setArtDispensationItems(Set<ArtDispensationItem> artDispensationItems) {
		this.artDispensationItems = artDispensationItems;
	}

	public ArtDispensationItem addArtDispensationItem(ArtDispensationItem artDispensationItem) {
		getArtDispensationItems().add(artDispensationItem);
		artDispensationItem.setArtDispensation(this);

		return artDispensationItem;
	}

	public ArtDispensationItem removeArtDispensationItem(ArtDispensationItem artDispensationItem) {
		getArtDispensationItems().remove(artDispensationItem);
		artDispensationItem.setArtDispensation(null);

		return artDispensationItem;
	}

	public Boolean getIsTransit() {
		return isTransit;
	}

	public void setIsTransit(Boolean isTransit) {
		this.isTransit = isTransit;
	}

	public MasterModeOfDispensation getMasterModeOfDispensation() {
		return masterModeOfDispensation;
	}

	public void setMasterModeOfDispensation(MasterModeOfDispensation masterModeOfDispensation) {
		this.masterModeOfDispensation = masterModeOfDispensation;
	}

	public ArtBeneficiaryDueList getArtBeneficiaryDueList() {
		return artBeneficiaryDueList;
	}

	public void setArtBeneficiaryDueList(ArtBeneficiaryDueList artBeneficiaryDueList) {
		this.artBeneficiaryDueList = artBeneficiaryDueList;
	}

}