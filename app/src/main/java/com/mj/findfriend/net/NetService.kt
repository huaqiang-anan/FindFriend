package com.mj.findfriend.net


import com.mj.findfriend.net.entity.GirlFriend
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Created by huaqiang
 * on 2016-07-29.
 */
interface NetService {
    @POST("/detail")
    fun getMsg(@Query("ak") ak: String): Call<GirlFriend>

}
