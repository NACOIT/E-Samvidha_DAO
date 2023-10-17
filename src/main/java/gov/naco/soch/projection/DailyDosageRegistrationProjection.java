package gov.naco.soch.projection;

public interface DailyDosageRegistrationProjection {

	int getTotalRegTillDate();

	int getCurrenTMonthReg();

	void setTotalRegTillDate(int count);

	void setCurrenTMonthReg(int count);

}
