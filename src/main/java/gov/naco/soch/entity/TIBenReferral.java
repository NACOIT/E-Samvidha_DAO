package gov.naco.soch.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZonedDateTime;

/**
 * A TIBenReferral.
 */
@GenericGenerator(name = "ti_ben_referral", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "ti_ben_referral_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "ti_ben_referral")
public class TIBenReferral implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
  @GeneratedValue( generator = "ti_ben_referral")
    private Long id;

    @Column(name = "refferal_requestor_id")
    private Integer refferalRequestorId;

    @Column(name = "time_of_appointment")
    private ZonedDateTime timeOfAppointment;

    @Column(name = "referral_facility")
    private Integer referralFacility;

    @Column(name = "referred_facility")
    private Integer referredFacility;

    @Column(name = "transfer_to")
    private String transferTo;

    @Column(name = "transfer_from")
    private String transferFrom;

    @Column(name = "transfer_date")
    private LocalDate transferDate;

    @Column(name = "transfer_status")
    private String transferStatus;

    @Column(name = "referral_status")
    private String referralStatus;

    @Column(name = "date_of_referral")
    private LocalDate dateOfReferral;

    @Column(name = "hiv_status")
    private String hivStatus;

    @Column(name = "is_completed")
    private Integer isCompleted;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_deleted")
    private Boolean isDelete;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "created_time")
    private ZonedDateTime createdTime;

    @Column(name = "modified_by")
    private Integer modifiedBy;

    @Column(name = "modified_time")
    private ZonedDateTime modifiedTime;

    @ManyToOne(optional = false,fetch=FetchType.EAGER)
    @NotNull
    @JsonIgnoreProperties("tIBenReferrals")
    private TIBeneficiary beneficiary;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRefferalRequestorId() {
        return refferalRequestorId;
    }

    public TIBenReferral refferalRequestorId(Integer refferalRequestorId) {
        this.refferalRequestorId = refferalRequestorId;
        return this;
    }

    public void setRefferalRequestorId(Integer refferalRequestorId) {
        this.refferalRequestorId = refferalRequestorId;
    }

    public ZonedDateTime getTimeOfAppointment() {
        return timeOfAppointment;
    }

    public TIBenReferral timeOfAppointment(ZonedDateTime timeOfAppointment) {
        this.timeOfAppointment = timeOfAppointment;
        return this;
    }

    public void setTimeOfAppointment(ZonedDateTime timeOfAppointment) {
        this.timeOfAppointment = timeOfAppointment;
    }

    public Integer getReferralFacility() {
        return referralFacility;
    }

    public TIBenReferral referralFacility(Integer referralFacility) {
        this.referralFacility = referralFacility;
        return this;
    }

    public void setReferralFacility(Integer referralFacility) {
        this.referralFacility = referralFacility;
    }

    public Integer getReferredFacility() {
        return referredFacility;
    }

    public TIBenReferral referredFacility(Integer referredFacility) {
        this.referredFacility = referredFacility;
        return this;
    }

    public void setReferredFacility(Integer referredFacility) {
        this.referredFacility = referredFacility;
    }

    public String getTransferTo() {
        return transferTo;
    }

    public TIBenReferral transferTo(String transferTo) {
        this.transferTo = transferTo;
        return this;
    }

    public void setTransferTo(String transferTo) {
        this.transferTo = transferTo;
    }

    public String getTransferFrom() {
        return transferFrom;
    }

    public TIBenReferral transferFrom(String transferFrom) {
        this.transferFrom = transferFrom;
        return this;
    }

    public void setTransferFrom(String transferFrom) {
        this.transferFrom = transferFrom;
    }

    public LocalDate getTransferDate() {
        return transferDate;
    }

    public TIBenReferral transferDate(LocalDate transferDate) {
        this.transferDate = transferDate;
        return this;
    }

    public void setTransferDate(LocalDate transferDate) {
        this.transferDate = transferDate;
    }

    public String getTransferStatus() {
        return transferStatus;
    }

    public TIBenReferral transferStatus(String transferStatus) {
        this.transferStatus = transferStatus;
        return this;
    }

    public void setTransferStatus(String transferStatus) {
        this.transferStatus = transferStatus;
    }

    public String getReferralStatus() {
        return referralStatus;
    }

    public TIBenReferral referralStatus(String referralStatus) {
        this.referralStatus = referralStatus;
        return this;
    }

    public void setReferralStatus(String referralStatus) {
        this.referralStatus = referralStatus;
    }

    public LocalDate getDateOfReferral() {
        return dateOfReferral;
    }

    public TIBenReferral dateOfReferral(LocalDate dateOfReferral) {
        this.dateOfReferral = dateOfReferral;
        return this;
    }

    public void setDateOfReferral(LocalDate dateOfReferral) {
        this.dateOfReferral = dateOfReferral;
    }

    public String getHivStatus() {
        return hivStatus;
    }

    public TIBenReferral hivStatus(String hivStatus) {
        this.hivStatus = hivStatus;
        return this;
    }

    public void setHivStatus(String hivStatus) {
        this.hivStatus = hivStatus;
    }

    public Integer getIsCompleted() {
        return isCompleted;
    }

    public TIBenReferral isCompleted(Integer isCompleted) {
        this.isCompleted = isCompleted;
        return this;
    }

    public void setIsCompleted(Integer isCompleted) {
        this.isCompleted = isCompleted;
    }

    public Boolean isIsActive() {
        return isActive;
    }

    public TIBenReferral isActive(Boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean isIsDelete() {
        return isDelete;
    }

    public TIBenReferral isDelete(Boolean isDelete) {
        this.isDelete = isDelete;
        return this;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public TIBenReferral createdBy(Integer createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public ZonedDateTime getCreatedTime() {
        return createdTime;
    }

    public TIBenReferral createdTime(ZonedDateTime createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public void setCreatedTime(ZonedDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public TIBenReferral modifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public ZonedDateTime getModifiedTime() {
        return modifiedTime;
    }

    public TIBenReferral modifiedTime(ZonedDateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
        return this;
    }

    public void setModifiedTime(ZonedDateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public TIBeneficiary getBeneficiary() {
        return beneficiary;
    }

    public TIBenReferral beneficiary(TIBeneficiary tIBeneficiary) {
        this.beneficiary = tIBeneficiary;
        return this;
    }

    public void setBeneficiary(TIBeneficiary tIBeneficiary) {
        this.beneficiary = tIBeneficiary;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TIBenReferral)) {
            return false;
        }
        return id != null && id.equals(((TIBenReferral) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "TIBenReferral{" +
            "id=" + getId() +
            ", refferalRequestorId=" + getRefferalRequestorId() +
            ", timeOfAppointment='" + getTimeOfAppointment() + "'" +
            ", referralFacility=" + getReferralFacility() +
            ", referredFacility=" + getReferredFacility() +
            ", transferTo='" + getTransferTo() + "'" +
            ", transferFrom='" + getTransferFrom() + "'" +
            ", transferDate='" + getTransferDate() + "'" +
            ", transferStatus='" + getTransferStatus() + "'" +
            ", referralStatus='" + getReferralStatus() + "'" +
            ", dateOfReferral='" + getDateOfReferral() + "'" +
            ", hivStatus='" + getHivStatus() + "'" +
            ", isCompleted=" + getIsCompleted() +
            ", isActive='" + isIsActive() + "'" +
            ", isDelete='" + isIsDelete() + "'" +
            ", createdBy=" + getCreatedBy() +
            ", createdTime='" + getCreatedTime() + "'" +
            ", modifiedBy=" + getModifiedBy() +
            ", modifiedTime='" + getModifiedTime() + "'" +
            "}";
    }
}
