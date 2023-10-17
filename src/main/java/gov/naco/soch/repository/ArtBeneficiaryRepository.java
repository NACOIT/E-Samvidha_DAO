package gov.naco.soch.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.constructordto.ArtDetailsDTO;
import gov.naco.soch.entity.ArtBeneficiary;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.projection.ArtBeneficiaryExcelProjection;
import gov.naco.soch.projection.ArtBeneficiaryListProjection;
import gov.naco.soch.projection.ArtBeneficiaryProjection;
import gov.naco.soch.projection.WhiteCardDetailsProjection;

@Repository
public interface ArtBeneficiaryRepository extends JpaRepository<ArtBeneficiary, Long>, CustomRepository,
		PagingAndSortingRepository<ArtBeneficiary, Long> {

	@Query(nativeQuery = true, value = "select b.id as beneficiaryId,b.uid as uid,\r\n"
			+ "b.first_name as firstName,b.last_name as lastName,b.middle_name as middleName,\r\n"
			+ "b.art_number as artNumber,b.pre_art_number as preArtNumber,\r\n"
			+ "b.date_of_birth as dateOfBirth,g.name as gender,bs.name as artStatus from soch.art_beneficiary ab\r\n"
			+ "join soch.beneficiary b on(ab.beneficiary_id=b.id)\r\n"
			+ "join soch.master_gender g on(b.gender_id=g.id)\r\n"
			+ "join soch.master_art_beneficiary_status bs on(ab.art_beneficiary_status_id=bs.id)\r\n"
			+ "where ab.beneficiary_id=:beneficiaryId and ab.is_active =true and ab.is_delete =false and b.is_active =true and b.is_delete =false")
	ArtBeneficiaryProjection findByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);

	List<ArtBeneficiary> findByFacilityId(Facility facilityId);

	@Modifying
	@Transactional
	@Query("update ArtBeneficiary ab set ab.isDelete = true , ab.isActive = false where ab.beneficiary.id = :beneficiaryId and ab.facility.id = :facilityId")
	int deleteArtBeneficiary(@Param("beneficiaryId") Long beneficiaryId, @Param("facilityId") Long facilityId);

	@Query(value = "select * from soch.art_beneficiary ab where ab.beneficiary_id=:beneficiaryId and ab.is_delete=:isDelete ", nativeQuery = true)
	ArtBeneficiary findByBeneficiaryIdAndAndIsDelete(@Param("beneficiaryId") Long beneficiaryId,
			@Param("isDelete") boolean isDelete);

	@Query("select new gov.naco.soch.constructordto.ArtDetailsDTO(masterArtBeneficiaryStatus.name as artStatus,facility.name as artCentre) from ArtBeneficiary ab where ab.beneficiary.id=:beneficiaryId"
			+ " and isDelete=:isDelete")
	ArtDetailsDTO getArtStatusAndArtCentre(@Param("beneficiaryId") Long beneficiaryId,
			@Param("isDelete") boolean isDelete);

	@Query(value = "select * from soch.art_beneficiary ab where ab.is_delete=false and ab.beneficiary_id=:id ", nativeQuery = true)
	Optional<ArtBeneficiary> findByBenId(@Param("id") Long id);
	
	@Query(value = "select * from soch.art_beneficiary ab where ab.beneficiary_id=:id and ab.is_delete=false and ab.is_active=true", nativeQuery = true)
	Optional<ArtBeneficiary> findByBenIdIsDeleteAndIsActive(@Param("id") Long id);

	@Query(value = "select * from soch.art_beneficiary ab where ab.beneficiary_id=:beneficiaryId and ab.facility_id=:facilityId", nativeQuery = true)
	Optional<ArtBeneficiary> findByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId,
			@Param("facilityId") Long facilityId);

	@Query(value = "select mabs.name from  art_beneficiary ab inner join soch.beneficiary b on b.id = ab.beneficiary_id inner join \r\n"
			+ " soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\r\n"
			+ " inner join master_art_beneficiary_status mabs on mabs.id = ab.art_beneficiary_status_id  where  ab.beneficiary_id  = :beneficiaryId and  bfm.facility_id  = :facilityId and "
			+ " ab.is_active  = true and ab.is_delete = false ", nativeQuery = true)
	String getBenficiaryStatus(Long beneficiaryId, Long facilityId);

	@Query(value = "select ab.* from soch.art_beneficiary ab where ab.beneficiary_id = :beneficiaryId", nativeQuery = true)
	Optional<ArtBeneficiary> findBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);

	@Modifying
	@Query(nativeQuery = true, value = "update soch.art_beneficiary set art_beneficiary_status_id = :artBeneficiaryStatusId where id in (:artBeneficiaryIdList) ")
	void updateArtBeneficiaryStatusId(@Param("artBeneficiaryIdList") List<Long> artBeneficiaryIdList,
			@Param("artBeneficiaryStatusId") Long artBeneficiaryStatusId);

	@Query(nativeQuery = true, value = " select distinct(beneficiary_id) from soch.art_beneficiary where hiv_risk_factor_id  in (:riskFactorValueIds)"
			+ " and is_active = true and is_delete = false")
	Set<Long> findRiskFactorBeneficiaryList(@Param("riskFactorValueIds") Set<Long> riskFactorValueIds);

	@Query(nativeQuery = true, value = "select b.id as beneficiaryId, b.uid as uid, b.first_name as firstName, b.middle_name as middleName, b.last_name as lastName, b.pre_art_number as preArtNumber, b.art_number as artNumber, bg.name as gender, b.date_of_birth as dateOfBirth, mab.name as status from soch.art_beneficiary ab inner join soch.beneficiary b on (ab.beneficiary_id = b.id) inner join soch.master_gender bg on (b.gender_id = bg.id) inner join soch.master_art_beneficiary_status mab on (mab.id = ab.art_beneficiary_status_id) where b.is_delete = false and b.category_id <= :categoryId and ab.facility_id = :facilityId and ab.is_delete = false ", countQuery = "select count(*) from soch.beneficiary b join soch.art_beneficiary ab on ab.beneficiary_id = b.id and ab.facility_id = :facilityId and ab.is_delete = false join soch.master_gender bg on b.gender_id = bg.id join soch.master_art_beneficiary_status mab on mab.id = ab.art_beneficiary_status_id where b.is_delete = false and b.category_id <= :categoryId ")
	Page<ArtBeneficiaryListProjection> findPediatricBeneficiariesByFacilityId(@Param("facilityId") Long facilityId,
			@Param("categoryId") Long categoryId, Pageable pageable);

	@Query(nativeQuery = true, value = "select b.id as beneficiaryid, b.uid as uid, b.first_name as firstname, b.middle_name as middlename, b.last_name as lastname, b.pre_art_number as preartnumber, b.art_number as artnumber, bg.name as gender, b.date_of_birth as dateofbirth, mab.name as status from soch.art_beneficiary ab inner join soch.beneficiary b on (ab.beneficiary_id = b.id) inner join soch.master_gender bg on (b.gender_id = bg.id) inner join soch.master_art_beneficiary_status mab on (mab.id = ab.art_beneficiary_status_id) where b.is_delete = false and b.category_id <= :categoryId and ab.facility_id = :facilityId and ab.is_delete = false and mobile_number = :searchString ", countQuery = "select count(*) from soch.beneficiary b join soch.art_beneficiary ab on ab.beneficiary_id = b.id and ab.facility_id = :facilityId and b.category_id <= :categoryId and ab.is_delete = false join soch.master_gender bg on b.gender_id = bg.id join soch.master_art_beneficiary_status mab on mab.id = ab.art_beneficiary_status_id where b.is_delete = false and mobile_number = :searchString")
	Page<ArtBeneficiaryListProjection> findPediatricBeneficiaryByMobileNo(@Param("facilityId") Long facilityId,
			@Param("categoryId") Long categoryId, @Param("searchString") String searchString, Pageable pageable);

	@Query(nativeQuery = true, value = "select b.id as beneficiaryid, b.uid as uid, b.first_name as firstname, b.middle_name as middlename, b.last_name as lastname, b.pre_art_number as preartnumber, b.art_number as artnumber, bg.name as gender, b.date_of_birth as dateofbirth, mab.name as status from soch.art_beneficiary ab inner join soch.beneficiary b on (ab.beneficiary_id = b.id) inner join soch.master_gender bg on (b.gender_id = bg.id) inner join soch.master_art_beneficiary_status mab on (mab.id = ab.art_beneficiary_status_id) where b.is_delete = false and b.category_id <= :categoryId and ab.facility_id = :facilityId and ab.is_delete = false and lower(uid) = lower(:searchString) ", countQuery = "select count(*) from soch.beneficiary b join soch.art_beneficiary ab on ab.beneficiary_id = b.id and ab.facility_id = :facilityId and b.category_id <= :categoryId and ab.is_delete = false join soch.master_gender bg on b.gender_id = bg.id join soch.master_art_beneficiary_status mab on mab.id = ab.art_beneficiary_status_id where b.is_delete = false and lower(uid) = lower(:searchString) ")
	Page<ArtBeneficiaryListProjection> findPediatricBeneficiaryByUid(@Param("facilityId") Long facilityId,
			@Param("categoryId") Long categoryId, @Param("searchString") String searchString, Pageable pageable);

	@Query(nativeQuery = true, value = "select b.id as beneficiaryid, b.uid as uid, b.first_name as firstname, b.middle_name as middlename, b.last_name as lastname, b.pre_art_number as preartnumber, b.art_number as artnumber, bg.name as gender, b.date_of_birth as dateofbirth, mab.name as status from soch.art_beneficiary ab inner join soch.beneficiary b on (ab.beneficiary_id = b.id) inner join soch.master_gender bg on (b.gender_id = bg.id) inner join soch.master_art_beneficiary_status mab on (mab.id = ab.art_beneficiary_status_id) where b.is_delete = false and b.category_id <= :categoryId and ab.facility_id = :facilityId and ab.is_delete = false and (lower(art_benf_search_str) like %:searchString%)", countQuery = "select count(*) from soch.beneficiary b join soch.art_beneficiary ab on ab.beneficiary_id = b.id and ab.facility_id = :facilityId and b.category_id <= :categoryId and ab.is_delete = false join soch.master_gender bg on b.gender_id = bg.id join soch.master_art_beneficiary_status mab on mab.id = ab.art_beneficiary_status_id where b.is_delete = false and (lower(b.art_benf_search_str) like %:searchString%)")
	Page<ArtBeneficiaryListProjection> findPediatricBeneficiaryByBasicSearch(@Param("facilityId") Long facilityId,
			@Param("categoryId") Long categoryId, @Param("searchString") String searchString, Pageable pageable);

	@Query(nativeQuery = true, value = "select b.id as beneficiaryid, b.uid as uid, b.first_name as firstname, b.middle_name as middlename, b.last_name as lastname, b.pre_art_number as preartnumber, b.art_number as artnumber, bg.name as gender, b.date_of_birth as dateofbirth, mab.name as status from soch.art_beneficiary ab inner join soch.beneficiary b on (ab.beneficiary_id = b.id) inner join soch.master_gender bg on (b.gender_id = bg.id) inner join soch.master_art_beneficiary_status mab on (mab.id = ab.art_beneficiary_status_id) where b.is_delete = false and b.category_id <= :categoryId and ab.facility_id = :facilityId and ab.is_delete = false and tsv_artvalues @@ to_tsquery(:searchString) ", countQuery = "select count(*) from soch.beneficiary b join soch.art_beneficiary ab on ab.beneficiary_id = b.id and ab.facility_id = :facilityId and b.category_id <= :categoryId and ab.is_delete = false join soch.master_gender bg on b.gender_id = bg.id join soch.master_art_beneficiary_status mab on mab.id = ab.art_beneficiary_status_id where b.is_delete = false and tsv_artvalues @@ to_tsquery(:searchString)")
	Page<ArtBeneficiaryListProjection> findPediatricBeneficiaryByBasicSearchWithTsVector(
			@Param("facilityId") Long facilityId, @Param("categoryId") Long categoryId,
			@Param("searchString") String searchString, Pageable pageable);

	@Query(nativeQuery = true, value = "select b.id as beneficiaryId, b.uid as uid, b.first_name as firstName, b.middle_name as middleName, b.last_name as lastName, mg.name as gender, b.mobile_number as mobileNumber, b.date_of_birth as dateOfBirth,bfm.pre_art_number as oldPreArtNumber,bfm.art_number as oldArtNumber, b.pre_art_number as preArtNumber, b.art_number as artNumber, res1.status as status, res1.lac_linked as lacLinked, res1.is_transit as isTransit, res1.transfer_status as artTransferStatus, res1.name as transferredTo from ( select case when t1.beneficiary_id is not null then t1.beneficiary_id else t2.beneficiary_id end as beneficiary_id, case when t1.art_beneficiary_status_id is not null then t1.art_beneficiary_status_id else t2.art_beneficiary_status_id end as art_beneficiary_status_id, case when t1.is_transit is not null then t1.is_transit else t2.is_transit end as is_transit, case when t1.lac_linked is not null then t1.lac_linked else t2.lac_linked end as lac_linked, case when t1.status is not null then t1.status else t2.status end as status,case when t1.facility_id =:facilityId and t2.transfer_status!='PENDING' then null else t2.transfer_status end as transfer_status, case when t1.facility_id =:facilityId and t2.transfer_status!='PENDING' then null else t2.name end as name  from ( select pa.beneficiary_id, pa.facility_id, pa.art_beneficiary_status_id as art_beneficiary_status_id, pa.lac_linked, mas.name as status, case when ( CURRENT_DATE >= pa.transit_start_date and CURRENT_DATE <= pa.transit_end_date) then true else false end as is_transit from soch.art_beneficiary pa, soch.master_art_beneficiary_status mas where pa.facility_id = :facilityId and pa.is_active = true and pa.is_delete = false and pa.art_beneficiary_status_id = mas.id) t1 full outer join ( select t.beneficiary_id, t.source_facility_id, t.transfer_status, pa1.facility_id, pa1.lac_linked, pa1.art_beneficiary_status_id, fac.name, mas.name as status, case when ( CURRENT_DATE >= pa1.transit_start_date and CURRENT_DATE <= pa1.transit_end_date ) then true else false end as is_transit from soch.transfers t inner join soch.art_beneficiary pa1 on ( t.beneficiary_id = pa1.beneficiary_id and pa1.is_delete = false) inner join soch.master_art_beneficiary_status mas on ( pa1.art_beneficiary_status_id = mas.id ) inner join soch.facility fac on (fac.id = t.destination_facility_id) where t.source_facility_id = :facilityId and t.id in ( select max(tr1.id) id from soch.transfers tr1 where tr1.source_facility_id = :facilityId group by tr1.beneficiary_id ) ) t2 on ( t1.beneficiary_id = t2.beneficiary_id ) ) res1 inner join soch.beneficiary b on (res1.beneficiary_id = b.id and b.is_delete = false) inner join soch.master_gender mg on (mg.id = b.gender_id) left join (select beneficiary_id,art_number, pre_art_number from soch.beneficiary_facility_mapping where id in ( select max(bfm1.id) id from soch.beneficiary_facility_mapping bfm1 where bfm1.facility_id =:facilityId and bfm1.is_delete = true group by bfm1.beneficiary_id ) ) bfm on (bfm.beneficiary_id = b.id) ", countQuery = "select count(*) from( select case when t1.beneficiary_id is not null then t1.beneficiary_id else t2.beneficiary_id end as beneficiary_id, case when t1.art_beneficiary_status_id is not null then t1.art_beneficiary_status_id else t2.art_beneficiary_status_id end as art_beneficiary_status_id, case when t1.is_transit is not null then t1.is_transit else t2.is_transit end as is_transit, case when t1.lac_linked is not null then t1.lac_linked else t2.lac_linked end as lac_linked, case when t1.status is not null then t1.status else t2.status end as status, t2.transfer_status, t2.name from ( select pa.beneficiary_id, pa.facility_id, pa.art_beneficiary_status_id as art_beneficiary_status_id, pa.lac_linked, mas.name as status, case when ( CURRENT_DATE >= pa.transit_start_date and CURRENT_DATE <= pa.transit_end_date) then true else false end as is_transit from soch.art_beneficiary pa, soch.master_art_beneficiary_status mas where pa.facility_id = :facilityId and pa.is_active = true and pa.is_delete = false and pa.art_beneficiary_status_id = mas.id) t1 full outer join ( select t.beneficiary_id, t.source_facility_id, t.transfer_status, pa1.facility_id, pa1.lac_linked, pa1.art_beneficiary_status_id, fac.name, mas.name as status, case when ( CURRENT_DATE >= pa1.transit_start_date and CURRENT_DATE <= pa1.transit_end_date ) then true else false end as is_transit from soch.transfers t inner join soch.art_beneficiary pa1 on ( t.beneficiary_id = pa1.beneficiary_id and pa1.is_delete=false) inner join soch.master_art_beneficiary_status mas on ( pa1.art_beneficiary_status_id = mas.id ) inner join soch.facility fac on (fac.id = t.destination_facility_id) where t.source_facility_id = :facilityId and t.id in ( select max(tr1.id) id from soch.transfers tr1 where tr1.source_facility_id = :facilityId group by tr1.beneficiary_id ) ) t2 on ( t1.beneficiary_id = t2.beneficiary_id ) ) res1 inner join soch.beneficiary b on (res1.beneficiary_id = b.id and b.is_delete = false) inner join soch.master_gender mg on (mg.id = b.gender_id) ")
	Page<ArtBeneficiaryListProjection> findArtBeneficiariesByFacilityId(@Param("facilityId") Long facilityId,
			Pageable pageable);

	@Query(nativeQuery = true, value = "select b.id as beneficiaryId, b.uid as uid, b.first_name as firstName, b.middle_name as middleName, b.last_name as lastName, mg.name as gender, b.mobile_number as mobileNumber, b.date_of_birth as dateOfBirth,bfm.pre_art_number as oldPreArtNumber,bfm.art_number as oldArtNumber, b.pre_art_number as preArtNumber, b.art_number as artNumber, res1.status as status, res1.lac_linked as lacLinked, res1.is_transit as isTransit, res1.transfer_status as artTransferStatus, res1.name as transferredTo from ( select case when t1.beneficiary_id is not null then t1.beneficiary_id else t2.beneficiary_id end as beneficiary_id, case when t1.art_beneficiary_status_id is not null then t1.art_beneficiary_status_id else t2.art_beneficiary_status_id end as art_beneficiary_status_id, case when t1.is_transit is not null then t1.is_transit else t2.is_transit end as is_transit, case when t1.lac_linked is not null then t1.lac_linked else t2.lac_linked end as lac_linked, case when t1.status is not null then t1.status else t2.status end as status, case when t1.facility_id =:facilityId and t2.transfer_status!='PENDING' then null else t2.transfer_status end as transfer_status,case when t1.facility_id =:facilityId and t2.transfer_status!='PENDING' then null else t2.name end as name from ( select pa.beneficiary_id, pa.facility_id, pa.art_beneficiary_status_id as art_beneficiary_status_id, pa.lac_linked, mas.name as status, case when ( CURRENT_DATE >= pa.transit_start_date and CURRENT_DATE <= pa.transit_end_date) then true else false end as is_transit from soch.art_beneficiary pa, soch.master_art_beneficiary_status mas where pa.facility_id = :facilityId and pa.is_active = true and pa.is_delete = false and pa.art_beneficiary_status_id = mas.id) t1 full outer join ( select t.beneficiary_id, t.source_facility_id, t.transfer_status, pa1.facility_id, pa1.lac_linked, pa1.art_beneficiary_status_id, fac.name, mas.name as status, case when ( CURRENT_DATE >= pa1.transit_start_date and CURRENT_DATE <= pa1.transit_end_date ) then true else false end as is_transit from soch.transfers t inner join soch.art_beneficiary pa1 on ( t.beneficiary_id = pa1.beneficiary_id and pa1.is_delete = false) inner join soch.master_art_beneficiary_status mas on ( pa1.art_beneficiary_status_id = mas.id ) inner join soch.facility fac on (fac.id = t.destination_facility_id) where t.source_facility_id = :facilityId and t.id in ( select max(tr1.id) id from soch.transfers tr1 where tr1.source_facility_id = :facilityId group by tr1.beneficiary_id ) ) t2 on ( t1.beneficiary_id = t2.beneficiary_id ) ) res1 inner join soch.beneficiary b on (res1.beneficiary_id = b.id and b.is_delete = false) inner join soch.master_gender mg on (mg.id = b.gender_id) left join (select beneficiary_id, art_number, pre_art_number from soch.beneficiary_facility_mapping where id in (select max(bfm1.id) id from soch.beneficiary_facility_mapping bfm1 where bfm1.facility_id =:facilityId and bfm1.is_delete = true group by bfm1.beneficiary_id ) ) bfm on (bfm.beneficiary_id = b.id) where b.is_delete = false and mobile_number = :searchString ", countQuery = " select count(*) from ( select case when t1.beneficiary_id is not null then t1.beneficiary_id else t2.beneficiary_id end as beneficiary_id, case when t1.art_beneficiary_status_id is not null then t1.art_beneficiary_status_id else t2.art_beneficiary_status_id end as art_beneficiary_status_id, case when t1.is_transit is not null then t1.is_transit else t2.is_transit end as is_transit, case when t1.lac_linked is not null then t1.lac_linked else t2.lac_linked end as lac_linked, case when t1.status is not null then t1.status else t2.status end as status, t2.transfer_status, t2.name from ( select pa.beneficiary_id, pa.facility_id, pa.art_beneficiary_status_id as art_beneficiary_status_id, pa.lac_linked, mas.name as status, case when ( CURRENT_DATE >= pa.transit_start_date and CURRENT_DATE <= pa.transit_end_date) then true else false end as is_transit from soch.art_beneficiary pa, soch.master_art_beneficiary_status mas where pa.facility_id = :facilityId and pa.is_active = true and pa.is_delete = false and pa.art_beneficiary_status_id = mas.id) t1 full outer join ( select t.beneficiary_id, t.source_facility_id, t.transfer_status, pa1.facility_id, pa1.lac_linked, pa1.art_beneficiary_status_id, fac.name, mas.name as status, case when ( CURRENT_DATE >= pa1.transit_start_date and CURRENT_DATE <= pa1.transit_end_date ) then true else false end as is_transit from soch.transfers t inner join soch.art_beneficiary pa1 on ( t.beneficiary_id = pa1.beneficiary_id and pa1.is_delete = false) inner join soch.master_art_beneficiary_status mas on ( pa1.art_beneficiary_status_id = mas.id ) inner join soch.facility fac on (fac.id = t.destination_facility_id) where t.source_facility_id = :facilityId and t.id in ( select max(tr1.id) id from soch.transfers tr1 where tr1.source_facility_id = :facilityId group by tr1.beneficiary_id ) ) t2 on ( t1.beneficiary_id = t2.beneficiary_id ) ) res1 inner join soch.beneficiary b on (res1.beneficiary_id = b.id and b.is_delete = false) inner join soch.master_gender mg on (mg.id = b.gender_id) where mobile_number = :searchString ")
	Page<ArtBeneficiaryListProjection> findArtBeneficiaryByMobilNo(@Param("facilityId") Long facilityId,
			@Param("searchString") String searchString, Pageable pageable);

	@Query(nativeQuery = true, value = "select b.id as beneficiaryId, b.uid as uid, b.first_name as firstName, b.middle_name as middleName, b.last_name as lastName, mg.name as gender, b.mobile_number as mobileNumber, b.date_of_birth as dateOfBirth,bfm.pre_art_number as oldPreArtNumber,bfm.art_number as oldArtNumber, b.pre_art_number as preArtNumber, b.art_number as artNumber, res1.status as status, res1.lac_linked as lacLinked, res1.is_transit as isTransit, res1.transfer_status as artTransferStatus, res1.name as transferredTo from ( select case when t1.beneficiary_id is not null then t1.beneficiary_id else t2.beneficiary_id end as beneficiary_id, case when t1.art_beneficiary_status_id is not null then t1.art_beneficiary_status_id else t2.art_beneficiary_status_id end as art_beneficiary_status_id, case when t1.is_transit is not null then t1.is_transit else t2.is_transit end as is_transit, case when t1.lac_linked is not null then t1.lac_linked else t2.lac_linked end as lac_linked,case when t1.status is not null then t1.status else t2.status end as status, case when t1.facility_id =:facilityId and t2.transfer_status!='PENDING' then null else t2.transfer_status end as transfer_status,case when t1.facility_id =:facilityId and t2.transfer_status!='PENDING' then null else t2.name end as name from ( select pa.beneficiary_id, pa.facility_id, pa.art_beneficiary_status_id as art_beneficiary_status_id, pa.lac_linked, mas.name as status, case when ( CURRENT_DATE >= pa.transit_start_date and CURRENT_DATE <= pa.transit_end_date) then true else false end as is_transit from soch.art_beneficiary pa, soch.master_art_beneficiary_status mas where pa.facility_id = :facilityId and pa.is_active = true and pa.is_delete = false and pa.art_beneficiary_status_id = mas.id) t1 full outer join ( select t.beneficiary_id, t.source_facility_id, t.transfer_status, pa1.facility_id, pa1.lac_linked, pa1.art_beneficiary_status_id, fac.name, mas.name as status, case when ( CURRENT_DATE >= pa1.transit_start_date and CURRENT_DATE <= pa1.transit_end_date ) then true else false end as is_transit from soch.transfers t inner join soch.art_beneficiary pa1 on ( t.beneficiary_id = pa1.beneficiary_id and pa1.is_delete = false) inner join soch.master_art_beneficiary_status mas on ( pa1.art_beneficiary_status_id = mas.id ) inner join soch.facility fac on (fac.id = t.destination_facility_id) where t.source_facility_id = :facilityId and t.id in ( select max(tr1.id) id from soch.transfers tr1 where tr1.source_facility_id = :facilityId group by tr1.beneficiary_id ) ) t2 on ( t1.beneficiary_id = t2.beneficiary_id ) ) res1 inner join soch.beneficiary b on (res1.beneficiary_id = b.id and b.is_delete = false) inner join soch.master_gender mg on (mg.id = b.gender_id) left join (select beneficiary_id, art_number, pre_art_number from soch.beneficiary_facility_mapping where id in (select max(bfm1.id) id from soch.beneficiary_facility_mapping bfm1 where bfm1.facility_id =:facilityId and bfm1.is_delete = true group by bfm1.beneficiary_id ) ) bfm on (bfm.beneficiary_id = b.id) where b.is_delete = false and lower(uid) = lower(:searchString) ", countQuery = " select count(*) from ( select case when t1.beneficiary_id is not null then t1.beneficiary_id else t2.beneficiary_id end as beneficiary_id, case when t1.art_beneficiary_status_id is not null then t1.art_beneficiary_status_id else t2.art_beneficiary_status_id end as art_beneficiary_status_id, case when t1.is_transit is not null then t1.is_transit else t2.is_transit end as is_transit, case when t1.lac_linked is not null then t1.lac_linked else t2.lac_linked end as lac_linked, case when t1.status is not null then t1.status else t2.status end as status, t2.transfer_status, t2.name from ( select pa.beneficiary_id, pa.facility_id, pa.art_beneficiary_status_id as art_beneficiary_status_id, pa.lac_linked, mas.name as status, case when ( CURRENT_DATE >= pa.transit_start_date and CURRENT_DATE <= pa.transit_end_date) then true else false end as is_transit from soch.art_beneficiary pa, soch.master_art_beneficiary_status mas where pa.facility_id = :facilityId and pa.is_active = true and pa.is_delete = false and pa.art_beneficiary_status_id = mas.id) t1 full outer join ( select t.beneficiary_id, t.source_facility_id, t.transfer_status, pa1.facility_id, pa1.lac_linked, pa1.art_beneficiary_status_id, fac.name, mas.name as status, case when ( CURRENT_DATE >= pa1.transit_start_date and CURRENT_DATE <= pa1.transit_end_date ) then true else false end as is_transit from soch.transfers t inner join soch.art_beneficiary pa1 on ( t.beneficiary_id = pa1.beneficiary_id and pa1.is_delete = false) inner join soch.master_art_beneficiary_status mas on ( pa1.art_beneficiary_status_id = mas.id ) inner join soch.facility fac on (fac.id = t.destination_facility_id) where t.source_facility_id = :facilityId and t.id in ( select max(tr1.id) id from soch.transfers tr1 where tr1.source_facility_id = :facilityId group by tr1.beneficiary_id ) ) t2 on ( t1.beneficiary_id = t2.beneficiary_id ) ) res1 inner join soch.beneficiary b on (res1.beneficiary_id = b.id and b.is_delete = false) inner join soch.master_gender mg on (mg.id = b.gender_id) where  lower(uid) = lower(:searchString) ")
	Page<ArtBeneficiaryListProjection> findArtBeneficiaryByUid(@Param("facilityId") Long facilityId,
			@Param("searchString") String searchString, Pageable pageable);

	@Query(nativeQuery = true, value = "select b.id as beneficiaryId, b.uid as uid, b.first_name as firstName, b.middle_name as middleName, b.last_name as lastName, mg.name as gender, b.mobile_number as mobileNumber, b.date_of_birth as dateOfBirth,bfm.pre_art_number as oldPreArtNumber,bfm.art_number as oldArtNumber, b.pre_art_number as preArtNumber, b.art_number as artNumber, res1.status as status, res1.lac_linked as lacLinked, res1.is_transit as isTransit, res1.transfer_status as artTransferStatus, res1.name as transferredTo from ( select case when t1.beneficiary_id is not null then t1.beneficiary_id else t2.beneficiary_id end as beneficiary_id, case when t1.art_beneficiary_status_id is not null then t1.art_beneficiary_status_id else t2.art_beneficiary_status_id end as art_beneficiary_status_id, case when t1.is_transit is not null then t1.is_transit else t2.is_transit end as is_transit, case when t1.lac_linked is not null then t1.lac_linked else t2.lac_linked end as lac_linked,case when t1.status is not null then t1.status else t2.status end as status, case when t1.facility_id =:facilityId and t2.transfer_status!='PENDING' then null else t2.transfer_status end as transfer_status,case when t1.facility_id =:facilityId and t2.transfer_status!='PENDING' then null else t2.name end as name from ( select pa.beneficiary_id, pa.facility_id, pa.art_beneficiary_status_id as art_beneficiary_status_id, pa.lac_linked, mas.name as status, case when ( CURRENT_DATE >= pa.transit_start_date and CURRENT_DATE <= pa.transit_end_date) then true else false end as is_transit from soch.art_beneficiary pa, soch.master_art_beneficiary_status mas where pa.facility_id = :facilityId and pa.is_active = true and pa.is_delete = false and pa.art_beneficiary_status_id = mas.id) t1 full outer join ( select t.beneficiary_id, t.source_facility_id, t.transfer_status, pa1.facility_id, pa1.lac_linked, pa1.art_beneficiary_status_id, fac.name, mas.name as status, case when ( CURRENT_DATE >= pa1.transit_start_date and CURRENT_DATE <= pa1.transit_end_date ) then true else false end as is_transit from soch.transfers t inner join soch.art_beneficiary pa1 on ( t.beneficiary_id = pa1.beneficiary_id and pa1.is_delete = false) inner join soch.master_art_beneficiary_status mas on ( pa1.art_beneficiary_status_id = mas.id ) inner join soch.facility fac on (fac.id = t.destination_facility_id) where t.source_facility_id = :facilityId and t.id in ( select max(tr1.id) id from soch.transfers tr1 where tr1.source_facility_id = :facilityId group by tr1.beneficiary_id ) ) t2 on ( t1.beneficiary_id = t2.beneficiary_id ) ) res1 inner join soch.beneficiary b on (res1.beneficiary_id = b.id and b.is_delete = false) inner join soch.master_gender mg on (mg.id = b.gender_id) left join soch.beneficiary_facility_mapping bfm on (bfm.beneficiary_id=b.id and bfm.is_delete=true)  where b.tsv_artvalues @@ to_tsquery(:searchString) ", countQuery = " select count(*) from ( select case when t1.beneficiary_id is not null then t1.beneficiary_id else t2.beneficiary_id end as beneficiary_id, case when t1.art_beneficiary_status_id is not null then t1.art_beneficiary_status_id else t2.art_beneficiary_status_id end as art_beneficiary_status_id, case when t1.is_transit is not null then t1.is_transit else t2.is_transit end as is_transit, case when t1.lac_linked is not null then t1.lac_linked else t2.lac_linked end as lac_linked, case when t1.status is not null then t1.status else t2.status end as status, t2.transfer_status, t2.name from ( select pa.beneficiary_id, pa.facility_id, pa.art_beneficiary_status_id as art_beneficiary_status_id, pa.lac_linked, mas.name as status, case when ( CURRENT_DATE >= pa.transit_start_date and CURRENT_DATE <= pa.transit_end_date) then true else false end as is_transit from soch.art_beneficiary pa, soch.master_art_beneficiary_status mas where pa.facility_id = :facilityId and pa.is_active = true and pa.is_delete = false and pa.art_beneficiary_status_id = mas.id) t1 full outer join ( select t.beneficiary_id, t.source_facility_id, t.transfer_status, pa1.facility_id, pa1.lac_linked, pa1.art_beneficiary_status_id, fac.name, mas.name as status, case when ( CURRENT_DATE >= pa1.transit_start_date and CURRENT_DATE <= pa1.transit_end_date ) then true else false end as is_transit from soch.transfers t inner join soch.art_beneficiary pa1 on ( t.beneficiary_id = pa1.beneficiary_id and pa1.is_delete = false) inner join soch.master_art_beneficiary_status mas on ( pa1.art_beneficiary_status_id = mas.id ) inner join soch.facility fac on (fac.id = t.destination_facility_id) where t.source_facility_id = :facilityId and t.id in ( select max(tr1.id) id from soch.transfers tr1 where tr1.source_facility_id = :facilityId group by tr1.beneficiary_id ) ) t2 on ( t1.beneficiary_id = t2.beneficiary_id ) ) res1 inner join soch.beneficiary b on (res1.beneficiary_id = b.id and b.is_delete = false) inner join soch.master_gender mg on (mg.id = b.gender_id) where b.tsv_artvalues @@ to_tsquery(:searchString) ")
	Page<ArtBeneficiaryListProjection> findArtBeneficiaryWithTsVector(@Param("facilityId") Long facilityId,
			@Param("searchString") String searchString, Pageable pageable);

//	@Query(nativeQuery = true, value = "select b.id as beneficiaryId, b.uid as uid, b.first_name as firstName, b.middle_name as middleName, b.last_name as lastName, mg.name as gender, b.mobile_number as mobileNumber, b.date_of_birth as dateOfBirth,bfm.pre_art_number as oldPreArtNumber,bfm.art_number as oldArtNumber, b.pre_art_number as preArtNumber, b.art_number as artNumber, res1.status as status, res1.lac_linked as lacLinked, res1.is_transit as isTransit, res1.transfer_status as artTransferStatus, res1.name as transferredTo from ( select case when t1.beneficiary_id is not null then t1.beneficiary_id else t2.beneficiary_id end as beneficiary_id, case when t1.art_beneficiary_status_id is not null then t1.art_beneficiary_status_id else t2.art_beneficiary_status_id end as art_beneficiary_status_id, case when t1.is_transit is not null then t1.is_transit else t2.is_transit end as is_transit, case when t1.lac_linked is not null then t1.lac_linked else t2.lac_linked end as lac_linked, case when t1.status is not null then t1.status else t2.status end as status, t2.transfer_status, t2.name from ( select pa.beneficiary_id, pa.facility_id, pa.art_beneficiary_status_id as art_beneficiary_status_id, pa.lac_linked, mas.name as status, case when ( CURRENT_DATE >= pa.transit_start_date and CURRENT_DATE <= pa.transit_end_date) then true else false end as is_transit from soch.art_beneficiary pa, soch.master_art_beneficiary_status mas where pa.facility_id = :facilityId and pa.is_active = true and pa.is_delete = false and pa.art_beneficiary_status_id = mas.id) t1 full outer join ( select t.beneficiary_id, t.source_facility_id, t.transfer_status, pa1.facility_id, pa1.lac_linked, pa1.art_beneficiary_status_id, fac.name, mas.name as status, case when ( CURRENT_DATE >= pa1.transit_start_date and CURRENT_DATE <= pa1.transit_end_date ) then true else false end as is_transit from soch.transfers t inner join soch.art_beneficiary pa1 on ( t.beneficiary_id = pa1.beneficiary_id and pa1.is_delete = false) inner join soch.master_art_beneficiary_status mas on ( pa1.art_beneficiary_status_id = mas.id ) inner join soch.facility fac on (fac.id = t.destination_facility_id) where t.source_facility_id = :facilityId and t.id in ( select max(tr1.id) id from soch.transfers tr1 where tr1.source_facility_id = :facilityId group by tr1.beneficiary_id ) ) t2 on ( t1.beneficiary_id = t2.beneficiary_id ) ) res1 inner join soch.beneficiary b on (res1.beneficiary_id = b.id and b.is_delete = false) inner join soch.master_gender mg on (mg.id = b.gender_id) left join soch.beneficiary_facility_mapping bfm on (bfm.beneficiary_id=b.id and bfm.is_delete=true)  "
//			+ "where b.is_delete=false and (lower(b.uid) like %:searchString% or lower(b.art_number) like %:searchString% or lower(b.pre_art_number) like %:searchString% or lower(b.first_name) like %:searchString% or lower(b.last_name) like %:searchString% or lower(b.middle_name) like %:searchString% or concat(lower(b.first_name), ' ',lower(b.middle_name), ' ',lower(b.last_name)) like %:searchString% or concat(lower(b.first_name), ' ',lower(b.middle_name)) like %:searchString% or concat(lower(b.first_name), ' ',lower(b.last_name)) like %:searchString% )"
//			, countQuery = " select count(*) from ( select case when t1.beneficiary_id is not null then t1.beneficiary_id else t2.beneficiary_id end as beneficiary_id, case when t1.art_beneficiary_status_id is not null then t1.art_beneficiary_status_id else t2.art_beneficiary_status_id end as art_beneficiary_status_id, case when t1.is_transit is not null then t1.is_transit else t2.is_transit end as is_transit, case when t1.lac_linked is not null then t1.lac_linked else t2.lac_linked end as lac_linked, case when t1.status is not null then t1.status else t2.status end as status, t2.transfer_status, t2.name from ( select pa.beneficiary_id, pa.facility_id, pa.art_beneficiary_status_id as art_beneficiary_status_id, pa.lac_linked, mas.name as status, case when ( CURRENT_DATE >= pa.transit_start_date and CURRENT_DATE <= pa.transit_end_date) then true else false end as is_transit from soch.art_beneficiary pa, soch.master_art_beneficiary_status mas where pa.facility_id = :facilityId and pa.is_active = true and pa.is_delete = false and pa.art_beneficiary_status_id = mas.id) t1 full outer join ( select t.beneficiary_id, t.source_facility_id, t.transfer_status, pa1.facility_id, pa1.lac_linked, pa1.art_beneficiary_status_id, fac.name, mas.name as status, case when ( CURRENT_DATE >= pa1.transit_start_date and CURRENT_DATE <= pa1.transit_end_date ) then true else false end as is_transit from soch.transfers t inner join soch.art_beneficiary pa1 on ( t.beneficiary_id = pa1.beneficiary_id and pa1.is_delete = false) inner join soch.master_art_beneficiary_status mas on ( pa1.art_beneficiary_status_id = mas.id ) inner join soch.facility fac on (fac.id = t.destination_facility_id) where t.source_facility_id = :facilityId and t.id in ( select max(tr1.id) id from soch.transfers tr1 where tr1.source_facility_id = :facilityId group by tr1.beneficiary_id ) ) t2 on ( t1.beneficiary_id = t2.beneficiary_id ) ) res1 inner join soch.beneficiary b on (res1.beneficiary_id = b.id and b.is_delete = false) inner join soch.master_gender mg on (mg.id = b.gender_id) where b.tsv_artvalues @@ to_tsquery(:searchString) ")
//	Page<ArtBeneficiaryListProjection> findArtBeneficiaryByBasicSearch(@Param("facilityId") Long facilityId, @Param("searchString") String searchString, Pageable pageable);

	@Query(nativeQuery = true, value = " select b.id as beneficiaryId, b.uid as uid, b.first_name as firstName, b.middle_name as middleName, b.last_name as lastName, b.pre_art_number as preArtNumber, b.art_number as artNumber, bg.name as gender, b.date_of_birth as dateOfBirth, mab.name as status from soch.art_beneficiary ab inner join soch.beneficiary b on (ab.beneficiary_id = b.id and ab.facility_id =:facilityId and ab.is_delete = false) inner join soch.master_gender bg on (b.gender_id = bg.id) inner join soch.master_art_beneficiary_status mab on (mab.id = ab.art_beneficiary_status_id) where b.is_delete = false", countQuery = "select count(*) from soch.beneficiary b join soch.art_beneficiary ab on ab.beneficiary_id = b.id and ab.facility_id =:facilityId and ab.is_delete = false join soch.master_gender bg on b.gender_id = bg.id join soch.master_art_beneficiary_status mab on mab.id = ab.art_beneficiary_status_id where b.is_delete=false  ")
	Page<ArtBeneficiaryListProjection> findArtBeneficiariesByPresentFacilityId(@Param("facilityId") Long facilityId,
			Pageable pageable);

//	@Query(nativeQuery = true, value = "select b.id as beneficiaryId, b.uid as uid, b.first_name as firstName, b.middle_name as middleName, b.last_name as lastName, b.pre_art_number as preArtNumber, b.art_number as artNumber, bg.name as gender, b.date_of_birth as dateOfBirth, mab.name as status from soch.art_beneficiary ab inner join soch.beneficiary b on (ab.beneficiary_id = b.id and ab.facility_id =:facilityId and ab.is_delete = false) inner join soch.master_gender bg on (b.gender_id = bg.id) inner join soch.master_art_beneficiary_status mab on (mab.id = ab.art_beneficiary_status_id) where b.is_delete = false and (lower(art_benf_search_str) like %:searchString%)", countQuery = " select count(*) from soch.beneficiary b join soch.art_beneficiary ab on ab.beneficiary_id = b.id and ab.facility_id =:facilityId and ab.is_delete = false join soch.master_gender bg on b.gender_id = bg.id join soch.master_art_beneficiary_status mab on mab.id = ab.art_beneficiary_status_id where b.is_delete=false and (lower(art_benf_search_str) like %:searchString%)")
//	Page<ArtBeneficiaryListProjection> findArtBeneficiariesByPresentFacilityBasicSearch(
//			@Param("facilityId") Long facilityId, @Param("searchString") String searchString, Pageable pageable);

	@Query(nativeQuery = true, value = "select b.id as beneficiaryId, b.uid as uid, b.first_name as firstName, b.middle_name as middleName, b.last_name as lastName, b.pre_art_number as preArtNumber, b.art_number as artNumber, bg.name as gender, b.date_of_birth as dateOfBirth, mab.name as status,"
			+ "case when concat(b.first_name, ' ', b.middle_name, ' ', b.last_name) like :searchStringPos then 1"
			+ " when b.art_number like :searchStringPos then 2" + " when b.pre_art_number like :searchStringPos then 3"
			+ " when concat(b.first_name, ' ', b.middle_name, ' ', b.last_name) like :searchParamSuffix then 4"
			+ " when b.art_number like :searchParamPreffix then 5"
			+ " when b.pre_art_number like :searchParamPreffix then 6"
			+ " when concat(b.first_name, ' ', b.middle_name, ' ', b.last_name) like :searchParamPreffix then 7"
			+ " when b.art_number like :searchParamSuffix then 8"
			+ " when b.pre_art_number like :searchParamSuffix then 9"
			+ " when concat(b.first_name, ' ', b.middle_name, ' ', b.last_name) like :searchParamSuffixPreffix then 10"
			+ " when b.art_number like :searchParamSuffixPreffix then 11"
			+ " when b.pre_art_number like :searchParamSuffixPreffix then 12 "
			+ "end as rSeq from soch.art_beneficiary ab inner join soch.beneficiary b on (ab.beneficiary_id = b.id and ab.facility_id =:facilityId and ab.is_delete = false) inner join soch.master_gender bg on (b.gender_id = bg.id) inner join soch.master_art_beneficiary_status mab on (mab.id = ab.art_beneficiary_status_id) where b.is_delete = false and (lower(art_benf_search_str) like %:searchString%)", countQuery = " select count(*) from soch.beneficiary b join soch.art_beneficiary ab on ab.beneficiary_id = b.id and ab.facility_id =:facilityId and ab.is_delete = false join soch.master_gender bg on b.gender_id = bg.id join soch.master_art_beneficiary_status mab on mab.id = ab.art_beneficiary_status_id where b.is_delete=false and (lower(art_benf_search_str) like %:searchString%)")
	Page<ArtBeneficiaryListProjection> findArtBeneficiariesByPresentFacilityBasicSearch(
			@Param("facilityId") Long facilityId, @Param("searchString") String searchString, Pageable pageable,
			@Param("searchStringPos") String searchStringPos, @Param("searchParamPreffix") String searchParamPreffix,
			@Param("searchParamSuffix") String searchParamSuffix,
			@Param("searchParamSuffixPreffix") String searchParamSuffixPreffix);

	@Query(nativeQuery = true, value = "select b.id as beneficiaryId, b.uid as uid, b.first_name as firstName, b.middle_name as middleName, b.last_name as lastName, b.pre_art_number as preArtNumber, b.art_number as artNumber, bg.name as gender, b.date_of_birth as dateOfBirth, mab.name as status from soch.art_beneficiary ab inner join soch.beneficiary b on  (ab.beneficiary_id = b.id and ab.facility_id =:facilityId and ab.is_delete = false) inner join soch.master_gender bg on (b.gender_id = bg.id) inner join soch.master_art_beneficiary_status mab on (mab.id = ab.art_beneficiary_status_id) where b.is_delete=false and mobile_number = :searchString ", countQuery = " select count(*) from soch.beneficiary b join soch.art_beneficiary ab on ab.beneficiary_id = b.id and ab.facility_id =:facilityId and ab.is_delete = false join soch.master_gender bg on b.gender_id = bg.id join soch.master_art_beneficiary_status mab on mab.id = ab.art_beneficiary_status_id where b.is_delete=false and mobile_number = :searchString")
	Page<ArtBeneficiaryListProjection> findArtBeneficiariesInPresentFacilityByMobileNo(
			@Param("facilityId") Long facilityId, @Param("searchString") String searchString, Pageable pageable);

	@Query(nativeQuery = true, value = "select b.id as beneficiaryId, b.uid as uid, b.first_name as firstName, b.middle_name as middleName, b.last_name as lastName, b.pre_art_number as preArtNumber, b.art_number as artNumber, bg.name as gender, b.date_of_birth as dateOfBirth, mab.name as status from soch.art_beneficiary ab inner join soch.beneficiary b on (ab.beneficiary_id = b.id and ab.facility_id =:facilityId and ab.is_delete = false) inner join soch.master_gender bg on (b.gender_id = bg.id) inner join soch.master_art_beneficiary_status mab on (mab.id = ab.art_beneficiary_status_id) where b.is_delete=false and uid ilike concat(:searchString, '%') ", countQuery = " select count(*) from soch.beneficiary b join soch.art_beneficiary ab on ab.beneficiary_id = b.id and ab.facility_id =:facilityId and ab.is_delete = false join soch.master_gender bg on b.gender_id = bg.id join soch.master_art_beneficiary_status mab on mab.id = ab.art_beneficiary_status_id where b.is_delete=false and lower(uid) = lower(:searchString)  ")
	Page<ArtBeneficiaryListProjection> findArtBeneficiariesInPresentFacilityByUid(@Param("facilityId") Long facilityId,
			@Param("searchString") String searchString, Pageable pageable);

	@Query(nativeQuery = true, value = "select b.id as beneficiaryId, b.uid as uid, b.first_name as firstName, b.middle_name as middleName, b.last_name as lastName, b.pre_art_number as preArtNumber, b.art_number as artNumber, bg.name as gender, b.date_of_birth as dateOfBirth, mab.name as status from soch.art_beneficiary ab inner join soch.beneficiary b on (ab.beneficiary_id = b.id and ab.facility_id =:facilityId and ab.is_delete = false) inner join soch.master_gender bg on (b.gender_id = bg.id) inner join soch.master_art_beneficiary_status mab on (mab.id = ab.art_beneficiary_status_id) where b.is_delete = false and tsv_artvalues @@ to_tsquery(:searchString) ", countQuery = " select count(*) from soch.beneficiary b join soch.art_beneficiary ab on ab.beneficiary_id = b.id and ab.facility_id =:facilityId and ab.is_delete = false join soch.master_gender bg on b.gender_id = bg.id join soch.master_art_beneficiary_status mab on mab.id = ab.art_beneficiary_status_id where b.is_delete=false and tsv_artvalues @@ to_tsquery(:searchString) ")
	Page<ArtBeneficiaryListProjection> findArtBeneficiariesByPresentFacilityBasicSearchWithTsVector(
			@Param("facilityId") Long facilityId, @Param("searchString") String searchString, Pageable pageable);

	@Query(nativeQuery = true, value = "select    b.id as beneficiaryId, b.uid as uid, b.first_name as firstName,    b.middle_name as middleName, b.last_name as lastName,    b.pre_art_number as preArtNumber, b.art_number as artNumber, bg.name as gender,    b.date_of_birth as dateOfBirth,    mab.name as status,    duelst.expected_visit_date as expectedVisitDate from soch.art_beneficiary ab inner join soch.beneficiary b on (ab.beneficiary_id = b.id    and ab.facility_id = :facilityId and ab.is_delete = false) inner join soch.master_gender bg on    (b.gender_id = bg.id) inner join soch.master_art_beneficiary_status mab on    (mab.id = ab.art_beneficiary_status_id) left join (    select dp.expected_visit_date, dp.beneficiary_id from soch.art_beneficiary_due_list dp    join ( select min(expected_visit_date) as expected_visit_date, id, is_visited from soch.art_beneficiary_due_list group by expected_visit_date, id, is_visited ) dl on ( dl.id = dp.id and ( dl.is_visited = false and dl.expected_visit_date >= CURRENT_DATE ) and dp.is_delete = false ) ) duelst on    b.id = duelst.beneficiary_id where    b.is_delete = false    and exists(    select 1 from soch.art_dispensation ad where b.id = ad.beneficiary_id and ad.facility_id = :facilityId ) ", countQuery = "select count(*) from soch.beneficiary b join soch.art_beneficiary ab on ab.beneficiary_id = b.id and ab.facility_id = :facilityId and ab.is_delete = false join soch.master_gender bg on b.gender_id = bg.id join soch.master_art_beneficiary_status mab on mab.id = ab.art_beneficiary_status_id left join ( select dp.expected_visit_date, dp.beneficiary_id from soch.art_beneficiary_due_list dp join ( select min(expected_visit_date) as expected_visit_date, id, is_visited from soch.art_beneficiary_due_list group by expected_visit_date, id, is_visited ) dl on ( dl.id = dp.id and ( dl.is_visited = false and dl.expected_visit_date >= CURRENT_DATE ) and dp.is_delete = false ) ) duelst on b.id = duelst.beneficiary_id where b.is_delete = false and exists( select 1 from soch.art_dispensation ad where b.id = ad.beneficiary_id and ad.facility_id = :facilityId ) ")
	Page<ArtBeneficiaryListProjection> findDispensationHistoryByFacilityId(@Param("facilityId") Long facilityId,
			Pageable pageable);

	@Query(nativeQuery = true, value = "select b.id as beneficiaryId, b.uid as uid, b.first_name as firstName, b.middle_name as middleName, b.last_name as lastName, b.pre_art_number as preArtNumber, b.art_number as artNumber, bg.name as gender, b.date_of_birth as dateOfBirth, mab.name as status, duelst.expected_visit_date as expectedVisitDate from soch.art_beneficiary ab inner join soch.beneficiary b on (ab.beneficiary_id = b.id and ab.facility_id = :facilityId and ab.is_delete = false) inner join soch.master_gender bg on (b.gender_id = bg.id) inner join soch.master_art_beneficiary_status mab on (mab.id = ab.art_beneficiary_status_id) left join ( select dp.expected_visit_date, dp.beneficiary_id from soch.art_beneficiary_due_list dp join ( select min(expected_visit_date) as expected_visit_date, id, is_visited from soch.art_beneficiary_due_list group by expected_visit_date, id, is_visited ) dl on ( dl.id = dp.id and ( dl.is_visited = false and dl.expected_visit_date >= CURRENT_DATE ) and dp.is_delete = false ) ) duelst on b.id = duelst.beneficiary_id where b.is_delete = false and exists( select 1 from soch.art_dispensation ad where b.id = ad.beneficiary_id and ad.facility_id = :facilityId ) and b.tsv_artvalues @@ to_tsquery(:searchString) ", countQuery = "select count(*) from soch.beneficiary b join soch.art_beneficiary ab on ab.beneficiary_id = b.id and ab.facility_id = :facilityId and ab.is_delete = false join soch.master_gender bg on b.gender_id = bg.id join soch.master_art_beneficiary_status mab on mab.id = ab.art_beneficiary_status_id left join ( select dp.expected_visit_date, dp.beneficiary_id from soch.art_beneficiary_due_list dp join ( select min(expected_visit_date) as expected_visit_date, id, is_visited from soch.art_beneficiary_due_list group by expected_visit_date, id, is_visited ) dl on ( dl.id = dp.id and ( dl.is_visited = false and dl.expected_visit_date >= CURRENT_DATE ) and dp.is_delete = false ) ) duelst on b.id = duelst.beneficiary_id where b.is_delete = false and exists( select 1 from soch.art_dispensation ad where b.id = ad.beneficiary_id and ad.facility_id = :facilityId ) and b.tsv_artvalues @@ to_tsquery(:searchString) ")
	Page<ArtBeneficiaryListProjection> findArtBeneficiariesByDispensationHistoryWithTsVector(
			@Param("facilityId") Long facilityId, @Param("searchString") String searchString, Pageable pageable);

	@Query(nativeQuery = true, value = "select b.id as beneficiaryId,b.uid as uid,b.first_name as firstName,b.middle_name as middleName,\r\n"
			+ "b.last_name as lastName,b.pre_art_number as preArtNumber,b.art_number as artNumber,bg.name as gender,\r\n"
			+ "b.date_of_birth as dateOfBirth,mab.name as status,\r\n"
			+ "(select min(ad.expected_visit_date) as expectedVisitDate from\r\n"
			+ "soch.art_beneficiary_due_list ad where ad.beneficiary_id = b.id\r\n"
			+ "and ad.facility_id = :facilityId and date(ad.expected_visit_date)>= date(Now())\r\n"
			+ "and ad.is_visited = false and ad.is_delete = false and ad.is_active = true)\r\n"
			+ "from soch.art_beneficiary ab inner join soch.beneficiary b on\r\n"
			+ "(ab.beneficiary_id = b.id and ab.facility_id =:facilityId and ab.is_delete = false)\r\n"
			+ "inner join soch.master_gender bg on (b.gender_id = bg.id)\r\n"
			+ "inner join soch.master_art_beneficiary_status mab on \r\n"
			+ "(mab.id = ab.art_beneficiary_status_id) where\r\n"
			+ "b.is_delete = false and ab.facility_id=:facilityId and ab.is_delete=false and exists(select 1 from soch.art_dispensation ad\r\n"
			+ "where b.id = ad.beneficiary_id and ad.facility_id =:facilityId ) and (lower(b.art_benf_search_str) like %:searchString%)", countQuery = "select count(ab.id) from soch.art_beneficiary ab\r\n"
					+ "inner join soch.beneficiary b on\r\n"
					+ "(ab.beneficiary_id = b.id and ab.facility_id =:facilityId and ab.is_delete = false)\r\n"
					+ "where b.is_delete = false and ab.facility_id=:facilityId and ab.is_delete=false and exists(select 1 from soch.art_dispensation ad\r\n"
					+ "where b.id = ad.beneficiary_id and ad.facility_id =:facilityId ) and (lower(b.art_benf_search_str) like %:searchString%)")
	Page<ArtBeneficiaryListProjection> findDispensationHistoryByBasicSearch(@Param("facilityId") Long facilityId,
			@Param("searchString") String searchString, Pageable pageable);

	@Modifying
	@Query(nativeQuery = true, value = " update soch.art_beneficiary set beneficiary_stability_status_id =:stabilityStatusId where beneficiary_id in (:beneficiaryIds) "
			+ " and art_beneficiary_status_id =8 and is_active =true and is_delete =false ")
	void updateArtBeneficiaryStabilityStatusId(@Param("beneficiaryIds") Set<Long> beneficiaryIds,
			@Param("stabilityStatusId") Integer stabilityStatusId);

	@Modifying
	@Query(nativeQuery = true, value = " update soch.art_beneficiary set beneficiary_stability_status_id =:stabilityStatusId where beneficiary_id in (:beneficiaryIds) "
			+ " and is_active =true and is_delete =false ")
	void updateBeneficiaryStabilityStatusId(@Param("beneficiaryIds") Set<Long> beneficiaryIds,
			@Param("stabilityStatusId") Integer stabilityStatusId);

	//@Query(nativeQuery = true, value = "select b.id as beneficiaryId, b.uid as uid, b.first_name as firstName, b.middle_name as middleName, b.last_name as lastName, b.pre_art_number as preArtNumber, b.art_number as artNumber, bg.name as gender, b.date_of_birth as dateOfBirth, mab.name as status, duelst.expected_visit_date as expectedVisitDate from soch.art_beneficiary ab inner join soch.beneficiary b on (ab.beneficiary_id = b.id and ab.facility_id = :facilityId and ab.is_delete = false) inner join soch.master_gender bg on (b.gender_id = bg.id) inner join soch.master_art_beneficiary_status mab on (mab.id = ab.art_beneficiary_status_id) left join ( select dp.expected_visit_date, dp.beneficiary_id from soch.art_beneficiary_due_list dp join ( select min(expected_visit_date) as expected_visit_date, id, is_visited from soch.art_beneficiary_due_list group by expected_visit_date, id, is_visited ) dl on ( dl.id = dp.id and ( dl.is_visited = false and dl.expected_visit_date >= CURRENT_DATE ) and dp.is_delete = false ) ) duelst on b.id = duelst.beneficiary_id where b.is_delete = false and exists( select 1 from soch.art_dispensation ad where b.id = ad.beneficiary_id and ad.facility_id = :facilityId ) and b.mobile_number = :searchString ", countQuery = "select count(*) from soch.beneficiary b join soch.art_beneficiary ab on ab.beneficiary_id = b.id and ab.facility_id = :facilityId and ab.is_delete = false join soch.master_gender bg on b.gender_id = bg.id join soch.master_art_beneficiary_status mab on mab.id = ab.art_beneficiary_status_id left join ( select dp.expected_visit_date, dp.beneficiary_id from soch.art_beneficiary_due_list dp join ( select min(expected_visit_date) as expected_visit_date, id, is_visited from soch.art_beneficiary_due_list group by expected_visit_date, id, is_visited ) dl on ( dl.id = dp.id and ( dl.is_visited = false and dl.expected_visit_date >= CURRENT_DATE ) and dp.is_delete = false ) ) duelst on b.id = duelst.beneficiary_id where b.is_delete = false and exists( select 1 from soch.art_dispensation ad where b.id = ad.beneficiary_id and ad.facility_id = :facilityId ) and b.mobile_number = :searchString ")
	@Query(nativeQuery = true, value = "select b.id as beneficiaryId,b.uid as uid,b.first_name as firstName,b.middle_name as middleName,\r\n"
			+ "b.last_name as lastName,b.pre_art_number as preArtNumber,b.art_number as artNumber,bg.name as gender,\r\n"
			+ "b.date_of_birth as dateOfBirth,mab.name as status,\r\n"
			+ "(select min(ad.expected_visit_date) as expectedVisitDate from\r\n"
			+ "soch.art_beneficiary_due_list ad where ad.beneficiary_id = b.id\r\n"
			+ "and ad.facility_id = :facilityId and date(ad.expected_visit_date)>= date(Now())\r\n"
			+ "and ad.is_visited = false and ad.is_delete = false and ad.is_active = true)\r\n"
			+ "from soch.art_beneficiary ab inner join soch.beneficiary b on\r\n"
			+ "(ab.beneficiary_id = b.id and ab.facility_id =:facilityId and ab.is_delete = false)\r\n"
			+ "inner join soch.master_gender bg on (b.gender_id = bg.id)\r\n"
			+ "inner join soch.master_art_beneficiary_status mab on \r\n"
			+ "(mab.id = ab.art_beneficiary_status_id) where\r\n"
			+ "b.is_delete = false and ab.facility_id=:facilityId and ab.is_delete=false and exists(select 1 from soch.art_dispensation ad\r\n"
			+ "where b.id = ad.beneficiary_id and ad.facility_id =:facilityId ) and b.mobile_number like %:searchString%", countQuery = "select count(ab.id) from soch.art_beneficiary ab\r\n"
					+ "inner join soch.beneficiary b on\r\n"
					+ "(ab.beneficiary_id = b.id and ab.facility_id =:facilityId and ab.is_delete = false)\r\n"
					+ "where b.is_delete = false and ab.facility_id=:facilityId and ab.is_delete=false and exists(select 1 from soch.art_dispensation ad\r\n"
					+ "where b.id = ad.beneficiary_id and ad.facility_id =:facilityId ) and b.mobile_number like %:searchString%")
	Page<ArtBeneficiaryListProjection> findDispensationHistoryByMobileNo(@Param("facilityId") Long facilityId,
			@Param("searchString") String searchString, Pageable pageable);

	//@Query(nativeQuery = true, value = "select b.id as beneficiaryId, b.uid as uid, b.first_name as firstName, b.middle_name as middleName, b.last_name as lastName, b.pre_art_number as preArtNumber, b.art_number as artNumber, bg.name as gender, b.date_of_birth as dateOfBirth, mab.name as status, duelst.expected_visit_date as expectedVisitDate from soch.art_beneficiary ab inner join soch.beneficiary b on (ab.beneficiary_id = b.id and ab.facility_id = :facilityId and ab.is_delete = false) inner join soch.master_gender bg on (b.gender_id = bg.id) inner join soch.master_art_beneficiary_status mab on (mab.id = ab.art_beneficiary_status_id) left join ( select dp.expected_visit_date, dp.beneficiary_id from soch.art_beneficiary_due_list dp join ( select min(expected_visit_date) as expected_visit_date, id, is_visited from soch.art_beneficiary_due_list group by expected_visit_date, id, is_visited ) dl on ( dl.id = dp.id and ( dl.is_visited = false and dl.expected_visit_date >= CURRENT_DATE ) and dp.is_delete = false ) ) duelst on b.id = duelst.beneficiary_id where b.is_delete = false and exists( select 1 from soch.art_dispensation ad where b.id = ad.beneficiary_id and ad.facility_id = :facilityId ) and lower(uid) = lower(:searchString) ", countQuery = "select count(*) from soch.beneficiary b join soch.art_beneficiary ab on ab.beneficiary_id = b.id and ab.facility_id = :facilityId and ab.is_delete = false join soch.master_gender bg on b.gender_id = bg.id join soch.master_art_beneficiary_status mab on mab.id = ab.art_beneficiary_status_id left join ( select dp.expected_visit_date, dp.beneficiary_id from soch.art_beneficiary_due_list dp join ( select min(expected_visit_date) as expected_visit_date, id, is_visited from soch.art_beneficiary_due_list group by expected_visit_date, id, is_visited ) dl on ( dl.id = dp.id and ( dl.is_visited = false and dl.expected_visit_date >= CURRENT_DATE ) and dp.is_delete = false ) ) duelst on b.id = duelst.beneficiary_id where b.is_delete = false and exists( select 1 from soch.art_dispensation ad where b.id = ad.beneficiary_id and ad.facility_id = :facilityId ) and lower(uid) = lower(:searchString)  ")
	@Query(nativeQuery = true, value = "select b.id as beneficiaryId,b.uid as uid,b.first_name as firstName,b.middle_name as middleName,\r\n"
			+ "b.last_name as lastName,b.pre_art_number as preArtNumber,b.art_number as artNumber,bg.name as gender,\r\n"
			+ "b.date_of_birth as dateOfBirth,mab.name as status,\r\n"
			+ "(select min(ad.expected_visit_date) as expectedVisitDate from\r\n"
			+ "soch.art_beneficiary_due_list ad where ad.beneficiary_id = b.id\r\n"
			+ "and ad.facility_id = :facilityId and date(ad.expected_visit_date)>= date(Now())\r\n"
			+ "and ad.is_visited = false and ad.is_delete = false and ad.is_active = true)\r\n"
			+ "from soch.art_beneficiary ab inner join soch.beneficiary b on\r\n"
			+ "(ab.beneficiary_id = b.id and ab.facility_id =:facilityId and ab.is_delete = false)\r\n"
			+ "inner join soch.master_gender bg on (b.gender_id = bg.id)\r\n"
			+ "inner join soch.master_art_beneficiary_status mab on \r\n"
			+ "(mab.id = ab.art_beneficiary_status_id) where\r\n"
			+ "b.is_delete = false and ab.facility_id=:facilityId and ab.is_delete=false and exists(select 1 from soch.art_dispensation ad\r\n"
			+ "where b.id = ad.beneficiary_id and ad.facility_id =:facilityId ) and lower(uid) = lower(:searchString)", countQuery = "select count(ab.id) from soch.art_beneficiary ab\r\n"
					+ "inner join soch.beneficiary b on\r\n"
					+ "(ab.beneficiary_id = b.id and ab.facility_id =:facilityId and ab.is_delete = false)\r\n"
					+ "where b.is_delete = false and ab.facility_id=:facilityId and ab.is_delete=false and exists(select 1 from soch.art_dispensation ad\r\n"
					+ "where b.id = ad.beneficiary_id and ad.facility_id =:facilityId ) and lower(uid) = lower(:searchString)")
	Page<ArtBeneficiaryListProjection> findDispensationHistoryByUid(@Param("facilityId") Long facilityId,
			@Param("searchString") String searchString, Pageable pageable);

	@Modifying
	@Query(nativeQuery = true, value = "update soch.art_beneficiary set beneficiary_stability_status_id = 1 where art_beneficiary_status_id =1 and is_active =true and is_delete =false")
	void updateArtPreparednessCounsellingBeneficiaries();

	@Modifying
	@Query(nativeQuery = true, value = "update soch.art_beneficiary set beneficiary_stability_status_id = 1 where art_beneficiary_status_id =2 and is_active =true and is_delete =false")
	void updateMisPriorToArtInitiationBeneficiaries();

	@Modifying
	@Query(nativeQuery = true, value = "update soch.art_beneficiary set beneficiary_stability_status_id = 1 where art_beneficiary_status_id =3 and is_active =true and is_delete =false")
	void updateLfuPriorToArtInitiationBeneficiaries();

	@Query(nativeQuery = true, value = "select ab.linkage_institute_name as institutionName, mot.name as organisationType, ab.modified_time as date "
			+ "from soch.art_beneficiary as ab "
			+ "left join soch.master_organisation_type as mot on mot.id = ab.linkage_organisation_type_id "
			+ "where ab.beneficiary_id = :beneficiaryId ")
	List<WhiteCardDetailsProjection> findLinkageDetailsByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);

	@Query(nativeQuery = true, value = "select beneficiary_id from soch.art_beneficiary ab where beneficiary_id not in (select bvr.beneficiary_id from soch.beneficiary_visit_register bvr "
			+ " join soch.art_beneficiary_opportunistic_infections aboi on aboi.visit_register_id = bvr.id )")
	Set<Long> findOnArtStableNoOIBeneficiaryList();

	@Query(nativeQuery = true, value = " select ab.beneficiary_id from soch.art_beneficiary ab where ab.beneficiary_id not in( "
			+ " select distinct (bvr.beneficiary_id) " + " from soch.art_beneficiary_side_effects abse "
			+ " join soch.beneficiary_visit_register bvr on bvr.id=abse.visit_register_id "
			+ " join soch.beneficiary b on bvr.beneficiary_id =b.id) ")
	Set<Long> findOnArtStableNoSideEffectsBeneficiaryList();

	@Query(nativeQuery = true, value = " select distinct (ab.beneficiary_id) from soch.art_beneficiary ab "
			+ " where ab.infant_registered_through_eid =true and ab.is_active =true and ab.is_delete =false ")
	Set<Long> findOnArtUnStableChildrenBeneficiaryList();

	@Query(nativeQuery = true, value = " select distinct (ab.beneficiary_id) from soch.art_beneficiary ab"
			+ " where ab.hiv_risk_factor_id in (2,3,11) and ab.is_active =true and ab.is_delete =false ")
	Set<Long> findOnArtUnStableRiskFactorBeneficiaryList();

	@Query(nativeQuery = true, value = " select distinct (ab.beneficiary_id) "
			+ " from soch.art_beneficiary ab where (current_Date - ab.art_registration_date) <= :dayCount ")
	Set<Long> findOnArtUnStableNewIntiatedArtBeneficiaryList(@Param("dayCount") Integer dayCount);

	@Query(nativeQuery = true, value = "select b.id as beneficiaryId,b.uid as uid,b.first_name as firstName,b.middle_name as middleName,\r\n"
			+ "b.last_name as lastName,b.pre_art_number as preArtNumber,b.art_number as artNumber,bg.name as gender,\r\n"
			+ "b.date_of_birth as dateOfBirth,mab.name as status,\r\n"
			+ "(select min(ad.expected_visit_date) as expectedVisitDate from\r\n"
			+ "soch.art_beneficiary_due_list ad where ad.beneficiary_id = b.id\r\n"
			+ "and ad.facility_id = :facilityId and date(ad.expected_visit_date)>= date(Now())\r\n"
			+ "and ad.is_visited = false and ad.is_delete = false and ad.is_active = true)\r\n"
			+ "from soch.art_beneficiary ab inner join soch.beneficiary b on\r\n"
			+ "(ab.beneficiary_id = b.id and ab.facility_id =:facilityId and ab.is_delete = false)\r\n"
			+ "inner join soch.master_gender bg on (b.gender_id = bg.id)\r\n"
			+ "inner join soch.master_art_beneficiary_status mab on \r\n"
			+ "(mab.id = ab.art_beneficiary_status_id) where\r\n"
			+ "b.is_delete = false and ab.facility_id=:facilityId and ab.is_delete=false and exists(select 1 from soch.art_dispensation ad\r\n"
			+ "where b.id = ad.beneficiary_id and ad.facility_id =:facilityId )", countQuery = "select count(ab.id) from soch.art_beneficiary ab\r\n"
					+ "inner join soch.beneficiary b on\r\n"
					+ "(ab.beneficiary_id = b.id and ab.facility_id =:facilityId and ab.is_delete = false)\r\n"
					+ "where b.is_delete = false and ab.facility_id=:facilityId and ab.is_delete=false and exists(select 1 from soch.art_dispensation ad\r\n"
					+ "where b.id = ad.beneficiary_id and ad.facility_id =:facilityId )")
	Page<ArtBeneficiaryListProjection> findBeneficiariesWithDispensationHistory(@Param("facilityId") Long facilityId,
			Pageable pageable);

//	@Query(nativeQuery = true, value = "select b.id as beneficiaryId, b.uid as uid, b.first_name as firstName, b.middle_name as middleName, "
//			+ "b.last_name as lastName, mg.name as gender, b.mobile_number as mobileNumber, b.date_of_birth as dateOfBirth,bfm.pre_art_number as oldPreArtNumber,bfm.art_number as oldArtNumber, b.pre_art_number as preArtNumber, b.art_number as artNumber, res1.status as status, res1.lac_linked as lacLinked, res1.is_transit as isTransit, res1.transfer_status as artTransferStatus, res1.name as transferredTo from ( select case when t1.beneficiary_id is not null then t1.beneficiary_id else t2.beneficiary_id end as beneficiary_id, case when t1.art_beneficiary_status_id is not null then t1.art_beneficiary_status_id else t2.art_beneficiary_status_id end as art_beneficiary_status_id, case when t1.is_transit is not null then t1.is_transit else t2.is_transit end as is_transit, case when t1.lac_linked is not null then t1.lac_linked else t2.lac_linked end as lac_linked,case when t1.status is not null then t1.status else t2.status end as status,case when t1.facility_id =:facilityId then null else t2.transfer_status end as transfer_status, case when t1.facility_id =:facilityId then null else t2.name end as name from ( select pa.beneficiary_id, pa.facility_id, pa.art_beneficiary_status_id as art_beneficiary_status_id, pa.lac_linked, mas.name as status, case when ( CURRENT_DATE >= pa.transit_start_date and CURRENT_DATE <= pa.transit_end_date) then true else false end as is_transit from soch.art_beneficiary pa, soch.master_art_beneficiary_status mas where pa.facility_id = :facilityId and pa.is_active = true and pa.is_delete = false and pa.art_beneficiary_status_id = mas.id) t1 full outer join ( select t.beneficiary_id, t.source_facility_id, t.transfer_status, pa1.facility_id, pa1.lac_linked, pa1.art_beneficiary_status_id, fac.name, mas.name as status, case when ( CURRENT_DATE >= pa1.transit_start_date and CURRENT_DATE <= pa1.transit_end_date ) then true else false end as is_transit from soch.transfers t inner join soch.art_beneficiary pa1 on ( t.beneficiary_id = pa1.beneficiary_id and pa1.is_delete = false) inner join soch.master_art_beneficiary_status mas on ( pa1.art_beneficiary_status_id = mas.id ) inner join soch.facility fac on (fac.id = t.destination_facility_id) where t.source_facility_id = :facilityId and t.id in ( select max(tr1.id) id from soch.transfers tr1 where tr1.source_facility_id = :facilityId group by tr1.beneficiary_id ) ) t2 on ( t1.beneficiary_id = t2.beneficiary_id ) ) res1 inner join soch.beneficiary b on (res1.beneficiary_id = b.id and b.is_delete = false) inner join soch.master_gender mg on (mg.id = b.gender_id) left join (select beneficiary_id,art_number, pre_art_number from soch.beneficiary_facility_mapping where id in ( select max(bfm1.id) id from soch.beneficiary_facility_mapping bfm1 where bfm1.facility_id =:facilityId and bfm1.is_delete = true group by bfm1.beneficiary_id ) ) bfm on (bfm.beneficiary_id = b.id)  "
//			+ "where b.is_delete=false and (lower(b.art_benf_search_str) like %:searchString%)", countQuery = " select count(*) from ( select case when t1.beneficiary_id is not null then t1.beneficiary_id else t2.beneficiary_id end as beneficiary_id, case when t1.art_beneficiary_status_id is not null then t1.art_beneficiary_status_id else t2.art_beneficiary_status_id end as art_beneficiary_status_id, case when t1.is_transit is not null then t1.is_transit else t2.is_transit end as is_transit, case when t1.lac_linked is not null then t1.lac_linked else t2.lac_linked end as lac_linked, case when t1.status is not null then t1.status else t2.status end as status, t2.transfer_status, t2.name from ( select pa.beneficiary_id, pa.facility_id, pa.art_beneficiary_status_id as art_beneficiary_status_id, pa.lac_linked, mas.name as status, case when ( CURRENT_DATE >= pa.transit_start_date and CURRENT_DATE <= pa.transit_end_date) then true else false end as is_transit from soch.art_beneficiary pa, soch.master_art_beneficiary_status mas where pa.facility_id = :facilityId and pa.is_active = true and pa.is_delete = false and pa.art_beneficiary_status_id = mas.id) t1 full outer join ( select t.beneficiary_id, t.source_facility_id, t.transfer_status, pa1.facility_id, pa1.lac_linked, pa1.art_beneficiary_status_id, fac.name, mas.name as status, case when ( CURRENT_DATE >= pa1.transit_start_date and CURRENT_DATE <= pa1.transit_end_date ) then true else false end as is_transit from soch.transfers t inner join soch.art_beneficiary pa1 on ( t.beneficiary_id = pa1.beneficiary_id and pa1.is_delete = false) inner join soch.master_art_beneficiary_status mas on ( pa1.art_beneficiary_status_id = mas.id ) inner join soch.facility fac on (fac.id = t.destination_facility_id) where t.source_facility_id = :facilityId and t.id in ( select max(tr1.id) id from soch.transfers tr1 where tr1.source_facility_id = :facilityId group by tr1.beneficiary_id ) ) t2 on ( t1.beneficiary_id = t2.beneficiary_id ) ) res1 inner join soch.beneficiary b on (res1.beneficiary_id = b.id and b.is_delete = false) inner join soch.master_gender mg on (mg.id = b.gender_id) where b.is_delete=false and (lower(b.art_benf_search_str) like %:searchString%)")
//	Page<ArtBeneficiaryListProjection> findArtBeneficiaryByBasicSearch(@Param("facilityId") Long facilityId,
//			@Param("searchString") String searchString, Pageable pageable);

//	@Query(nativeQuery = true, value = "select b.id as beneficiaryId, b.uid as uid, b.first_name as firstName, b.middle_name as middleName, "
//			+ "b.last_name as lastName, mg.name as gender, b.mobile_number as mobileNumber, b.date_of_birth as dateOfBirth,bfm.pre_art_number as oldPreArtNumber,bfm.art_number as oldArtNumber, b.pre_art_number as preArtNumber, b.art_number as artNumber, res1.status as status, res1.lac_linked as lacLinked, res1.is_transit as isTransit, res1.transfer_status as artTransferStatus, res1.name as transferredTo, "
//			+ "case when res1.r_nm = 0 then case when res1.r_art > 0 and res1.r_pre_art > 0 then (res1.r_art + res1.r_pre_art) when res1.r_art > 0 and res1.r_pre_art = 0 then (res1.r_art + res1.r_uid) + 50 when res1.r_pre_art > 0 then (res1.r_pre_art + res1.r_uid) + 80" + 
//			" else res1.r_uid + 120 end else res1.r_nm end as rSeq "
//			+ "from ( select case when t1.beneficiary_id is not null then t1.beneficiary_id else t2.beneficiary_id end as beneficiary_id, case when t1.art_beneficiary_status_id is not null then t1.art_beneficiary_status_id else t2.art_beneficiary_status_id end as art_beneficiary_status_id, case when t1.is_transit is not null then t1.is_transit else t2.is_transit end as is_transit, case when t1.lac_linked is not null then t1.lac_linked else t2.lac_linked end as lac_linked,case when t1.status is not null then t1.status else t2.status end as status,case when t1.facility_id =:facilityId and t2.transfer_status!='PENDING' then null else t2.transfer_status end as transfer_status, case when t1.facility_id =:facilityId and t2.transfer_status!='PENDING' then null else t2.name end as name,coalesce(strpos(b.art_number,:searchString), 0) r_art,\r\n" + 
//			" coalesce(strpos(b.pre_art_number, :searchString), 0) r_pre_art, coalesce(strpos(b.uid, :searchString), 0) r_uid, coalesce(strpos(concat(b.first_name, ' ', b.middle_name, ' ', b.last_name), :searchString), 0) r_nm from ( select pa.beneficiary_id, pa.facility_id, pa.art_beneficiary_status_id as art_beneficiary_status_id, pa.lac_linked, mas.name as status, case when ( CURRENT_DATE >= pa.transit_start_date and CURRENT_DATE <= pa.transit_end_date) then true else false end as is_transit from soch.art_beneficiary pa, soch.master_art_beneficiary_status mas where pa.facility_id = :facilityId and pa.is_active = true and pa.is_delete = false and pa.art_beneficiary_status_id = mas.id) t1 inner join soch.beneficiary b on\r\n" + 
//			"		(t1.beneficiary_id = b.id) full outer join ( select t.beneficiary_id, t.source_facility_id, t.transfer_status, pa1.facility_id, pa1.lac_linked, pa1.art_beneficiary_status_id, fac.name, mas.name as status, case when ( CURRENT_DATE >= pa1.transit_start_date and CURRENT_DATE <= pa1.transit_end_date ) then true else false end as is_transit from soch.transfers t inner join soch.art_beneficiary pa1 on ( t.beneficiary_id = pa1.beneficiary_id and pa1.is_delete = false) inner join soch.master_art_beneficiary_status mas on ( pa1.art_beneficiary_status_id = mas.id ) inner join soch.facility fac on (fac.id = t.destination_facility_id) where t.source_facility_id = :facilityId and t.id in ( select max(tr1.id) id from soch.transfers tr1 where tr1.source_facility_id = :facilityId group by tr1.beneficiary_id ) ) t2 on ( t1.beneficiary_id = t2.beneficiary_id ) ) res1 inner join soch.beneficiary b on (res1.beneficiary_id = b.id and b.is_delete = false) inner join soch.master_gender mg on (mg.id = b.gender_id) left join (select beneficiary_id,art_number, pre_art_number from soch.beneficiary_facility_mapping where id in ( select max(bfm1.id) id from soch.beneficiary_facility_mapping bfm1 where bfm1.facility_id =:facilityId and bfm1.is_delete = true group by bfm1.beneficiary_id ) ) bfm on (bfm.beneficiary_id = b.id)  "
//			+ "where b.is_delete=false and (lower(b.art_benf_search_str) like %:searchString%)", countQuery = " select count(*) from ( select case when t1.beneficiary_id is not null then t1.beneficiary_id else t2.beneficiary_id end as beneficiary_id, case when t1.art_beneficiary_status_id is not null then t1.art_beneficiary_status_id else t2.art_beneficiary_status_id end as art_beneficiary_status_id, case when t1.is_transit is not null then t1.is_transit else t2.is_transit end as is_transit, case when t1.lac_linked is not null then t1.lac_linked else t2.lac_linked end as lac_linked, case when t1.status is not null then t1.status else t2.status end as status, t2.transfer_status, t2.name from ( select pa.beneficiary_id, pa.facility_id, pa.art_beneficiary_status_id as art_beneficiary_status_id, pa.lac_linked, mas.name as status, case when ( CURRENT_DATE >= pa.transit_start_date and CURRENT_DATE <= pa.transit_end_date) then true else false end as is_transit from soch.art_beneficiary pa, soch.master_art_beneficiary_status mas where pa.facility_id = :facilityId and pa.is_active = true and pa.is_delete = false and pa.art_beneficiary_status_id = mas.id) t1 full outer join ( select t.beneficiary_id, t.source_facility_id, t.transfer_status, pa1.facility_id, pa1.lac_linked, pa1.art_beneficiary_status_id, fac.name, mas.name as status, case when ( CURRENT_DATE >= pa1.transit_start_date and CURRENT_DATE <= pa1.transit_end_date ) then true else false end as is_transit from soch.transfers t inner join soch.art_beneficiary pa1 on ( t.beneficiary_id = pa1.beneficiary_id and pa1.is_delete = false) inner join soch.master_art_beneficiary_status mas on ( pa1.art_beneficiary_status_id = mas.id ) inner join soch.facility fac on (fac.id = t.destination_facility_id) where t.source_facility_id = :facilityId and t.id in ( select max(tr1.id) id from soch.transfers tr1 where tr1.source_facility_id = :facilityId group by tr1.beneficiary_id ) ) t2 on ( t1.beneficiary_id = t2.beneficiary_id ) ) res1 inner join soch.beneficiary b on (res1.beneficiary_id = b.id and b.is_delete = false) inner join soch.master_gender mg on (mg.id = b.gender_id) where b.is_delete=false and (lower(b.art_benf_search_str) like %:searchString%)")
//	Page<ArtBeneficiaryListProjection> findArtBeneficiaryByBasicSearch(@Param("facilityId") Long facilityId,
//			@Param("searchString") String searchString, Pageable pageable,@Param("searchString") String searchString);

	@Query(nativeQuery = true, value = "select b.id as beneficiaryId, b.uid as uid, b.first_name as firstName, b.middle_name as middleName, "
			+ "b.last_name as lastName, mg.name as gender, b.mobile_number as mobileNumber, b.date_of_birth as dateOfBirth,bfm.pre_art_number as oldPreArtNumber,bfm.art_number as oldArtNumber, b.pre_art_number as preArtNumber, b.art_number as artNumber, res1.status as status, res1.lac_linked as lacLinked, res1.is_transit as isTransit, res1.transfer_status as artTransferStatus, res1.name as transferredTo, rSeq "
			+ "from (select case when t1.beneficiary_id is not null then t1.beneficiary_id else t2.beneficiary_id end as beneficiary_id, case when t1.art_beneficiary_status_id is not null then t1.art_beneficiary_status_id else t2.art_beneficiary_status_id end as art_beneficiary_status_id, case when t1.is_transit is not null then t1.is_transit else t2.is_transit end as is_transit, case when t1.lac_linked is not null then t1.lac_linked else t2.lac_linked end as lac_linked,case when t1.status is not null then t1.status else t2.status end as status,case when t1.facility_id =:facilityId and t2.transfer_status!='PENDING' then null else t2.transfer_status end as transfer_status, case when t1.facility_id =:facilityId and t2.transfer_status!='PENDING' then null else t2.name end as name,"
			+ "case when concat(b.first_name, ' ', b.middle_name, ' ', b.last_name) like :searchStringPos then 1"
			+ " when b.art_number like :searchStringPos then 2" + " when b.pre_art_number like :searchStringPos then 3"
			+ " when concat(b.first_name, ' ', b.middle_name, ' ', b.last_name) like :searchParamSuffix then 4"
			+ " when b.art_number like :searchParamPreffix then 5"
			+ " when b.pre_art_number like :searchParamPreffix then 6"
			+ " when concat(b.first_name, ' ', b.middle_name, ' ', b.last_name) like :searchParamPreffix then 7"
			+ " when b.art_number like :searchParamSuffix then 8"
			+ " when b.pre_art_number like :searchParamSuffix then 9"
			+ " when concat(b.first_name, ' ', b.middle_name, ' ', b.last_name) like :searchParamSuffixPreffix then 10"
			+ " when b.art_number like :searchParamSuffixPreffix then 11"
			+ " when b.pre_art_number like :searchParamSuffixPreffix then 12" + " else 13"
			+ " end as rSeq from ( select pa.beneficiary_id, pa.facility_id, pa.art_beneficiary_status_id as art_beneficiary_status_id, pa.lac_linked, mas.name as status, case when ( CURRENT_DATE >= pa.transit_start_date and CURRENT_DATE <= pa.transit_end_date) then true else false end as is_transit from soch.art_beneficiary pa, soch.master_art_beneficiary_status mas where pa.facility_id = :facilityId and pa.is_active = true and pa.is_delete = false and pa.art_beneficiary_status_id = mas.id) t1 inner join soch.beneficiary b on\r\n"
			+ "(t1.beneficiary_id = b.id) full outer join ( select t.beneficiary_id, t.source_facility_id, t.transfer_status, pa1.facility_id, pa1.lac_linked, pa1.art_beneficiary_status_id, fac.name, mas.name as status, case when ( CURRENT_DATE >= pa1.transit_start_date and CURRENT_DATE <= pa1.transit_end_date ) then true else false end as is_transit from soch.transfers t inner join soch.art_beneficiary pa1 on ( t.beneficiary_id = pa1.beneficiary_id and pa1.is_delete = false) inner join soch.master_art_beneficiary_status mas on ( pa1.art_beneficiary_status_id = mas.id ) inner join soch.facility fac on (fac.id = t.destination_facility_id) where t.source_facility_id = :facilityId and t.id in ( select max(tr1.id) id from soch.transfers tr1 where tr1.source_facility_id = :facilityId group by tr1.beneficiary_id ) ) t2 on ( t1.beneficiary_id = t2.beneficiary_id ) ) res1 inner join soch.beneficiary b on (res1.beneficiary_id = b.id and b.is_delete = false) inner join soch.master_gender mg on (mg.id = b.gender_id) left join (select beneficiary_id,art_number, pre_art_number from soch.beneficiary_facility_mapping where id in ( select max(bfm1.id) id from soch.beneficiary_facility_mapping bfm1 where bfm1.facility_id =:facilityId and bfm1.is_delete = true group by bfm1.beneficiary_id ) ) bfm on (bfm.beneficiary_id = b.id)  "
			+ "where b.is_delete=false and (lower(b.art_benf_search_str) like %:searchString%)", countQuery = " select count(*) from (select case when t1.beneficiary_id is not null then t1.beneficiary_id else t2.beneficiary_id end as beneficiary_id, case when t1.art_beneficiary_status_id is not null then t1.art_beneficiary_status_id else t2.art_beneficiary_status_id end as art_beneficiary_status_id, case when t1.is_transit is not null then t1.is_transit else t2.is_transit end as is_transit, case when t1.lac_linked is not null then t1.lac_linked else t2.lac_linked end as lac_linked,case when t1.status is not null then t1.status else t2.status end as status,case when t1.facility_id =:facilityId and t2.transfer_status!='PENDING' then null else t2.transfer_status end as transfer_status, case when t1.facility_id =:facilityId and t2.transfer_status!='PENDING' then null else t2.name end as name from ( select pa.beneficiary_id, pa.facility_id, pa.art_beneficiary_status_id as art_beneficiary_status_id, pa.lac_linked, mas.name as status, case when ( CURRENT_DATE >= pa.transit_start_date and CURRENT_DATE <= pa.transit_end_date) then true else false end as is_transit from soch.art_beneficiary pa, soch.master_art_beneficiary_status mas where pa.facility_id = :facilityId and pa.is_active = true and pa.is_delete = false and pa.art_beneficiary_status_id = mas.id) t1 inner join soch.beneficiary b on (t1.beneficiary_id = b.id) full outer join ( select t.beneficiary_id, t.source_facility_id, t.transfer_status, pa1.facility_id, pa1.lac_linked, pa1.art_beneficiary_status_id, fac.name, mas.name as status, case when ( CURRENT_DATE >= pa1.transit_start_date and CURRENT_DATE <= pa1.transit_end_date ) then true else false end as is_transit from soch.transfers t inner join soch.art_beneficiary pa1 on ( t.beneficiary_id = pa1.beneficiary_id and pa1.is_delete = false) inner join soch.master_art_beneficiary_status mas on ( pa1.art_beneficiary_status_id = mas.id ) inner join soch.facility fac on (fac.id = t.destination_facility_id) where t.source_facility_id = :facilityId and t.id in ( select max(tr1.id) id from soch.transfers tr1 where tr1.source_facility_id = :facilityId group by tr1.beneficiary_id ) ) t2 on ( t1.beneficiary_id = t2.beneficiary_id ) ) res1 inner join soch.beneficiary b on (res1.beneficiary_id = b.id and b.is_delete = false) inner join soch.master_gender mg on (mg.id = b.gender_id) left join (select beneficiary_id,art_number, pre_art_number from soch.beneficiary_facility_mapping where id in ( select max(bfm1.id) id from soch.beneficiary_facility_mapping bfm1 where bfm1.facility_id =:facilityId and bfm1.is_delete = true group by bfm1.beneficiary_id ) ) bfm on (bfm.beneficiary_id = b.id) where b.is_delete=false and (lower(b.art_benf_search_str) like %:searchString%)")
	Page<ArtBeneficiaryListProjection> findArtBeneficiaryByBasicSearch(@Param("facilityId") Long facilityId,
			@Param("searchString") String searchString, Pageable pageable,
			@Param("searchStringPos") String searchStringPos, @Param("searchParamPreffix") String searchParamPreffix,
			@Param("searchParamSuffix") String searchParamSuffix,
			@Param("searchParamSuffixPreffix") String searchParamSuffixPreffix);

	@Query(nativeQuery = true, value = "select ab.art_beneficiary_status_id from soch.art_beneficiary ab where ab.beneficiary_id =:beneficiaryId and ab.art_beneficiary_status_id !=8")
	Long findArtBeneficiaryStatusIdByBeneficiaryIdAndNotOnArtStatus(@Param("beneficiaryId") Long beneficiaryId);

	@Modifying
	@Query(nativeQuery = true, value = "update soch.art_beneficiary set art_beneficiary_status_id =8 where beneficiary_id=:beneficairyId ")
	void updateStatusToOnArtInArtBeneficary(@Param("beneficairyId") Long beneficairyId);

	/**
	 *  (select beneficiary_id,art_number, pre_art_number from soch.beneficiary_facility_mapping where id in ( select max(bfm1.id) id from soch.beneficiary_facility_mapping bfm1 where bfm1.facility_id = 231 and bfm1.is_delete = true  group by bfm1.beneficiary_id ) ) bfm on (bfm.beneficiary_id = b.id)
	 * @return
	 */
	@Query(nativeQuery = true, value = " select distinct on(b.id,b.uid,bfm.pre_art_number,bfm.art_number,mabs.name,mrf.name) b.id as beneficiaryId, " + 
			"b.uid as uid, b.first_name as firstName, b.middle_name as middleName, b.last_name as lastName,mg.name as gender, b.mobile_number as mobileNumber, " + 
			"b.date_of_birth as dateOfBirth, bfm.pre_art_number as oldPreArtNumber, bfm.art_number as oldArtNumber, b.pre_art_number as preArtNumber, " + 
			"b.art_number as artNumber, res1.status as status, res1.lac_linked as lacLinked, res1.is_transit as isTransit, " + 
			"res1.transfer_status as artTransferStatus, res1.name as transferredTo, ab.art_registration_date as artRegistrationDate, a.address_line_one as addressOne, " + 
			"a.address_line_two as addressTwo, ab.art_eligibility_date as artEligibilityDate, ab.art_start_date as artStartDate, b.alternate_phonenumber as alternatePhone, " + 
			"b.caregiver_name as caregiverName, b.caregiver_phone_number as caregiverPhone, mabs.name as beneficiaryStatus, a2.address_line_one as alternateAddressOne, " + 
			"a2.address_line_two as alternateAddressTwo, mep.name as entryPoint, b.bank_account_name as accountName, b.bank_account_number as accountNumber, " + 
			"b.bank_ifsc as bankIfsc, d.name as district, ab.infant_registered_through_eid as infantRegisteredThroughEid, " + 
			"p.pincode as pincode, mht.name as hivType, ib.pid as pid, f.name as ictcCenter, s.subdistrict_name as subdistrict , t3.town_name as town, " + 
			"abiad.tb_history as tbHistory, mfss.name as foursScreening, mis.name as iptStatus, abiad.ipt_start_date as iptStartDate, " + 
			"abiad.ipt_end_date as iptEndDate, mtts.name as tbTreatmentStatus, mtr.name as tbDiagnosis, mttt.name as tbTestingStatus, " + 
			"abiad.rif_resistance as rifResistance, abiad.nikshay_id as nikshayId, mto.name as treatmentOutcome, br.refer_date as ictcReferalDate, " + 
			"b.aadhar_number as aadharNumber, mmmd.name as mmdStatus, b.death_date as deathDate, b.death_reason as deathReason, mrf.name as typology, sri.is_beneficiary_accepted_for_sacep as sacepRefered, sri.beneficiary_sacep_visit_date as sacepReferalDate, sri.is_beneficiary_know_sacep_appointment_date as isAppointmentDateGiven, " + 
			"msrr.name as referralReason from ( select " + 
			"		case " + 
			"			when t1.beneficiary_id is not null then t1.beneficiary_id " + 
			"			else t2.beneficiary_id " + 
			"		end as beneficiary_id, " + 
			"		case " + 
			"			when t1.art_beneficiary_status_id is not null then t1.art_beneficiary_status_id " + 
			"			else t2.art_beneficiary_status_id " + 
			"		end as art_beneficiary_status_id, " + 
			"		case " + 
			"			when t1.is_transit is not null then t1.is_transit " + 
			"			else t2.is_transit " + 
			"		end as is_transit, " + 
			"		case " + 
			"			when t1.lac_linked is not null then t1.lac_linked " + 
			"			else t2.lac_linked " + 
			"		end as lac_linked, " + 
			"		case " + 
			"			when t1.status is not null then t1.status " + 
			"			else t2.status " + 
			"		end as status, t2.transfer_status, t2.name " + 
			"	from ( select pa.beneficiary_id, pa.facility_id, pa.art_beneficiary_status_id as art_beneficiary_status_id, pa.lac_linked, mas.name as status, " + 
			"			case " + 
			"				when ( CURRENT_DATE >= pa.transit_start_date and CURRENT_DATE <= pa.transit_end_date) then true " + 
			"				else false " + 
			"			end as is_transit " + 
			"		from soch.art_beneficiary pa, soch.master_art_beneficiary_status mas where pa.facility_id = :facilityId and pa.is_active = true and pa.is_delete = false and pa.art_beneficiary_status_id = mas.id) t1 " + 
			"	full outer join ( " + 
			"		select t.beneficiary_id, t.source_facility_id, t.transfer_status, pa1.facility_id, pa1.lac_linked, pa1.art_beneficiary_status_id, fac.name, mas.name as status, " + 
			"			case " + 
			"				when ( CURRENT_DATE >= pa1.transit_start_date and CURRENT_DATE <= pa1.transit_end_date ) then true " + 
			"				else false " + 
			"			end as is_transit " + 
			"		from soch.transfers t inner join soch.art_beneficiary pa1 on ( t.beneficiary_id = pa1.beneficiary_id and pa1.is_delete = false) " + 
			"		inner join soch.master_art_beneficiary_status mas on( pa1.art_beneficiary_status_id = mas.id ) " + 
			"		left join soch.facility fac on(fac.id = t.destination_facility_id) " + 
			"		where t.source_facility_id = :facilityId and t.id in ( select max(tr1.id) id from soch.transfers tr1 where tr1.source_facility_id =:facilityId group by tr1.beneficiary_id ) ) t2 on ( t1.beneficiary_id = t2.beneficiary_id ) ) res1 " + 
			"inner join soch.beneficiary b on (res1.beneficiary_id = b.id and b.is_delete = false)  " + 
			"inner join soch.master_gender mg on (mg.id = b.gender_id)  " + 
			"inner join soch.art_beneficiary ab on (ab.beneficiary_id = b.id) " + 
			"left join soch.address a on (a.id = b.address_id) " + 
			"inner join soch.master_art_beneficiary_status mabs on (mabs.id = ab.art_beneficiary_status_id) " + 
			"left join soch.address a2 on (a2.id = b.alternate_address_id) " + 
			"left join soch.master_entry_point mep on (mep.id = ab.entry_point_id) " + 
			"left join soch.district d on (d.id = a.district_id) " + 
			"left join soch.pincode p on (p.id = a.pincode_id) " + 
			"left join soch.master_hiv_type mht on (mht.id = b.hiv_type_id) " + 
			"left join soch.ictc_beneficiary ib on (ib.beneficiary_id = b.id) " + 
			"left join soch.facility f on (f.id = ib.facility_id) " + 
			"left join soch.subdistrict s on (s.subdistrict_id = a.subdistrict_id) " + 
			"left join soch.town t3 on (t3.town_id = a.town_id) " + 
			"left join (select * from soch.art_beneficiary_ipt_att_details where  id in(select max(id) from soch.art_beneficiary_ipt_att_details where facility_id=:facilityId group by beneficiary_id)) as abiad on (abiad.beneficiary_id = b.id) " + 
			"left join soch.master_four_s_screening mfss on (mfss.id = abiad.four_s_screening_id) " + 
			"left join soch.master_ipt_status mis on (mis.id = abiad.ipt_status_id) " + 
			"left join soch.master_tb_treatment_status mtts on (mtts.id = abiad.tb_treatment_status_id) " + 
			"left join soch.master_tb_result mtr on (mtr.id = abiad.tb_diagnosis_id) " + 
			"left join soch.master_tb_test_type mttt on (mttt.id = abiad.tb_test_type_id) " + 
			"left join soch.master_treatment_outcome mto on (mto.id = abiad.treatment_outcome_id) " + 
			"left join soch.beneficiary_referral br on (br.beneficiary_id = b.id) " + 
			"left join soch.master_multi_month_dispensation mmmd on (mmmd.id = ab.multi_month_dispensation_id) " + 
			"left join soch.master_risk_factor mrf on (mrf.id = ab.hiv_risk_factor_id) " + 
			"left join soch.sacep_referral_information sri on (sri.beneficiary_referral_id = br.id) " + 
			"left join soch.master_sacep_referral_reason msrr on (msrr.id = sri.SACEP_referral_reason_id) " + 
			"left join  (select beneficiary_id,art_number, pre_art_number from soch.beneficiary_facility_mapping where id in ( select max(bfm1.id) id from soch.beneficiary_facility_mapping bfm1 where bfm1.facility_id = :facilityId and bfm1.is_delete = true  group by bfm1.beneficiary_id ) ) bfm on (bfm.beneficiary_id = b.id) ")
	Page<ArtBeneficiaryExcelProjection> getArtBeneficiariesListForExcelDownload(@Param("facilityId") Long facilityId,
			Pageable pageable);

	/**
	 * @param searchValue
	 * @return
	 */
	@Query(nativeQuery = true, value = " select distinct on(b.id,b.uid,bfm.pre_art_number,bfm.art_number,mabs.name,mrf.name) b.id as beneficiaryId, " + 
			"b.uid as uid, b.first_name as firstName, b.middle_name as middleName, b.last_name as lastName,mg.name as gender, b.mobile_number as mobileNumber, " + 
			"b.date_of_birth as dateOfBirth, bfm.pre_art_number as oldPreArtNumber, bfm.art_number as oldArtNumber, b.pre_art_number as preArtNumber, " + 
			"b.art_number as artNumber, res1.status as status, res1.lac_linked as lacLinked, res1.is_transit as isTransit, " + 
			"res1.transfer_status as artTransferStatus, res1.name as transferredTo, ab.art_registration_date as artRegistrationDate, a.address_line_one as addressOne, " + 
			"a.address_line_two as addressTwo, ab.art_eligibility_date as artEligibilityDate, ab.art_start_date as artStartDate, b.alternate_phonenumber as alternatePhone, " + 
			"b.caregiver_name as caregiverName, b.caregiver_phone_number as caregiverPhone, mabs.name as beneficiaryStatus, a2.address_line_one as alternateAddressOne, " + 
			"a2.address_line_two as alternateAddressTwo, mep.name as entryPoint, b.bank_account_name as accountName, b.bank_account_number as accountNumber, " + 
			"b.bank_ifsc as bankIfsc, d.name as district, ab.infant_registered_through_eid as infantRegisteredThroughEid, " + 
			"p.pincode as pincode, mht.name as hivType, ib.pid as pid, f.name as ictcCenter, s.subdistrict_name as subdistrict , t3.town_name as town, " + 
			"abiad.tb_history as tbHistory, mfss.name as foursScreening, mis.name as iptStatus, abiad.ipt_start_date as iptStartDate, " + 
			"abiad.ipt_end_date as iptEndDate, mtts.name as tbTreatmentStatus, mtr.name as tbDiagnosis, mttt.name as tbTestingStatus, " + 
			"abiad.rif_resistance as rifResistance, abiad.nikshay_id as nikshayId, mto.name as treatmentOutcome, br.refer_date as ictcReferalDate, " + 
			"b.aadhar_number as aadharNumber, mmmd.name as mmdStatus, b.death_date as deathDate, b.death_reason as deathReason, mrf.name as typology, sri.is_beneficiary_accepted_for_sacep as sacepRefered, sri.beneficiary_sacep_visit_date as sacepReferalDate, sri.is_beneficiary_know_sacep_appointment_date as isAppointmentDateGiven, " + 
			"msrr.name as referralReason from ( select " + 
			"		case " + 
			"			when t1.beneficiary_id is not null then t1.beneficiary_id " + 
			"			else t2.beneficiary_id " + 
			"		end as beneficiary_id, " + 
			"		case " + 
			"			when t1.art_beneficiary_status_id is not null then t1.art_beneficiary_status_id " + 
			"			else t2.art_beneficiary_status_id " + 
			"		end as art_beneficiary_status_id, " + 
			"		case " + 
			"			when t1.is_transit is not null then t1.is_transit " + 
			"			else t2.is_transit " + 
			"		end as is_transit, " + 
			"		case " + 
			"			when t1.lac_linked is not null then t1.lac_linked " + 
			"			else t2.lac_linked " + 
			"		end as lac_linked, " + 
			"		case " + 
			"			when t1.status is not null then t1.status " + 
			"			else t2.status " + 
			"		end as status, t2.transfer_status, t2.name " + 
			"	from ( select pa.beneficiary_id, pa.facility_id, pa.art_beneficiary_status_id as art_beneficiary_status_id, pa.lac_linked, mas.name as status, " + 
			"			case " + 
			"				when ( CURRENT_DATE >= pa.transit_start_date and CURRENT_DATE <= pa.transit_end_date) then true " + 
			"				else false " + 
			"			end as is_transit " + 
			"		from soch.art_beneficiary pa, soch.master_art_beneficiary_status mas where pa.facility_id = :facilityId and pa.is_active = true and pa.is_delete = false and pa.art_beneficiary_status_id = mas.id) t1 " + 
			"	full outer join ( " + 
			"		select t.beneficiary_id, t.source_facility_id, t.transfer_status, pa1.facility_id, pa1.lac_linked, pa1.art_beneficiary_status_id, fac.name, mas.name as status, " + 
			"			case " + 
			"				when ( CURRENT_DATE >= pa1.transit_start_date and CURRENT_DATE <= pa1.transit_end_date ) then true " + 
			"				else false " + 
			"			end as is_transit " + 
			"		from soch.transfers t inner join soch.art_beneficiary pa1 on ( t.beneficiary_id = pa1.beneficiary_id and pa1.is_delete = false) " + 
			"		inner join soch.master_art_beneficiary_status mas on( pa1.art_beneficiary_status_id = mas.id ) " + 
			"		left join soch.facility fac on(fac.id = t.destination_facility_id) " + 
			"		where t.source_facility_id = :facilityId and t.id in ( select max(tr1.id) id from soch.transfers tr1 where tr1.source_facility_id =:facilityId group by tr1.beneficiary_id ) ) t2 on ( t1.beneficiary_id = t2.beneficiary_id ) ) res1 " + 
			"inner join soch.beneficiary b on (res1.beneficiary_id = b.id and b.is_delete = false)  " + 
			"inner join soch.master_gender mg on (mg.id = b.gender_id)  " + 
			"inner join soch.art_beneficiary ab on (ab.beneficiary_id = b.id) " + 
			"left join soch.address a on (a.id = b.address_id) " + 
			"inner join soch.master_art_beneficiary_status mabs on (mabs.id = ab.art_beneficiary_status_id) " + 
			"left join soch.address a2 on (a2.id = b.alternate_address_id) " + 
			"left join soch.master_entry_point mep on (mep.id = ab.entry_point_id) " + 
			"left join soch.district d on (d.id = a.district_id) " + 
			"left join soch.pincode p on (p.id = a.pincode_id) " + 
			"left join soch.master_hiv_type mht on (mht.id = b.hiv_type_id) " + 
			"left join soch.ictc_beneficiary ib on (ib.beneficiary_id = b.id) " + 
			"left join soch.facility f on (f.id = ib.facility_id) " + 
			"left join soch.subdistrict s on (s.subdistrict_id = a.subdistrict_id) " + 
			"left join soch.town t3 on (t3.town_id = a.town_id) " + 
			"left join (select * from soch.art_beneficiary_ipt_att_details where  id in(select max(id) from soch.art_beneficiary_ipt_att_details where facility_id=:facilityId group by beneficiary_id)) as abiad on (abiad.beneficiary_id = b.id) " + 
			"left join soch.master_four_s_screening mfss on (mfss.id = abiad.four_s_screening_id) " + 
			"left join soch.master_ipt_status mis on (mis.id = abiad.ipt_status_id) " + 
			"left join soch.master_tb_treatment_status mtts on (mtts.id = abiad.tb_treatment_status_id) " + 
			"left join soch.master_tb_result mtr on (mtr.id = abiad.tb_diagnosis_id) " + 
			"left join soch.master_tb_test_type mttt on (mttt.id = abiad.tb_test_type_id) " + 
			"left join soch.master_treatment_outcome mto on (mto.id = abiad.treatment_outcome_id) " + 
			"left join soch.beneficiary_referral br on (br.beneficiary_id = b.id) " + 
			"left join soch.master_multi_month_dispensation mmmd on (mmmd.id = ab.multi_month_dispensation_id) " + 
			"left join soch.master_risk_factor mrf on (mrf.id = ab.hiv_risk_factor_id) " + 
			"left join soch.sacep_referral_information sri on (sri.beneficiary_referral_id = br.id) " + 
			"left join soch.master_sacep_referral_reason msrr on (msrr.id = sri.SACEP_referral_reason_id) " + 
			"left join (select beneficiary_id,art_number, pre_art_number from soch.beneficiary_facility_mapping where id in ( select max(bfm1.id) id from soch.beneficiary_facility_mapping bfm1 where bfm1.facility_id = :facilityId and bfm1.is_delete = true  group by bfm1.beneficiary_id ) ) bfm on (bfm.beneficiary_id = b.id) "+
			"where (lower(b.art_benf_search_str) like %:searchValue% )")
	Page<ArtBeneficiaryExcelProjection> getArtBeneficiariesListForExcelDownload(@Param("facilityId") Long facilityId,
			Pageable pageable, @Param("searchValue") String searchValue);

}