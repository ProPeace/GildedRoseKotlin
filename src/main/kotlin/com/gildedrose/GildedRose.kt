package com.gildedrose

class GildedRose(var items: Array<Item>) {

    val hasQualityBetween0And50 : (Int)-> Boolean = { items[it].quality in 0..49 }

    /**
     * Increment item's quality by 1
     */
    private fun increaseItemQuality(itemIndex: Int) {
        if(items[itemIndex].quality < 50) items[itemIndex].quality ++
    }

    /**
     * Decrement item's quality by 1
     */
    private fun decreaseItemQuality(itemIndex: Int) {
        if(items[itemIndex].quality > 0)
            items[itemIndex].quality = items[itemIndex].quality - 1
    }

    /**
     * Decrement the SellIn of the item by 1
     */
    private fun decreaseItemSellIn(itemIndex: Int) {
        items[itemIndex].sellIn = items[itemIndex].sellIn - 1
    }

    private fun manageDateHasPassed(itemIndex: Int) {
        when (items[itemIndex].name) {
            "Aged Brie" -> increaseItemQuality(itemIndex)
            "Backstage passes to a TAFKAL80ETC concert" -> items[itemIndex].quality = 0
            else -> decreaseItemQuality(itemIndex)
        }
    }

    fun updateQuality() {
        for (i in items.indices) {
            // We start by dealing the case Sulfuras, which sellIn and quality will never change
            if (items[i].name == "Sulfuras, Hand of Ragnaros") continue

            // Then we can decrement the sellIn
            decreaseItemSellIn(i)

            // Now we check if the date has passed
            if (items[i].sellIn < 0) manageDateHasPassed(i)

            when (items[i].name) {
                "Aged Brie" -> increaseItemQuality(i)
                "Backstage passes to a TAFKAL80ETC concert" ->
                {
                    increaseItemQuality(i)
                    if (items[i].sellIn < 11)
                        increaseItemQuality(i)

                    if (items[i].sellIn < 6)
                        increaseItemQuality(i)
                }
                else -> if(items[i].quality > 0) decreaseItemQuality(i)
            }
        }
    }
}