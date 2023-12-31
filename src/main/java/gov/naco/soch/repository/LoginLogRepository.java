package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.LoginLog;

@Repository
public interface LoginLogRepository extends JpaRepository<LoginLog, Long> {

}
