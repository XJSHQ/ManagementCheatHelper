package org.xjshq.managementcheathelper.api

import org.xjshq.managementcheathelper.api.project.Project

fun Project.formatPP(block: (Project) -> Unit): String {
    block(this)
    val pp = calculatePP()
    val years = pp.toInt()
    val months = ((pp - years) * 12.0).toInt()
    return "Years: $years \n monthes: $months"
}

fun calculateNPV(receipts: MutableList<Double>, interestRate: Double, investment: Double): Double {
    var t = 0
    return receipts.sumByDouble {
        t++
        it / Math.pow(1.0 + interestRate, t.toDouble())
    } - investment
}
