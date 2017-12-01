package com.komori.yixi.di.component


import com.komori.yixi.branches.BranchesFragment
import com.komori.yixi.site.SiteFragment
import com.komori.yixi.di.module.FragmentModule
import com.komori.yixi.di.scope.FragmentScope
import com.komori.yixi.record.RecordFragment
import com.komori.yixi.speech.SpeechFragment

import dagger.Component

/**
 * Created by KomoriWu
 * on 2017-11-30.
 */

@FragmentScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(FragmentModule::class))
interface FragmentComponent {
//    fun getActivity(): Activity
    fun inject(speechFragment: SpeechFragment)
    fun inject(branchesFragment: BranchesFragment)
    fun inject(siteFragment: SiteFragment)
    fun inject(recordFragment: RecordFragment)
}
