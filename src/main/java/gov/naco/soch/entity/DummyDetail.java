package gov.naco.soch.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dummy_details database table.
 * 
 */
@Entity
@Table(name="dummy_details")
@NamedQuery(name="DummyDetail.findAll", query="SELECT d FROM DummyDetail d")
public class DummyDetail extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(length=255)
	private String address;

	@Column(length=255)
	private String mobile;

	//bi-directional many-to-one association to DummyMaster
	@ManyToOne
	@JoinColumn(name="dummy_master_id")
	private DummyMaster dummyMaster;

	public DummyDetail() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public DummyMaster getDummyMaster() {
		return this.dummyMaster;
	}

	public void setDummyMaster(DummyMaster dummyMaster) {
		this.dummyMaster = dummyMaster;
	}

}