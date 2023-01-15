package com.baktiyar11.cryptoapplication.presentation.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.baktiyar11.cryptoapplication.databinding.FragmentCoinDetailsBinding
import com.baktiyar11.cryptoapplication.presentation.ui.viewModel.CoinViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoinDetailFragment : Fragment() {

    private var _binding: FragmentCoinDetailsBinding? = null
    private val binding: FragmentCoinDetailsBinding
        get() = _binding ?: throw RuntimeException("FragmentCoinDetailsBinding == null")
    private val viewModel by viewModels<CoinViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentCoinDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModelObserve()
    }

    private fun viewModelObserve() = binding.apply {
        viewModel.getDetailInfo(fSym = getSymbol())
        viewModel.coinInfo.observe(viewLifecycleOwner) {
            tvPrice.text = it.price
            tvMinPrice.text = it.lowDay
            tvMaxPrice.text = it.highDay
            tvLastMarket.text = it.lastMarket
            tvLastUpdate.text = it.lastUpdate
            tvFromSymbol.text = it.fromSymbol
            tvToSymbol.text = it.toSymbol
            Picasso.get().load(it.imageUrl).into(ivLogoCoin)
        }
    }

    private fun getSymbol() = requireArguments().getString(EXTRA_FROM_SYMBOL, EMPTY_SYMBOL)

    companion object {
        private const val EXTRA_FROM_SYMBOL = "fSym"
        private const val EMPTY_SYMBOL = ""

        fun newInstance(fromSymbol: String) = CoinDetailFragment().apply {
            arguments = Bundle().apply { putString(EXTRA_FROM_SYMBOL, fromSymbol) }
        }
    }
}