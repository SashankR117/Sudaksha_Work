package com.singlepointsol.abzinsurance.Class

data class QueryResponse(
    val agent: Agent,
    val agentID: String,
    val description: String,
    val query: String,
    val queryID: String,
    val responseDate: String,
    val srNo: String
)