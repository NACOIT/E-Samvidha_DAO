package gov.naco.soch.projection;

import java.util.Date;

public interface DashboardStockAdjustProjection {

	Long getSlNo();

	String getPName();

	Date getAdjustDate();

	String getUom();

	Long getQuantity();

	String getAdjustreason();

}
