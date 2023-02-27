package com.iblessing.iblessinganimation.pojo

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import java.sql.Timestamp

@Data
@AllArgsConstructor
@NoArgsConstructor
class Announcement {
    var anId: Int = 0
    var anCreationTime: Timestamp? = null
    var anContent: String = ""
    var anTimeLimit: Int = 0
    var adId: Int = 0
}