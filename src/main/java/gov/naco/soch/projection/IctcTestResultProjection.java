package gov.naco.soch.projection;

public interface IctcTestResultProjection {

	Long getId();
	
	Long getHivType();

	Long getHivStatus();

	void setId(Long id);
	
	void setHivType(Long hivType);

	void setHivStatus(Long hivStatus);
}
