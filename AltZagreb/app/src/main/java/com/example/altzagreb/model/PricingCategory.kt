package com.example.altzagreb.model

enum class PricingCategory(val price: String) {
    Cheap(price = "$"),
    Affordable(price = "$$"),
    Upscale(price = "$$$"),
    Expensive(price = "$$$$")
}