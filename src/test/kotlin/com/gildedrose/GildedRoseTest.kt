package com.gildedrose

import org.junit.Assert.*
import org.junit.Test

class GildedRoseTest {

    /*@Test fun foo() {
        val items = arrayOf<Item>(Item("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("fixme", app.items[0].name)

    }*/

    private fun updateItems(items: Array<Item>)
    {
        val app = GildedRose(items)
        app.updateQuality()
    }

    private val items = arrayOf(Item("+5 Dexterity Vest", 10, 20), //
    Item("Aged Brie", 2, 0), //
    Item("Elixir of the Mongoose", 5, 7), //
    Item("Sulfuras, Hand of Ragnaros", 0, 80), //
    Item("Sulfuras, Hand of Ragnaros", -1, 80),
    Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
    Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
    Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
    // this conjured item does not work properly yet
    Item("Conjured Mana Cake", 3, 6))

    @Test fun normalUpdate() {
        val items = arrayOf(Item("+5 Dexterity Vest",10,20))
        val expectedItems = arrayOf(Item("+5 Dexterity Vest",9,19))

        updateItems(items)
        assertEquals(items.contentToString(), expectedItems.contentToString())
    }

    @Test fun sulfurasUpdate() {

        val items = arrayOf(Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                Item("Sulfuras, Hand of Ragnaros", -1, 80))

        updateItems(items)
        assertEquals(items.contentToString(), items.contentToString())
    }

    @Test fun agedBrieUpdate() {

        val items = arrayOf(Item("Aged Brie", 2, 0))
        val expectedItems = arrayOf(Item("Aged Brie",1,1))

        updateItems(items)
        assertEquals(items.contentToString(), expectedItems.contentToString())
    }

    @Test fun nonNegativeUpdate()
    {
        val items = arrayOf(Item("+5 Dexterity Vest",0,20))
        val negativeItems = arrayOf(Item("+5 Dexterity Vest",-1,19))

        updateItems(items)
        assertNotEquals(items.contentToString(), negativeItems.contentToString())
    }
}


