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
import java.time.LocalDate;

/**
 * The persistent class for the art_beneficiary_due_list database table.
 *
 */

@Entity(name = "ArtBeneficiaryDueListMiniMapper")
@Table(name = "art_beneficiary_due_list")
@Immutable
public class ArtBeneficiaryDueListMiniMapper  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "art_beneficiary_due_list")
    private Integer id;

    @Column(name = "expected_visit_date")
    private LocalDate expectedVisitDate;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_delete")
    private Boolean isDelete;

    @ManyToOne(fetch = FetchType.LAZY)
    private BeneficiaryMiniProfile beneficiary;

    @ManyToOne(fetch = FetchType.LAZY)
    private FacilityMiniProfile facility;


    // bi-directional many-to-one association to UserMaster

    @Column(name = "is_visited")
    private Boolean isVisited;

    public ArtBeneficiaryDueListMiniMapper() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getExpectedVisitDate() {
        return this.expectedVisitDate;
    }

    public void setExpectedVisitDate(LocalDate expectedVisitDate) {
        this.expectedVisitDate = expectedVisitDate;
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
    public Boolean getIsVisited() {
        return this.isVisited;
    }

    public void setIsVisited(Boolean isVisited) {
        this.isVisited = isVisited;
    }


    public BeneficiaryMiniProfile getBeneficiary() {
        return this.beneficiary;
    }

    public void setBeneficiary(BeneficiaryMiniProfile beneficiary) {
        this.beneficiary = beneficiary;
    }

    public FacilityMiniProfile getFacility() {
        return this.facility;
    }

    public void setFacility(FacilityMiniProfile facility) {
        this.facility = facility;
    }
}
