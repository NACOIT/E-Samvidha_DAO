package gov.naco.soch.entity;

import java.io.Serializable;

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
 * The persistent class for the contract_status_tracking database table.
 * 
 */
@Entity
@GenericGenerator(name = "contract_status_tracking", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "contract_status_tracking_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Table(name = "contract_status_tracking")
@NamedQuery(name = "ContractStatusTracking.findAll", query = "SELECT c FROM ContractStatusTracking c")
public class ContractStatusTracking extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "contract_status_tracking")
	private Integer id;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	// bi-directional many-to-one association to Contract
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "contract_id")
	private Contract contract;

	// bi-directional many-to-one association to ContractStatusMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "contract_status_id")
	private ContractStatusMaster contractStatusMaster;

	// bi-directional many-to-one association to UserMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "status_changed_user")
	private UserMaster userMaster;

	public ContractStatusTracking() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
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

	public Contract getContract() {
		return this.contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public ContractStatusMaster getContractStatusMaster() {
		return this.contractStatusMaster;
	}

	public void setContractStatusMaster(ContractStatusMaster contractStatusMaster) {
		this.contractStatusMaster = contractStatusMaster;
	}

	public UserMaster getUserMaster() {
		return this.userMaster;
	}

	public void setUserMaster(UserMaster userMaster) {
		this.userMaster = userMaster;
	}

}