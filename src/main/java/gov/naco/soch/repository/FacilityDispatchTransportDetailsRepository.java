package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.FacilityDispatch;
import gov.naco.soch.entity.FacilityDispatchTransportDetails;

@Repository
public interface FacilityDispatchTransportDetailsRepository
		extends JpaRepository<FacilityDispatchTransportDetails, Long>, CustomRepository {

	@Query(value = "select fd from FacilityDispatchTransportDetails fd where fd.awbNumber=:awbNum")
	FacilityDispatchTransportDetails findByAwbNumber(@Param("awbNum") String awbNum);

	FacilityDispatchTransportDetails findByFacilityDispatch_FacilityDispatchId(Long facilityDispatchId);

	@Query(nativeQuery=true,value="select fdt.awb_number from soch.facility_dispatch_transport_details fdt where\r\n"
			+ "fdt.awb_number is not null and fdt.transportation_status_id is null and fdt.is_active=true and fdt.is_delete=false")
	List<String> findAllAwbNumbers();

	@Query(nativeQuery=true,value="select count(fdt.awb_number) from soch.facility_dispatch_transport_details fdt where\r\n"
			+ "fdt.awb_number=:awbNum")
	Long findCountOfAwbNumber(@Param("awbNum") String awbNum);

}
