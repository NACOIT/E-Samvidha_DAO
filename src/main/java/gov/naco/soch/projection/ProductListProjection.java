package gov.naco.soch.projection;

import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDate;



public interface ProductListProjection {
		
	String getPlCenName();
	String getPlAddr();
	String getPlCity();
	String getPlDist();
	String getPlState();
	String getPlPin();
	String getPlProdName();
	String getPlBatchNum();
	Date getPlManfDate();
	Date getPlExprDate();
	int getPlAvailStock();
	int getPlStockConsumed();
	String getPlUom();
	void setPlCenName(String PlCenName);
	void setPlAddr(String PlAddr);
	void setPlCity(String PlCity);
	void setPlDist(String PlDist);
	void setPlState(String PlState);
	void setPlPin(String PlPin);
	void setPlProdName(String PlProdName);
	void setPlBatchNum(String PlBatchNum);
	void setPlManfDate(Date PlManfDate);
	void setPlExprDate(Date PlExprDate);
	void setPlAvailStock(int PlAvailStock);
	void setPlStockConsumed(int PlStockConsumed);
	void setPlUom(int PlUom);
}
