package com.example.dtc_topics.home

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import androidx.security.crypto.MasterKeys
import com.example.dtc_topics.R
import com.example.dtc_topics.databinding.HomeFragmentBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch



private const val ENCRYPTED_PREFS_FILE_NAME = "default_prefs"

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var homeFragmentBinding : HomeFragmentBinding
    private val homeViewModel : HomeViewModel by viewModels()


    private val sharedPreferences by lazy {
        val masterKey = MasterKey.Builder(requireContext())
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()
         EncryptedSharedPreferences.create(requireContext(),
             ENCRYPTED_PREFS_FILE_NAME,
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

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

        homeFragmentBinding.tokenButton.setOnClickListener {
            sharedPreferences.edit().putString("Name","Tigani").apply()
            Toast.makeText(requireContext(), sharedPreferences.getString("Name",""),Toast.LENGTH_SHORT).show()
        }

        return homeFragmentBinding.root
    }


}