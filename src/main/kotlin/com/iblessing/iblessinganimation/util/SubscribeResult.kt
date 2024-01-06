package com.iblessing.iblessinganimation.util

import com.iblessing.iblessinganimation.pojo.Collect
import com.iblessing.iblessinganimation.pojo.Subscribe

class SubscribeResult(
    var code: String,
    var statusCode: Int,
    var message: String,
    var subscribeList: List<Subscribe>?,
)
