package com.gabriel.dailyhealthapp.presenter.exercise_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.gabriel.dailyhealthapp.data.model.TrainingData
import com.gabriel.dailyhealthapp.databinding.FragmentChestBinding
import com.gabriel.dailyhealthapp.presenter.adapter.ExerciseAdapter
import com.gabriel.dailyhealthapp.presenter.model.Exercise
import com.gabriel.dailyhealthapp.presenter.model.ExerciseEntity
import com.gabriel.dailyhealthapp.util.StateView
import com.gabriel.dailyhealthapp.util.initToolbar
import com.gabriel.dailyhealthapp.util.showButtonSheet
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChestFragment : Fragment() {


    private var _binding: FragmentChestBinding? = null
    private val binding get() = _binding!!

    private val chestViewModel: ChestViewModel by viewModels()

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
        initToolbar(binding.toolbar)
        initRecyclerView(exercise.items)
        initListeners()
    }

    private fun initListeners() {

        binding.btnEnd.setOnClickListener {
            val training =
                TrainingData(name = "TREINO DE ABDÔMEM", description = "20 MIN - 16 EXERCÍCIOS")
            saveTraining(training)

        }
    }

    private fun saveTraining(training: TrainingData) {
        chestViewModel.saveTraining(training).observe(viewLifecycleOwner){stateView ->
            when(stateView){
                is StateView.Loading ->{

                }

                is StateView.Sucess ->{
                    binding.progressLoading.isVisible = true
                    Toast.makeText(requireContext(), "Sucess", Toast.LENGTH_LONG).show()
                }

                is StateView.Error ->{
                    binding.progressLoading.isVisible = false
                    showButtonSheet(message = stateView.message)
                }
            }
        }
    }


    private fun initRecyclerView(itemList: List<ExerciseEntity>) {
        exerciseAdapter = ExerciseAdapter(requireContext(), itemList)
        binding.recyclerComments.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerComments.setHasFixedSize(true)
        binding.recyclerComments.adapter = exerciseAdapter
    }

}