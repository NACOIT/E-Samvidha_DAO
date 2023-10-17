package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TiCounsellingV2SubEntity.class)
public abstract class TiCounsellingV2SubEntity_ {

	public static volatile SingularAttribute<TiCounsellingV2SubEntity, Integer> noOfCondomsDistributed;
	public static volatile SingularAttribute<TiCounsellingV2SubEntity, LocalDate> lastCounsellingDate;
	public static volatile SingularAttribute<TiCounsellingV2SubEntity, Long> facilityId;
	public static volatile SingularAttribute<TiCounsellingV2SubEntity, TiBenV2SubEntity> beneficiary;
	public static volatile SingularAttribute<TiCounsellingV2SubEntity, Integer> durationOfCounselling;
	public static volatile SingularAttribute<TiCounsellingV2SubEntity, Boolean> isDelete;
	public static volatile SingularAttribute<TiCounsellingV2SubEntity, LocalDate> counsellingDate;
	public static volatile SingularAttribute<TiCounsellingV2SubEntity, Long> id;
	public static volatile SingularAttribute<TiCounsellingV2SubEntity, LocalDate> nextCounsellingDate;
	public static volatile SingularAttribute<TiCounsellingV2SubEntity, Boolean> isEarly;

	public static final String NO_OF_CONDOMS_DISTRIBUTED = "noOfCondomsDistributed";
	public static final String LAST_COUNSELLING_DATE = "lastCounsellingDate";
	public static final String FACILITY_ID = "facilityId";
	public static final String BENEFICIARY = "beneficiary";
	public static final String DURATION_OF_COUNSELLING = "durationOfCounselling";
	public static final String IS_DELETE = "isDelete";
	public static final String COUNSELLING_DATE = "counsellingDate";
	public static final String ID = "id";
	public static final String NEXT_COUNSELLING_DATE = "nextCounsellingDate";
	public static final String IS_EARLY = "isEarly";

}

