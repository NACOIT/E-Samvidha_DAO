package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Captcha.class)
public abstract class Captcha_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<Captcha, String> answer;
	public static volatile SingularAttribute<Captcha, Long> id;
	public static volatile SingularAttribute<Captcha, Boolean> isUsed;

	public static final String ANSWER = "answer";
	public static final String ID = "id";
	public static final String IS_USED = "isUsed";

}

