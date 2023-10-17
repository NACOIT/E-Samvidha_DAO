package gov.naco.soch.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "tiOstBeneficiary", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "beneficiary_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
	@Entity(name = "TiOstBeneficiaryTransferReadOnly")
	@Table(name = "ti_ost_beneficiary")
	@Immutable
public class TiOstBeneficiaryTransferReadOnly extends Auditable<Long> implements Serializable {
	
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "tiOstBeneficiary")
    private Long id;
    
    @Size(max = 25)
    @Column(name = "ost_number")
    private String ostNumber;
    
    @OneToOne
    private BeneficiaryTransferReadOnly beneficiary;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOstNumber() {
		return ostNumber;
	}
	public void setOstNumber(String ostNumber) {
		this.ostNumber = ostNumber;
	}
	public BeneficiaryTransferReadOnly getBeneficiary() {
		return beneficiary;
	}
	public void setBeneficiary(BeneficiaryTransferReadOnly beneficiary) {
		this.beneficiary = beneficiary;
	}	
}
