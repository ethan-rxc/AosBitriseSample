package com.sample.bollsal.ui

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.Uninitialized
import com.sample.bollsal.entity.ResultResponse

enum class SearchStep {
  Init, Result
}

/**
 * immutable data class
 * the properties necessary to render your screen.
 */
data class SearchState(
  val response: Async<ResultResponse> = Uninitialized,
  val currentStep: SearchStep = SearchStep.Init
) : MavericksState
