package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BeneficiaryUidLinkMapping.class)
public abstract class BeneficiaryUidLinkMapping_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<BeneficiaryUidLinkMapping, Beneficiary> baseBeneficiary;
	public static volatile SingularAttribute<BeneficiaryUidLinkMapping, Boolean> isDelete;
	public static volatile SingularAttribute<BeneficiaryUidLinkMapping, Long> id;
	public static volatile SingularAttribute<BeneficiaryUidLinkMapping, Beneficiary> linkBeneficiary;
	public static volatile SingularAttribute<BeneficiaryUidLinkMapping, Facility> baseFacility;
	public static volatile SingularAttribute<BeneficiaryUidLinkMapping, Boolean> isActive;
	public static volatile SingularAttribute<BeneficiaryUidLinkMapping, Facility> linkFacility;

	public static final String BASE_BENEFICIARY = "baseBeneficiary";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String LINK_BENEFICIARY = "linkBeneficiary";
	public static final String BASE_FACILITY = "baseFacility";
	public static final String IS_ACTIVE = "isActive";
	public static final String LINK_FACILITY = "linkFacility";

}

