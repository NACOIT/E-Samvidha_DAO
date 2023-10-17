package gov.naco.soch.projection;

import java.util.Date;

public interface ProfileIptAndTbStatusProjection {

	Date getIptStartDate();

	Date getIptStopDate();

	Date getIptRestartDate();

	Date getIptEndDate();

	Date getTbDiagnoseDate();

	Date getAttStartDate();

	Date getTbCompleteDate();

}
