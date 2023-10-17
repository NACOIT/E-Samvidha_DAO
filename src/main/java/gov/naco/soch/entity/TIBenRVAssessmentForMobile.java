package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * A TIBenRVAssessment.
 */
@GenericGenerator(name = "benRVSequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "ti_ben_rv_assessment_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "ti_ben_rv_assessment")
public class TIBenRVAssessmentForMobile extends Auditable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "benRVSequence")
	private Long id;

	@Column(name = "due_date_of_assessment")
	private LocalDate dueDateOfAssessment;

	@Column(name = "assessment_pending")
	private Integer assessmentPending;

	@Column(name = "assessment_date")
	private LocalDate assessmentDate;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_early")
	private Boolean isEarly;

	@Column(name = "survey_id")
	private Long surveyId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "beneficiary_id")
	private TIBeneficiary beneficiary;

	@ManyToOne(fetch = FetchType.LAZY)
	private Facility facility;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "assessment_date_bti")
	private LocalDate assessmentDateBTi;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "master_rv_assement_status_id")
	private MasterRvAssementStatus assementStatus;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Questionnaire> questionnaire = new ArrayList<Questionnaire>();

	public List<Questionnaire> getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(List<Questionnaire> questionnaire) {
		this.questionnaire = questionnaire;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Boolean getIsEarly() {
		return isEarly;
	}

	public void setIsEarly(Boolean isEarly) {
		this.isEarly = isEarly;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	// jhipster-needle-entity-add-field - JHipster will add fields here, do not
	// remove
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Long surveyId) {
		this.surveyId = surveyId;
	}

	public MasterRvAssementStatus getAssementStatus() {
		return assementStatus;
	}

	public void setAssementStatus(MasterRvAssementStatus assementStatus) {
		this.assementStatus = assementStatus;
	}

	public LocalDate getDueDateOfAssessment() {
		return dueDateOfAssessment;
	}

	public TIBenRVAssessmentForMobile dueDateOfAssessment(LocalDate dueDateOfAssessment) {
		this.dueDateOfAssessment = dueDateOfAssessment;
		return this;
	}

	public void setDueDateOfAssessment(LocalDate dueDateOfAssessment) {
		this.dueDateOfAssessment = dueDateOfAssessment;
	}

	public Integer getAssessmentPending() {
		return assessmentPending;
	}

	public TIBenRVAssessmentForMobile assessmentPending(Integer assessmentPending) {
		this.assessmentPending = assessmentPending;
		return this;
	}

	public void setAssessmentPending(Integer assessmentPending) {
		this.assessmentPending = assessmentPending;
	}

	public LocalDate getAssessmentDate() {
		return assessmentDate;
	}

	public TIBenRVAssessmentForMobile assessmentDate(LocalDate assessmentDate) {
		this.assessmentDate = assessmentDate;
		return this;
	}

	public void setAssessmentDate(LocalDate assessmentDate) {
		this.assessmentDate = assessmentDate;
	}

	public Boolean isIsActive() {
		return isActive;
	}

	public TIBenRVAssessmentForMobile isActive(Boolean isActive) {
		this.isActive = isActive;
		return this;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public TIBeneficiary getBeneficiary() {
		return beneficiary;
	}

	public TIBenRVAssessmentForMobile beneficiary(TIBeneficiary tIBeneficiary) {
		this.beneficiary = tIBeneficiary;
		return this;
	}

	public void setBeneficiary(TIBeneficiary tIBeneficiary) {
		this.beneficiary = tIBeneficiary;
	}
	// jhipster-needle-entity-add-getters-setters - JHipster will add getters
	// and setters here, do not remove

	public LocalDate getAssessmentDateBTi() {
		return assessmentDateBTi;
	}

	public void setAssessmentDateBTi(LocalDate assessmentDateBTi) {
		this.assessmentDateBTi = assessmentDateBTi;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof TIBenRVAssessmentForMobile)) {
			return false;
		}
		return id != null && id.equals(((TIBenRVAssessmentForMobile) o).id);
	}

	@Override
	public int hashCode() {
		return 31;
	}

	

}
