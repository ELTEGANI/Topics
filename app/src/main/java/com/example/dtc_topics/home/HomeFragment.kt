package com.example.dtc_topics.home

import android.os.Bundle
import android.text.format.DateUtils
import android.text.format.DateUtils.formatDateTime
import android.text.format.Formatter
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.example.dtc_topics.R
import com.example.dtc_topics.databinding.HomeFragmentBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var homeFragmentBinding : HomeFragmentBinding
    private val homeViewModel : HomeViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        homeFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.home_fragment,container,false)
        homeFragmentBinding.webViewButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_webViewFragment)
        }

        homeFragmentBinding.downloadFileButton.setOnClickListener {
            viewLifecycleOwner.lifecycleScope.launch {
               if(homeViewModel.canAddDocument){
                 homeViewModel.downloadFileFromCloud()
               }else{
                   //request permission
               }
            }
        }

        homeViewModel.currentFileEntry.observe(viewLifecycleOwner) { fileDetails ->
            MaterialAlertDialogBuilder(requireContext())
                .setMessage("$fileDetails.filename+'\n'+$fileDetails.path")
                .setNegativeButton("Cancel") { dialog, which ->
                    // Respond to positive button press
                }
                .show()
        }

        return homeFragmentBinding.root
    }


}