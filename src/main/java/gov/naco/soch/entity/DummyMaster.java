package gov.naco.soch.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;


/**
 * The persistent class for the dummy_master database table.
 * 
 */
@Entity
@Table(name="dummy_master")
@NamedQuery(name="DummyMaster.findAll", query="SELECT d FROM DummyMaster d")
public class DummyMaster extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(name="created_date")
	private LocalDateTime createdDate;

	
	private LocalDate dateofbirth;

	@Column(length=255)
	private String email;

	@Column(length=255)
	private String name;

	@Column(name="submitted_time")
	private LocalDateTime submittedTime;

	//bi-directional many-to-one association to DummyDetail
	@OneToMany(mappedBy="dummyMaster")
	private Set<DummyDetail> dummyDetails;

	public DummyMaster() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getDateofbirth() {
		return this.dateofbirth;
	}

	public void setDateofbirth(LocalDate dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getSubmittedTime() {
		return this.submittedTime;
	}

	public void setSubmittedTime(LocalDateTime submittedTime) {
		this.submittedTime = submittedTime;
	}

	public Set<DummyDetail> getDummyDetails() {
		return this.dummyDetails;
	}

	public void setDummyDetails(Set<DummyDetail> dummyDetails) {
		this.dummyDetails = dummyDetails;
	}

	public DummyDetail addDummyDetail(DummyDetail dummyDetail) {
		getDummyDetails().add(dummyDetail);
		dummyDetail.setDummyMaster(this);

		return dummyDetail;
	}

	public DummyDetail removeDummyDetail(DummyDetail dummyDetail) {
		getDummyDetails().remove(dummyDetail);
		dummyDetail.setDummyMaster(null);

		return dummyDetail;
	}

}