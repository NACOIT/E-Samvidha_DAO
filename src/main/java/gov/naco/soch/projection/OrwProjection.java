package gov.naco.soch.projection;

import java.util.Set;

import gov.naco.soch.entity.UserRoleMapping;

public interface OrwProjection {
	
	Long getId();
	
	String getFirstname();
	
	String getOrwCode();
	
	String getPeCode();
	
	Long getRoleId();

}
