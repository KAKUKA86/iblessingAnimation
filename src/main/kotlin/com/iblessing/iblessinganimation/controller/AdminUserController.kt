package com.iblessing.iblessinganimation.controller

import com.iblessing.iblessinganimation.pojo.*
import com.iblessing.iblessinganimation.service.AdminUserService
import com.iblessing.iblessinganimation.util.*
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

    /**
     * 管理员删除分区
     */
    @RequestMapping("/delPartition")
    fun deletePartition(@RequestBody partition: Partition) : AdPartitionResult?{
        return service?.deletePartition(partition)
    }
    /**
     * 管理员修改分区
     */
    @RequestMapping("/updPartition")
    fun updatePartition(@RequestBody partition: Partition) : AdPartitionResult? {
        return service?.updatePartition(partition)
    }
    /**
     * 管理员查询现有词库
     */

    @RequestMapping("/queLexicon")
    fun queryLexicon(@RequestBody lexicon: Lexicon) :  AdLexiconResult? {
        return service?.queryAllLexicon(lexicon)
    }
    /**
     * 管理员新增词库
     */
    @RequestMapping("/addLexicon")
    fun addLexicon(@RequestBody lexicon: Lexicon) : AdLexiconResult? {
        return service?.addLexicon(lexicon)
    }

    /**
     * 管理员删除词库
     */
    @RequestMapping("/delLexicon")
    fun  deleteLexicon(@RequestBody lexicon: Lexicon) : AdLexiconResult? {
        return service?.deleteLexicon(lexicon)
    }
    /**
     * 管理员修改词库
     */
    @RequestMapping("/updLexicon")
    fun updateLexicon (@RequestBody lexicon: Lexicon) : AdLexiconResult? {
        return service?.updateLexicon(lexicon)
    }

    /**
     * 管理员查询已经发布的系统信息
     */
    @RequestMapping("/queAnnounce")
    fun queryAnnounce (@RequestBody announcement : Announcement) : AdAnnounceResult? {
        return service?.queryAllAnnouncement(announcement)
    }
    /**
     * 管理员添加系统维护信息
     */
    @RequestMapping("/addAnnounce")
    fun addAnnounce (@RequestBody announcement: Announcement) : AdAnnounceResult? {
        return service?.addAnnouncement(announcement)
    }
    /**
     * 管理员删除系统维护信息
     */
    @RequestMapping("/delAnnounce")
    fun deleteAnnounce (@RequestBody announcement: Announcement) : AdAnnounceResult? {
        return service?.deleteAnnouncement(announcement)
    }

    /**
     * 管理员修改系统 （原则上禁止更改）
     */


    /**
     * 管理员查询审核员信息
     */
    @RequestMapping("/queAudi")
    fun queryAuditor(@RequestBody audiUser: AudiUser): AdAuditorResult? {
        return service?.queryAllAuditor(audiUser)
    }
    /**
     * 管理员新增审核员
     */
    @RequestMapping("/addAudi")
    fun addAuditor(@RequestBody audiUser: AudiUser): AdAuditorResult? {
        return service?.addAuditor(audiUser)
    }
    /**
     * 管理员删除审核员
     */
    @RequestMapping("/delAudi")
    fun deleteAuditor(@RequestBody audiUser: AudiUser): AdAuditorResult?{
        return service?.deleteAuditor(audiUser)
    }
    /**
     * 管理员修改审核员信息
     */
    @RequestMapping("/updAudi")
    fun updateAuditor(@RequestBody audiUser: AudiUser): AdAuditorResult?{
        return service?.updateAuditor(audiUser)
    }
}