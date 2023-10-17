package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ArtDispensationMiniProfile.class)
public abstract class ArtDispensationMiniProfile_ {

	public static volatile SingularAttribute<ArtDispensationMiniProfile, BeneficiaryMiniProfile> beneficiary;
	public static volatile SingularAttribute<ArtDispensationMiniProfile, Boolean> isDelete;
	public static volatile SingularAttribute<ArtDispensationMiniProfile, Long> id;
	public static volatile SingularAttribute<ArtDispensationMiniProfile, Boolean> isActive;
	public static volatile SingularAttribute<ArtDispensationMiniProfile, FacilityMiniProfile> facility;

	public static final String BENEFICIARY = "beneficiary";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY = "facility";

}

