package com.github.johnnysc.practicetdd.task005

/**
 * @author Demitrist on 06.01.2023
 */

interface CacheDataSource {

    fun add(item: SimpleData)
    fun data(): List<SimpleData>

    class Timed(private val now: Now, private val lifeTimeMillis: Int = 1000) : CacheDataSource {
        private var source: MutableMap<Long,SimpleData> = mutableMapOf()

        override fun add(item: SimpleData) {
            source.put(now.now(), item)
        }

        override fun data(): List<SimpleData> {
            val temp = mutableMapOf<Long,SimpleData>()
            source.forEach {
                if (now.now() - lifeTimeMillis < it.key) temp.put(it.key, it.value)
            }
            source=temp
            val list = mutableListOf<SimpleData>()
            source.forEach{
                list.add(it.value)
            }
            return list
        }
    }
}