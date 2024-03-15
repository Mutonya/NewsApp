package com.example.maestro.presentation.auth

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.example.maestro.databinding.FragmentLoginBinding
import com.example.maestro.presentation.mainactivity.MainActivity
import com.example.maestro.utils.Resource
import com.example.maestro.utils.startNewActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginFragment :BindingFragment<FragmentLoginBinding>() {
    private val viewModel : AuthViewModel by viewModels()
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentLoginBinding::inflate


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.loginbutton.setOnClickListener {
            requireActivity().startNewActivity(MainActivity::class.java)

//            val email = binding.email.text.toString()
//            val password = binding.pbtext.text.toString()
//            viewModel.login(email, password)
        }
        subscribeToEvents()
    }
    private fun subscribeToEvents(){


        viewModel.loginResponse.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Failure -> {
                    Log.e("Failure", it.errorbody.toString())

                }

                Resource.Loading -> {


                }

                is Resource.Success -> {
                    Log.e("Success", it.result.currentuser.username)


                    requireActivity().startNewActivity(MainActivity::class.java)


                }
            }
        }


    }
}