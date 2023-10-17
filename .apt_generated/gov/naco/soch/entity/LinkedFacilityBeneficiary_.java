package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(LinkedFacilityBeneficiary.class)
public abstract class LinkedFacilityBeneficiary_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<LinkedFacilityBeneficiary, Boolean> isLinked;
	public static volatile SingularAttribute<LinkedFacilityBeneficiary, Facility> parentFacility;
	public static volatile SingularAttribute<LinkedFacilityBeneficiary, TiOstBeneficiary> tiOstBeneficiary;
	public static volatile SingularAttribute<LinkedFacilityBeneficiary, Beneficiary> beneficiary;
	public static volatile SingularAttribute<LinkedFacilityBeneficiary, Facility> linkedFacility;
	public static volatile SingularAttribute<LinkedFacilityBeneficiary, FacilityType> facilityType;
	public static volatile SingularAttribute<LinkedFacilityBeneficiary, Boolean> isDelete;
	public static volatile SingularAttribute<LinkedFacilityBeneficiary, Long> id;
	public static volatile SingularAttribute<LinkedFacilityBeneficiary, Boolean> isActive;
	public static volatile SingularAttribute<LinkedFacilityBeneficiary, LocalDate> linkDate;
	public static volatile SingularAttribute<LinkedFacilityBeneficiary, LocalDate> unlinkDate;

	public static final String IS_LINKED = "isLinked";
	public static final String PARENT_FACILITY = "parentFacility";
	public static final String TI_OST_BENEFICIARY = "tiOstBeneficiary";
	public static final String BENEFICIARY = "beneficiary";
	public static final String LINKED_FACILITY = "linkedFacility";
	public static final String FACILITY_TYPE = "facilityType";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String LINK_DATE = "linkDate";
	public static final String UNLINK_DATE = "unlinkDate";

}

