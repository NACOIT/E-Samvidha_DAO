package gov.naco.soch.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "master_art_beneficiary_delete_reason", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "master_art_beneficiary_delete_reason_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })

@Entity
@Table(name = "master_art_beneficiary_delete_reason")
@NamedQuery(name = "MasterArtBeneficiaryDeleteReason.findAll", query = "SELECT m FROM MasterArtBeneficiaryDeleteReason m")
public class MasterArtBeneficiaryDeleteReason extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "master_art_beneficiary_delete_reason")
	private Long id;
	
	private String code;
	
	private String name;
	
	private String description;
	
	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;
	
	@OneToMany(mappedBy = "masterArtBeneficiaryDeleteReason")
	private Set<ArtBeneficiary> artBeneficiaries;
	
	public MasterArtBeneficiaryDeleteReason() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Set<ArtBeneficiary> getArtBeneficiaries() {
		return artBeneficiaries;
	}

	public void setArtBeneficiaries(Set<ArtBeneficiary> artBeneficiaries) {
		this.artBeneficiaries = artBeneficiaries;
	}
	
	
}
