package com.example.saryandroidchallenge.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.saryandroidchallenge.R
import com.example.saryandroidchallenge.remote.models.Category
import com.example.saryandroidchallenge.remote.models.Data
import de.hdodenhof.circleimageview.CircleImageView

class ChildAdapter(private var context: Context) :
    RecyclerView.Adapter<ChildAdapter.ChildHolder>() {

    lateinit var cat: Category

    inner class ChildHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val image = itemView.findViewById<CircleImageView>(R.id.ivCategory)
        private val title = itemView.findViewById<AppCompatTextView>(R.id.tvCategory)

        fun bind(data: Data) {
            Glide.with(context).load(data.image).placeholder(R.drawable.ic_place_holder).into(image)
            title.text = data.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.child_item_layout, parent, false)
        return ChildHolder(view)
    }

    override fun getItemViewType(position: Int): Int {

        return super.getItemViewType(position)
    }

    fun setCategory(cat: Category) {
        this.cat = cat
    }

    override fun onBindViewHolder(holder: ChildHolder, position: Int) {
        cat.data?.get(position)?.let {
            holder.bind(it)
        }
    }

    override fun getItemCount(): Int {
        cat.data?.size?.let { count -> return count }
        return 0
    }

}