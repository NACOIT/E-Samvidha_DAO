package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ArtPepQueue.class)
public abstract class ArtPepQueue_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<ArtPepQueue, UserMaster> entryUser;
	public static volatile SingularAttribute<ArtPepQueue, Boolean> isVisited;
	public static volatile SingularAttribute<ArtPepQueue, Boolean> isDelete;
	public static volatile SingularAttribute<ArtPepQueue, LocalDate> visitDate;
	public static volatile SingularAttribute<ArtPepQueue, ArtPep> artPep;
	public static volatile SingularAttribute<ArtPepQueue, Long> id;
	public static volatile SingularAttribute<ArtPepQueue, Boolean> isActive;
	public static volatile SingularAttribute<ArtPepQueue, Facility> facility;
	public static volatile SingularAttribute<ArtPepQueue, UserMaster> assignedTo;

	public static final String ENTRY_USER = "entryUser";
	public static final String IS_VISITED = "isVisited";
	public static final String IS_DELETE = "isDelete";
	public static final String VISIT_DATE = "visitDate";
	public static final String ART_PEP = "artPep";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY = "facility";
	public static final String ASSIGNED_TO = "assignedTo";

}

