package gov.naco.soch.projection;

import java.util.Date;

public interface ContractProductScheduleSacsLotProjection {

	Long getLotId();

	Integer getScheduleSacsId();

	Date getStartDate();

	Date getEndDate();

	Long getQuantity();

	String getLotNumber();
}
