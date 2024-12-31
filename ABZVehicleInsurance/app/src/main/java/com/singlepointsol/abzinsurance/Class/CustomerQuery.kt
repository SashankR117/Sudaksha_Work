package com.singlepointsol.abzinsurance.Class

data class CustomerQuery(
    val customer: String,
    val customerID: String,
    val description: String,
    val queryDate: String,
    val queryID: String,
    val queryResponses: List<QueryResponse>,
    val status: String
)