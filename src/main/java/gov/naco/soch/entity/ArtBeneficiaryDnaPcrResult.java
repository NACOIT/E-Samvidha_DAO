package gov.naco.soch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the art_beneficiary_dna_pcr_result database table.
 * 
 */
@GenericGenerator(name = "artBeneficiaryDnaPcrResultSequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "art_beneficiary_dna_pcr_result_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "art_beneficiary_dna_pcr_result")
@NamedQuery(name = "ArtBeneficiaryDnaPcrResult.findAll", query = "SELECT a FROM ArtBeneficiaryDnaPcrResult a")
public class ArtBeneficiaryDnaPcrResult extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "artBeneficiaryDnaPcrResultSequence")
	private Long id;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	// bi-directional many-to-one association to Beneficiary
	@ManyToOne(fetch = FetchType.LAZY)
	private Beneficiary beneficiary;

	// bi-directional many-to-one association to MasterDnaPcrResult
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dna_pcr_result_id")
	private MasterDnaPcrResult masterDnaPcrResult;

	// bi-directional many-to-one association to MasterDnaPcrTest
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dna_pcr_test_id")
	private MasterDnaPcrTest masterDnaPcrTest;

	public ArtBeneficiaryDnaPcrResult() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Beneficiary getBeneficiary() {
		return this.beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	public MasterDnaPcrResult getMasterDnaPcrResult() {
		return this.masterDnaPcrResult;
	}

	public void setMasterDnaPcrResult(MasterDnaPcrResult masterDnaPcrResult) {
		this.masterDnaPcrResult = masterDnaPcrResult;
	}

	public MasterDnaPcrTest getMasterDnaPcrTest() {
		return this.masterDnaPcrTest;
	}

	public void setMasterDnaPcrTest(MasterDnaPcrTest masterDnaPcrTest) {
		this.masterDnaPcrTest = masterDnaPcrTest;
	}

}