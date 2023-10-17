package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity(name = "screeningV2")
@Table(name = "ti_ben_scr_details")
@Immutable
public class ScreeningV2 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Long id;

    @Column(name = "date_of_screening")
    private ZonedDateTime dateOfScreening;

    @Column(name = "next_date_of_screening")
    private LocalDate nextDateOfScreening;
    
      
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
    private TiBenSubEntity beneficiary;

    
    public ScreeningV2() {

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

       public TiBenSubEntity getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(TiBenSubEntity beneficiary) {
        this.beneficiary = beneficiary;
    }

  }


