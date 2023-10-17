package gov.naco.soch.projection;

import java.time.LocalDate;

public interface ArtDispensationItemProjection {

	Long getProductId();

	String getProductName();

	Long getDispensedQuantity();

	Long getReturnedQuantity();
	
	Long getArtDispensationId();
	
	Float getAdherence();
	
	LocalDate getVisitDate();

}
