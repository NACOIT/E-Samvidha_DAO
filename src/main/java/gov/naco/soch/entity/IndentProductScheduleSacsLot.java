package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the indent_product_scedule_sacs_lot database table.
 * 
 */
@Entity
@GenericGenerator(name = "indent_product_schedule_sacs_lot", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "indent_product_schedule_sacs_lot_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Table(name = "indent_product_schedule_sacs_lot")
@NamedQuery(name = "IndentProductScheduleSacsLot.findAll", query = "SELECT i FROM IndentProductScheduleSacsLot i")
public class IndentProductScheduleSacsLot extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "indent_product_schedule_sacs_lot")
	private Long id;

	@Column(name = "end_date")
	private LocalDate endDate;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "lot_number")
	private String lotNumber;

	private Long quantity;

	@Column(name = "start_date")
	private LocalDate startDate;

	// bi-directional many-to-one association to IndentProductScheduleSac
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "indent_product_scedule_sacs_id")
	private IndentProductScheduleSac indentProductScheduleSac;

	public IndentProductScheduleSacsLot() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getEndDate() {
		return this.endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
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

	public String getLotNumber() {
		return this.lotNumber;
	}

	public void setLotNumber(String lotNumber) {
		this.lotNumber = lotNumber;
	}

	public Long getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public LocalDate getStartDate() {
		return this.startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public IndentProductScheduleSac getIndentProductScheduleSac() {
		return this.indentProductScheduleSac;
	}

	public void setIndentProductScheduleSac(IndentProductScheduleSac indentProductScheduleSac) {
		this.indentProductScheduleSac = indentProductScheduleSac;
	}

}