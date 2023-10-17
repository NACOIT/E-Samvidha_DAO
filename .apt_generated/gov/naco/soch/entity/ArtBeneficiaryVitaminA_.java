package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ArtBeneficiaryVitaminA.class)
public abstract class ArtBeneficiaryVitaminA_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<ArtBeneficiaryVitaminA, LocalDate> givenDate;
	public static volatile SingularAttribute<ArtBeneficiaryVitaminA, MasterVitaminAAge> masterVitaminAAge;
	public static volatile SingularAttribute<ArtBeneficiaryVitaminA, Beneficiary> beneficiary;
	public static volatile SingularAttribute<ArtBeneficiaryVitaminA, Boolean> isDelete;
	public static volatile SingularAttribute<ArtBeneficiaryVitaminA, Long> id;
	public static volatile SingularAttribute<ArtBeneficiaryVitaminA, Boolean> isActive;

	public static final String GIVEN_DATE = "givenDate";
	public static final String MASTER_VITAMIN_AAGE = "masterVitaminAAge";
	public static final String BENEFICIARY = "beneficiary";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";

}

