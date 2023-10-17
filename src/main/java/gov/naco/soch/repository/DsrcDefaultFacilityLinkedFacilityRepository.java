package gov.naco.soch.repository;

import gov.naco.soch.entity.DsrcDefaultFacilityLinkedFacility;
import gov.naco.soch.projection.FacilityProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DsrcDefaultFacilityLinkedFacilityRepository extends JpaRepository<DsrcDefaultFacilityLinkedFacility, Long> {
    @Query(nativeQuery = true, value = "select * from soch.dsrc_default_facility_linked_facility where dsrc_facility_id= :dsrcFacilityId")
    List<DsrcDefaultFacilityLinkedFacility> findByDefaultFacilitiesByDsrcFacilityId(@Param("dsrcFacilityId") Long dsrcFacilityId);

    @Query(nativeQuery = true, value = "select df.default_facility_id as id , df.default_facility_name as name,df.default_facility_type_id as facilityTypeId  from soch.dsrc_default_facility_linked_facility df where df.dsrc_facility_id= :dsrcFacilityId and df.default_facility_type_id=:defaultFacilityTypeId and  df.is_deleted=false  limit 1")
    FacilityProjection findDefaultFacilityByDsrcFacilityAndFacilityTypeId(@Param("dsrcFacilityId") Long dsrcFacilityId,@Param("defaultFacilityTypeId") Long defaultFacilityTypeId);

    @Query(nativeQuery = true, value = "select df.default_facility_id as id , df.default_facility_name as name,df.default_facility_type_id as facilityTypeId  from soch.dsrc_default_facility_linked_facility df where df.dsrc_facility_id= :dsrcFacilityId  and  df.is_deleted=false ")
    List<FacilityProjection> findDefaultFacilityListByDsrcFacilityId(@Param("dsrcFacilityId") Long dsrcFacilityId);

}
