package com.singlepointsol.abzinsurance.retrofitinstance

import com.singlepointsol.abzinsurance.api.ProfileAPI
import com.singlepointsol.abzinsurance.constants.urls.CUSTOMER_BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ProfileRetrofitInstance {


    private fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(CUSTOMER_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
    val profileAPI: ProfileAPI = getInstance().create(ProfileAPI::class.java)
}