package gov.naco.soch.repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.DashboardIndicatorEstimateDetails;
import gov.naco.soch.projection.DashboardEstimateProjection;

@Repository
public interface DashboardIndicatorEstimateDetailsRepository
		extends JpaRepository<DashboardIndicatorEstimateDetails, Long>,
		JpaSpecificationExecutor<DashboardIndicatorEstimateDetails> {

	@Query(nativeQuery = true, value = "select mdi.name as name , died.estimate_value as value , died.low_range as lowRange,\r\n" +
			"died.high_range as highRange from \r\n" +  
			"soch.dashboard_indicator_estimate_details died\r\n" + 
			"join soch.master_dashboard_indicator mdi on mdi.id = died.dashboard_indicator_id \r\n" + 
			"where died.dashboard_gender_id in :genderId and died.age_group_id in :ageGroup \r\n" + 
			"and died.dashboard_typology_id in :typologyId and died.dashboard_geographical_level_id = 1\r\n" + 
			"and died.type_of_reported_year = :yearType and died.reported_year = :year\r\n" + 
			"and mdi.description = :description")
	DashboardEstimateProjection getEstimateDetailsNationWise(List<Integer> genderId, List<Integer> ageGroup, List<Integer> typologyId,
			String yearType, String year, String description);
	
	@Query(nativeQuery = true, value = "select mdi.name as name , died.estimate_value as value , died.low_range as lowRange,\r\n" +
			"died.high_range as highRange from \r\n" +  
			"soch.dashboard_indicator_estimate_details died\r\n" + 
			"join soch.master_dashboard_indicator mdi on mdi.id = died.dashboard_indicator_id \r\n" + 
			"where died.dashboard_gender_id in :genderId and died.age_group_id in :ageGroup \r\n" + 
			"and died.dashboard_typology_id in :typologyId and died.dashboard_geographical_level_id = 1\r\n" + 
			"and died.type_of_reported_year = :yearType and died.reported_year = :year\r\n" + 
			"and mdi.description = :description")
	DashboardEstimateProjection getEstimateDetailsNationWise(String yearType, String year, String description);

	@Query(nativeQuery = true, value = "select mdi.name as name , died.estimate_value as value, died.low_range as lowRange,\r\n" + 
			"died.high_range as highRange from \r\n" + 
			"soch.dashboard_indicator_estimate_details died\r\n" + 
			"join soch.master_dashboard_indicator mdi on mdi.id = died.dashboard_indicator_id \r\n" + 
			"where died.dashboard_gender_id in :genderId and died.age_group_id in :ageGroup and \r\n" + 
			"dashboard_geographical_level_id =2 and died.dashboard_typology_id in :typologyId\r\n" + 
			"and died.dashboard_geographical_level_id = 2 and died.type_of_reported_year = :yearType and died.reported_year = :year\r\n" + 
			"and died.state_id = :stateId and mdi.description = :description")
	DashboardEstimateProjection getEstimateDetailsStateWise(List<Integer> genderId, List<Integer> ageGroup, List<Integer> typologyId,
			String yearType, String year,String description, Integer stateId);

	@Query(nativeQuery = true, value ="select mdi.description from soch.master_dashboard_indicator mdi where\r\n" + 
			"mdi.id in (1,2,5,4) ORDER BY array_position(array[1,2,5,4], mdi.id)")
	List<String> getLabelsforEpidemic();
	
	@Query(nativeQuery = true, value ="select description from soch.master_dashboard_indicator mdi where\r\n" + 
			"id in (3,19,20)")
	List<String> getLabelsforMotherToChildGraph();

	@Query(nativeQuery = true, value ="select mdi.name as name , died.estimate_value as value from \r\n" + 
			"soch.dashboard_indicator_estimate_details died\r\n" + 
			"join soch.master_dashboard_indicator mdi on mdi.id = died.dashboard_indicator_id \r\n" + 
			"where died.type_of_reported_year = :yearType and died.reported_year = :year\r\n" + 
			"and mdi.description in :labels")
	List<DashboardEstimateProjection> getEstimateDetailsForMotherChildNationWise(String yearType, String year, List<String> labels);

	@Query(nativeQuery = true, value ="select mdi.name as name , died.estimate_value as value from \r\n" + 
			"soch.dashboard_indicator_estimate_details died\r\n" + 
			"join soch.master_dashboard_indicator mdi on mdi.id = died.dashboard_indicator_id \r\n" + 
			"where died.type_of_reported_year = :yearType and died.reported_year = :year\r\n" + 
			"and died.state_id = :stateId and mdi.description in :labels ")
	List<DashboardEstimateProjection> getEstimateDetailsForMotherChildStateWise(String yearType, String year, Integer stateId, List<String> labels);

	@Query(nativeQuery = true, value ="select count(distinct ib.beneficiary_id)\r\n" + 
			"from  soch.ictc_beneficiary ib\r\n" + 
			"inner join soch.beneficiary b on b.id  = ib.beneficiary_id\r\n" + 
			"inner join soch.ictc_visit iv on ib.id  = iv.ictc_beneficiary_id\r\n" + 
			"INNER JOIN soch.ictc_test_result ltr  ON ltr.ictc_beneficiary_id = ib.id\r\n" + 
			"where  ltr.tested_date IS NOT NULL  and ib.is_active = true\r\n" + 
			"and ib.is_deleted = false\r\n" + 
			"and cast(ltr.tested_date as date) >= :dateFrom   and\r\n" + 
			"cast(ltr.tested_date as date) <= :dateTo   and  ib.pid like 'PW%'")
	BigInteger getPWTestedForHIVCountNationWise(Timestamp dateFrom, Timestamp dateTo);

	@Query(nativeQuery = true, value = "select count(distinct ib.beneficiary_id)\r\n" + 
			"from  soch.ictc_beneficiary ib\r\n" + 
			"inner join soch.beneficiary b on b.id  = ib.beneficiary_id\r\n" + 
			"inner join soch.ictc_visit iv on ib.id  = iv.ictc_beneficiary_id\r\n" + 
			"INNER JOIN soch.ictc_test_result ltr  ON ltr.ictc_beneficiary_id = ib.id\r\n" + 
			"inner join soch.facility f on ib.facility_id = f.id \r\n" + 
			"inner join soch.address a on a.id = f.address_id \r\n" + 
			"where  ltr.tested_date IS NOT NULL  and ib.is_active = true\r\n" + 
			"and ib.is_deleted = false  \r\n" + 
			"and cast(ltr.tested_date as date) >= :dateFrom   and\r\n" + 
			"cast(ltr.tested_date as date) <= :dateTo   and  ib.pid like 'PW%'\r\n" + 
			"and a.state_id = :stateId")
	BigInteger getPWTestedForHIVCountStateWise(Timestamp dateFrom, Timestamp dateTo, Integer stateId);

	@Query(nativeQuery = true, value ="select count(distinct ib.beneficiary_id)\r\n" + 
			"from  soch.ictc_beneficiary ib\r\n" + 
			"inner join soch.beneficiary b on b.id  = ib.beneficiary_id\r\n" + 
			"inner join soch.ictc_visit iv on ib.id  = iv.ictc_beneficiary_id\r\n" + 
			"INNER JOIN soch.ictc_test_result ltr  ON ltr.ictc_beneficiary_id = ib.id\r\n" + 
			"where  ltr.tested_date IS NOT NULL  and ib.is_active = true\r\n" + 
			"and ib.is_deleted = false\r\n" + 
			"and cast(ltr.tested_date as date) >= :dateFrom   and\r\n" + 
			"cast(ltr.tested_date as date) <= :dateTo   and  ib.pid like 'PW%'\r\n" + 
			"and ltr.hiv_status = 2")
	BigInteger getNewlyIdentifiedHivPosPwNationWise(Timestamp dateFrom, Timestamp dateTo);

	@Query(nativeQuery = true, value ="select count(distinct ib.beneficiary_id)\r\n" + 
			"from  soch.ictc_beneficiary ib\r\n" + 
			"inner join soch.beneficiary b on b.id  = ib.beneficiary_id\r\n" + 
			"inner join soch.ictc_visit iv on ib.id  = iv.ictc_beneficiary_id\r\n" + 
			"INNER JOIN soch.ictc_test_result ltr  ON ltr.ictc_beneficiary_id = ib.id\r\n" + 
			"inner join soch.facility f on ib.facility_id = f.id \r\n" + 
			"inner join soch.address a on a.id = f.address_id \r\n" + 
			"where  ltr.tested_date IS NOT NULL  and ib.is_active = true\r\n" + 
			"and ib.is_deleted = false\r\n" + 
			"and cast(ltr.tested_date as date) >= :dateFrom   and\r\n" + 
			"cast(ltr.tested_date as date) <= :dateTo   and  ib.pid like 'PW%'\r\n" + 
			"and ltr.hiv_status = 2 and a.state_id = :stateId")
	BigInteger getNewlyIdentifiedHivPosPwStateWise(Timestamp dateFrom, Timestamp dateTo, Integer stateId);

	@Query(nativeQuery = true, value = "select count(distinct bvr.beneficiary_id) from soch.beneficiary_visit_register bvr \r\n" + 
			"join soch.beneficiary b on b.id = bvr.beneficiary_id \r\n" + 
			"join soch.art_beneficiary ab on b.id = ab.beneficiary_id \r\n" + 
			"where ((cast(bvr.lmp as date) >= :dateFrom and cast(bvr.lmp as date) <=:dateTo) or \r\n" + 
			"(cast(bvr.lmp + interval '9month' as date) >= :dateFrom\r\n" + 
			"and cast(bvr.lmp + interval '9month' as date) <= :dateTo)) and b.is_active = true\r\n" + 
			"and b.is_delete = false and cast(ab.art_registration_date as date) < :dateFrom")
	BigInteger getKnownHivPosPwCountNationwise(Timestamp dateFrom, Timestamp dateTo);

	@Query(nativeQuery = true, value ="select count(distinct bvr.beneficiary_id) from soch.beneficiary_visit_register bvr \r\n" + 
			"join soch.beneficiary b on b.id = bvr.beneficiary_id \r\n" + 
			"join soch.art_beneficiary ab on b.id = ab.beneficiary_id \r\n" + 
			"inner join soch.facility f on f.id = ab.facility_id \r\n" + 
			"inner join soch.address a on f.address_id = a.id \r\n" + 
			"where ((cast(bvr.lmp as date) >= :dateFrom and cast(bvr.lmp as date) <=:dateTo) or \r\n" + 
			"(cast(bvr.lmp + interval '9month' as date) >= :dateFrom\r\n" + 
			"and cast(bvr.lmp + interval '9month' as date) <= :dateTo)) and b.is_active = true\r\n" + 
			"and b.is_delete = false and cast(ab.art_registration_date as date) < :dateFrom\r\n" + 
			"and a.state_id = :stateId")
	BigInteger getKnownHivPosPwCountStatewise(Timestamp dateFrom, Timestamp dateTo, Integer stateId);
	
	@Query(nativeQuery = true, value = "select count(distinct bvr.beneficiary_id) from soch.beneficiary_visit_register bvr \r\n" + 
			"join soch.beneficiary b on b.id = bvr.beneficiary_id \r\n" + 
			"join soch.art_beneficiary ab on b.id = ab.beneficiary_id \r\n" + 
			"where ((cast(bvr.lmp as date) >= :dateFrom and cast(bvr.lmp as date) <=:dateTo) or \r\n" + 
			"(cast(bvr.lmp + interval '9month' as date) >= :dateFrom\r\n" + 
			"and cast(bvr.lmp + interval '9month' as date) <= :dateTo)) and b.is_active = true\r\n" + 
			"and b.is_delete = false and cast(ab.art_registration_date as date) < :dateFrom\r\n" + 
			"and ab.art_beneficiary_status_id in (8,9)")
	BigInteger getKnownPwInitiatedOnArtNationwise(Timestamp dateFrom, Timestamp dateTo);
	
	@Query(nativeQuery = true, value = "select count(distinct bvr.beneficiary_id) from soch.beneficiary_visit_register bvr \r\n" + 
			"join soch.beneficiary b on b.id = bvr.beneficiary_id \r\n" + 
			"join soch.art_beneficiary ab on b.id = ab.beneficiary_id \r\n" + 
			"inner join soch.facility f on f.id = ab.facility_id \r\n" + 
			"inner join soch.address a on f.address_id = a.id \r\n" + 
			"where ((cast(bvr.lmp as date) >= :dateFrom and cast(bvr.lmp as date) <=:dateTo) or \r\n" + 
			"(cast(bvr.lmp + interval '9month' as date) >= :dateFrom\r\n" + 
			"and cast(bvr.lmp + interval '9month' as date) <= :dateTo)) and b.is_active = true\r\n" + 
			"and b.is_delete = false and cast(ab.art_registration_date as date) < :dateFrom\r\n" + 
			"and ab.art_beneficiary_status_id in (8,9) and a.state_id = :stateId")
	BigInteger getKnownPwInitiatedOnArtStatewise(Timestamp dateFrom, Timestamp dateTo,Integer stateId);
	
	@Query(nativeQuery = true, value = "select count(distinct ib.beneficiary_id)\r\n" + 
			"from  soch.ictc_beneficiary ib\r\n" + 
			"inner join soch.beneficiary b on b.id  = ib.beneficiary_id\r\n" + 
			"inner join soch.ictc_visit iv on ib.id  = iv.ictc_beneficiary_id\r\n" + 
			"INNER JOIN soch.ictc_test_result ltr  ON ltr.ictc_beneficiary_id = ib.id\r\n" + 
			"inner join soch.art_beneficiary ab on ab.beneficiary_id = b.id\r\n" + 
			"where  ltr.tested_date IS NOT NULL  and ib.is_active = true\r\n" + 
			"and ib.is_deleted = false\r\n" + 
			"and cast(ltr.tested_date as date) >= :dateFrom   and\r\n" + 
			"cast(ltr.tested_date as date) <= :dateTo   and  ib.pid like 'PW%'\r\n" + 
			"and ltr.hiv_status = 2 and ab.art_beneficiary_status_id in (8,9)")
	BigInteger getNewPwInitiatedOnArtNationwise(Timestamp dateFrom, Timestamp dateTo);
	
	@Query(nativeQuery = true, value = "select count(distinct ib.beneficiary_id)\r\n" + 
			"from  soch.ictc_beneficiary ib\r\n" + 
			"inner join soch.beneficiary b on b.id  = ib.beneficiary_id\r\n" + 
			"inner join soch.ictc_visit iv on ib.id  = iv.ictc_beneficiary_id\r\n" + 
			"INNER JOIN soch.ictc_test_result ltr  ON ltr.ictc_beneficiary_id = ib.id\r\n" + 
			"inner join soch.art_beneficiary ab on ab.beneficiary_id = b.id\r\n" + 
			"inner join soch.facility f on ib.facility_id = f.id \r\n" + 
			"inner join soch.address a on a.id = f.address_id \r\n" + 
			"where  ltr.tested_date IS NOT NULL  and ib.is_active = true\r\n" + 
			"and ib.is_deleted = false\r\n" + 
			"and cast(ltr.tested_date as date) >= :dateFrom   and\r\n" + 
			"cast(ltr.tested_date as date) <= :dateTo   and  ib.pid like 'PW%'\r\n" + 
			"and ltr.hiv_status = 2 and ab.art_beneficiary_status_id in (8,9)\r\n" + 
			"and a.state_id = :stateId")
	BigInteger getNewPwInitiatedOnArtStatewise(Timestamp dateFrom, Timestamp dateTo,Integer stateId);
	
	@Query(nativeQuery = true, value = "select frequency_of_update from soch.master_dashboard_indicator mdi \r\n" + 
			"where description = :description")
	Integer getFrequencyOfUpdateForIndicator(String description);

	@Query(nativeQuery = true, value = "select estimate_value as value, low_range as lowRange, high_range as highRange , died.reported_year as reportedYear\r\n" + 
			"from soch.dashboard_indicator_estimate_details died\r\n" + 
			"join soch.master_dashboard_indicator mdi on mdi.id = died.dashboard_indicator_id \r\n" + 
			"where died.dashboard_gender_id in :genderId and died.age_group_id in :ageGroup \r\n" + 
			"and died.dashboard_typology_id in :typologyId\r\n" + 
			"and died.dashboard_geographical_level_id = 2 \r\n"+
			"and died.type_of_reported_year = :yearType \r\n" + 
			"and mdi.description = :description and died.reported_year in :yearList and died.state_id = :stateId")
	List<DashboardEstimateProjection> getEstimateProjectionStateWise(List<Integer> genderId, List<Integer> ageGroup,
			List<Integer> typologyId, String yearType, List<String> yearList, String description, Integer stateId);

	@Query(nativeQuery = true, value = "select estimate_value as value, low_range as lowRange, high_range as highRange , died.reported_year as reportedYear\r\n" + 
			"from soch.dashboard_indicator_estimate_details died\r\n" + 
			"join soch.master_dashboard_indicator mdi on mdi.id = died.dashboard_indicator_id \r\n" + 
			"where died.dashboard_gender_id in :genderId and died.age_group_id in :ageGroup \r\n" + 
			"and died.dashboard_typology_id in :typologyId\r\n" + 
			"and died.dashboard_geographical_level_id = 1 \r\n"+
			"and died.type_of_reported_year = :yearType \r\n" + 
			"and mdi.description = :description and died.reported_year in :yearList")
	List<DashboardEstimateProjection> getEstimateProjectionNationWise(List<Integer> genderId, List<Integer> ageGroup,
			List<Integer> typologyId, String yearType, List<String> yearList, String description);

	@Query(nativeQuery = true, value = "select mdi.name as name , died.estimate_value as value , died.low_range as lowRange,\r\n" +
			"died.high_range as highRange from \r\n" +  
			"soch.dashboard_indicator_estimate_details died\r\n" + 
			"join soch.master_dashboard_indicator mdi on mdi.id = died.dashboard_indicator_id \r\n" + 
			"and died.type_of_reported_year = :yearType and died.reported_year = :year\r\n" + 
			"and mdi.description = :description and died.state_id isnull ")
	DashboardEstimateProjection getOutputTargetEstimateDetailsNationWise(String yearType, String year,
			String description);
	
	
	@Query(nativeQuery = true, value = "select mdi.name as name , died.estimate_value as value from\r\n" + 
			"soch.dashboard_indicator_estimate_details died\r\n" + 
			"join soch.master_dashboard_indicator mdi on mdi.id = died.dashboard_indicator_id \r\n" + 
			"where  died.dashboard_geographical_level_id = 2 and died.type_of_reported_year = :yearType and died.reported_year = :year\r\n" + 
			" and died.state_id = :stateId and mdi.description = :description")
	DashboardEstimateProjection getOutputtargetEstimateDetailsStateWise(String yearType, String year,
			String description, Integer stateId);

	@Query(nativeQuery = true, value = "died.estimate_value from \r\n" +
			"soch.dashboard_indicator_estimate_details died\r\n" + 
			"join soch.master_dashboard_indicator mdi on mdi.id = died.dashboard_indicator_id \r\n" + 
			"where died.dashboard_gender_id in :genderId and died.age_group_id in :ageGroup \r\n" + 
			" and died.dashboard_geographical_level_id = 4\r\n" + 
			"and died.type_of_reported_year = :yearType and died.reported_year = :year\r\n" + 
			"and mdi.description = :description")
	BigInteger getGlobalPlhivKnownstatusAchievedPercent(String year, String yearType);
	
	@Query(nativeQuery = true, value = "select mdi.name as name , died.estimate_value as value from\r\n" + 
			"soch.dashboard_indicator_estimate_details died\r\n" + 
			"join soch.master_dashboard_indicator mdi on mdi.id = died.dashboard_indicator_id \r\n" + 
			"where  died.dashboard_geographical_level_id = 4 and died.type_of_reported_year = :yearType and died.reported_year = :year\r\n" + 
			"  and mdi.description = :description and died.age_group_id =:ageGroup and died.dashboard_typology_id =:typology and died.dashboard_gender_id=:gender")
	DashboardEstimateProjection getGlobalFastTrackIndicatorEstimateDetails(String yearType, String year,
			String description, Integer ageGroup, Integer typology, Integer gender);

	@Query(nativeQuery = true, value = "select estimate_value as value, low_range as lowRange, high_range as highRange , died.reported_year as reportedYear\r\n" + 
			"from soch.dashboard_indicator_estimate_details died\r\n" + 
			"join soch.master_dashboard_indicator mdi on mdi.id = died.dashboard_indicator_id \r\n" + 
			"where died.dashboard_gender_id in :genderId and died.age_group_id in :ageGroup \r\n" + 
			"and died.dashboard_typology_id in :typologyId\r\n" + 
			"and died.dashboard_geographical_level_id = 1 \r\n"+
			"and mdi.description = :description")
	List<DashboardEstimateProjection> getEstimateProjectionTrendsNationWise(List<Integer> genderId,
			List<Integer> ageGroup, List<Integer> typologyId, String description);

	@Query(nativeQuery = true, value = "select estimate_value as value, low_range as lowRange, high_range as highRange , died.reported_year as reportedYear\r\n" + 
			"from soch.dashboard_indicator_estimate_details died\r\n" + 
			"join soch.master_dashboard_indicator mdi on mdi.id = died.dashboard_indicator_id \r\n" + 
			"where died.dashboard_gender_id in :genderId and died.age_group_id in :ageGroup \r\n" + 
			"and died.dashboard_typology_id in :typologyId\r\n" + 
			"and died.dashboard_geographical_level_id = 2 \r\n"+
			"and mdi.description = :description and died.state_id = :stateId")
	List<DashboardEstimateProjection> getEstimateProjectionTrendsStateWise(List<Integer> genderId, List<Integer> ageGroup,
			List<Integer> typologyId, String description, Integer stateId);

	@Query(nativeQuery = true, value = "select  died.estimate_value as value from \r\n" +  
			"soch.dashboard_indicator_estimate_details died\r\n" + 
			"where died.dashboard_gender_id in :gender and died.age_group_id in :ageGroup \r\n" + 
			"and died.dashboard_typology_id in :typology and died.dashboard_geographical_level_id = :geographicalLevel\r\n" + 
			"and died.type_of_reported_year = :yearType and died.reported_year = :year\r\n" + 
			"and died.dashboard_indicator_id = :indicatorType")
	BigDecimal getDecreaseRateForTrends(List<Integer> gender, List<Integer> ageGroup, List<Integer> typology,
			String yearType, String year, int geographicalLevel, int indicatorType);

	@Query(nativeQuery = true, value = "select died.estimate_value from \r\n" +  
			"soch.dashboard_indicator_estimate_details died\r\n" +  
			"where died.dashboard_gender_id in :gender and died.age_group_id in :ageGroup \r\n" + 
			"and died.dashboard_typology_id in :typology and died.dashboard_geographical_level_id = :geographicalLevel\r\n" + 
			"and died.type_of_reported_year = :yearType and died.reported_year = :year\r\n" + 
			"and died.dashboard_indicator_id = :indicatorType and died.state_id = :stateId")
	BigDecimal getDecreaseRateForTrendsForState(List<Integer> gender, List<Integer> ageGroup, List<Integer> typology,
			String yearType, String year, int geographicalLevel, int indicatorType, Integer stateId);

	@Query(nativeQuery = true, value = "select estimate_value as value, died.reported_year as reportedYear\r\n" + 
			"from soch.dashboard_indicator_estimate_details died\r\n" + 
			"join soch.master_dashboard_indicator mdi on mdi.id = died.dashboard_indicator_id \r\n" + 
			"where died.dashboard_gender_id in :gender and died.age_group_id in :ageGroup \r\n" + 
			"and died.dashboard_typology_id in :typology\r\n" + 
			"and died.dashboard_geographical_level_id = :geographicalLevel \r\n"+
			"and died.dashboard_indicator_id = :indicatorType")
	List<DashboardEstimateProjection> getGlobalValuesList(List<Integer> gender, List<Integer> ageGroup,
			List<Integer> typology, int geographicalLevel, int indicatorType);
	


}
