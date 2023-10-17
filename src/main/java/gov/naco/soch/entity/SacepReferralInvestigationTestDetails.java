package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;

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

@GenericGenerator(name = "sacep_referral_investigation_test_details", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "sacep_referral_investigation_test_details_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "sacep_referral_investigation_test_details")
@NamedQuery(name = "SacepReferralInvestigationTestDetails.findAll", query = "SELECT s FROM SacepReferralInvestigationTestDetails s")
public class SacepReferralInvestigationTestDetails extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "sacep_referral_investigation_test_details")
	private Long id;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "investigation_test_date")
	private LocalDate investigationTestDate;

	@Column(name = "investigation_test_value")
	private String investigationTestValue;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "investigation_test_type_id")
	private MasterInvestigation masterInvestigation;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sacep_referral_information_id")
	private SacepReferralInformation sacepReferralInformation;
	
	

	public Long getId() {
		return id;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public LocalDate getInvestigationTestDate() {
		return investigationTestDate;
	}

	public String getInvestigationTestValue() {
		return investigationTestValue;
	}

	public MasterInvestigation getMasterInvestigation() {
		return masterInvestigation;
	}

	public SacepReferralInformation getSacepReferralInformation() {
		return sacepReferralInformation;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public void setInvestigationTestDate(LocalDate investigationTestDate) {
		this.investigationTestDate = investigationTestDate;
	}

	public void setInvestigationTestValue(String investigationTestValue) {
		this.investigationTestValue = investigationTestValue;
	}

	public void setMasterInvestigation(MasterInvestigation masterInvestigation) {
		this.masterInvestigation = masterInvestigation;
	}

	public void setSacepReferralInformation(SacepReferralInformation sacepReferralInformation) {
		this.sacepReferralInformation = sacepReferralInformation;
	}

}
