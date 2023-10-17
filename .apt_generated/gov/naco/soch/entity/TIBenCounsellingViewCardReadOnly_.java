package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TIBenCounsellingViewCardReadOnly.class)
public abstract class TIBenCounsellingViewCardReadOnly_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SetAttribute<TIBenCounsellingViewCardReadOnly, TIBenCounsellingTypeReadOnly> tiBenCounsellingType;
	public static volatile SingularAttribute<TIBenCounsellingViewCardReadOnly, LocalDate> lastCounsellingDate;
	public static volatile SingularAttribute<TIBenCounsellingViewCardReadOnly, TiBeneficiaryViewCardReadOnly> beneficiary;
	public static volatile SingularAttribute<TIBenCounsellingViewCardReadOnly, Long> id;
	public static volatile SingularAttribute<TIBenCounsellingViewCardReadOnly, LocalDate> nextCounsellingDate;

	public static final String TI_BEN_COUNSELLING_TYPE = "tiBenCounsellingType";
	public static final String LAST_COUNSELLING_DATE = "lastCounsellingDate";
	public static final String BENEFICIARY = "beneficiary";
	public static final String ID = "id";
	public static final String NEXT_COUNSELLING_DATE = "nextCounsellingDate";

}

