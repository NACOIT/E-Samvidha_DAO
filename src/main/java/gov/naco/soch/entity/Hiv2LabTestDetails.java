package gov.naco.soch.entity;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * The persistent class for the hiv2_lab_test_details database table.
 *
 */
@GenericGenerator(name = "hiv2_lab_test_details", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
        @Parameter(name = "sequence_name", value = "hiv2_lab_test_details_id_seq"),
        @Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })

@Entity
@Table(name = "hiv2_lab_test_details")

public class Hiv2LabTestDetails extends Auditable<Long> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "hiv2_lab_test_details")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hiv2_lab_facility_id")
    private Facility hiv2LabFacility;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "facility_id")
    private Facility facility;

    @ManyToOne(fetch = FetchType.LAZY)
    private IctcBeneficiary ictcBeneficiary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "beneficiary_id")
    private Beneficiary beneficiary;

    @Column(name = "pid", length = 99)
    private String pid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hiv_type_id")
    private MasterHivType hivType;

    @Column(name = "result_date")
    private LocalDate resultDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hiv2_lab_result_status_id")
    private MasterHiv2LabResultStatus hiv2LabResultStatusId;

    @Column(name="is_active")
    private Boolean isActive;

    @Column(name="is_delete")
    private Boolean isDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Facility getHiv2LabFacility() {
        return hiv2LabFacility;
    }

    public void setHiv2LabFacility(Facility hiv2LabFacility) {
        this.hiv2LabFacility = hiv2LabFacility;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public IctcBeneficiary getIctcBeneficiary() {
        return ictcBeneficiary;
    }

    public void setIctcBeneficiary(IctcBeneficiary ictcBeneficiary) {
        this.ictcBeneficiary = ictcBeneficiary;
    }

    public Beneficiary getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(Beneficiary beneficiary) {
        this.beneficiary = beneficiary;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public MasterHivType getHivType() {
        return hivType;
    }

    public void setHivType(MasterHivType hivType) {
        this.hivType = hivType;
    }

    public LocalDate getResultDate() {
        return resultDate;
    }

    public void setResultDate(LocalDate resultDate) {
        this.resultDate = resultDate;
    }

    public MasterHiv2LabResultStatus getHiv2LabResultStatusId() {
        return hiv2LabResultStatusId;
    }

    public void setHiv2LabResultStatusId(MasterHiv2LabResultStatus hiv2LabResultStatusId) {
        this.hiv2LabResultStatusId = hiv2LabResultStatusId;
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

}
