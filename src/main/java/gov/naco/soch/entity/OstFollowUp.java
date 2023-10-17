package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import gov.naco.soch.entity.MasterFollowUpType;
import gov.naco.soch.entity.MasterPrimaryDrug;

@NamedEntityGraph(name = "ostFollowUpGraph", attributeNodes = {
	@NamedAttributeNode(value = "tiOstBeneficiary", subgraph = "ostBeneficiaryGraph"),
	@NamedAttributeNode("tiOstFollowUpBy"), @NamedAttributeNode("tiOstFollowUpReason"),
	@NamedAttributeNode("tiOstSideEffect") }, subgraphs = { @NamedSubgraph(name = "ostBeneficiaryGraph", attributeNodes = {
		@NamedAttributeNode(value = "tiOstPrescriptions") }) })
@Entity(name = "OstFollowUp")
@Table(name = "ti_ost_follow_up")
@Immutable
public class OstFollowUp implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "tiOstFollowUp")
    private Long id;

    @Column(name = "follow_up_date")
    private LocalDate followUpDate;

    @ManyToOne
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

    @ManyToOne
    @JoinColumn(name = "other_drug_id")
    private MasterPrimaryDrug otherDrug;

    @ManyToOne
    @JoinColumn(name = "primary_drug_id")
    private MasterPrimaryDrug primaryDrug;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_delete")
    private Boolean isDelete;

    @Column(name = "is_early")
    private Boolean isEarly;
    
    @ManyToOne
    @JoinColumn(name = "ti_ost_beneficiary_id")
    private OstBenSubEntity tiOstBeneficiary;
    
    @OneToMany(mappedBy = "tiOstFollowUp")
   private Set<OstPrescription> tiOstPrescriptions;

    @OneToMany(mappedBy = "tiostFollowUp")
    private Set<OstFollowUpBy> tiOstFollowUpBy;

    @OneToMany(mappedBy = "tiostFollowUp")
    private Set<OstFollowUpReason> tiOstFollowUpReason;

    @OneToMany(mappedBy = "tiostFollowUp")
    private Set<OstSideEffect> tiOstSideEffect;

    @Column(name="facility_id")
    private Long facilityId;

    public OstFollowUp() {

    }

    public Long getId() {
        return id;
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
    
    public Set<OstPrescription> getTiOstPrescriptions() {
        return tiOstPrescriptions;
    }

    public void setTiOstPrescriptions(Set<OstPrescription> tiOstPrescriptions) {
        this.tiOstPrescriptions = tiOstPrescriptions;
    }

    public MasterFollowUpType getFollowUpType() {
        return followUpType;
    }

    public void setFollowUpType(MasterFollowUpType followUpType) {
        this.followUpType = followUpType;
    }

    public Integer getFrequencyOfOtherDrugUse() {
        return frequencyOfOtherDrugUse;
    }

    public void setFrequencyOfOtherDrugUse(Integer frequencyOfOtherDrugUse) {
        this.frequencyOfOtherDrugUse = frequencyOfOtherDrugUse;
    }

    public Integer getFrequencyOfPrimaryDrugUse() {
        return frequencyOfPrimaryDrugUse;
    }

    public void setFrequencyOfPrimaryDrugUse(Integer frequencyOfPrimaryDrugUse) {
        this.frequencyOfPrimaryDrugUse = frequencyOfPrimaryDrugUse;
    }

    public Integer getLastDoseOfOtherDrug() {
        return lastDoseOfOtherDrug;
    }

    public void setLastDoseOfOtherDrug(Integer lastDoseOfOtherDrug) {
        this.lastDoseOfOtherDrug = lastDoseOfOtherDrug;
    }

    public Integer getLastDoseOfPrimaryDrug() {
        return lastDoseOfPrimaryDrug;
    }

    public void setLastDoseOfPrimaryDrug(Integer lastDoseOfPrimaryDrug) {
        this.lastDoseOfPrimaryDrug = lastDoseOfPrimaryDrug;
    }

    public LocalDate getNextFollowupDate() {
        return nextFollowupDate;
    }

    public void setNextFollowupDate(LocalDate nextFollowupDate) {
        this.nextFollowupDate = nextFollowupDate;
    }

    public Boolean getNoSideEffects() {
        return noSideEffects;
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

    public Boolean getIsEarly() {
        return isEarly;
    }

    public void setIsEarly(Boolean isEarly) {
        this.isEarly = isEarly;
    }

    public OstBenSubEntity getTiOstBeneficiary() {
        return tiOstBeneficiary;
    }

    public void setTiOstBeneficiary(OstBenSubEntity tiOstBeneficiary) {
        this.tiOstBeneficiary = tiOstBeneficiary;
    }
    
    public Set<OstFollowUpBy> getTiOstFollowUpBy() {
        return tiOstFollowUpBy;
    }

    public void setTiOstFollowUpBy(Set<OstFollowUpBy> tiOstFollowUpBy) {
        this.tiOstFollowUpBy = tiOstFollowUpBy;
    }

    public Set<OstFollowUpReason> getTiOstFollowUpReason() {
        return tiOstFollowUpReason;
    }

    public void setTiOstFollowUpReason(Set<OstFollowUpReason> tiOstFollowUpReason) {
        this.tiOstFollowUpReason = tiOstFollowUpReason;
    }

    public Set<OstSideEffect> getTiOstSideEffect() {
        return tiOstSideEffect;
    }

    public void setTiOstSideEffect(Set<OstSideEffect> tiOstSideEffect) {
        this.tiOstSideEffect = tiOstSideEffect;
    }

    public Long getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
    }

}
