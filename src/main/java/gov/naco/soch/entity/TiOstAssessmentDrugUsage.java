package gov.naco.soch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Where;

@GenericGenerator(name = "tiOstAssessmentDrugUsage", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "ti_ost_assessment_drugusage_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })

@Entity
@Table(name = "ti_ost_assessment_drugusage")
@NamedQuery(name = "TiOstAssessmentDrugUsage.findAll", query = "SELECT t FROM TiOstAssessmentDrugUsage t")
@Where(clause="is_delete=false")
public class TiOstAssessmentDrugUsage extends Auditable<Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(generator = "tiOstAssessmentDrugUsage")
    private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "assessment_id")
	private TiOstAssessment tiOstAssessment;

	@ManyToOne(fetch = FetchType.LAZY)
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

	public TiOstAssessment getTiOstAssessment() {
		return tiOstAssessment;
	}

	public void setTiOstAssessment(TiOstAssessment tiOstAssessment) {
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
