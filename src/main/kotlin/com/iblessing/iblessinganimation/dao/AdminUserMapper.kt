package com.iblessing.iblessinganimation.dao

import com.iblessing.iblessinganimation.pojo.*
import org.apache.ibatis.annotations.*
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

    @Delete(
        "delete * from a_partition " +
                " where "
    )
    fun deletePartition(paId: Int): Int

    @Update(
        "update a_partition " +
                "set pa_name = #{paName} , " +
                "pa_creation_time  = #{paCreationTime} ," +
                "ad_id = #{adId}" +
                "where pa_id = #{paId} "
    )
    fun updatePartition(paName: String, paCreationTime: Timestamp, adId: Int, paId: Int): Int

    @Select(
        "select * from a_partition"
    )
    fun queryAllLexicon(): List<Lexicon>

    @Select(
        "select * from a_partition where le_word = #{leWord}"
    )
    fun queryLexiconByLeWord(leWord: String): Int
    fun addLexicon(leWord: String, leCreationTime: Timestamp, adId: Any): Int

    @Delete(
        "delete * from a_partition " +
                " where le_id= #{leId}"
    )
    fun deleteLexicon(leId: Int): Int

    @Update(
        "update a_partition " +
                "set le_word = #{leWord} , " +
                "le_creation_time  = #{leCreationTime} ," +
                "ad_id = #{adId}" +
                "where le_id = #{leId} "
    )
    fun updateLexicon(leWord: String, leCreationTime: Timestamp, adId: Int, leId: Int): Int

    @Select(
        "select * from a_partition"
    )
    fun queryAllAnnouncement(): List<Announcement>

    @Update(
        "update a_partition " +
                "set an_content = #{anContent} , " +
                "an_creation_time  = #{anCreationTime} ," +
                "ad_id = #{adId}, " +
                "an_time_limit = #{anTimeLimit}" +
                "where an_id = #{anId} "
    )
    fun addAnnouncement(anContent: String, anCreationTime: Timestamp, adId: Int, anTimeLimit: Int): Int

    @Delete(
        "delete * from a_partition " +
                " where an_id= #{anId}"
    )
    fun deleteAnnouncementById(anId: Int): Int

    @Select(
        "select * from a_partition"
    )
    fun queryAllAuditor(): List<AudiUser>

    @Select(
        "select * from a_partition where au_username = #{auUsername}"
    )
    fun queryAuditorByAuUsername(auUsername: String): Int

    @Insert(
        "insert into a_audi_user (au_username , au_user_password)" +
                "values (#{auUsername} , #{auUserPassword} )"
    )
    fun addAuditor(auUsername: String, auUserPassword: String): Int

    @Delete(
        "delete * from a_partition " +
                " where au_id= #{auId}"
    )
    fun deleteAuditorById(auId: Int): Int

    @Update(
        "update a_audi_user " +
                "set au_username = #{auUsername} , " +
                "au_user_password  = #{auUserPassword} " +
                "where au_id = #{auId} "
    )
    fun updateAuditor(auUsername: String, auUserPassword: String, auId: Int): Int

}
