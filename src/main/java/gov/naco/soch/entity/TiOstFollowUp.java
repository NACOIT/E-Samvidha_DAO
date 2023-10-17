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
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the ti_ost_follow_up database table.
 * 
 */

@GenericGenerator(name = "tiOstFollowUp", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "ti_ost_follow_up_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@NamedEntityGraph(name = "tiOstFollowUpGraph", attributeNodes = { @NamedAttributeNode("tiOstPrescriptions"),
		@NamedAttributeNode("tiOstFollowUpBy"), @NamedAttributeNode("tiOstFollowUpReason"),
		@NamedAttributeNode("tiOstSideEffect") })
@Entity
@Table(name = "ti_ost_follow_up")
@NamedQuery(name = "TiOstFollowUp.findAll", query = "SELECT t FROM TiOstFollowUp t")
public class TiOstFollowUp extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "tiOstFollowUp")
	private Long id;

	@Column(name = "follow_up_date")
	private LocalDate followUpDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "follow_up_type_id")
	private MasterFollowUpType followUpType;

	@Column(name = "frequency_of_other_drug_use")
	private Integer frequencyOfOtherDrugUse;

	@Column(name = "frequency_of_primary_drug_use")
	private Integer frequencyOfPrimaryDrugUse;

	@Column(name = "last_dose_of_other_drug")
	private Integer lastDoseOfOtherDrug;

	@Column(name = "last_dose_of_primary_drug")
	private Integer lastDoseOfPrimaryDrug;

	@Column(name = "next_followup_date")
	private LocalDate nextFollowupDate;

	@Column(name = "no_side_effects")
	private Boolean noSideEffects;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "other_drug_id")
	private MasterPrimaryDrug otherDrug;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "primary_drug_id")
	private MasterPrimaryDrug primaryDrug;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "is_early")
	private Boolean isEarly;

	@Column(name = "no_of_condoms_distributed")
	private Long noOfCondomsDistributed;

	// bi-directional many-to-one association to TiOstBeneficiary
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ti_ost_beneficiary_id")
	private TiOstBeneficiary tiOstBeneficiary;

	@OneToMany(mappedBy = "tiOstFollowUp", cascade = CascadeType.ALL)
	private Set<TiOstPrescription> tiOstPrescriptions;

	@OneToMany(mappedBy = "tiostFollowUp", cascade = CascadeType.ALL)
	private Set<TiOstFollowUpBy> tiOstFollowUpBy;

	@OneToMany(mappedBy = "tiostFollowUp", cascade = CascadeType.ALL)
	private Set<TiOstFollowUpReasonMapping> tiOstFollowUpReason;

	@OneToMany(mappedBy = "tiostFollowUp", cascade = CascadeType.ALL)
	private Set<TiOstFollowUpSideEffectMapping> tiOstSideEffect;
	// bi-directional many-to-one association to Facility
	@ManyToOne(fetch = FetchType.LAZY)
	private Facility facility;

	public TiOstFollowUp() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFollowUpDate() {
		return followUpDate;
	}

	public void setFollowUpDate(LocalDate followUpDate) {
		this.followUpDate = followUpDate;
	}

	public Boolean getIsEarly() {
		return isEarly;
	}

	public void setIsEarly(Boolean isEarly) {
		this.isEarly = isEarly;
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

	public LocalDate getNextFollowupDate() {
		return nextFollowupDate;
	}

	public void setNextFollowupDate(LocalDate nextFollowupDate) {
		this.nextFollowupDate = nextFollowupDate;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public Set<TiOstFollowUpBy> getTiOstFollowUpBy() {
		return tiOstFollowUpBy;
	}

	public void setTiOstFollowUpBy(Set<TiOstFollowUpBy> tiOstFollowUpBy) {
		this.tiOstFollowUpBy = tiOstFollowUpBy;
		if (tiOstFollowUpBy != null) {
			for (TiOstFollowUpBy followUpBy : tiOstFollowUpBy) {
				this.tiOstFollowUpBy.add(addTiOstFollowUpBy(followUpBy));
			}
		}
	}

	public TiOstFollowUpBy addTiOstFollowUpBy(TiOstFollowUpBy tiOstFollowUpBy) {
		getTiOstFollowUpBy().add(tiOstFollowUpBy);
		tiOstFollowUpBy.setTiostFollowUp(this);
		return tiOstFollowUpBy;
	}

	public TiOstFollowUpBy removeTiOstFollowUpBy(TiOstFollowUpBy tiOstFollowUpBy) {
		getTiOstFollowUpBy().remove(tiOstFollowUpBy);
		tiOstFollowUpBy.setTiostFollowUp(null);
		return tiOstFollowUpBy;
	}

	public MasterFollowUpType getFollowUpType() {
		return this.followUpType;
	}

	public void setFollowUpType(MasterFollowUpType followUpType) {
		this.followUpType = followUpType;
	}

	public Integer getFrequencyOfOtherDrugUse() {
		return this.frequencyOfOtherDrugUse;
	}

	public void setFrequencyOfOtherDrugUse(Integer frequencyOfOtherDrugUse) {
		this.frequencyOfOtherDrugUse = frequencyOfOtherDrugUse;
	}

	public Integer getFrequencyOfPrimaryDrugUse() {
		return this.frequencyOfPrimaryDrugUse;
	}

	public void setFrequencyOfPrimaryDrugUse(Integer frequencyOfPrimaryDrugUse) {
		this.frequencyOfPrimaryDrugUse = frequencyOfPrimaryDrugUse;
	}

	public Integer getLastDoseOfOtherDrug() {
		return this.lastDoseOfOtherDrug;
	}

	public void setLastDoseOfOtherDrug(Integer lastDoseOfOtherDrug) {
		this.lastDoseOfOtherDrug = lastDoseOfOtherDrug;
	}

	public Integer getLastDoseOfPrimaryDrug() {
		return this.lastDoseOfPrimaryDrug;
	}

	public void setLastDoseOfPrimaryDrug(Integer lastDoseOfPrimaryDrug) {
		this.lastDoseOfPrimaryDrug = lastDoseOfPrimaryDrug;
	}

	public Boolean getNoSideEffects() {
		return this.noSideEffects;
	}

	public void setNoSideEffects(Boolean noSideEffects) {
		this.noSideEffects = noSideEffects;
	}

	public MasterPrimaryDrug getOtherDrug() {
		return otherDrug;
	}

	public void setOtherDrug(MasterPrimaryDrug otherDrug) {
		this.otherDrug = otherDrug;
	}

	public MasterPrimaryDrug getPrimaryDrug() {
		return primaryDrug;
	}

	public void setPrimaryDrug(MasterPrimaryDrug primaryDrug) {
		this.primaryDrug = primaryDrug;
	}

	public Set<TiOstFollowUpReasonMapping> getTiOstFollowUpReason() {
		return tiOstFollowUpReason;
	}

	public void setTiOstFollowUpReason(Set<TiOstFollowUpReasonMapping> tiOstFollowUpReason) {
		this.tiOstFollowUpReason = tiOstFollowUpReason;
		if (tiOstFollowUpReason != null) {
			for (TiOstFollowUpReasonMapping tiOstFollowUpReasonMapping : tiOstFollowUpReason) {
				this.tiOstFollowUpReason.add(addTiOstFollowUpReason(tiOstFollowUpReasonMapping));
			}
		}
	}

	public TiOstFollowUpReasonMapping addTiOstFollowUpReason(TiOstFollowUpReasonMapping tiOstFollowUpReasonMapping) {
		getTiOstFollowUpReason().add(tiOstFollowUpReasonMapping);
		tiOstFollowUpReasonMapping.setTiostFollowUp(this);
		return tiOstFollowUpReasonMapping;
	}

	public TiOstFollowUpReasonMapping removeTiOstFollowUpReasonMapping(
			TiOstFollowUpReasonMapping tiOstFollowUpReasonMapping) {
		getTiOstFollowUpReason().remove(tiOstFollowUpReasonMapping);
		tiOstFollowUpReasonMapping.setTiostFollowUp(null);
		return tiOstFollowUpReasonMapping;
	}

	public Set<TiOstFollowUpSideEffectMapping> getTiOstSideEffect() {
		return tiOstSideEffect;
	}

	public void setTiOstSideEffect(Set<TiOstFollowUpSideEffectMapping> tiOstSideEffect) {
		this.tiOstSideEffect = tiOstSideEffect;
		if (tiOstSideEffect != null) {
			for (TiOstFollowUpSideEffectMapping tiOstFollowUpSideEffectMapping : tiOstSideEffect) {
				this.tiOstSideEffect.add(addTiOstFollowUpSideEffect(tiOstFollowUpSideEffectMapping));
			}
		}
	}

	public TiOstFollowUpSideEffectMapping addTiOstFollowUpSideEffect(
			TiOstFollowUpSideEffectMapping tiOstFollowUpSideEffectMapping) {
		getTiOstSideEffect().add(tiOstFollowUpSideEffectMapping);
		tiOstFollowUpSideEffectMapping.setTiostFollowUp(this);
		return tiOstFollowUpSideEffectMapping;
	}

	public TiOstFollowUpSideEffectMapping removeTiOstFollowUpSideEffect(
			TiOstFollowUpSideEffectMapping tiOstFollowUpSideEffectMapping) {
		getTiOstSideEffect().remove(tiOstFollowUpSideEffectMapping);
		tiOstFollowUpSideEffectMapping.setTiostFollowUp(null);
		return tiOstFollowUpSideEffectMapping;
	}

	public TiOstBeneficiary getTiOstBeneficiary() {
		return this.tiOstBeneficiary;
	}

	public void setTiOstBeneficiary(TiOstBeneficiary tiOstBeneficiary) {
		this.tiOstBeneficiary = tiOstBeneficiary;
	}

	public Set<TiOstPrescription> getTiOstPrescriptions() {
		return tiOstPrescriptions;
	}

	public void setTiOstPrescriptions(Set<TiOstPrescription> tiOstPrescriptions) {
		this.tiOstPrescriptions = tiOstPrescriptions;
		if (tiOstPrescriptions != null) {
			for (TiOstPrescription prescription : tiOstPrescriptions) {
				this.tiOstPrescriptions.add(addTiOstPrescription(prescription));
			}
		}
	}

	public Long getNoOfCondomsDistributed() {
		return noOfCondomsDistributed;
	}

	public void setNoOfCondomsDistributed(Long noOfCondomsDistributed) {
		this.noOfCondomsDistributed = noOfCondomsDistributed;
	}

	public TiOstPrescription addTiOstPrescription(TiOstPrescription tiOstPrescription) {
		getTiOstPrescriptions().add(tiOstPrescription);
		tiOstPrescription.setTiOstFollowUp(this);
		return tiOstPrescription;
	}

	public TiOstPrescription removeTiOstPrescription(TiOstPrescription tiOstPrescription) {
		getTiOstPrescriptions().remove(tiOstPrescription);
		tiOstPrescription.setTiOstFollowUp(null);
		return tiOstPrescription;
	}

}