package com.baktiyar11.cryptoapplication.presentation.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.baktiyar11.cryptoapplication.R
import com.baktiyar11.cryptoapplication.databinding.ActivityCoinPriceListBinding
import com.baktiyar11.cryptoapplication.presentation.ui.adapter.CoinInfoAdapter
import com.baktiyar11.cryptoapplication.presentation.ui.details.CoinDetailActivity
import com.baktiyar11.cryptoapplication.presentation.ui.details.CoinDetailFragment
import com.baktiyar11.cryptoapplication.presentation.ui.viewModel.CoinViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoinPriceListActivity : AppCompatActivity() {

    private val binding by lazy { ActivityCoinPriceListBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<CoinViewModel>()
    private val coinInfoAdapter by lazy { CoinInfoAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        observeViewModel()
    }

    private fun observeViewModel() = binding.apply {
        setupClickListener()
        rvCoinPriceList.adapter = coinInfoAdapter
        viewModel.apply {
            loadData()
            getCoinInfoList()
            coinInfoList.observe(this@CoinPriceListActivity) { coinInfoAdapter.submitList(it) }
        }
    }

    private fun isOnePaneMode() = binding.fragmentContainer == null

    private fun launchDetailActivity(fromSymbol: String) =
        startActivity(CoinDetailActivity.newIntent(this@CoinPriceListActivity, fromSymbol))

    private fun launchDetailFragment(fromSymbol: String) {
        supportFragmentManager.popBackStack()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, CoinDetailFragment.newInstance(fromSymbol))
            .addToBackStack(null).commit()
    }

    private fun setupClickListener() {
        coinInfoAdapter.onCoinClickListener = { coinInfo ->
            if (isOnePaneMode()) launchDetailActivity(coinInfo.fromSymbol)
            else launchDetailFragment(coinInfo.fromSymbol)
        }
    }
}