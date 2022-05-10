package com.example.saryandroidchallenge.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.saryandroidchallenge.R


class BannerPageAdapter(
    private val context: Context,
    private val banners: List<Int>
) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val view =
            LayoutInflater.from(context).inflate(R.layout.banner_item_layout, container, false)

        val banner = view.findViewById<AppCompatImageView>(R.id.iv_banner)
        banner.setImageResource(banners[position])
        val vp = container as ViewPager
        vp.addView(view, 0)
        return view
    }

    override fun getCount(): Int = banners.size

    override fun isViewFromObject(view: View, `object`: Any) = view == `object`

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

        val vp = container as ViewPager
        vp.removeView(`object` as View)
    }
}