package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterHabitsSmoking;

@Repository
public interface MasterHabitsSmokingRepository extends JpaRepository<MasterHabitsSmoking, Long> {

	List<MasterHabitsSmoking> findByIsDelete(Boolean isDelete);

}