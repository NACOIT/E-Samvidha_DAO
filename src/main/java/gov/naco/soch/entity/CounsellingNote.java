package gov.naco.soch.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "master_art_counselling_note", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "master_art_counselling_note_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "master_art_counselling_note")
@NamedQuery(name = "CounsellingNote.findAll", query = "SELECT n FROM CounsellingNote n")
public class CounsellingNote extends Auditable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( generator = "master_art_counselling_note")
	private Long id;
	
	@Column(name = "counselling_note")
	private String counsellingNote;
	
	@Column(name = "counselling_section")
	private String counsellingSection;
	
	@Column(name = "question_key")
	private String questionKey;
	
	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;
	
	@Column(name="first_visit_only")
	private Boolean firstVisit;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "counselling_type_id")
	private CounsellingType counsellingType;
	
	
	 @OneToMany(mappedBy = "counsellingNote") 
	 private Set<CounsellingOptions>counsellingOptions;
	 
	 @OneToMany(mappedBy = "counsellingNote") 
	 private Set<ArtBeneficiaryCounsellingNotes> artBeneficiaryCounsellingNotes;
	 
	 
	public CounsellingNote() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCounsellingNote() {
		return counsellingNote;
	}

	public void setCounsellingNote(String counsellingNote) {
		this.counsellingNote = counsellingNote;
	}

	public String getCounsellingSection() {
		return counsellingSection;
	}

	public void setCounsellingSection(String counsellingSection) {
		this.counsellingSection = counsellingSection;
	}

	public String getQuestionKey() {
		return questionKey;
	}

	public void setQuestionKey(String questionKey) {
		this.questionKey = questionKey;
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

	public Boolean getFirstVisit() {
		return firstVisit;
	}

	public void setFirstVisit(Boolean firstVisit) {
		this.firstVisit = firstVisit;
	}

	public CounsellingType getCounsellingType() {
		return counsellingType;
	}

	public void setCounsellingType(CounsellingType counsellingType) {
		this.counsellingType = counsellingType;
	}

	public Set<CounsellingOptions> getCounsellingOptions() {
		return counsellingOptions;
	}

	public void setCounsellingOptions(Set<CounsellingOptions> counsellingOptions) {
		this.counsellingOptions = counsellingOptions;
	}
	
	public Set<ArtBeneficiaryCounsellingNotes> getArtBeneficiaryCounsellingNotes() {
		return artBeneficiaryCounsellingNotes;
	}

	public void setArtBeneficiaryCounsellingNotes(Set<ArtBeneficiaryCounsellingNotes> artBeneficiaryCounsellingNotes) {
		this.artBeneficiaryCounsellingNotes = artBeneficiaryCounsellingNotes;
	}

	

}
