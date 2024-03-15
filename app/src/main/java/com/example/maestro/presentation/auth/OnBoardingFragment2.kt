package com.example.maestro.presentation.auth

import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import com.example.maestro.databinding.OnboardingFragmentBinding

class OnBoardingFragment2:BindingFragment<OnboardingFragmentBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = OnboardingFragmentBinding::inflate
}