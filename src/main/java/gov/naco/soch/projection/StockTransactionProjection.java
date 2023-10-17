package gov.naco.soch.projection;

import java.sql.Date;

public interface StockTransactionProjection {
	
	String getStrCenName();
	String getStrPrdName();
	Date getStrTrnDate();
	//String getStrTrnDate();
	String getStrTrnType();
	int getStrWdlTbs();
	int getStrDepTbs();
	int getStrBalance();
	String getStrTrnRem();
	void setStrCenName(String StrCenName);
	void setStrPrdName(String StrPrdName);
	void setStrTrnDate(Date StrTrnDate);
	//void setStrTrnDate(String StrTrnDate);
	void setStrTrnType(String StrTrnType);
	void setStrWdlTbs(int StrWdlTbs);
	void setStrDepTbs(int StrDepTbs);
	void setStrBalance(int StrBalance);
	void setStrTrnRem(String StrTrnRem);

}
