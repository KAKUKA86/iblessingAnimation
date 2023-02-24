package com.iblessing.iblessinganimation.pojo

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import java.sql.Timestamp

@Data
@AllArgsConstructor
@NoArgsConstructor
class Lexicon {
    var leId: Int = 0
    var leWord: String = ""
    var leCreationTime: Timestamp? = null
    var leNumber: Int = 0
    var adId: Int = 0
}