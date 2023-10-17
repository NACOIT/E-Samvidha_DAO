package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DashboardIndicatorEstimateDetails.class)
public abstract class DashboardIndicatorEstimateDetails_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<DashboardIndicatorEstimateDetails, MasterDashboardIndicator> dashboardIndicatorId;
	public static volatile SingularAttribute<DashboardIndicatorEstimateDetails, Long> estimateValue;
	public static volatile SingularAttribute<DashboardIndicatorEstimateDetails, Boolean> isDelete;
	public static volatile SingularAttribute<DashboardIndicatorEstimateDetails, State> stateId;
	public static volatile SingularAttribute<DashboardIndicatorEstimateDetails, Long> highRange;
	public static volatile SingularAttribute<DashboardIndicatorEstimateDetails, Boolean> isActive;
	public static volatile SingularAttribute<DashboardIndicatorEstimateDetails, MasterDashboardGender> dashboardGenderId;
	public static volatile SingularAttribute<DashboardIndicatorEstimateDetails, String> reportedYear;
	public static volatile SingularAttribute<DashboardIndicatorEstimateDetails, MasterAgeGroup> ageGroupId;
	public static volatile SingularAttribute<DashboardIndicatorEstimateDetails, District> districtId;
	public static volatile SingularAttribute<DashboardIndicatorEstimateDetails, MasterDashboardGeographicalLevel> dashboardGeographicalLevelId;
	public static volatile SingularAttribute<DashboardIndicatorEstimateDetails, Long> id;
	public static volatile SingularAttribute<DashboardIndicatorEstimateDetails, String> countryName;
	public static volatile SingularAttribute<DashboardIndicatorEstimateDetails, MasterDashboardTypology> dashboardtypologyId;
	public static volatile SingularAttribute<DashboardIndicatorEstimateDetails, Long> lowRange;

	public static final String DASHBOARD_INDICATOR_ID = "dashboardIndicatorId";
	public static final String ESTIMATE_VALUE = "estimateValue";
	public static final String IS_DELETE = "isDelete";
	public static final String STATE_ID = "stateId";
	public static final String HIGH_RANGE = "highRange";
	public static final String IS_ACTIVE = "isActive";
	public static final String DASHBOARD_GENDER_ID = "dashboardGenderId";
	public static final String REPORTED_YEAR = "reportedYear";
	public static final String AGE_GROUP_ID = "ageGroupId";
	public static final String DISTRICT_ID = "districtId";
	public static final String DASHBOARD_GEOGRAPHICAL_LEVEL_ID = "dashboardGeographicalLevelId";
	public static final String ID = "id";
	public static final String COUNTRY_NAME = "countryName";
	public static final String DASHBOARDTYPOLOGY_ID = "dashboardtypologyId";
	public static final String LOW_RANGE = "lowRange";

}

