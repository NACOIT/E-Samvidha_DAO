package gov.naco.soch.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


/**
 * The persistent class for the address database table.
 * 
 */
@GenericGenerator(name = "addressSequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "address_id_seq"), 
		@Parameter(name = "initial_value", value = "1"),
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "addressSequence")
	@Column(unique = true, nullable = false)
	private Long id;

	private String address;

	@Column(name="address_line_one")
	private String addressLineOne;

	@Column(name="address_line_two")
	private String addressLineTwo;

	private String block;

	private String city;

	private String country;

	@Column(name="geo_latitude")
	private String geoLatitude;

	@Column(name="geo_longitude")
	private String geoLongitude;

	@Column(name="house_no")
	private Integer houseNo;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	private String taluk;

	//bi-directional many-to-one association to District
	@ManyToOne(fetch = FetchType.LAZY)
	private District district;

	@Column(name="pincode")
	private String pincode;

	//bi-directional many-to-one association to Pincode
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="pincode_id")
	private Pincode pincodeEntity;

	//bi-directional many-to-one association to State
	@ManyToOne(fetch = FetchType.LAZY)
	private State state;

	//bi-directional many-to-one association to Subdistrict
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="subdistrict_id")
	private Subdistrict subdistrict;

	//bi-directional many-to-one association to Town
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="town_id")
	private Town town;

	//bi-directional many-to-one association to Beneficiary
	@OneToMany(mappedBy="address")
	private Set<Beneficiary> beneficiaries;

	//bi-directional many-to-one association to Facility
	@OneToMany(mappedBy="address")
	private Set<Facility> facilities;

	public Address() {
	}

	public Address(Long addressId, String addLineOne, String addLineTwo, Long stateId, String stateName,
		Long districtId, String districtName, Long subDistrictId, String subDistrictName, Long townId,
		String townName, String pincode2) {
	  this.id=addressId;
	  this.addressLineOne=addLineOne;
	  this.addressLineTwo=addLineTwo;
	  this.state=new State(stateId,stateName);
	  this.district=new District(districtId,districtName);
	  this.subdistrict=new Subdistrict(subDistrictId,subDistrictName);
	  this.town=new Town(townId,townName);
	  this.pincode=pincode2;
	  
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressLineOne() {
		return this.addressLineOne;
	}

	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	public String getAddressLineTwo() {
		return this.addressLineTwo;
	}

	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}

	public String getBlock() {
		return this.block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getGeoLatitude() {
		return this.geoLatitude;
	}

	public void setGeoLatitude(String geoLatitude) {
		this.geoLatitude = geoLatitude;
	}

	public String getGeoLongitude() {
		return this.geoLongitude;
	}

	public void setGeoLongitude(String geoLongitude) {
		this.geoLongitude = geoLongitude;
	}

	public Integer getHouseNo() {
		return this.houseNo;
	}

	public void setHouseNo(Integer houseNo) {
		this.houseNo = houseNo;
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

	
	public String getTaluk() {
		return this.taluk;
	}

	public void setTaluk(String taluk) {
		this.taluk = taluk;
	}

	public District getDistrict() {
		return this.district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	

	public Pincode getPincodeEntity() {
		return pincodeEntity;
	}

	public void setPincodeEntity(Pincode pincodeEntity) {
		this.pincodeEntity = pincodeEntity;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Subdistrict getSubdistrict() {
		return this.subdistrict;
	}

	public void setSubdistrict(Subdistrict subdistrict) {
		this.subdistrict = subdistrict;
	}

	public Town getTown() {
		return this.town;
	}

	public void setTown(Town town) {
		this.town = town;
	}

	public Set<Beneficiary> getBeneficiaries() {
		return this.beneficiaries;
	}

	public void setBeneficiaries(Set<Beneficiary> beneficiaries) {
		this.beneficiaries = beneficiaries;
	}

	public Beneficiary addBeneficiary(Beneficiary beneficiary) {
		getBeneficiaries().add(beneficiary);
		beneficiary.setAddress(this);

		return beneficiary;
	}

	public Beneficiary removeBeneficiary(Beneficiary beneficiary) {
		getBeneficiaries().remove(beneficiary);
		beneficiary.setAddress(null);

		return beneficiary;
	}

	public Set<Facility> getFacilities() {
		return this.facilities;
	}

	public void setFacilities(Set<Facility> facilities) {
		this.facilities = facilities;
	}

	public Facility addFacility(Facility facility) {
		getFacilities().add(facility);
		facility.setAddress(this);

		return facility;
	}

	public Facility removeFacility(Facility facility) {
		getFacilities().remove(facility);
		facility.setAddress(null);

		return facility;
	}

}