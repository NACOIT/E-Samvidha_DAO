package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SurveyAnswer.class)
public abstract class SurveyAnswer_ {

	public static volatile SingularAttribute<SurveyAnswer, String> answer;
	public static volatile SingularAttribute<SurveyAnswer, Question> question;
	public static volatile SingularAttribute<SurveyAnswer, Survey> survey;
	public static volatile SingularAttribute<SurveyAnswer, Integer> Id;

	public static final String ANSWER = "answer";
	public static final String QUESTION = "question";
	public static final String SURVEY = "survey";
	public static final String ID = "Id";

}

