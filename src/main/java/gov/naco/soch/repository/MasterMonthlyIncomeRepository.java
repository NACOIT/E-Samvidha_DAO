package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterMonthlyIncome;

@Repository
public interface MasterMonthlyIncomeRepository extends JpaRepository<MasterMonthlyIncome, Long> {

	List<MasterMonthlyIncome> findByIsDelete(Boolean isDelete);

}
