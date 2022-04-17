package com.toeii.module.home.activity

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.toeii.androidbaseframemvvm.base.ktx.launchIO
import com.toeii.androidbaseframemvvm.base.mvvm.vm.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * 首页的VM层
 *
 * @property mRepository HomeRepository 仓库层 通过Hilt注入
 *
 * @author toeii
 * @since 5/25/21 5:41 PM
 */
@HiltViewModel
class HomeViewModel @Inject constructor(private val mRepository: HomeRepository) : BaseViewModel() {

    private val _data = MutableLiveData<String>()
    val data: MutableLiveData<String> = _data


    /**
     * 模拟获取数据
     */
    fun getData() {
        launchIO {
            mRepository.getData()
                .catch { Log.d("qqq", "getData: $it") }
                .onStart { changeStateView(loading = true) }
                .collect {
                    changeStateView(hide = true)
                    _data.postValue(it)
                }
        }
    }
}