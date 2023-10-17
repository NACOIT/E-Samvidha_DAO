package gov.naco.soch.entity;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BeneficiaryIctcStatusTracking.class)
public abstract class BeneficiaryIctcStatusTracking_ {

	public static volatile SingularAttribute<BeneficiaryIctcStatusTracking, LocalDateTime> modifiedTime;
	public static volatile SingularAttribute<BeneficiaryIctcStatusTracking, Long> facilityId;
	public static volatile SingularAttribute<BeneficiaryIctcStatusTracking, Integer> previousIctcBeneficiaryStatusId;
	public static volatile SingularAttribute<BeneficiaryIctcStatusTracking, LocalDateTime> statusChangedDate;
	public static volatile SingularAttribute<BeneficiaryIctcStatusTracking, Boolean> isActive;
	public static volatile SingularAttribute<BeneficiaryIctcStatusTracking, Boolean> isDeleted;
	public static volatile SingularAttribute<BeneficiaryIctcStatusTracking, Integer> createdBy;
	public static volatile SingularAttribute<BeneficiaryIctcStatusTracking, Integer> currentIctcBeneficiaryStatusId;
	public static volatile SingularAttribute<BeneficiaryIctcStatusTracking, LocalDateTime> createdTime;
	public static volatile SingularAttribute<BeneficiaryIctcStatusTracking, Integer> modifiedBy;
	public static volatile SingularAttribute<BeneficiaryIctcStatusTracking, Long> id;
	public static volatile SingularAttribute<BeneficiaryIctcStatusTracking, Integer> statusChangedBy;
	public static volatile SingularAttribute<BeneficiaryIctcStatusTracking, Long> beneficiaryId;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String FACILITY_ID = "facilityId";
	public static final String PREVIOUS_ICTC_BENEFICIARY_STATUS_ID = "previousIctcBeneficiaryStatusId";
	public static final String STATUS_CHANGED_DATE = "statusChangedDate";
	public static final String IS_ACTIVE = "isActive";
	public static final String IS_DELETED = "isDeleted";
	public static final String CREATED_BY = "createdBy";
	public static final String CURRENT_ICTC_BENEFICIARY_STATUS_ID = "currentIctcBeneficiaryStatusId";
	public static final String CREATED_TIME = "createdTime";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String STATUS_CHANGED_BY = "statusChangedBy";
	public static final String BENEFICIARY_ID = "beneficiaryId";

}

