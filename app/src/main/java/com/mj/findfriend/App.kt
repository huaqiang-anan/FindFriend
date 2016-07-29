package com.mj.findfriend

import android.app.Application

import com.mj.findfriend.net.NetService

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by huaqiang
 * on 2016-07-29.
 */
open class App : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
        //val crashHandler = CrashHandler.getInstance()
        //crashHandler.init(this)
    }

    companion object {
        private var instance: Application? = null
        fun instance() = instance!!
        var mNetService: NetService? = null

        /*open fun getNetSetvice(): NetService {
            var mNetService = mNetService
            if (null != mNetService) {
                return mNetService
            }
            val retrofit = Retrofit.Builder()
                    .baseUrl(Config.SHIPPING_API_HOST)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            mNetService = retrofit.create<NetService>(NetService::class.java!!)
            return mNetService
        }*/

        //同注释的方法！
        val service: NetService
            get() {
                var mNetService = mNetService
                if (null != mNetService) {
                    return mNetService
                }
                val retrofit = Retrofit.Builder()
                        .baseUrl(Config.SHIPPING_API_HOST)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()

                mNetService = retrofit.create<NetService>(NetService::class.java!!)
                return mNetService
            }
    }
}