package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TiProfileUpdate.class)
public abstract class TiProfileUpdate_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<TiProfileUpdate, Long> facilityId;
	public static volatile SingularAttribute<TiProfileUpdate, Integer> peSanctioned;
	public static volatile SingularAttribute<TiProfileUpdate, Integer> newStaffRecruit;
	public static volatile SingularAttribute<TiProfileUpdate, Integer> year;
	public static volatile SingularAttribute<TiProfileUpdate, Boolean> isDelete;
	public static volatile SingularAttribute<TiProfileUpdate, Integer> peTotal;
	public static volatile SingularAttribute<TiProfileUpdate, Integer> committees;
	public static volatile SingularAttribute<TiProfileUpdate, Boolean> isActive;
	public static volatile SingularAttribute<TiProfileUpdate, Integer> month;
	public static volatile SingularAttribute<TiProfileUpdate, Integer> advocacy;
	public static volatile SingularAttribute<TiProfileUpdate, Integer> otherStaffVacant;
	public static volatile SingularAttribute<TiProfileUpdate, Integer> orwSanctioned;
	public static volatile SingularAttribute<TiProfileUpdate, Long> id;
	public static volatile SingularAttribute<TiProfileUpdate, Integer> violenceReported;
	public static volatile SingularAttribute<TiProfileUpdate, Integer> orwTotal;

	public static final String FACILITY_ID = "facilityId";
	public static final String PE_SANCTIONED = "peSanctioned";
	public static final String NEW_STAFF_RECRUIT = "newStaffRecruit";
	public static final String YEAR = "year";
	public static final String IS_DELETE = "isDelete";
	public static final String PE_TOTAL = "peTotal";
	public static final String COMMITTEES = "committees";
	public static final String IS_ACTIVE = "isActive";
	public static final String MONTH = "month";
	public static final String ADVOCACY = "advocacy";
	public static final String OTHER_STAFF_VACANT = "otherStaffVacant";
	public static final String ORW_SANCTIONED = "orwSanctioned";
	public static final String ID = "id";
	public static final String VIOLENCE_REPORTED = "violenceReported";
	public static final String ORW_TOTAL = "orwTotal";

}

