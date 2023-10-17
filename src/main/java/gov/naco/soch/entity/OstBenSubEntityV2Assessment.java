package gov.naco.soch.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "OstBenSubEntityV2Assessment", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "ti_ost_beneficiary_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })

@NamedEntityGraph(name = "OstBenSubEntityV2Assessment", attributeNodes = { 
		 @NamedAttributeNode("ostAssess"),@NamedAttributeNode("ostStatus")})
@Entity(name = "OstBenSubEntityV2Assessment")
@Table(name = "ti_ost_beneficiary")
@Immutable
public class OstBenSubEntityV2Assessment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Long id;
	
	@Column(name = "ost_code")
	private String ostCode;

	@Size(max = 25)
	@Column(name = "ost_number")
	private String ostNumber;
	
	@ManyToOne
	private MasterBenSubV2Assessment beneficiary;
	
	@ManyToOne
	@JoinColumn(name = "status_id")
	private MasterOstClientStatus status;

	@OneToMany(mappedBy = "tiOstBeneficiary")
	private Set<OstAssessmentV2> ostAssess;

	@ManyToOne
	@JoinColumn(name = "ost_status_id")
	private MasterBeneficiaryOstStatus ostStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOstCode() {
		return ostCode;
	}

	public void setOstCode(String ostCode) {
		this.ostCode = ostCode;
	}

	public String getOstNumber() {
		return ostNumber;
	}

	public void setOstNumber(String ostNumber) {
		this.ostNumber = ostNumber;
	}

	public MasterBenSubV2Assessment getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(MasterBenSubV2Assessment beneficiary) {
		this.beneficiary = beneficiary;
	}

	public MasterOstClientStatus getStatus() {
		return status;
	}

	public void setStatus(MasterOstClientStatus status) {
		this.status = status;
	}

	public Set<OstAssessmentV2> getOstAssess() {
		return ostAssess;
	}

	public void setOstAssess(Set<OstAssessmentV2> ostAssess) {
		this.ostAssess = ostAssess;
	}

	public MasterBeneficiaryOstStatus getOstStatus() {
		return ostStatus;
	}

	public void setOstStatus(MasterBeneficiaryOstStatus ostStatus) {
		this.ostStatus = ostStatus;
	}
}
