package com.gabriel.dailyhealthapp.presenter.tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gabriel.dailyhealthapp.R
import com.gabriel.dailyhealthapp.databinding.FragmentHomeBinding
import com.gabriel.dailyhealthapp.presenter.adapter.CategoriesAdapter
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
        categoriesAdapter = CategoriesAdapter(requireContext(),itemList){ item, option ->
            optionSelect(item, option)
        }

        binding.recyclerComments.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerComments.setHasFixedSize(true)
        binding.recyclerComments.adapter = categoriesAdapter
    }
    private fun optionSelect(item: TrainingEntity, option: Int) {
        when(option){
            CategoriesAdapter.SELECT_NEXT -> {
                findNavController().navigate(R.id.action_tabManagerFragment_to_chestFragment)
//                Toast.makeText(requireContext(),"Next ${item.name}", Toast.LENGTH_LONG).show()
            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}