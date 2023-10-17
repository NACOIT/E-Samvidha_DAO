package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.OtpEntity;


@Repository
public interface MobileOtpRepository extends JpaRepository<OtpEntity, Long>{
	@Query(nativeQuery = true, value = "select * from soch.beneficiary_mobile_login_otp where mobile_number=:mobileNumber")
	OtpEntity findByMobileNumber(@Param("mobileNumber")String mobileNumber);

	@Query(nativeQuery = true, value = "select * from soch.beneficiary_mobile_login_otp \r\n" + 
			"where id=:otpId AND otp=:otp \r\n" + 
			"AND mobile_number=:mobileNumber \r\n")// + 
			//"AND (select EXTRACT(EPOCH FROM (now()::timestamp - otp_generated_time::timestamp))) < 120")
	OtpEntity validateOtp(@Param("otpId")Long otpId, @Param("otp")String otp, @Param("mobileNumber")String mobileNumber);

	@Modifying
	@Query(nativeQuery = true, value = "update soch.beneficiary_mobile_login_otp set device_token = :fcmToken where beneficiary_id=:beneficiaryId")
	int refereshBeneficiaryDetails(@Param("beneficiaryId")Long beneficiaryId, @Param("fcmToken")String fcmToken);

}
