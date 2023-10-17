package gov.naco.soch.entity;

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


@GenericGenerator(name = "OstAssessmentVCReadOnly", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "ti_ost_beneficiary_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })

@Entity(name = "OstAssessmentVCReadOnly")
@Table(name = "ti_ost_assessment")
@Immutable
public class OstAssessmentVCReadOnly implements Comparable<OstAssessmentVCReadOnly>{

	private static final long serialVersionUID = 1L;

	@Id
	 @GeneratedValue(generator = "OstAssessmentVCReadOnly")
	private Long id;

	@Column(name = "date_of_assessment")
	private LocalDate dateOfAssessment;
	
	@ManyToOne
	@JoinColumn(name = "ti_ost_beneficiary_id")
	private OstBenSubEntityVCReadOnly tiOstBeneficiary;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDateOfAssessment() {
		return dateOfAssessment;
	}

	public void setDateOfAssessment(LocalDate dateOfAssessment) {
		this.dateOfAssessment = dateOfAssessment;
	}

	public OstBenSubEntityVCReadOnly getTiOstBeneficiary() {
		return tiOstBeneficiary;
	}

	public void setTiOstBeneficiary(OstBenSubEntityVCReadOnly tiOstBeneficiary) {
		this.tiOstBeneficiary = tiOstBeneficiary;
	}

	@Override
	public int compareTo(OstAssessmentVCReadOnly o) {
	    // TODO Auto-generated method stub
	    return 0;
	}
}
