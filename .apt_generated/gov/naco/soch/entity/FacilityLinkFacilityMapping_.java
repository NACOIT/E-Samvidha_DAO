package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FacilityLinkFacilityMapping.class)
public abstract class FacilityLinkFacilityMapping_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<FacilityLinkFacilityMapping, Facility> linkFacilityId;
	public static volatile SingularAttribute<FacilityLinkFacilityMapping, FacilityType> linkFacilityTypeId;
	public static volatile SingularAttribute<FacilityLinkFacilityMapping, Facility> parentFacilityId;
	public static volatile SingularAttribute<FacilityLinkFacilityMapping, Boolean> isDelete;
	public static volatile SingularAttribute<FacilityLinkFacilityMapping, FacilityType> parentFacilityTypeId;
	public static volatile SingularAttribute<FacilityLinkFacilityMapping, Long> id;
	public static volatile SingularAttribute<FacilityLinkFacilityMapping, Boolean> currentLinkStatus;
	public static volatile SingularAttribute<FacilityLinkFacilityMapping, Boolean> isActive;
	public static volatile SingularAttribute<FacilityLinkFacilityMapping, LocalDate> linkDate;

	public static final String LINK_FACILITY_ID = "linkFacilityId";
	public static final String LINK_FACILITY_TYPE_ID = "linkFacilityTypeId";
	public static final String PARENT_FACILITY_ID = "parentFacilityId";
	public static final String IS_DELETE = "isDelete";
	public static final String PARENT_FACILITY_TYPE_ID = "parentFacilityTypeId";
	public static final String ID = "id";
	public static final String CURRENT_LINK_STATUS = "currentLinkStatus";
	public static final String IS_ACTIVE = "isActive";
	public static final String LINK_DATE = "linkDate";

}

