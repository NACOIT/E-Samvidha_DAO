package gov.naco.soch.constructordto;

public class ProductReviewDto {

    private Long id;

    private String productName;

    private String batchNumber;

    private Integer availableQty;

    private Integer dispenseQty;

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

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public Integer getAvailableQty() {
        return availableQty;
    }

    public void setAvailableQty(Integer availableQty) {
        this.availableQty = availableQty;
    }

    public Integer getDispenseQty() {
        return dispenseQty;
    }

    public void setDispenseQty(Integer dispenseQty) {
        this.dispenseQty = dispenseQty;
    }
}
