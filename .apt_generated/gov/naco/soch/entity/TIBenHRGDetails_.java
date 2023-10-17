package gov.naco.soch.entity;

import java.time.ZonedDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TIBenHRGDetails.class)
public abstract class TIBenHRGDetails_ {

	public static volatile SingularAttribute<TIBenHRGDetails, ZonedDateTime> modifiedTime;
	public static volatile SingularAttribute<TIBenHRGDetails, String> hrgSecondaryCategory;
	public static volatile SingularAttribute<TIBenHRGDetails, String> subCategory;
	public static volatile SingularAttribute<TIBenHRGDetails, String> hrgPrimaryCategory;
	public static volatile SingularAttribute<TIBenHRGDetails, Integer> avgNoSexualActsUponReg;
	public static volatile SingularAttribute<TIBenHRGDetails, Boolean> consumeAlcohol;
	public static volatile SingularAttribute<TIBenHRGDetails, TIBeneficiary> beneficiary;
	public static volatile SingularAttribute<TIBenHRGDetails, Integer> createdBy;
	public static volatile SingularAttribute<TIBenHRGDetails, Integer> noYearsInSexWork;
	public static volatile SingularAttribute<TIBenHRGDetails, ZonedDateTime> createdTime;
	public static volatile SingularAttribute<TIBenHRGDetails, Integer> modifiedBy;
	public static volatile SingularAttribute<TIBenHRGDetails, Long> id;
	public static volatile SingularAttribute<TIBenHRGDetails, Integer> alcoholConsDaysInWeek;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String HRG_SECONDARY_CATEGORY = "hrgSecondaryCategory";
	public static final String SUB_CATEGORY = "subCategory";
	public static final String HRG_PRIMARY_CATEGORY = "hrgPrimaryCategory";
	public static final String AVG_NO_SEXUAL_ACTS_UPON_REG = "avgNoSexualActsUponReg";
	public static final String CONSUME_ALCOHOL = "consumeAlcohol";
	public static final String BENEFICIARY = "beneficiary";
	public static final String CREATED_BY = "createdBy";
	public static final String NO_YEARS_IN_SEX_WORK = "noYearsInSexWork";
	public static final String CREATED_TIME = "createdTime";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String ALCOHOL_CONS_DAYS_IN_WEEK = "alcoholConsDaysInWeek";

}

