package gov.naco.soch.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the test database table.
 * 
 */
@GenericGenerator(name = "test", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "test_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "test")
@NamedQuery(name = "Test.findAll", query = "SELECT t FROM Test t")
public class Test extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "test")
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(name = "collection_center", length = 99)
	private String collectionCenter;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(length = 99)
	private String status;
	
	@Column(name = "is_barcode_required")
	private Boolean isBarcodeRequired;

	@Column(name = "testing_center", length = 99)
	private String testingCenter;

	@Column(name = "type_of_test", length = 99)
	private String typeOfTest;
	
	// bi-directional many-to-one association to LabTestSample
	@OneToMany(mappedBy = "test")
	private Set<LabTestSample> labTestSamples;

	public Test() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCollectionCenter() {
		return this.collectionCenter;
	}

	public void setCollectionCenter(String collectionCenter) {
		this.collectionCenter = collectionCenter;
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTestingCenter() {
		return this.testingCenter;
	}

	public void setTestingCenter(String testingCenter) {
		this.testingCenter = testingCenter;
	}

	public String getTypeOfTest() {
		return this.typeOfTest;
	}

	public void setTypeOfTest(String typeOfTest) {
		this.typeOfTest = typeOfTest;
	}

	public Boolean getIsBarcodeRequired() {
		return isBarcodeRequired;
	}

	public void setIsBarcodeRequired(Boolean isBarcodeRequired) {
		this.isBarcodeRequired = isBarcodeRequired;
	}

	public Set<LabTestSample> getLabTestSamples() {
		return labTestSamples;
	}

	public void setLabTestSamples(Set<LabTestSample> labTestSamples) {
		this.labTestSamples = labTestSamples;
	}

}