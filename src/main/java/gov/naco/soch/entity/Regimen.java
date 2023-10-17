package gov.naco.soch.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Where;

/**
 * The persistent class for the regimen database table.
 * 
 */
@GenericGenerator(name = "regimen", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "regimen_id_seq"),
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "regimen")
@Where(clause = "is_delete <> true")
public class Regimen extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "regimen")
	private Long id;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "regimen_name")
	private String regimenName;

	// bi-directional many-to-one association to MasterData
	@ManyToOne
	@JoinColumn(name = "adult_ped")
	private MasterData masterData1;

	// bi-directional many-to-one association to MasterData
	@ManyToOne
	@JoinColumn(name = "line")
	private MasterData masterData2;

	// bi-directional many-to-one association to DispensationItem
	@OneToMany(mappedBy = "regimen")
	private Set<DispensationItem> dispensationItems;

	// bi-directional many-to-one association to RegimenConstituent
	@OneToMany(mappedBy = "regimen", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<RegimenConstituent> regimenConstituents;

	// bi-directional many-to-one association to ArtDispensationItem
	@OneToMany(mappedBy = "regimen")
	private Set<ArtDispensationItem> artDispensationItems;
	
	//bi-directional many-to-one association to ArtBeneficiaryClinicalDetail
	@OneToMany(mappedBy="regimen")
	private Set<ArtBeneficiaryClinicalDetail> artBeneficiaryClinicalDetails;

	public Regimen() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getRegimenName() {
		return this.regimenName;
	}

	public void setRegimenName(String regimenName) {
		this.regimenName = regimenName;
	}

	public Set<DispensationItem> getDispensationItems() {
		return this.dispensationItems;
	}

	public MasterData getMasterData1() {
		return masterData1;
	}

	public void setMasterData1(MasterData masterData1) {
		this.masterData1 = masterData1;
	}

	public MasterData getMasterData2() {
		return masterData2;
	}

	public void setMasterData2(MasterData masterData2) {
		this.masterData2 = masterData2;
	}

	public void setDispensationItems(Set<DispensationItem> dispensationItems) {
		this.dispensationItems = dispensationItems;
	}

	public DispensationItem addDispensationItem(DispensationItem dispensationItem) {
		getDispensationItems().add(dispensationItem);
		dispensationItem.setRegimen(this);

		return dispensationItem;
	}

	public DispensationItem removeDispensationItem(DispensationItem dispensationItem) {
		getDispensationItems().remove(dispensationItem);
		dispensationItem.setRegimen(null);

		return dispensationItem;
	}

	public Set<RegimenConstituent> getRegimenConstituents() {
		return this.regimenConstituents;
	}

	public void setRegimenConstituents(Set<RegimenConstituent> regimenConstituents) {
		this.regimenConstituents = regimenConstituents;
	}

	public RegimenConstituent addRegimenConstituent(RegimenConstituent regimenConstituent) {
		getRegimenConstituents().add(regimenConstituent);
		regimenConstituent.setRegimen(this);

		return regimenConstituent;
	}

	public RegimenConstituent removeRegimenConstituent(RegimenConstituent regimenConstituent) {
		getRegimenConstituents().remove(regimenConstituent);
		regimenConstituent.setRegimen(null);

		return regimenConstituent;
	}

	public Set<ArtDispensationItem> getArtDispensationItems() {
		return this.artDispensationItems;
	}

	public void setArtDispensationItems(Set<ArtDispensationItem> artDispensationItems) {
		this.artDispensationItems = artDispensationItems;
	}

	public ArtDispensationItem addArtDispensationItem(ArtDispensationItem artDispensationItem) {
		getArtDispensationItems().add(artDispensationItem);
		artDispensationItem.setRegimen(this);

		return artDispensationItem;
	}

	public ArtDispensationItem removeArtDispensationItem(ArtDispensationItem artDispensationItem) {
		getArtDispensationItems().remove(artDispensationItem);
		artDispensationItem.setRegimen(null);

		return artDispensationItem;
	}

	public Set<ArtBeneficiaryClinicalDetail> getArtBeneficiaryClinicalDetails() {
		return artBeneficiaryClinicalDetails;
	}

	public void setArtBeneficiaryClinicalDetails(Set<ArtBeneficiaryClinicalDetail> artBeneficiaryClinicalDetails) {
		this.artBeneficiaryClinicalDetails = artBeneficiaryClinicalDetails;
	}
	
	public ArtBeneficiaryClinicalDetail addArtBeneficiaryClinicalDetail(ArtBeneficiaryClinicalDetail artBeneficiaryClinicalDetail) {
		getArtBeneficiaryClinicalDetails().add(artBeneficiaryClinicalDetail);
		artBeneficiaryClinicalDetail.setRegimen(this);

		return artBeneficiaryClinicalDetail;
	}

	public ArtBeneficiaryClinicalDetail removeArtBeneficiaryClinicalDetail(ArtBeneficiaryClinicalDetail artBeneficiaryClinicalDetail) {
		getArtBeneficiaryClinicalDetails().remove(artBeneficiaryClinicalDetail);
		artBeneficiaryClinicalDetail.setRegimen(null);

		return artBeneficiaryClinicalDetail;
	}

}