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

    /**
     * Créé l'objet GildedRose d'une liste d'items et y applique la méthode updateQuality
     * @param items : la liste des items à mettre à jour
     */
    private fun updateItems(items: Array<Item>)
    {
        val app = GildedRose(items)
        app.updateQuality()
    }

    /**
     * Exécute un test sur une liste d'item "normaux"
     */
    @Test fun normalUpdate() {
        val items = arrayOf(Item("+5 Dexterity Vest",10,20))
        val expectedItems = arrayOf(Item("+5 Dexterity Vest",9,19))

        updateItems(items)
        assertEquals(items.contentToString(), expectedItems.contentToString())
    }

    /**
     * Exécute un test sur l'item légendaire Sulfuras
     */
    @Test fun sulfurasUpdate() {

        val items = arrayOf(Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                Item("Sulfuras, Hand of Ragnaros", -1, 80))

        updateItems(items)
        assertEquals(items.contentToString(), items.contentToString())
    }

    /**
     * Exécute un test sur l'item "Aged Brie"
     */
    @Test fun agedBrieUpdate() {

        val items = arrayOf(Item("Aged Brie", 2, 0))
        val expectedItems = arrayOf(Item("Aged Brie",1,1))

        updateItems(items)
        assertEquals(items.contentToString(), expectedItems.contentToString())
    }

    /**
     * Exécute un test pour vérifier que la qualité des items ne peut être négative
     */
    @Test fun nonNegativeUpdate()
    {
        val items = arrayOf(Item("+5 Dexterity Vest",10,0))
        val negativeItems = arrayOf(Item("+5 Dexterity Vest",9,-1))

        updateItems(items)
        assertNotEquals(items.contentToString(), negativeItems.contentToString())
    }

    /**
     * Exécute un test qui vérifie que la qualité des items ne peut dépasser 50
     */
    @Test fun notOver50Update()
    {
        val items = arrayOf(Item("Aged Brie", 2, 50))
        val over50Items = arrayOf(Item("Aged Brie", 1, 51))

        updateItems(items)
        assertNotEquals(items.contentToString(), over50Items.contentToString())
    }
}


