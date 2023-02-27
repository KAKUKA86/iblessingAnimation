package com.iblessing.iblessinganimation.pojo

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import java.sql.Timestamp

@Data
@AllArgsConstructor
@NoArgsConstructor
class Article {
    var arId: Int = 0
    var noId: Int = 0
    var paId: Int = 0
    var arTitle: String = ""
    var arContent: String = ""
    var arTime: Timestamp? = null
    var arView: Int = 0
    var arStatus: Int = 0
    var auId: Int = 0
}