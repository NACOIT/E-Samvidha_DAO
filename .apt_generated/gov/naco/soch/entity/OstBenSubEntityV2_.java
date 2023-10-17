package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OstBenSubEntityV2.class)
public abstract class OstBenSubEntityV2_ {

	public static volatile SetAttribute<OstBenSubEntityV2, OstPrescriptionV2FollowUp> tiOstPrescriptions;
	public static volatile SingularAttribute<OstBenSubEntityV2, Long> facilityId;
	public static volatile SingularAttribute<OstBenSubEntityV2, MasterBenSubEntity> beneficiary;
	public static volatile SingularAttribute<OstBenSubEntityV2, String> ostNumber;
	public static volatile SingularAttribute<OstBenSubEntityV2, MasterBeneficiaryOstStatus> ostStatus;
	public static volatile SingularAttribute<OstBenSubEntityV2, Long> id;
	public static volatile SingularAttribute<OstBenSubEntityV2, String> ostCode;
	public static volatile SingularAttribute<OstBenSubEntityV2, MasterOstClientStatus> status;
	public static volatile SetAttribute<OstBenSubEntityV2, OstAssessmentV2> ostAssess;

	public static final String TI_OST_PRESCRIPTIONS = "tiOstPrescriptions";
	public static final String FACILITY_ID = "facilityId";
	public static final String BENEFICIARY = "beneficiary";
	public static final String OST_NUMBER = "ostNumber";
	public static final String OST_STATUS = "ostStatus";
	public static final String ID = "id";
	public static final String OST_CODE = "ostCode";
	public static final String STATUS = "status";
	public static final String OST_ASSESS = "ostAssess";

}

