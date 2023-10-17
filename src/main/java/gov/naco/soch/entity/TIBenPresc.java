package gov.naco.soch.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * A TIBenPresc.
 */
@Entity
@Table(name = "ti_ben_presc")
public class TIBenPresc implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "facility_id", nullable = false)
    private Integer facilityId;

    @Column(name = "initiation_date")
    private ZonedDateTime initiationDate;

    @Column(name = "substitution_drug")
    private Integer substitutionDrug;

    @Column(name = "consent_taken")
    private Boolean consentTaken;

    @Column(name = "dosage")
    private Integer dosage;

    @Column(name = "measure_of_unit")
    private String measureOfUnit;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_delete")
    private Boolean isDelete;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "created_time")
    private ZonedDateTime createdTime;

    @Column(name = "modified_by")
    private Integer modifiedBy;

    @Column(name = "modified_time")
    private ZonedDateTime modifiedTime;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties("tIBenPrescs")
    private TIBeneficiary beneficiary;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFacilityId() {
        return facilityId;
    }

    public TIBenPresc facilityId(Integer facilityId) {
        this.facilityId = facilityId;
        return this;
    }

    public void setFacilityId(Integer facilityId) {
        this.facilityId = facilityId;
    }

    public ZonedDateTime getInitiationDate() {
        return initiationDate;
    }

    public TIBenPresc initiationDate(ZonedDateTime initiationDate) {
        this.initiationDate = initiationDate;
        return this;
    }

    public void setInitiationDate(ZonedDateTime initiationDate) {
        this.initiationDate = initiationDate;
    }

    public Integer getSubstitutionDrug() {
        return substitutionDrug;
    }

    public TIBenPresc substitutionDrug(Integer substitutionDrug) {
        this.substitutionDrug = substitutionDrug;
        return this;
    }

    public void setSubstitutionDrug(Integer substitutionDrug) {
        this.substitutionDrug = substitutionDrug;
    }

    public Boolean isConsentTaken() {
        return consentTaken;
    }

    public TIBenPresc consentTaken(Boolean consentTaken) {
        this.consentTaken = consentTaken;
        return this;
    }

    public void setConsentTaken(Boolean consentTaken) {
        this.consentTaken = consentTaken;
    }

    public Integer getDosage() {
        return dosage;
    }

    public TIBenPresc dosage(Integer dosage) {
        this.dosage = dosage;
        return this;
    }

    public void setDosage(Integer dosage) {
        this.dosage = dosage;
    }

    public String getMeasureOfUnit() {
        return measureOfUnit;
    }

    public TIBenPresc measureOfUnit(String measureOfUnit) {
        this.measureOfUnit = measureOfUnit;
        return this;
    }

    public void setMeasureOfUnit(String measureOfUnit) {
        this.measureOfUnit = measureOfUnit;
    }

    public Boolean isIsActive() {
        return isActive;
    }

    public TIBenPresc isActive(Boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean isIsDelete() {
        return isDelete;
    }

    public TIBenPresc isDelete(Boolean isDelete) {
        this.isDelete = isDelete;
        return this;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public TIBenPresc createdBy(Integer createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public ZonedDateTime getCreatedTime() {
        return createdTime;
    }

    public TIBenPresc createdTime(ZonedDateTime createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public void setCreatedTime(ZonedDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public TIBenPresc modifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public ZonedDateTime getModifiedTime() {
        return modifiedTime;
    }

    public TIBenPresc modifiedTime(ZonedDateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
        return this;
    }

    public void setModifiedTime(ZonedDateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public TIBeneficiary getBeneficiary() {
        return beneficiary;
    }

    public TIBenPresc beneficiary(TIBeneficiary tIBeneficiary) {
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
        if (!(o instanceof TIBenPresc)) {
            return false;
        }
        return id != null && id.equals(((TIBenPresc) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "TIBenPresc{" +
            "id=" + getId() +
            ", facilityId=" + getFacilityId() +
            ", initiationDate='" + getInitiationDate() + "'" +
            ", substitutionDrug=" + getSubstitutionDrug() +
            ", consentTaken='" + isConsentTaken() + "'" +
            ", dosage=" + getDosage() +
            ", measureOfUnit='" + getMeasureOfUnit() + "'" +
            ", isActive='" + isIsActive() + "'" +
            ", isDelete='" + isIsDelete() + "'" +
            ", createdBy=" + getCreatedBy() +
            ", createdTime='" + getCreatedTime() + "'" +
            ", modifiedBy=" + getModifiedBy() +
            ", modifiedTime='" + getModifiedTime() + "'" +
            "}";
    }
}
