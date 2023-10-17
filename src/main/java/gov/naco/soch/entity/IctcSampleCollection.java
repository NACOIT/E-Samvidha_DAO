package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * A IctcSampleCollection.
 */
@Entity
@Table(name = "ictc_sample_collection")
public class IctcSampleCollection extends Auditable<Long> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 99)
    @Column(name = "barcode", length = 99)
    private String barcode;

    @Column(name = "test_type")
    private Long testType;
    
    @Column(name = "sample_collection_date")
    private LocalDateTime sampleCollectionDate;
    
    @Column(name = "sample_collection_status")
    private Long sampleCollectionStatus;
    
    @Column(name = "sample_received_date")
    private LocalDateTime sampleReceivedDate;
   
    @Column(name = "is_dispatched")
    private Boolean isDispatched;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_deleted")
    private Boolean isDeleted;
    
    @Column(name = "is_eighteen_plus")
	private Boolean isEighteenPlus;

    @ManyToOne
    @JoinColumn(name = "batch_id")
    private IctcSampleBatch batch;
    
    @ManyToOne(optional = false)
	@JoinColumn(name = "ictc_beneficiary_id")
    @NotNull
	private IctcBeneficiary ictcBeneficiary;
    
    @ManyToOne
    @JoinColumn(name = "visit_id")
    private IctcVisit visit;

    @ManyToOne(fetch = FetchType.LAZY)
   	@JoinColumn(name = "facility_id")
   	private Facility facility;
    
    @OneToMany(mappedBy="sample")
    private List<IctcTestResult> ictcTestResult;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public Long getTestType() {
		return testType;
	}

	public void setTestType(Long testType) {
		this.testType = testType;
	}

	public LocalDateTime getSampleCollectionDate() {
		return sampleCollectionDate;
	}

	public void setSampleCollectionDate(LocalDateTime sampleCollectionDate) {
		this.sampleCollectionDate = sampleCollectionDate;
	}

	public Long getSampleCollectionStatus() {
		return sampleCollectionStatus;
	}

	public void setSampleCollectionStatus(Long sampleCollectionStatus) {
		this.sampleCollectionStatus = sampleCollectionStatus;
	}

	public LocalDateTime getSampleReceivedDate() {
		return sampleReceivedDate;
	}

	public void setSampleReceivedDate(LocalDateTime sampleReceivedDate) {
		this.sampleReceivedDate = sampleReceivedDate;
	}

	public Boolean getIsDispatched() {
		return isDispatched;
	}

	public void setIsDispatched(Boolean isDispatched) {
		this.isDispatched = isDispatched;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Boolean getIsEighteenPlus() {
		return isEighteenPlus;
	}

	public void setIsEighteenPlus(Boolean isEighteenPlus) {
		this.isEighteenPlus = isEighteenPlus;
	}

	public IctcSampleBatch getBatch() {
		return batch;
	}

	public void setBatch(IctcSampleBatch batch) {
		this.batch = batch;
	}

	public IctcBeneficiary getIctcBeneficiary() {
		return ictcBeneficiary;
	}

	public void setIctcBeneficiary(IctcBeneficiary ictcBeneficiary) {
		this.ictcBeneficiary = ictcBeneficiary;
	}

	public IctcVisit getVisit() {
		return visit;
	}

	public void setVisit(IctcVisit visit) {
		this.visit = visit;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public List<IctcTestResult> getIctcTestResult() {
		return ictcTestResult;
	}

	public void setIctcTestResult(List<IctcTestResult> ictcTestResult) {
		this.ictcTestResult = ictcTestResult;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IctcSampleCollection other = (IctcSampleCollection) obj;
		return Objects.equals(id, other.id);
	}


}
