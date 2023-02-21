package com.iblessing.iblessinganimation.dao

import com.iblessing.iblessinganimation.pojo.AdminUser
import com.iblessing.iblessinganimation.pojo.Partition
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import java.sql.Timestamp

@Mapper
interface AdminUserMapper {
    @Select("select * from a_admin_user where ad_username = #{adUsername}")
    fun queryAdminUserByAdUserName(adUsername: String): AdminUser?

    @Select("select * from a_partition")
    fun queryAllPartition(): List<Partition>

    @Select("select * from a_partition where pa_name = #{paName}")
    fun queryPartitionByPaName(paName: String): Int

    @Insert(
        "insert into a_partition (pa_name , pa_creation_time , ad_id)" +
                "values (#{paName} , #{paCreationTime} , #{adId})"
    )
    fun addPartition(paName: String, adId: Int, paCreationTime: Timestamp): Int

}
