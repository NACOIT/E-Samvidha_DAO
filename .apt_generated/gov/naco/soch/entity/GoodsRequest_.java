package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GoodsRequest.class)
public abstract class GoodsRequest_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<GoodsRequest, IndentReasonsMaster> indentReason;
	public static volatile SingularAttribute<GoodsRequest, Product> product;
	public static volatile SingularAttribute<GoodsRequest, IndentRequestStatusMaster> goodsRequestStatus;
	public static volatile SingularAttribute<GoodsRequest, Boolean> isDispatched;
	public static volatile SingularAttribute<GoodsRequest, Boolean> isDelete;
	public static volatile SingularAttribute<GoodsRequest, LocalDate> estimateDeliveryDate;
	public static volatile SingularAttribute<GoodsRequest, Facility> sacs;
	public static volatile SingularAttribute<GoodsRequest, Boolean> isActive;
	public static volatile SingularAttribute<GoodsRequest, Long> approvedQuantity;
	public static volatile SingularAttribute<GoodsRequest, LocalDate> approvedDate;
	public static volatile SingularAttribute<GoodsRequest, String> indentNumber;
	public static volatile SingularAttribute<GoodsRequest, LocalDate> requestedDeliveryDate;
	public static volatile SingularAttribute<GoodsRequest, Long> requestedQuantity;
	public static volatile SingularAttribute<GoodsRequest, Long> id;
	public static volatile SingularAttribute<GoodsRequest, LocalDate> requestedDate;
	public static volatile SingularAttribute<GoodsRequest, Facility> facility;

	public static final String INDENT_REASON = "indentReason";
	public static final String PRODUCT = "product";
	public static final String GOODS_REQUEST_STATUS = "goodsRequestStatus";
	public static final String IS_DISPATCHED = "isDispatched";
	public static final String IS_DELETE = "isDelete";
	public static final String ESTIMATE_DELIVERY_DATE = "estimateDeliveryDate";
	public static final String SACS = "sacs";
	public static final String IS_ACTIVE = "isActive";
	public static final String APPROVED_QUANTITY = "approvedQuantity";
	public static final String APPROVED_DATE = "approvedDate";
	public static final String INDENT_NUMBER = "indentNumber";
	public static final String REQUESTED_DELIVERY_DATE = "requestedDeliveryDate";
	public static final String REQUESTED_QUANTITY = "requestedQuantity";
	public static final String ID = "id";
	public static final String REQUESTED_DATE = "requestedDate";
	public static final String FACILITY = "facility";

}

