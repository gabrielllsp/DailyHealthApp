package com.gabriel.dailyhealthapp.presenter.auth.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.gabriel.dailyhealthapp.R
import com.gabriel.dailyhealthapp.databinding.FragmentLoginBinding
import com.gabriel.dailyhealthapp.util.FirebaseHelper
import com.gabriel.dailyhealthapp.util.StateView
import com.gabriel.dailyhealthapp.util.showButtonSheet
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
    }

    private fun initListeners() {
        binding.btnForgot.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_forgotFragment)
        }
        binding.btnRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
        binding.btnLogin.setOnClickListener { validateData() }
    }

    private fun validateData() {
        val email = binding.editEmail.text.toString().trim()
        val password = binding.editPassword.text.toString().trim()

        if (email.isNotEmpty()) {
            if (password.isNotEmpty()) {
                loginUser(email, password)
            } else {
                showButtonSheet(message = getString(R.string.text_password_empty))
            }
        } else {
            showButtonSheet(message = getString(R.string.text_email_empty))
        }
    }

    private fun loginUser(email: String, password: String) {
        loginViewModel.login(email, password).observe(viewLifecycleOwner) { stateView ->
            when (stateView) {
                is StateView.Loading -> {
                    binding.progressLoading.isVisible = true
                }

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