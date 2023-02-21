package com.iblessing.iblessinganimation.pojo

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import java.sql.Timestamp

@Data
@AllArgsConstructor
@NoArgsConstructor
class Partition {
    var paId: Int = 0
    var paName: String = ""
    var paCreationTime: Timestamp? = null
    var adId: Int = 0
}