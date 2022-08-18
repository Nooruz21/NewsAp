package com.example.newsapp.ui.news

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.newsapp.base.BaseFragment
import com.example.newsapp.data.domain.Resource
import com.example.newsapp.databinding.FragmentNewsBinding
import com.example.newsapp.model.Article
import com.example.newsapp.model.News
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val ARG_PARAM1 = "category_key"

class NewsFragment : BaseFragment<FragmentNewsBinding>() {
    private var category = "No category"
    private val viewModel: NewsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        category = arguments?.getString(ARG_PARAM1).toString()
    }

    companion object {
        @JvmStatic
        fun newInstance(category: String) =
            NewsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, category)
                }
            }
    }

    override fun initListener() {

    }

    override fun initView() {
        var adapter: NewsAdapter
        viewModel.getNews(category)
        val data = arrayListOf<Article>()
        viewModel.serviceNews.observe(viewLifecycleOwner) { it: Resource<News?>? ->
            when (it?.status) {
                Resource.Status.SUCCESS -> {
                    data.add(it.data as Article)
                    Log.e("ololo", "initView: ${it.data}", )
                }
                else -> {

                }
            }
            adapter = NewsAdapter(data)
            binding.recyclerview.adapter = adapter
        }
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): FragmentNewsBinding {
        return FragmentNewsBinding.inflate(inflater, container, false)
    }
}