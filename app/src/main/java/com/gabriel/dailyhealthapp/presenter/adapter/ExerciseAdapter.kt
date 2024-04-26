package com.gabriel.dailyhealthapp.presenter.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gabriel.dailyhealthapp.databinding.ItemExerciseBinding
import com.gabriel.dailyhealthapp.presenter.model.ExerciseEntity

class ExerciseAdapter(
    context: Context,
    private val itemList: List<ExerciseEntity>
) : RecyclerView.Adapter<ExerciseAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemExerciseBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val newItem = itemList[position]

        holder.binding.textName.text = newItem.title
        holder.binding.textDescription.text = newItem.description
        holder.binding.imageView2.setImageResource(newItem.image)

    }

    inner class MyViewHolder(val binding: ItemExerciseBinding) :
        RecyclerView.ViewHolder(binding.root)
}