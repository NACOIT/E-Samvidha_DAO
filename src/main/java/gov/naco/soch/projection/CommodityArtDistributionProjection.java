package gov.naco.soch.projection;

import java.util.Date;

public interface CommodityArtDistributionProjection {
	
	Date getDispenseDate();
	String getProductName();
	String getDisenseQty();
	String getUomName();

}
