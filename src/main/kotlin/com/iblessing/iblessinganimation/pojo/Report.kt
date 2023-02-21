package com.iblessing.iblessinganimation.pojo

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@Data
@AllArgsConstructor
@NoArgsConstructor
class Report {
    var reId: Int = 0
    var noId: Int = 0
    var arId: Int = 0
    var reType: String = ""
    var reContent: String = ""
}