package gov.naco.soch.projection;

import java.time.LocalDate;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;

@SqlResultSetMapping(name = "AuthorValueMapping", classes = @ConstructorResult(targetClass = UnregisteredSourceReceiptHistoryProjection.class, columns = {
		@ColumnResult(name = "unregsourceindentnumber"), @ColumnResult(name = "receiptstatus"),
		@ColumnResult(name = "grnstatus"), @ColumnResult(name = "receiptid", type = Integer.class),
		@ColumnResult(name = "address"), @ColumnResult(name = "sourcename"),
		@ColumnResult(name = "receiptdate", type = LocalDate.class) }))
public class UnregisteredSourceReceiptHistoryProjection {

	private String unregsourceindentnumber;

	private String receiptstatus;

	private String grnstatus;

	private Integer receiptid;

	private String address;

	private String sourcename;

	private LocalDate receiptdate;

	public String getReceiptstatus() {
		return receiptstatus;
	}

	public void setReceiptstatus(String receiptstatus) {
		this.receiptstatus = receiptstatus;
	}

	public String getGrnstatus() {
		return grnstatus;
	}

	public void setGrnstatus(String grnstatus) {
		this.grnstatus = grnstatus;
	}

	public Integer getReceiptid() {
		return receiptid;
	}

	public void setReceiptid(Integer receiptid) {
		this.receiptid = receiptid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSourcename() {
		return sourcename;
	}

	public void setSourcename(String sourcename) {
		this.sourcename = sourcename;
	}

	public LocalDate getReceiptdate() {
		return receiptdate;
	}

	public String getUnregsourceindentnumber() {
		return unregsourceindentnumber;
	}

	public void setUnregsourceindentnumber(String unregsourceindentnumber) {
		this.unregsourceindentnumber = unregsourceindentnumber;
	}

	public void setReceiptdate(LocalDate receiptdate) {
		this.receiptdate = receiptdate;
	}

}
