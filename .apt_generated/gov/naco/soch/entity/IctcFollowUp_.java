package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(IctcFollowUp.class)
public abstract class IctcFollowUp_ {

	public static volatile SingularAttribute<IctcFollowUp, LocalDate> modifiedTime;
	public static volatile SingularAttribute<IctcFollowUp, Boolean> isActive;
	public static volatile SingularAttribute<IctcFollowUp, IctcBeneficiary> ictcBeneficiary;
	public static volatile SingularAttribute<IctcFollowUp, LabTestSample> sample;
	public static volatile SingularAttribute<IctcFollowUp, LocalDate> followUpDate;
	public static volatile SingularAttribute<IctcFollowUp, Integer> followUpType;
	public static volatile SingularAttribute<IctcFollowUp, Boolean> isDeleted;
	public static volatile SingularAttribute<IctcFollowUp, Integer> createdBy;
	public static volatile SingularAttribute<IctcFollowUp, LocalDate> createdTime;
	public static volatile SingularAttribute<IctcFollowUp, Integer> modifiedBy;
	public static volatile SingularAttribute<IctcFollowUp, Long> id;
	public static volatile SingularAttribute<IctcFollowUp, IctcVisit> visit;
	public static volatile SingularAttribute<IctcFollowUp, Facility> facility;
	public static volatile SingularAttribute<IctcFollowUp, Boolean> isCompleted;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String IS_ACTIVE = "isActive";
	public static final String ICTC_BENEFICIARY = "ictcBeneficiary";
	public static final String SAMPLE = "sample";
	public static final String FOLLOW_UP_DATE = "followUpDate";
	public static final String FOLLOW_UP_TYPE = "followUpType";
	public static final String IS_DELETED = "isDeleted";
	public static final String CREATED_BY = "createdBy";
	public static final String CREATED_TIME = "createdTime";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String VISIT = "visit";
	public static final String FACILITY = "facility";
	public static final String IS_COMPLETED = "isCompleted";

}

