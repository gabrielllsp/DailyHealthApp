package com.gabriel.dailyhealthapp.presenter.auth.forgot

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.gabriel.dailyhealthapp.databinding.FragmentForgotBinding
import com.gabriel.dailyhealthapp.util.initToolbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForgotFragment : Fragment() {
    private var _binding: FragmentForgotBinding? = null
    private val binding get() = _binding!!


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
            Toast.makeText(requireContext(), " E-mail enviado com sucesso.", Toast.LENGTH_SHORT)
                .show()
        } else {
            Toast.makeText(requireContext(), "Digite seu e-mail", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}