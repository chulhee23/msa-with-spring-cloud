package im.chulhee.userservice.generator

import java.time.Instant


object UserIdGenerator {
    var sequenceId = 1
    var currentMilliSeconds = System.currentTimeMillis()

    /**
     * generate snowflake id
     * 사인(sign) 비트 : 1
     * 타임스탬프 : 41
     * 데이터센터 ID : 5
     * 서버 ID : 5
     * 일련번호 : 12 각 서버에서 ID를 생성할 때마다 1만큼 증가시킨다. 이 값은 1ms 가 경과할 때마다 0으로 초기화해준다.
     * 여기서는 id 값을 실제로 대치하진 않는다.
     */
    fun generate(): String {
        val sign = 1.toBinaryString()

        val timestamp = Instant.now().toEpochMilli().toInt().toBinaryString()
        val dataCenterId = 1.toBinaryString()
        val serverId = 1.toBinaryString()
        val now = System.currentTimeMillis()
        if (now - currentMilliSeconds > 1L) {
            currentMilliSeconds = now
            sequenceId = 1
        } else {
            sequenceId++
        }

        return "$sign$timestamp$dataCenterId$serverId${sequenceId.toBinaryString()}"
    }


}

private fun Int.toBinaryString(): String {
    return Integer.toBinaryString(this)

}
