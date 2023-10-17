package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.projection.ProfileChartCDAndVLProjection;
import gov.naco.soch.projection.ProfileDispensationDetailsProjection;
import gov.naco.soch.projection.ProfileFamilyDetailsProjection;
import gov.naco.soch.projection.ProfileIptAndTbStatusProjection;
import gov.naco.soch.projection.ProfileOiDetailsProjection;
import gov.naco.soch.projection.ProfileWidgetProjection;

@Repository
public interface MiniDashBoardProfileRepository extends CrudRepository<Beneficiary, Long> {
	@Query(nativeQuery = true, value = "select b.id as beneficiaryId,CONCAT(b.first_name ,b.last_name) as beneficiaryName, mr.name as relationType,mabs.name as artStatus ,b.art_number as artNumber,b.pre_art_number as preArtNumber  from beneficiary_family_details bfd  inner join beneficiary b\r\n"
			+ "		on b.id = bfd.member_beneficiary_id inner join master_relationship mr  on bfd.relationship_id  = mr.id \r\n"
			+ "		left join art_beneficiary ab on ab.beneficiary_id = bfd.member_beneficiary_id\r\n"
			+ "		left join master_art_beneficiary_status mabs on mabs.id = ab.art_beneficiary_status_id \r\n"
			+ "		where bfd.beneficiary_id = :beneficairyId")
	public List<ProfileFamilyDetailsProjection> getprofileFamilyDetails(@Param("beneficairyId") Long beneficairyId);

	@Query(nativeQuery = true, value = "select bvr.id,bvr.visit_date as visitDate,p.product_name as productname,coalesce (adi.dispense_quantity,0) as givenQty,coalesce(adi.adherence_to_art,0) as adherencePercentage,\r\n"
			+ "					0 as regulationOfVisitStatus, (select expected_visit_date from art_beneficiary_due_list\r\n"
			//+ "					where beneficiary_id  = :beneficairyId and facility_id  = :facilityId and visit_register_id = (select max(visit_register_id) from  art_beneficiary_due_list where visit_register_id < ad.visit_register_id  group by created_time ,expected_visit_date order by created_time desc  limit 1)\r\n"
			+ "					where beneficiary_id  = :beneficairyId and facility_id  = :facilityId and visit_register_id = (select max(visit_register_id) from  art_beneficiary_due_list where visit_register_id < ad.visit_register_id and beneficiary_id = :beneficairyId)\r\n"
			+ "					and case when (select count(*) from role_access_mapping where role_id = urm .role_id and access_code ='ART-PHARMACIST') >0 then true else false end limit 1)\r\n"
			+ "					as expectedVisitDate,ad.dispense_date as dispenseddate"
			+ "					from art_beneficiary ab inner join beneficiary b on ab.beneficiary_id  = b.id \r\n"
			+ "					inner join art_dispensation ad on ab.beneficiary_id  = ad.beneficiary_id \r\n"
			+ "					left join user_role_mapping urm on urm.user_id  = ad.entry_user \r\n"
			+ "					inner join beneficiary_visit_register bvr on ad.visit_register_id = bvr.id\r\n"
			+ "					inner join art_dispensation_item adi on adi.art_dispensation_id  = ad.id\r\n"
			+ "					inner join product p on p.id = adi.product_id\r\n"
			+ "					where ab.beneficiary_id =  :beneficairyId order by ad.dispense_date desc limit 6")
	public List<ProfileDispensationDetailsProjection> getprofileDispensationDetails(
			@Param("beneficairyId") Long beneficairyId, @Param("facilityId") Long facilityI);

	@Query(nativeQuery = true, value = "select ROW_NUMBER () OVER (ORDER BY lts.result_received_date desc) as resultId, lts.result_value as resultValue ,lts.result_received_date as resultDate  from  soch.lab_test_sample lts\r\n"
			+ "			 inner join soch.facility f on f.id = lts.sample_collected_facility_id\r\n"
			+ "			 inner join soch.test t on t.id = lts.test_id  \r\n"
			+ "			 where t.id = 1 and lts.beneficiary_id = :beneficairyId\r\n"
			+ "		 	 and f.id = :facilityId and lts.is_delete=false limit 12")
	public List<ProfileWidgetProjection> getProfileCDFourWidgetData(@Param("beneficairyId") Long beneficairyId,
			@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select ROW_NUMBER () OVER (ORDER BY lts.result_received_date desc) as resultId,mrt.result_type as resultType, lts.result_value as resultValue ,lts.result_received_date as resultDate  from  soch.lab_test_sample lts\r\n"
			+ "			 inner join soch.facility f on f.id = lts.sample_collected_facility_id\r\n"
			+ "			 inner join soch.test t on t.id = lts.test_id  \r\n"
			+ "			 inner join master_result_type mrt on mrt.id  = lts.result_type_id \r\n"
			+ "			 where t.id = 2 and lts.beneficiary_id = :beneficairyId\r\n"
			+ "		 	 and f.id = :facilityId and lts.is_delete=false limit 12")
	public List<ProfileWidgetProjection> getProfileVLWidgetData(@Param("beneficairyId") Long beneficairyId,
			@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select bvr.id as visitId,bvr.beneficiary_id as beneficiaryId, bvr.visit_date as visitDate,string_agg(moi.name,', ') as oiItems,abf.opportunistic_infections_remarks as remarks from beneficiary_visit_register bvr\r\n"
			+ "			 inner join beneficiary b on b.id = bvr.beneficiary_id inner join art_beneficiary ab on ab.beneficiary_id = b.id \r\n"
			+ "			 inner join  art_beneficiary_opportunistic_infections aboi on aboi.visit_register_id = bvr.id \r\n"
			+ "			 inner join master_opportunistic_infections moi on moi.id = aboi.opportunistic_infection_id \r\n"
			+ "			 left join art_beneficiary_followup abf on abf.visit_register_id = bvr.id where b.id = :beneficairyId and ab.facility_id = :facilityId\r\n"
			+ "			 group by bvr.id,abf.opportunistic_infections_remarks,b.id order by bvr.visit_date desc limit 3")
	public List<ProfileOiDetailsProjection> getProfileOIData(@Param("beneficairyId") Long beneficairyId,
			@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select  abiad.ipt_start_date as iptStartDate ,abiad.ipt_stop_date as iptStopDate ,abiad.ipt_restart_date as iptRestartDate,abiad.ipt_end_date as iptEndDate,\r\n"
			+ "			abiad.tb_diagnosis as tbDiagnoseDate , abiad.att_start_date as attStartDate ,abiad.tb_treatment_completion_date as tbCompleteDate  \r\n"
			+ "			from art_beneficiary_ipt_att_details abiad inner join beneficiary b\r\n"
			+ "			on b.id = abiad.beneficiary_id inner join art_beneficiary ab on ab.beneficiary_id = b.id where b.id = :beneficairyId and ab.facility_id = :facilityId")
	public ProfileIptAndTbStatusProjection getProfileIptAndTbStatusData(@Param("beneficairyId") Long beneficairyId,
			@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select coalesce (max(cast(result_value as INTEGER )),0) as maxValue,coalesce (min(cast(result_value as INTEGER )),0) as minValue  from  soch.lab_test_sample lts"
			+ "				 inner join soch.facility f on f.id = lts.sample_collected_facility_id\r\n"
			+ "				 inner join soch.test t on t.id = lts.test_id  \r\n"
			+ "				 where t.id = 1 and lts.beneficiary_id = :beneficairyId\r\n"
			+ "			 	 and f.id = :facilityId and lts.is_delete=false")
	public ProfileChartCDAndVLProjection getProfileCDFourCountData(@Param("beneficairyId") Long beneficairyId,
			@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select coalesce (max(cast(result_value as INTEGER )),0) as maxValue,coalesce (min(cast(result_value as INTEGER )),0) as minValue  from  soch.lab_test_sample lts"
			+ "					 inner join soch.facility f on f.id = lts.sample_collected_facility_id\r\n"
			+ "					 inner join soch.test t on t.id = lts.test_id  \r\n"
			+ "				 	where t.id = 2 and lts.beneficiary_id = :beneficairyId\r\n"
			+ "			 	 	and f.id = :facilityId and lts.is_delete=false")
	public ProfileChartCDAndVLProjection getProfileVLFourCountData(@Param("beneficairyId") Long beneficairyId,
			@Param("facilityId") Long facilityId);
	
	@Query(nativeQuery = true, value = "select bvr.id,ad.dispense_date as visitDate,p.product_name as productname,coalesce (adi.dispense_quantity,0) as givenQty, coalesce(adi.adherence_to_art,0) as adherencePercentage,\r\n" + 
			"0 as regulationOfVisitStatus,(select expected_visit_date from soch.art_beneficiary_due_list where beneficiary_id  =:beneficairyId and facility_id  =:facilityId \r\n" + 
			" and visit_register_id = (select max(visit_register_id) \r\n" + 
			"                          from  soch.art_beneficiary_due_list \r\n" + 
			"						  where visit_register_id < ad.visit_register_id and beneficiary_id = :beneficairyId ) \r\n" + 
			//"group by created_time ,expected_visit_date order by created_time desc  limit 1)\r\n" + 
			"and case when (select count(*) from soch.role_access_mapping where role_id = urm .role_id and access_code ='ART-PHARMACIST') >0 then true else false end limit 1)\r\n" + 
			"as expectedVisitDate, ad.dispense_date as dispenseddate\r\n" + 
			"from soch.art_beneficiary ab inner join soch.beneficiary b on ab.beneficiary_id  = b.id \r\n" + 
			"inner join soch.art_dispensation ad on ab.beneficiary_id  = ad.beneficiary_id \r\n" + 
			"left join soch.user_role_mapping urm on urm.user_id  = ad.entry_user \r\n" + 
			"inner join soch.beneficiary_visit_register bvr on ad.visit_register_id = bvr.id\r\n" + 
			"inner join soch.art_dispensation_item adi on adi.art_dispensation_id  = ad.id\r\n" + 
			"inner join soch.product p on p.id = adi.product_id\r\n" + 
			"inner join soch.product_commodity_type_master pctm on pctm.id = p.product_commodity_type_id\r\n" + 
			"where ab.beneficiary_id =  :beneficairyId and lower(pctm.product_commodity_type_name) = lower(:name) \r\n" + 
			"order by ad.dispense_date desc limit 6 ")
	public List<ProfileDispensationDetailsProjection> getprofileDispensationDetailsByName(@Param("beneficairyId") Long beneficairyId,
			@Param("facilityId") Long facilityId , @Param("name") String name);

	@Query(nativeQuery = true, value = "select bvr.id,bvr.visit_date as visitDate,p.product_name as productname,coalesce (adi.dispense_quantity,0) as givenQty, coalesce(adi.adherence_to_art,0) as adherencePercentage,\r\n" + 
			"0 as regulationOfVisitStatus,(select expected_visit_date from soch.art_beneficiary_due_list where beneficiary_id  =:beneficairyId and facility_id  =:facilityId \r\n" + 
			" and visit_register_id = (select max(visit_register_id) \r\n" + 
			"                          from  soch.art_beneficiary_due_list \r\n" + 
			"						  where visit_register_id < ad.visit_register_id and beneficiary_id = :beneficairyId )  \r\n" + 
			//"group by created_time ,expected_visit_date order by created_time desc  limit 1)\r\n" + 
			"and case when (select count(*) from soch.role_access_mapping where role_id = urm .role_id and access_code ='ART-PHARMACIST') >0 then true else false end limit 1)\r\n" + 
			"as expectedVisitDate, ad.dispense_date as dispenseddate\r\n" + 
			"from soch.art_beneficiary ab inner join soch.beneficiary b on ab.beneficiary_id  = b.id \r\n" + 
			"inner join soch.art_dispensation ad on ab.beneficiary_id  = ad.beneficiary_id \r\n" + 
			"left join soch.user_role_mapping urm on urm.user_id  = ad.entry_user \r\n" + 
			"inner join soch.beneficiary_visit_register bvr on ad.visit_register_id = bvr.id\r\n" + 
			"inner join soch.art_dispensation_item adi on adi.art_dispensation_id  = ad.id\r\n" + 
			"inner join soch.product p on p.id = adi.product_id\r\n" + 
			"inner join soch.product_commodity_type_master pctm on pctm.id = p.product_commodity_type_id\r\n" + 
			"where ab.beneficiary_id =  :beneficairyId and lower(pctm.product_commodity_type_name) not in ('hiv','tb','att') \r\n" + 
			"order by ad.dispense_date desc limit 6 ")
	public List<ProfileDispensationDetailsProjection> getprofileOiDispensationDetails(Long beneficairyId,
			Long facilityId);
	
	@Query(nativeQuery = true, value = "select ROW_NUMBER () OVER (ORDER BY lts.result_received_date asc) as resultId, lts.result_value as resultValue ,lts.result_received_date as resultDate  from  soch.lab_test_sample lts\r\n"
			+ "			 inner join soch.facility f on f.id = lts.sample_collected_facility_id\r\n"
			+ "			 inner join soch.test t on t.id = lts.test_id  \r\n"
			+ "			 where t.id = 1 and lts.beneficiary_id = :beneficairyId\r\n"
			+ "		 	 and f.id = :facilityId and lts.is_delete=false limit 1")
	public ProfileWidgetProjection getBaselineCDFourValueData( @Param("beneficairyId") Long beneficairyId, @Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select ROW_NUMBER () OVER (ORDER BY lts.result_received_date asc) as resultId,mrt.result_type as resultType, lts.result_value as resultValue ,lts.result_received_date as resultDate  from  soch.lab_test_sample lts\r\n"
			+ "			 inner join soch.facility f on f.id = lts.sample_collected_facility_id\r\n"
			+ "			 inner join soch.test t on t.id = lts.test_id  \r\n"
			+ "			 inner join master_result_type mrt on mrt.id  = lts.result_type_id \r\n"
			+ "			 where t.id = 2 and lts.beneficiary_id = :beneficairyId\r\n"
			+ "		 	 and f.id = :facilityId and lts.is_delete=false limit 1")
	public ProfileWidgetProjection getBaselineVlValueData(@Param("beneficairyId") Long beneficairyId, @Param("facilityId") Long facilityId);

}
