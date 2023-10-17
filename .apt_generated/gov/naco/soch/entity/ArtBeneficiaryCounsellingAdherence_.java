package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ArtBeneficiaryCounsellingAdherence.class)
public abstract class ArtBeneficiaryCounsellingAdherence_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<ArtBeneficiaryCounsellingAdherence, UserMaster> entryUser;
	public static volatile SingularAttribute<ArtBeneficiaryCounsellingAdherence, Product> product;
	public static volatile SingularAttribute<ArtBeneficiaryCounsellingAdherence, Integer> adherenceToArt;
	public static volatile SingularAttribute<ArtBeneficiaryCounsellingAdherence, Beneficiary> beneficiary;
	public static volatile SingularAttribute<ArtBeneficiaryCounsellingAdherence, Boolean> isDelete;
	public static volatile SingularAttribute<ArtBeneficiaryCounsellingAdherence, Integer> remainingPills;
	public static volatile SingularAttribute<ArtBeneficiaryCounsellingAdherence, BeneficiaryVisitRegister> beneficiaryVisitRegister;
	public static volatile SingularAttribute<ArtBeneficiaryCounsellingAdherence, Long> id;
	public static volatile SingularAttribute<ArtBeneficiaryCounsellingAdherence, Boolean> isActive;
	public static volatile SingularAttribute<ArtBeneficiaryCounsellingAdherence, Facility> facility;

	public static final String ENTRY_USER = "entryUser";
	public static final String PRODUCT = "product";
	public static final String ADHERENCE_TO_ART = "adherenceToArt";
	public static final String BENEFICIARY = "beneficiary";
	public static final String IS_DELETE = "isDelete";
	public static final String REMAINING_PILLS = "remainingPills";
	public static final String BENEFICIARY_VISIT_REGISTER = "beneficiaryVisitRegister";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY = "facility";

}

