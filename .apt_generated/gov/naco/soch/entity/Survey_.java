package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Survey.class)
public abstract class Survey_ {

	public static volatile SingularAttribute<Survey, Questionnaire> questionnaire;
	public static volatile ListAttribute<Survey, SurveyAnswer> answers;
	public static volatile SingularAttribute<Survey, Integer> id;

	public static final String QUESTIONNAIRE = "questionnaire";
	public static final String ANSWERS = "answers";
	public static final String ID = "id";

}

