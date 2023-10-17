package gov.naco.soch.constructordto;

public class ScreeningDTO {
    
    private Long id;
    private Long  status;
    
    public ScreeningDTO(Long id, Long status) {
	super();
	this.id = id;
	this.status = status;
    }
    
    public Long getId() {
        return id;
    }   
    public void setId(Long id) {
        this.id = id;
    }
    public Long getStatus() {
        return status;
    }
    public void setStatus(Long status) {
        this.status = status;
    }
    
    

}
