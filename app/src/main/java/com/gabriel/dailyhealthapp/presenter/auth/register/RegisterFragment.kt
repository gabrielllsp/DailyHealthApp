package com.gabriel.dailyhealthapp.presenter.auth.register

import android.os.Bundle


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.gabriel.dailyhealthapp.R
import com.gabriel.dailyhealthapp.data.model.User
import com.gabriel.dailyhealthapp.databinding.FragmentRegisterBinding
import com.gabriel.dailyhealthapp.presenter.profile.ProfileViewModel
import com.gabriel.dailyhealthapp.util.FirebaseHelper
import com.gabriel.dailyhealthapp.util.StateView
import com.gabriel.dailyhealthapp.util.initToolbar
import com.gabriel.dailyhealthapp.util.showButtonSheet
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    private val registerViewModel: RegisterViewModel by viewModels()
    private val profileViewModel: ProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(binding.toolbar)
        initListeners()
    }

    private fun initListeners() {
        binding.btnRegister.setOnClickListener { validateData() }
    }

    private fun validateData() {
        val name = binding.editName.text.toString().trim()
        val email = binding.editEmail.text.toString().trim()
        val password = binding.editPassword.text.toString().trim()

        if (name.isNotEmpty()) {
            if (email.isNotEmpty()) {
                if (password.isNotEmpty()) {

                    registerUser(name, email, password)

                } else {
                    showButtonSheet(message = getString(R.string.text_password_empty))
                }

            } else {
                showButtonSheet(message = getString(R.string.text_email_empty))
            }
        } else {
            showButtonSheet(message = getString(R.string.text_name_empty))
        }
    }

    private fun registerUser(name: String, email: String, password: String) {

        registerViewModel.register(name, email, password).observe(viewLifecycleOwner) { stateView ->
            when (stateView) {
                is StateView.Loading -> {
                    binding.progressLoading.isVisible = true
                }

                is StateView.Sucess -> {
                    stateView.data?.let { saveProfile(it) }

                }

                is StateView.Error -> {
                    binding.progressLoading.isVisible = false
                    showButtonSheet(
                        message = getString(
                            FirebaseHelper.validError(
                                stateView.message ?: ""
                            )
                        )
                    )
                }
            }
        }

    }

    private fun saveProfile(user: User) {
        profileViewModel.saveProfile(user).observe(viewLifecycleOwner) { stateView ->
            when (stateView) {
                is StateView.Loading -> {}

                is StateView.Sucess -> {
                    binding.progressLoading.isVisible = false
                    findNavController().navigate(R.id.action_global_homeFragment)


                }

                is StateView.Error -> {
                    binding.progressLoading.isVisible = false
                    showButtonSheet(
                        message = getString(
                            FirebaseHelper.validError(
                                stateView.message ?: ""
                            )
                        )
                    )
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}