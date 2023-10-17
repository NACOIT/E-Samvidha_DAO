package gov.naco.soch.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.Date;
import java.sql.Timestamp;
import java.time.LocalDate;


/**
 * The persistent class for the art_beneficiary_immunization_report database table.
 * 
 */
@GenericGenerator(name = "art_beneficiary_immunization_report", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "art_beneficiary_immunization_report_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name="art_beneficiary_immunization_report")
@NamedQuery(name="ArtBeneficiaryImmunizationReport.findAll", query="SELECT a FROM ArtBeneficiaryImmunizationReport a")
public class ArtBeneficiaryImmunizationReport extends Auditable<Long> implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "art_beneficiary_immunization_report")
	private Long id;

	@Column(name="due_date")
	private LocalDate dueDate;

	@Column(name="given_date")
	private LocalDate givenDate;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;
	
	
	@Column(name="vaccination_age")
	private Integer vaccinationAge;

	//bi-directional many-to-one association to Beneficiary
	@ManyToOne(fetch = FetchType.LAZY)
	private Beneficiary beneficiary;

	//bi-directional many-to-one association to MasterVaccineStage
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="vaccine_stage_id")
	private MasterVaccineStage masterVaccineStage;

	//bi-directional many-to-one association to MasterVaccineType
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="vaccine_type_id")
	private MasterVaccineType masterVaccineType;

	public ArtBeneficiaryImmunizationReport() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public LocalDate getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
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


	public Integer getVaccinationAge() {
		return this.vaccinationAge;
	}

	public void setVaccinationAge(Integer vaccinationAge) {
		this.vaccinationAge = vaccinationAge;
	}

	public Beneficiary getBeneficiary() {
		return this.beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	public MasterVaccineStage getMasterVaccineStage() {
		return this.masterVaccineStage;
	}

	public void setMasterVaccineStage(MasterVaccineStage masterVaccineStage) {
		this.masterVaccineStage = masterVaccineStage;
	}

	public MasterVaccineType getMasterVaccineType() {
		return this.masterVaccineType;
	}

	public void setMasterVaccineType(MasterVaccineType masterVaccineType) {
		this.masterVaccineType = masterVaccineType;
	}

}