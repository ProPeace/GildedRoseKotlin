package com.gildedrose

class GildedRose(var items: Array<Item>) {

    /**
     * Increment item's quality by 1
     */
    private fun incrementItemQuality(itemIndex : Int){
        items[itemIndex].quality = items[itemIndex].quality + 1
    }

    /**
     * Decrement the SellIn of the item by 1
     */
    private fun decrementItemSellIn(itemIndex : Int)
    {
        items[itemIndex].sellIn = items[itemIndex].sellIn - 1
    }

    fun updateQuality() {
        for (i in items.indices) {
            // We start by dealing the case Sulfuras, which will never change
            if (items[i].name == "Sulfuras, Hand of Ragnaros") {
                decrementItemSellIn(i)
                return
            }

            if (items[i].name != "Aged Brie" && items[i].name != "Backstage passes to a TAFKAL80ETC concert") {
                if (items[i].quality > 0) {
                    if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                        items[i].quality = items[i].quality - 1
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    incrementItemQuality(i)

                    if (items[i].name == "Backstage passes to a TAFKAL80ETC concert") {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                incrementItemQuality(i)
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                incrementItemQuality(i)
                            }
                        }
                    }
                }
            }

            if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                items[i].sellIn = items[i].sellIn - 1
            }

            if (items[i].sellIn < 0) {
                if (items[i].name != "Aged Brie") {
                    if (items[i].name != "Backstage passes to a TAFKAL80ETC concert") {
                        if (items[i].quality > 0) {
                            if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                                items[i].quality = items[i].quality - 1
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality
                    }
                } else {
                    if (items[i].quality < 50) {
                        incrementItemQuality(i)
                    }
                }
            }
        }
    }

}

