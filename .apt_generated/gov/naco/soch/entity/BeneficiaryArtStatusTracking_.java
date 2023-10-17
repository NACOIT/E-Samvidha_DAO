package gov.naco.soch.entity;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BeneficiaryArtStatusTracking.class)
public abstract class BeneficiaryArtStatusTracking_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<BeneficiaryArtStatusTracking, LocalDateTime> statusDate;
	public static volatile SingularAttribute<BeneficiaryArtStatusTracking, Beneficiary> beneficiary;
	public static volatile SingularAttribute<BeneficiaryArtStatusTracking, Boolean> isDelete;
	public static volatile SingularAttribute<BeneficiaryArtStatusTracking, MasterArtBeneficiaryStatus> previousArtBeneficiaryStatus;
	public static volatile SingularAttribute<BeneficiaryArtStatusTracking, Long> id;
	public static volatile SingularAttribute<BeneficiaryArtStatusTracking, Boolean> isActive;
	public static volatile SingularAttribute<BeneficiaryArtStatusTracking, Facility> facility;
	public static volatile SingularAttribute<BeneficiaryArtStatusTracking, MasterArtBeneficiaryStatus> currentArtBeneficiaryStatus;
	public static volatile SingularAttribute<BeneficiaryArtStatusTracking, Long> statusChangedBy;

	public static final String STATUS_DATE = "statusDate";
	public static final String BENEFICIARY = "beneficiary";
	public static final String IS_DELETE = "isDelete";
	public static final String PREVIOUS_ART_BENEFICIARY_STATUS = "previousArtBeneficiaryStatus";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY = "facility";
	public static final String CURRENT_ART_BENEFICIARY_STATUS = "currentArtBeneficiaryStatus";
	public static final String STATUS_CHANGED_BY = "statusChangedBy";

}

