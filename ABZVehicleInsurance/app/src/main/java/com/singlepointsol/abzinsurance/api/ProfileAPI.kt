package com.singlepointsol.abzinsurance.api

import com.singlepointsol.abzinsurance.Class.ProfileDataClass
import com.singlepointsol.abzinsurance.viewmodel.ProfileViewModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ProfileAPI {

    @GET("/api/CustomerQuery")
    suspend fun getProfile(
        @Query("Bycustomer") customerID: String

    ): Response<ProfileDataClass>
}