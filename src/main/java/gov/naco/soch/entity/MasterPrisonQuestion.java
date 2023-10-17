package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the master_prison_questions database table.
 * 
 */
@GenericGenerator(name = "master_prison_questions", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "master_prison_questions_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "master_prison_questions")
@NamedQuery(name = "MasterPrisonQuestion.findAll", query = "SELECT d FROM MasterPrisonQuestion d")
public class MasterPrisonQuestion extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( generator = "master_prison_questions")
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(name="question_number")
	private String questionNumber;
	
	@Column(name="question")
	private String question;
	
	@Column(name = "description")
	private String description;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="created_time")
	private LocalDateTime createdTime;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="modified_by")
	private Long modifiedBy;

	@Column(name="modified_time")
	private LocalDateTime modifiedTime;
	
	// bi-directional one-to-many association to DesignationFacilityTypeMapping
//	@OneToMany(mappedBy="master_prison_questions", cascade=CascadeType.ALL)
//	private Set<PrisonQuestionnierResult> prisonQuestionnierResult;
	
	public MasterPrisonQuestion(Long id, String questionNumber, String question, String description, Long createdBy,
			LocalDateTime createdTime, Boolean isActive, Boolean isDelete, Long modifiedBy, LocalDateTime modifiedTime) {
		super();
		this.id = id;
		this.questionNumber = questionNumber;
		this.question = question;
		this.description = description;
		this.createdBy = createdBy;
		this.createdTime = createdTime;
		this.isActive = isActive;
		this.isDelete = isDelete;
		this.modifiedBy = modifiedBy;
		this.modifiedTime = modifiedTime;
	}

	public MasterPrisonQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestionNumber() {
		return questionNumber;
	}

	public void setQuestionNumber(String questionNumber) {
		this.questionNumber = questionNumber;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
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

	public Long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public LocalDateTime getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(LocalDateTime modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

//	public Set<PrisonQuestionnierResult> getPrisonQuestionnierResult() {
//		return prisonQuestionnierResult;
//	}
//
//	public void setPrisonQuestionnierResult(Set<PrisonQuestionnierResult> prisonQuestionnierResult) {
//		this.prisonQuestionnierResult = prisonQuestionnierResult;
//	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "MasterPrisonQuestion [id=" + id + ", questionNumber=" + questionNumber + ", question=" + question
				+ ", description=" + description + ", createdBy=" + createdBy + ", createdTime=" + createdTime
				+ ", isActive=" + isActive + ", isDelete=" + isDelete + ", modifiedBy=" + modifiedBy + ", modifiedTime="
				+ modifiedTime + "]";
	}
	
}
