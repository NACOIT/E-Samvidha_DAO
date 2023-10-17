package gov.naco.soch.projection;

import java.math.BigInteger;

public interface StockDetailsProjection {
	
	String getProductName();
	
	BigInteger getAvailableQuantity();
	
	BigInteger getExpiredQuantity();
	
	BigInteger getDispensedQuantity();
	
	

}
