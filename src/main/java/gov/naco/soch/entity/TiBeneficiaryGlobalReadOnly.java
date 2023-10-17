package gov.naco.soch.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "tibenGlobalReadOnlySequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "ti_beneficiary_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })

@Entity(name = "TiBeneficiaryGlobalReadOnly")
@Table(name = "ti_beneficiary")
@Immutable
public class TiBeneficiaryGlobalReadOnly extends Auditable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "tibenGlobalReadOnlySequence")
	private Long id;

	@Column(name = "number_of_partners")
	private String numberOfPartners;
	
    @OneToOne
    private BeneficiaryGlobalReadOnly beneficiary;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumberOfPartners() {
		return numberOfPartners;
	}

	public void setNumberOfPartners(String numberOfPartners) {
		this.numberOfPartners = numberOfPartners;
	}

	public BeneficiaryGlobalReadOnly getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(BeneficiaryGlobalReadOnly beneficiary) {
		this.beneficiary = beneficiary;
	}
    
    
}
