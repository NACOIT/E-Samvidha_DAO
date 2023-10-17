package gov.naco.soch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "tiBeneficiaryV2ReadOnlySequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "ti_beneficiary_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@NamedEntityGraph(name = "tiBeneficiaryV2ReadOnlyGraph")
@Entity(name = "TiBeneficiaryV2ReadOnly")
@Table(name = "ti_beneficiary")
@Immutable
public class TiBeneficiaryV2ReadOnly  extends Auditable<Long> implements Serializable {

    /**
    * 
    */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "tiBeneficiaryV2ReadOnlySequence")
    private Long id;
    
    @Column(name = "ti_code")
    private String tiCode;
    
    @ManyToOne
    @JoinColumn(name = "master_hrg_primary_id")
    private TypologyMaster hrgPrimary;
    
    @ManyToOne
    @JoinColumn(name = "status_id")
    private MasterTiClientStatus status;
    
    @OneToOne
    private  BeneficiaryV2ReadOnly beneficiary;
    
    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_deleted")
    private Boolean isDeleted;
    

    @Column(name = "facility_id")
    private Long facilityId;
    
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

	public TypologyMaster getHrgPrimary() {
		return hrgPrimary;
	}

	public void setHrgPrimary(TypologyMaster hrgPrimary) {
		this.hrgPrimary = hrgPrimary;
	}

	public MasterTiClientStatus getStatus() {
		return status;
	}

	public void setStatus(MasterTiClientStatus status) {
		this.status = status;
	}

	public BeneficiaryV2ReadOnly getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(BeneficiaryV2ReadOnly beneficiary) {
		this.beneficiary = beneficiary;
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

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}
	
}
