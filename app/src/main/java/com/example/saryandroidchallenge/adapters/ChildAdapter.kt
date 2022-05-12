package com.example.saryandroidchallenge.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.saryandroidchallenge.R
import com.example.saryandroidchallenge.databinding.AdsItemLayoutBinding
import com.example.saryandroidchallenge.databinding.GroupItemLayoutBinding
import com.example.saryandroidchallenge.databinding.SmartItemLayoutBinding
import com.example.saryandroidchallenge.remote.models.Category
import com.example.saryandroidchallenge.remote.models.Data
import com.example.saryandroidchallenge.utils.SaryDataType

class ChildAdapter(private var context: Context) :
    RecyclerView.Adapter<ChildAdapter.CustomViewHolder>() {

    private lateinit var cat: Category

    fun setCategory(cat: Category) {
        this.cat = cat
    }

    override fun getItemCount(): Int {
        cat.data?.size?.let { count -> return count }
        return 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return when (viewType) {

            SaryDataType.smart.ordinal -> {
                val b = SmartItemLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
                SmartViewHolder(b)
            }
            SaryDataType.group.ordinal -> {
                val b = GroupItemLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
                GroupViewHolder(b)
            }
            SaryDataType.banner.ordinal -> {
                val b = AdsItemLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
                AdsViewHolder(b)
            }
            else -> {
                val b = GroupItemLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
                GroupViewHolder(b)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {

        when (cat.data_type) {
            SaryDataType.smart.name -> {
                return SaryDataType.smart.ordinal
            }

            SaryDataType.group.name -> {
                return SaryDataType.group.ordinal
            }

            SaryDataType.banner.name -> {
                return SaryDataType.banner.ordinal
            }
        }

        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        cat.data?.let { items ->

            when (cat.data_type) {
                SaryDataType.smart.name -> {
                    (holder as SmartViewHolder).bind(items[position])
                }

                SaryDataType.group.name -> {
                    (holder as GroupViewHolder).bind(items[position])
                }

                SaryDataType.banner.name -> {
                    (holder as AdsViewHolder).bind(items[position])
                }
            }

        }
    }

    inner class SmartViewHolder(private var binding: SmartItemLayoutBinding) :
        CustomViewHolder(binding.root) {

        override fun bind(data: Data) {
            with(binding) {
                Glide.with(context).load(data.image)
                    .placeholder(R.drawable.ic_place_holder)
                    .error(R.drawable.ic_place_holder)
                    .into(ivSmart)
                tvSmart.text = data.name
            }
        }
    }

    inner class AdsViewHolder(private var binding: AdsItemLayoutBinding) :
        CustomViewHolder(binding.root) {

        override fun bind(data: Data) {
            with(binding) {
                Glide.with(context).load(data.image)
                    .placeholder(R.drawable.ic_place_holder)
                    .error(R.drawable.ic_place_holder)
                    .into(ivAds)
            }
        }
    }

    inner class GroupViewHolder(private var binding: GroupItemLayoutBinding) :
        CustomViewHolder(binding.root) {

        override fun bind(data: Data) {
            with(binding) {
                Glide.with(context).load(data.image)
                    .placeholder(R.drawable.ic_place_holder)
                    .error(R.drawable.ic_place_holder)
                    .into(ivGroup)
            }
        }
    }

    abstract inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(data: Data)
    }
}