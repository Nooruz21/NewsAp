package com.example.newsapp.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.newsapp.base.BaseFragment
import com.example.newsapp.databinding.FragmentSearchBinding
import com.example.newsapp.ui.news.NewsViewModel
import com.example.newsapp.ui.search.adapter.CategoryViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : BaseFragment<FragmentSearchBinding>() {

    private val viewModel: NewsViewModel by viewModel()


    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): FragmentSearchBinding {
        return FragmentSearchBinding.inflate(inflater, container, false)
    }

    override fun initListener() {

    }

    override fun initView() {
        val adapter = CategoryViewPagerAdapter(this)
        binding.viewpager.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewpager
        ) { tab, position ->
            tab.text = adapter.getTitle(position)
        }.attach()
    }
}
