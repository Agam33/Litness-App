package com.org.litness.ui.exercise.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.org.litness.ui.exercise.model.Exercise
import com.org.litness.databinding.ItemExerciseBinding

class ExerciseAdapter(
  private val onItemClickListener: OnItemClickListener? = null
): ListAdapter<Exercise, ExerciseAdapter.MViewHolder>(diffUtil) {

    interface OnItemClickListener {
        fun onItemClicked(exercise: Exercise)
    }

    inner class MViewHolder(
        private val binding: ItemExerciseBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(exercise: Exercise) {
            binding.tvExerciseTitle.text = exercise.title
            binding.tvFocusArea.text = exercise.focusArea
            Glide.with(binding.root.context)
                .load(exercise.imgUrl)
                .into(binding.ivExercise)

            binding.root.setOnClickListener {
                onItemClickListener?.onItemClicked(exercise)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MViewHolder {
        return MViewHolder(
            ItemExerciseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<Exercise>() {
            override fun areItemsTheSame(oldItem: Exercise, newItem: Exercise): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Exercise, newItem: Exercise): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}