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
 * The persistent class for the contract_product_schedule database table.
 * 
 */
@Entity
@GenericGenerator(name = "contract_product_schedule", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "contract_product_schedule_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Table(name = "contract_product_schedule")
@NamedQuery(name = "ContractProductSchedule.findAll", query = "SELECT c FROM ContractProductSchedule c")
public class ContractProductSchedule extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "contract_product_schedule")
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

	// bi-directional many-to-one association to ContractProduct
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contract_product_id")
	private ContractProduct contractProduct;

	// bi-directional many-to-one association to ContractProductScheduleSac
	@OneToMany(mappedBy = "contractProductSchedule", cascade = CascadeType.ALL)
	private Set<ContractProductScheduleSac> contractProductScheduleSacs;

	// bi-directional many-to-one association to Dispatch
	@OneToMany(mappedBy = "contractProductSchedule", cascade = CascadeType.ALL)
	private Set<Dispatch> dispatches;

	public ContractProductSchedule() {
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

	public ContractProduct getContractProduct() {
		return this.contractProduct;
	}

	public void setContractProduct(ContractProduct contractProduct) {
		this.contractProduct = contractProduct;
	}

	public Set<ContractProductScheduleSac> getContractProductScheduleSacs() {
		return this.contractProductScheduleSacs;
	}

	public void setContractProductScheduleSacs(Set<ContractProductScheduleSac> contractProductScheduleSacs) {
		this.contractProductScheduleSacs = contractProductScheduleSacs;
	}

	public ContractProductScheduleSac addContractProductScheduleSac(
			ContractProductScheduleSac contractProductScheduleSac) {
		getContractProductScheduleSacs().add(contractProductScheduleSac);
		contractProductScheduleSac.setContractProductSchedule(this);

		return contractProductScheduleSac;
	}

	public ContractProductScheduleSac removeContractProductScheduleSac(
			ContractProductScheduleSac contractProductScheduleSac) {
		getContractProductScheduleSacs().remove(contractProductScheduleSac);
		contractProductScheduleSac.setContractProductSchedule(null);

		return contractProductScheduleSac;
	}

	public Set<Dispatch> getDispatches() {
		return this.dispatches;
	}

	public void setDispatches(Set<Dispatch> dispatches) {
		this.dispatches = dispatches;
	}

	public Dispatch addDispatch(Dispatch dispatch) {
		getDispatches().add(dispatch);
		dispatch.setContractProductSchedule(this);

		return dispatch;
	}

	public Dispatch removeDispatch(Dispatch dispatch) {
		getDispatches().remove(dispatch);
		dispatch.setContractProductSchedule(null);

		return dispatch;
	}

}