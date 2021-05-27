package com.sample.bollsal.data.api

import com.sample.bollsal.entity.ResultResponse
import retrofit2.http.GET

interface SearchService {
  @GET("")
  suspend fun search(keyword: String): ResultResponse
}
