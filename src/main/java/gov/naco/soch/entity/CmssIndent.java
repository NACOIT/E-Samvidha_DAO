package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the cmss_indents database table.
 * 
 */
@Entity
@GenericGenerator(name = "cmss_indents", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "cmss_indents_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Table(name = "cmss_indents")
@NamedQuery(name = "CmssIndent.findAll", query = "SELECT c FROM CmssIndent c")
public class CmssIndent extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "cmss_indents")
	private Long id;

	@Column(name = "cmss_product_name")
	private String cmssProductName;

	
	@Column(name = "indent_date")
	private LocalDate indentDate;

	@Column(name = "indent_no")
	private String indentNo;

	@Column(name = "indent_qty")
	private Long indentQty;

	@Column(name = "indent_store")
	private String indentStore;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "issuing_store")
	private String issuingStore;

	@Column(name = "product_code")
	private String productCode;

	@Column(name = "product_name")
	private String productName;

	// bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name = "sacs_id")
	private Facility facility;

	public CmssIndent() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCmssProductName() {
		return this.cmssProductName;
	}

	public void setCmssProductName(String cmssProductName) {
		this.cmssProductName = cmssProductName;
	}

	public Long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public LocalDate getIndentDate() {
		return this.indentDate;
	}

	public void setIndentDate(LocalDate indentDate) {
		this.indentDate = indentDate;
	}

	public String getIndentNo() {
		return this.indentNo;
	}

	public void setIndentNo(String indentNo) {
		this.indentNo = indentNo;
	}

	public Long getIndentQty() {
		return this.indentQty;
	}

	public void setIndentQty(Long indentQty) {
		this.indentQty = indentQty;
	}

	public String getIndentStore() {
		return this.indentStore;
	}

	public void setIndentStore(String indentStore) {
		this.indentStore = indentStore;
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

	public String getIssuingStore() {
		return this.issuingStore;
	}

	public void setIssuingStore(String issuingStore) {
		this.issuingStore = issuingStore;
	}

	public String getProductCode() {
		return this.productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

}