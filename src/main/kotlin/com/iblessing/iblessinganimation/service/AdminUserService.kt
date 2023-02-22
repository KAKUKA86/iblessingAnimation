package com.iblessing.iblessinganimation.service

import com.iblessing.iblessinganimation.pojo.Announcement
import com.iblessing.iblessinganimation.pojo.Lexicon
import com.iblessing.iblessinganimation.pojo.Partition
import com.iblessing.iblessinganimation.util.AdAnnounceResult
import com.iblessing.iblessinganimation.util.AdLexiconResult
import com.iblessing.iblessinganimation.util.AdPartitionResult
import com.iblessing.iblessinganimation.util.AdUserResult
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
}

