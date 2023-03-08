package com.iblessing.iblessinganimation.util

import com.iblessing.iblessinganimation.pojo.Partition

class NoPartitionResult (
    var code: Int,
    val statusCode : String,
    var msg: String,
    var data: List<Partition>?
        )