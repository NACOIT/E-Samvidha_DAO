package gov.naco.soch.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.constants.BeneficiaryServiceQueryConstant;
import gov.naco.soch.constructordto.CalendarServiceDto;

@Repository
public class BeneficiaryCalendarRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Transactional(readOnly = true)
	public List<CalendarServiceDto> getBeneficiaryServiceData(int serviceTypeId, Long beneficiaryId, Long facilityId) {
		String sectionQuery = "";
		Map<String, Long> paramMap = new HashMap<String, Long>();
		paramMap.put("beneficiaryId", beneficiaryId);
		paramMap.put("facilityId", facilityId);
		switch (serviceTypeId) {
		case 1:
			sectionQuery = BeneficiaryServiceQueryConstant.SERVICE_ASSESSMENT_QUERY;
			break;
		case 2:
			sectionQuery = BeneficiaryServiceQueryConstant.SERVICE_COMMODITY_DISTRIBUTE_QUERY;
			break;
		case 3:
			sectionQuery = BeneficiaryServiceQueryConstant.SERVICE_COUNSELLING_QUERY;
			break;
		case 4:
			sectionQuery = BeneficiaryServiceQueryConstant.SERVICE_CLINICAL_TREAT_QUERY;
			break;
		case 5:
			sectionQuery = BeneficiaryServiceQueryConstant.SERVICE_SCREENING;
			break;
		case 6:
			sectionQuery = BeneficiaryServiceQueryConstant.SERVICE_OST_ASSESSMENT_QUERY;
			break;
		case 7:
			sectionQuery = BeneficiaryServiceQueryConstant.SERVICE_OST_FOLLOW_QUERY;
			break;
		case 8:
			sectionQuery = BeneficiaryServiceQueryConstant.SERVICE_OST_DISPENSE_QUERY;
			break;
		case 9:
			sectionQuery = BeneficiaryServiceQueryConstant.TI_REFERRAL;
			break;
		case 10:
			sectionQuery = BeneficiaryServiceQueryConstant.OST_REFERRAL;
			break;
		default:
			break;
		}
		if (sectionQuery.isEmpty()) {
			List<CalendarServiceDto> emptyList = new ArrayList<CalendarServiceDto>();
			return emptyList;
		}

		return jdbcTemplate.query(sectionQuery, paramMap, new BeneficiaryServiceRowMapper());
	}

	class BeneficiaryServiceRowMapper implements RowMapper<CalendarServiceDto> {
		@Override
		public CalendarServiceDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			CalendarServiceDto calendarServiceDto = new CalendarServiceDto();
			calendarServiceDto.setServiceTypeId(rs.getInt("servicetypeid"));
			calendarServiceDto.setDateOne(rs.getDate("dateone"));
			calendarServiceDto.setDateTwo(rs.getDate("datetwo"));
			calendarServiceDto.setDateTwoValid(rs.getBoolean("datetwovalid"));
			calendarServiceDto.setDatetwoevent(rs.getBoolean("datetwoevent"));
			calendarServiceDto.setDateThree(rs.getDate("datethree"));
			calendarServiceDto.setDatethreevent(rs.getBoolean("datethreevent"));
			calendarServiceDto.setEventdataone(rs.getString("eventdataone"));
			String eventDataThree = rs.getString("eventdatathree");
			calendarServiceDto.setEventdatatwo(rs.getString("eventdatatwo"));
			if(eventDataThree!=null) {
				if (eventDataThree.equalsIgnoreCase("Batch No :  Product Name :  Dispensed Count : ")) {
					calendarServiceDto.setEventdatathree("NA");
				} else {
					calendarServiceDto.setEventdatathree(eventDataThree);
				}
			}
			calendarServiceDto.setEventdatafour(rs.getString("eventdatafour"));
			calendarServiceDto.setEventdatafive(rs.getString("eventdatafive"));
			return calendarServiceDto;
		}
	}
}
