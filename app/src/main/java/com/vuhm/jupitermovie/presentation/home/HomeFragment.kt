package com.vuhm.jupitermovie.presentation.home

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.vuhm.jupitermovie.R
import com.vuhm.jupitermovie.base.BaseFragment
import com.vuhm.jupitermovie.core.utils.Resource
import com.vuhm.jupitermovie.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val homeViewModel: HomeViewModel by viewModels()

    override fun initControls(savedInstanceState: Bundle?) {
        homeViewModel.getTrending()
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                homeViewModel.data.collectLatest { data ->
                    when (data) {
                        is Resource.Success -> Toast.makeText(
                            context,
                            data.toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                        is Resource.Loading -> Toast.makeText(
                            context,
                            "Loading",
                            Toast.LENGTH_SHORT
                        ).show()
                        is Resource.Error -> Toast.makeText(context, "Error", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }
    }

    override fun initEvents() {

    }
}