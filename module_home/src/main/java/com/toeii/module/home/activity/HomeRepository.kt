package com.toeii.module.home.activity

import com.toeii.androidbaseframemvvm.base.mvvm.m.BaseRepository
import com.toeii.module.home.net.HomeApiService
import kotlinx.coroutines.delay
import javax.inject.Inject

/**
 * 首页M层
 *
 * @author toeii
 * @since 5/25/21 5:42 PM
 */
class HomeRepository @Inject constructor() : BaseRepository() {

    @Inject
    lateinit var mApi: HomeApiService

    /**
     * 模拟获取数据
     */
    suspend fun getData() = request<String> {
        delay(1000L)
        emit("Hello Hilt")
    }
}