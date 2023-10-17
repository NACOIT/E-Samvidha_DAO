package gov.naco.soch.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BeneficiaryVisitRegister.class)
public abstract class BeneficiaryVisitRegister_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<BeneficiaryVisitRegister, TIBeneficiary> tiBeneficiary;
	public static volatile SetAttribute<BeneficiaryVisitRegister, ArtBeneficiaryQueue> artBeneficiaryQueues;
	public static volatile SingularAttribute<BeneficiaryVisitRegister, LocalDate> dsrcBeneficiaryStatusDate;
	public static volatile SingularAttribute<BeneficiaryVisitRegister, LocalDateTime> ostClientStatusDate;
	public static volatile SetAttribute<BeneficiaryVisitRegister, ArtDispensation> artDispensations;
	public static volatile SingularAttribute<BeneficiaryVisitRegister, Boolean> isActive;
	public static volatile SingularAttribute<BeneficiaryVisitRegister, LocalDate> lmp;
	public static volatile SingularAttribute<BeneficiaryVisitRegister, MasterOstClientStatus> ostClientStatus;
	public static volatile SingularAttribute<BeneficiaryVisitRegister, String> visitBy;
	public static volatile SingularAttribute<BeneficiaryVisitRegister, TiOstBeneficiary> tiOstBeneficiary;
	public static volatile SingularAttribute<BeneficiaryVisitRegister, MasterDeliveryOutcome> deliveryOutcome;
	public static volatile SingularAttribute<BeneficiaryVisitRegister, LocalDate> visitDate;
	public static volatile SingularAttribute<BeneficiaryVisitRegister, Long> id;
	public static volatile SingularAttribute<BeneficiaryVisitRegister, Boolean> isPregnant;
	public static volatile SingularAttribute<BeneficiaryVisitRegister, Float> height;
	public static volatile SingularAttribute<BeneficiaryVisitRegister, LocalDateTime> ostStatusDate;
	public static volatile SingularAttribute<BeneficiaryVisitRegister, MasterDsrcBeneficiaryStatus> dsrcBeneficiaryStatus;
	public static volatile SingularAttribute<BeneficiaryVisitRegister, LocalDate> edd;
	public static volatile SingularAttribute<BeneficiaryVisitRegister, Boolean> isDelete;
	public static volatile SingularAttribute<BeneficiaryVisitRegister, Float> weight;
	public static volatile SingularAttribute<BeneficiaryVisitRegister, MasterPregnancyTypeCase> masterPregnancyTypeCase;
	public static volatile SingularAttribute<BeneficiaryVisitRegister, MasterTiClientStatus> tiClientStatus;
	public static volatile SetAttribute<BeneficiaryVisitRegister, ArtBeneficiaryCounsellingNotes> artBeneficiaryCounsellingNotes;
	public static volatile SingularAttribute<BeneficiaryVisitRegister, Boolean> foursSymptoms;
	public static volatile SingularAttribute<BeneficiaryVisitRegister, Beneficiary> beneficiary;
	public static volatile SingularAttribute<BeneficiaryVisitRegister, LocalDateTime> tiClientStatusDate;
	public static volatile SingularAttribute<BeneficiaryVisitRegister, MasterBeneficiaryOstStatus> ostStatus;
	public static volatile SingularAttribute<BeneficiaryVisitRegister, Facility> facility;
	public static volatile SingularAttribute<BeneficiaryVisitRegister, String> pregnancyMonth;

	public static final String TI_BENEFICIARY = "tiBeneficiary";
	public static final String ART_BENEFICIARY_QUEUES = "artBeneficiaryQueues";
	public static final String DSRC_BENEFICIARY_STATUS_DATE = "dsrcBeneficiaryStatusDate";
	public static final String OST_CLIENT_STATUS_DATE = "ostClientStatusDate";
	public static final String ART_DISPENSATIONS = "artDispensations";
	public static final String IS_ACTIVE = "isActive";
	public static final String LMP = "lmp";
	public static final String OST_CLIENT_STATUS = "ostClientStatus";
	public static final String VISIT_BY = "visitBy";
	public static final String TI_OST_BENEFICIARY = "tiOstBeneficiary";
	public static final String DELIVERY_OUTCOME = "deliveryOutcome";
	public static final String VISIT_DATE = "visitDate";
	public static final String ID = "id";
	public static final String IS_PREGNANT = "isPregnant";
	public static final String HEIGHT = "height";
	public static final String OST_STATUS_DATE = "ostStatusDate";
	public static final String DSRC_BENEFICIARY_STATUS = "dsrcBeneficiaryStatus";
	public static final String EDD = "edd";
	public static final String IS_DELETE = "isDelete";
	public static final String WEIGHT = "weight";
	public static final String MASTER_PREGNANCY_TYPE_CASE = "masterPregnancyTypeCase";
	public static final String TI_CLIENT_STATUS = "tiClientStatus";
	public static final String ART_BENEFICIARY_COUNSELLING_NOTES = "artBeneficiaryCounsellingNotes";
	public static final String FOURS_SYMPTOMS = "foursSymptoms";
	public static final String BENEFICIARY = "beneficiary";
	public static final String TI_CLIENT_STATUS_DATE = "tiClientStatusDate";
	public static final String OST_STATUS = "ostStatus";
	public static final String FACILITY = "facility";
	public static final String PREGNANCY_MONTH = "pregnancyMonth";

}

