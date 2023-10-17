package gov.naco.soch.constructordto;

import java.time.LocalDate;
import java.util.List;

public class OngoingReviewDto {

    private List<DiagnosisDto> diagnosisDtos;

    private String firstName;

    private String lastname;

    private Integer age;

    private String gender;

    private Integer totalNode;
    
    private FollowUpDatesDto followUp;

    private List<ReviewDateDto> reviewDateDto;
    
    private Boolean isLapOrIb;
    
    //private List<LocalDate> syphilisFollowupDates;
    
    //private List<ProductReviewDto> syphilisproductList;
    
    //private List<String> titreList;
    
    //private List<String> syphilisTestResult;

    private String infantCode;
    private Boolean isPregnant;
    
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

	public List<DiagnosisDto> getDiagnosisDtos() {
        return diagnosisDtos;
    }

    public void setDiagnosisDtos(List<DiagnosisDto> diagnosisDtos) {
        this.diagnosisDtos = diagnosisDtos;
    }

    public Integer getTotalNode() {
        return totalNode;
    }

    public void setTotalNode(Integer totalNode) {
        this.totalNode = totalNode;
    }




    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<ReviewDateDto> getReviewDateDto() {
        return reviewDateDto;
    }

    public void setReviewDateDto(List<ReviewDateDto> reviewDateDto) {
        this.reviewDateDto = reviewDateDto;
    }

	public Boolean getIsLapOrIb() {
		return isLapOrIb;
	}

	public void setIsLapOrIb(Boolean isLapOrIb) {
		this.isLapOrIb = isLapOrIb;
	}

	public FollowUpDatesDto getFollowUp() {
		return followUp;
	}

	public void setFollowUp(FollowUpDatesDto followUp) {
		this.followUp = followUp;
	}

	public String getInfantCode() {
		return infantCode;
	}

	public void setInfantCode(String infantCode) {
		this.infantCode = infantCode;
	}

	public Boolean getIsPregnant() {
		return isPregnant;
	}

	public void setIsPregnant(Boolean isPregnant) {
		this.isPregnant = isPregnant;
	}

	/*public List<LocalDate> getSyphilisFollowupDates() {
		return syphilisFollowupDates;
	}

	public void setSyphilisFollowupDates(List<LocalDate> syphilisFollowupDates) {
		this.syphilisFollowupDates = syphilisFollowupDates;
	}

	public List<ProductReviewDto> getSyphilisproductList() {
		return syphilisproductList;
	}

	public void setSyphilisproductList(List<ProductReviewDto> syphilisproductList) {
		this.syphilisproductList = syphilisproductList;
	}

	public List<String> getTitreList() {
		return titreList;
	}

	public void setTitreList(List<String> titreList) {
		this.titreList = titreList;
	}

	public List<String> getSyphilisTestResult() {
		return syphilisTestResult;
	}

	public void setSyphilisTestResult(List<String> syphilisTestResult) {
		this.syphilisTestResult = syphilisTestResult;
	} */
	
	
}
