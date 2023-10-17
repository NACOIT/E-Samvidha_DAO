package gov.naco.soch.projection;

import java.util.Date;

public interface MasterLineProjection {

	/*
	 * private String MllCenName; private String MllAddr; private String MllCity;
	 * private String MllDist; private String MllState; private String MllPin;
	 * private Date MllCurrDate; private String MllUid; private String MllRegNum;
	 * private String MllPatientName; private String MllPatGender; private String
	 * MllPatAge; private String MllPatMobile; private String MllCurrStatus; private
	 * String MllCurrDosage;
	 */

	/*
	 * select f.name AS MllCenName,a.address AS MllAddr,a.city as MllCity,s.name AS
	 * MllState ,d.name AS MllDist,a.pincode as MllPin,b.uid as
	 * MllUid,b.ost_code,concat(b.first_name,' ',b.last_name) as
	 * MllPatientName,b.created_time,b.gender,b.age,b.mobile_number,
	 * b.beneficiary_activity_status,bp.current_dose from soch.facility f inner join
	 * soch.address a on f.address_id = a.id inner join soch.beneficiary b on f.code
	 * = b.ost_code inner join soch.address ad on f.address_id = ad.id inner join
	 * soch.district d on a.district_id = d.id inner join soch.state s on a.state_id
	 * = s.id left outer join soch.ti_ost_details bp on bp.beneficiary_id = b.id
	 * where f.id = 1001;
	 */

	String getMllCenName();

	void setMllCenName(String mllCenName);

	String getMllAddr();

	void setMllAddr(String mllAddr);

	String getMllCity();

	void setMllCity(String mllCity);

	String getMllDist();

	void setMllDist(String mllDist);

	String getMllState();

	void setMllState(String mllState);

	String getMllPin();

	void setMllPin(String mllPin);

	Date getMllRegDate();

	void setMllRegDate(Date mllCurrDate);

	String getMllUid();

	void setMllUid(String mllUid);

	String getMllRegNum();

	void setMllRegNum(String mllRegNum);

	String getMllPatientName();

	void setMllPatientName(String mllPatientName);

	String getMllPatGender();

	void setMllPatGender(String mllPatGender);

	String getMllPatAge();

	void setMllPatAge(String mllPatAge);

	String getMllPatMobile();

	void setMllPatMobile(String mllPatMobile);

	String getMllCurrStatus();

	void setMllCurrStatus(String mllCurrStatus);

	String getMllCurrDosage();

	void setMllCurrDosage(String mllCurrDosage);

}
