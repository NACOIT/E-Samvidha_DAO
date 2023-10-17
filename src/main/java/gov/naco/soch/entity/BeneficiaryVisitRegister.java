package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
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
 * The persistent class for the beneficiary_visit_register database table.
 * 
 */
@GenericGenerator(name = "beneficiary_visit_register", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "beneficiary_visit_register_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })

@Entity
@Table(name = "beneficiary_visit_register")
@NamedQuery(name = "BeneficiaryVisitRegister.findAll", query = "SELECT b FROM BeneficiaryVisitRegister b")
public class BeneficiaryVisitRegister extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "beneficiary_visit_register")
	private Long id;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "visit_date")
	private LocalDate visitDate;

	@Column(name = "weight")
	private Float weight;

	@Column(name = "height")
	private Float height;

	@Column(name = "is_pregnant")
	private Boolean isPregnant;

	@Column(name = "lmp")
	private LocalDate lmp;

	@Column(name = "four_s_symptoms")
	private Boolean foursSymptoms;

	@Column(name = "visit_by")
	private String visitBy;
	
	@Column(name="ost_client_status_date")
	private LocalDateTime ostClientStatusDate;
	
	@Column(name="ti_client_status_date")
	private LocalDateTime tiClientStatusDate;
	
	@Column(name="ost_status_date")
	private LocalDateTime ostStatusDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pregnant_case_type_id")
	private MasterPregnancyTypeCase masterPregnancyTypeCase;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "beneficiary_id")
	private Beneficiary beneficiary;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "delivery_outcome_id")
	private MasterDeliveryOutcome deliveryOutcome;

	// bi-directional many-to-one association to Facility
	@ManyToOne(fetch = FetchType.LAZY)
	private Facility facility;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ti_beneficiary_id")
	private TIBeneficiary tiBeneficiary;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ost_beneficiary_id")
	private TiOstBeneficiary tiOstBeneficiary;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ost_client_status_id")
	private MasterOstClientStatus ostClientStatus;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ti_client_status_id")
	private MasterTiClientStatus tiClientStatus;
	
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "ost_status_id")
	 private MasterBeneficiaryOstStatus ostStatus;
	
	
	// bi-directional many-to-one association to ArtBeneficiaryQueue
	@OneToMany(mappedBy = "beneficiaryVisitRegister")
	private Set<ArtBeneficiaryQueue> artBeneficiaryQueues;

	// bi-directional many-to-one association to ArtDispensation
	@OneToMany(mappedBy = "beneficiaryVisitRegister")
	private Set<ArtDispensation> artDispensations;

	@OneToMany(mappedBy = "beneficiaryVisitRegister")
	private Set<ArtBeneficiaryCounsellingNotes> artBeneficiaryCounsellingNotes;

	@Column(name="pregnancy_month")
	private String pregnancyMonth;

	@Column(name="edd")
	private LocalDate edd;

	@Column(name="dsrc_beneficiary_status_date ")
	private LocalDate dsrcBeneficiaryStatusDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dsrc_beneficiary_status_id")
	private MasterDsrcBeneficiaryStatus dsrcBeneficiaryStatus;


	public BeneficiaryVisitRegister() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<ArtDispensation> getArtDispensations() {
		return artDispensations;
	}

	public void setArtDispensations(Set<ArtDispensation> artDispensations) {
		this.artDispensations = artDispensations;
	}

	public LocalDate getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(LocalDate visitDate) {
		this.visitDate = visitDate;
	}
	
	public LocalDateTime getOstClientStatusDate() {
	    return ostClientStatusDate;
	}

	public void setOstClientStatusDate(LocalDateTime ostClientStatusDate) {
	    this.ostClientStatusDate = ostClientStatusDate;
	}

	public LocalDateTime getTiClientStatusDate() {
	    return tiClientStatusDate;
	}

	public void setTiClientStatusDate(LocalDateTime tiClientStatusDate) {
	    this.tiClientStatusDate = tiClientStatusDate;
	}

	public LocalDateTime getOstStatusDate() {
	    return ostStatusDate;
	}

	public void setOstStatusDate(LocalDateTime ostStatusDate) {
	    this.ostStatusDate = ostStatusDate;
	}

	public TIBeneficiary getTiBeneficiary() {
	    return tiBeneficiary;
	}

	public void setTiBeneficiary(TIBeneficiary tiBeneficiary) {
	    this.tiBeneficiary = tiBeneficiary;
	}

	public TiOstBeneficiary getTiOstBeneficiary() {
	    return tiOstBeneficiary;
	}

	public void setTiOstBeneficiary(TiOstBeneficiary tiOstBeneficiary) {
	    this.tiOstBeneficiary = tiOstBeneficiary;
	}

	public MasterOstClientStatus getOstClientStatus() {
	    return ostClientStatus;
	}

	public void setOstClientStatus(MasterOstClientStatus ostClientStatus) {
	    this.ostClientStatus = ostClientStatus;
	}

	public MasterTiClientStatus getTiClientStatus() {
	    return tiClientStatus;
	}

	public void setTiClientStatus(MasterTiClientStatus tiClientStatus) {
	    this.tiClientStatus = tiClientStatus;
	}

	public MasterBeneficiaryOstStatus getOstStatus() {
	    return ostStatus;
	}

	public void setOstStatus(MasterBeneficiaryOstStatus ostStatus) {
	    this.ostStatus = ostStatus;
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

	public Beneficiary getBeneficiary() {
		return this.beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public Set<ArtBeneficiaryQueue> getArtBeneficiaryQueues() {
		return this.artBeneficiaryQueues;
	}

	public void setArtBeneficiaryQueues(Set<ArtBeneficiaryQueue> artBeneficiaryQueues) {
		this.artBeneficiaryQueues = artBeneficiaryQueues;
	}

	public ArtBeneficiaryQueue addArtBeneficiaryQueue(ArtBeneficiaryQueue artBeneficiaryQueue) {
		getArtBeneficiaryQueues().add(artBeneficiaryQueue);
		// artBeneficiaryQueue.setBeneficiaryVisitRegister(this);

		return artBeneficiaryQueue;
	}

	public ArtBeneficiaryQueue removeArtBeneficiaryQueue(ArtBeneficiaryQueue artBeneficiaryQueue) {
		getArtBeneficiaryQueues().remove(artBeneficiaryQueue);
		// artBeneficiaryQueue.setBeneficiaryVisitRegister(null);

		return artBeneficiaryQueue;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

	public Boolean getIsPregnant() {
		return isPregnant;
	}

	public void setIsPregnant(Boolean isPregnant) {
		this.isPregnant = isPregnant;
	}

	public MasterPregnancyTypeCase getMasterPregnancyTypeCase() {
		return masterPregnancyTypeCase;
	}

	public void setMasterPregnancyTypeCase(MasterPregnancyTypeCase masterPregnancyTypeCase) {
		this.masterPregnancyTypeCase = masterPregnancyTypeCase;
	}

	public LocalDate getLmp() {
		return lmp;
	}

	public void setLmp(LocalDate lmp) {
		this.lmp = lmp;
	}

	public Boolean getFoursSymptoms() {
		return foursSymptoms;
	}

	public void setFoursSymptoms(Boolean foursSymptoms) {
		this.foursSymptoms = foursSymptoms;
	}

	public String getVisitBy() {
		return visitBy;
	}

	public void setVisitBy(String visitBy) {
		this.visitBy = visitBy;
	}

	public ArtDispensation addArtDispensation(ArtDispensation artDispensation) {
		getArtDispensations().add(artDispensation);
		artDispensation.setBeneficiaryVisitRegister(this);

		return artDispensation;
	}

	public ArtDispensation removeArtDispensation(ArtDispensation artDispensation) {
		getArtDispensations().remove(artDispensation);
		artDispensation.setBeneficiaryVisitRegister(null);

		return artDispensation;
	}

	public Set<ArtBeneficiaryCounsellingNotes> getArtBeneficiaryCounsellingNotes() {
		return artBeneficiaryCounsellingNotes;
	}

	public void setArtBeneficiaryCounsellingNotes(Set<ArtBeneficiaryCounsellingNotes> artBeneficiaryCounsellingNotes) {
		this.artBeneficiaryCounsellingNotes = artBeneficiaryCounsellingNotes;
	}

	public MasterDeliveryOutcome getDeliveryOutcome() {
		return deliveryOutcome;
	}

	public void setDeliveryOutcome(MasterDeliveryOutcome deliveryOutcome) {
		this.deliveryOutcome = deliveryOutcome;
	}

    public void setPregnancyMonth(String pregnancyMonth) {
        this.pregnancyMonth = pregnancyMonth;
    }

    public String getPregnancyMonth() {
        return pregnancyMonth;
    }

	public LocalDate getEdd() {
		return edd;
	}

	public void setEdd(LocalDate edd) {
		this.edd = edd;
	}

	public LocalDate getDsrcBeneficiaryStatusDate() {
		return dsrcBeneficiaryStatusDate;
	}

	public void setDsrcBeneficiaryStatusDate(LocalDate dsrcBeneficiaryStatusDate) {
		this.dsrcBeneficiaryStatusDate = dsrcBeneficiaryStatusDate;
	}

	public MasterDsrcBeneficiaryStatus getDsrcBeneficiaryStatus() {
		return dsrcBeneficiaryStatus;
	}

	public void setDsrcBeneficiaryStatus(MasterDsrcBeneficiaryStatus dsrcBeneficiaryStatus) {
		this.dsrcBeneficiaryStatus = dsrcBeneficiaryStatus;
	}
}
