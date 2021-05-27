package com.sample.bollsal.ui.navigation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.sample.bollsal.R
import com.sample.bollsal.databinding.FragmentBollsalBinding

class BollsalFragment: Fragment(R.layout.fragment_bollsal) {
  private val binding: FragmentBollsalBinding by viewBinding(FragmentBollsalBinding::bind)

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.btn.setOnClickListener {
      findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
    }
  }
}
