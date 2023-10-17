package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FacilityLinkedFacilityBeneficiary.class)
public abstract class FacilityLinkedFacilityBeneficiary_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<FacilityLinkedFacilityBeneficiary, Boolean> isLinked;
	public static volatile SingularAttribute<FacilityLinkedFacilityBeneficiary, Facility> parentFacility;
	public static volatile SingularAttribute<FacilityLinkedFacilityBeneficiary, Facility> linkedFacilityId;
	public static volatile SingularAttribute<FacilityLinkedFacilityBeneficiary, TiOstBeneficiary> tiOstBeneficiary;
	public static volatile SingularAttribute<FacilityLinkedFacilityBeneficiary, Beneficiary> beneficiary;
	public static volatile SingularAttribute<FacilityLinkedFacilityBeneficiary, Boolean> isDelete;
	public static volatile SingularAttribute<FacilityLinkedFacilityBeneficiary, FacilityType> facilityTypeBean;
	public static volatile SingularAttribute<FacilityLinkedFacilityBeneficiary, Long> id;
	public static volatile SingularAttribute<FacilityLinkedFacilityBeneficiary, Boolean> isActive;
	public static volatile SingularAttribute<FacilityLinkedFacilityBeneficiary, LocalDate> linkDate;
	public static volatile SingularAttribute<FacilityLinkedFacilityBeneficiary, LocalDate> unlinkDate;

	public static final String IS_LINKED = "isLinked";
	public static final String PARENT_FACILITY = "parentFacility";
	public static final String LINKED_FACILITY_ID = "linkedFacilityId";
	public static final String TI_OST_BENEFICIARY = "tiOstBeneficiary";
	public static final String BENEFICIARY = "beneficiary";
	public static final String IS_DELETE = "isDelete";
	public static final String FACILITY_TYPE_BEAN = "facilityTypeBean";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String LINK_DATE = "linkDate";
	public static final String UNLINK_DATE = "unlinkDate";

}

