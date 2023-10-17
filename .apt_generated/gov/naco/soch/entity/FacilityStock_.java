package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FacilityStock.class)
public abstract class FacilityStock_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SetAttribute<FacilityStock, ArtDispensationItem> artDispensationItems;
	public static volatile SingularAttribute<FacilityStock, Product> product;
	public static volatile SingularAttribute<FacilityStock, Boolean> isDelete;
	public static volatile SingularAttribute<FacilityStock, LocalDate> expiredDate;
	public static volatile SingularAttribute<FacilityStock, Long> numberOfBoxes;
	public static volatile SingularAttribute<FacilityStock, Boolean> isActive;
	public static volatile SingularAttribute<FacilityStock, LocalDate> batchInceptionDate;
	public static volatile SetAttribute<FacilityStock, ArtPepDispensationItem> artPepDispensationItems;
	public static volatile SingularAttribute<FacilityStock, Double> git;
	public static volatile SingularAttribute<FacilityStock, Double> damagedQuantity;
	public static volatile SingularAttribute<FacilityStock, LocalDate> batchCompletionDate;
	public static volatile SingularAttribute<FacilityStock, LocalDate> manufacturingDate;
	public static volatile SingularAttribute<FacilityStock, Long> id;
	public static volatile SingularAttribute<FacilityStock, Double> currentQuantity;
	public static volatile SingularAttribute<FacilityStock, Facility> facility;
	public static volatile SingularAttribute<FacilityStock, String> batchNumber;

	public static final String ART_DISPENSATION_ITEMS = "artDispensationItems";
	public static final String PRODUCT = "product";
	public static final String IS_DELETE = "isDelete";
	public static final String EXPIRED_DATE = "expiredDate";
	public static final String NUMBER_OF_BOXES = "numberOfBoxes";
	public static final String IS_ACTIVE = "isActive";
	public static final String BATCH_INCEPTION_DATE = "batchInceptionDate";
	public static final String ART_PEP_DISPENSATION_ITEMS = "artPepDispensationItems";
	public static final String GIT = "git";
	public static final String DAMAGED_QUANTITY = "damagedQuantity";
	public static final String BATCH_COMPLETION_DATE = "batchCompletionDate";
	public static final String MANUFACTURING_DATE = "manufacturingDate";
	public static final String ID = "id";
	public static final String CURRENT_QUANTITY = "currentQuantity";
	public static final String FACILITY = "facility";
	public static final String BATCH_NUMBER = "batchNumber";

}

