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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "tIHotspot", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "ti_hotspot_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })

@Entity
@Table(name = "ti_hotspot")
@NamedQuery(name = "TIHotspot.findAll", query = "SELECT a FROM TIHotspot a")
public class TIHotspot extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(generator = "tIHotspot")
    private Long id;

	@Column(name = "hotspot_name")
	private String hotspotName;

	@Column(name = "hotspot_code")
	private String hotspotCode;

	@Column(name = "hotspot_status")
	private String hotspotStatus;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "status")
	private String status;

	@ManyToOne(fetch = FetchType.LAZY)
	private Facility facility;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "typology_id")
	private TypologyMaster typology;

	@ManyToOne(cascade = CascadeType.ALL)
	private Address hotspotAddress;

	public TIHotspot() {
	    // TODO Auto-generated constructor stub
	}
	
	public TIHotspot(Long hotspotId) {
	   this.id=hotspotId;
	}

	public String getHotspotName() {
		return hotspotName;
	}

	public void setHotspotName(String hotspotName) {
		this.hotspotName = hotspotName;
	}

	public String getHotspotCode() {
		return hotspotCode;
	}

	public void setHotspotCode(String hotspotCode) {
		this.hotspotCode = hotspotCode;
	}

	public String getHotspotStatus() {
		return hotspotStatus;
	}

	public void setHotspotStatus(String hotspotStatus) {
		this.hotspotStatus = hotspotStatus;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Address getHotspotAddress() {
		return hotspotAddress;
	}

	public void setHotspotAddress(Address hotspotAddress) {
		this.hotspotAddress = hotspotAddress;
	}

	public TypologyMaster getTypology() {
		return typology;
	}

	public void setTypology(TypologyMaster typology) {
		this.typology = typology;
	}

}
