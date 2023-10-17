package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
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
 * The persistent class for the art_beneficiary_vitamin_a database table.
 * 
 */
@GenericGenerator(name = "art_beneficiary_vitamin_a", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "art_beneficiary_vitamin_a_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "art_beneficiary_vitamin_a")
@NamedQuery(name = "ArtBeneficiaryVitaminA.findAll", query = "SELECT a FROM ArtBeneficiaryVitaminA a")
public class ArtBeneficiaryVitaminA extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "art_beneficiary_vitamin_a")
	private Long id;

	@Column(name = "given_date")
	private LocalDate givenDate;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	// bi-directional many-to-one association to Beneficiary
	@ManyToOne(fetch = FetchType.LAZY)
	private Beneficiary beneficiary;

	// bi-directional many-to-one association to MasterVitaminAAge
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vitamin_a_age_id")
	private MasterVitaminAAge masterVitaminAAge;

	public ArtBeneficiaryVitaminA() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getGivenDate() {
		return this.givenDate;
	}

	public void setGivenDate(LocalDate givenDate) {
		this.givenDate = givenDate;
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

	public MasterVitaminAAge getMasterVitaminAAge() {
		return this.masterVitaminAAge;
	}

	public void setMasterVitaminAAge(MasterVitaminAAge masterVitaminAAge) {
		this.masterVitaminAAge = masterVitaminAAge;
	}

}