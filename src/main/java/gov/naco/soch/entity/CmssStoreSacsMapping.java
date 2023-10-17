package gov.naco.soch.entity;

import java.io.Serializable;

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

/**
 * The persistent class for the cmss_store_sacs_mapping database table.
 * 
 */
@Entity
@GenericGenerator(name = "cmss_store_sacs_mapping", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "cmss_store_sacs_mapping_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Table(name = "cmss_store_sacs_mapping")
@NamedQuery(name = "CmssStoreSacsMapping.findAll", query = "SELECT c FROM CmssStoreSacsMapping c")
public class CmssStoreSacsMapping extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "cmss_store_sacs_mapping")
	private Long id;

	@Column(name = "store_id")
	private String cmssStoreId;

	@Column(name = "cmss_store_name")
	private String cmssStoreName;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	// bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name = "sacs_id")
	private Facility facility;

	public CmssStoreSacsMapping() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCmssStoreId() {
		return cmssStoreId;
	}

	public void setCmssStoreId(String cmssStoreId) {
		this.cmssStoreId = cmssStoreId;
	}

	public String getCmssStoreName() {
		return this.cmssStoreName;
	}

	public void setCmssStoreName(String cmssStoreName) {
		this.cmssStoreName = cmssStoreName;
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

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

}