package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;
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

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the contract database table.
 * 
 */
@Entity
@GenericGenerator(name = "contract", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "contract_contract_id_seq"), @Parameter(name = "increment_size", value = "1"),
		@Parameter(name = "optimizer", value = "hilo") })
@NamedQuery(name = "Contract.findAll", query = "SELECT c FROM Contract c")
public class Contract extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "contract")
	@Column(name = "contract_id")
	private Long contractId;

	@Column(name = "allotment_date")
	private LocalDate allotmentDate;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "noa_number")
	private String noaNumber;

	@Column(name = "indent_num")
	private String indentNum;

	// bi-directional many-to-one association to Supplier
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "supplier_id")
	private Facility facility;

	// bi-directional many-to-one association to ContractProduct
	@OneToMany( mappedBy = "contract", cascade = CascadeType.ALL)
	private Set<ContractProduct> contractProducts;

	// bi-directional many-to-one association to Dispatch
	@OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
	private Set<Dispatch> dispatches;

	// bi-directional many-to-one association to ContractStatusMaster
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contract_status_id")
	private ContractStatusMaster contractStatusMaster;

	// bi-directional many-to-one association to ContractStatusTracking
	@OneToMany(mappedBy = "contract")
	private Set<ContractStatusTracking> contractStatusTrackings;

	public Contract() {
	}

	public Long getContractId() {
		return this.contractId;
	}

	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}

	public LocalDate getAllotmentDate() {
		return this.allotmentDate;
	}

	public void setAllotmentDate(LocalDate allotmentDate) {
		this.allotmentDate = allotmentDate;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
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

	public String getNoaNumber() {
		return this.noaNumber;
	}

	public void setNoaNumber(String noaNumber) {
		this.noaNumber = noaNumber;
	}

	public Set<ContractProduct> getContractProducts() {
		return this.contractProducts;
	}

	public void setContractProducts(Set<ContractProduct> contractProducts) {
		this.contractProducts = contractProducts;
	}

	public ContractProduct addContractProduct(ContractProduct contractProduct) {
		getContractProducts().add(contractProduct);
		contractProduct.setContract(this);

		return contractProduct;
	}

	public ContractProduct removeContractProduct(ContractProduct contractProduct) {
		getContractProducts().remove(contractProduct);
		contractProduct.setContract(null);

		return contractProduct;
	}

	public Set<Dispatch> getDispatches() {
		return this.dispatches;
	}

	public void setDispatches(Set<Dispatch> dispatches) {
		this.dispatches = dispatches;
	}

	public Dispatch addDispatch(Dispatch dispatch) {
		getDispatches().add(dispatch);
		dispatch.setContract(this);

		return dispatch;
	}

	public Dispatch removeDispatch(Dispatch dispatch) {
		getDispatches().remove(dispatch);
		dispatch.setContract(null);

		return dispatch;
	}

	public ContractStatusMaster getContractStatusMaster() {
		return contractStatusMaster;
	}

	public void setContractStatusMaster(ContractStatusMaster contractStatusMaster) {
		this.contractStatusMaster = contractStatusMaster;
	}

	public Set<ContractStatusTracking> getContractStatusTrackings() {
		return this.contractStatusTrackings;
	}

	public void setContractStatusTrackings(Set<ContractStatusTracking> contractStatusTrackings) {
		this.contractStatusTrackings = contractStatusTrackings;
	}

	public ContractStatusTracking addContractStatusTracking(ContractStatusTracking contractStatusTracking) {
		getContractStatusTrackings().add(contractStatusTracking);
		contractStatusTracking.setContract(this);

		return contractStatusTracking;
	}

	public String getIndentNum() {
		return indentNum;
	}

	public void setIndentNum(String indentNum) {
		this.indentNum = indentNum;
	}

	public ContractStatusTracking removeContractStatusTracking(ContractStatusTracking contractStatusTracking) {
		getContractStatusTrackings().remove(contractStatusTracking);
		contractStatusTracking.setContract(null);

		return contractStatusTracking;
	}

}