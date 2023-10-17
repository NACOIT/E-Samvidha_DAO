package gov.naco.soch.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
/**
 * The persistent class for the beneficiary_four_s_symptoms_per_visit database
 * table.
 * 
 */
@GenericGenerator(name = "benSymptomFourSequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "beneficiary_four_s_symptoms_per_visit_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "beneficiary_four_s_symptoms_per_visit")
@NamedQuery(name = "BeneficiaryFourSSymptomsPerVisit.findAll", query = "SELECT b FROM BeneficiaryFourSSymptomsPerVisit b")
public class BeneficiaryFourSSymptomsPerVisit extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "benSymptomFourSequence")
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	// bi-directional many-to-one association to BeneficiaryVisitRegister
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "visit_register_id")
	private BeneficiaryVisitRegister beneficiaryVisitRegister;

	// bi-directional many-to-one association to MasterFourSSymptom
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "four_s_symptom")
	private MasterFourSsymptom masterFourSSymptom;

	public BeneficiaryFourSSymptomsPerVisit() {
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

	public BeneficiaryVisitRegister getBeneficiaryVisitRegister() {
		return beneficiaryVisitRegister;
	}

	public void setBeneficiaryVisitRegister(BeneficiaryVisitRegister beneficiaryVisitRegister) {
		this.beneficiaryVisitRegister = beneficiaryVisitRegister;
	}

	public MasterFourSsymptom getMasterFourSSymptom() {
		return masterFourSSymptom;
	}

	public void setMasterFourSSymptom(MasterFourSsymptom masterFourSSymptom) {
		this.masterFourSSymptom = masterFourSSymptom;
	}
}
