package com.iblessing.iblessinganimation.pojo

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@Data
@AllArgsConstructor
@NoArgsConstructor
class Partition {
    var paId: Int = 0
    var paName: String = ""
    var paCreationTime: Long = 0
    var paStatus: String = ""
    var auId: Int = 0
}