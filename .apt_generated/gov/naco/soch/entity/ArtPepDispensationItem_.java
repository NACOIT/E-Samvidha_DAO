package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ArtPepDispensationItem.class)
public abstract class ArtPepDispensationItem_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<ArtPepDispensationItem, Long> dispenseQuantity;
	public static volatile SingularAttribute<ArtPepDispensationItem, Product> product;
	public static volatile SingularAttribute<ArtPepDispensationItem, ArtPepDispensation> artPepDispensation;
	public static volatile SingularAttribute<ArtPepDispensationItem, FacilityStock> facilityStock;
	public static volatile SingularAttribute<ArtPepDispensationItem, Integer> id;
	public static volatile SingularAttribute<ArtPepDispensationItem, String> batchNumber;

	public static final String DISPENSE_QUANTITY = "dispenseQuantity";
	public static final String PRODUCT = "product";
	public static final String ART_PEP_DISPENSATION = "artPepDispensation";
	public static final String FACILITY_STOCK = "facilityStock";
	public static final String ID = "id";
	public static final String BATCH_NUMBER = "batchNumber";

}

