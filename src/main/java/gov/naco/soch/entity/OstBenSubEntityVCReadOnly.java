package gov.naco.soch.entity;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "tiOstBeneficiary", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "ti_ost_beneficiary_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })

//@NamedEntityGraph(name = "OstBenSubEntityGraph", attributeNodes = {
//		@NamedAttributeNode("tiOstPrescriptions"),@NamedAttributeNode("ostAssess") ,
//		@NamedAttributeNode("ostFollowUp")
//})
@Entity(name = "OstBenSubEntityVCReadOnly")
@Table(name = "ti_ost_beneficiary")
@Immutable
public class OstBenSubEntityVCReadOnly extends Auditable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "tiOstBeneficiary")
	private Long id;
	
	@Column(name = "ost_code")
	private String ostCode;

	@Size(max = 25)
	@Column(name = "ost_number")
	private String ostNumber;

	@Column(name = "consent_documented")
	private Boolean consentDocumented;

	@Column(name = "guardian_contact_number")
	private String guardianContactNumber;

	@OneToMany(mappedBy = "tiOstBeneficiary")
	@OrderBy("id DESC")
	private SortedSet<OstPrescriptionVCReadOnly> tiOstPrescriptions = new TreeSet<>();

	@OneToMany(mappedBy = "tiOstBeneficiary")
	@OrderBy("id DESC")
	private SortedSet<OstAssessmentVCReadOnly> ostAssess= new TreeSet<>();

	@OneToMany(mappedBy = "tiOstBeneficiary")
	@OrderBy("id DESC")
	private SortedSet<OstFollowUpVCReadOnly> ostFollowUp = new TreeSet<>();

	@ManyToOne
	@JoinColumn(name = "ost_status_id")
	private MasterBeneficiaryOstStatus ostStatus;
	
    @ManyToOne
    @JoinColumn(name = "status_id")
    private MasterOstClientStatus status;

     @ManyToOne
    private FacilityReadOnly facility;
	

    @OneToOne
    private BeneficiaryViewCardReadOnly beneficiary;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getConsentDocumented() {
		return consentDocumented;
	}

	public void setConsentDocumented(Boolean consentDocumented) {
		this.consentDocumented = consentDocumented;
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

	public String getGuardianContactNumber() {
		return guardianContactNumber;
	}

	public void setGuardianContactNumber(String guardianContactNumber) {
		this.guardianContactNumber = guardianContactNumber;
	}

	public MasterBeneficiaryOstStatus getOstStatus() {
		return ostStatus;
	}

	public void setOstStatus(MasterBeneficiaryOstStatus ostStatus) {
		this.ostStatus = ostStatus;
	}

	public SortedSet<OstPrescriptionVCReadOnly> getTiOstPrescriptions() {
		return tiOstPrescriptions;
	}

	public void setTiOstPrescriptions(SortedSet<OstPrescriptionVCReadOnly> tiOstPrescriptions) {
		this.tiOstPrescriptions = tiOstPrescriptions;
	}

	public SortedSet<OstAssessmentVCReadOnly> getOstAssess() {
		return ostAssess;
	}

	public void setOstAssess(SortedSet<OstAssessmentVCReadOnly> ostAssess) {
		this.ostAssess = ostAssess;
	}

	public Set<OstFollowUpVCReadOnly> getOstFollowUp() {
		return ostFollowUp;
	}

	public void setOstFollowUp(SortedSet<OstFollowUpVCReadOnly> ostFollowUp) {
		this.ostFollowUp = ostFollowUp;
	}

	public FacilityReadOnly getFacility() {
		return facility;
	}

	public void setFacility(FacilityReadOnly facility) {
		this.facility = facility;
	}

	public BeneficiaryViewCardReadOnly getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(BeneficiaryViewCardReadOnly beneficiary) {
		this.beneficiary = beneficiary;
	}

	public MasterOstClientStatus getStatus() {
		return status;
	}

	public void setStatus(MasterOstClientStatus status) {
		this.status = status;
	}

}
