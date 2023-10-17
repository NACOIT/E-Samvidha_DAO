package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity(name="RVAssessmentV2ForMobile")
@Table(name = "ti_ben_rv_assessment")
@Immutable
public class RVAssessmentV2ForMobile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    @Id
    private Long id;
    
	@Column(name = "assessment_date")
	private LocalDate assessmentDate;
	
	@ManyToOne
    private TiBenSubEntityRVAssessmentV2 beneficiary;
    
	@Column(name = "due_date_of_assessment")
	private LocalDate dueDateOfAssessment;
	
	@Column(name="facility_id")
	private Long facilityId;

	@Column(name = "is_delete")
	private Boolean isDelete;
	
	@Column(name="is_early")
	private Boolean isEarly;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getAssessmentDate() {
		return assessmentDate;
	}

	public void setAssessmentDate(LocalDate assessmentDate) {
		this.assessmentDate = assessmentDate;
	}

	public TiBenSubEntityRVAssessmentV2 getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(TiBenSubEntityRVAssessmentV2 beneficiary) {
		this.beneficiary = beneficiary;
	}

	public LocalDate getDueDateOfAssessment() {
		return dueDateOfAssessment;
	}

	public void setDueDateOfAssessment(LocalDate dueDateOfAssessment) {
		this.dueDateOfAssessment = dueDateOfAssessment;
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
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
	

}
