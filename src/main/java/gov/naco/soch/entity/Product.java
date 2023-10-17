package gov.naco.soch.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;

/**
 * The persistent class for the product database table.
 * 
 */
@GenericGenerator(name = "product", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "product_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "product")
@Where(clause = "is_delete <> true")
public class Product extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( generator = "product")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "is_batchnumber_mandatory")
	private Boolean isBatchNumber;

	@Column(length = 99)
	private String formulation;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "minimum_shelf_life", length = 99)
	private String minimumShelfLife;

	@Column(name = "product_detail", length = 99)
	private String productDetail;

	@Column(name = "product_image")
	@Type(type = "org.hibernate.type.BinaryType")
	private byte[] productImage;

	@Column(name = "product_name", length = 99)
	private String productName;

	@Column(name = "product_code")
	private String productCode;

	@Column(name = "product_short_code", length = 99)
	private String productShortCode;

	// bi-directional many-to-one association to ProductUomMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "uom_id")
	private ProductUomMaster productUomMaster;

	// bi-directional many-to-one association to DispensationItem
	@OneToMany(mappedBy = "product")
	private Set<DispensationItem> dispensationItems;

	// bi-directional many-to-one association to Division
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "division_id")
	private Division division;

	// bi-directional many-to-one association to ProductTypesMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "product_type_id")
	private ProductTypesMaster productTypesMaster;

	// bi-directional many-to-one association to ProductDosage
	@OneToMany(mappedBy = "product")
	private Set<ProductDosage> productDosages;

	// bi-directional many-to-one association to ProductLabTypesMapping
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ProductLabTypesMapping> productLabTypesMappings;

	// bi-directional many-to-one association to RegimenConstituent
	@OneToMany(mappedBy = "product")
	private Set<RegimenConstituent> regimenConstituents;

	// bi-directional many-to-one association to FacilityStock
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private Set<FacilityStock> facilityStocks;

	// bi-directional many-to-one association to FacilityStockTransferDetail
	@OneToMany(mappedBy = "product")
	private Set<FacilityStockTransferDetail> facilityStockTransferDetails;

	// bi-directional many-to-one association to ContractProduct
	@OneToMany(mappedBy = "product")
	private Set<ContractProduct> contractProducts;

	// bi-directional many-to-one association to SupplierStock
	@OneToMany(mappedBy = "product")
	private Set<SupplierStock> supplierStocks;

	@OneToMany(mappedBy = "product")
	private Set<FacilityReconciliation> facilityReconciliations;

	// bi-directional many-to-one association to IndentProduct
	@OneToMany(mappedBy = "product")
	private Set<IndentProduct> indentProducts;

	// bi-directional many-to-one association to ProductCommodityTypeMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "product_commodity_type_id")
	private ProductCommodityTypeMaster productCommodityTypeMaster;

	// bi-directional many-to-one association to ProductDrugLineMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "product_drug_line_id")
	private ProductDrugLineMaster productDrugLineMaster;

	// bi-directional many-to-one association to ProductRecipientTypeMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "product_recipient_type_id")
	private ProductRecipientTypeMaster productRecipientTypeMaster;

	// bi-directional many-to-one association to FacilityStockDailyBalance
	@OneToMany(mappedBy = "product")
	private Set<FacilityStockDailyBalance> facilityStockDailyBalances;

	@OneToMany(mappedBy = "product")
	private Set<ArtDispensationItem> artDispensationItems;

	// bi-directional many-to-one association to ArtPepDispensationItem
	@OneToMany(mappedBy = "product")
	private Set<ArtPepDispensationItem> artPepDispensationItems;
	
	// bi-directional many-to-one association to ProductFacilityTypeMapping
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private Set<ProductFacilityTypeMapping> productFacilityTypeMappings;

	public Product() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// public TiOstDrugDispensation getTiOstDrugDispensations() {
	// return tiOstDrugDispensations;
	// }
	//
	// public void setTiOstDrugDispensations(TiOstDrugDispensation
	// tiOstDrugDispensations) {
	// this.tiOstDrugDispensations = tiOstDrugDispensations;
	// }

	public Boolean getIsBatchNumber() {
		return isBatchNumber;
	}

	public void setIsBatchNumber(Boolean isBatchNumber) {
		this.isBatchNumber = isBatchNumber;
	}

	public String getFormulation() {
		return this.formulation;
	}

	public void setFormulation(String formulation) {
		this.formulation = formulation;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	// public Set<TiOstDrugDispensation> getTiOstDrugDispensations() {
	// return tiOstDrugDispensations;
	// }
	//
	// public void setTiOstDrugDispensations(Set<TiOstDrugDispensation>
	// tiOstDrugDispensations) {
	// this.tiOstDrugDispensations = tiOstDrugDispensations;
	// }

	public String getMinimumShelfLife() {
		return this.minimumShelfLife;
	}

	public void setMinimumShelfLife(String minimumShelfLife) {
		this.minimumShelfLife = minimumShelfLife;
	}

	public String getProductDetail() {
		return this.productDetail;
	}

	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}

	public byte[] getProductImage() {
		return this.productImage;
	}

	public void setProductImage(byte[] productImage) {
		this.productImage = productImage;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductShortCode() {
		return this.productShortCode;
	}

	public void setProductShortCode(String productShortCode) {
		this.productShortCode = productShortCode;
	}

	public ProductUomMaster getProductUomMaster() {
		return this.productUomMaster;
	}

	public void setProductUomMaster(ProductUomMaster productUomMaster) {
		this.productUomMaster = productUomMaster;
	}

	public Set<DispensationItem> getDispensationItems() {
		return this.dispensationItems;
	}

	public void setDispensationItems(Set<DispensationItem> dispensationItems) {
		this.dispensationItems = dispensationItems;
	}

	public DispensationItem addDispensationItem(DispensationItem dispensationItem) {
		getDispensationItems().add(dispensationItem);
		dispensationItem.setProduct(this);

		return dispensationItem;
	}

	public DispensationItem removeDispensationItem(DispensationItem dispensationItem) {
		getDispensationItems().remove(dispensationItem);
		dispensationItem.setProduct(null);

		return dispensationItem;
	}

	public Division getDivision() {
		return this.division;
	}

	public void setDivision(Division division) {
		this.division = division;
	}

	public ProductTypesMaster getProductTypesMaster() {
		return this.productTypesMaster;
	}

	public void setProductTypesMaster(ProductTypesMaster productTypesMaster) {
		this.productTypesMaster = productTypesMaster;
	}

	public Set<ProductDosage> getProductDosages() {
		return this.productDosages;
	}

	public void setProductDosages(Set<ProductDosage> productDosages) {
		this.productDosages = productDosages;
	}

	public ProductDosage addProductDosage(ProductDosage productDosage) {
		getProductDosages().add(productDosage);
		productDosage.setProduct(this);

		return productDosage;
	}

	public ProductDosage removeProductDosage(ProductDosage productDosage) {
		getProductDosages().remove(productDosage);
		productDosage.setProduct(null);

		return productDosage;
	}

	public Set<RegimenConstituent> getRegimenConstituents() {
		return this.regimenConstituents;
	}

	public void setRegimenConstituents(Set<RegimenConstituent> regimenConstituents) {
		this.regimenConstituents = regimenConstituents;
	}

	public RegimenConstituent addRegimenConstituent(RegimenConstituent regimenConstituent) {
		getRegimenConstituents().add(regimenConstituent);
		regimenConstituent.setProduct(this);

		return regimenConstituent;
	}

	public RegimenConstituent removeRegimenConstituent(RegimenConstituent regimenConstituent) {
		getRegimenConstituents().remove(regimenConstituent);
		regimenConstituent.setProduct(null);

		return regimenConstituent;
	}

	public Set<ProductLabTypesMapping> getProductLabTypesMappings() {
		return this.productLabTypesMappings;
	}

	public void setProductLabTypesMappings(Set<ProductLabTypesMapping> productLabTypesMappings) {
		this.productLabTypesMappings = productLabTypesMappings;
	}

	public ProductLabTypesMapping addProductLabTypesMapping(ProductLabTypesMapping productLabTypesMapping) {
		getProductLabTypesMappings().add(productLabTypesMapping);
		productLabTypesMapping.setProduct(this);

		return productLabTypesMapping;
	}

	public ProductLabTypesMapping removeProductLabTypesMapping(ProductLabTypesMapping productLabTypesMapping) {
		getProductLabTypesMappings().remove(productLabTypesMapping);
		productLabTypesMapping.setProduct(null);

		return productLabTypesMapping;
	}

	public Set<FacilityStock> getFacilityStocks() {
		return this.facilityStocks;
	}

	public void setFacilityStocks(Set<FacilityStock> facilityStocks) {
		this.facilityStocks = facilityStocks;
	}

	public FacilityStock addFacilityStock(FacilityStock facilityStock) {
		getFacilityStocks().add(facilityStock);
		facilityStock.setProduct(this);

		return facilityStock;
	}

	public FacilityStock removeFacilityStock(FacilityStock facilityStock) {
		getFacilityStocks().remove(facilityStock);
		facilityStock.setProduct(null);

		return facilityStock;
	}

	public Set<FacilityStockTransferDetail> getFacilityStockTransferDetails() {
		return this.facilityStockTransferDetails;
	}

	public void setFacilityStockTransferDetails(Set<FacilityStockTransferDetail> facilityStockTransferDetails) {
		this.facilityStockTransferDetails = facilityStockTransferDetails;
	}

	public FacilityStockTransferDetail addFacilityStockTransferDetail(
			FacilityStockTransferDetail facilityStockTransferDetail) {
		getFacilityStockTransferDetails().add(facilityStockTransferDetail);
		facilityStockTransferDetail.setProduct(this);

		return facilityStockTransferDetail;
	}

	public FacilityStockTransferDetail removeFacilityStockTransferDetail(
			FacilityStockTransferDetail facilityStockTransferDetail) {
		getFacilityStockTransferDetails().remove(facilityStockTransferDetail);
		facilityStockTransferDetail.setProduct(null);

		return facilityStockTransferDetail;
	}

	public Set<ContractProduct> getContractProducts() {
		return this.contractProducts;
	}

	public void setContractProducts(Set<ContractProduct> contractProducts) {
		this.contractProducts = contractProducts;
	}

	public ContractProduct addContractProduct(ContractProduct contractProduct) {
		getContractProducts().add(contractProduct);
		contractProduct.setProduct(this);

		return contractProduct;
	}

	public ContractProduct removeContractProduct(ContractProduct contractProduct) {
		getContractProducts().remove(contractProduct);
		contractProduct.setProduct(null);

		return contractProduct;
	}

	public Set<SupplierStock> getSupplierStocks() {
		return this.supplierStocks;
	}

	public void setSupplierStocks(Set<SupplierStock> supplierStocks) {
		this.supplierStocks = supplierStocks;
	}

	public SupplierStock addSupplierStock(SupplierStock supplierStock) {
		getSupplierStocks().add(supplierStock);
		supplierStock.setProduct(this);

		return supplierStock;
	}

	public SupplierStock removeSupplierStock(SupplierStock supplierStock) {
		getSupplierStocks().remove(supplierStock);
		supplierStock.setProduct(null);

		return supplierStock;
	}

	public Set<FacilityReconciliation> getFacilityReconciliations() {
		return facilityReconciliations;
	}

	public void setFacilityReconciliations(Set<FacilityReconciliation> facilityReconciliations) {
		this.facilityReconciliations = facilityReconciliations;
	}

	public FacilityReconciliation addFacilityReconciliation(FacilityReconciliation facilityReconciliation) {
		getFacilityReconciliations().add(facilityReconciliation);
		facilityReconciliation.setProduct(this);

		return facilityReconciliation;
	}

	public FacilityReconciliation removeFacilityReconciliation(FacilityReconciliation facilityReconciliation) {
		getFacilityReconciliations().remove(facilityReconciliation);
		facilityReconciliation.setProduct(null);

		return facilityReconciliation;
	}

	public Set<IndentProduct> getIndentProducts() {
		return this.indentProducts;
	}

	public void setIndentProducts(Set<IndentProduct> indentProducts) {
		this.indentProducts = indentProducts;
	}

	public IndentProduct addIndentProduct(IndentProduct indentProduct) {
		getIndentProducts().add(indentProduct);
		indentProduct.setProduct(this);

		return indentProduct;
	}

	public IndentProduct removeIndentProduct(IndentProduct indentProduct) {
		getIndentProducts().remove(indentProduct);
		indentProduct.setProduct(null);

		return indentProduct;
	}

	public ProductCommodityTypeMaster getProductCommodityTypeMaster() {
		return productCommodityTypeMaster;
	}

	public void setProductCommodityTypeMaster(ProductCommodityTypeMaster productCommodityTypeMaster) {
		this.productCommodityTypeMaster = productCommodityTypeMaster;
	}

	public ProductDrugLineMaster getProductDrugLineMaster() {
		return productDrugLineMaster;
	}

	public void setProductDrugLineMaster(ProductDrugLineMaster productDrugLineMaster) {
		this.productDrugLineMaster = productDrugLineMaster;
	}

	public ProductRecipientTypeMaster getProductRecipientTypeMaster() {
		return productRecipientTypeMaster;
	}

	public void setProductRecipientTypeMaster(ProductRecipientTypeMaster productRecipientTypeMaster) {
		this.productRecipientTypeMaster = productRecipientTypeMaster;
	}

	public Set<FacilityStockDailyBalance> getFacilityStockDailyBalances() {
		return this.facilityStockDailyBalances;
	}

	public void setFacilityStockDailyBalances(Set<FacilityStockDailyBalance> facilityStockDailyBalances) {
		this.facilityStockDailyBalances = facilityStockDailyBalances;
	}

	public FacilityStockDailyBalance addFacilityStockDailyBalance(FacilityStockDailyBalance facilityStockDailyBalance) {
		getFacilityStockDailyBalances().add(facilityStockDailyBalance);
		facilityStockDailyBalance.setProduct(this);

		return facilityStockDailyBalance;
	}

	public FacilityStockDailyBalance removeFacilityStockDailyBalance(
			FacilityStockDailyBalance facilityStockDailyBalance) {
		getFacilityStockDailyBalances().remove(facilityStockDailyBalance);
		facilityStockDailyBalance.setProduct(null);

		return facilityStockDailyBalance;
	}

	public Set<ArtDispensationItem> getArtDispensationItems() {
		return artDispensationItems;
	}

	public void setArtDispensationItems(Set<ArtDispensationItem> artDispensationItems) {
		this.artDispensationItems = artDispensationItems;
	}

	public ArtDispensationItem addArtDispensationItem(ArtDispensationItem artDispensationItem) {
		getArtDispensationItems().add(artDispensationItem);
		artDispensationItem.setProduct(this);

		return artDispensationItem;
	}

	public ArtDispensationItem removeArtDispensationItem(ArtDispensationItem artDispensationItem) {
		getArtDispensationItems().remove(artDispensationItem);
		artDispensationItem.setProduct(null);
		return artDispensationItem;
	}

	public Set<ArtPepDispensationItem> getArtPepDispensationItems() {
		return this.artPepDispensationItems;
	}

	public void setArtPepDispensationItems(Set<ArtPepDispensationItem> artPepDispensationItems) {
		this.artPepDispensationItems = artPepDispensationItems;
	}

	public ArtPepDispensationItem addArtPepDispensationItem(ArtPepDispensationItem artPepDispensationItem) {
		getArtPepDispensationItems().add(artPepDispensationItem);
		artPepDispensationItem.setProduct(this);

		return artPepDispensationItem;
	}

	public ArtPepDispensationItem removeArtPepDispensationItem(ArtPepDispensationItem artPepDispensationItem) {
		getArtPepDispensationItems().remove(artPepDispensationItem);
		artPepDispensationItem.setProduct(null);

		return artPepDispensationItem;
	}

	public Set<ProductFacilityTypeMapping> getProductFacilityTypeMappings() {
		return productFacilityTypeMappings;
	}

	public void setProductFacilityTypeMappings(Set<ProductFacilityTypeMapping> productFacilityTypeMappings) {
		this.productFacilityTypeMappings = productFacilityTypeMappings;
	}

}