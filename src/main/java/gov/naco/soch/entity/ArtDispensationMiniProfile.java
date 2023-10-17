package gov.naco.soch.entity;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * The Immutable class for the art_dispensation database table.
 *
 */

@Entity(name = "ArtDispensationMiniProfile")
@Table(name = "art_dispensation")
@Immutable
public class ArtDispensationMiniProfile implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "art_dispensation")
    private Long id;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_delete")
    private Boolean isDelete;

    @ManyToOne(fetch = FetchType.LAZY)
    private BeneficiaryMiniProfile beneficiary;

    // bi-directional many-to-one association to Facility
    @ManyToOne(fetch = FetchType.LAZY)
    private FacilityMiniProfile facility;

    public ArtDispensationMiniProfile() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsDelete() {
        return this.isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

}