package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TIBenCounsellingTypeReadOnly.class)
public abstract class TIBenCounsellingTypeReadOnly_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<TIBenCounsellingTypeReadOnly, TIBenCounsellingViewCardReadOnly> tiBenCounselling;
	public static volatile SingularAttribute<TIBenCounsellingTypeReadOnly, MasterCounsellingType> masterCounsellingType;
	public static volatile SingularAttribute<TIBenCounsellingTypeReadOnly, Long> id;

	public static final String TI_BEN_COUNSELLING = "tiBenCounselling";
	public static final String MASTER_COUNSELLING_TYPE = "masterCounsellingType";
	public static final String ID = "id";

}

