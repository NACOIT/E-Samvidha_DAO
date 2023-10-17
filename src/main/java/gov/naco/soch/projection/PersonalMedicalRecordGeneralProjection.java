package gov.naco.soch.projection;

import java.time.LocalDate;

public interface PersonalMedicalRecordGeneralProjection {

	Long getId();

	String getUid();

	String getFirstName();

	String getLastName();

	int getAge();

	String getGender();

	LocalDate getRegDate();

	String getMiddleName();

	Double getHeight();

	Double getWeight();

	int getNoOfPartnersLinked();

	int getNoOfPartnersHivTested();

	int getNoOfPartnersHivReactive();

}
