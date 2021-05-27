package com.sample.bollsal.ui.navigation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.sample.bollsal.R
import com.sample.bollsal.databinding.FragmentSafeargBinding

class SafeArgFragment: Fragment(R.layout.fragment_safearg) {

  private val binding: FragmentSafeargBinding by viewBinding(FragmentSafeargBinding::bind)

//  val args by navArgs<SafeArgFragmentArgs>()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

//    Log.d("bollsal", "onViewCreated: ${args.num}   ${args.key}")
    binding.view.setOnClickListener {
      findNavController().navigate(R.id.action_global_globalActionFragment)
    }
  }
}
