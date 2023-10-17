package gov.naco.soch.projection;

import java.util.Date;

public interface BeneficiaryBasicProjection {

	Long getId();

	String getUid();

	String getFirstName();

	String getLastName();

	int getAge();

	String getGender();

	Date getRegDate();

	String getMiddleName();
}
