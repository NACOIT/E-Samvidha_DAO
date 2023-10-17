package gov.naco.soch.entity;

import gov.naco.soch.entity.Question.QstnType;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Question.class)
public abstract class Question_ {

	public static volatile SingularAttribute<Question, QstnType> choiceType;
	public static volatile SingularAttribute<Question, Questionnaire> questionnaire;
	public static volatile SingularAttribute<Question, String> name;
	public static volatile SingularAttribute<Question, String> visibleIf;
	public static volatile SingularAttribute<Question, Integer> id;
	public static volatile SingularAttribute<Question, String> title;
	public static volatile SingularAttribute<Question, String> choices;

	public static final String CHOICE_TYPE = "choiceType";
	public static final String QUESTIONNAIRE = "questionnaire";
	public static final String NAME = "name";
	public static final String VISIBLE_IF = "visibleIf";
	public static final String ID = "id";
	public static final String TITLE = "title";
	public static final String CHOICES = "choices";

}

