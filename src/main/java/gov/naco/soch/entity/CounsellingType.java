package gov.naco.soch.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "counsellingTypeSequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "master_art_counselling_type_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "master_art_counselling_type")
@NamedQuery(name = "CounsellingType.findAll", query = "SELECT n FROM CounsellingType n")
public class CounsellingType extends Auditable<Long> implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "counsellingTypeSequence")
	private Long id;
	
	@Column(name = "counselling_type")
	private String counsellingType;
	
	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;
	
	
    @OneToMany(mappedBy = "counsellingType") 
	private Set<CounsellingNote> counsellingNotes;
	 
	
	public CounsellingType() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCounsellingType() {
		return counsellingType;
	}

	public void setCounsellingType(String counsellingType) {
		this.counsellingType = counsellingType;
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

	public Set<CounsellingNote> getCounsellingNotes() {
		return counsellingNotes;
	}

	public void setCounsellingNotes(Set<CounsellingNote> counsellingNotes) {
		this.counsellingNotes = counsellingNotes;
	}

	

}
