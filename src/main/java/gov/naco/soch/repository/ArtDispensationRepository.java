package gov.naco.soch.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ArtDispensation;
import gov.naco.soch.projection.ArtBeneficiaryDispensationProjection;
import gov.naco.soch.projection.ArtDispensationItemProjection;
import gov.naco.soch.projection.ArtDispensationProjection;
import gov.naco.soch.projection.ArtTransitDispensationProjection;

@Repository
public interface ArtDispensationRepository extends JpaRepository<ArtDispensation, Long>, CustomRepository {

	@Query(nativeQuery = true, value = "SELECT * FROM soch.art_dispensation where beneficiary_id =:beneficiaryId"
			+ " ORDER BY created_time DESC LIMIT 3")
	List<ArtDispensation> findByLastDispensationdetails(@Param("beneficiaryId") Long beneficiaryId);

	/*@Query(nativeQuery = true, value = "select b.id as beneficiaryId,b.uid as uid,b.first_name as firstName,b.middle_name as middleName,b.last_name as lastName,\r\n"
			+ "b.pre_art_number as preArtNumber,b.art_number as artNumber,b.date_of_birth as dateOfBirth,ad.id as id,\r\n"
			+ "ad.is_transit as isTransit,ad.dispense_date as dispenseDate,bvr.visit_by as proxy,mg.name as gender,ad.modified_time as modifiedTime,\r\n"
			+ "(select ad.expected_visit_date as nextAppointmentDate from soch.art_beneficiary_due_list ad where ad.beneficiary_id=b.id\r\n"
			+ "and ad.facility_id=:facilityId and date(ad.expected_visit_date)>=date(Now()) and ad.is_visited =false and ad.is_delete=false  and ad.is_active=true \r\n"
			+ "and ad.entry_user=:userId order by ad.id desc limit 1)\r\n"
			+ "from soch.art_dispensation ad join soch.beneficiary_visit_register bvr\r\n"
			+ "on(ad.visit_register_id=bvr.id)join soch.beneficiary b\r\n"
			+ "on(ad.beneficiary_id=b.id) join soch.master_gender mg on (mg.id=b.gender_id)"
			+ "where ad.facility_id=:facilityId and ad.dispense_date=:date")*/
	@Query(nativeQuery = true, value = "select b.id as beneficiaryId,b.uid as uid,b.first_name as firstName,b.middle_name as middleName,b.last_name as lastName,\r\n"
			+ "b.pre_art_number as preArtNumber,b.art_number as artNumber,b.date_of_birth as dateOfBirth,ad.id as id,\r\n"
			+ "ad.is_transit as isTransit,ad.dispense_date as dispenseDate,bvr.visit_by as proxy,mg.name as gender,ad.modified_time as modifiedTime,\r\n"
			+ "(select ad.expected_visit_date as nextAppointmentDate from\r\n"
			+ "soch.art_beneficiary_due_list ad where ad.beneficiary_id = b.id\r\n"
			+ "and ad.facility_id = :facilityId and date(ad.expected_visit_date)>= date(Now())\r\n"
			+ "and ad.is_visited = false and ad.is_delete = false and ad.is_active = true order by ad.id desc limit 1)\r\n"
			+ "from soch.art_dispensation ad join soch.beneficiary_visit_register bvr\r\n"
			+ "on(ad.visit_register_id=bvr.id) join soch.beneficiary b\r\n"
			+ "on(ad.beneficiary_id=b.id) join soch.master_gender mg on (mg.id=b.gender_id)"
			+ "where ad.facility_id=:facilityId and ad.dispense_date=:dispenseDate")
	List<ArtDispensationProjection> findAllByFacility_IdAndDispenseDate(@Param("facilityId") Long facilityId,
			@Param("dispenseDate") LocalDate dispenseDate);

	@Query(nativeQuery = true, value = "SELECT * FROM soch.art_dispensation as a where a.beneficiary_id =:beneficiaryId"
			+ " ORDER BY a.id DESC LIMIT 1")
	ArtDispensation findByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);

	@Query(nativeQuery = true, value = " select t.beneficiary_id from soch.art_dispensation ad2 inner join"
			+ " ( select ad.beneficiary_id ,min(ad.dispense_date) as dispense_date from soch.art_dispensation ad group by ad.beneficiary_id )  as t on "
			+ " ad2.beneficiary_id =t.beneficiary_id and ad2.dispense_date =t.dispense_date "
			+ " where (current_date - t.dispense_date) >= :dayCount ")
	Set<Long> findOnArtStableBeneficiaryList(@Param("dayCount") Integer dayCount);

	/**
	 * @param facilityId
	 * @param startDate
	 * @param endDate
	 * @param pageable
	 * @return
	 */
	@Query(nativeQuery = true, value = "select b.id as beneficiaryId,b.uid as uid,b.first_name as firstName,b.middle_name as middleName,b.last_name as lastName, "
			+ "b.pre_art_number as preArtNumber,b.art_number as artNumber,b.date_of_birth as dateOfBirth,ad.id as id, "
			+ "ad.dispense_date as dispenseDate,bvr.visit_by as proxy,mg.name as gender,abdl.expected_visit_date as nextAppointmentDate from soch.beneficiary b inner join soch.master_gender mg on mg.id=b.gender_id inner join "
			+ "soch.art_beneficiary_due_list abdl on abdl.beneficiary_id = b.id inner join soch.art_dispensation ad on  ad.art_beneficiary_due_list_id =abdl.id inner join soch.beneficiary_visit_register bvr "
			+ "on bvr.id = ad.visit_register_id where ad.is_transit = true and ad.facility_id =:facilityId and (ad.dispense_date >= :startDate and ad.dispense_date <= :endDate) "
			+ "and ad.is_active = true and ad.is_delete = false and abdl.facility_id =:facilityId and abdl.is_visited = false and abdl.is_delete = false and abdl.is_active = true ")
	Page<ArtTransitDispensationProjection> getTransitDispensationDetails(@Param("facilityId") Long facilityId,
			@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate, Pageable pageable);

	@Query(nativeQuery = true, value = "select b.id as beneficiaryId,ad.id as artDispensationId,ab.id as artBeneficiaryId,b.first_name as firstName,b.last_name as lastName,\r\n"
			+ "b.uid as uid,b.art_number as artNumber,b.pre_art_number as preArtNumber,\r\n"
			+ "b.date_of_birth as dateOfBirth,g.name as gender,\r\n"
			+ "ad.dispense_date as dispensationDate,bv.id as visitId,bv.visit_by as visitBy,p.id as productId,p.product_name as productName,\r\n"
			+ "adt.dispense_quantity as dispenseQuantity,\r\n"
			+ "(select expected_visit_date as nextAppDate from soch.art_beneficiary_due_list \r\n"
			+ "where id in(select max(abdl.id) from soch.art_beneficiary_due_list abdl\r\n"
			+ "where abdl.visit_register_id=bv.id))\r\n"
			+ "from soch.art_dispensation ad join soch.art_dispensation_item adt\r\n"
			+ "on(adt.art_dispensation_id=ad.id) left join soch.product p on(adt.product_id=p.id)\r\n"
			+ "left join soch.beneficiary_visit_register bv\r\n"
			+ "on(ad.visit_register_id=bv.id) left join soch.beneficiary b \r\n"
			+ "on(ad.beneficiary_id=b.id) left join soch.art_beneficiary ab\r\n"
			+ "on(ab.beneficiary_id=b.id) left join soch.master_gender g\r\n"
			+ "on(b.gender_id=g.id) where ad.is_transit=true and ab.is_transit=true\r\n"
			+ "and ad.facility_id!=:facilityId and ab.facility_id=:facilityId and ad.dispense_date BETWEEN :fromDate and :toDate\r\n"
			+ " order by ad.dispense_date desc")
	Page<ArtBeneficiaryDispensationProjection> findOtherFacilityTransitDispensationList(
			@Param("facilityId") Long facilityId, @Param("fromDate") LocalDate fromDate,
			@Param("toDate") LocalDate toDate, Pageable paging);

	@Query(nativeQuery = true, value = "select b.id as beneficiaryId,ad.id as artDispensationId,ab.id as artBeneficiaryId,b.first_name as firstName,b.last_name as lastName,\r\n"
			+ "b.uid as uid,b.art_number as artNumber,b.pre_art_number as preArtNumber,\r\n"
			+ "b.date_of_birth as dateOfBirth,g.name as gender,\r\n"
			+ "ad.dispense_date as dispensationDate,bv.id as visitId,bv.visit_by as visitBy,p.id as productId,p.product_name as productName,\r\n"
			+ "adt.dispense_quantity as dispenseQuantity,\r\n"
			+ "(select expected_visit_date as nextAppDate from soch.art_beneficiary_due_list \r\n"
			+ "where id in(select max(abdl.id) from soch.art_beneficiary_due_list abdl\r\n"
			+ "where abdl.visit_register_id=bv.id))\r\n"
			+ "from soch.art_dispensation ad join soch.art_dispensation_item adt\r\n"
			+ "on(adt.art_dispensation_id=ad.id) left join soch.product p on(adt.product_id=p.id)\r\n"
			+ "left join soch.beneficiary_visit_register bv\r\n"
			+ "on(ad.visit_register_id=bv.id) left join soch.beneficiary b \r\n"
			+ "on(ad.beneficiary_id=b.id) left join soch.art_beneficiary ab\r\n"
			+ "on(ab.beneficiary_id=b.id) left join soch.master_gender g\r\n"
			+ "on(b.gender_id=g.id) where ad.is_transit=true and ab.is_transit=true\r\n"
			+ "and ad.facility_id!=:facilityId and ab.facility_id=:facilityId and ad.dispense_date BETWEEN :fromDate and :toDate\r\n"
			+ "and (LOWER(b.uid) like :searchValue% or LOWER(b.first_name) like :searchValue% or LOWER(b.middle_name) like :searchValue% or LOWER(b.last_name) like :searchValue%\r\n"
			+ "or LOWER(b.art_number) like :searchValue% or LOWER(b.pre_art_number) like :searchValue%\r\n"
			+ "or LOWER(concat(b.first_name,coalesce(b.middle_name),b.last_name)) like :searchValue%)"
			+ "order by ad.dispense_date desc")
	Page<ArtBeneficiaryDispensationProjection> findOtherFacilityTransitDispensationListSearchByParam(
			@Valid @Param("facilityId") Long facilityId, @Param("fromDate") LocalDate fromDate,
			@Param("toDate") LocalDate toDate, @Param("searchValue") String searchValue, Pageable paging);

	@Query(nativeQuery = true, value = "select count(b.id) from soch.art_dispensation ad left join soch.beneficiary b \r\n"
			+ "on(ad.beneficiary_id=b.id) left join soch.art_beneficiary ab\r\n"
			+ "on(ab.beneficiary_id=b.id) where ad.is_transit=true and ab.is_transit=true\r\n"
			+ "and ad.facility_id!=:facilityId and ab.facility_id=:facilityId and ad.dispense_date BETWEEN :fromDate and :toDate\r\n")
	Long findCountOfOtherTransitFacilityList(@Param("facilityId") Long facilityId,
			@Param("fromDate") LocalDate fromDate, @Param("toDate") LocalDate toDate);

	@Query(nativeQuery = true, value = "select count(b.id) from soch.art_dispensation ad left join soch.beneficiary b \r\n"
			+ "on(ad.beneficiary_id=b.id) left join soch.art_beneficiary ab\r\n"
			+ "on(ab.beneficiary_id=b.id) where ad.is_transit=true and ab.is_transit=true\r\n"
			+ "and ad.facility_id!=:facilityId and ab.facility_id=:facilityId and ad.dispense_date BETWEEN :fromDate and :toDate\r\n"
			+ "and (LOWER(b.uid) like :searchValue% or LOWER(b.first_name) like :searchValue% or LOWER(b.middle_name) like :searchValue% or LOWER(b.last_name) like :searchValue%\r\n"
			+ "or LOWER(b.art_number) like :searchValue% or LOWER(b.pre_art_number) like :searchValue%\r\n"
			+ "or LOWER(concat(b.first_name,coalesce(b.middle_name),b.last_name)) like :searchValue%)")
	Long findCountOtherTransitFacilitySearch(@Param("facilityId") Long facilityId,
			@Param("fromDate") LocalDate fromDate, @Param("toDate") LocalDate toDate,
			@Param("searchValue") String searchValue);

	/**
	 * @param facilityId
	 * @param start
	 * @param end
	 * @param pageable
	 * @param searchKey
	 * @return
	 */
	@Query(nativeQuery = true, value = "select b.id as beneficiaryId,b.uid as uid,b.first_name as firstName,b.middle_name as middleName,b.last_name as lastName, "
			+ "b.pre_art_number as preArtNumber,b.art_number as artNumber,b.date_of_birth as dateOfBirth,ad.id as id, "
			+ "ad.dispense_date as dispenseDate,bvr.visit_by as proxy,mg.name as gender,abdl.expected_visit_date as nextAppointmentDate from soch.beneficiary b inner join soch.master_gender mg on mg.id=b.gender_id inner join "
			+ "soch.art_beneficiary_due_list abdl on abdl.beneficiary_id = b.id inner join soch.art_dispensation ad on  ad.art_beneficiary_due_list_id =abdl.id inner join soch.beneficiary_visit_register bvr "
			+ "on bvr.id = ad.visit_register_id where ad.is_transit = true and ad.facility_id =:facilityId and (ad.dispense_date >= :startDate and ad.dispense_date <= :endDate) "
			+ "and ad.is_active = true and ad.is_delete = false and abdl.facility_id =:facilityId and abdl.is_visited = false and abdl.is_delete = false and abdl.is_active = true and (lower(b.uid) like %:searchKey% or lower(b.art_number) like %:searchKey% "
			+ "or lower(b.pre_art_number) like %:searchKey% or lower(b.first_name) like %:searchKey% or lower(b.last_name) like %:searchKey% or "
			+ "lower(b.middle_name) like %:searchKey% or concat(lower(b.first_name), ' ',lower(b.middle_name), ' ',lower(b.last_name)) like %:searchKey% or "
			+ "concat(lower(b.first_name), ' ',lower(b.middle_name)) like %:searchKey% or concat(lower(b.first_name), ' ',lower(b.last_name)) like %:searchKey% ) ")
	Page<ArtTransitDispensationProjection> getTransitDispensationDetailsBySearch(@Param("facilityId") Long facilityId,
			@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate,
			@Param("searchKey") String searchKey, Pageable pageable);

	@Query(nativeQuery = true, value = "select b.id as beneficiaryId,b.uid as uid,b.first_name as firstName,b.middle_name as middleName,b.last_name as lastName, "
			+ "b.pre_art_number as preArtNumber,b.art_number as artNumber,b.date_of_birth as dateOfBirth,ad.id as id, "
			+ "ad.dispense_date as dispenseDate,bvr.visit_by as proxy,mg.name as gender,abdl.expected_visit_date as nextAppointmentDate from soch.beneficiary b inner join soch.master_gender mg on mg.id=b.gender_id inner join "
			+ "soch.art_beneficiary_due_list abdl on abdl.beneficiary_id = b.id inner join soch.art_dispensation ad on  ad.art_beneficiary_due_list_id =abdl.id inner join soch.beneficiary_visit_register bvr "
			+ "on bvr.id = ad.visit_register_id where ad.facility_id =:facilityId and (ad.dispense_date >= :startDate and ad.dispense_date <= :endDate) "
			+ "and ad.is_active = true and ad.is_delete = false and abdl.facility_id =:facilityId and abdl.is_visited = false and abdl.is_delete = false and abdl.is_active = true ")
	Page<ArtDispensationProjection> getArtDispensationDetails(@Param("facilityId") Long facilityId,
			@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate, Pageable pageable);

	@Query(nativeQuery = true, value = "select b.id as beneficiaryId,b.uid as uid,b.first_name as firstName,b.middle_name as middleName,b.last_name as lastName, "
			+ "b.pre_art_number as preArtNumber,b.art_number as artNumber,b.date_of_birth as dateOfBirth,ad.id as id, "
			+ "ad.dispense_date as dispenseDate,bvr.visit_by as proxy,mg.name as gender,abdl.expected_visit_date as nextAppointmentDate from soch.beneficiary b inner join soch.master_gender mg on mg.id=b.gender_id inner join "
			+ "soch.art_beneficiary_due_list abdl on abdl.beneficiary_id = b.id inner join soch.art_dispensation ad on  ad.art_beneficiary_due_list_id =abdl.id inner join soch.beneficiary_visit_register bvr "
			+ "on bvr.id = ad.visit_register_id where ad.facility_id =:facilityId and (ad.dispense_date >= :startDate and ad.dispense_date <= :endDate) "
			+ "and ad.is_active = true and ad.is_delete = false and abdl.facility_id =:facilityId and abdl.is_visited = false and abdl.is_delete = false and abdl.is_active = true and (lower(b.uid) like %:searchKey% or lower(b.art_number) like %:searchKey% "
			+ "or lower(b.pre_art_number) like %:searchKey% or lower(b.first_name) like %:searchKey% or lower(b.last_name) like %:searchKey% or "
			+ "lower(b.middle_name) like %:searchKey% or concat(lower(b.first_name), ' ',lower(b.middle_name), ' ',lower(b.last_name)) like %:searchKey% or "
			+ "concat(lower(b.first_name), ' ',lower(b.middle_name)) like %:searchKey% or concat(lower(b.first_name), ' ',lower(b.last_name)) like %:searchKey% ) ")
	Page<ArtDispensationProjection> getArtDispensationDetailsBySearch(@Param("facilityId") Long facilityId,
			@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate,
			@Param("searchKey") String searchKey, Pageable pageable);

	@Query(nativeQuery = true, value = "select bvr.visit_date as visitDate , adi.adherence_to_art as adherence , adi.dispense_quantity as dispensedQuantity," + 
			"pro.product_name as productName , pro.id as productId " + 
			"from soch.art_dispensation as ad " + 
			"join soch.beneficiary_visit_register as bvr on bvr.id = ad.visit_register_id " + 
			"join soch.art_dispensation_item as adi on adi.art_dispensation_id =ad.id " + 
			"left join soch.product as pro on pro.id = adi.product_id " + 
			"where ad.beneficiary_id =:beneficiaryId order by bvr.id asc")
	List<ArtDispensationItemProjection> findAllDispensationDetails(@Param("beneficiaryId") Long beneficiaryId);
	
	@Query(value = "SELECT a FROM ArtDispensation a LEFT JOIN FETCH a.artDispensationItems WHERE a.id=:dispensationId")
	ArtDispensation findByArtDispensationId(@Param("dispensationId") Long dispensationId);
	
	@Query(nativeQuery = true, value = "SELECT * FROM soch.art_dispensation as a where a.beneficiary_id =:beneficiaryId ")
	List<ArtDispensation> findByDispensationId(@Param("beneficiaryId") Long beneficiaryId);

}
