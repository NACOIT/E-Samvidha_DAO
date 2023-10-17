package gov.naco.soch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Where;

import gov.naco.soch.entity.MasterPrimaryDrug;

@Entity(name="OstAssessmentDrugUsage")
@Table(name = "ti_ost_assessment_drugusage")
@Where(clause="is_delete=false")
@Immutable
public class OstAssessmentDrugUsage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
      private Long id;

	@ManyToOne
	@JoinColumn(name = "assessment_id")
	private OstAssessment tiOstAssessment;

	@ManyToOne
	@JoinColumn(name = "drug_id")
	private MasterPrimaryDrug drugUsage;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public OstAssessment getTiOstAssessment() {
	    return tiOstAssessment;
	}

	public void setTiOstAssessment(OstAssessment tiOstAssessment) {
	    this.tiOstAssessment = tiOstAssessment;
	}

	public MasterPrimaryDrug getDrugUsage() {
		return drugUsage;
	}

	public void setDrugUsage(MasterPrimaryDrug drugUsage) {
		this.drugUsage = drugUsage;
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

}
