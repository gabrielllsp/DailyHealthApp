package com.gabriel.dailyhealthapp.presenter.tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gabriel.dailyhealthapp.R
import com.gabriel.dailyhealthapp.databinding.FragmentTabManagerBinding
import com.gabriel.dailyhealthapp.presenter.adapter.ViewPagerAdapter
import com.gabriel.dailyhealthapp.util.showButtonSheet
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.Firebase
import com.google.firebase.auth.auth


class TabManagerFragment : Fragment() {
    private var _binding: FragmentTabManagerBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentTabManagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
        initTabs()

    }

    private fun initListeners() {
        binding.btnLogout.setOnClickListener {
            val auth = Firebase.auth
            showButtonSheet(
                titleDialog = R.string.text_title_tabManger_logout_fragment,
                titleButton = R.string.text_bottom_tabManger_logout_fragment,
                message = getString(R.string.text_message_dialog_tabManger_logout_fragment),
                onClick = {
                    auth.signOut()
                    findNavController().navigate(R.id.action_tabManagerFragment_to_authentication)
                }
            )

        }
    }

    private fun initTabs() {
        val pageAdapter = ViewPagerAdapter(requireActivity())
        binding.viewPager.adapter = pageAdapter

        pageAdapter.addFragment(HomeFragment(), R.string.status_home)
        pageAdapter.addFragment(HistoricFragment(), R.string.status_historic)
        pageAdapter.addFragment(AccountFragment(), R.string.status_account)

        binding.viewPager.offscreenPageLimit = 3

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = getString(pageAdapter.getTitle(position))
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}