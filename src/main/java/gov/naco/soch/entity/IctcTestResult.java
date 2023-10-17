package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * A IctcTestResult.
 */
@Entity
@Table(name = "ictc_test_result")
public class IctcTestResult extends Auditable<Long> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tested_date")
    private LocalDate testedDate;

    @Column(name = "result_status")
    private Long resultStatus;

    @Column(name = "hiv_status")
    private Long hivStatus;

    @Column(name = "hiv_type")
    private Long hivType;

    @Column(name = "report_received_date")
    private LocalDate reportReceivedDate;

    @Column(name = "report_delivery_date")
    private LocalDate reportDeliveryDate;

    @Column(name = "is_tested_for_tb")
    private Boolean isTestedForTb;

    @Column(name = "tb_test_result")
    private Long tbTestResult;

    @Column(name = "is_tested_for_syphilis")
    private Boolean isTestedForSyphilis;

    @Column(name = "syphilis_test_result")
    private Long syphilisTestResult;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @NotNull
    @JoinColumn(name = "ictc_beneficiary_id")
    private IctcBeneficiary ictcBeneficiary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sample_id")
    private IctcSampleCollection sample;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "visit_id")
    private IctcVisit visit;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getTestedDate() {
		return testedDate;
	}

	public void setTestedDate(LocalDate testedDate) {
		this.testedDate = testedDate;
	}

	public Long getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(Long resultStatus) {
		this.resultStatus = resultStatus;
	}

	public Long getHivStatus() {
		return hivStatus;
	}

	public void setHivStatus(Long hivStatus) {
		this.hivStatus = hivStatus;
	}

	public Long getHivType() {
		return hivType;
	}

	public void setHivType(Long hivType) {
		this.hivType = hivType;
	}

	public LocalDate getReportReceivedDate() {
		return reportReceivedDate;
	}

	public void setReportReceivedDate(LocalDate reportReceivedDate) {
		this.reportReceivedDate = reportReceivedDate;
	}

	public LocalDate getReportDeliveryDate() {
		return reportDeliveryDate;
	}

	public void setReportDeliveryDate(LocalDate reportDeliveryDate) {
		this.reportDeliveryDate = reportDeliveryDate;
	}

	public Boolean getIsTestedForTb() {
		return isTestedForTb;
	}

	public void setIsTestedForTb(Boolean isTestedForTb) {
		this.isTestedForTb = isTestedForTb;
	}

	public Long getTbTestResult() {
		return tbTestResult;
	}

	public void setTbTestResult(Long tbTestResult) {
		this.tbTestResult = tbTestResult;
	}

	public Boolean getIsTestedForSyphilis() {
		return isTestedForSyphilis;
	}

	public void setIsTestedForSyphilis(Boolean isTestedForSyphilis) {
		this.isTestedForSyphilis = isTestedForSyphilis;
	}

	public Long getSyphilisTestResult() {
		return syphilisTestResult;
	}

	public void setSyphilisTestResult(Long syphilisTestResult) {
		this.syphilisTestResult = syphilisTestResult;
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

	public IctcBeneficiary getIctcBeneficiary() {
		return ictcBeneficiary;
	}

	public void setIctcBeneficiary(IctcBeneficiary ictcBeneficiary) {
		this.ictcBeneficiary = ictcBeneficiary;
	}

	public IctcSampleCollection getSample() {
		return sample;
	}

	public void setSample(IctcSampleCollection sample) {
		this.sample = sample;
	}

	public IctcVisit getVisit() {
		return visit;
	}

	public void setVisit(IctcVisit visit) {
		this.visit = visit;
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
		IctcTestResult other = (IctcTestResult) obj;
		return Objects.equals(id, other.id);
	}

	

}
