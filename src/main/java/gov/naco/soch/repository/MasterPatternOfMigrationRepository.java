package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterMigrationPattern;

@Repository
public interface MasterPatternOfMigrationRepository extends JpaRepository<MasterMigrationPattern, Long> {

	List<MasterMigrationPattern> findByIsDelete(Boolean isDelete);

}