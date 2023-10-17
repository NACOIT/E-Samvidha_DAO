package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

@GenericGenerator(name = "beneficiary_art_status_tracking", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "beneficiary_art_status_tracking_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "beneficiary_art_status_tracking")
@NamedQuery(name = "BeneficiaryArtStatusTracking.findAll", query = "SELECT b FROM BeneficiaryArtStatusTracking b")
public class BeneficiaryArtStatusTracking extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "beneficiary_art_status_tracking")
	private Long id;

	// bi-directional many-to-one association to Facility
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "facility_id")
	private Facility facility;

	// bi-directional many-to-one association to Beneficiary
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "beneficiary_id")
	private Beneficiary beneficiary;

	// bi-directional many-to-one association to MasterBeneficiaryActivityStatus
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "current_art_beneficiary_status_id")
	private MasterArtBeneficiaryStatus currentArtBeneficiaryStatus;

	// bi-directional many-to-one association to MasterBeneficiaryActivityStatus
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "previous_art_beneficiary_status_id")
	private MasterArtBeneficiaryStatus previousArtBeneficiaryStatus;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "status_changed_by")
	private Long statusChangedBy;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "status_changed_date")
	private LocalDateTime statusDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public Beneficiary getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public LocalDateTime getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(LocalDateTime statusDate) {
		this.statusDate = statusDate;
	}

	public MasterArtBeneficiaryStatus getCurrentArtBeneficiaryStatus() {
		return currentArtBeneficiaryStatus;
	}

	public void setCurrentArtBeneficiaryStatus(MasterArtBeneficiaryStatus currentArtBeneficiaryStatus) {
		this.currentArtBeneficiaryStatus = currentArtBeneficiaryStatus;
	}

	public MasterArtBeneficiaryStatus getPreviousArtBeneficiaryStatus() {
		return previousArtBeneficiaryStatus;
	}

	public void setPreviousArtBeneficiaryStatus(MasterArtBeneficiaryStatus previousArtBeneficiaryStatus) {
		this.previousArtBeneficiaryStatus = previousArtBeneficiaryStatus;
	}

	public Long getStatusChangedBy() {
		return statusChangedBy;
	}

	public void setStatusChangedBy(Long statusChangedBy) {
		this.statusChangedBy = statusChangedBy;
	}
	
}
