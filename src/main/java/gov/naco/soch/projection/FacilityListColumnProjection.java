package gov.naco.soch.projection;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;

@SqlResultSetMapping(name = "AuthorValueMapping", classes = @ConstructorResult(targetClass = FacilityListColumnProjection.class, columns = {
		@ColumnResult(name = "facilityid", type = Integer.class), @ColumnResult(name = "userid", type = Integer.class),
		@ColumnResult(name = "code"), @ColumnResult(name = "facilityname"),
		@ColumnResult(name = "noa", type = BigInteger.class), @ColumnResult(name = "product"),
		@ColumnResult(name = "procurementagent"), @ColumnResult(name = "firstname"), @ColumnResult(name = "email"),
		@ColumnResult(name = "mobilenumber"), @ColumnResult(name = "state"),
		@ColumnResult(name = "createdtime", type = Timestamp.class), @ColumnResult(name = "facilitytype"),
		@ColumnResult(name = "nationalid"), @ColumnResult(name = "machine"),
		@ColumnResult(name = "status", type = Boolean.class),
		@ColumnResult(name = "mappedfacilitycount", type = BigInteger.class),
		@ColumnResult(name = "islab", type = Boolean.class), @ColumnResult(name = "district"),
		@ColumnResult(name = "subdistrictname"),
		@ColumnResult(name = "workingsince", type = Timestamp.class), @ColumnResult(name = "darpannumber"), @ColumnResult(name = "approvalstatus", type = Long.class),
		@ColumnResult(name = "pannumber"),@ColumnResult(name = "bankaccountno"),@ColumnResult(name = "bankid", type = Integer.class),
		@ColumnResult(name = "cnano"),@ColumnResult(name = "ngotype", type = Integer.class)
	}))
public class FacilityListColumnProjection {

	private Integer facilityid;
	private Integer userid;
	private String code;
	private String facilityname;
	private BigInteger noa;
	private String product;
	private String procurementagent;
	private String firstname;
	private String email;
	private String mobilenumber;
	private String state;
	private Timestamp createdtime;
	private String facilitytype;;
	private String nationalid;
	private String machine;
	private Boolean status;
	private BigInteger mappedfacilitycount;
	private Boolean islab;
	private String subdistrictname;
	private String district;
	private String darpannumber;
	private String pannumber;
	private String bankaccountno;
	private Long bankid;
	private String cnano;
	private Timestamp workingsince;
	private Long ngotype;
	private Long approvalstatus;
	private Boolean isBlackList;
	

	public Boolean getIsBlackList() {
		return isBlackList;
	}

	public void setIsBlackList(Boolean isBlackList) {
		this.isBlackList = isBlackList;
	}

	public Integer getFacilityid() {
		return facilityid;
	}

	public void setFacilityid(Integer facilityid) {
		this.facilityid = facilityid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFacilityname() {
		return facilityname;
	}

	public void setFacilityname(String facilityname) {
		this.facilityname = facilityname;
	}

	public BigInteger getNoa() {
		return noa;
	}

	public void setNoa(BigInteger noa) {
		this.noa = noa;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getProcurementagent() {
		return procurementagent;
	}

	public void setProcurementagent(String procurementagent) {
		this.procurementagent = procurementagent;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Timestamp getCreatedtime() {
		return createdtime;
	}

	public void setCreatedtime(Timestamp createdtime) {
		this.createdtime = createdtime;
	}

	public String getFacilitytype() {
		return facilitytype;
	}

	public void setFacilitytype(String facilitytype) {
		this.facilitytype = facilitytype;
	}

	public String getNationalid() {
		return nationalid;
	}

	public void setNationalid(String nationalid) {
		this.nationalid = nationalid;
	}

	public String getMachine() {
		return machine;
	}

	public void setMachine(String machine) {
		this.machine = machine;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public BigInteger getMappedfacilitycount() {
		return mappedfacilitycount;
	}

	public void setMappedfacilitycount(BigInteger mappedfacilitycount) {
		this.mappedfacilitycount = mappedfacilitycount;
	}

	public Boolean getIslab() {
		return islab;
	}

	public void setIslab(Boolean islab) {
		this.islab = islab;
	}

	public String getSubdistrictname() {
		return subdistrictname;
	}

	public void setSubdistrictname(String subdistrictname) {
		this.subdistrictname = subdistrictname;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getDarpannumber() {
		return darpannumber;
	}

	public void setDarpannumber(String darpannumber) {
		this.darpannumber = darpannumber;
	}

	public String getPannumber() {
		return pannumber;
	}

	public void setPannumber(String pannumber) {
		this.pannumber = pannumber;
	}

	public String getBankaccountno() {
		return bankaccountno;
	}

	public void setBankaccountno(String bankaccountno) {
		this.bankaccountno = bankaccountno;
	}

	public Long getBankid() {
		return bankid;
	}

	public void setBankid(Long bankid) {
		this.bankid = bankid;
	}

	public String getCnano() {
		return cnano;
	}

	public void setCnano(String cnano) {
		this.cnano = cnano;
	}

	public Timestamp getWorkingsince() {
		return workingsince;
	}

	public void setWorkingsince(Timestamp workingsince) {
		this.workingsince = workingsince;
	}

	public Long getNgotype() {
		return ngotype;
	}

	public void setNgotype(Long ngotype) {
		this.ngotype = ngotype;
	}

	public Long getApprovalstatus() {
		return approvalstatus;
	}

	public void setApprovalstatus(Long approvalstatus) {
		this.approvalstatus = approvalstatus;
	}

	@Override
	public String toString() {
		return "FacilityListColumnProjection [facilityid=" + facilityid + ", userid=" + userid + ", code=" + code
				+ ", facilityname=" + facilityname + ", noa=" + noa + ", product=" + product + ", procurementagent="
				+ procurementagent + ", firstname=" + firstname + ", email=" + email + ", mobilenumber=" + mobilenumber
				+ ", state=" + state + ", createdtime=" + createdtime + ", facilitytype=" + facilitytype
				+ ", nationalid=" + nationalid + ", machine=" + machine + ", status=" + status
				+ ", mappedfacilitycount=" + mappedfacilitycount + ", islab=" + islab + ", subdistrictname="
				+ subdistrictname + ", district=" + district + ", darpannumber=" + darpannumber + ", pannumber="
				+ pannumber + ", bankaccountno=" + bankaccountno + ", bankid=" + bankid + ", cnano=" + cnano
				+ ", workingsince=" + workingsince + ", ngotype=" + ngotype + ", approvalstatus=" + approvalstatus
				+ ", isBlackList=" + isBlackList + "]";
	}

}
