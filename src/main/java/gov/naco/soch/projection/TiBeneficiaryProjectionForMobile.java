package gov.naco.soch.projection;

import java.time.LocalDate;

public interface TiBeneficiaryProjectionForMobile {
	Long getId();
	Long getStatusId();
	String getStatus();
	Long getFacilityId();
    Long getBeneficiaryId();
    String getUid();
    LocalDate getDateOfBirth();
    String getFirstName();
    String getMiddleName();
    String getLastName();
    String getMobile();
    String getTiCode();
    Long getTypologyId();
    String getTypologyName();
    String getGender();
    String getMasterClientStatus();
    Long getBfmId();
    Long getBfmBenId();
    Long getBfmFacilityId();
    Long getBfmFacilityTypeId();
    LocalDate getDateOfReg();
    String getOrwCode();
}
