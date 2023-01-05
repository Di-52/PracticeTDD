package com.github.johnnysc.practicetdd.task007

/**
 * @author Demitrist on 05.01.2023
 */

class MainViewModel(
    private val filters: List<GoodFilter>,
    private val products: List<Good>,
    private val communication: Communication<List<Good>>,
    private val filtersCommunication: Communication<List<GoodFilter>>,
) {

    private val activeFilters = mutableListOf<GoodFilter>()

    fun change(filter: GoodFilter) {
        if (!filters.contains(filter)) return
        when (activeFilters.contains(filter)) {
            true -> activeFilters.remove(filter)
            else -> activeFilters.add(filter)
        }

        val newList = products.toMutableList()
        val filteredGoods = mutableListOf<Good>()
        activeFilters.forEach { currenFilter ->
            newList.forEach { currentGood ->
                if (!currentGood.map(currenFilter))
                    filteredGoods.add(currentGood)
            }
            newList.removeAll(filteredGoods)
        }

        communication.map(newList)
        filtersCommunication.map(activeFilters)
    }
}