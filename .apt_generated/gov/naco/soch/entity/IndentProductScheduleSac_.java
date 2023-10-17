package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(IndentProductScheduleSac.class)
public abstract class IndentProductScheduleSac_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<IndentProductScheduleSac, Boolean> isDelete;
	public static volatile SingularAttribute<IndentProductScheduleSac, IndentProductSchedule> indentProductSchedule;
	public static volatile SetAttribute<IndentProductScheduleSac, IndentProductScheduleSacsLot> indentProductSceduleSacsLots;
	public static volatile SingularAttribute<IndentProductScheduleSac, Long> id;
	public static volatile SingularAttribute<IndentProductScheduleSac, Boolean> isActive;
	public static volatile SingularAttribute<IndentProductScheduleSac, Facility> facility;

	public static final String IS_DELETE = "isDelete";
	public static final String INDENT_PRODUCT_SCHEDULE = "indentProductSchedule";
	public static final String INDENT_PRODUCT_SCEDULE_SACS_LOTS = "indentProductSceduleSacsLots";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY = "facility";

}

