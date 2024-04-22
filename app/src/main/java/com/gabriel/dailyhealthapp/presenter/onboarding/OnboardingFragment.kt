package com.gabriel.dailyhealthapp.presenter.onboarding

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gabriel.dailyhealthapp.R
import com.gabriel.dailyhealthapp.databinding.FragmentOnboardingBinding
import com.gabriel.dailyhealthapp.util.FirebaseHelper


class OnboardingFragment : Fragment() {
    private var _binding: FragmentOnboardingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed(this::verifyAuth, 1000)
    }

    private fun verifyAuth() {
        if (FirebaseHelper.isAuthenticated()){
            binding.btnStart.setOnClickListener {
                findNavController().navigate(R.id.action_onboardingFragment_to_homeFragment)
            }
        }else{
            binding.btnStart.setOnClickListener {
                findNavController().navigate(R.id.action_onboardingFragment_to_loginFragment)
            }
        }
    }

    private fun initListeners() {

    }
}