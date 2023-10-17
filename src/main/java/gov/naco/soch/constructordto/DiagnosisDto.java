package gov.naco.soch.constructordto;

public class DiagnosisDto {
    private Long id;

    private String name;
    
    private Boolean isTreatmentCompleted;

    private Boolean isStatus = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatus() {
        return isStatus;
    }

    public void setStatus(Boolean status) {
        isStatus = status;
    }

	public Boolean getIsTreatmentCompleted() {
		return isTreatmentCompleted;
	}

	public void setIsTreatmentCompleted(Boolean isTreatmentCompleted) {
		this.isTreatmentCompleted = isTreatmentCompleted;
	}
   
}
