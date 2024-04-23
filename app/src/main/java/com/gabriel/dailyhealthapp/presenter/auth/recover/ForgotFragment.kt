package com.gabriel.dailyhealthapp.presenter.auth.recover

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.gabriel.dailyhealthapp.R
import com.gabriel.dailyhealthapp.databinding.FragmentForgotBinding
import com.gabriel.dailyhealthapp.util.FirebaseHelper
import com.gabriel.dailyhealthapp.util.StateView
import com.gabriel.dailyhealthapp.util.initToolbar
import com.gabriel.dailyhealthapp.util.showButtonSheet
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForgotFragment : Fragment() {
    private var _binding: FragmentForgotBinding? = null
    private val binding get() = _binding!!

    private val forgotViewModel: ForgotViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentForgotBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(binding.toolbar)
        initListeners()
    }

    private fun initListeners() {
        binding.btnForgot.setOnClickListener { validateData() }
    }

    private fun validateData() {
        val email = binding.editEmail.text.toString().trim()

        if (email.isNotEmpty()) {
            recoverAccount(email)

        } else {
            showButtonSheet(message = getString(R.string.text_email_empty))
        }
    }

    private fun recoverAccount(email: String) {
        forgotViewModel.recover(email).observe(viewLifecycleOwner) { stateView ->
            when (stateView) {
                is StateView.Loading -> {
                    binding.progressLoading.isVisible = true
                }

                is StateView.Sucess -> {
                    binding.progressLoading.isVisible = false
                    showButtonSheet(message = getString(R.string.text_send_email_sucess_recover_fragment))
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