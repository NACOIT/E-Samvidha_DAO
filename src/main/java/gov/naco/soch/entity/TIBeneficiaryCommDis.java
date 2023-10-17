package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * A TIBeneficiaryCommDis.
 */
@GenericGenerator(name = "benCommSequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
	@Parameter(name = "sequence_name", value = "ti_beneficiary_comm_dis_id_seq"),
	@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "ti_beneficiary_comm_dis")
public class TIBeneficiaryCommDis extends Auditable<Long> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "benCommSequence")
    private Long id;

    @Column(name = "condoms_distributed")
    private Integer condomsDistributed;

    @Column(name = "syringes_distributed")
    private Integer syringesDistributed;

    @Column(name = "syringes_returned")
    private Integer syringesReturned;

    @Column(name = "needles_distributed")
    private Integer needlesDistributed;

    @Column(name = "needles_returned")
    private Integer needlesReturned;

    @Column(name = "condom_use_during_last_sex")
    private Boolean condomUseDuringLastSex;

    @Column(name = "not_sharing_needle_syringe")
    private Boolean notSharingNeedleSyringe;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "facility_id")
    private Long facilityId;

    @Column(name = "distribution_date")
    private LocalDate distributionDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private TIBeneficiary beneficiary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "master_contact_type_id")
    private MasterContactType contactType;
    
    @Column(name = "is_csm")
    private Boolean csm;
    
    // jhipster-needle-entity-add-field - JHipster will add fields here, do not
    // remove
    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Integer getCondomsDistributed() {
	return condomsDistributed;
    }

    public TIBeneficiaryCommDis condomsDistributed(Integer condomsDistributed) {
	this.condomsDistributed = condomsDistributed;
	return this;
    }

    public void setCondomsDistributed(Integer condomsDistributed) {
	this.condomsDistributed = condomsDistributed;
    }

    public Integer getSyringesDistributed() {
	return syringesDistributed;
    }

    public void setSyringesDistributed(Integer syringesDistributed) {
	this.syringesDistributed = syringesDistributed;
    }

    public Integer getSyringesReturned() {
	return syringesReturned;
    }

    public void setSyringesReturned(Integer syringesReturned) {
	this.syringesReturned = syringesReturned;
    }

    public Integer getNeedlesDistributed() {
	return needlesDistributed;
    }

    public void setNeedlesDistributed(Integer needlesDistributed) {
	this.needlesDistributed = needlesDistributed;
    }

    public Integer getNeedlesReturned() {
	return needlesReturned;
    }

    public void setNeedlesReturned(Integer needlesReturned) {
	this.needlesReturned = needlesReturned;
    }

    public Boolean getCondomUseDuringLastSex() {
	return condomUseDuringLastSex;
    }

    public Boolean getNotSharingNeedleSyringe() {
	return notSharingNeedleSyringe;
    }

    public Boolean getIsActive() {
	return isActive;
    }

    public Boolean getIsDeleted() {
	return isDeleted;
    }

    public Boolean isCondomUseDuringLastSex() {
	return condomUseDuringLastSex;
    }

    public TIBeneficiaryCommDis condomUseDuringLastSex(Boolean condomUseDuringLastSex) {
	this.condomUseDuringLastSex = condomUseDuringLastSex;
	return this;
    }

    public void setCondomUseDuringLastSex(Boolean condomUseDuringLastSex) {
	this.condomUseDuringLastSex = condomUseDuringLastSex;
    }

    public Boolean isNotSharingNeedleSyringe() {
	return notSharingNeedleSyringe;
    }

    public TIBeneficiaryCommDis notSharingNeedleSyringe(Boolean notSharingNeedleSyringe) {
	this.notSharingNeedleSyringe = notSharingNeedleSyringe;
	return this;
    }

    public void setNotSharingNeedleSyringe(Boolean notSharingNeedleSyringe) {
	this.notSharingNeedleSyringe = notSharingNeedleSyringe;
    }
    public LocalDate getDistributionDate() {
        return distributionDate;
    }

    public void setDistributionDate(LocalDate distributionDate) {
        this.distributionDate = distributionDate;
    }

    public Boolean isIsActive() {
	return isActive;
    }

    public TIBeneficiaryCommDis isActive(Boolean isActive) {
	this.isActive = isActive;
	return this;
    }

    public void setIsActive(Boolean isActive) {
	this.isActive = isActive;
    }

    public Boolean isIsDeleted() {
	return isDeleted;
    }

    public TIBeneficiaryCommDis isDeleted(Boolean isDeleted) {
	this.isDeleted = isDeleted;
	return this;
    }

    public void setIsDeleted(Boolean isDeleted) {
	this.isDeleted = isDeleted;
    }

    public TIBeneficiary getBeneficiary() {
	return beneficiary;
    }

    public Long getFacilityId() {
	return facilityId;
    }

    public void setFacilityId(Long facilityId) {
	this.facilityId = facilityId;
    }

    public TIBeneficiaryCommDis beneficiary(TIBeneficiary tIBeneficiary) {
	this.beneficiary = tIBeneficiary;
	return this;
    }

    public void setBeneficiary(TIBeneficiary tIBeneficiary) {
	this.beneficiary = tIBeneficiary;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and
    // setters here, do not remove

    public MasterContactType getContactType() {
	return contactType;
    }

    public void setContactType(MasterContactType contactType) {
	this.contactType = contactType;
    }

    public Boolean getCsm() {
		return csm;
	}

	public void setCsm(Boolean csm) {
		this.csm = csm;
	}
	
	@Override
    public boolean equals(Object o) {
	if (this == o) {
	    return true;
	}
	if (!(o instanceof TIBeneficiaryCommDis)) {
	    return false;
	}
	return id != null && id.equals(((TIBeneficiaryCommDis) o).id);
    }

    @Override
    public int hashCode() {
	return 31;
    }

    @Override
    public String toString() {
	return "TIBeneficiaryCommDis [id=" + id + ", condomsDistributed=" + condomsDistributed
		+ ", syringesDistributed=" + syringesDistributed + ", syringesReturned=" + syringesReturned
		+ ", needlesDistributed=" + needlesDistributed + ", needlesReturned=" + needlesReturned
		+ ", condomUseDuringLastSex=" + condomUseDuringLastSex + ", notSharingNeedleSyringe="
		+ notSharingNeedleSyringe + ", isActive=" + isActive + ", isDeleted=" + isDeleted + ", facilityId="
		+ facilityId + ", beneficiary=" + beneficiary + ", contactType=" + contactType + "]";
    }

}
