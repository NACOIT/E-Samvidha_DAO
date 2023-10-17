package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Product.class)
public abstract class Product_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SetAttribute<Product, RegimenConstituent> regimenConstituents;
	public static volatile SetAttribute<Product, FacilityStock> facilityStocks;
	public static volatile SingularAttribute<Product, String> minimumShelfLife;
	public static volatile SingularAttribute<Product, ProductCommodityTypeMaster> productCommodityTypeMaster;
	public static volatile SetAttribute<Product, IndentProduct> indentProducts;
	public static volatile SingularAttribute<Product, String> productShortCode;
	public static volatile SingularAttribute<Product, Boolean> isActive;
	public static volatile SetAttribute<Product, ProductDosage> productDosages;
	public static volatile SingularAttribute<Product, String> productName;
	public static volatile SetAttribute<Product, FacilityStockTransferDetail> facilityStockTransferDetails;
	public static volatile SingularAttribute<Product, Division> division;
	public static volatile SetAttribute<Product, ProductLabTypesMapping> productLabTypesMappings;
	public static volatile SingularAttribute<Product, byte[]> productImage;
	public static volatile SetAttribute<Product, FacilityStockDailyBalance> facilityStockDailyBalances;
	public static volatile SingularAttribute<Product, ProductTypesMaster> productTypesMaster;
	public static volatile SingularAttribute<Product, String> formulation;
	public static volatile SetAttribute<Product, FacilityReconciliation> facilityReconciliations;
	public static volatile SingularAttribute<Product, Long> id;
	public static volatile SetAttribute<Product, ProductFacilityTypeMapping> productFacilityTypeMappings;
	public static volatile SetAttribute<Product, ArtDispensationItem> artDispensationItems;
	public static volatile SetAttribute<Product, SupplierStock> supplierStocks;
	public static volatile SingularAttribute<Product, String> productDetail;
	public static volatile SingularAttribute<Product, Boolean> isDelete;
	public static volatile SingularAttribute<Product, Boolean> isBatchNumber;
	public static volatile SingularAttribute<Product, ProductDrugLineMaster> productDrugLineMaster;
	public static volatile SetAttribute<Product, DispensationItem> dispensationItems;
	public static volatile SetAttribute<Product, ArtPepDispensationItem> artPepDispensationItems;
	public static volatile SingularAttribute<Product, String> productCode;
	public static volatile SingularAttribute<Product, ProductRecipientTypeMaster> productRecipientTypeMaster;
	public static volatile SingularAttribute<Product, ProductUomMaster> productUomMaster;
	public static volatile SetAttribute<Product, ContractProduct> contractProducts;

	public static final String REGIMEN_CONSTITUENTS = "regimenConstituents";
	public static final String FACILITY_STOCKS = "facilityStocks";
	public static final String MINIMUM_SHELF_LIFE = "minimumShelfLife";
	public static final String PRODUCT_COMMODITY_TYPE_MASTER = "productCommodityTypeMaster";
	public static final String INDENT_PRODUCTS = "indentProducts";
	public static final String PRODUCT_SHORT_CODE = "productShortCode";
	public static final String IS_ACTIVE = "isActive";
	public static final String PRODUCT_DOSAGES = "productDosages";
	public static final String PRODUCT_NAME = "productName";
	public static final String FACILITY_STOCK_TRANSFER_DETAILS = "facilityStockTransferDetails";
	public static final String DIVISION = "division";
	public static final String PRODUCT_LAB_TYPES_MAPPINGS = "productLabTypesMappings";
	public static final String PRODUCT_IMAGE = "productImage";
	public static final String FACILITY_STOCK_DAILY_BALANCES = "facilityStockDailyBalances";
	public static final String PRODUCT_TYPES_MASTER = "productTypesMaster";
	public static final String FORMULATION = "formulation";
	public static final String FACILITY_RECONCILIATIONS = "facilityReconciliations";
	public static final String ID = "id";
	public static final String PRODUCT_FACILITY_TYPE_MAPPINGS = "productFacilityTypeMappings";
	public static final String ART_DISPENSATION_ITEMS = "artDispensationItems";
	public static final String SUPPLIER_STOCKS = "supplierStocks";
	public static final String PRODUCT_DETAIL = "productDetail";
	public static final String IS_DELETE = "isDelete";
	public static final String IS_BATCH_NUMBER = "isBatchNumber";
	public static final String PRODUCT_DRUG_LINE_MASTER = "productDrugLineMaster";
	public static final String DISPENSATION_ITEMS = "dispensationItems";
	public static final String ART_PEP_DISPENSATION_ITEMS = "artPepDispensationItems";
	public static final String PRODUCT_CODE = "productCode";
	public static final String PRODUCT_RECIPIENT_TYPE_MASTER = "productRecipientTypeMaster";
	public static final String PRODUCT_UOM_MASTER = "productUomMaster";
	public static final String CONTRACT_PRODUCTS = "contractProducts";

}

