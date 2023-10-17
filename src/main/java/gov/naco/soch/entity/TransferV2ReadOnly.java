package gov.naco.soch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "transferV2ReadOnly", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "transfers_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })

@NamedEntityGraph(name = "TransferV2ReadOnlyEntityGraph")
@Entity(name = "TransferV2ReadOnly")
@Table(name = "transfers")
@NamedQuery(name = "TransferV2ReadOnly.findAll", query = "SELECT t FROM TransferV2ReadOnly t")
@Immutable
public class TransferV2ReadOnly extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "transferV2ReadOnly")
	private Long id;
	
	@Column(name = "transfer_status")
	private String transferStatus;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "beneficiary_id")
	private BeneficiaryV2ReadOnly beneficiary;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "destination_facility_id")
	private FacilityReadOnly facilityTo;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "source_facility_id")
	private FacilityReadOnly facilityFrom;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTransferStatus() {
		return transferStatus;
	}

	public void setTransferStatus(String transferStatus) {
		this.transferStatus = transferStatus;
	}

	public BeneficiaryV2ReadOnly getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(BeneficiaryV2ReadOnly beneficiary) {
		this.beneficiary = beneficiary;
	}

	public FacilityReadOnly getFacilityTo() {
		return facilityTo;
	}

	public void setFacilityTo(FacilityReadOnly facilityTo) {
		this.facilityTo = facilityTo;
	}

	public FacilityReadOnly getFacilityFrom() {
		return facilityFrom;
	}

	public void setFacilityFrom(FacilityReadOnly facilityFrom) {
		this.facilityFrom = facilityFrom;
	}
}
