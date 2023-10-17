package gov.naco.soch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the master_name_list database table.
 * 
 */
@Entity
@Table(name = "master_name_list")
@NamedQuery(name = "MasterNameList.findAll", query = "SELECT m FROM MasterNameList m")
public class MasterNameList extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "master_description", length = 2147483647)
	private String masterDescription;

	@Column(name = "master_name", length = 2147483647)
	private String masterName;
	
	@Column(name = "master_type")
	private Integer masterType;
	
	@Column(name = "fetch_endpoint", length = 2147483647)
	private String fetchEndpoint;
	
	@Column(name = "save_endpoint", length = 2147483647)
	private String saveEndpoint;

	public MasterNameList() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public String getMasterDescription() {
		return this.masterDescription;
	}

	public void setMasterDescription(String masterDescription) {
		this.masterDescription = masterDescription;
	}

	public String getMasterName() {
		return this.masterName;
	}

	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}

	public Integer getMasterType() {
		return masterType;
	}

	public void setMasterType(Integer masterType) {
		this.masterType = masterType;
	}

	public String getFetchEndpoint() {
		return fetchEndpoint;
	}

	public void setFetchEndpoint(String fetchEndpoint) {
		this.fetchEndpoint = fetchEndpoint;
	}

	public String getSaveEndpoint() {
		return saveEndpoint;
	}

	public void setSaveEndpoint(String saveEndpoint) {
		this.saveEndpoint = saveEndpoint;
	}
	

}