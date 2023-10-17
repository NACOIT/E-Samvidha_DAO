package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity(name = "TIBenBasicDetails")
@Table(name = "ti_beneficiary")
@Immutable
public class TIBenBasicDetails implements Serializable{

  
   private static final long serialVersionUID = 1L;
   @Id
   private Long id;
   @Column(name = "ti_code")
   private String tiCode;
   @Column(name = "is_deleted")
   private Boolean isDeleted;
   @Column(name = "date_of_reg")
   private LocalDate dateOfReg;
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "status_id")
   private MasterTiClientStatus status;
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "master_hrg_primary_id")
   private TypologyMaster hrgPrimary;
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "master_hrg_secondary_id")
   private MasterHrgSecondary hrgSecondary;
   @ManyToOne(fetch = FetchType.LAZY)
   private MasterBenSubEntity beneficiary;
   
   @Column(name = "lap_treatments")
   private Integer lapTreatments;

   @Column(name = "ib_treatments")
   private Integer ibTreatments;
   
public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public String getTiCode() {
    return tiCode;
}
public void setTiCode(String tiCode) {
    this.tiCode = tiCode;
}
public Boolean getIsDeleted() {
    return isDeleted;
}
public void setIsDeleted(Boolean isDeleted) {
    this.isDeleted = isDeleted;
}
public MasterBenSubEntity getBeneficiary() {
    return beneficiary;
}
public void setBeneficiary(MasterBenSubEntity beneficiary) {
    this.beneficiary = beneficiary;
}
public LocalDate getDateOfReg() {
    return dateOfReg;
}
public void setDateOfReg(LocalDate dateOfReg) {
    this.dateOfReg = dateOfReg;
}
public MasterTiClientStatus getStatus() {
    return status;
}
public void setStatus(MasterTiClientStatus status) {
    this.status = status;
}
public TypologyMaster getHrgPrimary() {
    return hrgPrimary;
}
public void setHrgPrimary(TypologyMaster hrgPrimary) {
    this.hrgPrimary = hrgPrimary;
}
public MasterHrgSecondary getHrgSecondary() {
    return hrgSecondary;
}
public void setHrgSecondary(MasterHrgSecondary hrgSecondary) {
    this.hrgSecondary = hrgSecondary;
}

public Integer getLapTreatments() {
	return lapTreatments;
  }
public void setLapTreatments(Integer lapTreatments) {
	this.lapTreatments = lapTreatments;
    }

    public Integer getIbTreatments() {
	return ibTreatments;
    }

    public void setIbTreatments(Integer ibTreatments) {
	this.ibTreatments = ibTreatments;
    }
   
}
