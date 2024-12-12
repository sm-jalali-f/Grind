package org.example

/**
 * 121. Best Time to Buy and Sell Stock
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 * Example 1:
 *     Input: prices = [7,1,5,3,6,4]
 *     Output: 5
 *     Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *     Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * Example 2:
 *     Input: prices = [7,6,4,3,1]
 *     Output: 0
 *     Explanation: In this case, no transactions are done and the max profit = 0.
 * Constraints:
 *     1 <= prices.length <= 105
 *     0 <= prices[i] <= 104
 *     */
class Q4BuySellStock {

    fun goodAnswer(prices: IntArray): Int {
        if (prices.isEmpty()) return 0

        var minPrice = Int.MAX_VALUE
        var maxProfit = 0

        for (price in prices) {
            if (price < minPrice) {
                minPrice = price
            } else {
                val profit = price - minPrice
                if (profit > maxProfit) {
                    maxProfit = profit
                }
            }
        }

        return maxProfit
    }
    fun maxProfit(prices: IntArray): Int {
        var maxProfit = 0
        var minValue = 10001
        for (i in prices.indices) {
            if (prices[i] < minValue) {
                for (j in i + 1 until prices.size) {
                    if (prices[j] - prices[i] > maxProfit)
                        maxProfit = prices[j] - prices[i]
                }
                minValue = prices[i]
            }
        }
        return maxProfit

    }
}