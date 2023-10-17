package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OstBenSubEntityV2Assessment.class)
public abstract class OstBenSubEntityV2Assessment_ {

	public static volatile SingularAttribute<OstBenSubEntityV2Assessment, MasterBenSubV2Assessment> beneficiary;
	public static volatile SingularAttribute<OstBenSubEntityV2Assessment, String> ostNumber;
	public static volatile SingularAttribute<OstBenSubEntityV2Assessment, MasterBeneficiaryOstStatus> ostStatus;
	public static volatile SingularAttribute<OstBenSubEntityV2Assessment, Long> id;
	public static volatile SingularAttribute<OstBenSubEntityV2Assessment, String> ostCode;
	public static volatile SingularAttribute<OstBenSubEntityV2Assessment, MasterOstClientStatus> status;
	public static volatile SetAttribute<OstBenSubEntityV2Assessment, OstAssessmentV2> ostAssess;

	public static final String BENEFICIARY = "beneficiary";
	public static final String OST_NUMBER = "ostNumber";
	public static final String OST_STATUS = "ostStatus";
	public static final String ID = "id";
	public static final String OST_CODE = "ostCode";
	public static final String STATUS = "status";
	public static final String OST_ASSESS = "ostAssess";

}

