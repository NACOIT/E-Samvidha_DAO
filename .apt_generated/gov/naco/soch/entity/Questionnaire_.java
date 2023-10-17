package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Questionnaire.class)
public abstract class Questionnaire_ {

	public static volatile SingularAttribute<Questionnaire, String> surveyName;
	public static volatile ListAttribute<Questionnaire, Question> questions;
	public static volatile SingularAttribute<Questionnaire, String> description;
	public static volatile SingularAttribute<Questionnaire, Integer> id;

	public static final String SURVEY_NAME = "surveyName";
	public static final String QUESTIONS = "questions";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";

}

