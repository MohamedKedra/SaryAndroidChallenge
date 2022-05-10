package com.example.saryandroidchallenge.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.saryandroidchallenge.R
import com.example.saryandroidchallenge.adapters.BannerPageAdapter
import com.example.saryandroidchallenge.app.base.DataState
import com.example.saryandroidchallenge.remote.models.Result
import com.example.saryandroidchallenge.ui.main.view_model.MainViewModel
import com.google.android.material.tabs.TabLayout
import org.koin.android.ext.android.inject

class MainFragment : Fragment() {

    private val viewModel by inject<MainViewModel>()
    private lateinit var bannerPageAdapter: BannerPageAdapter
    private lateinit var bannerSlider: ViewPager
    private lateinit var dotsLayout: TabLayout

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

        observeBanners()
        bannerPageAdapter = BannerPageAdapter(requireContext())
        bannerSlider.adapter = bannerPageAdapter
        dotsLayout.setupWithViewPager(bannerSlider)
    }

    private fun observeBanners() {
        viewModel.refreshBanners().observe(viewLifecycleOwner) {
            when (it.getStatus()) {

                DataState.DataStatus.LOADING -> {
                    Log.d("tag", it.getData()?.status.toString().plus(" loading"))
                }

                DataState.DataStatus.SUCCESS -> {
                    Log.d("tag",
                        it.getData()?.status.toString().plus(it.getData()?.result?.size)
                            .plus(" success")
                    )
                    it.getData()?.result.let { data ->
                        data?.let { list ->
                            bannerPageAdapter.setBanners(list as ArrayList<Result>)
                            bannerPageAdapter.notifyDataSetChanged()
                        }
                    }
                }

                DataState.DataStatus.ERROR -> {
                    Log.d("tag", it.getData()?.status.toString())
                }

                DataState.DataStatus.NO_INTERNET -> {
                    Log.d("tag", it.getData()?.status.toString())
                }


            }
        }
    }

}