package gov.naco.soch.constants;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class IndicatorConstant {

	public static final String REQUEST_TYPE_INIT = "INIT";
	public static final String REQUEST_TYPE_CLICK = "CLICK";

	public static final Map<String, String> INDICATOR_SECTION_DESC_MAP;
	public static final Map<String, String> INDICATOR_DESC_MAP;
	static {
		Map<String, String> indicatorSectionDescMap = new HashMap<String, String>();
		indicatorSectionDescMap.put("SEC_1", "Section 1 : Service Uptake and Outcomes");
		indicatorSectionDescMap.put("SEC_2", "Section 2 : Psychosocial interventions ");
		indicatorSectionDescMap.put("SEC_3", "Section 3 : Referrals/Linkages and Other Services");
		INDICATOR_SECTION_DESC_MAP = Collections.unmodifiableMap(indicatorSectionDescMap);
		Map<String, String> indicatorDescMap = new HashMap<String, String>();
		indicatorDescMap.put("SEC_1A_2",
				"{'sNo':'1.2','description':'Number of new clients started on OST by the centre during the reporting month ','source':'Client Register - OST Clients (RF/2)'}");
		indicatorDescMap.put("SEC_1A_3",
				"{'sNo':'1.3','description':'Target assigned to the OST centre by SACS','source':'Client Register - OST Clients (RF/2)'}");
		indicatorDescMap.put("",
				"{'sNo':'1.4','description':'Of the total number of clients started on OST by the centre till the reporting month, number referred by other IDU TIs (cumulative)','source':'Client Register - New Clients & OST Clients (RF/1 & RF/2)'}");
		indicatorDescMap.put("SEC_1A_5",
				"{'sNo':'1.5','description':'Number of clients who completed treatment and were taken off medications by treating team during the reporting month','source':'Client files & Dispensing Register'}");
		indicatorDescMap.put("SEC_1A_6",
				"{'sNo':'1.6','description':'Total number of clients who completed treatment and were taken off medications by treating team till this month (cumulative)','source':'Client files & Dispensing Register'}");
		indicatorDescMap.put("SEC_1A_7",
				"{'sNo':'1.7','description':'Out of the total registered OST clients, number of clients not in treatment (did not receive even one dose during the reporting month) due to reasons like death, migration, imprisonment or transfer to other centres','source':'Sum of next 4 indicators'}");

		indicatorDescMap.put("SEC_1A_8",
				"{'sNo':'1.7a','description':'Out of the total registered OST clients, number of clients are not in treatment due to migration outside the city / town where OST centre is located (cumulative)','source':'Client Files & Master Register of TI'}");
		indicatorDescMap.put("SEC_1A_9",
				"{'sNo':'1.7b','description':'Out of the total registered OST clients, number of clients are not in treatment due ongoing imprisonment','source':'Client Files & Master Register of TI'}");
		indicatorDescMap.put("",
				"{'sNo':'1.7c','description':'Out of the total registered OST clients, number of clients formally transferred to other OST centres (in same district or another district) for the remaining duration of treatment','source':'Client files & Dispensing Register'}");
		indicatorDescMap.put("",
				"{'sNo':'1.7d','description':'Out of the total cumulative OST uptake, clients should be on treatment during the reporting month (i.e. who have not completed treatment and also not met other outcomes)','source':'Autogenerated'}");
		indicatorDescMap.put("",
				"{'sNo':'1.8','description':'Number of individual clients currently receiving OST from the centres in the reporting month (received medicines on at least one day during the reporting month)','source':'Sum of next 3 indicators'}");
		indicatorDescMap.put("",
				"{'sNo':'1.8a','description':'Number of clients receiving medicines for 25 or more days in the reporting month ','source':'Daily Dispensing Register (RF/8)'}");
		indicatorDescMap.put("",
				"{'sNo':'1.8b','description':'Number of clients receiving medicines for 15-24 days in the reporting month ','source':'Daily Dispensing Register (RF/8)'}");
		indicatorDescMap.put("",
				"{'sNo':'1.8c','description':'Number of clients receiving medicines for less than 15 days in the reporting month but received at least one dose','source':'Daily Dispensing Register (RF/8)'}");
		indicatorDescMap.put("",
				"{'sNo':'1.9','description':'Out of the expected OST clients, total number of clients who did not receive OST on even one day during the reporting month ','source':'Autogenerated'}");
		indicatorDescMap.put("",
				"{'sNo':'1.9a','description':'Out of the total registered OST clients, number of clients who have passed away (as reported by a family member / outreach staff of TI) (cumulative)','source':'Client Files & Master Register of TI'}");
		indicatorDescMap.put("",
				"{'sNo':'1.10','description':'Out of the expected OST clients, number of clients who were in treatment till preceding month but did not receive OST on even one day during the reporting month ','source':'Daily Dispensing Register (RF/8)'}");
		indicatorDescMap.put("",
				"{'sNo':'1.11','description':'Out of the total active OST clients, number of clients who re-enetered treatment (received at least one dose) during the reporting month','source':'Daily Dispensing Register (RF/8)'}");
		indicatorDescMap.put("",
				"{'sNo':'1.12','description':'Total number of OST dosages dispensed to the clients during the reporting month (sum of dosages dispensed on each day of the reporting month)','source':'Daily Dispensing Register (RF/8)'}");
		indicatorDescMap.put("SEC_2A_1",
				"{'sNo':'2.1','description':'Number of clients for whom clinical follow-up (follow-up with the doctor) was conducted at the clinic during the reporting month','source':'Client Register - Follow-up Clients'}");
		indicatorDescMap.put("SEC_2A_2",
				"{'sNo':'2.2','description':'Number of clients for whom psychosocial follow-up (follow-up with the counsellor) was conducted at the clinic during the reporting month','source':'Client Register - Follow-up Clients'}");
		indicatorDescMap.put("",
				"{'sNo':'2.3','description':'Number of LFU clients of previous month contacted by the outreach team of the TI during the reporting month','source':'PE Diary'}");
		indicatorDescMap.put("SEC_2A_4",
				"{'sNo':'2.4','description':'Number of individual (one-to-one) counselling sessions taken with the clients during the reporting month (excluding psychosocial follow-up visits)','source':'Counselling Register'}");
		indicatorDescMap.put("SEC_2A_5",
				"{'sNo':'2.5','description':'Number of group counselling sessions taken with the clients during the reporting month ','source':'Group Discussion Register'}");
		indicatorDescMap.put("SEC_2A_6",
				"{'sNo':'2.6','description':'Number of field visits made by the counsellor during the reporting month ','source':'Counselling Register'}");
		indicatorDescMap.put("SEC_2A_7",
				"{'sNo':'2.7','description':'Number of clients counseled on ART (treatment preparedness, adherence and Positive living) during the reporting month','source':'Counselling Register'}");
		indicatorDescMap.put("SEC_2A_8",
				"{'sNo':'2.8','description':'Number of OST clients counselled on reintegration during the month','source':'Counselling Register'}");
		indicatorDescMap.put("SEC_3A_1",
				"{'sNo':'3.1','description':'Number of individual OST clients referred to ICTC for HIV testing during the reporting month','source':'Referral Register'}");
		indicatorDescMap.put("SEC_3A_2",
				"{'sNo':'3.2','description':'Number of individual OST clients tested for HIV during the reporting month','source':'Referral Register'}");
		indicatorDescMap.put("SEC_3A_3",
				"{'sNo':'3.3','description':'Number of individual OST clients detected positive for HIV during the reporting month','source':'Referral Register'}");
		indicatorDescMap.put("SEC_3A_4",
				"{'sNo':'3.4','description':'Cumulative number of OST clients detected HIV positive till this month','source':'Referral Register'}");
		indicatorDescMap.put("SEC_3A_5",
				"{'sNo':'3.5','description':'Cumulative number of HIV positive OST clients linked with ART centre till this month ','source':'Referral Register'}");
		indicatorDescMap.put("",
				"{'sNo':'3.6','description':'Total number of OST clients currently on ART medicines','source':'Referral Register'}");
		indicatorDescMap.put("SEC_3B_1",
				"{'sNo':'3.7','description':'Number of condoms distributed to OST clients during the reporting month','source':'DIC Register'}");
		indicatorDescMap.put("SEC_3B_2",
				"{'sNo':'3.8','description':'Number of individual OST clients referred to STI clinic during the reporting month','source':'Referral Register'}");
		indicatorDescMap.put("SEC_3B_3",
				"{'sNo':'3.9','description':'Of the total individual OST clients diagnosed and treated for STI during the reporting month','source':'Referral Register'}");
		indicatorDescMap.put("SEC_3B_4",
				"{'sNo':'3.10','description':'Number of individual OST clients tested for syphilis during the month','source':'Referral Register'}");
		indicatorDescMap.put("SEC_3C_1",
				"{'sNo':'3.11','description':'Number of individual OST clients clinically screened for TB in the reporting month','source':'Referral Register'}");
		indicatorDescMap.put("SEC_3C_2",
				"{'sNo':'3.12','description':'Number of individual OST clients referred to TB treatment services in the reporting month','source':'Referral Register'}");
		indicatorDescMap.put("SEC_3C_3",
				"{'sNo':'3.13','description':'Number of individual OST clients diagnosed with TB in the reporting month','source':'Referral Register'}");
		indicatorDescMap.put("SEC_3C_4",
				"{'sNo':'3.14','description':'Total number of individual OST clients currently on treatment for TB (DOTS)','source':'Master Register'}");
		indicatorDescMap.put("SEC_3D_1",
				"{'sNo':'3.15','description':'Number of IDUs linked with Detoxification services during the month','source':'Referral Register'}");
		indicatorDescMap.put("SEC_3D_2",
				"{'sNo':'3.16','description':'Number of individual IDUs linked with rehabilitation services during the month','source':'Referral Register'}");
		indicatorDescMap.put("SEC_3D_3",
				"{'sNo':'3.17','description':'Number of clients linked with other welfare services (legal aid, shelter, nutrition, etc.)','source':'Referral Register'}");
		INDICATOR_DESC_MAP = Collections.unmodifiableMap(indicatorDescMap);
	}

}