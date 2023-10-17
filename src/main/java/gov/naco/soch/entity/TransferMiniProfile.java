package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "transferSequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
                @Parameter(name = "sequence_name", value = "transfers_id_seq"),
                @Parameter(name = "increment_size", value = "1"),
                @Parameter(name = "optimizer", value = "hilo") })
@Entity(name="TransferMiniProfile")
@Table(name="transfers")
public class TransferMiniProfile  implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "transferSequence")
    private Long id;

    @Column(name="is_active")
    private Boolean isActive;

    @Column(name="is_deleted")
    private Boolean isDeleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="beneficiary_id")
    private BeneficiaryMiniProfile beneficiary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="destination_facility_id")
    private FacilityMiniProfile facilityTo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="source_facility_id")
    private FacilityMiniProfile facilityFrom;

    @Column(name = "transfer_status")
    private String transferStatus;

    @Column(name = "accepted_time")
    private LocalDateTime acceptedTime;


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

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public BeneficiaryMiniProfile getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(BeneficiaryMiniProfile beneficiary) {
        this.beneficiary = beneficiary;
    }

    public void setFacilityTo(FacilityMiniProfile facilityTo) {
        this.facilityTo = facilityTo;
    }

    public FacilityMiniProfile getFacilityTo() {
        return facilityTo;
    }

    public FacilityMiniProfile getFacilityFrom() {
        return facilityFrom;
    }

    public void setFacilityFrom(FacilityMiniProfile facilityFrom) {
        this.facilityFrom = facilityFrom;
    }
    public LocalDateTime getAcceptedTime() {
        return acceptedTime;
    }

    public void setAcceptedTime(LocalDateTime acceptedTime) {
        this.acceptedTime = acceptedTime;
    }

    public String getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(String transferStatus) {
        this.transferStatus = transferStatus;
    }

}