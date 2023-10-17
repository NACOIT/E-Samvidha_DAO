package gov.naco.soch.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * The persistent class for the master_dsrc_beneficiary_status database table.
 * 
 */
@GenericGenerator(name = "master_dsrc_beneficiary_status", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
parameters = {
		@Parameter(name = "sequence_name", value = "master_dsrc_beneficiary_status_id_seq"),
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "master_dsrc_beneficiary_status")
@NamedQuery(name = "MasterDsrcBeneficiaryStatus.findAll", query = "SELECT m FROM MasterDsrcBeneficiaryStatus m")
public class MasterDsrcBeneficiaryStatus extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "master_dsrc_beneficiary_status")
	private Long id;

	private String code;

	private String description;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	private String name;


	public MasterDsrcBeneficiaryStatus() {
	}

	public MasterDsrcBeneficiaryStatus(Long id) {
		this.id = id;
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


}