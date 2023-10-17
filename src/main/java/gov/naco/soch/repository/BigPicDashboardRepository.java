package gov.naco.soch.repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.projection.LongitudinalCascadeProjection;

@Repository
public interface BigPicDashboardRepository extends JpaRepository<Beneficiary, Long>, CustomRepository , BigPicRepository{

	@Query(nativeQuery = true, value = "select distinct ib.beneficiary_id \r\n" + 
			"as beneficiary from soch.ictc_beneficiary ib\r\n" + 
			"JOIN soch.beneficiary b ON ib.beneficiary_id = b.id\r\n" + 
			"JOIN soch.ictc_test_result lts  ON lts.ictc_beneficiary_id = ib.id\r\n" + 
			"where b.hiv_status_id = 2 and cast(lts.tested_date as date) >= :dateFrom and \r\n" + 
			"cast(lts.tested_date as date) <=:dateTo \r\n" + 
			"and  b.is_active = true and b.is_delete = false")
	Set<Long> getPlhivDaigonisedCount(Timestamp dateFrom,
			Timestamp dateTo);

	@Query(nativeQuery = true, value = "select distinct ib.beneficiary_id \r\n" + 
			"as beneficiary from soch.ictc_beneficiary ib\r\n" + 
			"JOIN soch.beneficiary b ON ib.beneficiary_id = b.id\r\n" + 
			"inner join soch.facility f on ib.facility_id = f.id\r\n" + 
			"join soch.address a on a.id = f.address_id  \r\n" + 
			"JOIN soch.ictc_test_result lts  ON lts.ictc_beneficiary_id = ib.id\r\n" + 
			"where b.hiv_status_id = 2 and cast(lts.tested_date as date) >= :dateFrom and \r\n" + 
			"cast(lts.tested_date as date) <= :dateTo\r\n" + 
			"and  b.is_active = true and b.is_delete = false\r\n" + 
			"and a.state_id = :stateId")
	Set<Long> getPlhivDaigonisedCountStatewise(Timestamp dateFrom, 
			 Timestamp dateTo, Integer stateId);
	
	@Query(nativeQuery = true, value = "select count(lts.beneficiary_id)  from  soch.lab_test_sample lts\r\n" + 
			"inner join soch.beneficiary b on b.id = lts.beneficiary_id \r\n" + 
			"inner join soch.test t on t.id = lts.test_id  \r\n" + 
			"inner join soch.master_result_type mrt on mrt.id  = lts.result_type_id \r\n" + 
			"where t.id = 2 and  lts.is_delete=false and mrt.id in (1,2)\r\n" + 
			"and lts.beneficiary_id in :beneficiaryIds")
	BigDecimal getViralySuppressedPlhivCount(List<String> beneficiaryIds);
	
	@Query(nativeQuery = true, value ="select count(distinct(lat.benid)) from \r\n" + 
			"(select bast1.beneficiary_id as benid, max(bast1.status_changed_date) as latest_date\r\n" + 
			"from soch.beneficiary_art_status_tracking bast1\r\n" + 
			"join soch.art_beneficiary ab on ab.beneficiary_id = bast1.beneficiary_id\r\n" + 
			"where CAST(bast1.status_changed_date AS Date) <= :dateTo \r\n" + 
			"and bast1.current_art_beneficiary_status_id in (1,2,3,4,8,9,10,11,12)\r\n" + 
			"and ab.is_delete =false\r\n" + 
			"group by bast1.beneficiary_id)lat")
	BigDecimal getEverRegisteredPlhivTillYear(Timestamp dateTo);
	
	@Query(nativeQuery = true, value ="	select count(distinct(lat.benid)) from \r\n" + 
			"(select bast1.beneficiary_id as benid, max(bast1.status_changed_date) as latest_date\r\n" + 
			"from soch.beneficiary_art_status_tracking bast1\r\n" + 
			"join soch.art_beneficiary ab on ab.beneficiary_id = bast1.beneficiary_id\r\n" + 
			"where CAST(bast1.status_changed_date AS Date) <= :dateTo\r\n" + 
			"and bast1.current_art_beneficiary_status_id in (8,9)\r\n" + 
			"and ab.is_delete =false\r\n" + 
			"group by bast1.beneficiary_id)lat")
	BigDecimal getOnArtPlhivTillYear(Timestamp dateTo);
	
	
	/*@Query(nativeQuery = true, value = "select count(lts.beneficiary_id)  from  soch.lab_test_sample lts \r\n" + 
			"	where lts.id in (select max(lts.id) from  soch.lab_test_sample lts\r\n" + 
			"	inner join soch.beneficiary b on b.id = lts.beneficiary_id  \r\n" + 
			"	inner join soch.test t on t.id = lts.test_id   \r\n" + 
			"	inner join soch.master_result_type mrt on mrt.id  = lts.result_type_id  \r\n" + 
			"	where t.id = 2 and  lts.is_delete=false and mrt.id in (1,2) and lts.result_received_date IS NOT NULL \r\n" + 
			"	and lts.result_type_id is  NOT null and lts.result_received_date between\r\n" + 
			"	:dateFrom and :dateTo \r\n" + 
			"	group by  lts.beneficiary_id ) " ) 
	BigDecimal getVirallySuppessedPlhivTillYear(Timestamp dateFrom, Timestamp dateTo);*/
    
    @Query(nativeQuery = true, value = " 	select\r\n" + 
    		"    count(distinct lts.beneficiary_id) from soch.lab_test_sample lts\r\n" + 
    		"	 inner join soch.master_result_type mrt ON  mrt.id = lts.result_type_id\r\n" + 
    		"	 join (select  beneficiary_id, max(result_received_date) as max_dt  \r\n" + 
    		"    from  soch.lab_test_sample group by  beneficiary_id ) t1 on \r\n" + 
    		"    lts.beneficiary_id = t1.beneficiary_id\r\n" + 
    		"    and lts.result_received_date = t1.max_dt\r\n" + 
    		"	 where lts.test_id = 2 and lts.is_delete = false and (mrt.id in (1, 2, 11, 12)\r\n" + 
    		"    or (mrt.id in (4, 14) and (case\r\n" + 
    		"    when lts.result_value ~ E'^\\\\\\d+$' then cast(lts.result_value as numeric)\r\n" + 
    		"        else 0\r\n" + 
    		"    end) < 1000)) and  lts.result_received_date between\r\n" + 
    		"	:dateFrom and :dateTo  " ) 
	BigDecimal getVirallySuppessedPlhivTillYear(Timestamp dateFrom, Timestamp dateTo);
	
	/*
	 * @Query(nativeQuery = true, value =
	 * "select count(distinct lts.beneficiary_id)  from  soch.lab_test_sample lts\r\n"
	 * + "inner join soch.beneficiary b on b.id = lts.beneficiary_id \r\n" +
	 * "inner join soch.test t on t.id = lts.test_id  \r\n" +
	 * "inner join soch.master_result_type mrt on mrt.id  = lts.result_type_id \r\n"
	 * +
	 * "where t.id = 2 and  lts.is_delete=false and lts.result_received_date IS NOT NULL and lts.result_received_date between :dateFrom and :dateTo\r\n"
	 * ) BigDecimal getVlTestedPlhiv(Timestamp dateFrom, Timestamp dateTo);
	 */
    
    @Query(nativeQuery = true, value = "select count(distinct lts.id)  from  soch.lab_test_sample_batch sb\r\n" + 
    		"	JOIN soch.lab_test_sample lts ON sb.id = lts.test_batch_id\r\n" + 
    		"  inner join soch.test t on t.id = lts.test_id \r\n" + 
    		"  inner join soch.master_result_type mrt on mrt.id  = lts.result_type_id \r\n" + 
    		"  JOIN soch.master_sample_status mss ON lts.sample_status_id = mss.id\r\n" + 
    		"  where mss.status  = 'RESULT POSTED' AND  t.id = 2 and  lts.is_delete=false and \r\n" + 
    		"  sb.received_date IS NOT NULL and lts.result_received_date IS NOT NULL AND lts.result_received_date between :dateFrom and :dateTo" ) 
	BigDecimal getVlTestedPlhiv(Timestamp dateFrom, Timestamp dateTo);
	 
    @Query(nativeQuery = true, value =" select count(distinct(lat.benid)) from \r\n " +
    		" ( select bast1.beneficiary_id as benid, max(bast1.status_changed_date) as latest_date \r\n" +
    		" from soch.beneficiary_art_status_tracking bast1 \r\n "+
    		" join soch.art_beneficiary ab on ab.beneficiary_id = bast1.beneficiary_id \r\n"+
    		" inner join soch.facility f on ab.facility_id = f.id \r\n" + 
    		" join soch.address a on a.id = f.address_id \r\n" + 
    		" join soch.state s on s.id = a.state_id \r\n" + 
    		" where CAST(bast1.status_changed_date AS Date) <= :dateTo \r\n"+
    		" and bast1.current_art_beneficiary_status_id in (1,2,3,4,8,9,10,11,12) \r\n"+
    		" and ab.is_delete =false and s.id =:stateId \r\n "+
    		" group by bast1.beneficiary_id )lat")
	BigDecimal getEverRegisteredPlhivTillYearByStateId(Timestamp dateTo, Integer stateId);

    @Query(nativeQuery = true, value =" select count(distinct(lat.benid)) from \r\n " +
    		" ( select bast1.beneficiary_id as benid, max(bast1.status_changed_date) as latest_date \r\n" +
    		" from soch.beneficiary_art_status_tracking bast1 \r\n "+
    		" join soch.art_beneficiary ab on ab.beneficiary_id = bast1.beneficiary_id \r\n"+
    		" inner join soch.facility f on ab.facility_id = f.id \r\n" + 
    		" join soch.address a on a.id = f.address_id \r\n" + 
    		" join soch.state s on s.id = a.state_id \r\n" + 
    		" where CAST(bast1.status_changed_date AS Date) <= :dateTo \r\n"+
    		" and bast1.current_art_beneficiary_status_id in (8,9) \r\n"+
    		" and ab.is_delete =false and s.id =:stateId \r\n "+
    		" group by bast1.beneficiary_id )lat")
	BigDecimal getOnArtPlhivTillYearByYearByStateId(Timestamp dateTo, Integer stateId);

	@Query(nativeQuery = true, value ="select distinct ib.beneficiary_id as beneficiary,\r\n" + 
			"CAST(ab.art_registration_date AS Date) as registrationDate, CAST(lts.tested_date AS Date) as testedDate\r\n" + 
			"from soch.beneficiary_referral br \r\n" + 
			"inner join soch.beneficiary b on b.id = br.beneficiary_id\r\n" + 
			"inner join soch.art_beneficiary ab  on b.id = ab.beneficiary_id\r\n" + 
			"inner join soch.ictc_beneficiary ib on ib.beneficiary_id = b.id\r\n" + 
			"LEFT JOIN soch.ictc_test_result lts ON ib.current_test_result_id = lts.id\r\n" + 
			"inner join soch.master_referral_status mrs on mrs.id = br.referral_status_id\r\n" + 
			"where  mrs.id = 3\r\n" + 
			"and br.referral_type_id = 1 and ab.art_registration_date is not null \r\n" + 
			"and lts.tested_date is not null\r\n" + 
			"and ib.beneficiary_id in (:plhivBeneficiaries)")
	Set<LongitudinalCascadeProjection> getPlhivRegisteredAtArt(List<Long> plhivBeneficiaries);

	@Query(nativeQuery = true, value ="select ad.beneficiary_id as beneficiary,\r\n" + 
			"cast(ab.art_registration_date as Date) as registrationDate , cast(ad.dispense_date as Date) as testedDate\r\n" + 
			"from soch.art_dispensation ad \r\n" + 
			"join soch.beneficiary b on b.id = ad.beneficiary_id \r\n" + 
			"join soch.art_beneficiary ab on ab.beneficiary_id = b.id\r\n" + 
			"where ad.id in (select min(id)\r\n" + 
			"from soch.art_dispensation ad \r\n" + 
			"where ad.beneficiary_id in (:plhivDiagnosed)\r\n" + 
			"group by beneficiary_id)")
	Set<LongitudinalCascadeProjection> getPlhivInitiatedOnArt(List<Long> plhivDiagnosed);

	@Query(nativeQuery = true, value = "select distinct ad.beneficiary_id from soch.art_dispensation ad \r\n" + 
			"join soch.beneficiary b on b.id = ad.beneficiary_id \r\n" + 
			"join soch.art_beneficiary ab on b.id = ab.beneficiary_id \r\n" + 
			"where ad.id in (select min(id)\r\n" + 
			"from soch.art_dispensation ad \r\n" + 
			"where ad.beneficiary_id in (:ben)\r\n" + 
			"group by beneficiary_id) and \r\n" + 
			"ab.art_beneficiary_status_id = 8\r\n" + 
			"and now()- ad.dispense_date >= interval '180 days'")
	Set<Long> getPlhivEligibleForVL(List<Long> ben);

	@Query(nativeQuery = true, value = "select distinct lts.beneficiary_id\r\n" + 
			"as beneficiaryList from  soch.lab_test_sample lts\r\n" + 
			"inner join soch.beneficiary b on b.id = lts.beneficiary_id \r\n" + 
			"inner join soch.test t on t.id = lts.test_id  \r\n" + 
			"inner join soch.master_result_type mrt on mrt.id  = lts.result_type_id \r\n" + 
			"where t.id = 2 and  lts.is_delete=false \r\n" + 
			"and lts.beneficiary_id in (:plhivEligibleForVL)")
	Set<Long> getPlhivTestedForVL(List<Long> plhivEligibleForVL);

	@Query(nativeQuery = true, value = "select count(distinct lts.beneficiary_id) from soch.lab_test_sample lts\r\n" + 
			"inner join soch.master_result_type mrt on mrt.id = lts.result_type_id\r\n" + 
			"join (select beneficiary_id, max(result_received_date) as max_dt\r\n" + 
			"from soch.lab_test_sample group by beneficiary_id ) t1 on\r\n" + 
			"lts.beneficiary_id = t1.beneficiary_id and lts.result_received_date = t1.max_dt\r\n" + 
			"where lts.test_id = 2 and lts.is_delete = false\r\n" + 
			"and (mrt.id in (1, 2, 11, 12) or (mrt.id in (4, 14)\r\n" + 
			"and (case when lts.result_value ~ E'^\\\\\\d+$' then cast(lts.result_value as numeric)\r\n" + 
			"else 0 end) < 1000))\r\n" + 
			"and lts.beneficiary_id in  (:plhivTestedForVL)")
	BigDecimal getPlhivVirallySuppressed(List<Long> plhivTestedForVL);


	/*
	 * @Query(nativeQuery = true, value =
	 * "select count(lts.beneficiary_id)  from  soch.lab_test_sample lts \r\n" +
	 * "	where lts.id in (select max(lts.id) from  soch.lab_test_sample lts\r\n"
	 * + "	inner join soch.beneficiary b on b.id = lts.beneficiary_id  \r\n" +
	 * "	inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id  \r\n" +
	 * " 	inner join soch.facility f on ab.facility_id = f.id \r\n" +
	 * " 	join soch.address a on a.id = f.address_id \r\n" +
	 * " 	join soch.state s on s.id = a.state_id \r\n" +
	 * "	inner join soch.test t on t.id = lts.test_id   \r\n" +
	 * "	inner join soch.master_result_type mrt on mrt.id  = lts.result_type_id  \r\n"
	 * +
	 * "	where t.id = 2 and  lts.is_delete=false and mrt.id in (1,2) and lts.result_received_date IS NOT NULL \r\n"
	 * +
	 * "	and lts.result_type_id is  NOT null and lts.result_received_date between\r\n"
	 * + "	:dateFrom and :dateTo and s.id =:stateId  \r\n" +
	 * "	group by  lts.beneficiary_id ) " ) BigDecimal
	 * getVirallySuppessedPlhivTillYearByStateId(Timestamp dateFrom, Timestamp
	 * dateTo, Integer stateId);
	 */
	
	@Query(nativeQuery = true, value = " 	select\r\n" + 
    		"    count(distinct lts.beneficiary_id) from soch.lab_test_sample lts\r\n" + 
    		"	 inner join soch.master_result_type mrt ON  mrt.id = lts.result_type_id\r\n" + 
    		"	 join (select  beneficiary_id, max(result_received_date) as max_dt  \r\n" + 
    		"    from  soch.lab_test_sample group by  beneficiary_id ) t1 on \r\n" + 
    		"    lts.beneficiary_id = t1.beneficiary_id\r\n" + 
    		"    and lts.result_received_date = t1.max_dt\r\n" + 
    		"	 inner join soch.facility f on lts.sample_collected_facility_id = f.id \r\n" +
    		"	 join soch.address a on a.id = f.address_id \r\n" +
    		"	 join soch.state s on s.id = a.state_id \r\n" +
    		"	 where lts.test_id = 2 and lts.is_delete = false and (mrt.id in (1, 2, 11, 12)\r\n" + 
    		"    or (mrt.id in (4, 14) and (case\r\n" + 
    		"    when lts.result_value ~ E'^\\\\\\d+$' then cast(lts.result_value as numeric)\r\n" + 
    		"        else 0 \r\n" + 
    		"    end) < 1000)) and  lts.result_received_date between\r\n" + 
    		"	:dateFrom and :dateTo AND  s.id =:stateId  " ) 
	BigDecimal getVirallySuppessedPlhivTillYearByStateId(Timestamp dateFrom, Timestamp dateTo, Integer stateId);

	@Query(nativeQuery = true, value = "select count(distinct lts.beneficiary_id)  from  soch.lab_test_sample lts\r\n" + 
			" inner join soch.beneficiary b on b.id = lts.beneficiary_id \r\n" + 
			" inner join soch.test t on t.id = lts.test_id  \r\n" + 
			" inner join soch.master_result_type mrt on mrt.id  = lts.result_type_id \r\n" + 
			"	inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id  \r\n" + 
			" 	inner join soch.facility f on ab.facility_id = f.id \r\n" +
			" 	join soch.address a on a.id = f.address_id \r\n" +
			" 	join soch.state s on s.id = a.state_id \r\n" +
			" where t.id = 2 and  lts.is_delete=false and lts.result_received_date IS NOT NULL and a.state_id = :stateId and lts.result_received_date between :dateFrom and :dateTo \r\n" ) 
	BigDecimal getVlTestedPlhivByStateId(Timestamp dateFrom, Timestamp dateTo, Integer stateId);

	@Query(nativeQuery = true ,value = "select count(distinct tb.beneficiary_id) from soch.dsrc_beneficiary tb \r\n" + 
			"inner join soch.beneficiary b on b.id = tb.beneficiary_id\r\n" + 
			"inner join soch.beneficiary_clinical_treatment  bct on  b.id = bct.beneficiary_id\r\n" + 
			"inner join soch.facility f on tb.facility_id = f.id\r\n" + 
			"inner join soch.facility_type ft  on f.facility_type_id =  ft.id\r\n" + 
			"where bct.clinical_treatment_type_id = 1 and \r\n" + 
			"b.is_delete = false and bct.is_delete = false and ft.id = 12 \r\n" + 
			"and CAST(bct.treatment_date AS DATE) >= :dateFrom\r\n" + 
			"and CAST(bct.treatment_date AS DATE) <= :dateTo")
	BigDecimal getDsrsAttendeesCount(Timestamp dateFrom, Timestamp dateTo);

	@Query(nativeQuery = true ,value = "select count(distinct tb.beneficiary_id) from soch.dsrc_beneficiary tb \r\n" + 
			"inner join soch.beneficiary b on b.id = tb.beneficiary_id\r\n" + 
			"inner join soch.beneficiary_clinical_treatment  bct on  b.id = bct.beneficiary_id\r\n" + 
			"inner join soch.facility f on tb.facility_id = f.id\r\n" + 
			"inner join soch.facility_type ft  on f.facility_type_id =  ft.id\r\n" + 
			"join soch.address a on a.id = f.address_id \r\n" + 
			"join soch.state s on s.id = a.state_id \r\n" + 
			"where bct.clinical_treatment_type_id = 1 and \r\n" + 
			"b.is_delete = FALSE and bct.is_delete = FALSE and ft.id = 12 \r\n" + 
			"and CAST(bct.treatment_date AS DATE) >= :dateFrom\r\n" + 
			"and CAST(bct.treatment_date AS DATE) <= :dateTo\r\n" + 
			"and a.state_id =:stateId\r\n")
	BigDecimal getDsrsAttendeesCountWithStateId(Integer stateId, Timestamp dateFrom, Timestamp dateTo);

	@Query(nativeQuery = true , value ="select count (distinct ib.beneficiary_id)  \r\n" + 
			" from soch.ictc_beneficiary ib \r\n" + 
			" INNER JOIN soch.beneficiary b ON ib.beneficiary_id = b.id \r\n" + 
			" INNER JOIN soch.ictc_test_result ltr  ON ltr.ictc_beneficiary_id = ib.id\r\n" + 
			" INNER JOIN soch.facility f ON ib.facility_id = f.id \r\n" + 
			" INNER JOIN soch.facility_type ft  ON f.facility_type_id = ft.id \r\n" + 
			" where ltr.tested_date IS NOT NULL and cast(ltr.tested_date as date) >= :dateFrom and \r\n" + 
			" cast(ltr.tested_date as date) <=:dateTo and b.category_id <> 1\r\n" + 
			" and  b.is_active = true and b.is_delete = false and ft.id IN (11,13) and ib.pid like 'GC%' ")
	BigDecimal getGeneralClientsTested(Timestamp dateFrom, Timestamp dateTo);

	@Query(nativeQuery =   true ,value = "select count(distinct ib.beneficiary_id) \r\n" + 
			"from  soch.ictc_beneficiary ib \r\n" + 
			"inner join soch.beneficiary b on b.id  = ib.beneficiary_id \r\n" + 
			"inner join soch.ictc_visit iv on ib.id  = iv.ictc_beneficiary_id \r\n" + 
			"INNER JOIN soch.ictc_test_result ltr  ON ltr.ictc_beneficiary_id = ib.id\r\n" + 
			"INNER JOIN soch.facility f ON ib.facility_id = f.id \r\n" + 
			"INNER JOIN soch.facility_type ft  ON f.facility_type_id = ft.id \r\n" + 
			"where  ltr.tested_date IS NOT NULL and iv.is_pregnant = true and ib.is_active = true \r\n" + 
			"and ib.is_deleted = false\r\n" + 
			"and cast(ltr.tested_date as date) >= :dateFrom  and \r\n" + 
			"cast(ltr.tested_date as date) <=:dateTo and b.category_id <> 1 and ft.id IN (11,13) and ib.pid like 'PW%' " )
	BigDecimal getPWTestedCount(Timestamp dateFrom, Timestamp dateTo);

	@Query(nativeQuery = true, value ="select count(distinct ab.beneficiary_id)" + 
			" from soch.art_beneficiary ab \r\n" + 
			" inner join soch.beneficiary b on ab.beneficiary_id = b.id \r\n" + 
			" inner join soch.master_art_beneficiary_status mabs on mabs.id = ab.art_beneficiary_status_id \r\n" + 
			" where mabs.name  in ('On-ART','On-ART-MIS') and \r\n" +
			"  CAST(ab.art_registration_date AS Date) >= :dateFrom \r\n" +
			"  and CAST(ab.art_registration_date AS Date) <= :dateTo")
	BigDecimal getPlhivOnArt(Timestamp dateFrom, Timestamp dateTo);


	@Query(nativeQuery = true , value = "select count(distinct ib.beneficiary_id) \r\n" + 
			" from soch.ictc_beneficiary ib \r\n" + 
			"INNER JOIN soch.beneficiary b ON ib.beneficiary_id = b.id \r\n" + 
			"INNER JOIN soch.ictc_test_result ltr  ON ltr.ictc_beneficiary_id = ib.id\r\n" + 
			" INNER JOIN soch.facility f ON ib.facility_id  = f.id\r\n" + 
			"INNER JOIN soch.facility_type ft  ON f.facility_type_id = ft.id \r\n" + 
			"JOIN soch.address a on a.id = f.address_id\r\n" + 
			"JOIN soch.state s on s.id = a.state_id \r\n" + 
			"where ltr.tested_date IS NOT NULL and cast(ltr.tested_date as date) >= :dateFrom and \r\n" + 
			"cast(ltr.tested_date as date) <=:dateTo and b.category_id <> 1\r\n" + 
			"and  b.is_active = true and b.is_delete = false and ft.id IN (11,13) and a.state_id =:stateId and ib.pid like 'GC%'")
	BigDecimal getGeneralClientsTestedByStateId(Integer stateId, Timestamp dateFrom, Timestamp dateTo);

	@Query(nativeQuery =   true ,value = "select count(distinct ib.beneficiary_id) \r\n" + 
			" from  soch.ictc_beneficiary ib \r\n" + 
			" inner join soch.beneficiary b on b.id  = ib.beneficiary_id \r\n" + 
			" inner join soch.ictc_visit iv on ib.id  = iv.ictc_beneficiary_id \r\n" + 
			" INNER JOIN soch.ictc_test_result ltr  ON ltr.ictc_beneficiary_id = ib.id\r\n" + 
			" INNER JOIN soch.facility f ON ib.facility_id = f.id \r\n" + 
			" INNER JOIN soch.facility_type ft  ON f.facility_type_id = ft.id \r\n" + 
			" JOIN soch.address a on a.id = f.address_id \r\n" + 
			" JOIN soch.state s on s.id = a.state_id \r\n" + 
			" where  ltr.tested_date IS NOT NULL and iv.is_pregnant = true and ib.is_active = true and ib.is_deleted = false\r\n" + 
			" and cast(ltr.tested_date as date) >= :dateFrom and \r\n" + 
			"cast(ltr.tested_date as date) <=:dateTo and b.category_id <> 1 and ft.id IN (11,13) and a.state_id =:stateId and ib.pid like 'PW%'\r\n" )
	BigDecimal getPWTestedCountByStateId(Integer stateId,Timestamp dateFrom, Timestamp dateTo);

	/*
	 * @Query(nativeQuery = true, value ="select count(distinct ab.beneficiary_id)"
	 * + " from soch.art_beneficiary ab \r\n" +
	 * " inner join soch.beneficiary b on ab.beneficiary_id = b.id \r\n" +
	 * " INNER JOIN soch.facility f ON ab.facility_id = f.id \r\n"+
	 * " JOIN soch.address a on a.id = f.address_id \r\n" +
	 * " JOIN soch.state s on s.id = a.state_id \r\n" +
	 * " inner join soch.master_art_beneficiary_status mabs on mabs.id = ab.art_beneficiary_status_id \r\n"
	 * + " where mabs.name  in ('On-ART','On-ART-MIS') \r\n" +
	 * " and CAST(ab.art_registration_date AS Date) <= :dateTo and a.state_id =:stateId"
	 * ) BigDecimal getPlhivOnArtByStateId(Integer stateId,Timestamp dateFrom,
	 * Timestamp dateTo);
	 */
	
	 @Query(nativeQuery = true, value = "select count(distinct lts.id)  from  soch.lab_test_sample_batch sb\r\n" + 
	    		"	JOIN soch.lab_test_sample lts ON sb.id = lts.test_batch_id\r\n" + 
	    		"  inner join soch.test t on t.id = lts.test_id \r\n" +
	    		"  INNER JOIN soch.facility f ON lts.sample_collected_facility_id = f.id \r\n"+
				"  JOIN soch.address a on a.id = f.address_id \r\n" +
				"  JOIN soch.state s on s.id = a.state_id \r\n" +
	    		"  inner join soch.master_result_type mrt on mrt.id  = lts.result_type_id \r\n" + 
	    		"  JOIN soch.master_sample_status mss ON lts.sample_status_id = mss.id\r\n" + 
	    		"  where mss.status  = 'RESULT POSTED' AND  t.id = 2 and  lts.is_delete=false and \r\n" + 
	    		"  sb.received_date IS NOT NULL and lts.result_received_date IS NOT NULL AND lts.result_received_date between :dateFrom and :dateTo  \r"+
	    		"  and a.state_id =:stateId" ) 
	BigDecimal getVlTestedPlhivByStateId(Integer stateId, Timestamp dateFrom, Timestamp dateTo);

	/*
	 * @Query(nativeQuery = true,
	 * value="SELECT COUNT(distinct bvr.beneficiary_id) AS value FROM soch.beneficiary_visit_register bvr\r\n"
	 * + "inner join soch.ti_beneficiary tb  ON tb.id= bvr.ti_beneficiary_id \r\n" +
	 * "inner join soch.facility f ON tb.facility_id = f.id\r\n" +
	 * "inner join soch.master_client_status msc on msc.id = bvr.ti_client_status_id\r\n"
	 * +
	 * "WHERE msc.name='Active'  AND CAST(ti_client_status_date AS Date) >=  :dateFrom AND\r\n"
	 * +
	 * "CAST(ti_client_status_date AS Date) <=  :dateTo AND f.c_b_status =:tiType\r\n"
	 * + "GROUP BY TO_CHAR(DATE_TRUNC('month',ti_client_status_date),'MONTH')")
	 * List<BigInteger> getActiveHrgBeneficiaryFromBenificiarVisit(String tiType,
	 * Timestamp dateFrom, Timestamp dateTo);
	 */
	 
	 @Query(nativeQuery = true,value="SELECT COUNT(distinct bvr.beneficiary_id) AS value FROM soch.beneficiary_visit_register bvr\r\n" + 
				"inner join soch.ti_beneficiary tb  ON tb.id= bvr.ti_beneficiary_id \r\n" + 
				"inner join soch.facility f ON tb.facility_id = f.id\r\n" + 
				"inner join soch.master_client_status msc on msc.id = bvr.ti_client_status_id\r\n" + 
				"WHERE msc.name='Active'  AND\r\n" + 
				"CAST(ti_client_status_date AS Date) <=  :dateTo AND f.c_b_status =:tiType\r\n"  )
		BigInteger getActiveHrgBeneficiaryFromBenificiarVisit(String tiType,Timestamp dateTo);

	@Query(nativeQuery =  true , value = "select sum(ips.hrg_covered) from  soch.ipc_session  ips\r\n" + 
			"inner join soch.facility f ON ips.facility_id = f.id\r\n" + 
			"where  f.c_b_status =:tiType AND CAST(ips.session_date AS Date)>= :dateFrom AND\r\n" + 
			"CAST(ips.session_date AS Date)<= :dateTo ")
	BigInteger getIpcSessionHrgValue(String tiType, Timestamp dateFrom, Timestamp dateTo);

	@Query(nativeQuery = true,value="SELECT COUNT(distinct bvr.beneficiary_id) AS value FROM soch.beneficiary_visit_register bvr\r\n" + 
			"inner join soch.ti_beneficiary tb  ON tb.id= bvr.ti_beneficiary_id \r\n" + 
			"inner join soch.facility f ON tb.facility_id = f.id\r\n" + 
			" JOIN soch.address a on a.id = f.address_id \r\n" +
			" JOIN soch.state s on s.id = a.state_id \r\n" +
			"inner join soch.master_client_status msc on msc.id = bvr.ti_client_status_id\r\n" + 
			"WHERE msc.name='Active'  AND \r\n" + 
			"CAST(ti_client_status_date AS Date) <= :dateTo AND f.c_b_status =:tiType AND a.state_id =:stateId") 
	BigInteger getActiveHrgBeneficiaryFromBenificiarVisitByStateId(String tiType,Timestamp dateTo,Integer stateId);

	@Query(nativeQuery =  true , value = "select sum(ips.hrg_covered) from  soch.ipc_session  ips\r\n" + 
			"inner join soch.facility f ON ips.facility_id = f.id\r\n" + 
			" JOIN soch.address a on a.id = f.address_id \r\n" +
			" JOIN soch.state s on s.id = a.state_id \r\n" +
			"where  f.c_b_status =:tiType AND CAST(ips.session_date AS Date)>= :dateFrom AND\r\n" + 
			"CAST(ips.session_date AS Date)<= :dateTo AND a.state_id =:stateId ")
	BigInteger getIpcSessionHrgValueByStateId(String tiType, Timestamp dateFrom, Timestamp dateTo, Integer stateId);


	

}
