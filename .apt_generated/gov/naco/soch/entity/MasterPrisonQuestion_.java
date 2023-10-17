package gov.naco.soch.entity;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MasterPrisonQuestion.class)
public abstract class MasterPrisonQuestion_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<MasterPrisonQuestion, LocalDateTime> modifiedTime;
	public static volatile SingularAttribute<MasterPrisonQuestion, String> question;
	public static volatile SingularAttribute<MasterPrisonQuestion, Long> createdBy;
	public static volatile SingularAttribute<MasterPrisonQuestion, Boolean> isDelete;
	public static volatile SingularAttribute<MasterPrisonQuestion, String> description;
	public static volatile SingularAttribute<MasterPrisonQuestion, LocalDateTime> createdTime;
	public static volatile SingularAttribute<MasterPrisonQuestion, Long> modifiedBy;
	public static volatile SingularAttribute<MasterPrisonQuestion, Long> id;
	public static volatile SingularAttribute<MasterPrisonQuestion, Boolean> isActive;
	public static volatile SingularAttribute<MasterPrisonQuestion, String> questionNumber;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String QUESTION = "question";
	public static final String CREATED_BY = "createdBy";
	public static final String IS_DELETE = "isDelete";
	public static final String DESCRIPTION = "description";
	public static final String CREATED_TIME = "createdTime";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String QUESTION_NUMBER = "questionNumber";

}

