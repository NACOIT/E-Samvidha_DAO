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
 * The persistent class for the contract_product_schedule_sacs database table.
 * 
 */
@Entity
@GenericGenerator(name = "contract_product_schedule_sacs", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "contract_product_schedule_sacs_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Table(name = "contract_product_schedule_sacs")
@NamedQuery(name = "ContractProductScheduleSac.findAll", query = "SELECT c FROM ContractProductScheduleSac c")
public class ContractProductScheduleSac extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "contract_product_schedule_sacs")
	private Integer id;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	// bi-directional many-to-one association to ContractProductSceduleSacsLot
	@OneToMany(mappedBy = "contractProductScheduleSac", cascade = CascadeType.ALL)
	private Set<ContractProductScheduleSacsLot> contractProductSceduleSacsLots;

	// bi-directional many-to-one association to ContractProductSchedule
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contract_product_schedule_id")
	private ContractProductSchedule contractProductSchedule;

	// bi-directional many-to-one association to Facility
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "to_facility")
	private Facility facility;

	public ContractProductScheduleSac() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<ContractProductScheduleSacsLot> getContractProductSceduleSacsLots() {
		return this.contractProductSceduleSacsLots;
	}

	public void setContractProductSceduleSacsLots(Set<ContractProductScheduleSacsLot> contractProductSceduleSacsLots) {
		this.contractProductSceduleSacsLots = contractProductSceduleSacsLots;
	}

	public ContractProductScheduleSacsLot addContractProductSceduleSacsLot(
			ContractProductScheduleSacsLot contractProductSceduleSacsLot) {
		getContractProductSceduleSacsLots().add(contractProductSceduleSacsLot);
		contractProductSceduleSacsLot.setContractProductScheduleSac(this);

		return contractProductSceduleSacsLot;
	}

	public ContractProductScheduleSacsLot removeContractProductSceduleSacsLot(
			ContractProductScheduleSacsLot contractProductSceduleSacsLot) {
		getContractProductSceduleSacsLots().remove(contractProductSceduleSacsLot);
		contractProductSceduleSacsLot.setContractProductScheduleSac(null);

		return contractProductSceduleSacsLot;
	}

	public ContractProductSchedule getContractProductSchedule() {
		return this.contractProductSchedule;
	}

	public void setContractProductSchedule(ContractProductSchedule contractProductSchedule) {
		this.contractProductSchedule = contractProductSchedule;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

}