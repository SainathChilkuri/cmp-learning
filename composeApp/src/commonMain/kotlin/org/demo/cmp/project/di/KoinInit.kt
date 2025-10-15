package org.demo.cmp.project.di

import org.koin.core.context.startKoin


object Koin {
    fun initKoin(){
        startKoin {
           modules(appModule())
        }
    }

}


