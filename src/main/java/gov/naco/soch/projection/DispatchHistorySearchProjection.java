package gov.naco.soch.projection;

import java.math.BigInteger;
import java.sql.Timestamp;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;

@SqlResultSetMapping(name = "AuthorValueMapping", classes = @ConstructorResult(targetClass = DispatchHistorySearchProjection.class, columns = {
		@ColumnResult(name = "stnnumber"), @ColumnResult(name = "invoicenumber"), @ColumnResult(name = "productname"),
		@ColumnResult(name = "lotnumber"), @ColumnResult(name = "consignmentstatus"),
		@ColumnResult(name = "dispatchstatus"), @ColumnResult(name = "noanumber"), @ColumnResult(name = "consignee"),
		@ColumnResult(name = "quantity", type = BigInteger.class),
		@ColumnResult(name = "invoicedate", type = Timestamp.class),
		@ColumnResult(name = "consignorid", type = Long.class), @ColumnResult(name = "consignorname"),
		@ColumnResult(name = "dispatchid", type = Integer.class) }))
public class DispatchHistorySearchProjection {

	private Integer dispatchid;
	private String stnnumber;
	private String invoicenumber;
	private Timestamp invoicedate;
	private Long consignorid;
	private String consignorname;

	private String productname;
	private String lotnumber;
	private String consignmentstatus;
	private String dispatchstatus;
	private String noanumber;
	private BigInteger quantity;
	private String consignee;

	public Integer getDispatchid() {
		return dispatchid;
	}

	public void setDispatchid(Integer dispatchid) {
		this.dispatchid = dispatchid;
	}

	public String getStnnumber() {
		return stnnumber;
	}

	public void setStnnumber(String stnnumber) {
		this.stnnumber = stnnumber;
	}

	public String getInvoicenumber() {
		return invoicenumber;
	}

	public void setInvoicenumber(String invoicenumber) {
		this.invoicenumber = invoicenumber;
	}

	public Timestamp getInvoicedate() {
		return invoicedate;
	}

	public void setInvoicedate(Timestamp invoicedate) {
		this.invoicedate = invoicedate;
	}

	public Long getConsignorid() {
		return consignorid;
	}

	public void setConsignorid(Long consignorid) {
		this.consignorid = consignorid;
	}

	public String getConsignorname() {
		return consignorname;
	}

	public void setConsignorname(String consignorname) {
		this.consignorname = consignorname;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getLotnumber() {
		return lotnumber;
	}

	public void setLotnumber(String lotnumber) {
		this.lotnumber = lotnumber;
	}

	public String getConsignmentstatus() {
		return consignmentstatus;
	}

	public void setConsignmentstatus(String consignmentstatus) {
		this.consignmentstatus = consignmentstatus;
	}

	public String getDispatchstatus() {
		return dispatchstatus;
	}

	public void setDispatchstatus(String dispatchstatus) {
		this.dispatchstatus = dispatchstatus;
	}

	public String getNoanumber() {
		return noanumber;
	}

	public void setNoanumber(String noanumber) {
		this.noanumber = noanumber;
	}

	public BigInteger getQuantity() {
		return quantity;
	}

	public void setQuantity(BigInteger quantity) {
		this.quantity = quantity;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

}
