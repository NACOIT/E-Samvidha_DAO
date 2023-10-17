package gov.naco.soch.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "tIBenScrDetailsBenRefReadOnlySequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "tIBenScrDetailsBenRefReadOnly_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity(name="TIBenScrDetailsBenRefReadOnly")
@Table(name = "ti_ben_scr_details")
@Immutable
public class TIBenScrDetailsBenRefReadOnly extends Auditable<Long> implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "benScreenSequence")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "infection_id")
	private MasterInfectionType infection;
	
	@ManyToOne
	@JoinColumn(name = "screening_status_hiv_id")
	private MasterHivScreeningStatus screeningStatusHiv;
	
	@ManyToOne
	@JoinColumn(name = "screening_status_syphilis_id")
	private MasterSyphilisStatus screeningStatusSyphilis;
	
	@ManyToOne
	@JoinColumn(name = "tb_status_id")
	private MasterTbScreeningStatus tbStatus;
	
	@OneToOne(mappedBy = "tiBenScrDetails")
	private BeneficiaryReferralReadOnly beneficiaryReferral;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MasterInfectionType getInfection() {
		return infection;
	}

	public void setInfection(MasterInfectionType infection) {
		this.infection = infection;
	}

	public MasterHivScreeningStatus getScreeningStatusHiv() {
		return screeningStatusHiv;
	}

	public void setScreeningStatusHiv(MasterHivScreeningStatus screeningStatusHiv) {
		this.screeningStatusHiv = screeningStatusHiv;
	}

	public MasterSyphilisStatus getScreeningStatusSyphilis() {
		return screeningStatusSyphilis;
	}

	public void setScreeningStatusSyphilis(MasterSyphilisStatus screeningStatusSyphilis) {
		this.screeningStatusSyphilis = screeningStatusSyphilis;
	}

	public MasterTbScreeningStatus getTbStatus() {
		return tbStatus;
	}

	public void setTbStatus(MasterTbScreeningStatus tbStatus) {
		this.tbStatus = tbStatus;
	}

	public BeneficiaryReferralReadOnly getBeneficiaryReferral() {
		return beneficiaryReferral;
	}

	public void setBeneficiaryReferral(BeneficiaryReferralReadOnly beneficiaryReferral) {
		this.beneficiaryReferral = beneficiaryReferral;
	}
	
}
