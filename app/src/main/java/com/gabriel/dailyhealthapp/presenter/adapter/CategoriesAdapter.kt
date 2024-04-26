package com.gabriel.dailyhealthapp.presenter.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gabriel.dailyhealthapp.databinding.TrainingItemBinding
import com.gabriel.dailyhealthapp.presenter.model.TrainingEntity


class CategoriesAdapter(
    private val context: Context,
    private val itemList: List<TrainingEntity>,
    private val itemSelected: (TrainingEntity, Int) -> Unit
) : RecyclerView.Adapter<CategoriesAdapter.MyViewHolder>() {

    companion object {
        val SELECT_NEXT: Int = 1
    }

    private fun setIndicators(item: TrainingEntity, holder: MyViewHolder){
        holder.binding.btnStart.setOnClickListener {
            itemSelected(item, SELECT_NEXT)
        }
    }

    inner class MyViewHolder(val binding: TrainingItemBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            TrainingItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = itemList.size


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val newItem = itemList[position]

        holder.binding.textName.text = newItem.name
        holder.binding.textDescription.text = newItem.description
        holder.binding.trainingImage.setImageResource(newItem.image)
        setIndicators(newItem, holder)

        }
    }