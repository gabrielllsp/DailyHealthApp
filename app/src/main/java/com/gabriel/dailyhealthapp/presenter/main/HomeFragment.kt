package com.gabriel.dailyhealthapp.presenter.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.gabriel.dailyhealthapp.databinding.FragmentHomeBinding
import com.gabriel.dailyhealthapp.presenter.exercise_details.adapter.CategoriesAdapter
import com.gabriel.dailyhealthapp.presenter.model.Training
import com.gabriel.dailyhealthapp.presenter.model.TrainingEntity


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val training = Training()

    private lateinit var categoriesAdapter: CategoriesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView(training.items)

    }

    private fun initRecyclerView(itemList: List<TrainingEntity>) {
        categoriesAdapter = CategoriesAdapter(itemList)

        binding.recyclerComments.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerComments.setHasFixedSize(true)
        binding.recyclerComments.adapter = categoriesAdapter

    }

}