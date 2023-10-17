package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "benRVSequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "ti_ben_rv_assessment_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Entity(name = "TIBenRVAssessmentViewCardReadOnly")
@Table(name = "ti_ben_rv_assessment")
@Immutable
public class TIBenRVAssessmentViewCardReadOnly extends Auditable<Long> implements Serializable,Comparable<TIBenRVAssessmentViewCardReadOnly> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "benRVSequence")
	private Long id;

	@Column(name = "due_date_of_assessment")
	private LocalDate dueDateOfAssessment;

	@Column(name = "assessment_date")
	private LocalDate assessmentDate;

	@ManyToOne
	@JoinColumn(name = "beneficiary_id")
	private TiBeneficiaryViewCardReadOnly beneficiary;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDueDateOfAssessment() {
		return dueDateOfAssessment;
	}

	public void setDueDateOfAssessment(LocalDate dueDateOfAssessment) {
		this.dueDateOfAssessment = dueDateOfAssessment;
	}

	public LocalDate getAssessmentDate() {
		return assessmentDate;
	}

	public void setAssessmentDate(LocalDate assessmentDate) {
		this.assessmentDate = assessmentDate;
	}

	public TiBeneficiaryViewCardReadOnly getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(TiBeneficiaryViewCardReadOnly beneficiary) {
		this.beneficiary = beneficiary;
	}

	@Override
	public int compareTo(TIBenRVAssessmentViewCardReadOnly o) {
	    // TODO Auto-generated method stub
	    return 0;
	}

	
}
