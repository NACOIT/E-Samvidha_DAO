package gov.naco.soch.entity;


import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@NamedEntityGraph(
        name = "counsellingV2Graph"
)
@Entity(
        name = "TiCounsellingV2SubEntity"
)
@Table(
        name = "ti_ben_counselling"
)
@Immutable
public class TiCounsellingV2SubEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;

    @Column(
            name = "last_counselling_date"
    )
    private LocalDate lastCounsellingDate;

    @ManyToOne
    @JoinColumn(name = "beneficiary_id")
    private TiBenV2SubEntity beneficiary;

    @Column(name="is_early")
    private Boolean isEarly;

    @Column(name = "next_counselling_date")
    private LocalDate nextCounsellingDate;

    @Column(name = "facility_id")
    private Long facilityId;

    @Column(name = "duration_of_counselling")
    private Integer durationOfCounselling;

    @Column(name = "no_of_condoms_distributed")
    private Integer noOfCondomsDistributed;

    @Column(name = "counselling_date")
    private LocalDate counsellingDate;

    @Column(name = "is_deleted")
    private Boolean isDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getLastCounsellingDate() {
        return lastCounsellingDate;
    }

    public void setLastCounsellingDate(LocalDate lastCounsellingDate) {
        this.lastCounsellingDate = lastCounsellingDate;
    }

    public TiBenV2SubEntity getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(TiBenV2SubEntity beneficiary) {
        this.beneficiary = beneficiary;
    }

    public Boolean getEarly() {
        return isEarly;
    }

    public void setEarly(Boolean early) {
        isEarly = early;
    }

    public LocalDate getNextCounsellingDate() {
        return nextCounsellingDate;
    }

    public void setNextCounsellingDate(LocalDate nextCounsellingDate) {
        this.nextCounsellingDate = nextCounsellingDate;
    }

    public Long getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
    }

    public Integer getDurationOfCounselling() {
        return durationOfCounselling;
    }

    public void setDurationOfCounselling(Integer durationOfCounselling) {
        this.durationOfCounselling = durationOfCounselling;
    }

    public Integer getNoOfCondomsDistributed() {
        return noOfCondomsDistributed;
    }

    public void setNoOfCondomsDistributed(Integer noOfCondomsDistributed) {
        this.noOfCondomsDistributed = noOfCondomsDistributed;
    }

    public LocalDate getCounsellingDate() {
        return counsellingDate;
    }

    public void setCounsellingDate(LocalDate counsellingDate) {
        this.counsellingDate = counsellingDate;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }
}
