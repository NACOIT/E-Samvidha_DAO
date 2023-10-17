package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity(name = "TiBenSubEntity")
@Table(name = "ti_beneficiary")
@Immutable
public class TiBenSubEntity implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    
    @Column(name = "date_of_reg")
    private LocalDate dateOfReg;

    @Column(name = "ti_code")
    private String tiCode;
    
    @Column(name = "lap_treatments")
    private Integer lapTreatments;

    @Column(name = "ib_treatments")
    private Integer ibTreatments;
    @Column(name = "orw_code")
    private String orwCode;
    
    @Column(name="is_active")
    private Boolean isActive;
    
    @ManyToOne
    @JoinColumn(name = "status_id")
    private MasterTiClientStatus status;
    
    @ManyToOne
    @JoinColumn(name = "master_hrg_primary_id")
    private TypologyMaster hrgPrimary;

    @ManyToOne
    @JoinColumn(name = "master_hrg_secondary_id")
    private MasterHrgSecondary hrgSecondary;
    
    @ManyToOne
    private MasterBenSubEntity beneficiary;
    
    public TiBenSubEntity() {
	
    }

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

    public LocalDate getDateOfReg() {
        return dateOfReg;
    }

    public void setDateOfReg(LocalDate dateOfReg) {
        this.dateOfReg = dateOfReg;
    }

    public String getTiCode() {
        return tiCode;
    }

    public void setTiCode(String tiCode) {
        this.tiCode = tiCode;
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

    public MasterBenSubEntity getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(MasterBenSubEntity beneficiary) {
        this.beneficiary = beneficiary;
    }

	public String getOrwCode() {
		return orwCode;
	}

	public void setOrwCode(String orwCode) {
		this.orwCode = orwCode;
	}
    
    

    
    
}
