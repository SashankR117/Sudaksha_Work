package com.singlepointsol.abzinsurance.viewmodel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.lifecycle.ViewModel
import com.singlepointsol.abzinsurance.api.ProfileAPI
import com.singlepointsol.abzinsurance.retrofitinstance.ProfileRetrofitInstance

class ProfileViewModel: ViewModel()  {

    private val ProfileAPI = ProfileRetrofitInstance.profileAPI

    suspend fun getData(customer: String){

        ProfileAPI.getProfile(customer)


    }

}