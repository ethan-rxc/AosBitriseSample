package com.sample.bollsal.hilt

import dagger.BindsInstance
import dagger.hilt.DefineComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Scope


@Scope
annotation class BollsalScope

@BollsalScope
@DefineComponent(parent = SingletonComponent::class)
interface BollsalComponent {

  @DefineComponent.Builder
  interface Builder {
    fun add(@BindsInstance data: BollsalData): BollsalComponent.Builder
    fun build(): BollsalComponent
  }
}

data class BollsalData(
  val value: Int
)
