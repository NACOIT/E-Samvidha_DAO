package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ArtDispensationItem.class)
public abstract class ArtDispensationItem_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<ArtDispensationItem, Long> dispenseQuantity;
	public static volatile SingularAttribute<ArtDispensationItem, Product> product;
	public static volatile SingularAttribute<ArtDispensationItem, Integer> adherenceToArt;
	public static volatile SingularAttribute<ArtDispensationItem, Long> returnQty;
	public static volatile SingularAttribute<ArtDispensationItem, Boolean> isDelete;
	public static volatile SingularAttribute<ArtDispensationItem, Integer> remainingPills;
	public static volatile SingularAttribute<ArtDispensationItem, Boolean> isActive;
	public static volatile SingularAttribute<ArtDispensationItem, ArtDispensation> artDispensation;
	public static volatile SingularAttribute<ArtDispensationItem, Float> dosageQty;
	public static volatile SingularAttribute<ArtDispensationItem, FacilityStock> facilityStock;
	public static volatile SingularAttribute<ArtDispensationItem, Long> id;
	public static volatile SingularAttribute<ArtDispensationItem, Regimen> regimen;
	public static volatile SingularAttribute<ArtDispensationItem, String> batchNumber;

	public static final String DISPENSE_QUANTITY = "dispenseQuantity";
	public static final String PRODUCT = "product";
	public static final String ADHERENCE_TO_ART = "adherenceToArt";
	public static final String RETURN_QTY = "returnQty";
	public static final String IS_DELETE = "isDelete";
	public static final String REMAINING_PILLS = "remainingPills";
	public static final String IS_ACTIVE = "isActive";
	public static final String ART_DISPENSATION = "artDispensation";
	public static final String DOSAGE_QTY = "dosageQty";
	public static final String FACILITY_STOCK = "facilityStock";
	public static final String ID = "id";
	public static final String REGIMEN = "regimen";
	public static final String BATCH_NUMBER = "batchNumber";

}

