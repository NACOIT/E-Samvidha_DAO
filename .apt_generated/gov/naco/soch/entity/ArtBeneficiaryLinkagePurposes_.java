package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ArtBeneficiaryLinkagePurposes.class)
public abstract class ArtBeneficiaryLinkagePurposes_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<ArtBeneficiaryLinkagePurposes, Beneficiary> beneficiary;
	public static volatile SingularAttribute<ArtBeneficiaryLinkagePurposes, Boolean> isDelete;
	public static volatile SingularAttribute<ArtBeneficiaryLinkagePurposes, Long> id;
	public static volatile SingularAttribute<ArtBeneficiaryLinkagePurposes, MasterPurpos> masterPurpos;
	public static volatile SingularAttribute<ArtBeneficiaryLinkagePurposes, Boolean> isActive;

	public static final String BENEFICIARY = "beneficiary";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String MASTER_PURPOS = "masterPurpos";
	public static final String IS_ACTIVE = "isActive";

}

