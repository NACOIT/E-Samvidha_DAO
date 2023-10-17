package gov.naco.soch.projection;

import java.time.LocalDate;

public interface ArtBeneficiaryListProjection {
     String getUid();
     String getGender();
     String getPreArtNumber();
     String getArtNumber();
     String getOldPreArtNumber();
     String getOldArtNumber();
     String getStatus();
     String getFirstName();
     String getMiddleName();
     String getLastName();
     Long getBeneficiaryId();
     LocalDate getDateOfBirth();
     Boolean getLacLinked();
     String getArtTransferStatus();
     Boolean getIsTransit();
     String  getTransferredTo();
     LocalDate getExpectedVisitDate();
     
}
