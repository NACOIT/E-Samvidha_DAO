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

/**
 * The persistent class for the master_art_beneficiary_status database table.
 * 
 */
@GenericGenerator(name = "master_art_beneficiary_status", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "master_art_beneficiary_status_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "master_art_beneficiary_status")
@NamedQuery(name = "MasterArtBeneficiaryStatus.findAll", query = "SELECT m FROM MasterArtBeneficiaryStatus m")
public class MasterArtBeneficiaryStatus extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "master_art_beneficiary_status")
	private Long id;

	private String code;

	private String description;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	private String name;

	// bi-directional many-to-one association to ArtBeneficiary
	@OneToMany(mappedBy = "masterArtBeneficiaryStatus")
	private Set<ArtBeneficiary> artBeneficiaries;

	public MasterArtBeneficiaryStatus() {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<ArtBeneficiary> getArtBeneficiaries() {
		return artBeneficiaries;
	}

	public void setArtBeneficiaries(Set<ArtBeneficiary> artBeneficiaries) {
		this.artBeneficiaries = artBeneficiaries;
	}

}