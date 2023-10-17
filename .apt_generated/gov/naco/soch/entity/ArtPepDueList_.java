package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ArtPepDueList.class)
public abstract class ArtPepDueList_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<ArtPepDueList, UserMaster> entryUser;
	public static volatile SingularAttribute<ArtPepDueList, Boolean> isVisited;
	public static volatile SingularAttribute<ArtPepDueList, Boolean> isDelete;
	public static volatile SingularAttribute<ArtPepDueList, LocalDate> visitedDate;
	public static volatile SingularAttribute<ArtPepDueList, ArtPep> artPep;
	public static volatile SingularAttribute<ArtPepDueList, Long> id;
	public static volatile SingularAttribute<ArtPepDueList, Boolean> isActive;
	public static volatile SingularAttribute<ArtPepDueList, LocalDate> expectedVisitDate;
	public static volatile SingularAttribute<ArtPepDueList, Facility> facility;

	public static final String ENTRY_USER = "entryUser";
	public static final String IS_VISITED = "isVisited";
	public static final String IS_DELETE = "isDelete";
	public static final String VISITED_DATE = "visitedDate";
	public static final String ART_PEP = "artPep";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String EXPECTED_VISIT_DATE = "expectedVisitDate";
	public static final String FACILITY = "facility";

}

