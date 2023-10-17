package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ArtFollowupList.class)
public abstract class ArtFollowupList_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<ArtFollowupList, Beneficiary> beneficiary;
	public static volatile SingularAttribute<ArtFollowupList, Long> artBeneficiaryStatusIdCaptured;
	public static volatile SingularAttribute<ArtFollowupList, Boolean> isDelete;
	public static volatile SingularAttribute<ArtFollowupList, Integer> monthGenerated;
	public static volatile SingularAttribute<ArtFollowupList, Long> id;
	public static volatile SingularAttribute<ArtFollowupList, Boolean> isActive;
	public static volatile SingularAttribute<ArtFollowupList, Facility> facility;
	public static volatile SingularAttribute<ArtFollowupList, Integer> yearGenerated;

	public static final String BENEFICIARY = "beneficiary";
	public static final String ART_BENEFICIARY_STATUS_ID_CAPTURED = "artBeneficiaryStatusIdCaptured";
	public static final String IS_DELETE = "isDelete";
	public static final String MONTH_GENERATED = "monthGenerated";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY = "facility";
	public static final String YEAR_GENERATED = "yearGenerated";

}

