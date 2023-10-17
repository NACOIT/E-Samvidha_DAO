package gov.naco.soch.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "benSequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "ti_beneficiary_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })

@Entity(name = "TiBeneficiaryTransferReadOnly")
@Table(name = "ti_beneficiary")
@Immutable
public class TiBeneficiaryTransferReadOnly extends Auditable<Long> implements Serializable{
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "benSequence")
    private Long id;
    
    @Column(name = "ti_code")
    private String tiCode;
    
    @OneToOne
    BeneficiaryTransferReadOnly beneficiary;
    
    @ManyToOne
    @JoinColumn(name = "master_hrg_primary_id")
    private TypologyMaster hrgPrimary;
    
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BeneficiaryTransferReadOnly getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(BeneficiaryTransferReadOnly beneficiary) {
		this.beneficiary = beneficiary;
	}

	public TypologyMaster getHrgPrimary() {
		return hrgPrimary;
	}

	public void setHrgPrimary(TypologyMaster hrgPrimary) {
		this.hrgPrimary = hrgPrimary;
	}

	public String getTiCode() {
		return tiCode;
	}

	public void setTiCode(String tiCode) {
		this.tiCode = tiCode;
	}
	
	
}
