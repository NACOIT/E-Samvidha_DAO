package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PediatricBeneficiaryEntity.class)
public abstract class PediatricBeneficiaryEntity_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<PediatricBeneficiaryEntity, String> neoNatalComplications;
	public static volatile SingularAttribute<PediatricBeneficiaryEntity, LocalDate> guardianDateOfBirth;
	public static volatile SingularAttribute<PediatricBeneficiaryEntity, String> paediatricOtherVaccines;
	public static volatile SingularAttribute<PediatricBeneficiaryEntity, Long> genderId;
	public static volatile SingularAttribute<PediatricBeneficiaryEntity, LocalDate> dateOfBirth;
	public static volatile SingularAttribute<PediatricBeneficiaryEntity, Long> stayingWithId;
	public static volatile SingularAttribute<PediatricBeneficiaryEntity, Long> birthHistoryId;
	public static volatile SingularAttribute<PediatricBeneficiaryEntity, Long> guardianCaregiverHighestEducation_id;
	public static volatile SingularAttribute<PediatricBeneficiaryEntity, Long> guardianCaregiverId;
	public static volatile SingularAttribute<PediatricBeneficiaryEntity, String> guardianCaregiverOthers;
	public static volatile SingularAttribute<PediatricBeneficiaryEntity, Long> id;
	public static volatile SingularAttribute<PediatricBeneficiaryEntity, Double> birthWeight;
	public static volatile SingularAttribute<PediatricBeneficiaryEntity, String> stayingWithOthers;

	public static final String NEO_NATAL_COMPLICATIONS = "neoNatalComplications";
	public static final String GUARDIAN_DATE_OF_BIRTH = "guardianDateOfBirth";
	public static final String PAEDIATRIC_OTHER_VACCINES = "paediatricOtherVaccines";
	public static final String GENDER_ID = "genderId";
	public static final String DATE_OF_BIRTH = "dateOfBirth";
	public static final String STAYING_WITH_ID = "stayingWithId";
	public static final String BIRTH_HISTORY_ID = "birthHistoryId";
	public static final String GUARDIAN_CAREGIVER_HIGHEST_EDUCATION_ID = "guardianCaregiverHighestEducation_id";
	public static final String GUARDIAN_CAREGIVER_ID = "guardianCaregiverId";
	public static final String GUARDIAN_CAREGIVER_OTHERS = "guardianCaregiverOthers";
	public static final String ID = "id";
	public static final String BIRTH_WEIGHT = "birthWeight";
	public static final String STAYING_WITH_OTHERS = "stayingWithOthers";

}

