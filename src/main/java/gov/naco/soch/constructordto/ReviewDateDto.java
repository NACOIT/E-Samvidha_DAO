package gov.naco.soch.constructordto;

import java.time.LocalDate;
import java.util.List;

public class ReviewDateDto {

    private LocalDate followupDate;

    private LocalDate nextFollowupDate;
    
    private FollowUpDatesDto followUp;

    private Boolean isTreatmentCompleted;
    
    private String syphilisTestType;
    
    private String syphilisTestResult;
    
    private Long syphilisTestTypeId;
    
    private Long syphilisTestResultId;
    
    private String titre;
    
    private String concatDate;

    private List<ProductReviewDto> productReviewDtoList;
    
    private Long referTo;
	private Long testTypeConducted;
	
	
	


    public Long getReferTo() {
		return referTo;
	}

	public void setReferTo(Long referTo) {
		this.referTo = referTo;
	}

	public Long getTestTypeConducted() {
		return testTypeConducted;
	}

	public void setTestTypeConducted(Long testTypeConducted) {
		this.testTypeConducted = testTypeConducted;
	}

	public LocalDate getFollowupDate() {
        return followupDate;
    }

    public void setFollowupDate(LocalDate followupDate) {
        this.followupDate = followupDate;
    }

    public String getConcatDate() {
		return concatDate;
	}

	public void setConcatDate(String concatDate) {
		this.concatDate = concatDate;
	}

	public LocalDate getNextFollowupDate() {
        return nextFollowupDate;
    }

    public void setNextFollowupDate(LocalDate nextFollowupDate) {
        this.nextFollowupDate = nextFollowupDate;
    }

    public List<ProductReviewDto> getProductReviewDtoList() {
        return productReviewDtoList;
    }

    public void setProductReviewDtoList(List<ProductReviewDto> productReviewDtoList) {
        this.productReviewDtoList = productReviewDtoList;
    }

    public Boolean getTreatmentCompleted() {
        return isTreatmentCompleted;
    }

    public void setTreatmentCompleted(Boolean treatmentCompleted) {
        isTreatmentCompleted = treatmentCompleted;
    }

	public FollowUpDatesDto getFollowUp() {
		return followUp;
	}

	public void setFollowUp(FollowUpDatesDto followUp) {
		this.followUp = followUp;
	}

	public Boolean getIsTreatmentCompleted() {
		return isTreatmentCompleted;
	}

	public void setIsTreatmentCompleted(Boolean isTreatmentCompleted) {
		this.isTreatmentCompleted = isTreatmentCompleted;
	}

	public String getSyphilisTestType() {
		return syphilisTestType;
	}

	public void setSyphilisTestType(String syphilisTestType) {
		this.syphilisTestType = syphilisTestType;
	}

	public String getSyphilisTestResult() {
		return syphilisTestResult;
	}

	public void setSyphilisTestResult(String syphilisTestResult) {
		this.syphilisTestResult = syphilisTestResult;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Long getSyphilisTestTypeId() {
		return syphilisTestTypeId;
	}

	public void setSyphilisTestTypeId(Long syphilisTestTypeId) {
		this.syphilisTestTypeId = syphilisTestTypeId;
	}

	public Long getSyphilisTestResultId() {
		return syphilisTestResultId;
	}

	public void setSyphilisTestResultId(Long syphilisTestResultId) {
		this.syphilisTestResultId = syphilisTestResultId;
	}
    
}
