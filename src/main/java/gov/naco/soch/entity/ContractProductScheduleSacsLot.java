package gov.naco.soch.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the contract_product_scedule_sacs_lot database
 * table.
 * 
 */
@Entity
@GenericGenerator(name = "contract_product_schedule_sacs_lot", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "contract_product_schedule_sacs_lot_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Table(name = "contract_product_schedule_sacs_lot")
@NamedQuery(name = "ContractProductScheduleSacsLot.findAll", query = "SELECT c FROM ContractProductScheduleSacsLot c")
public class ContractProductScheduleSacsLot extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "contract_product_schedule_sacs_lot")
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name = "end_date")
	private Date endDate;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	private Long quantity;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "lot_number")
	private String lotNumber;

	// bi-directional many-to-one association to ContractProductScheduleSac
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "contract_product_scedule_sacs_id")
	private ContractProductScheduleSac contractProductScheduleSac;

	// bi-directional many-to-one association to Dispatch
	@OneToMany(mappedBy = "contractProductSceduleSacsLot", cascade = CascadeType.ALL)
	private Set<Dispatch> dispatches;

	public ContractProductScheduleSacsLot() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
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

	public Long getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public ContractProductScheduleSac getContractProductScheduleSac() {
		return this.contractProductScheduleSac;
	}

	public void setContractProductScheduleSac(ContractProductScheduleSac contractProductScheduleSac) {
		this.contractProductScheduleSac = contractProductScheduleSac;
	}

	public Set<Dispatch> getDispatches() {
		return this.dispatches;
	}

	public void setDispatches(Set<Dispatch> dispatches) {
		this.dispatches = dispatches;
	}

	public Dispatch addDispatch(Dispatch dispatch) {
		getDispatches().add(dispatch);
		dispatch.setContractProductSceduleSacsLot(this);

		return dispatch;
	}

	public Dispatch removeDispatch(Dispatch dispatch) {
		getDispatches().remove(dispatch);
		dispatch.setContractProductSceduleSacsLot(null);

		return dispatch;
	}

	public String getLotNumber() {
		return lotNumber;
	}

	public void setLotNumber(String lotNumber) {
		this.lotNumber = lotNumber;
	}

}