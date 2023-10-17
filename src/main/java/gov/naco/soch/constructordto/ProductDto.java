package gov.naco.soch.constructordto;

import java.time.LocalDate;

public class ProductDto {

	private Long id;
	private byte[] productImage;
	private String productName;
	private String productCode;
	private String batchNo;
	private Double currentQuantity;
	private Double dispensedQuantity;
	private Long receivedQuantity;
	private Long damagedQuantity;
	private LocalDate mfgDate;
	private LocalDate expiryDate;
	private Integer numberOfBoxes;
	private Double expiredQuantity;

	public ProductDto(Long id, String productName, String batchNo, Double currentQuantity, Double dispensedQuantity,
			LocalDate mfgDate, LocalDate expiryDate, Integer numberOfBoxes, byte[] productImage) {
		super();
		this.id = id;
		this.productName = productName;
		this.currentQuantity = currentQuantity;
		this.batchNo = batchNo;
		this.dispensedQuantity = dispensedQuantity;
		this.mfgDate = mfgDate;
		this.expiryDate = expiryDate;
		this.numberOfBoxes = numberOfBoxes;
		this.productImage = productImage;

	}

	public ProductDto(Long id, String productName, String productCode, Double currentQuantity, Double expiredQuantity,byte[] productImage) {
		super();
		this.id = id;
		this.productName = productName;
		this.productCode = productCode;
		this.currentQuantity = currentQuantity;
		this.expiredQuantity = expiredQuantity;
		this.productImage = productImage;

	}
	
	public ProductDto(Long id, String productName, String productCode,String batchNumber,LocalDate manufacturingDate, LocalDate expiredDate, Double currentQuantity) {
		super();
		this.id = id;
		this.productName = productName;
		this.productCode = productCode;
		this.mfgDate = manufacturingDate;
		this.batchNo = batchNumber;
		this.expiryDate = expiredDate;
		this.currentQuantity = currentQuantity;
	}

	public ProductDto() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
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

	public Long getReceivedQuantity() {
		return receivedQuantity;
	}

	public void setReceivedQuantity(Long receivedQuantity) {
		this.receivedQuantity = receivedQuantity;
	}

	public byte[] getProductImage() {
		return productImage;
	}

	public void setProductImage(byte[] productImage) {
		this.productImage = productImage;
	}

	public Long getDamagedQuantity() {
		return damagedQuantity;
	}

	public void setDamagedQuantity(Long damagedQuantity) {
		this.damagedQuantity = damagedQuantity;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public Double getCurrentQuantity() {
		return currentQuantity;
	}

	public void setCurrentQuantity(Double currentQuantity) {
		this.currentQuantity = currentQuantity;
	}

	public Double getDispensedQuantity() {
		return dispensedQuantity;
	}

	public void setDispensedQuantity(Double dispensedQuantity) {
		this.dispensedQuantity = dispensedQuantity;
	}

	public LocalDate getMfgDate() {
		return mfgDate;
	}

	public void setMfgDate(LocalDate mfgDate) {
		this.mfgDate = mfgDate;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Integer getNumberOfBoxes() {
		return numberOfBoxes;
	}

	public void setNumberOfBoxes(Integer numberOfBoxes) {
		this.numberOfBoxes = numberOfBoxes;
	}

	public Double getExpiredQuantity() {
		return expiredQuantity;
	}

	public void setExpiredQuantity(Double expiredQuantity) {
		this.expiredQuantity = expiredQuantity;
	}

}
