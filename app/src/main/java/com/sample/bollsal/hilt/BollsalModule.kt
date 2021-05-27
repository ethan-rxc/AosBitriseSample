package com.sample.bollsal.hilt

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class BollsalModule {

  /**
   * @Provides // 외부lib나 제어를 할수 없는 경우
   * fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)
   *
   * @Binds  // 그외 (ex: repository impl의 사용)
   * fun provideApiHelper(apiHelper: ApiHelperImpl): ApiHelper = apiHelper
   */
}
