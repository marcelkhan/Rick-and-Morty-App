package com.marcelkhan.rickandmortyapp.network

object Constants {

    const val BASE_URL = "https://rickandmortyapi.com/api/"

    // Character
    const val CHARACTER_ENDPOINT = "character"
    const val CHARACTER_ID_ENDPOINT = "character/{id}"
    const val CHARACTER_NAME_ENDPOINT = "character/?name={name}"
    const val CHARACTER_PAGE_ENDPOINT = "character/?page={page}"
    const val CHARACTER_STATUS_ENDPOINT = "character/?status={status}"

    // Location
    const val LOCATION_ENDPOINT = "location"
    const val LOCATION_ID_ENDPOINT = "location/{id}"
    const val LOCATION_NAME_ENDPOINT = "location/?name={name}"
    const val LOCATION_TYPE_ENDPOINT = "location/?type={type}"
    const val LOCATION_DIMENSION_ENDPOINT = "location/?dimension={dimension}"

    // Episode
    const val EPISODE_ENDPOINT = "episode"
    const val EPISODE_ID_ENDPOINT = "episode/{id}"
    const val EPISODE_NAME_ENDPOINT = "episode/?name={name}"
    const val EPISODE_EPISODE_ENDPOINT = "episode/?episode={episode}"
}