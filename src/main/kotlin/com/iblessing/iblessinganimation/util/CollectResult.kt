package com.iblessing.iblessinganimation.util

import com.iblessing.iblessinganimation.pojo.Collect

class CollectResult(
    var code: String,
    var statusCode: Int,
    var message: String,
    var collect: Collect?,
    var collectList: List<Collect>?,
)