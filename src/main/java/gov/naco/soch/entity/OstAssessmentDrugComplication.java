package gov.naco.soch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Where;

import gov.naco.soch.entity.MasterDrugComplications;

@Entity(name="OstAssessmentDrugComplication")
@Table(name = "ti_ost_assessment_drugcomplication")
@Where(clause="is_delete=false")
@Immutable
public class OstAssessmentDrugComplication  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
     @GeneratedValue(generator = "tiOstAssessmentDrugComplicationSequence")
     private Long id;

	@ManyToOne
	@JoinColumn(name = "assessment_id")
	private OstAssessment tiOstAssessment;

	@ManyToOne
	@JoinColumn(name = "complication_id")
	private MasterDrugComplications complication;

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

	public MasterDrugComplications getComplication() {
		return complication;
	}

	public void setComplication(MasterDrugComplications complication) {
		this.complication = complication;
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