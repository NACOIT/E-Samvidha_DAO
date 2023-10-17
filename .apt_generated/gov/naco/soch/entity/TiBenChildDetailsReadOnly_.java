package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TiBenChildDetailsReadOnly.class)
public abstract class TiBenChildDetailsReadOnly_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<TiBenChildDetailsReadOnly, Long> facilityId;
	public static volatile SingularAttribute<TiBenChildDetailsReadOnly, TiBeneficiaryReadOnly> beneficiary;
	public static volatile SingularAttribute<TiBenChildDetailsReadOnly, Boolean> isDelete;
	public static volatile SingularAttribute<TiBenChildDetailsReadOnly, MasterGender> genderId;
	public static volatile SingularAttribute<TiBenChildDetailsReadOnly, Long> id;
	public static volatile SingularAttribute<TiBenChildDetailsReadOnly, Boolean> isActive;
	public static volatile SingularAttribute<TiBenChildDetailsReadOnly, Integer> age;

	public static final String FACILITY_ID = "facilityId";
	public static final String BENEFICIARY = "beneficiary";
	public static final String IS_DELETE = "isDelete";
	public static final String GENDER_ID = "genderId";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String AGE = "age";

}

