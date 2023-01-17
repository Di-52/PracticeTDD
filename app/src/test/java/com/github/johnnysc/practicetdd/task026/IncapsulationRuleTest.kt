package com.github.johnnysc.practicetdd.task026

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author Asatryan on 15.01.2023
 */
class IncapsulationRuleTest {

    @Test
    fun `incapsulation rule passed`() {
        val rule: GoodCodeRule = GoodCodeRule.Incapsulation()
        val textList = listOf(
            "package com.github.johnnysc.practicetdd\n" +
                    "\n" +
                    "class Repository(private val dataSource: DataSource) {\n" +
                    "\n" +
                    "    private var page: Int = 0\n" +
                    "}",
            "package com.github.johnnysc.practicetdd\n" +
                    "\n" +
                    "abstract class Repository(private val dataSource: DataSource) {\n" +
                    "\n" +
                    "    protected var page: Int = 0\n" +
                    "}",
            "package com.github.johnnysc.practicetdd\n" +
                    "\n" +
                    "abstract class Repository(protected val dataSource: DataSource) {\n" +
                    "\n" +
                    "    private var page: Int = 0\n" +
                    "}",
            "package com.github.johnnysc.practicetdd\n" +
                    "\n" +
                    "abstract class Repository(protected val dataSource: DataSource) {\n" +
                    "\n" +
                    "    protected var page: Int = 0\n" +
                    "}",
            "package com.github.johnnysc.practicetdd\n" +
                    "\n" +
                    "abstract class Repository(protected val dataSource: DataSource) {\n" +
                    "\n" +
                    "    protected abstract val page: Int\n" +
                    "}",
        )
        textList.forEach { text ->
            val actual = rule.isValid(text = text)
            val expected = true
            assertEquals(expected, actual)
        }
    }

    @Test
    fun `incapsulation rule not passed`() {
        val rule: GoodCodeRule = GoodCodeRule.Incapsulation()
        val textList = listOf(
            "package com.github.johnnysc.practicetdd\n" +
                    "\n" +
                    "class Repository(val dataSource: DataSource) {\n" +
                    "\n" +
                    "    var page: Int = 0\n" +
                    "}",
            "package com.github.johnnysc.practicetdd\n" +
                    "\n" +
                    "class Repository(private val dataSource: DataSource) {\n" +
                    "\n" +
                    "    var page: Int = 0\n" +
                    "}",
            "package com.github.johnnysc.practicetdd\n" +
                    "\n" +
                    "class Repository(val dataSource: DataSource) {\n" +
                    "\n" +
                    "   private var page: Int = 0\n" +
                    "}",
            "package com.github.johnnysc.practicetdd\n" +
                    "\n" +
                    "abstract class Repository(protected val dataSource: DataSource) {\n" +
                    "\n" +
                    "    var page: Int = 0\n" +
                    "}",
            "package com.github.johnnysc.practicetdd\n" +
                    "\n" +
                    "abstract class Repository(val dataSource: DataSource) {\n" +
                    "\n" +
                    "   protected var page: Int = 0\n" +
                    "}",
            "package com.github.johnnysc.practicetdd\n" +
                    "\n" +
                    "abstract class Repository(val dataSource: DataSource) {\n" +
                    "\n" +
                    "   protected abstract val page: Int\n" +
                    "}",
        )
        textList.forEach { text ->
            val actual = rule.isValid(text = text)
            val expected = false
            assertEquals(expected, actual)
        }
    }

    @Test
    fun `incaplsulation rule passed with funs`() {
        val rule: GoodCodeRule = GoodCodeRule.Incapsulation()
        val textList = listOf(
            "package com.github.johnnysc.practicetdd.task026\n" +
                    "\n" +
                    "class TestClass(private val value: String) : TestInterface {\n" +
                    "\n" +
                    "    private var count = 0\n" +
                    "\n" +
                    "    override fun function(text: String, num: Int): Boolean {\n" +
                    "        val i = 1\n" +
                    "        return true\n" +
                    "    }\n" +
                    "}",
            "package com.github.johnnysc.practicetdd.task026\n" +
                    "\n" +
                    "abstract class Abstract(private val resource: Resources) {\n" +
                    "    \n" +
                    "    protected abstract var name: String\n" +
                    "    protected val count = 15\n" +
                    "    abstract fun invoke(): String\n" +
                    "\n" +
                    "    fun fetchResource(id: Int): String {\n" +
                    "        val isInvoke = false\n" +
                    "        return count.toString()\n" +
                    "    }\n" +
                    "}"
        )
        textList.forEach {
            val actual = rule.isValid(it)
            val expected = true
            assertEquals(expected, actual)
        }
    }

    @Test
    fun `incaplsulation rule not passed with funs`() {
        val rule: GoodCodeRule = GoodCodeRule.Incapsulation()
        val textList = listOf(
            "package com.github.johnnysc.practicetdd.task026\n" +
                    "\n" +
                    "class TestClass(val value: String) : TestInterface {\n" +
                    "\n" +
                    "    var count = 0\n" +
                    "\n" +
                    "    override fun function(text: String, num: Int): Boolean {\n" +
                    "        val i = 1\n" +
                    "        return true\n" +
                    "    }\n" +
                    "}",
            "package com.github.johnnysc.practicetdd.task026\n" +
                    "\n" +
                    "abstract class Abstract(private val resource: Resources) {\n" +
                    "    \n" +
                    "    abstract var name: String\n" +
                    "    protected val count = 15\n" +
                    "    abstract fun invoke(): String\n" +
                    "\n" +
                    "    fun fetchResource(id: Int): String {\n" +
                    "        val isInvoke = false\n" +
                    "        return count.toString()\n" +
                    "    }\n" +
                    "}"
        )
        textList.forEach {
            val actual = rule.isValid(it)
            val expected = false
            assertEquals(expected, actual)
        }
    }

}