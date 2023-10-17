package gov.naco.soch.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@GenericGenerator(name = "dsrc_default_facility_linked_facility", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
        @Parameter(name = "sequence_name", value = "dsrc_default_facility_linked_facility_id_seq"),
        @Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "dsrc_default_facility_linked_facility")

public class DsrcDefaultFacilityLinkedFacility extends Auditable<Long> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "default_facility_name", length = 200)
    private String defaultFacilityName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "default_facility_id")
    private Facility defaultFacility;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dsrc_facility_id")
    private Facility dsrcFacility;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "default_facility_type_id")
    private FacilityType defaultFacilityType;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDefaultFacilityName() {
        return defaultFacilityName;
    }

    public void setDefaultFacilityName(String defaultFacilityName) {
        this.defaultFacilityName = defaultFacilityName;
    }

    public Facility getDefaultFacility() {
        return defaultFacility;
    }

    public void setDefaultFacility(Facility defaultFacility) {
        this.defaultFacility = defaultFacility;
    }

    public Facility getDsrcFacility() {
        return dsrcFacility;
    }

    public void setDsrcFacility(Facility dsrcFacility) {
        this.dsrcFacility = dsrcFacility;
    }

    public FacilityType getDefaultFacilityType() {
        return defaultFacilityType;
    }

    public void setDefaultFacilityType(FacilityType defaultFacilityType) {
        this.defaultFacilityType = defaultFacilityType;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }


    public Long getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

}
