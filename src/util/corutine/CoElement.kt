package util.corutine

interface CoElement<T> {
   fun runInCorutine()
   fun getCallbacker():CoCallbacker<T>
}