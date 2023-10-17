package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "beneficiary_referral", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "beneficiary_referral_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Entity(name = "BeneficiaryReferralViewCardReadOnly")
@Table(name = "beneficiary_referral")
@Immutable
public class BeneficiaryReferralViewCardReadOnly extends Auditable<Long> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "beneficiary_referral")
	private Long id;

	@Column(name = "refer_date")
	private LocalDate referDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "beneficiary_id")
	private BeneficiaryViewCardReadOnly beneficiary;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="refered_to")
	FacilityReadOnly referredTo;
	
	@Column(name = "referral_reason")
	private String referralReason;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getReferDate() {
		return referDate;
	}

	public void setReferDate(LocalDate referDate) {
		this.referDate = referDate;
	}

	public BeneficiaryViewCardReadOnly getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(BeneficiaryViewCardReadOnly beneficiary) {
		this.beneficiary = beneficiary;
	}

	public FacilityReadOnly getReferredTo() {
		return referredTo;
	}

	public void setReferredTo(FacilityReadOnly referredTo) {
		this.referredTo = referredTo;
	}

	public String getReferralReason() {
		return referralReason;
	}

	public void setReferralReason(String referralReason) {
		this.referralReason = referralReason;
	}
	
	
}
