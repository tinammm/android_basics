package com.example.altzagreb.data

import com.example.altzagreb.R
import com.example.altzagreb.model.AltInstitution
import com.example.altzagreb.model.AltInstitutionCategory
import com.example.altzagreb.model.PricingCategory
import com.google.android.gms.maps.model.LatLng

object AltMuseumDataProvider {
    fun getAllMuseums(): List<AltInstitution> {
        return listOf(
            AltInstitution(
                type = AltInstitutionCategory.Museum,
                name = R.string.hangover_museum,
                image = R.drawable.hangover,
                longDescriptor = R.string.hangover_museum_long_desc,
                shortDescriptor = R.string.hangover_museum_short_desc,
                pricing = PricingCategory.Cheap,
                locationLink = R.string.hangover_museum_location,
                geoLocation = LatLng(45.821780, 15.921650)
            ),
            AltInstitution(
                type = AltInstitutionCategory.Museum,
                name = R.string.museum_of_broken_relationships,
                image = R.drawable.broken_relationships,
                longDescriptor = R.string.museum_of_broken_relationships_long_desc,
                shortDescriptor = R.string.museum_of_broken_relationships_short_desc,
                pricing = PricingCategory.Cheap,
                locationLink = R.string.museum_of_broken_relationships_location,
                geoLocation = LatLng(45.796261, 15.965030)
            ),
            AltInstitution(
                type = AltInstitutionCategory.Museum,
                name = R.string.mushroom_museum,
                image = R.drawable.mushrooms,
                longDescriptor = R.string.mushroom_museum_long_desc,
                shortDescriptor = R.string.mushroom_museum_short_desc,
                pricing = PricingCategory.Cheap,
                locationLink = R.string.mushroom_museum_location,
                geoLocation = LatLng(45.8136478, 15.9767553)
            ),
        )
    }
}