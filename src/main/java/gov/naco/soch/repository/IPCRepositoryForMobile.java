package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.IPCSession;
import gov.naco.soch.projection.IPCProjectionForMobile;

@Repository
public interface IPCRepositoryForMobile extends JpaRepository<IPCSession, Long> {

	@Query(nativeQuery = true, value = "select ipc.id as id, ipc.ipc_code as ipcCode from soch.ipc_session ipc where ipc.orw_code = :orwCode and ipc.facility_id = :facilityId ")
	List<IPCProjectionForMobile> getIpcCodes(String orwCode, Long facilityId);

}
