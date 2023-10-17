package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "prison_questionaire_results", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "prison_questionaire_results_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "prison_questionaire_results")
@NamedQuery(name = "PrisonQuestionnierResult.findAll", query = "SELECT a FROM PrisonQuestionnierResult a")
public class PrisonQuestionnierResult extends Auditable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
			return serialVersionUID;
		}

	@Id
	@GeneratedValue(generator = "prison_questionaire_results")
	@Column(unique = true, nullable = false)
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	// bi-directional many-to-one association to masterPrisonQuestion Facility
//	@ManyToOne
//	@JoinColumn(name="question_number")
//	private MasterPrisonQuestion masterPrisonQuestion;
	
	@Column(name="question_id")
	private Integer masterPrisonQuestion;
	
	@Column(name="male_value")
	private Integer maleValue;
	
	@Column(name="female_value")
	private Integer femaleValue;
	
	@Column(name="tg_value")
	private Integer tgValue;
	
	@Column(name="financial_year")
	private String financialYear;
	
	@Column(name="month_name")
	private Integer month;
	
//	@ManyToOne
//	@JoinColumn(name="facility_id")
//	private Facility facility;
	
	@Column(name="facility_id")
	private Long facility;
	
	@Column(name="is_submitted_to_naco")
	private Boolean isSubmittedToNaco;
	
	@Column(name="total_prison_in_state")
	private Integer totalprisonstate;
	
	@Column(name="total_prison_till_reporting_month")
	private Integer prisonstated;
	
	public Integer getTotalprisonstate() {
		return totalprisonstate;
	}	

	public void setTotalprisonstate(Integer totalprisonstate) {
		this.totalprisonstate = totalprisonstate;
	}

	public Integer getPrisonstated() {
		return prisonstated;
	}

	public void setPrisonstated(Integer prisonstated) {
		this.prisonstated = prisonstated;
	}

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;
		
	public PrisonQuestionnierResult() {
		
	}

	public PrisonQuestionnierResult(Long id, Integer masterPrisonQuestion, Integer maleValue, Integer femaleValue,
			Integer tgValue, String financialYear, Integer month, Long facility, Boolean isSubmittedToNaco,
			Integer totalprisonstate, Integer prisonstated, Boolean isActive, Boolean isDelete) {
		super();
		this.id = id;
		this.masterPrisonQuestion = masterPrisonQuestion;
		this.maleValue = maleValue;
		this.femaleValue = femaleValue;
		this.tgValue = tgValue;
		this.financialYear = financialYear;
		this.month = month;
		this.facility = facility;
		this.isSubmittedToNaco = isSubmittedToNaco;
		this.totalprisonstate = totalprisonstate;
		this.prisonstated = prisonstated;
		this.isActive = isActive;
		this.isDelete = isDelete;
	}

//	public MasterPrisonQuestion getMasterPrisonQuestion() {
//		return masterPrisonQuestion;
//	}
//
//	public void setMasterPrisonQuestion(MasterPrisonQuestion masterPrisonQuestion) {
//		this.masterPrisonQuestion = masterPrisonQuestion;
//	}
	
	public Integer getMasterPrisonQuestion() {
		return masterPrisonQuestion;
	}

	public void setMasterPrisonQuestion(Integer masterPrisonQuestion) {
		this.masterPrisonQuestion = masterPrisonQuestion;
	}

	public Integer getMaleValue() {
		return maleValue;
	}

	public void setMaleValue(Integer maleValue) {
		this.maleValue = maleValue;
	}

	public Integer getFemaleValue() {
		return femaleValue;
	}

	public void setFemaleValue(Integer femaleValue) {
		this.femaleValue = femaleValue;
	}

	public Integer getTgValue() {
		return tgValue;
	}

	public void setTgValue(Integer tgValue) {
		this.tgValue = tgValue;
	}

	public String getFinancialYear() {
		return financialYear;
	}

	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

//	public Facility getFacility() {
//		return facility;
//	}
//
//	public void setFacility(Facility facility) {
//		this.facility = facility;
//	}

	public Long getFacility() {
		return facility;
	}

	public void setFacility(Long facility) {
		this.facility = facility;
	}
	
	public Boolean getIsSubmittedToNaco() {
		return isSubmittedToNaco;
	}

	public void setIsSubmittedToNaco(Boolean isSubmittedToNaco) {
		this.isSubmittedToNaco = isSubmittedToNaco;
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

	@Override
	public String toString() {
		return "PrisonQuestionnierResult [id=" + id + ", masterPrisonQuestion=" + masterPrisonQuestion + ", maleValue="
				+ maleValue + ", femaleValue=" + femaleValue + ", tgValue=" + tgValue + ", financialYear="
				+ financialYear + ", month=" + month + ", facility=" + facility + ", isSubmittedToNaco="
				+ isSubmittedToNaco + ", totalprisonstate=" + totalprisonstate + ", prisonstated=" + prisonstated
				+ ", isActive=" + isActive + ", isDelete=" + isDelete + "]";
	}
	
	
}
