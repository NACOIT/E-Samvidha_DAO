package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(IndentProductScheduleSacsLot.class)
public abstract class IndentProductScheduleSacsLot_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<IndentProductScheduleSacsLot, Long> quantity;
	public static volatile SingularAttribute<IndentProductScheduleSacsLot, LocalDate> endDate;
	public static volatile SingularAttribute<IndentProductScheduleSacsLot, Boolean> isDelete;
	public static volatile SingularAttribute<IndentProductScheduleSacsLot, Long> id;
	public static volatile SingularAttribute<IndentProductScheduleSacsLot, String> lotNumber;
	public static volatile SingularAttribute<IndentProductScheduleSacsLot, Boolean> isActive;
	public static volatile SingularAttribute<IndentProductScheduleSacsLot, IndentProductScheduleSac> indentProductScheduleSac;
	public static volatile SingularAttribute<IndentProductScheduleSacsLot, LocalDate> startDate;

	public static final String QUANTITY = "quantity";
	public static final String END_DATE = "endDate";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String LOT_NUMBER = "lotNumber";
	public static final String IS_ACTIVE = "isActive";
	public static final String INDENT_PRODUCT_SCHEDULE_SAC = "indentProductScheduleSac";
	public static final String START_DATE = "startDate";

}

