package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Address.class)
public abstract class Address_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<Address, String> country;
	public static volatile SingularAttribute<Address, String> pincode;
	public static volatile SingularAttribute<Address, String> address;
	public static volatile SingularAttribute<Address, Town> town;
	public static volatile SingularAttribute<Address, String> city;
	public static volatile SingularAttribute<Address, String> taluk;
	public static volatile SingularAttribute<Address, Boolean> isDelete;
	public static volatile SingularAttribute<Address, String> addressLineOne;
	public static volatile SingularAttribute<Address, Boolean> isActive;
	public static volatile SingularAttribute<Address, String> geoLongitude;
	public static volatile SingularAttribute<Address, Pincode> pincodeEntity;
	public static volatile SingularAttribute<Address, String> addressLineTwo;
	public static volatile SingularAttribute<Address, String> geoLatitude;
	public static volatile SingularAttribute<Address, Subdistrict> subdistrict;
	public static volatile SingularAttribute<Address, District> district;
	public static volatile SingularAttribute<Address, Integer> houseNo;
	public static volatile SingularAttribute<Address, String> block;
	public static volatile SingularAttribute<Address, Long> id;
	public static volatile SingularAttribute<Address, State> state;
	public static volatile SetAttribute<Address, Facility> facilities;
	public static volatile SetAttribute<Address, Beneficiary> beneficiaries;

	public static final String COUNTRY = "country";
	public static final String PINCODE = "pincode";
	public static final String ADDRESS = "address";
	public static final String TOWN = "town";
	public static final String CITY = "city";
	public static final String TALUK = "taluk";
	public static final String IS_DELETE = "isDelete";
	public static final String ADDRESS_LINE_ONE = "addressLineOne";
	public static final String IS_ACTIVE = "isActive";
	public static final String GEO_LONGITUDE = "geoLongitude";
	public static final String PINCODE_ENTITY = "pincodeEntity";
	public static final String ADDRESS_LINE_TWO = "addressLineTwo";
	public static final String GEO_LATITUDE = "geoLatitude";
	public static final String SUBDISTRICT = "subdistrict";
	public static final String DISTRICT = "district";
	public static final String HOUSE_NO = "houseNo";
	public static final String BLOCK = "block";
	public static final String ID = "id";
	public static final String STATE = "state";
	public static final String FACILITIES = "facilities";
	public static final String BENEFICIARIES = "beneficiaries";

}

