package com.iblessing.iblessinganimation.service

import com.iblessing.iblessinganimation.pojo.*
import com.iblessing.iblessinganimation.util.*
import org.springframework.stereotype.Service

@Service
interface AdminUserService {
    fun adminUserLogin(adUsername: String, adUserPassword: String): AdUserResult?
    fun queryAllPartition(partition: Partition): AdPartitionResult?
    fun addPartition(partition: Partition): AdPartitionResult?
    fun updatePartition(partition: Partition): AdPartitionResult?
    fun deletePartition(partition: Partition): AdPartitionResult?
    fun queryAllLexicon(lexicon: Lexicon): AdLexiconResult?
    fun addLexicon(lexicon: Lexicon): AdLexiconResult?
    fun deleteLexicon(lexicon: Lexicon): AdLexiconResult?
    fun updateLexicon(lexicon: Lexicon): AdLexiconResult?
    fun queryAllAnnouncement(announcement: Announcement): AdAnnounceResult?
    fun addAnnouncement(announcement: Announcement): AdAnnounceResult?
    fun deleteAnnouncement(announcement: Announcement): AdAnnounceResult?
    fun queryAllAuditor(audiUser: AudiUser): AdAuditorResult?
    fun addAuditor(audiUser: AudiUser): AdAuditorResult?
    fun deleteAuditor(audiUser: AudiUser): AdAuditorResult?
    fun updateAuditor(audiUser: AudiUser): AdAuditorResult?
    fun queryAllAuditorArticle(article: Article): AdArticleResult?
    fun updateAuditorArticle(article: Article): AdArticleResult?
}

