package gov.naco.soch.projection;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface ArtDispensationProjection {

	String getUid();

	Long getId();

	Long getBeneficiaryId();

	String getFirstName();

	String getMiddleName();

	String getLastName();

	String getPreArtNumber();

	String getArtNumber();

	LocalDate getDateOfBirth();

	String getGender();

	LocalDate getDispenseDate();

	String getCategory();

	String getProxy();

	LocalDate getNextAppointmentDate();
	
	Boolean getIsTransit();
	
	LocalDateTime getModifiedTime();

}