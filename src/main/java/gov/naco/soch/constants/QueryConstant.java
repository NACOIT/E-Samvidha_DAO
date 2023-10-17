package gov.naco.soch.constants;

public final class QueryConstant {

	public final static String DAILY_DOSAGE_REPORT_FETCH_QUREY = "Select * from soch.fnGetRepDailyDosage(?,?,?)";
	public final static String DAILY_DOSAGE_REGISTRAION_DTL_QUERY = "select count(case when to_char(tb.date_of_reg,'MM') <= to_char(now(),'MM') then 1 else 0 end) as totalRegTillDate,\r\n"
			+ "count(case when to_char(tb.date_of_reg,'MM') = to_char(now(),'MM') then 1 else 0 end) as currenTMonthReg\r\n"
			+ "from soch.ti_beneficiary tb inner join soch.facility f on f.id = tb.facility_id where f.id = ?";

	public static final String FACILITY_PERFORM_SEC_1 = "";
	public static final String FACILITY_PERFORM_SEC_2 = "";
	public static final String FACILITY_PERFORM_SEC_3 = "";

}
