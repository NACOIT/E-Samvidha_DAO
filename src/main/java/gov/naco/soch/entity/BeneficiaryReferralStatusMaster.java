package gov.naco.soch.entity;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import java.time.LocalDate;
import java.util.Set;


/**
 * The persistent class for the beneficiary_referral_status_master database table.
 * 
 */
@GenericGenerator(name = "beneficiary_referral_status_master", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "beneficiary_referral_status_master_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name="beneficiary_referral_status_master")
@NamedQuery(name="BeneficiaryReferralStatusMaster.findAll", query="SELECT b FROM BeneficiaryReferralStatusMaster b")
public class BeneficiaryReferralStatusMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "beneficiary_referral_status_master")
	@Column(name="referral_status_id")
	private Integer referralStatusId;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private LocalDate createdTime;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private LocalDate modifiedTime;

	private String status;

	//bi-directional many-to-one association to BeneficiaryReferral
	@OneToMany(mappedBy="beneficiaryReferralStatusMaster")
	private Set<BeneficiaryReferral> beneficiaryReferrals;

	public BeneficiaryReferralStatusMaster() {
	}

	public Integer getReferralStatusId() {
		return this.referralStatusId;
	}

	public void setReferralStatusId(Integer referralStatusId) {
		this.referralStatusId = referralStatusId;
	}

	public Integer getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}


	public LocalDate getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDate createdTime) {
		this.createdTime = createdTime;
	}

	public LocalDate getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(LocalDate modifiedTime) {
		this.modifiedTime = modifiedTime;
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

	public Integer getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<BeneficiaryReferral> getBeneficiaryReferrals() {
		return this.beneficiaryReferrals;
	}

	public void setBeneficiaryReferrals(Set<BeneficiaryReferral> beneficiaryReferrals) {
		this.beneficiaryReferrals = beneficiaryReferrals;
	}



	public BeneficiaryReferral removeBeneficiaryReferral(BeneficiaryReferral beneficiaryReferral) {
		getBeneficiaryReferrals().remove(beneficiaryReferral);
		beneficiaryReferral.setBeneficiaryReferralStatusMaster(null);

		return beneficiaryReferral;
	}

}