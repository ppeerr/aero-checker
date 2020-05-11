package com.per.aero_checker.client.skyscanner.api

import com.fasterxml.jackson.annotation.JsonProperty

class PlacesResponse {
    @JsonProperty("Places")
    var places: List<Place>? = null
}
