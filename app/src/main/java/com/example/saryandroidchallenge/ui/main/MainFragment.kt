package com.example.saryandroidchallenge.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.example.saryandroidchallenge.R
import com.example.saryandroidchallenge.adapters.BannerPageAdapter
import com.google.android.material.tabs.TabLayout

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    private lateinit var bannerSlider: ViewPager

    private lateinit var dotsLayout: TabLayout

    private var list = listOf(R.drawable.ic_launcher_foreground, androidx.appcompat.R.drawable.tooltip_frame_dark, androidx.constraintlayout.widget.R.drawable.abc_action_bar_item_background_material)

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.main_fragment, container, false)
        bannerSlider = view.findViewById(R.id.banner_slider)
        dotsLayout = view.findViewById(R.id.banner_indicator)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bannerSlider.adapter = BannerPageAdapter(requireContext(), list)

        dotsLayout.setupWithViewPager(bannerSlider)

    }

}