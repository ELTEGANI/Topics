package com.example.dtc_topics.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.dtc_topics.R
import com.example.dtc_topics.databinding.HomeFragmentBinding


class HomeFragment : Fragment() {

    private lateinit var homeFragmentBinding : HomeFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        homeFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.home_fragment,container,false)
        homeFragmentBinding.webViewButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_webViewFragment)
        }
        return homeFragmentBinding.root
    }


}