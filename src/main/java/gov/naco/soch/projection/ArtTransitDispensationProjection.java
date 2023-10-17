/**
 * 
 */
package gov.naco.soch.projection;

import java.time.LocalDate;

/**
 * @author Jiji_145999
 *
 * @date 26-Nov-2020 11:40:53 am
 */
public interface ArtTransitDispensationProjection {
	
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


}
