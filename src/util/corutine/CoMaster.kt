package util.corutine

import kotlinx.coroutines.*
import java.util.Optional

class CoMaster<T>(private val coAmount:Int, private val extCallbacker: CoCallbacker<Optional<T & Any>>, private val nexter: CoNexter<T>):CoCallbacker<T> {

   private val workList = mutableListOf<Deferred<Unit>>()
   private var runFlag = true
   private var extCallbackOnce = true

   private fun addWork(activeWorks:Int){

      var prepareList = mutableListOf<CoElement<T>>();

      for(i in activeWorks..coAmount-1){
         val next = nexter.next()
         if(next.isPresent){
            prepareList.add(next.get())
         }else{
            break
         }
      }
      if(prepareList.isNotEmpty()){
         workList.addAll(prepareList.map {e -> GlobalScope.async(Dispatchers.Default){e.runInCorutine() }}.toList())
      }
   }

   fun run(){

      println("Master Start")

      addWork(0)

      while (runFlag && (workList.stream().anyMatch{ e->e.isActive } || workList.isNotEmpty())){
         val doneWorkElements = workList.filter { e -> e.isCompleted }
         workList.removeAll(doneWorkElements)
         addWork(workList.size)
      }

      if(workList.isNotEmpty() && workList.stream().anyMatch{ e->e.isActive }){
         workList.filter { e->e.isActive }.forEach { e->e.cancel() }
      }

      if (extCallbackOnce) {
         extCallbackOnce = false
         extCallbacker.callback(Optional.empty())
      }
   }

   override fun callback(callbacdkElement: T) {
      if(extCallbackOnce) {
         extCallbackOnce = false
         runFlag = false
         extCallbacker.callback(Optional.ofNullable(callbacdkElement))
      }
   }
}