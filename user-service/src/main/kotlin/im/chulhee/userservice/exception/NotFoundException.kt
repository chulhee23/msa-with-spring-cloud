package im.chulhee.userservice.exception

class NotFoundException(override val message: String) : RuntimeException(message) {
}
