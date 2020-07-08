package com.gildedrose

class GildedRose(var items: Array<Item>) {

    /**
     * Increment item's quality by 1
     */
    private fun increaseItemQuality(itemIndex: Int) {
        items[itemIndex].quality = items[itemIndex].quality + 1
    }

    /**
     * Decrement item's quality by 1
     */
    private fun decreaseItemQuality(itemIndex: Int) {
        items[itemIndex].quality = items[itemIndex].quality - 1
    }

    /**
     * Decrement the SellIn of the item by 1
     */
    private fun decreaseItemSellIn(itemIndex: Int) {
        items[itemIndex].sellIn = items[itemIndex].sellIn - 1
    }

    private fun decreaseQualityTwiceAsFast(itemIndex: Int) {
        if(items[itemIndex].quality > 0) {
            if (items[itemIndex].name == "Aged Brie") increaseItemQuality(itemIndex)
            else if (items[itemIndex].name != "Backstage passes to a TAFKAL80ETC concert") decreaseItemQuality(itemIndex)
        }
    }

    fun updateQuality() {
        for (i in items.indices) {
            // We start by dealing the case Sulfuras, which sellIn and quality will never change
            if (items[i].name == "Sulfuras, Hand of Ragnaros") {
                return
            }

            // Then we can decrement the sellIn
            decreaseItemSellIn(i)

            //TODO Ajouter une expression lambda pour gérer ça :
            if(items[i].sellIn < 0) decreaseQualityTwiceAsFast(i) // If the sellIn is quality decrease twice as fast

            // As the quality can never be under 0 and over 50 :
            if (items[i].quality in 1..49) {

                // We manage the aged brie
                if (items[i].name == "Aged Brie") {
                    increaseItemQuality(i)
                    return
                }

                // We manage the Backstage passes
                if (items[i].name == "Backstage passes to a TAFKAL80ETC concert") {
                    if (items[i].sellIn < 0) {
                        items[i].quality = 0
                        return
                    }
                    increaseItemQuality(i)
                    if (items[i].sellIn < 11)
                        increaseItemQuality(i)

                    if (items[i].sellIn < 6)
                        increaseItemQuality(i)
                }

                // Finally we manage the "normal" item
                else {
                    decreaseItemQuality(i)
                }
            }
        }
    }
}


            /*if (items[i].name != "Aged Brie" && items[i].name != "Backstage passes to a TAFKAL80ETC concert") {
                if (items[i].quality > 0) {
                    if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                        items[i].quality = items[i].quality - 1
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    increaseItemQuality(i)

                    if (items[i].name == "Backstage passes to a TAFKAL80ETC concert") {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                increaseItemQuality(i)
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                increaseItemQuality(i)
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
                        increaseItemQuality(i)
                    }
                }
            }*/


