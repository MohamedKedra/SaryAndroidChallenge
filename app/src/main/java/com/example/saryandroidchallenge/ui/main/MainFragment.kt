package com.example.saryandroidchallenge.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.saryandroidchallenge.R
import com.example.saryandroidchallenge.adapters.BannerPageAdapter
import com.example.saryandroidchallenge.adapters.ParentAdapter
import com.example.saryandroidchallenge.app.base.DataState
import com.example.saryandroidchallenge.databinding.MainFragmentBinding
import com.example.saryandroidchallenge.remote.models.Category
import com.example.saryandroidchallenge.remote.models.Result
import com.example.saryandroidchallenge.ui.main.view_model.MainViewModel
import kotlinx.android.synthetic.main.error_layout.*
import kotlinx.android.synthetic.main.error_list_layout.*
import kotlinx.android.synthetic.main.main_fragment.*
import org.koin.android.ext.android.inject

class MainFragment : Fragment() {

    private lateinit var binding: MainFragmentBinding
    private val viewModel by inject<MainViewModel>()
    private lateinit var bannerPageAdapter: BannerPageAdapter
    private lateinit var parentAdapter: ParentAdapter

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeBanners()
        bannerPageAdapter = BannerPageAdapter(requireContext())
        banner_slider.adapter = bannerPageAdapter
        banner_indicator.setupWithViewPager(banner_slider)

        observeCategories()
        parentAdapter = ParentAdapter(requireContext())
        rvMain.adapter = parentAdapter
    }

    private fun observeBanners() {
        viewModel.refreshBanners().observe(viewLifecycleOwner) {
            when (it.getStatus()) {
                DataState.DataStatus.LOADING -> {
                    showOrHideLoading(isLoading = true)
                }

                DataState.DataStatus.SUCCESS -> {
                    showOrHideLoading()
                    it.getData()?.result.let { data ->
                        data?.let { list ->
                            bannerPageAdapter.setBanners(list as ArrayList<Result>)
                            bannerPageAdapter.notifyDataSetChanged()
                        }
                    }
                }

                DataState.DataStatus.ERROR -> {
                    showOrHideLoading(hasIssue = true, txt = getString(R.string.error))
                }

                DataState.DataStatus.NO_INTERNET -> {
                    showOrHideLoading(hasIssue = true, txt = getString(R.string.no_internet))
                }
            }
        }
    }

    private fun observeCategories() {
        viewModel.refreshCategories().observe(viewLifecycleOwner) {
            when (it.getStatus()) {

                DataState.DataStatus.LOADING -> {
                    showOrHideLoadingList(isLoading = true)
                }
                DataState.DataStatus.SUCCESS -> {
                    showOrHideLoadingList()
                    it?.getData()?.result?.let { list ->
                        parentAdapter.setCategories(list as ArrayList<Category>)
                        parentAdapter.notifyDataSetChanged()
                    }
                }

                DataState.DataStatus.ERROR -> {
                    showOrHideLoadingList(hasIssue = true, txt = getString(R.string.error))
                }

                DataState.DataStatus.NO_INTERNET -> {
                    showOrHideLoadingList(hasIssue = true, txt = getString(R.string.no_internet))

                }
            }
        }
    }

    private fun showOrHideLoading(
        isLoading: Boolean = false,
        hasIssue: Boolean = false,
        txt: String = ""
    ) {
        progress.isVisible = isLoading
        tvIssue.isVisible = hasIssue
        tvIssue.text = txt
        bannerContainer.isVisible = !isLoading && !hasIssue
    }

    private fun showOrHideLoadingList(
        isLoading: Boolean = false,
        hasIssue: Boolean = false,
        txt: String = ""
    ) {
        progressList.isVisible = isLoading
        tvIssueList.isVisible = hasIssue
        tvIssueList.text = txt
        rvMain.isVisible = !isLoading && !hasIssue
    }
}