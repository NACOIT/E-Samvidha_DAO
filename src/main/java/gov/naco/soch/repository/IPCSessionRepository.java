package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.IPCSession;

@Repository
public interface IPCSessionRepository extends JpaRepository<IPCSession, Long>, JpaSpecificationExecutor<IPCSession> {

}

