package com.gabriel.dailyhealthapp.presenter.auth.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.gabriel.dailyhealthapp.databinding.FragmentRegisterBinding
import com.gabriel.dailyhealthapp.util.initToolbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!


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
                    Toast.makeText(requireContext(), " login...", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(requireContext(), "Digite sua senha", Toast.LENGTH_SHORT)
                        .show()
                }

            } else {
                Toast.makeText(requireContext(), "Digite seu e-mail", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(requireContext(), "Digite seu nome", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}