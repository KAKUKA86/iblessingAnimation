package com.iblessing.iblessinganimation.service

import com.iblessing.iblessinganimation.pojo.Partition
import com.iblessing.iblessinganimation.util.AdPartitionResult
import com.iblessing.iblessinganimation.util.AdUserResult
import org.springframework.stereotype.Service

@Service
interface AdminUserService {
    fun adminUserLogin(adUsername: String, adUserPassword: String): AdUserResult?
    fun queryAllPartition(partition: Partition): AdPartitionResult?
    fun addPartition(partition: Partition): AdPartitionResult?
}
