package gov.naco.soch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "ti_profile_update", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
	@Parameter(name = "sequence_name", value = "ti_profile_update_id_seq"),
	@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })

@Entity
@Table(name = "ti_profile_update")
@NamedQuery(name = "TiProfileUpdate.findAll", query = "SELECT t FROM TiProfileUpdate t")
public class TiProfileUpdate extends Auditable<Long> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "ti_profile_update")
    private Long id;
    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "is_delete")
    private Boolean isDelete;
    @Column(name = "facility_id")
    private Long facilityId;
    private Integer advocacy;
    @Column(name = "violence_reported")
    private Integer violenceReported;
    private Integer committees;
    @Column(name = "orw_sanctioned")
    private Integer orwSanctioned;
    @Column(name = "orw_total")
    private Integer orwTotal;
    @Column(name = "pe_sanctioned")
    private Integer peSanctioned;
    @Column(name = "pe_total")
    private Integer peTotal;
    @Column(name = "other_staff_vacant")
    private Integer otherStaffVacant;
    @Column(name = "new_staff_recruit")
    private Integer newStaffRecruit;
    private Integer month;
    private Integer year;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Boolean getIsActive() {
        return isActive;
    }
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
    public Boolean getIsDelete() {
        return isDelete;
    }
    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }
    public Long getFacilityId() {
        return facilityId;
    }
    public void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
    }
    public Integer getMonth() {
        return month;
    }
    public void setMonth(Integer month) {
        this.month = month;
    }
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
    public Integer getAdvocacy() {
        return advocacy;
    }
    public void setAdvocacy(Integer advocacy) {
        this.advocacy = advocacy;
    }
    public Integer getViolenceReported() {
        return violenceReported;
    }
    public void setViolenceReported(Integer violenceReported) {
        this.violenceReported = violenceReported;
    }
    public Integer getCommittees() {
        return committees;
    }
    public void setCommittees(Integer committees) {
        this.committees = committees;
    }
    public Integer getOrwSanctioned() {
        return orwSanctioned;
    }
    public void setOrwSanctioned(Integer orwSanctioned) {
        this.orwSanctioned = orwSanctioned;
    }
    public Integer getOrwTotal() {
        return orwTotal;
    }
    public void setOrwTotal(Integer orwTotal) {
        this.orwTotal = orwTotal;
    }
    public Integer getPeSanctioned() {
        return peSanctioned;
    }
    public void setPeSanctioned(Integer peSanctioned) {
        this.peSanctioned = peSanctioned;
    }
    public Integer getPeTotal() {
        return peTotal;
    }
    public void setPeTotal(Integer peTotal) {
        this.peTotal = peTotal;
    }
    public Integer getOtherStaffVacant() {
        return otherStaffVacant;
    }
    public void setOtherStaffVacant(Integer otherStaffVacant) {
        this.otherStaffVacant = otherStaffVacant;
    }
    public Integer getNewStaffRecruit() {
        return newStaffRecruit;
    }
    public void setNewStaffRecruit(Integer newStaffRecruit) {
        this.newStaffRecruit = newStaffRecruit;
    }

    
    
}
