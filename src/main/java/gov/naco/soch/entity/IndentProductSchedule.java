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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the indent_product_schedule database table.
 * 
 */
@Entity
@GenericGenerator(name = "indent_product_schedule", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "indent_product_schedule_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Table(name = "indent_product_schedule")
@NamedQuery(name = "IndentProductSchedule.findAll", query = "SELECT i FROM IndentProductSchedule i")
public class IndentProductSchedule extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "indent_product_schedule")
	private Long id;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	private Long quantity;

	@Column(name = "schedule_number")
	private String scheduleNumber;

	@Column(name = "unit_price")
	private Double unitPrice;

	// bi-directional many-to-one association to IndentProduct
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "indent_product_id")
	private IndentProduct indentProduct;

	// bi-directional many-to-one association to IndentProductScheduleSac
	@OneToMany(mappedBy = "indentProductSchedule", cascade = CascadeType.ALL)
	private Set<IndentProductScheduleSac> indentProductScheduleSacs;

	public IndentProductSchedule() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public String getScheduleNumber() {
		return this.scheduleNumber;
	}

	public void setScheduleNumber(String scheduleNumber) {
		this.scheduleNumber = scheduleNumber;
	}

	public Double getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public IndentProduct getIndentProduct() {
		return this.indentProduct;
	}

	public void setIndentProduct(IndentProduct indentProduct) {
		this.indentProduct = indentProduct;
	}

	public Set<IndentProductScheduleSac> getIndentProductScheduleSacs() {
		return this.indentProductScheduleSacs;
	}

	public void setIndentProductScheduleSacs(Set<IndentProductScheduleSac> indentProductScheduleSacs) {
		this.indentProductScheduleSacs = indentProductScheduleSacs;
	}

	public IndentProductScheduleSac addIndentProductScheduleSac(IndentProductScheduleSac indentProductScheduleSac) {
		getIndentProductScheduleSacs().add(indentProductScheduleSac);
		indentProductScheduleSac.setIndentProductSchedule(this);

		return indentProductScheduleSac;
	}

	public IndentProductScheduleSac removeIndentProductScheduleSac(IndentProductScheduleSac indentProductScheduleSac) {
		getIndentProductScheduleSacs().remove(indentProductScheduleSac);
		indentProductScheduleSac.setIndentProductSchedule(null);

		return indentProductScheduleSac;
	}

}