package gov.naco.soch.projection;

import java.time.LocalDate;

public interface ArtBeneficiaryDispensationProjection {

	Long getArtDispensationId();

	String getUid();

	String getGender();

	String getPreArtNumber();

	String getArtNumber();

	String getFirstName();

	String getMiddleName();

	String getLastName();

	Long getBeneficiaryId();

	Long getArtBeneficiaryId();

	LocalDate getDateOfBirth();

	LocalDate getDispensationDate();
	
	LocalDate getNextAppDate();

	Long getDispenseQuantity();

	String getVisitBy();
	
	Long getProductId();

	String getProductName();
	
	Long getVisitId();
	

}
