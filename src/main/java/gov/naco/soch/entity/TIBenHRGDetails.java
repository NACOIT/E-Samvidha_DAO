package gov.naco.soch.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * A TIBenHRGDetails.
 */
@Entity
@Table(name = "ti_ben_hrg_details")
public class TIBenHRGDetails implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hrg_primary_category")
    private String hrgPrimaryCategory;

    @Column(name = "hrg_secondary_category")
    private String hrgSecondaryCategory;

    @Column(name = "sub_category")
    private String subCategory;

    @Column(name = "avg_no_sexual_acts_upon_reg")
    private Integer avgNoSexualActsUponReg;

    @Column(name = "no_years_in_sex_work")
    private Integer noYearsInSexWork;

    @Column(name = "consume_alcohol")
    private Boolean consumeAlcohol;

    @Column(name = "alcohol_cons_days_in_week")
    private Integer alcoholConsDaysInWeek;

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
    @JsonIgnoreProperties("tIBenHRGDetails")
    private TIBeneficiary beneficiary;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHrgPrimaryCategory() {
        return hrgPrimaryCategory;
    }

    public TIBenHRGDetails hrgPrimaryCategory(String hrgPrimaryCategory) {
        this.hrgPrimaryCategory = hrgPrimaryCategory;
        return this;
    }

    public void setHrgPrimaryCategory(String hrgPrimaryCategory) {
        this.hrgPrimaryCategory = hrgPrimaryCategory;
    }

    public String getHrgSecondaryCategory() {
        return hrgSecondaryCategory;
    }

    public TIBenHRGDetails hrgSecondaryCategory(String hrgSecondaryCategory) {
        this.hrgSecondaryCategory = hrgSecondaryCategory;
        return this;
    }

    public void setHrgSecondaryCategory(String hrgSecondaryCategory) {
        this.hrgSecondaryCategory = hrgSecondaryCategory;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public TIBenHRGDetails subCategory(String subCategory) {
        this.subCategory = subCategory;
        return this;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public Integer getAvgNoSexualActsUponReg() {
        return avgNoSexualActsUponReg;
    }

    public TIBenHRGDetails avgNoSexualActsUponReg(Integer avgNoSexualActsUponReg) {
        this.avgNoSexualActsUponReg = avgNoSexualActsUponReg;
        return this;
    }

    public void setAvgNoSexualActsUponReg(Integer avgNoSexualActsUponReg) {
        this.avgNoSexualActsUponReg = avgNoSexualActsUponReg;
    }

    public Integer getNoYearsInSexWork() {
        return noYearsInSexWork;
    }

    public TIBenHRGDetails noYearsInSexWork(Integer noYearsInSexWork) {
        this.noYearsInSexWork = noYearsInSexWork;
        return this;
    }

    public void setNoYearsInSexWork(Integer noYearsInSexWork) {
        this.noYearsInSexWork = noYearsInSexWork;
    }

    public Boolean isConsumeAlcohol() {
        return consumeAlcohol;
    }

    public TIBenHRGDetails consumeAlcohol(Boolean consumeAlcohol) {
        this.consumeAlcohol = consumeAlcohol;
        return this;
    }

    public void setConsumeAlcohol(Boolean consumeAlcohol) {
        this.consumeAlcohol = consumeAlcohol;
    }

    public Integer getAlcoholConsDaysInWeek() {
        return alcoholConsDaysInWeek;
    }

    public TIBenHRGDetails alcoholConsDaysInWeek(Integer alcoholConsDaysInWeek) {
        this.alcoholConsDaysInWeek = alcoholConsDaysInWeek;
        return this;
    }

    public void setAlcoholConsDaysInWeek(Integer alcoholConsDaysInWeek) {
        this.alcoholConsDaysInWeek = alcoholConsDaysInWeek;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public TIBenHRGDetails createdBy(Integer createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public ZonedDateTime getCreatedTime() {
        return createdTime;
    }

    public TIBenHRGDetails createdTime(ZonedDateTime createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public void setCreatedTime(ZonedDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public TIBenHRGDetails modifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public ZonedDateTime getModifiedTime() {
        return modifiedTime;
    }

    public TIBenHRGDetails modifiedTime(ZonedDateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
        return this;
    }

    public void setModifiedTime(ZonedDateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public TIBeneficiary getBeneficiary() {
        return beneficiary;
    }

    public TIBenHRGDetails beneficiary(TIBeneficiary tIBeneficiary) {
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
        if (!(o instanceof TIBenHRGDetails)) {
            return false;
        }
        return id != null && id.equals(((TIBenHRGDetails) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "TIBenHRGDetails{" +
            "id=" + getId() +
            ", hrgPrimaryCategory='" + getHrgPrimaryCategory() + "'" +
            ", hrgSecondaryCategory='" + getHrgSecondaryCategory() + "'" +
            ", subCategory='" + getSubCategory() + "'" +
            ", avgNoSexualActsUponReg=" + getAvgNoSexualActsUponReg() +
            ", noYearsInSexWork=" + getNoYearsInSexWork() +
            ", consumeAlcohol='" + isConsumeAlcohol() + "'" +
            ", alcoholConsDaysInWeek=" + getAlcoholConsDaysInWeek() +
            ", createdBy=" + getCreatedBy() +
            ", createdTime='" + getCreatedTime() + "'" +
            ", modifiedBy=" + getModifiedBy() +
            ", modifiedTime='" + getModifiedTime() + "'" +
            "}";
    }
}
