package com.sample.bollsal.ui.navigation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.sample.bollsal.R
import com.sample.bollsal.databinding.FragmentGlobalactionBinding

class GlobalActionFragment: Fragment(R.layout.fragment_globalaction) {

  private val binding: FragmentGlobalactionBinding by viewBinding(FragmentGlobalactionBinding::bind)

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.view.setOnClickListener {
      val action = GlobalActionFragmentDirections.actionGlobalActionFragmentToSafeArgFragment(0, "key")
      findNavController().navigate(R.id.action_globalActionFragment_to_safeArgFragment)
    }
  }
}
