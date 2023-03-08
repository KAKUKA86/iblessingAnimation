package com.iblessing.iblessinganimation.pojo

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import java.sql.Timestamp

@Data
@AllArgsConstructor
@NoArgsConstructor
class Favorites {
    var faId: Int = 0
    var noId: Int = 0
    var arId: Int = 0
    var arTitle: String = ""
    var faTime: Timestamp? = null
}