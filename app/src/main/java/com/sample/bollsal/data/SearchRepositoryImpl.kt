package com.sample.bollsal.data

import com.sample.bollsal.data.api.SearchService
import com.sample.bollsal.domain.interfaces.SearchRepository
import com.sample.bollsal.entity.ResultResponse
import com.sample.bollsal.entity.SearchData
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
  private val searchService: SearchService
) : SearchRepository {
  override suspend fun search(data: SearchData): ResultResponse {
    return searchService.search(data.keyword)
  }
}
