package gov.naco.soch.entity;

import java.io.Serializable;
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
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the beneficiary_social_welfare_schemes database
 * table.
 * 
 */
@GenericGenerator(name = "beneficiary_social_welfare_schemes", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "beneficiary_social_welfare_schemes_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })

@Entity
@Table(name = "beneficiary_social_welfare_schemes")
@NamedQuery(name = "BeneficiarySocialWelfareScheme.findAll", query = "SELECT b FROM BeneficiarySocialWelfareScheme b")
public class BeneficiarySocialWelfareScheme extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "beneficiary_social_welfare_schemes")
	private Long id;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	// bi-directional many-to-one association to Beneficiary
	@ManyToOne(fetch = FetchType.LAZY)
	private Beneficiary beneficiary;

	// bi-directional many-to-one association to MasterSocialWelfare
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "social_welfare_scheme_id")
	private MasterSocialWelfare masterSocialWelfare;

	public BeneficiarySocialWelfareScheme() {
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

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Beneficiary getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	public MasterSocialWelfare getMasterSocialWelfare() {
		return masterSocialWelfare;
	}

	public void setMasterSocialWelfare(MasterSocialWelfare masterSocialWelfare) {
		this.masterSocialWelfare = masterSocialWelfare;
	}
}
