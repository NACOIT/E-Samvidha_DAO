package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PrisonQuestionnierResult.class)
public abstract class PrisonQuestionnierResult_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<PrisonQuestionnierResult, Integer> tgValue;
	public static volatile SingularAttribute<PrisonQuestionnierResult, Integer> totalprisonstate;
	public static volatile SingularAttribute<PrisonQuestionnierResult, Integer> masterPrisonQuestion;
	public static volatile SingularAttribute<PrisonQuestionnierResult, Boolean> isDelete;
	public static volatile SingularAttribute<PrisonQuestionnierResult, Boolean> isActive;
	public static volatile SingularAttribute<PrisonQuestionnierResult, String> financialYear;
	public static volatile SingularAttribute<PrisonQuestionnierResult, Integer> month;
	public static volatile SingularAttribute<PrisonQuestionnierResult, Integer> prisonstated;
	public static volatile SingularAttribute<PrisonQuestionnierResult, Integer> femaleValue;
	public static volatile SingularAttribute<PrisonQuestionnierResult, Long> id;
	public static volatile SingularAttribute<PrisonQuestionnierResult, Integer> maleValue;
	public static volatile SingularAttribute<PrisonQuestionnierResult, Long> facility;
	public static volatile SingularAttribute<PrisonQuestionnierResult, Boolean> isSubmittedToNaco;

	public static final String TG_VALUE = "tgValue";
	public static final String TOTALPRISONSTATE = "totalprisonstate";
	public static final String MASTER_PRISON_QUESTION = "masterPrisonQuestion";
	public static final String IS_DELETE = "isDelete";
	public static final String IS_ACTIVE = "isActive";
	public static final String FINANCIAL_YEAR = "financialYear";
	public static final String MONTH = "month";
	public static final String PRISONSTATED = "prisonstated";
	public static final String FEMALE_VALUE = "femaleValue";
	public static final String ID = "id";
	public static final String MALE_VALUE = "maleValue";
	public static final String FACILITY = "facility";
	public static final String IS_SUBMITTED_TO_NACO = "isSubmittedToNaco";

}

