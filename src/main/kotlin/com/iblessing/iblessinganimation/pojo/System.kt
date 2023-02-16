package com.iblessing.iblessinganimation.pojo

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@Data
@AllArgsConstructor
@NoArgsConstructor
class System {
    var syId : Int = 0
    var syTime : Long = 0
    var syContent : String = ""
    var syTimeLimit : Int = 0
    var adId : Int = 0
}