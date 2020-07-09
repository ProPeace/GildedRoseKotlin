package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        loop@ for (i in items.indices) {
            // We start by dealing the case Sulfuras, which sellIn and quality will never change
            if (items[i].name == "Sulfuras, Hand of Ragnaros") continue

            // Then we can decrement the sellIn
            decreaseItemSellIn(i)

            when (items[i].name) {
                "Aged Brie" -> updateAgedBrieQuality(i)
                "Backstage passes to a TAFKAL80ETC concert" -> updateBackstagePassesQuality(i)
                else -> updateNormalItemQuality(i)
            }
        }
    }

    /**
     * Update the quality of the Aged Brie item
     */
    private fun updateAgedBrieQuality(itemIndex: Int)
    {
        if (items[itemIndex].sellIn < 0) {
            increaseItemQuality(itemIndex)
        }
        increaseItemQuality(itemIndex)
    }

    /**
     * Update the quality of the Backstage passes items
     */
    private fun updateBackstagePassesQuality(itemIndex: Int)
    {
        if(items[itemIndex].sellIn < 0) {
            items[itemIndex].quality = 0
            return
        }
        increaseItemQuality(itemIndex)
        if (items[itemIndex].sellIn < 11) increaseItemQuality(itemIndex)
        if (items[itemIndex].sellIn < 6) increaseItemQuality(itemIndex)
    }

    /**
     * Update the quality of the normals item
     */
    private fun updateNormalItemQuality(itemIndex: Int)
    {
        if (items[itemIndex].sellIn < 0) {
            decreaseItemQuality(itemIndex)
        }
        decreaseItemQuality(itemIndex)
    }

    /**
     * Increment item's quality by 1
     */
    private fun increaseItemQuality(itemIndex: Int) { if(items[itemIndex].quality < 50) items[itemIndex].quality ++ }

    /**
     * Decrement item's quality by 1
     */
    private fun decreaseItemQuality(itemIndex: Int) { if(items[itemIndex].quality > 0)  items[itemIndex].quality -- }

    /**
     * Decrement the SellIn of the item by 1
     */
    private fun decreaseItemSellIn(itemIndex: Int) { items[itemIndex].sellIn -- }
}