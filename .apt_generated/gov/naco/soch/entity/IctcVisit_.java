package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(IctcVisit.class)
public abstract class IctcVisit_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<IctcVisit, Long> beneficiaryStatus;
	public static volatile SingularAttribute<IctcVisit, LocalDate> cptInitiationDate;
	public static volatile SingularAttribute<IctcVisit, LocalDate> pregnancyLmpDate;
	public static volatile SingularAttribute<IctcVisit, Long> transmissionRoute;
	public static volatile SingularAttribute<IctcVisit, LocalDate> expectedDeliveryDate;
	public static volatile SingularAttribute<IctcVisit, Boolean> hasStiRtiSymptoms;
	public static volatile SingularAttribute<IctcVisit, Boolean> isActive;
	public static volatile SingularAttribute<IctcVisit, IctcBeneficiary> ictcBeneficiary;
	public static volatile SingularAttribute<IctcVisit, Boolean> isRPQCaptured;
	public static volatile SingularAttribute<IctcVisit, Boolean> hasTbSymptoms;
	public static volatile SingularAttribute<IctcVisit, Boolean> isDeleted;
	public static volatile SingularAttribute<IctcVisit, Long> arvProphylaxis;
	public static volatile SingularAttribute<IctcVisit, Long> deliveryOutcome;
	public static volatile SingularAttribute<IctcVisit, Long> rpqSurveyId;
	public static volatile SingularAttribute<IctcVisit, Long> infantBreastFed;
	public static volatile SingularAttribute<IctcVisit, LocalDate> visitDate;
	public static volatile SingularAttribute<IctcVisit, Long> pregnancyType;
	public static volatile SingularAttribute<IctcVisit, Long> id;
	public static volatile SingularAttribute<IctcVisit, LocalDate> deliveryDate;
	public static volatile SingularAttribute<IctcVisit, Boolean> isPregnant;
	public static volatile SingularAttribute<IctcVisit, Facility> facility;
	public static volatile SingularAttribute<IctcVisit, Long> monthOfPregnancy;
	public static volatile SingularAttribute<IctcVisit, Long> gravida;

	public static final String BENEFICIARY_STATUS = "beneficiaryStatus";
	public static final String CPT_INITIATION_DATE = "cptInitiationDate";
	public static final String PREGNANCY_LMP_DATE = "pregnancyLmpDate";
	public static final String TRANSMISSION_ROUTE = "transmissionRoute";
	public static final String EXPECTED_DELIVERY_DATE = "expectedDeliveryDate";
	public static final String HAS_STI_RTI_SYMPTOMS = "hasStiRtiSymptoms";
	public static final String IS_ACTIVE = "isActive";
	public static final String ICTC_BENEFICIARY = "ictcBeneficiary";
	public static final String IS_RP_QCAPTURED = "isRPQCaptured";
	public static final String HAS_TB_SYMPTOMS = "hasTbSymptoms";
	public static final String IS_DELETED = "isDeleted";
	public static final String ARV_PROPHYLAXIS = "arvProphylaxis";
	public static final String DELIVERY_OUTCOME = "deliveryOutcome";
	public static final String RPQ_SURVEY_ID = "rpqSurveyId";
	public static final String INFANT_BREAST_FED = "infantBreastFed";
	public static final String VISIT_DATE = "visitDate";
	public static final String PREGNANCY_TYPE = "pregnancyType";
	public static final String ID = "id";
	public static final String DELIVERY_DATE = "deliveryDate";
	public static final String IS_PREGNANT = "isPregnant";
	public static final String FACILITY = "facility";
	public static final String MONTH_OF_PREGNANCY = "monthOfPregnancy";
	public static final String GRAVIDA = "gravida";

}

