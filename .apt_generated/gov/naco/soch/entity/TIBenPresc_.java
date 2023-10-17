package gov.naco.soch.entity;

import java.time.ZonedDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TIBenPresc.class)
public abstract class TIBenPresc_ {

	public static volatile SingularAttribute<TIBenPresc, Boolean> consentTaken;
	public static volatile SingularAttribute<TIBenPresc, Integer> dosage;
	public static volatile SingularAttribute<TIBenPresc, ZonedDateTime> modifiedTime;
	public static volatile SingularAttribute<TIBenPresc, Integer> facilityId;
	public static volatile SingularAttribute<TIBenPresc, String> measureOfUnit;
	public static volatile SingularAttribute<TIBenPresc, Boolean> isDelete;
	public static volatile SingularAttribute<TIBenPresc, Integer> substitutionDrug;
	public static volatile SingularAttribute<TIBenPresc, Boolean> isActive;
	public static volatile SingularAttribute<TIBenPresc, ZonedDateTime> initiationDate;
	public static volatile SingularAttribute<TIBenPresc, TIBeneficiary> beneficiary;
	public static volatile SingularAttribute<TIBenPresc, Integer> createdBy;
	public static volatile SingularAttribute<TIBenPresc, ZonedDateTime> createdTime;
	public static volatile SingularAttribute<TIBenPresc, Integer> modifiedBy;
	public static volatile SingularAttribute<TIBenPresc, Long> id;

	public static final String CONSENT_TAKEN = "consentTaken";
	public static final String DOSAGE = "dosage";
	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String FACILITY_ID = "facilityId";
	public static final String MEASURE_OF_UNIT = "measureOfUnit";
	public static final String IS_DELETE = "isDelete";
	public static final String SUBSTITUTION_DRUG = "substitutionDrug";
	public static final String IS_ACTIVE = "isActive";
	public static final String INITIATION_DATE = "initiationDate";
	public static final String BENEFICIARY = "beneficiary";
	public static final String CREATED_BY = "createdBy";
	public static final String CREATED_TIME = "createdTime";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";

}

