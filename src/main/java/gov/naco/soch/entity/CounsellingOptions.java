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


@GenericGenerator(name = "master_art_counselling_options", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "master_art_counselling_options_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "master_art_counselling_options")
@NamedQuery(name = "CounsellingOptions.findAll", query = "SELECT n FROM CounsellingOptions n")
public class CounsellingOptions extends Auditable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "master_art_counselling_options")
	private Long id;
	
	@Column(name = "counselling_option")
	private String counsellingOption;
	
	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "counselling_note_id")
	private CounsellingNote counsellingNote;
	
	public CounsellingOptions() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCounsellingOption() {
		return counsellingOption;
	}

	public void setCounsellingOption(String counsellingOption) {
		this.counsellingOption = counsellingOption;
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
	
	

	
	
	

}
