package com.sample.bollsal.ui

import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.sample.bollsal.domain.usecase.Search
import com.sample.bollsal.entity.ResultResponse
import com.sample.bollsal.entity.SearchData
import com.sample.bollsal.hilt.AssistedViewModelFactory
import com.sample.bollsal.hilt.hiltMavericksViewModelFactory
import dagger.Binds
import dagger.Provides
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 *
 * @AssistedInject
 *
 * @Assisted 의존성그래프에 추가되어 있지 않음 - 동적으로 값이 변동될수 있음
 * 그외 - 의존성 그래프에 추가되어 변동이 없음
 */
class SearchViewModel @AssistedInject constructor(
  @Assisted state: SearchState,
  private val search: Search
) : MavericksViewModel<SearchState>(state) {

  @AssistedFactory
  interface Factory : AssistedViewModelFactory<SearchViewModel, SearchState>

  companion object : MavericksViewModelFactory<SearchViewModel, SearchState> by hiltMavericksViewModelFactory()

  fun search() {
    withState {
      /** 중복로딩을 막을수도 있음.*/
//      if (it.response is Loading) {
//        return@withState
//      }

      suspend {
        // repository Call API
        //ResultResponse(listOf())
        search.excute(SearchData("keyword", 0))
      }.execute { copy(response = it) }
    }
  }
}
