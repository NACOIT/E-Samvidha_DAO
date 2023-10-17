package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity(name = "screening")
@Table(name = "ti_ben_scr_details")
@Immutable
public class Screening implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Long id;

    @Column(name = "date_of_screening")
    private ZonedDateTime dateOfScreening;

    @Column(name = "next_date_of_screening")
    private LocalDate nextDateOfScreening;
    
    @Column(name = "prolonged_cough_greater_than_three_weeks")
    private Boolean prolongedCoughGreaterThanThreeWeeks;

    @Column(name = "presence_of_sweat_greater_than_three_weeks")
    private Boolean presenceOfSweatGreaterThanThreeWeeks;

    @Column(name = "weightloss_greater_than_3_kg_in_last_four_weeks")
    private Boolean weightlossGreaterThan3kgInLastFourWeeks;

    @Column(name = "fever_greater_than_three_weeks")
    private Boolean feverGreaterThanThreeWeeks;
    
    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "is_early")
    private Boolean isEarly;

    @Column(name="facility_id")
    private Long facilityId;
    
    @ManyToOne
    @JoinColumn(name = "infection_id")
    private MasterInfectionType infection;
    
    @ManyToOne
    @JoinColumn(name = "screening_status_hiv_id")
    private MasterHivScreeningStatus screeningStatusHiv;

    @ManyToOne
    @JoinColumn(name = "screening_status_syphilis_id")
    private MasterSyphilisStatus screeningStatusSyphilis;

    @ManyToOne
    @JoinColumn(name = "tb_status_id")
    private MasterTbScreeningStatus tbStatus;

    @ManyToOne
    private TiBenSubEntity beneficiary;

    @OneToOne(mappedBy = "tiBenScrDetails")
    private BenReferral beneficiaryReferral;
    
    public Screening() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getDateOfScreening() {
        return dateOfScreening;
    }

    public void setDateOfScreening(ZonedDateTime dateOfScreening) {
        this.dateOfScreening = dateOfScreening;
    }

    public LocalDate getNextDateOfScreening() {
        return nextDateOfScreening;
    }

    public void setNextDateOfScreening(LocalDate nextDateOfScreening) {
        this.nextDateOfScreening = nextDateOfScreening;
    }

    public Boolean getProlongedCoughGreaterThanThreeWeeks() {
        return prolongedCoughGreaterThanThreeWeeks;
    }

    public void setProlongedCoughGreaterThanThreeWeeks(Boolean prolongedCoughGreaterThanThreeWeeks) {
        this.prolongedCoughGreaterThanThreeWeeks = prolongedCoughGreaterThanThreeWeeks;
    }

    public Boolean getPresenceOfSweatGreaterThanThreeWeeks() {
        return presenceOfSweatGreaterThanThreeWeeks;
    }

    public void setPresenceOfSweatGreaterThanThreeWeeks(Boolean presenceOfSweatGreaterThanThreeWeeks) {
        this.presenceOfSweatGreaterThanThreeWeeks = presenceOfSweatGreaterThanThreeWeeks;
    }

    public Boolean getWeightlossGreaterThan3kgInLastFourWeeks() {
        return weightlossGreaterThan3kgInLastFourWeeks;
    }

    public void setWeightlossGreaterThan3kgInLastFourWeeks(Boolean weightlossGreaterThan3kgInLastFourWeeks) {
        this.weightlossGreaterThan3kgInLastFourWeeks = weightlossGreaterThan3kgInLastFourWeeks;
    }

    public Boolean getFeverGreaterThanThreeWeeks() {
        return feverGreaterThanThreeWeeks;
    }

    public void setFeverGreaterThanThreeWeeks(Boolean feverGreaterThanThreeWeeks) {
        this.feverGreaterThanThreeWeeks = feverGreaterThanThreeWeeks;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Boolean getIsEarly() {
        return isEarly;
    }

    public void setIsEarly(Boolean isEarly) {
        this.isEarly = isEarly;
    }

    public Long getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
    }

    public MasterInfectionType getInfection() {
        return infection;
    }

    public void setInfection(MasterInfectionType infection) {
        this.infection = infection;
    }

    public MasterHivScreeningStatus getScreeningStatusHiv() {
        return screeningStatusHiv;
    }

    public void setScreeningStatusHiv(MasterHivScreeningStatus screeningStatusHiv) {
        this.screeningStatusHiv = screeningStatusHiv;
    }

    public MasterSyphilisStatus getScreeningStatusSyphilis() {
        return screeningStatusSyphilis;
    }

    public void setScreeningStatusSyphilis(MasterSyphilisStatus screeningStatusSyphilis) {
        this.screeningStatusSyphilis = screeningStatusSyphilis;
    }

    public MasterTbScreeningStatus getTbStatus() {
        return tbStatus;
    }

    public void setTbStatus(MasterTbScreeningStatus tbStatus) {
        this.tbStatus = tbStatus;
    }

    public TiBenSubEntity getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(TiBenSubEntity beneficiary) {
        this.beneficiary = beneficiary;
    }

    public BenReferral getBeneficiaryReferral() {
        return beneficiaryReferral;
    }

    public void setBeneficiaryReferral(BenReferral beneficiaryReferral) {
        this.beneficiaryReferral = beneficiaryReferral;
    }
    
    

}


