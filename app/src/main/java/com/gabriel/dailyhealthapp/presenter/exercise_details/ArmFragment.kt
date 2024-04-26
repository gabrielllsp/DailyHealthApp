package com.gabriel.dailyhealthapp.presenter.exercise_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.gabriel.dailyhealthapp.databinding.FragmentArmBinding
import com.gabriel.dailyhealthapp.presenter.adapter.ArmAdapter
import com.gabriel.dailyhealthapp.presenter.model.Exercise
import com.gabriel.dailyhealthapp.presenter.model.ExerciseEntity
import com.gabriel.dailyhealthapp.util.initToolbar


class ArmFragment : Fragment() {
    private var _binding: FragmentArmBinding? = null
    private val binding get() = _binding!!
    private val exercise = Exercise()
    private lateinit var armAdapter: ArmAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentArmBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(binding.toolbar)
        initRecyclerView(exercise.itemsArm)

    }

    private fun initRecyclerView(itemList: List<ExerciseEntity>) {
        armAdapter = ArmAdapter(requireContext(), itemList)
        binding.recyclerArm.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerArm.setHasFixedSize(true)
        binding.recyclerArm.adapter = armAdapter
    }
}