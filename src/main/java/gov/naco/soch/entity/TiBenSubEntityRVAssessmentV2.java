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

@Entity(name = "TiBenSubEntityRVAssessmentV2")
@Table(name = "ti_beneficiary")
@Immutable
public class TiBenSubEntityRVAssessmentV2 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    @Id
    private Long id;
    
    @Column(name = "ti_code")
    private String tiCode;
    
    @Column(name = "date_of_reg")
    private LocalDate dateOfReg;
    
    @Column(name = "orw_code")
    private String orwCode;
    
    @ManyToOne
    @JoinColumn(name = "status_id")
    private MasterTiClientStatus status;
    
    @ManyToOne
    @JoinColumn(name = "master_hrg_primary_id")
    private TypologyMaster hrgPrimary;
    
    @ManyToOne
    private MasterBenSubEntityRVAssessmentV2 beneficiary;
    
    @Column(name="is_active")
    private Boolean isActive;
    
    public TiBenSubEntityRVAssessmentV2() {
    	
    }

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

	public MasterBenSubEntityRVAssessmentV2 getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(MasterBenSubEntityRVAssessmentV2 beneficiary) {
		this.beneficiary = beneficiary;
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

	public String getOrwCode() {
		return orwCode;
	}

	public void setOrwCode(String orwCode) {
		this.orwCode = orwCode;
	}

}
