package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AddressReadOnly.class)
public abstract class AddressReadOnly_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<AddressReadOnly, String> country;
	public static volatile SingularAttribute<AddressReadOnly, String> pincode;
	public static volatile SingularAttribute<AddressReadOnly, String> addressLineTwo;
	public static volatile SingularAttribute<AddressReadOnly, TownReadOnly> town;
	public static volatile SingularAttribute<AddressReadOnly, String> city;
	public static volatile SingularAttribute<AddressReadOnly, Boolean> isDelete;
	public static volatile SingularAttribute<AddressReadOnly, SubDistrictReadOnly> subdistrict;
	public static volatile SingularAttribute<AddressReadOnly, DistrictReadOnly> district;
	public static volatile SingularAttribute<AddressReadOnly, String> addressLineOne;
	public static volatile SingularAttribute<AddressReadOnly, Long> id;
	public static volatile SingularAttribute<AddressReadOnly, StateReadOnly> state;
	public static volatile SingularAttribute<AddressReadOnly, Boolean> isActive;

	public static final String COUNTRY = "country";
	public static final String PINCODE = "pincode";
	public static final String ADDRESS_LINE_TWO = "addressLineTwo";
	public static final String TOWN = "town";
	public static final String CITY = "city";
	public static final String IS_DELETE = "isDelete";
	public static final String SUBDISTRICT = "subdistrict";
	public static final String DISTRICT = "district";
	public static final String ADDRESS_LINE_ONE = "addressLineOne";
	public static final String ID = "id";
	public static final String STATE = "state";
	public static final String IS_ACTIVE = "isActive";

}

