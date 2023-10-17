package gov.naco.soch.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@GenericGenerator(name = "art_beneficiary_counselling_notes", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "art_beneficiary_counselling_notes_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "art_beneficiary_counselling_notes")
@NamedQuery(name = "ArtBeneficiaryCounsellingNotes.findAll", query = "SELECT n FROM ArtBeneficiaryCounsellingNotes n")
public class ArtBeneficiaryCounsellingNotes extends Auditable<Long> implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( generator = "art_beneficiary_counselling_notes")
	private Long id;
	
	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "art_counselling_note_id")
	private CounsellingNote counsellingNote;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "beneficiary_id")
	private Beneficiary beneficiary;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "facility_id")
	private Facility facility;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "visit_register_id")
	private BeneficiaryVisitRegister beneficiaryVisitRegister;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "entry_user")
	private UserMaster userMaster;
	
	@OneToMany(mappedBy = "artBeneficiaryCounsellingNotes", cascade = CascadeType.ALL, fetch = FetchType.EAGER) 
	 private Set<ArtBeneficiaryCounsellingNotesAnswers> artBeneficiaryCounsellingNotesAnswers;
	
	public ArtBeneficiaryCounsellingNotes() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	
	public CounsellingNote getCounsellingNote() {
		return counsellingNote;
	}

	public void setCounsellingNote(CounsellingNote counsellingNote) {
		this.counsellingNote = counsellingNote;
	}

	public Beneficiary getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}
	public BeneficiaryVisitRegister getBeneficiaryVisitRegister() {
		return beneficiaryVisitRegister;
	}

	public void setBeneficiaryVisitRegister(BeneficiaryVisitRegister beneficiaryVisitRegister) {
		this.beneficiaryVisitRegister = beneficiaryVisitRegister;
	}

	public UserMaster getUserMaster() {
		return userMaster;
	}

	public void setUserMaster(UserMaster userMaster) {
		this.userMaster = userMaster;
	}

	public Set<ArtBeneficiaryCounsellingNotesAnswers> getArtBeneficiaryCounsellingNotesAnswers() {
		return artBeneficiaryCounsellingNotesAnswers;
	}

	public void setArtBeneficiaryCounsellingNotesAnswers(
			Set<ArtBeneficiaryCounsellingNotesAnswers> artBeneficiaryCounsellingNotesAnswers) {
		this.artBeneficiaryCounsellingNotesAnswers = artBeneficiaryCounsellingNotesAnswers;
	}

	
    
	
	
	
	
	

}
