package com.sample.bollsal.hilt

import com.sample.bollsal.ui.SearchViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.multibindings.IntoMap

/**
 * ViewModel이 생성될때마다 추가해주어야 함.
 */
@Module
@InstallIn(MavericksViewModelComponent::class)
interface ViewModelModule {
  @Binds
  @IntoMap
  @ViewModelKey(SearchViewModel::class)
  fun searchViewModelFactory(factory: SearchViewModel.Factory): AssistedViewModelFactory<*, *>
}
