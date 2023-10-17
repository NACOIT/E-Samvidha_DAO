package gov.naco.soch.constants;

public final class BeneficiaryServiceQueryConstant {

	public static final String SERVICE_ASSESSMENT_QUERY = "select jsonStr.serviceTypeId,jsonStr.dateone, jsonStr.datetwo,jsonStr.datetwovalid ,jsonStr.datetwoevent, jsonStr.datethree,jsonStr.datethreevent ,string_agg(jsonStr.eventdataone,'||') as eventdataone,null as eventdatatwo,\r\n"
			+ "				null as eventdatathree,null  as eventdatafour,null as eventdatafive from  (select '1' as serviceTypeId,tbrv.assessment_date as dateone,tbrv.due_date_of_assessment as datetwo,\r\n"
			+ "case when tbrv.due_date_of_assessment = (select max(due_date_of_assessment) from ti_ben_rv_assessment ta inner join ti_beneficiary tb on tb.id  = ta.beneficiary_id  where tb.beneficiary_id = :beneficiaryId )\r\n"
			+ "				then true else false end as datetwovalid,false as datetwoevent, null as datethree,false as datethreevent, json_build_object(\r\n"
			+ "        'question', json_agg(q2.\"name\"),\r\n" + "        'answer', json_agg(sa.answer)\r\n"
			+ "    ):: varchar  as eventdataone\r\n"
			+ " from beneficiary b inner join ti_beneficiary tb on tb.beneficiary_id  = b.id \r\n"
			+ "inner join ti_ben_rv_assessment tbrv on tbrv.beneficiary_id  = tb.id\r\n"
			+ "left join survey_answer sa on sa.survey_id  = tbrv.survey_id \r\n"
			+ "left join question q2 on q2.id = sa.question_id \r\n"
			+ "where tb.beneficiary_id  = :beneficiaryId group by q2.\"name\" ,sa.answer,tbrv.assessment_date,tbrv.due_date_of_assessment) jsonStr group by jsonStr.serviceTypeId,jsonStr.dateone,jsonStr.datetwo,jsonStr.datetwovalid,jsonStr.datetwoevent,jsonStr.datethree,jsonStr.datethreevent";

	public static final String SERVICE_COMMODITY_DISTRIBUTE_QUERY = " select '2' as serviceTypeId, (case when tbc.condoms_distributed >0 then tbc.distribution_date else null end ) as dateone,\r\n" + 
			"null as datetwo ,false as datetwovalid,false as datetwoevent, null as datethree,false as datethreevent ,\r\n" + 
			"coalesce(condoms_distributed,0)  as eventdataone,\r\n" + 
			"coalesce(syringes_distributed,0) as eventdatatwo, \r\n" + 
			"coalesce(needles_distributed,0) eventdatathree , \r\n" + 
			"mct.name  as eventdatafour,\r\n" + 
			"tm.typology_name as eventdatafive\r\n" + 
			"from soch.ti_beneficiary_comm_dis tbc \r\n" + 
			"left join soch.ti_beneficiary tb on tb.id  = tbc.beneficiary_id \r\n" + 
			"left join soch.typology_master tm on tm.typology_id  = tb.master_hrg_primary_id\r\n" + 
			"left join soch.master_contact_type mct on mct.id = tbc.master_contact_type_id\r\n" + 
			"where tb.beneficiary_id = :beneficiaryId ";

	public static final String SERVICE_COUNSELLING_QUERY = "select '3' as serviceTypeId , tc.counselling_date as dateone, tc.next_counselling_date as datetwo,\r\n"
			+ "				case when tc.next_counselling_date = (select max(tbc.next_counselling_date) from ti_ben_counselling tbc inner join ti_beneficiary tob on tob.id  = tbc.beneficiary_id where tob.beneficiary_id = :beneficiaryId )\r\n"
			+ "				then true else false end as datetwovalid,false as datetwoevent, null as datethree,false as datethreevent , string_agg(mct.name , '; ')   as eventdataone , tc.no_of_condoms_distributed as  eventdatatwo,\r\n"
			+ "			null as eventdatathree,null as eventdatafour,null as eventdatafive from ti_ben_counselling tc inner join ti_beneficiary tob on tob.id  = tc.beneficiary_id\r\n"
			+ "			left join ti_ben_counselling_type ct on tc.id = ct.counselling_id left join master_counselling_type mct on ct.master_counselling_type_id  = mct.id \r\n"
			+ "			where tob.beneficiary_id = :beneficiaryId group by serviceTypeId,tc.counselling_date,tc.next_counselling_date,tc.no_of_condoms_distributed";

	
	public static final String SERVICE_CLINICAL_TREAT_QUERY = " select '4' as serviceTypeId , \r\n" + 
			"case when mctt.id = 1  then bsrtd.followup_date \r\n" + 
			"when mctt.id = 2  then batd.followup_date \r\n" + 
			"when mctt.id = 3 then bootd.followup_date \r\n" + 
			"when mctt.id = 4 then bct.treatment_date \r\n" + 
			"else null end as dateone, \r\n" + 
			"case when mctt.id in( 1,2,3,4) then mctt.name \r\n" + 
			"else null end as eventdataone, \r\n" + 
			"case when mctt.id = 1 then msrdt.name \r\n" + 
			"else null end as eventdatatwo, \r\n" + 
			"case when mctt.id = 1 then string_agg( distinct concat ( 'Batch No : ',bsrtd.batch_number ,' Product Name : ',  p.product_name,' Dispensed Count : ',  bsrtd.dispense_qty),',') \r\n" + 
			"else null end as eventdatathree , \r\n" + 
			"null as  eventdatafour  , \r\n" + 
			"null as eventdatafive,false  as datetwovalid ,null as datetwo ,  \r\n" + 
			"false as datetwoevent , null as datethree , false as datethreevent \r\n" + 
			"from soch.beneficiary_clinical_treatment bct \r\n" + 
			"join soch.master_clinical_treatment_type mctt on mctt.id = bct.clinical_treatment_type_id \r\n" + 
			"left join soch.beneficiary_sti_rti_treatment_details bsrtd on bsrtd.clinical_treatment_id = bct.id \r\n" + 
			"left join soch.master_diagnosis_type msrdt on msrdt.id = bsrtd.sti_rti_diagnosis_type_id \r\n" + 
			"left join soch.product p on p.id = bsrtd.sti_rti_prod_id \r\n" + 
			"left join soch.beneficiary_abscess_treatment_details batd on batd.clinical_treatment_id = bct.id \r\n" + 
			"left join soch.beneficiary_opioid_overdose_treatment_details bootd on bootd.clinical_treatment_id = bct.id \r\n" + 
			"where bct.beneficiary_id = :beneficiaryId  \r\n" + 
			"group by mctt.id , bsrtd.followup_date , batd.followup_date , \r\n" + 
			"bootd.followup_date ,msrdt.name,bct.treatment_date " ;

	public static final String SERVICE_SCREENING = "select '5' as serviceTypeId , tbs.date_of_screening  as dateone, tbs.next_date_of_screening as datetwo,case when next_date_of_screening = (select max(tbs.next_date_of_screening) from ti_ben_scr_details tbs\r\n"
			+ "							inner join ti_beneficiary tb on tb.id  = tbs.beneficiary_id  where tb.beneficiary_id = :beneficiaryId )\r\n"
			+ "							then true else false end as datetwovalid,false as datetwoevent, null as datethree,false as datethreevent , it.name as eventdataone,(case when tbs.screening_status_hiv_id is not null then hss.name\r\n"
			+ "							when tbs.screening_status_syphilis_id is not null then ss.name when tbs.tb_status_id 	is not null then tbss.name end)as eventdatatwo ,\r\n"
			+ "							null as eventdatathree,null as eventdatafour, null as eventdatafive from ti_ben_scr_details tbs inner join ti_beneficiary tb on tb.id  = tbs.beneficiary_id and tbs.is_deleted = false \r\n"
			+ "							left join master_infection_type it on it.id = tbs.infection_id left join master_hiv_screening_status hss on tbs.screening_status_hiv_id  = hss.id left join \r\n"
			+ "							master_syphilis_status ss on ss.id = tbs.screening_status_syphilis_id left join master_tb_screening_status tbss on tbss.id = tbs.tb_status_id \r\n"
			+ "						 	where tb.beneficiary_id = :beneficiaryId group by serviceTypeId,tbs.date_of_screening,tbs.next_date_of_screening,it.name\r\n"
			+ "							,tbs.screening_status_hiv_id,hss.name,tbs.screening_status_syphilis_id ,ss.name,tbs.tb_status_id,tbss.name";

	public static final String SERVICE_OST_ASSESSMENT_QUERY = "select '6' as serviceTypeId , tio.date_of_assessment  as dateone, null as datetwo,\r\n"
			+ "				false  as datetwovalid,false as datetwoevent, null as datethree,false as datethreevent,tio.diagnosis as eventdataone,tio.advice as eventdatatwo,null as eventdatathree,null as eventdatafour,\r\n"
			+ "				null as eventdatafive from ti_ost_assessment tio inner join ti_ost_beneficiary tob on tio.ti_ost_beneficiary_id  = tob.id  where tob.beneficiary_id  = :beneficiaryId\r\n"
			+ "				group by serviceTypeId,tio.date_of_assessment,tio.next_date_of_assessment,tio.diagnosis,tio.advice";

	public static final String SERVICE_OST_FOLLOW_QUERY = "select '7' as serviceTypeId , tof.follow_up_date  as dateone, tof.next_followup_date as datetwo,\r\n"
			+ "			case when tof.next_followup_date = (select max(next_followup_date)  from ti_ost_follow_up o inner join ti_ost_beneficiary tob  on o.ti_ost_beneficiary_id  = tob.id where tob.beneficiary_id  = :beneficiaryId)\r\n"
			+ "			then true else false end as datetwovalid,false as datetwoevent, null as datethree,false as datethreevent,null as eventdataone,null as eventdatatwo,null as eventdatathree,null as eventdatafour,\r\n"
			+ "			null as eventdatafive 	from ti_ost_follow_up tof inner join ti_ost_beneficiary tob  on tof.ti_ost_beneficiary_id  = tob.id where\r\n"
			+ "			tob.beneficiary_id  = :beneficiaryId group by serviceTypeId,tof.follow_up_date,tof.next_followup_date";

	public static final String SERVICE_OST_DISPENSE_QUERY = "select tod.dispensation_date as dateone,'8' as serviceTypeId  , null as datetwo,\r\n"
			+ "						false as datetwovalid,false as datetwoevent, null as datethree,false as datethreevent,md.name as eventdataone,\r\n"
			+ "						top.dosage_qty as eventdatatwo,tod.take_home_days  as eventdatathree,null as eventdatafour,\r\n"
			+ "						null as eventdatafive from (select * from ti_ost_dispensation_item where ost_dispensation_item_id in\r\n"
			+ "						(select max(ost_dispensation_item_id ) from ti_ost_dispensation_item where ti_ost_beneficiary_id  = (select id from ti_ost_beneficiary tob2 where beneficiary_id  = :beneficiaryId)group by dispensation_date  )) \r\n"
			+ "						tod inner join ti_ost_prescription top on tod.ti_ost_prescription_id  = top.id  inner join ti_ost_beneficiary tob on tob.id = tod.ti_ost_beneficiary_id \r\n"
			+ "						left join master_drugs md on md.id = top.substitution_drug where tob.beneficiary_id  = :beneficiaryId  and tob.is_active  = true";

	public static final String TI_REFERRAL = "select '9' as serviceTypeId,br.refer_date as dateone ,null as datetwo ,false as datetwovalid,false as datetwoevent, null as datethree,false as datethreevent,\r\n"
			+ "						ft.facility_type_name  as eventdataone ,f.\"name\" as eventdatatwo,null as eventdatathree, null as eventdatafour, null as eventdatafive\r\n"
			+ "						from beneficiary b inner join ti_beneficiary tb on b.id = tb.beneficiary_id	inner join beneficiary_referral br on b.id = br.beneficiary_id \r\n"
			+ "						inner join facility f on f.id = br.refered_to inner join facility_type ft on ft.id = f.facility_type_id \r\n"
			+ "						where br.refered_from = :facilityId and tb.beneficiary_id  = :beneficiaryId";

	public static final String OST_REFERRAL = "select '10' as serviceTypeId,br.refer_date as dateone ,null as datetwo ,false as datetwovalid,false as datetwoevent, null as datethree,false as datethreevent,\r\n"
			+ "						ft.facility_type_name  as eventdataone ,f.\"name\" as eventdatatwo,null as eventdatathree, null as eventdatafour, null as eventdatafive\r\n"
			+ "						from beneficiary b inner join ti_ost_beneficiary tob on b.id = tob.beneficiary_id	inner join beneficiary_referral br on b.id = br.beneficiary_id \r\n"
			+ "						inner join facility f on f.id = br.refered_to inner join facility_type ft on ft.id = f.facility_type_id \r\n"
			+ "						where br.refered_from = :facilityId and tob.beneficiary_id  = :beneficiaryId";

}
