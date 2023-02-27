package com.iblessing.iblessinganimation.util

import com.iblessing.iblessinganimation.pojo.Partition

class NoPartitionResult (
    val statusCode : Int,
    var code: String,
    var msg: String,
    var data: List<Partition>?
        )