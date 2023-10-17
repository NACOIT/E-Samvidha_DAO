package gov.naco.soch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity(name = "IctcBeneficiaryVCReadOnly")
@Table(name = "ictc_beneficiary")
public class IctcBeneficiaryVCReadOnly implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(max = 99)
	@Column(name = "pid", length = 99)
	private String pid;

	@OneToOne
	@JoinColumn(unique = true, name = "beneficiary_id")
	private BeneficiaryViewCardReadOnly beneficiary;

	@ManyToOne
	@JoinColumn(name = "facility_id")
	private FacilityReadOnly facility;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public BeneficiaryViewCardReadOnly getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(BeneficiaryViewCardReadOnly beneficiary) {
		this.beneficiary = beneficiary;
	}

	public FacilityReadOnly getFacility() {
		return facility;
	}

	public void setFacility(FacilityReadOnly facility) {
		this.facility = facility;
	}

}
