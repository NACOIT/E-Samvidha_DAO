package gov.naco.soch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the facility_settings database table.
 * 
 */
@Entity
@Table(name = "facility_settings")
@NamedQuery(name = "FacilitySetting.findAll", query = "SELECT f FROM FacilitySetting f")
public class FacilitySetting extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "dsrc_default")
	private String dsrcDefault;

	@Column(name = "ictc_default")
	private String ictcDefault;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "rntcp_default")
	private String rntcpDefault;

	@Column(name = "ti_default")
	private String tiDefault;

	// bi-directional many-to-one association to Facility
	@ManyToOne
	private Facility facility;

	// bi-directional many-to-one association to FacilityType
	@ManyToOne
	@JoinColumn(name = "facility_type_id")
	private FacilityType facilityType;

	public FacilitySetting() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDsrcDefault() {
		return this.dsrcDefault;
	}

	public void setDsrcDefault(String dsrcDefault) {
		this.dsrcDefault = dsrcDefault;
	}

	public String getIctcDefault() {
		return this.ictcDefault;
	}

	public void setIctcDefault(String ictcDefault) {
		this.ictcDefault = ictcDefault;
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

	public String getRntcpDefault() {
		return this.rntcpDefault;
	}

	public void setRntcpDefault(String rntcpDefault) {
		this.rntcpDefault = rntcpDefault;
	}

	public String getTiDefault() {
		return this.tiDefault;
	}

	public void setTiDefault(String tiDefault) {
		this.tiDefault = tiDefault;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public FacilityType getFacilityType() {
		return this.facilityType;
	}

	public void setFacilityType(FacilityType facilityType) {
		this.facilityType = facilityType;
	}

}