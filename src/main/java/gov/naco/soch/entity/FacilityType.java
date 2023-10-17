package gov.naco.soch.entity;

import java.io.Serializable;
import java.util.Set;

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
 * The persistent class for the facility_type database table.
 * 
 */
@GenericGenerator(name = "facilityTypeSequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "facility_type_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "facility_type")
@NamedQuery(name = "FacilityType.findAll", query = "SELECT f FROM FacilityType f")
public class FacilityType extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( generator = "facilityTypeSequence")
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(name = "facility_type_name", length = 99)
	private String facilityTypeName;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;
	
	@Column(name="description")
	private String description;

	// bi-directional many-to-one association to Facility
	@OneToMany(mappedBy = "facilityType")
	private Set<Facility> facilities;

	// bi-directional many-to-one association to FacilityTypeDivisionMapping
	@OneToMany(mappedBy = "facilityType")
	private Set<FacilityTypeDivisionMapping> facilityTypeDivisionMappings;

	// bi-directional many-to-one association to Role
	@OneToMany(mappedBy = "facilityType", fetch = FetchType.EAGER)
	private Set<Role> roles;

	// bi-directional many-to-one association to UserMaster
	@OneToMany(mappedBy = "facilityType")
	private Set<UserMaster> userMasters;

	// bi-directional many-to-one association to FacilitySetting
//	@OneToMany(mappedBy = "facilityType")
//	private Set<FacilitySetting> facilitySettings;
	
	@OneToMany(mappedBy = "sourceFacilityType")
	private Set<BeneficiaryPrivateTransfers> beneficiaryPrivateTransfers;

	// bi-directional many-to-one association to DesignationFacilityTypeMapping
	@OneToMany
	@JoinColumn(name = "facility_type_id")
	private Set<DesignationFacilityTypeMapping> designationFacilityTypeMappings;
	
	// bi-directional many-to-one association to ProductFacilityTypeMapping
	@OneToMany
	@JoinColumn(name = "facility_type_id")
	private Set<ProductFacilityTypeMapping> ProductFacilityTypeMappings;

	public FacilityType() {
	}

	public FacilityType(Long benFacFacilityType) {
	   this.id=benFacFacilityType;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFacilityTypeName() {
		return this.facilityTypeName;
	}

	public void setFacilityTypeName(String facilityTypeName) {
		this.facilityTypeName = facilityTypeName;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Set<Facility> getFacilities() {
		return this.facilities;
	}

	public void setFacilities(Set<Facility> facilities) {
		this.facilities = facilities;
	}

	public Facility addFacility(Facility facility) {
		getFacilities().add(facility);
		facility.setFacilityType(this);

		return facility;
	}

	public Facility removeFacility(Facility facility) {
		getFacilities().remove(facility);
		facility.setFacilityType(null);

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
		facilityTypeDivisionMapping.setFacilityType(this);

		return facilityTypeDivisionMapping;
	}

	public FacilityTypeDivisionMapping removeFacilityTypeDivisionMapping(
			FacilityTypeDivisionMapping facilityTypeDivisionMapping) {
		getFacilityTypeDivisionMappings().remove(facilityTypeDivisionMapping);
		facilityTypeDivisionMapping.setFacilityType(null);

		return facilityTypeDivisionMapping;
	}

	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Role addRole(Role role) {
		getRoles().add(role);
		role.setFacilityType(this);

		return role;
	}

	public Role removeRole(Role role) {
		getRoles().remove(role);
		role.setFacilityType(null);

		return role;
	}

	public Set<UserMaster> getUserMasters() {
		return this.userMasters;
	}

	public void setUserMasters(Set<UserMaster> userMasters) {
		this.userMasters = userMasters;
	}

	public UserMaster addUserMaster(UserMaster userMaster) {
		getUserMasters().add(userMaster);
		userMaster.setFacilityType(this);

		return userMaster;
	}

	public UserMaster removeUserMaster(UserMaster userMaster) {
		getUserMasters().remove(userMaster);
		userMaster.setDivision(null);

		return userMaster;
	}

//	public Set<FacilitySetting> getFacilitySettings() {
//		return this.facilitySettings;
//	}

//	public void setFacilitySettings(Set<FacilitySetting> facilitySettings) {
//		this.facilitySettings = facilitySettings;
//	}

//	public FacilitySetting addFacilitySetting(FacilitySetting facilitySetting) {
//		getFacilitySettings().add(facilitySetting);
//		facilitySetting.setFacilityType(this);
//
//		return facilitySetting;
//	}

//	public FacilitySetting removeFacilitySetting(FacilitySetting facilitySetting) {
//		getFacilitySettings().remove(facilitySetting);
//		facilitySetting.setFacilityType(null);
//
//		return facilitySetting;
//	}

	public Set<DesignationFacilityTypeMapping> getDesignationFacilityTypeMappings() {
		return designationFacilityTypeMappings;
	}

	public void setDesignationFacilityTypeMappings(
			Set<DesignationFacilityTypeMapping> designationFacilityTypeMappings) {
		this.designationFacilityTypeMappings = designationFacilityTypeMappings;
	}

	public Set<ProductFacilityTypeMapping> getProductFacilityTypeMappings() {
		return ProductFacilityTypeMappings;
	}

	public void setProductFacilityTypeMappings(Set<ProductFacilityTypeMapping> productFacilityTypeMappings) {
		ProductFacilityTypeMappings = productFacilityTypeMappings;
	}

	public Set<BeneficiaryPrivateTransfers> getBeneficiaryPrivateTransfers() {
		return beneficiaryPrivateTransfers;
	}

	public void setBeneficiaryPrivateTransfers(Set<BeneficiaryPrivateTransfers> beneficiaryPrivateTransfers) {
		this.beneficiaryPrivateTransfers = beneficiaryPrivateTransfers;
	}

}