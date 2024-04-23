package com.gabriel.dailyhealthapp.presenter.exercise_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.gabriel.dailyhealthapp.databinding.FragmentChestBinding
import com.gabriel.dailyhealthapp.presenter.exercise_details.adapter.ExerciseAdapter
import com.gabriel.dailyhealthapp.presenter.model.Exercise
import com.gabriel.dailyhealthapp.presenter.model.ExerciseEntity


class ChestFragment : Fragment() {


    private var _binding: FragmentChestBinding? = null
    private val binding get() = _binding!!
    private val exercise = Exercise()
    private lateinit var exerciseAdapter: ExerciseAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentChestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView(exercise.items)

    }

    private fun initRecyclerView(itemList: List<ExerciseEntity>) {
        exerciseAdapter = ExerciseAdapter(itemList)

        binding.recyclerComments.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerComments.setHasFixedSize(true)
        binding.recyclerComments.adapter = exerciseAdapter
    }

}