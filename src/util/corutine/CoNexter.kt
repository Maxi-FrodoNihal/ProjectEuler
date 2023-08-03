package util.corutine

import java.util.Optional

interface CoNexter<T> {
   fun next():Optional<CoElement<T>>
}