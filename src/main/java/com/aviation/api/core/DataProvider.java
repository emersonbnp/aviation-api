package com.aviation.api.core;

import com.aviation.api.application.provider.navigationaldata.model.AirportInfoResponse;
import java.util.List;

public interface DataProvider {

  List<AirportInfoResponse> getAirport(String ids, String bbox);
}
