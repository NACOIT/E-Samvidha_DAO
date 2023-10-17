package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(NacoBudgetAllocationEntity.class)
public abstract class NacoBudgetAllocationEntity_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<NacoBudgetAllocationEntity, String> financialYear;
	public static volatile SingularAttribute<NacoBudgetAllocationEntity, Long> facilityId;
	public static volatile SingularAttribute<NacoBudgetAllocationEntity, String> comments;
	public static volatile SingularAttribute<NacoBudgetAllocationEntity, Boolean> isDelete;
	public static volatile SingularAttribute<NacoBudgetAllocationEntity, String> approvedBudget;
	public static volatile SingularAttribute<NacoBudgetAllocationEntity, Long> id;
	public static volatile SingularAttribute<NacoBudgetAllocationEntity, Boolean> isActive;

	public static final String FINANCIAL_YEAR = "financialYear";
	public static final String FACILITY_ID = "facilityId";
	public static final String COMMENTS = "comments";
	public static final String IS_DELETE = "isDelete";
	public static final String APPROVED_BUDGET = "approvedBudget";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";

}

