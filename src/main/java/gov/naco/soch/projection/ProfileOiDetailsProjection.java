package gov.naco.soch.projection;

import java.util.Date;

public interface ProfileOiDetailsProjection {

	Long getVisitId();

	Long getBeneficiaryId();

	Date getVisitDate();

	String getOiItems();

	String getRemarks();

}
