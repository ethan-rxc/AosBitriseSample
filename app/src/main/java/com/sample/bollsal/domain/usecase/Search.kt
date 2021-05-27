package com.sample.bollsal.domain.usecase

import com.sample.bollsal.entity.ResultResponse
import com.sample.bollsal.entity.SearchData
import javax.inject.Inject

class Search @Inject constructor(){
  fun excute(param: SearchData): ResultResponse {
    //return repository.search(param)
    return ResultResponse(listOf())
  }
}
