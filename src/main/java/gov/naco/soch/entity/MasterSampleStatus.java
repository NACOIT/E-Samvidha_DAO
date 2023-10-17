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
 * The persistent class for the master_sample_status database table.
 * 
 */
@Entity
@Table(name = "master_sample_status")
@NamedQuery(name = "MasterSampleStatus.findAll", query = "SELECT m FROM MasterSampleStatus m")
public class MasterSampleStatus extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "is_selectable")
	private Boolean isSelectable;

	private String status;

	// bi-directional many-to-one association to LabTestSample
	@OneToMany(mappedBy = "masterSampleStatus")
	private Set<LabTestSample> labTestSamples;

	public MasterSampleStatus() {
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

	public Boolean getIsSelectable() {
		return isSelectable;
	}

	public void setIsSelectable(Boolean isSelectable) {
		this.isSelectable = isSelectable;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<LabTestSample> getLabTestSamples() {
		return this.labTestSamples;
	}

	public void setLabTestSamples(Set<LabTestSample> labTestSamples) {
		this.labTestSamples = labTestSamples;
	}

	public LabTestSample addLabTestSample(LabTestSample labTestSample) {
		getLabTestSamples().add(labTestSample);
		labTestSample.setMasterSampleStatus(this);

		return labTestSample;
	}

	public LabTestSample removeLabTestSample(LabTestSample labTestSample) {
		getLabTestSamples().remove(labTestSample);
		labTestSample.setMasterSampleStatus(null);

		return labTestSample;
	}

}