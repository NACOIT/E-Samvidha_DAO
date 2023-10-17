package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ArtPepDispensation.class)
public abstract class ArtPepDispensation_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<ArtPepDispensation, UserMaster> userMaster;
	public static volatile SetAttribute<ArtPepDispensation, ArtPepDispensationItem> artPepDispensationItems;
	public static volatile SingularAttribute<ArtPepDispensation, Boolean> isDelete;
	public static volatile SingularAttribute<ArtPepDispensation, LocalDate> dispenseDate;
	public static volatile SingularAttribute<ArtPepDispensation, ArtPep> artPep;
	public static volatile SingularAttribute<ArtPepDispensation, Long> id;
	public static volatile SingularAttribute<ArtPepDispensation, Boolean> isActive;
	public static volatile SingularAttribute<ArtPepDispensation, Facility> facility;

	public static final String USER_MASTER = "userMaster";
	public static final String ART_PEP_DISPENSATION_ITEMS = "artPepDispensationItems";
	public static final String IS_DELETE = "isDelete";
	public static final String DISPENSE_DATE = "dispenseDate";
	public static final String ART_PEP = "artPep";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY = "facility";

}

