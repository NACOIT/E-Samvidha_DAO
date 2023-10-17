package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ArtPrivateDispensationItem.class)
public abstract class ArtPrivateDispensationItem_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<ArtPrivateDispensationItem, Long> dispenseQuantity;
	public static volatile SingularAttribute<ArtPrivateDispensationItem, Product> product;
	public static volatile SingularAttribute<ArtPrivateDispensationItem, ArtPrivateDispensation> artPrivateDispensation;
	public static volatile SingularAttribute<ArtPrivateDispensationItem, FacilityStock> facilityStock;
	public static volatile SingularAttribute<ArtPrivateDispensationItem, Integer> id;
	public static volatile SingularAttribute<ArtPrivateDispensationItem, String> batchNumber;

	public static final String DISPENSE_QUANTITY = "dispenseQuantity";
	public static final String PRODUCT = "product";
	public static final String ART_PRIVATE_DISPENSATION = "artPrivateDispensation";
	public static final String FACILITY_STOCK = "facilityStock";
	public static final String ID = "id";
	public static final String BATCH_NUMBER = "batchNumber";

}

