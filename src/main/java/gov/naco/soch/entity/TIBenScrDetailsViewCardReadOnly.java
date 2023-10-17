package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Parameter;


@GenericGenerator(name = "benScreenSequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "ti_ben_scr_details_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity(name = "TIBenScrDetailsViewCardReadOnly")
@Table(name = "ti_ben_scr_details")
@Immutable
public class TIBenScrDetailsViewCardReadOnly extends Auditable<Long> implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "benScreenSequence")
	private Long id;
	
	@Column(name = "date_of_screening")
	private ZonedDateTime dateOfScreening;
	
	@Column(name = "next_date_of_screening")
	private LocalDate nextDateOfScreening;

	@ManyToOne
	@JoinColumn(name = "screening_status_hiv_id")
	private MasterHivScreeningStatus screeningStatusHiv;
	
	@ManyToOne
	@JoinColumn(name = "screening_status_syphilis_id")
	private MasterSyphilisStatus screeningStatusSyphilis;
	
	@ManyToOne
	@JoinColumn(name = "tb_status_id")
	private MasterTbScreeningStatus tbStatus;
	
	@ManyToOne
	@JoinColumn(name = "beneficiary_id")
	private TiBeneficiaryViewCardReadOnly beneficiary;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ZonedDateTime getDateOfScreening() {
		return dateOfScreening;
	}

	public void setDateOfScreening(ZonedDateTime dateOfScreening) {
		this.dateOfScreening = dateOfScreening;
	}

	public LocalDate getNextDateOfScreening() {
		return nextDateOfScreening;
	}

	public void setNextDateOfScreening(LocalDate nextDateOfScreening) {
		this.nextDateOfScreening = nextDateOfScreening;
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

	public TiBeneficiaryViewCardReadOnly getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(TiBeneficiaryViewCardReadOnly beneficiary) {
		this.beneficiary = beneficiary;
	}

}
