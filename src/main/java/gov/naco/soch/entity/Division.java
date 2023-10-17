package gov.naco.soch.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the division database table.
 * 
 */

@GenericGenerator(name = "division", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "division_id_seq"), @Parameter(name = "increment_size", value = "1"),
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "division")
@NamedQuery(name = "Division.findAll", query = "SELECT d FROM Division d")
public class Division extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "division")
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(length = 99)
	private String code;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(length = 99)
	private String name;

	@Column(name = "npo_email_id")
	private String npoEmailId;

	@Column(name = "npo_mobile_number")
	private String npoMobileNumber;

	@Column(name = "npo_name")
	private String npoName;

	@Column(name = "scc_email_id")
	private String sccEmailId;

	@Column(name = "scc_mobile_number")
	private String sccMobileNumber;

	@Column(name = "scc_name")
	private String sccName;

	// bi-directional many-to-one association to Facility
	@OneToMany(mappedBy = "division")
	private Set<Facility> facilities;

	// bi-directional many-to-one association to FacilityTypeDivisionMapping
	@OneToMany(mappedBy = "division", cascade = CascadeType.ALL)
	private Set<FacilityTypeDivisionMapping> facilityTypeDivisionMappings;

	// bi-directional many-to-one association to Product
	@OneToMany(mappedBy = "division")
	private Set<Product> products;

	// bi-directional many-to-one association to UserMaster
	@OneToMany(mappedBy = "division")
	private Set<UserMaster> userMasters;

	// bi-directional many-to-one association to DivisionAdminDivisionMapping
	@OneToMany
	@JoinColumn(name="division_id")
	private Set<DivisionAdminDivisionMapping> divisionAdminDivisionMappings;

	public Division() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNpoEmailId() {
		return this.npoEmailId;
	}

	public void setNpoEmailId(String npoEmailId) {
		this.npoEmailId = npoEmailId;
	}

	public String getNpoMobileNumber() {
		return this.npoMobileNumber;
	}

	public void setNpoMobileNumber(String npoMobileNumber) {
		this.npoMobileNumber = npoMobileNumber;
	}

	public String getNpoName() {
		return this.npoName;
	}

	public void setNpoName(String npoName) {
		this.npoName = npoName;
	}

	public String getSccEmailId() {
		return this.sccEmailId;
	}

	public void setSccEmailId(String sccEmailId) {
		this.sccEmailId = sccEmailId;
	}

	public String getSccMobileNumber() {
		return this.sccMobileNumber;
	}

	public void setSccMobileNumber(String sccMobileNumber) {
		this.sccMobileNumber = sccMobileNumber;
	}

	public String getSccName() {
		return this.sccName;
	}

	public void setSccName(String sccName) {
		this.sccName = sccName;
	}

	public Set<Facility> getFacilities() {
		return this.facilities;
	}

	public void setFacilities(Set<Facility> facilities) {
		this.facilities = facilities;
	}

	public Facility addFacility(Facility facility) {
		getFacilities().add(facility);
		facility.setDivision(this);

		return facility;
	}

	public Facility removeFacility(Facility facility) {
		getFacilities().remove(facility);
		facility.setDivision(null);

		return facility;
	}

	public Set<FacilityTypeDivisionMapping> getFacilityTypeDivisionMappings() {
		return this.facilityTypeDivisionMappings;
	}

	public void setFacilityTypeDivisionMappings(Set<FacilityTypeDivisionMapping> facilityTypeDivisionMappings) {
		this.facilityTypeDivisionMappings = facilityTypeDivisionMappings;
	}

	public FacilityTypeDivisionMapping addFacilityTypeDivisionMapping(
			FacilityTypeDivisionMapping facilityTypeDivisionMapping) {
		getFacilityTypeDivisionMappings().add(facilityTypeDivisionMapping);
		facilityTypeDivisionMapping.setDivision(this);

		return facilityTypeDivisionMapping;
	}

	public FacilityTypeDivisionMapping removeFacilityTypeDivisionMapping(
			FacilityTypeDivisionMapping facilityTypeDivisionMapping) {
		getFacilityTypeDivisionMappings().remove(facilityTypeDivisionMapping);
		facilityTypeDivisionMapping.setDivision(null);

		return facilityTypeDivisionMapping;
	}

	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setDivision(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setDivision(null);

		return product;
	}

	public Set<UserMaster> getUserMasters() {
		return this.userMasters;
	}

	public void setUserMasters(Set<UserMaster> userMasters) {
		this.userMasters = userMasters;
	}

	public UserMaster addUserMaster(UserMaster userMaster) {
		getUserMasters().add(userMaster);
		userMaster.setDivision(this);

		return userMaster;
	}

	public UserMaster removeUserMaster(UserMaster userMaster) {
		getUserMasters().remove(userMaster);
		userMaster.setDivision(null);

		return userMaster;
	}

	public Set<DivisionAdminDivisionMapping> getDivisionAdminDivisionMappings() {
		return divisionAdminDivisionMappings;
	}

	public void setDivisionAdminDivisionMappings(Set<DivisionAdminDivisionMapping> divisionAdminDivisionMappings) {
		this.divisionAdminDivisionMappings = divisionAdminDivisionMappings;
	}

}