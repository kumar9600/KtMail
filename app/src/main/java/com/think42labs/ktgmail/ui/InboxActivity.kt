package com.think42labs.ktgmail.ui

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import androidx.recyclerview.widget.RecyclerView
import com.think42labs.ktgmail.AppViewModelFactory
import com.think42labs.ktgmail.Constants
import com.think42labs.ktgmail.R
import com.think42labs.ktgmail.databinding.ActivityMainBinding
import com.think42labs.ktgmail.net.Response
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class InboxActivity : DaggerAppCompatActivity(), InboxAdapter.ClickListener {

    @Inject
    lateinit var viewModelFactory: AppViewModelFactory

    private lateinit var viewModel: ListActivityViewModel

    private lateinit var binding: ActivityMainBinding

    private val inboxList = arrayListOf<Response>()

    private lateinit var inboxAdapter: InboxAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = viewModelFactory.create(ListActivityViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.inboxList.observe(this, Observer {
            if (it.isNotEmpty()) {
                inboxList.clear()
                inboxList.addAll(it)
                inboxAdapter.notifyDataSetChanged()
            }
        })

        binding.toolbar.setNavigationOnClickListener {
            Constants.showSnackBar(binding.container, "Toolbar clicked")
        }

        viewModel.error.observe(this, Observer {
            Constants.showSnackBar(binding.container, it)
        })

        inboxAdapter = InboxAdapter(inboxList, this, this)
        binding.recyclerView.adapter = inboxAdapter
    }

    override fun onClickMessage(subject: String) {
        Constants.showSnackBar(binding.container, subject)
    }
}
