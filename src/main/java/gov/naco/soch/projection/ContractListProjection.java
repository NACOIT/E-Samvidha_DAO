package gov.naco.soch.projection;

import java.math.BigInteger;
import java.sql.Timestamp;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;

@SqlResultSetMapping(name = "AuthorValueMapping", classes = @ConstructorResult(targetClass = ContractListProjection.class, columns = {
		@ColumnResult(name = "productname"), @ColumnResult(name = "indentnumber"),
		@ColumnResult(name = "contractstatus"), @ColumnResult(name = "allotmentdate", type = Timestamp.class),
		@ColumnResult(name = "id", type = Integer.class), @ColumnResult(name = "count", type = BigInteger.class),
		@ColumnResult(name = "suppliername") }))
public class ContractListProjection {

	private Integer id;
	private String noanumber;
	private String indentnumber;
	private Timestamp allotmentdate;
	private String contractstatus;
	private String suppliername;
	private String productname;
	private BigInteger count;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNoanumber() {
		return noanumber;
	}

	public void setNoanumber(String noanumber) {
		this.noanumber = noanumber;
	}

	public String getIndentnumber() {
		return indentnumber;
	}

	public void setIndentnumber(String indentnumber) {
		this.indentnumber = indentnumber;
	}

	public Timestamp getAllotmentdate() {
		return allotmentdate;
	}

	public void setAllotmentdate(Timestamp allotmentdate) {
		this.allotmentdate = allotmentdate;
	}

	public String getContractstatus() {
		return contractstatus;
	}

	public void setContractstatus(String contractstatus) {
		this.contractstatus = contractstatus;
	}

	public String getSuppliername() {
		return suppliername;
	}

	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public BigInteger getCount() {
		return count;
	}

	public void setCount(BigInteger count) {
		this.count = count;
	}

}
