package com.example.newsapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.newsapp.base.BaseFragment
import com.example.newsapp.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }


    override fun initListener() {

    }

    override fun initView() {

    }



}