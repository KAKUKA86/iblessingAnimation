package com.iblessing.iblessinganimation.util

import com.iblessing.iblessinganimation.pojo.AdminUser
import com.iblessing.iblessinganimation.pojo.Partition

class AdPartitionResult(
    var statusCode: Int,
    var code: String,
    var message: String,
    var partition: Partition?,
    var partitionList: List<Partition>?

)