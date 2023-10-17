package gov.naco.soch.projection;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;

@SqlResultSetMapping(name = "AuthorValueMapping", classes = @ConstructorResult(targetClass = ProductSearchProjection.class, columns = {
		@ColumnResult(name = "productid", type = Integer.class), @ColumnResult(name = "productname"),
		@ColumnResult(name = "productcode"), @ColumnResult(name = "productimage", type = byte[].class),
		@ColumnResult(name = "uomid", type = Integer.class), @ColumnResult(name = "uomname"),
		@ColumnResult(name = "status", type = Boolean.class),@ColumnResult(name = "facilitytype") }))
public class ProductSearchProjection {

	private Integer productid;
	private String productname;
	private byte[] productimage;
	private String productcode;
	private Integer uomid;
	private String uomname;
	private Boolean status;
	private String facilitytype;

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public byte[] getProductimage() {
		return productimage;
	}

	public void setProductimage(byte[] productimage) {
		this.productimage = productimage;
	}

	public String getProductcode() {
		return productcode;
	}

	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}

	public Integer getUomid() {
		return uomid;
	}

	public void setUomid(Integer uomid) {
		this.uomid = uomid;
	}

	public String getUomname() {
		return uomname;
	}

	public void setUomname(String uomname) {
		this.uomname = uomname;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getFacilitytype() {
		return facilitytype;
	}

	public void setFacilitytype(String facilitytype) {
		this.facilitytype = facilitytype;
	}



}
