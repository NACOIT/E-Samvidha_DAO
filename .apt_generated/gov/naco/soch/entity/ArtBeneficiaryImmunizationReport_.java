package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ArtBeneficiaryImmunizationReport.class)
public abstract class ArtBeneficiaryImmunizationReport_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<ArtBeneficiaryImmunizationReport, LocalDate> givenDate;
	public static volatile SingularAttribute<ArtBeneficiaryImmunizationReport, Beneficiary> beneficiary;
	public static volatile SingularAttribute<ArtBeneficiaryImmunizationReport, Boolean> isDelete;
	public static volatile SingularAttribute<ArtBeneficiaryImmunizationReport, Integer> vaccinationAge;
	public static volatile SingularAttribute<ArtBeneficiaryImmunizationReport, LocalDate> dueDate;
	public static volatile SingularAttribute<ArtBeneficiaryImmunizationReport, MasterVaccineStage> masterVaccineStage;
	public static volatile SingularAttribute<ArtBeneficiaryImmunizationReport, Long> id;
	public static volatile SingularAttribute<ArtBeneficiaryImmunizationReport, Boolean> isActive;
	public static volatile SingularAttribute<ArtBeneficiaryImmunizationReport, MasterVaccineType> masterVaccineType;

	public static final String GIVEN_DATE = "givenDate";
	public static final String BENEFICIARY = "beneficiary";
	public static final String IS_DELETE = "isDelete";
	public static final String VACCINATION_AGE = "vaccinationAge";
	public static final String DUE_DATE = "dueDate";
	public static final String MASTER_VACCINE_STAGE = "masterVaccineStage";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String MASTER_VACCINE_TYPE = "masterVaccineType";

}

