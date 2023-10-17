package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CmssIndent.class)
public abstract class CmssIndent_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<CmssIndent, String> cmssProductName;
	public static volatile SingularAttribute<CmssIndent, LocalDate> indentDate;
	public static volatile SingularAttribute<CmssIndent, String> indentStore;
	public static volatile SingularAttribute<CmssIndent, String> productCode;
	public static volatile SingularAttribute<CmssIndent, Long> indentQty;
	public static volatile SingularAttribute<CmssIndent, Boolean> isDelete;
	public static volatile SingularAttribute<CmssIndent, String> issuingStore;
	public static volatile SingularAttribute<CmssIndent, Long> id;
	public static volatile SingularAttribute<CmssIndent, Boolean> isActive;
	public static volatile SingularAttribute<CmssIndent, String> indentNo;
	public static volatile SingularAttribute<CmssIndent, Facility> facility;
	public static volatile SingularAttribute<CmssIndent, String> productName;

	public static final String CMSS_PRODUCT_NAME = "cmssProductName";
	public static final String INDENT_DATE = "indentDate";
	public static final String INDENT_STORE = "indentStore";
	public static final String PRODUCT_CODE = "productCode";
	public static final String INDENT_QTY = "indentQty";
	public static final String IS_DELETE = "isDelete";
	public static final String ISSUING_STORE = "issuingStore";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String INDENT_NO = "indentNo";
	public static final String FACILITY = "facility";
	public static final String PRODUCT_NAME = "productName";

}

