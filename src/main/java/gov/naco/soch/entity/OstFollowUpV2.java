package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;
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
import gov.naco.soch.entity.MasterPrimaryDrug;

@NamedEntityGraph(name = "ostFollowUpGraphV2", attributeNodes = {
	@NamedAttributeNode(value = "tiOstBeneficiary", subgraph = "ostBeneficiaryGraphV2"),
}, subgraphs = { @NamedSubgraph(name = "ostBeneficiaryGraphV2", attributeNodes = { }) })
@Entity(name = "OstFollowUpV2")
@Table(name = "ti_ost_follow_up")
@Immutable
public class OstFollowUpV2 implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "tiOstFollowUp")
    private Long id;

    @Column(name = "follow_up_date")
    private LocalDate followUpDate;

    @Column(name = "next_followup_date")
    private LocalDate nextFollowupDate;

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
    private OstBenSubEntityV2 tiOstBeneficiary;
    
    @OneToMany(mappedBy = "tiostFollowUp")
    private Set<OstFollowUpByV2> tiOstFollowUpBy;

    public OstFollowUpV2() {

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
    
     public LocalDate getNextFollowupDate() {
        return nextFollowupDate;
    }

    public void setNextFollowupDate(LocalDate nextFollowupDate) {
        this.nextFollowupDate = nextFollowupDate;
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

    public OstBenSubEntityV2 getTiOstBeneficiary() {
        return tiOstBeneficiary;
    }

    public void setTiOstBeneficiary(OstBenSubEntityV2 tiOstBeneficiary) {
        this.tiOstBeneficiary = tiOstBeneficiary;
    }
    
    public Set<OstFollowUpByV2> getTiOstFollowUpBy() {
        return tiOstFollowUpBy;
    }

    public void setTiOstFollowUpBy(Set<OstFollowUpByV2> tiOstFollowUpBy) {
        this.tiOstFollowUpBy = tiOstFollowUpBy;
    }
 }
