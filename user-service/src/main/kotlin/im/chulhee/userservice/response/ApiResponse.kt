package im.chulhee.userservice.response

data class ApiResponse<T>(
    var code: ResponseCode = ResponseCode.SUCCESS,
    var result: T? = null,
    var error: ErrorMessage? = null,
) {

    constructor(result: T) : this() {
        this.result = result
    }
}
