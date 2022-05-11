package com.example.saryandroidchallenge.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.saryandroidchallenge.databinding.ChildItemLayoutBinding

class ChildAdapter : RecyclerView.Adapter<ChildAdapter.ChildHolder>() {

    inner class ChildHolder(binding: ChildItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildHolder {
        val binding =
            ChildItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChildHolder(binding)
    }

    override fun onBindViewHolder(holder: ChildHolder, position: Int) {
    }

    override fun getItemCount(): Int = 12


}