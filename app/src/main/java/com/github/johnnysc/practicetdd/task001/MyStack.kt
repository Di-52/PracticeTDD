package com.github.johnnysc.practicetdd.task001

interface MyStack<T : Any> {

    fun pop(): T
    fun push(item: T)

    abstract class AbstractMyStack<T : Any>(private val maxCount: Int) : MyStack<T> {
        protected val itemList: Array<Any?>
        protected var position: Int = 0

        init {
            if (maxCount < 1) throw java.lang.IllegalStateException("Count of elements must be positive!")
            itemList = Array(size = maxCount) { null }
        }

        override fun push(item: T) {
            if (position == maxCount) throw java.lang.IllegalStateException("Stack overflow exception, maximum is $maxCount")
            itemList[position] = item
            position++
        }
    }

    class FIFO<T : Any>(val maxCount: Int) : AbstractMyStack<T>(maxCount) {

        override fun pop(): T {
            if (position == 0) throw IllegalStateException("Stack is empty")
            val item = itemList[0] as T
            if (position > 1)
                for (i in 0..position - 2)
                    itemList[i] = itemList[i + 1]
            position--
            itemList[position] = null
            return item
        }
    }

    class LIFO<T : Any>(val maxCount: Int) : AbstractMyStack<T>(maxCount) {

        override fun pop(): T {
            if (position == 0) throw IllegalStateException("Stack is empty")
            position--
            val item = itemList[position]
            itemList[position] = null
            return item as T
        }
    }
}