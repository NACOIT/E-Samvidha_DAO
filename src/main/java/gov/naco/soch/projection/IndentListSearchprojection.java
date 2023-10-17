package gov.naco.soch.projection;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;

@SqlResultSetMapping(name = "AuthorValueMapping", classes = @ConstructorResult(targetClass = IndentListSearchprojection.class, columns = {
		@ColumnResult(name = "productname"), @ColumnResult(name = "indentnumber"), @ColumnResult(name = "indentstatus"),
		@ColumnResult(name = "indentdate", type = Date.class), @ColumnResult(name = "indentid", type = Integer.class),
		@ColumnResult(name = "count", type = BigInteger.class), @ColumnResult(name = "procurementagentname"),
		@ColumnResult(name = "indentstatusid", type = Integer.class),
		@ColumnResult(name = "procurementagentid", type = Integer.class) }))
public class IndentListSearchprojection {

	private Integer indentid;

	private BigInteger count;

	private String indentnumber;

	private Date indentdate;

	private Integer indentstatusid;

	private String indentstatus;

	private Integer procurementagentid;

	private String procurementagentname;

	private String productname;

	public Integer getIndentid() {
		return indentid;
	}

	public void setIndentid(Integer indentid) {
		this.indentid = indentid;
	}

	public String getIndentnumber() {
		return indentnumber;
	}

	public void setIndentnumber(String indentnumber) {
		this.indentnumber = indentnumber;
	}

	public Date getIndentdate() {
		return indentdate;
	}

	public void setIndentdate(Date indentdate) {
		this.indentdate = indentdate;
	}

	public Integer getIndentstatusid() {
		return indentstatusid;
	}

	public void setIndentstatusid(Integer indentstatusid) {
		this.indentstatusid = indentstatusid;
	}

	public String getIndentstatus() {
		return indentstatus;
	}

	public void setIndentstatus(String indentstatus) {
		this.indentstatus = indentstatus;
	}

	public Integer getProcurementagentid() {
		return procurementagentid;
	}

	public void setProcurementagentid(Integer procurementagentid) {
		this.procurementagentid = procurementagentid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProcurementagentname() {
		return procurementagentname;
	}

	public void setProcurementagentname(String procurementagentname) {
		this.procurementagentname = procurementagentname;
	}

	public BigInteger getCount() {
		return count;
	}

	public void setCount(BigInteger count) {
		this.count = count;
	}

}
