package com.sample.bollsal.domain.interfaces

import com.sample.bollsal.entity.ResultResponse
import com.sample.bollsal.entity.SearchData

interface SearchRepository {
  suspend fun search(data: SearchData): ResultResponse
}
