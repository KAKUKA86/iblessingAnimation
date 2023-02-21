package com.iblessing.iblessinganimation.service.impl

import com.iblessing.iblessinganimation.dao.AdminUserMapper
import com.iblessing.iblessinganimation.pojo.AdminUser
import com.iblessing.iblessinganimation.pojo.Partition
import com.iblessing.iblessinganimation.service.AdminUserService
import com.iblessing.iblessinganimation.util.AdPartitionResult
import com.iblessing.iblessinganimation.util.AdUserResult
import jakarta.annotation.Resource
import org.springframework.stereotype.Service
import java.sql.Timestamp
import java.util.*

@Service
class AdminUserServiceImpl : AdminUserService {
    @Resource
    private var mapper: AdminUserMapper? = null
    override fun adminUserLogin(adUsername: String, adUserPassword: String): AdUserResult? {
        println("service处 $adUsername")
        val adminUser: AdminUser? = mapper?.queryAdminUserByAdUserName(adUsername)
        println("service出库 ${adminUser?.adUsername}")
        return if (Objects.isNull(adminUser)) {
            println("该用户不存在")
            AdUserResult(400, "002", "用户不存在", null)
        } else {
            println("用户存在条件")
            if (Objects.equals(adminUser?.adUsername, adUserPassword)) {
                println(adminUser?.adUsername + "登陆成功，写入登录时间")
                AdUserResult(200, "001", "登录成功", adminUser)
            } else {
                println("该用户存在但密码错误")
                AdUserResult(100, "002", "密码错误", null)
            }
        }
    }

    override fun queryAllPartition(partition: Partition): AdPartitionResult? {
        val partitionList: List<Partition>? = mapper?.queryAllPartition()
        return if (Objects.nonNull(partitionList)) {
            println("查询成功")
            AdPartitionResult(500, "500", "查询成功", null, partitionList)
        } else {
            println("查询失败")
            AdPartitionResult(400, "400", "查询失败", null, null)

        }
    }

    override fun addPartition(partition: Partition): AdPartitionResult? {
        return if(mapper?.queryPartitionByPaName(partition.paName) == 0) {
            println("通过重复验证")
            AdPartitionResult(400, "400" ,"名称已经存在" , partition,null)
        }else {
            partition.paCreationTime = Timestamp(System.currentTimeMillis())
            if (mapper?.addPartition(partition.paName,partition.adId, partition.paCreationTime!!) != 0){
                AdPartitionResult(500,"500","新增成功",partition,null)
            }else{
                AdPartitionResult(400,"400","新增失败",partition,null)
            }
        }
    }
}