package com.example.saryandroidchallenge.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.example.saryandroidchallenge.R
import com.example.saryandroidchallenge.remote.models.Result
import com.example.saryandroidchallenge.ui.main.view.OnItemClickListener


class BannerPageAdapter(
    private val context: Context,
    private val onItemClickedListener: OnItemClickListener
) : PagerAdapter() {

    private var banners = ArrayList<Result>()

    fun setBanners(banners: ArrayList<Result>) {
        this.banners = banners
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val view =
            LayoutInflater.from(context).inflate(R.layout.banner_item_layout, container, false)
        val item = banners[position]
        val banner = view.findViewById<AppCompatImageView>(R.id.iv_banner)
        Glide.with(context).load(item.image).into(banner)
        val vp = container as ViewPager
        vp.addView(view, 0)
        view.setOnClickListener {
            onItemClickedListener.onItemClicked(item)
        }
        return view
    }

    override fun getCount(): Int = banners.size

    override fun isViewFromObject(view: View, `object`: Any) = view == `object`

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

        val vp = container as ViewPager
        vp.removeView(`object` as View)
    }
}