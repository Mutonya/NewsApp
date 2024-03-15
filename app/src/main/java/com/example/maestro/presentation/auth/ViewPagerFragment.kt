package com.example.maestro.presentation.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.viewbinding.ViewBinding
import com.example.maestro.databinding.ViewpagerBinding

class ViewPagerFragment :BindingFragment<ViewpagerBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = ViewpagerBinding::inflate


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ViewPagerAdapter(childFragmentManager)
       binding.viewPager.adapter = adapter
    }
}