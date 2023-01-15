package com.baktiyar11.cryptoapplication.presentation.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baktiyar11.cryptoapplication.presentation.model.CoinInfoPresentation
import com.baktiyar11.domain.base.Mapper
import com.baktiyar11.domain.model.CoinInfoDomain
import com.baktiyar11.domain.usecase.GetCoinInfoListUseCase
import com.baktiyar11.domain.usecase.GetCoinInfoUseCase
import com.baktiyar11.domain.usecase.LoadDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinViewModel @Inject constructor(
    private val getCoinInfoListUseCase: GetCoinInfoListUseCase,
    private val getCoinInfoUseCase: GetCoinInfoUseCase,
    private val loadDataUseCase: LoadDataUseCase,
    private val mapCoinListFromDomainToPresentation: Mapper<List<CoinInfoDomain>, List<CoinInfoPresentation>>,
    private val mapCoinFromDomainToPresentation: Mapper<CoinInfoDomain, CoinInfoPresentation>,
) : ViewModel() {

    private val _coinInfoList = MutableLiveData<List<CoinInfoPresentation>>()
    val coinInfoList: LiveData<List<CoinInfoPresentation>> get() = _coinInfoList

    private val _coinInfo = MutableLiveData<CoinInfoPresentation>()
    val coinInfo: LiveData<CoinInfoPresentation> get() = _coinInfo

    fun getCoinInfoList() = viewModelScope.launch {
        _coinInfoList.value =
            mapCoinListFromDomainToPresentation.map(getCoinInfoListUseCase())
    }

    fun getDetailInfo(fSym: String) = viewModelScope.launch {
        _coinInfo.value = mapCoinFromDomainToPresentation.map(getCoinInfoUseCase(fSym = fSym))
    }

    fun loadData() = viewModelScope.launch { loadDataUseCase() }
}