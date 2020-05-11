package com.per.aero_checker.client.skyscanner.api

import com.fasterxml.jackson.annotation.JsonProperty

class Place {
    @JsonProperty("PlaceId")
    var placeId: String? = null
    @JsonProperty("PlaceName")
    var placeName: String? = null
    @JsonProperty("CountryId")
    var countryId: String? = null
    @JsonProperty("RegionId")
    var regionId: String? = null
    @JsonProperty("CityId")
    var cityId: String? = null
    @JsonProperty("CountryName")
    var countryName: String? = null
}
