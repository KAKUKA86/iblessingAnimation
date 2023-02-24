package com.iblessing.iblessinganimation.service.impl

import com.iblessing.iblessinganimation.dao.AdminUserMapper
import com.iblessing.iblessinganimation.pojo.*
import com.iblessing.iblessinganimation.service.AdminUserService
import com.iblessing.iblessinganimation.util.*
import jakarta.annotation.Resource
import org.springframework.stereotype.Service
import java.sql.Timestamp
import java.util.*

@Service
class AdminUserServiceImpl : AdminUserService {
    @Resource
    private var mapper: AdminUserMapper? = null

    /**
     * 管理员登录
     */
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

    /**
     * 管理员查询现有分区
     */

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

    /**
     * 管理员添加分区
     */

    override fun addPartition(partition: Partition): AdPartitionResult? {
        return if (mapper?.queryPartitionByPaName(partition.paName) == 0) {
            println("通过重复验证")
            AdPartitionResult(400, "400", "名称已经存在", partition, null)
        } else {
            partition.paCreationTime = Timestamp(System.currentTimeMillis())
            if (mapper?.addPartition(partition.paName, partition.adId, partition.paCreationTime!!) != 0) {
                AdPartitionResult(500, "500", "新增成功", partition, null)
            } else {
                AdPartitionResult(400, "400", "新增失败", partition, null)
            }
        }
    }

    /**
     * 管理员修改分区
     */
    override fun updatePartition(partition: Partition): AdPartitionResult? {
        val paName = partition.paName
        val paCreationTime = Timestamp(System.currentTimeMillis())
        val adId = partition.adId
        val paId = partition.paId
        return if (mapper?.updatePartition(paName, paCreationTime, adId, paId) != 0) {
            AdPartitionResult(500, "500", "修改成功", partition, null)
        } else {
            AdPartitionResult(400, "400", "修改失败", partition, null)
        }
    }

    /**
     * 管理员删除分区
     */

    override fun deletePartition(partition: Partition): AdPartitionResult? {
        val paId = partition.paId
        return if (mapper?.deletePartition(paId) != 0) {
            AdPartitionResult(500, "500", "删除成功", null, null)
        } else {
            AdPartitionResult(400, "400", "删除失败", partition, null)
        }
    }

    /**
     * 管理员查询现有词库
     */

    override fun queryAllLexicon(lexicon: Lexicon): AdLexiconResult? {
        val lexiconList = mapper?.queryAllLexicon()
        return if (Objects.nonNull(lexiconList)) {
            println("查询成功")
            AdLexiconResult(500, "500", "查询成功", null, lexiconList)
        } else {
            AdLexiconResult(400, "400", "查询失败", null, null)
        }
    }

    /**
     * 管理员添加词库
     */

    override fun addLexicon(lexicon: Lexicon): AdLexiconResult? {
        val leWord = lexicon.leWord
        val leCreationTime = Timestamp(System.currentTimeMillis())
        val adId = lexicon.adId
        return if (mapper?.queryLexiconByLeWord(leWord) == 0) {
            println("通过重复验证")
            AdLexiconResult(400, "400", "名称已经存在", lexicon, null)
        } else {
            if (mapper?.addLexicon(leWord, leCreationTime, adId) != 0) {
                AdLexiconResult(500, "500", "新增成功", lexicon, null)
            } else {
                AdLexiconResult(400, "400", "新增失败", lexicon, null)
            }
        }
    }

    /**
     * 管理员删除词库
     */

    override fun deleteLexicon(lexicon: Lexicon): AdLexiconResult? {
        val leId = lexicon.leId
        return if (mapper?.deleteLexicon(leId) != 0) {
            AdLexiconResult(500, "500", "删除成功", null, null)
        } else {
            AdLexiconResult(400, "400", "删除失败", lexicon, null)
        }
    }

    /**
     * 管理员修改词库
     */
    override fun updateLexicon(lexicon: Lexicon): AdLexiconResult? {
        val leWord = lexicon.leWord
        val leCreationTime = Timestamp(System.currentTimeMillis())
        val adId = lexicon.adId
        val leId = lexicon.leId
        return if (mapper?.updateLexicon(leWord, leCreationTime, adId, leId) != 0) {
            AdLexiconResult(500, "500", "修改成功", lexicon, null)
        } else {
            AdLexiconResult(400, "400", "修改失败", lexicon, null)
        }
    }

    /**
     *  管理员查询现有公告
     */
    override fun queryAllAnnouncement(announcement: Announcement): AdAnnounceResult? {
        val announcementList = mapper?.queryAllAnnouncement()
        return if (Objects.nonNull(announcementList)) {
            println("查询成功")
            AdAnnounceResult(500, "500", "查询成功", null, announcementList)
        } else {
            AdAnnounceResult(400, "400", "查询失败", null, null)
        }
    }

    /**
     * 管理员添加公告
     */

    override fun addAnnouncement(announcement: Announcement): AdAnnounceResult? {
        val anContent = announcement.anContent
        val anCreationTime = Timestamp(System.currentTimeMillis())
        val adId = announcement.adId
        val anTimeLimit = announcement.anTimeLimit
        return if (mapper?.addAnnouncement(anContent, anCreationTime, adId, anTimeLimit) != 0) {
            AdAnnounceResult(500, "500", "新增成功", announcement, null)
        } else {
            AdAnnounceResult(400, "400", "新增失败", announcement, null)
        }
    }

    /**
     *  管理员删除公告
     */

    override fun deleteAnnouncement(announcement: Announcement): AdAnnounceResult? {
        val anId = announcement.anId
        return if (mapper?.deleteAnnouncementById(anId) != 0) {
            AdAnnounceResult(500, "500", "删除成功", null, null)
        } else {
            AdAnnounceResult(400, "400", "删除失败", announcement, null)
        }
    }

    /**
     *  管理员查询现有审核员
     */
    override fun queryAllAuditor(audiUser: AudiUser): AdAuditorResult? {
        val audiUserList = mapper?.queryAllAuditor()
        return if (Objects.nonNull(audiUserList)) {
            println("查询成功")
            AdAuditorResult(500, "500", "查询成功", null, audiUserList)
        } else {
            AdAuditorResult(400, "400", "查询失败", null, null)
        }
    }

    /**
     * 管理员添加审核员
     */
    override fun addAuditor(audiUser: AudiUser): AdAuditorResult? {
        val auUsername = audiUser.auUsername
        val auUserPassword = audiUser.auUserPassword
        return if (mapper?.queryAuditorByAuUsername(auUsername) == 0) {
            println("通过重复验证")
            AdAuditorResult(400, "400", "名称已经存在", audiUser, null)
        } else {
            if (mapper?.addAuditor(auUsername, auUserPassword) != 0) {
                AdAuditorResult(500, "500", "新增成功", audiUser, null)
            } else {
                AdAuditorResult(400, "400", "新增失败", audiUser, null)
            }
        }
    }

    /**
     * 管理员删除审核员
     */
    override fun deleteAuditor(audiUser: AudiUser): AdAuditorResult? {
        val auId = audiUser.auId
        return if (mapper?.deleteAuditorById(auId) != 0) {
            AdAuditorResult(500, "500", "删除成功", null, null)
        } else {
            AdAuditorResult(400, "400", "删除失败", audiUser, null)
        }
    }

    /**
     * 管理员修改审核员
     */
    override fun updateAuditor(audiUser: AudiUser): AdAuditorResult? {
        val auUsername = audiUser.auUsername
        val auUserPassword = audiUser.auUserPassword
        val auId = audiUser.auId
        return if (mapper?.updateAuditor(auUsername, auUserPassword, auId) != 0) {
            AdAuditorResult(500, "500", "修改成功", audiUser, null)
        } else {
            AdAuditorResult(400, "400", "修改失败", audiUser, null)
        }
    }
}