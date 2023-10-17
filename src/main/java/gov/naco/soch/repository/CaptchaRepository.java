package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.Captcha;

//repository mapped with entity class Captcha
@Repository
public interface CaptchaRepository extends JpaRepository<Captcha, Long> {

	@Modifying
	@Query(nativeQuery = true, value = "delete from soch.captcha where created_time < NOW() - INTERVAL '2 DAY'")
	void deleteAllCreatedBefore2Days();
	
	@Modifying
	@Query(nativeQuery = true, value = "update soch.captcha set is_used=true, modified_time=now(),modified_by=0 where id=:captchaId")
	void updateCaptchaAsUsed(@Param("captchaId") Long captchaId);
	
}
