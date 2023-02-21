package com.iblessing.iblessinganimation.controller

import com.iblessing.iblessinganimation.pojo.AdminUser
import com.iblessing.iblessinganimation.pojo.Partition
import com.iblessing.iblessinganimation.service.AdminUserService
import com.iblessing.iblessinganimation.util.AdPartitionResult
import com.iblessing.iblessinganimation.util.AdUserResult
import jakarta.annotation.Resource
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping("/adUser")
class AdminUserController {
    @Resource
    val service: AdminUserService? = null

    /**
     * 管理员登录
     */
    @PostMapping("/login")
    fun adminLogin(@RequestBody adminUser: AdminUser): AdUserResult? {
        val adUsername: String = adminUser.adUsername
        val adUserPassword: String = adminUser.adUserPassword
        return service?.adminUserLogin(adUsername, adUserPassword)
    }

    /**
     * 管理员查询现有分区
     */
    @RequestMapping("/quePartition")
    fun queryPartition(@RequestBody partition: Partition): AdPartitionResult? {
        return service?.queryAllPartition(partition)
    }

    /**
     * 管理员新增分区
     */
    @RequestMapping("/addPartition")
    fun addPartition(@RequestBody partition: Partition) : AdPartitionResult? {
        return service?.addPartition(partition)
    }
}