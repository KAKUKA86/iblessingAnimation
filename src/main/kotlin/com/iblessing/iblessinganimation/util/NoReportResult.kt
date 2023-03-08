package com.iblessing.iblessinganimation.util

import com.iblessing.iblessinganimation.pojo.Report

class NoReportResult(
    var code: Int,
    var statusCode: String,
    var message: String,
    var noReport: Report?,
    var noReportList: List<Report>?
) {
}