package gov.naco.soch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Parameter;


/**
 * The persistent class for the address database table.
 * 
 */
@GenericGenerator(name = "addresSequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "address_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name="address")
@Immutable
public class AddressReadOnly extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "addresSequence")
	@Column(unique = true, nullable = false)
	private Long id;


	@Column(name="address_line_one")
	private String addressLineOne;

	@Column(name="address_line_two")
	private String addressLineTwo;

	private String country;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	//bi-directional many-to-one association to District
	@ManyToOne
	private DistrictReadOnly district;

	@Column(name="pincode")
	private String pincode;

	//bi-directional many-to-one association to State
	@ManyToOne
	private StateReadOnly state;

	//bi-directional many-to-one association to Subdistrict
	@ManyToOne
	@JoinColumn(name="subdistrict_id")
	private SubDistrictReadOnly subdistrict;

	//bi-directional many-to-one association to Town
	@ManyToOne
	@JoinColumn(name="town_id")
	private TownReadOnly  town;
	
	private String city;


	public AddressReadOnly() {
	}


	public Long getId() {
	    return id;
	}


	public void setId(Long id) {
	    this.id = id;
	}


	public String getAddressLineOne() {
	    return addressLineOne;
	}


	public void setAddressLineOne(String addressLineOne) {
	    this.addressLineOne = addressLineOne;
	}


	public String getAddressLineTwo() {
	    return addressLineTwo;
	}


	public void setAddressLineTwo(String addressLineTwo) {
	    this.addressLineTwo = addressLineTwo;
	}


	public String getCountry() {
	    return country;
	}


	public void setCountry(String country) {
	    this.country = country;
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


	public DistrictReadOnly getDistrict() {
	    return district;
	}


	public void setDistrict(DistrictReadOnly district) {
	    this.district = district;
	}


	public String getPincode() {
	    return pincode;
	}


	public void setPincode(String pincode) {
	    this.pincode = pincode;
	}


	public StateReadOnly getState() {
	    return state;
	}


	public void setState(StateReadOnly state) {
	    this.state = state;
	}


	public SubDistrictReadOnly getSubdistrict() {
	    return subdistrict;
	}


	public void setSubdistrict(SubDistrictReadOnly subdistrict) {
	    this.subdistrict = subdistrict;
	}


	public TownReadOnly getTown() {
	    return town;
	}


	public void setTown(TownReadOnly town) {
	    this.town = town;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}
}