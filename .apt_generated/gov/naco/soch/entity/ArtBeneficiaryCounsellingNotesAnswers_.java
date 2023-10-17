package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ArtBeneficiaryCounsellingNotesAnswers.class)
public abstract class ArtBeneficiaryCounsellingNotesAnswers_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<ArtBeneficiaryCounsellingNotesAnswers, Boolean> isDelete;
	public static volatile SingularAttribute<ArtBeneficiaryCounsellingNotesAnswers, Long> id;
	public static volatile SingularAttribute<ArtBeneficiaryCounsellingNotesAnswers, Boolean> isActive;
	public static volatile SingularAttribute<ArtBeneficiaryCounsellingNotesAnswers, String> artCounsellingNoteAnswer;
	public static volatile SingularAttribute<ArtBeneficiaryCounsellingNotesAnswers, ArtBeneficiaryCounsellingNotes> artBeneficiaryCounsellingNotes;

	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String ART_COUNSELLING_NOTE_ANSWER = "artCounsellingNoteAnswer";
	public static final String ART_BENEFICIARY_COUNSELLING_NOTES = "artBeneficiaryCounsellingNotes";

}

