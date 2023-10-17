package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * A IctcSampleBatch.
 */
@Entity
@Table(name = "ictc_sample_batch")
public class IctcSampleBatch extends Auditable<Long> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 25)
    @Column(name = "consignment_id", length = 25)
    private String consignmentId;

    @Column(name = "dispatch_date")
    private LocalDateTime dispatchDate;

    @Column(name = "batch_status")
    private Long batchStatus;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_deleted")
    private Boolean isDeleted;
    
    @ManyToOne
	@JoinColumn(name = "facility_id")
	private Facility facility;

    @ManyToOne
	@JoinColumn(name = "lab_id")
	private Facility lab;
    
    @OneToMany(mappedBy = "batch")
	private Set<IctcSampleCollection> sampleCollection;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getConsignmentId() {
		return consignmentId;
	}

	public void setConsignmentId(String consignmentId) {
		this.consignmentId = consignmentId;
	}

	public LocalDateTime getDispatchDate() {
		return dispatchDate;
	}

	public void setDispatchDate(LocalDateTime dispatchDate) {
		this.dispatchDate = dispatchDate;
	}

	public Long getBatchStatus() {
		return batchStatus;
	}

	public void setBatchStatus(Long batchStatus) {
		this.batchStatus = batchStatus;
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

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public Facility getLab() {
		return lab;
	}

	public void setLab(Facility lab) {
		this.lab = lab;
	}

	public Set<IctcSampleCollection> getSampleCollection() {
		return sampleCollection;
	}

	public void setSampleCollection(Set<IctcSampleCollection> sampleCollection) {
		this.sampleCollection = sampleCollection;
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
		IctcSampleBatch other = (IctcSampleBatch) obj;
		return Objects.equals(id, other.id);
	}

}
