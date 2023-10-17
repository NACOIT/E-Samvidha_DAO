package gov.naco.soch.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the master_batch_status database table.
 * 
 */
@Entity
@Table(name = "master_batch_status")
@NamedQuery(name = "MasterBatchStatus.findAll", query = "SELECT m FROM MasterBatchStatus m")
public class MasterBatchStatus extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "is_delete")
	private Boolean isDelete;

	private String status;

	// bi-directional many-to-one association to LabTestSampleBatch
	@OneToMany(mappedBy = "masterBatchStatus")
	private Set<LabTestSampleBatch> labTestSampleBatches;

	public MasterBatchStatus() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<LabTestSampleBatch> getLabTestSampleBatches() {
		return this.labTestSampleBatches;
	}

	public void setLabTestSampleBatches(Set<LabTestSampleBatch> labTestSampleBatches) {
		this.labTestSampleBatches = labTestSampleBatches;
	}

	public LabTestSampleBatch addLabTestSampleBatch(LabTestSampleBatch labTestSampleBatch) {
		getLabTestSampleBatches().add(labTestSampleBatch);
		labTestSampleBatch.setMasterBatchStatus(this);

		return labTestSampleBatch;
	}

	public LabTestSampleBatch removeLabTestSampleBatch(LabTestSampleBatch labTestSampleBatch) {
		getLabTestSampleBatches().remove(labTestSampleBatch);
		labTestSampleBatch.setMasterBatchStatus(null);

		return labTestSampleBatch;
	}

}