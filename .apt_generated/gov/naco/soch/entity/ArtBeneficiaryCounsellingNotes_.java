package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ArtBeneficiaryCounsellingNotes.class)
public abstract class ArtBeneficiaryCounsellingNotes_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<ArtBeneficiaryCounsellingNotes, UserMaster> userMaster;
	public static volatile SingularAttribute<ArtBeneficiaryCounsellingNotes, Beneficiary> beneficiary;
	public static volatile SetAttribute<ArtBeneficiaryCounsellingNotes, ArtBeneficiaryCounsellingNotesAnswers> artBeneficiaryCounsellingNotesAnswers;
	public static volatile SingularAttribute<ArtBeneficiaryCounsellingNotes, Boolean> isDelete;
	public static volatile SingularAttribute<ArtBeneficiaryCounsellingNotes, BeneficiaryVisitRegister> beneficiaryVisitRegister;
	public static volatile SingularAttribute<ArtBeneficiaryCounsellingNotes, Long> id;
	public static volatile SingularAttribute<ArtBeneficiaryCounsellingNotes, Boolean> isActive;
	public static volatile SingularAttribute<ArtBeneficiaryCounsellingNotes, Facility> facility;
	public static volatile SingularAttribute<ArtBeneficiaryCounsellingNotes, CounsellingNote> counsellingNote;

	public static final String USER_MASTER = "userMaster";
	public static final String BENEFICIARY = "beneficiary";
	public static final String ART_BENEFICIARY_COUNSELLING_NOTES_ANSWERS = "artBeneficiaryCounsellingNotesAnswers";
	public static final String IS_DELETE = "isDelete";
	public static final String BENEFICIARY_VISIT_REGISTER = "beneficiaryVisitRegister";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY = "facility";
	public static final String COUNSELLING_NOTE = "counsellingNote";

}

