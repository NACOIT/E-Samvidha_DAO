package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ArtBeneficiaryMiniProfile.class)
public abstract class ArtBeneficiaryMiniProfile_ {

	public static volatile SingularAttribute<ArtBeneficiaryMiniProfile, Boolean> lacLinked;
	public static volatile SingularAttribute<ArtBeneficiaryMiniProfile, BeneficiaryMiniProfile> beneficiary;
	public static volatile SingularAttribute<ArtBeneficiaryMiniProfile, Boolean> isDelete;
	public static volatile SingularAttribute<ArtBeneficiaryMiniProfile, MasterArtBeneficiaryStatus> masterArtBeneficiaryStatus;
	public static volatile SingularAttribute<ArtBeneficiaryMiniProfile, Long> id;
	public static volatile SingularAttribute<ArtBeneficiaryMiniProfile, Boolean> isActive;
	public static volatile SingularAttribute<ArtBeneficiaryMiniProfile, FacilityMiniProfile> facility;
	public static volatile SingularAttribute<ArtBeneficiaryMiniProfile, Boolean> isTransit;

	public static final String LAC_LINKED = "lacLinked";
	public static final String BENEFICIARY = "beneficiary";
	public static final String IS_DELETE = "isDelete";
	public static final String MASTER_ART_BENEFICIARY_STATUS = "masterArtBeneficiaryStatus";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY = "facility";
	public static final String IS_TRANSIT = "isTransit";

}

