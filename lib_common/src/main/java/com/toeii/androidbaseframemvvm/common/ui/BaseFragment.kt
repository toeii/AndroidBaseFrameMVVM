package com.toeii.androidbaseframemvvm.common.ui

import androidx.viewbinding.ViewBinding
import com.toeii.androidbaseframemvvm.base.mvvm.v.BaseFrameFragment
import com.toeii.androidbaseframemvvm.base.mvvm.vm.BaseViewModel

/**
 * Fragment基类
 *
 * @author toeii
 * @since 8/27/20
 */
abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel> : BaseFrameFragment<VB, VM>()