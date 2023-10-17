package gov.naco.soch.projection;

import java.time.LocalDate;

public interface ArtBeneficiaryProjection {

    String getUid();
    String getGender();
    String getPreArtNumber();
    String getArtNumber();
    String getFirstName();
    String getMiddleName();
    String getLastName();
    Long getBeneficiaryId();
    String getArtStatus();
    LocalDate getDateOfBirth();
}
