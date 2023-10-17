package gov.naco.soch.projection;

import java.util.Date;

public interface ProfileWidgetProjection {
	int getResultId();

	String getResultType();

	String getResultValue();

	Date getResultDate();
}
