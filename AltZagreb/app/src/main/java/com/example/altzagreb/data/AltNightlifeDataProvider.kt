package com.example.altzagreb.data

import com.example.altzagreb.R
import com.example.altzagreb.model.AltInstitution
import com.example.altzagreb.model.AltInstitutionCategory
import com.example.altzagreb.model.PricingCategory
import com.google.android.gms.maps.model.LatLng

object AltNightlifeDataProvider {
    fun getAllNightLife() : List<AltInstitution> {
        return listOf(
            AltInstitution(
                type = AltInstitutionCategory.Club,
                name = R.string.medika,
                image = R.drawable.medika,
                longDescriptor = R.string.medika_long_desc,
                shortDescriptor = R.string.medika_short_desc,
                pricing = PricingCategory.Affordable,
                locationLink = R.string.medika_location,
                geoLocation = LatLng(45.8064792, 15.9644548)
            )
        )
    }
}