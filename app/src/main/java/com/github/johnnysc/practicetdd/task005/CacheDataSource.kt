package com.github.johnnysc.practicetdd.task005

/**
 * @author Demitrist on 06.01.2023
 */

interface CacheDataSource {

    fun add(item: SimpleData)
    fun data(): List<SimpleData>

    class Timed(private val now: Now, private val lifeTimeMillis: Int = 1000) : CacheDataSource {
        private var source: MutableMap<Long, SimpleData> = mutableMapOf()

        override fun add(item: SimpleData) {
            source.put(now.now(), item)
        }

        override fun data(): List<SimpleData> {
            val temp = mutableMapOf<Long, SimpleData>()
            val list = mutableListOf<SimpleData>()
            source.forEach {
                if (now.now() < it.key + lifeTimeMillis) {
                    temp.put(it.key, it.value)
                    list.add(it.value)
                }
            }
            source = temp
            return list
        }
    }
}