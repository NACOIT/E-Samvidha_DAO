package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TIBenChildDetails.class)
public abstract class TIBenChildDetails_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<TIBenChildDetails, TIBeneficiary> beneficiary;
	public static volatile SingularAttribute<TIBenChildDetails, Boolean> isDelete;
	public static volatile SingularAttribute<TIBenChildDetails, MasterGender> genderId;
	public static volatile SingularAttribute<TIBenChildDetails, Long> id;
	public static volatile SingularAttribute<TIBenChildDetails, Boolean> isActive;
	public static volatile SingularAttribute<TIBenChildDetails, Facility> facility;
	public static volatile SingularAttribute<TIBenChildDetails, Integer> age;

	public static final String BENEFICIARY = "beneficiary";
	public static final String IS_DELETE = "isDelete";
	public static final String GENDER_ID = "genderId";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY = "facility";
	public static final String AGE = "age";

}

