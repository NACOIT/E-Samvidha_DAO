package gov.naco.soch.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(NgoReleasedAmtEntity.class)
public abstract class NgoReleasedAmtEntity_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<NgoReleasedAmtEntity, String> financialYear;
	public static volatile SingularAttribute<NgoReleasedAmtEntity, Long> facilityId;
	public static volatile SingularAttribute<NgoReleasedAmtEntity, Date> releaseDate;
	public static volatile SingularAttribute<NgoReleasedAmtEntity, Boolean> isDelete;
	public static volatile SingularAttribute<NgoReleasedAmtEntity, Long> id;
	public static volatile SingularAttribute<NgoReleasedAmtEntity, Boolean> isActive;
	public static volatile SingularAttribute<NgoReleasedAmtEntity, Long> projectId;
	public static volatile SingularAttribute<NgoReleasedAmtEntity, String> releasedAmount;
	public static volatile SingularAttribute<NgoReleasedAmtEntity, String> remarks;
	public static volatile SingularAttribute<NgoReleasedAmtEntity, Integer> status;

	public static final String FINANCIAL_YEAR = "financialYear";
	public static final String FACILITY_ID = "facilityId";
	public static final String RELEASE_DATE = "releaseDate";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String PROJECT_ID = "projectId";
	public static final String RELEASED_AMOUNT = "releasedAmount";
	public static final String REMARKS = "remarks";
	public static final String STATUS = "status";

}

