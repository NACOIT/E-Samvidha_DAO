package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CMSSRORequest.class)
public abstract class CMSSRORequest_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<CMSSRORequest, IndentReasonsMaster> reason;
	public static volatile SingularAttribute<CMSSRORequest, CMSSProductMapping> product;
	public static volatile SingularAttribute<CMSSRORequest, Boolean> isDelete;
	public static volatile SingularAttribute<CMSSRORequest, CmssWarehouse> store;
	public static volatile SingularAttribute<CMSSRORequest, Boolean> isActive;
	public static volatile SingularAttribute<CMSSRORequest, String> indentNumber;
	public static volatile SingularAttribute<CMSSRORequest, Long> receivedQuantity;
	public static volatile SingularAttribute<CMSSRORequest, LocalDate> requestedDeliveryDate;
	public static volatile SingularAttribute<CMSSRORequest, Long> requestedQuantity;
	public static volatile SingularAttribute<CMSSRORequest, Long> id;
	public static volatile SingularAttribute<CMSSRORequest, Facility> facility;
	public static volatile SingularAttribute<CMSSRORequest, LocalDate> receivedDate;
	public static volatile SingularAttribute<CMSSRORequest, MasterCmssROStatus> requestStatus;

	public static final String REASON = "reason";
	public static final String PRODUCT = "product";
	public static final String IS_DELETE = "isDelete";
	public static final String STORE = "store";
	public static final String IS_ACTIVE = "isActive";
	public static final String INDENT_NUMBER = "indentNumber";
	public static final String RECEIVED_QUANTITY = "receivedQuantity";
	public static final String REQUESTED_DELIVERY_DATE = "requestedDeliveryDate";
	public static final String REQUESTED_QUANTITY = "requestedQuantity";
	public static final String ID = "id";
	public static final String FACILITY = "facility";
	public static final String RECEIVED_DATE = "receivedDate";
	public static final String REQUEST_STATUS = "requestStatus";

}

