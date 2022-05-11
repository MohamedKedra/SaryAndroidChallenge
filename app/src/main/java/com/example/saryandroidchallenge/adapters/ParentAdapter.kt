package com.example.saryandroidchallenge.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.saryandroidchallenge.databinding.ParentItemLayoutBinding
import com.example.saryandroidchallenge.remote.models.Category

class ParentAdapter(private val context: Context) :
    RecyclerView.Adapter<ParentAdapter.ParentHolder>() {

    private var categories = ArrayList<Category>()

    inner class ParentHolder(private val binding: ParentItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            with(binding) {

                rvCategory.layoutManager = GridLayoutManager(context, 4)
                rvCategory.adapter = ChildAdapter()
            }
        }
    }

    fun setCategories(categories: ArrayList<Category>) {
        this.categories = categories
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentHolder {
        val binding = ParentItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ParentHolder(binding)
    }

    override fun onBindViewHolder(holder: ParentHolder, position: Int) {

        holder.bind()
    }

    override fun getItemCount(): Int = 4
}