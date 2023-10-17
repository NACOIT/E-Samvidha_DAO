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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the master_inventory_unregistered_source database
 * table.
 * 
 */
@Entity
@Table(name = "master_inventory_unregistered_source")
@NamedQuery(name = "MasterInventoryUnregisteredSource.findAll", query = "SELECT m FROM MasterInventoryUnregisteredSource m")
public class MasterInventoryUnregisteredSource extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "source_name")
	private String sourceName;

	// bi-directional many-to-one association to FacilityReceipt
	@OneToMany(mappedBy = "masterInventoryUnregisteredSource")
	private Set<FacilityReceipt> facilityReceipts;

	// bi-directional many-to-one association to FacilityReceipt
	@OneToMany(mappedBy = "masterInventoryUnregisteredSource")
	private Set<FacilityDispatch> facilityDispatchs;

	// bi-directional many-to-one association to Address
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Address address;

	@Column(name = "is_facility")
	private Boolean isFacility;

	public MasterInventoryUnregisteredSource() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public String getSourceName() {
		return this.sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public Set<FacilityReceipt> getFacilityReceipts() {
		return this.facilityReceipts;
	}

	public void setFacilityReceipts(Set<FacilityReceipt> facilityReceipts) {
		this.facilityReceipts = facilityReceipts;
	}

	public FacilityReceipt addFacilityReceipt(FacilityReceipt facilityReceipt) {
		getFacilityReceipts().add(facilityReceipt);
		facilityReceipt.setMasterInventoryUnregisteredSource(this);

		return facilityReceipt;
	}

	public FacilityReceipt removeFacilityReceipt(FacilityReceipt facilityReceipt) {
		getFacilityReceipts().remove(facilityReceipt);
		facilityReceipt.setMasterInventoryUnregisteredSource(null);

		return facilityReceipt;
	}

	public Set<FacilityDispatch> getFacilityDispatchs() {
		return facilityDispatchs;
	}

	public void setFacilityDispatchs(Set<FacilityDispatch> facilityDispatchs) {
		this.facilityDispatchs = facilityDispatchs;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Boolean getIsFacility() {
		return isFacility;
	}

	public void setIsFacility(Boolean isFacility) {
		this.isFacility = isFacility;
	}

}