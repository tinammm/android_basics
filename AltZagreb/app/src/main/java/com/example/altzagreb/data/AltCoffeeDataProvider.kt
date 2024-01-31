package com.example.altzagreb.data

import com.example.altzagreb.R
import com.example.altzagreb.model.AltInstitution
import com.example.altzagreb.model.AltInstitutionCategory
import com.example.altzagreb.model.PricingCategory
import com.google.android.gms.maps.model.LatLng

object AltCoffeeDataProvider {
    fun getAllCoffeeShops() : List<AltInstitution> {
        return listOf(
            AltInstitution(
                type = AltInstitutionCategory.CoffeeShop,
                name = R.string.krivi_put,
                image = R.drawable.krivi_put,
                longDescriptor = R.string.krivi_put_long_desc,
                shortDescriptor = R.string.krivi_put_short_desc,
                pricing = PricingCategory.Cheap,
                locationLink = R.string.krivi_put_location,
                geoLocation = LatLng(45.793419, 15.958230)
            ),
            AltInstitution(
                type = AltInstitutionCategory.CoffeeShop,
                name = R.string.botanicar,
                image = R.drawable.botanicar,
                longDescriptor = R.string.botanicar_long_desc,
                shortDescriptor = R.string.botanicar_short_desc,
                pricing = PricingCategory.Affordable,
                locationLink = R.string.botanicar_location,
                geoLocation = LatLng(45.806300, 15.971400)
            )
        )
    }
}