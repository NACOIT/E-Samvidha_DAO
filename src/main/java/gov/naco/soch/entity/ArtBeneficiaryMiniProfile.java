package gov.naco.soch.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Parameter;

@Entity(name = "ArtBeneficiaryMiniProfile")
@Table(name = "art_beneficiary")
@Immutable
public class ArtBeneficiaryMiniProfile implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "art_beneficiary")
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "facility_id")
    private FacilityMiniProfile facility;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_delete")
    private Boolean isDelete;

    @Column(name = "lac_linked")
    private Boolean lacLinked;

    @Column(name = "is_transit")
    private Boolean isTransit;


    // bi-directional many-to-one association to Beneficiary
    @ManyToOne(fetch = FetchType.LAZY)
    private BeneficiaryMiniProfile beneficiary;


    // bi-directional many-to-one association to MasterBeneficiaryActivityStatus
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "art_beneficiary_status_id")
    private MasterArtBeneficiaryStatus masterArtBeneficiaryStatus;


    public ArtBeneficiaryMiniProfile() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MasterArtBeneficiaryStatus getMasterArtBeneficiaryStatus() {
        return masterArtBeneficiaryStatus;
    }

    public void setMasterArtBeneficiaryStatus(MasterArtBeneficiaryStatus masterArtBeneficiaryStatus) {
        this.masterArtBeneficiaryStatus = masterArtBeneficiaryStatus;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public FacilityMiniProfile getFacility() {
        return facility;
    }

    public void setFacility(FacilityMiniProfile facility) {
        this.facility = facility;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    public Boolean getLacLinked() {
        return lacLinked;
    }

    public void setLacLinked(Boolean lacLinked) {
        this.lacLinked = lacLinked;
    }

    public Boolean getTransit() {
        return isTransit;
    }

    public void setTransit(Boolean transit) {
        isTransit = transit;
    }

    public BeneficiaryMiniProfile getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(BeneficiaryMiniProfile beneficiary) {
        this.beneficiary = beneficiary;
    }

}