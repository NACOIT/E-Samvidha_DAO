package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ArtBeneficiaryDnaPcrResult.class)
public abstract class ArtBeneficiaryDnaPcrResult_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<ArtBeneficiaryDnaPcrResult, Beneficiary> beneficiary;
	public static volatile SingularAttribute<ArtBeneficiaryDnaPcrResult, MasterDnaPcrTest> masterDnaPcrTest;
	public static volatile SingularAttribute<ArtBeneficiaryDnaPcrResult, Boolean> isDelete;
	public static volatile SingularAttribute<ArtBeneficiaryDnaPcrResult, MasterDnaPcrResult> masterDnaPcrResult;
	public static volatile SingularAttribute<ArtBeneficiaryDnaPcrResult, Long> id;
	public static volatile SingularAttribute<ArtBeneficiaryDnaPcrResult, Boolean> isActive;

	public static final String BENEFICIARY = "beneficiary";
	public static final String MASTER_DNA_PCR_TEST = "masterDnaPcrTest";
	public static final String IS_DELETE = "isDelete";
	public static final String MASTER_DNA_PCR_RESULT = "masterDnaPcrResult";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";

}

