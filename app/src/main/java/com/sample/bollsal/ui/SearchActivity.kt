package com.sample.bollsal.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.sample.bollsal.R
import com.sample.bollsal.extension.replaceFragment
import com.sample.bollsal.hilt.BollsalComponent
import javax.inject.Inject

class SearchActivity : AppCompatActivity() {

  @Inject
  lateinit var bollsalComponent: BollsalComponent

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    //replaceFragment<SearchFragment>(R.id.fragmentContainer)
  }
}
