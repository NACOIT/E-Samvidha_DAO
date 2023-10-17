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


@GenericGenerator(name = "tiOstAssessmentDrugComplicationSequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "ti_ost_assessment_drugcomplication_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })

@Entity
@Table(name = "ti_ost_assessment_drugcomplication")
@NamedQuery(name = "TiOstAssessmentDrugComplication.findAll", query = "SELECT t FROM TiOstAssessmentDrugComplication t")
@Where(clause="is_delete=false")
public class TiOstAssessmentDrugComplication extends Auditable<Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(generator = "tiOstAssessmentDrugComplicationSequence")
    private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "assessment_id")
	private TiOstAssessment tiOstAssessment;

	@ManyToOne(fetch = FetchType.LAZY)
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

	public TiOstAssessment getTiOstAssessment() {
		return tiOstAssessment;
	}

	public void setTiOstAssessment(TiOstAssessment tiOstAssessment) {
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
