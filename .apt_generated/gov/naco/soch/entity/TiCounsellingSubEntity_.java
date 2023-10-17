package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TiCounsellingSubEntity.class)
public abstract class TiCounsellingSubEntity_ {

	public static volatile SingularAttribute<TiCounsellingSubEntity, Integer> noOfCondomsDistributed;
	public static volatile SingularAttribute<TiCounsellingSubEntity, LocalDate> lastCounsellingDate;
	public static volatile SingularAttribute<TiCounsellingSubEntity, Long> facilityId;
	public static volatile SingularAttribute<TiCounsellingSubEntity, Boolean> isDelete;
	public static volatile SingularAttribute<TiCounsellingSubEntity, LocalDate> counsellingDate;
	public static volatile SingularAttribute<TiCounsellingSubEntity, LocalDate> nextCounsellingDate;
	public static volatile SingularAttribute<TiCounsellingSubEntity, Boolean> isActive;
	public static volatile SetAttribute<TiCounsellingSubEntity, TiBenCounsellingType> tiBenCounsellingType;
	public static volatile SingularAttribute<TiCounsellingSubEntity, TiBenSubEntity> beneficiary;
	public static volatile SingularAttribute<TiCounsellingSubEntity, Integer> durationOfCounselling;
	public static volatile SingularAttribute<TiCounsellingSubEntity, Long> id;
	public static volatile SingularAttribute<TiCounsellingSubEntity, Boolean> isEarly;
	public static volatile SingularAttribute<TiCounsellingSubEntity, String> remarks;

	public static final String NO_OF_CONDOMS_DISTRIBUTED = "noOfCondomsDistributed";
	public static final String LAST_COUNSELLING_DATE = "lastCounsellingDate";
	public static final String FACILITY_ID = "facilityId";
	public static final String IS_DELETE = "isDelete";
	public static final String COUNSELLING_DATE = "counsellingDate";
	public static final String NEXT_COUNSELLING_DATE = "nextCounsellingDate";
	public static final String IS_ACTIVE = "isActive";
	public static final String TI_BEN_COUNSELLING_TYPE = "tiBenCounsellingType";
	public static final String BENEFICIARY = "beneficiary";
	public static final String DURATION_OF_COUNSELLING = "durationOfCounselling";
	public static final String ID = "id";
	public static final String IS_EARLY = "isEarly";
	public static final String REMARKS = "remarks";

}

