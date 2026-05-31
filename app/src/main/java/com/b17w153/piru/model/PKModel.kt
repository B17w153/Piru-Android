package com.b17w153.piru.model

import kotlin.math.exp
import kotlin.math.ln

data class PKParameters(
    val dose: Double,           // mg
    val halfLife: Double,       // 小时
    val ka: Double,             // 吸收速率常数 (1/h)
    val bioavailability: Double = 1.0
)

class PKCalculator {
    // 根据 route 的 onset 时间估算 ka（原 Swift 逻辑类似）
    fun estimateKa(onsetHours: Double): Double {
        return when {
            onsetHours <= 0.25 -> 8.0   // 极快
            onsetHours <= 0.5 -> 4.0
            onsetHours <= 1.0 -> 2.5
            onsetHours <= 2.0 -> 1.2
            else -> 0.8
        }
    }

    // 计算 t 时刻的血药浓度 (一室模型，口服/非静脉)
    fun calculateConcentration(
        t: Double,                  // 时间（小时）
        params: PKParameters
    ): Double {
        val ke = ln(2.0) / params.halfLife
        val term1 = exp(-ke * t)
        val term2 = exp(-params.ka * t)
        
        return (params.dose * params.bioavailability * params.ka) /
               (params.ka - ke) * (term1 - term2) // 假设 Vd = 1（相对浓度）
    }

    // 生成时间线数据点（用于图表）
    fun generateTimeline(
        params: PKParameters,
        durationHours: Double = 24.0,
        stepMinutes: Int = 15
    ): List<Pair<Double, Double>> {  // (时间h, 浓度)
        val points = mutableListOf<Pair<Double, Double>>()
        var t = 0.0
        while (t <= durationHours) {
            val conc = calculateConcentration(t, params)
            points.add(t to conc)
            t += stepMinutes / 60.0
        }
        return points
    }
}