package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CounsellingNote.class)
public abstract class CounsellingNote_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<CounsellingNote, String> questionKey;
	public static volatile SetAttribute<CounsellingNote, CounsellingOptions> counsellingOptions;
	public static volatile SingularAttribute<CounsellingNote, CounsellingType> counsellingType;
	public static volatile SingularAttribute<CounsellingNote, String> counsellingSection;
	public static volatile SingularAttribute<CounsellingNote, Boolean> isDelete;
	public static volatile SingularAttribute<CounsellingNote, Long> id;
	public static volatile SingularAttribute<CounsellingNote, Boolean> isActive;
	public static volatile SingularAttribute<CounsellingNote, Boolean> firstVisit;
	public static volatile SingularAttribute<CounsellingNote, String> counsellingNote;
	public static volatile SetAttribute<CounsellingNote, ArtBeneficiaryCounsellingNotes> artBeneficiaryCounsellingNotes;

	public static final String QUESTION_KEY = "questionKey";
	public static final String COUNSELLING_OPTIONS = "counsellingOptions";
	public static final String COUNSELLING_TYPE = "counsellingType";
	public static final String COUNSELLING_SECTION = "counsellingSection";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String FIRST_VISIT = "firstVisit";
	public static final String COUNSELLING_NOTE = "counsellingNote";
	public static final String ART_BENEFICIARY_COUNSELLING_NOTES = "artBeneficiaryCounsellingNotes";

}

