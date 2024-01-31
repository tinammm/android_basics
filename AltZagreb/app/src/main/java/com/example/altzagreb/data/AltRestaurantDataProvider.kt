package com.example.altzagreb.data

import com.example.altzagreb.R
import com.example.altzagreb.model.AltInstitution
import com.example.altzagreb.model.AltInstitutionCategory
import com.example.altzagreb.model.PricingCategory
import com.google.android.gms.maps.model.LatLng

object AltRestaurantDataProvider {
    fun getAltRestaurants() : List<AltInstitution>{
        return listOf(
            AltInstitution(
                type = AltInstitutionCategory.Restaurant,
                name = R.string.sopal,
                image = R.drawable.sopal,
                longDescriptor = R.string.sopal_long_desc,
                shortDescriptor = R.string.sopal_short_desc,
                pricing = PricingCategory.Affordable,
                locationLink = R.string.sopal_location,
                geoLocation = LatLng(45.8113433, 15.9751758)
            ),
            AltInstitution(
                type = AltInstitutionCategory.Restaurant,
                name = R.string.cato,
                image = R.drawable.cato,
                longDescriptor = R.string.cato_long_desc,
                shortDescriptor = R.string.cato_short_desc,
                pricing = PricingCategory.Cheap,
                locationLink = R.string.cato_location,
                geoLocation = LatLng(45.8137151, 15.990284)
            ),
            AltInstitution(
                type = AltInstitutionCategory.Restaurant,
                name = R.string.sol_tapas,
                image = R.drawable.sol_tapas,
                longDescriptor = R.string.sol_long_desc,
                shortDescriptor = R.string.sol_short_desc,
                pricing = PricingCategory.Upscale,
                locationLink = R.string.sol_location,
                geoLocation = LatLng(45.8130795, 15.9786428)
            ),
            AltInstitution(
                type = AltInstitutionCategory.Restaurant,
                name = R.string.kai,
                image = R.drawable.kai,
                longDescriptor = R.string.kai_long_desc,
                shortDescriptor = R.string.kai_short_desc,
                pricing = PricingCategory.Affordable,
                locationLink = R.string.kai_location,
                geoLocation = LatLng(45.8123818, 15.9785798)
            ),
            AltInstitution(
                type = AltInstitutionCategory.Restaurant,
                name = R.string.bestija,
                image = R.drawable.bestija,
                longDescriptor = R.string.bestija_long_desc,
                shortDescriptor = R.string.bestija_short_desc,
                pricing = PricingCategory.Upscale,
                locationLink = R.string.bestija_location,
                geoLocation = LatLng(45.8105375, 15.9729893)
            )
        )
    }
}