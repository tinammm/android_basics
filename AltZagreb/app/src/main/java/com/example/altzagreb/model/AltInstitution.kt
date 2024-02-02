package com.example.altzagreb.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.google.android.gms.maps.model.LatLng
import java.lang.invoke.TypeDescriptor

data class AltInstitution(
    /** Type of institution**/
    val type: AltInstitutionCategory,
    /** Name of alternative object **/
    @StringRes val name: Int,
    /** Image of institution**/
    @DrawableRes val image: Int,
    /** Long description of alternative object and what it offers**/
    @StringRes val longDescriptor: Int,
    /** Short description of alternative object indicating it's type**/
    @StringRes val shortDescriptor: Int,
    /** Pricing category that defines the object budget wise **/
    val pricing: PricingCategory,
    /** Google Maps link used for sharing location over intent **/
    @StringRes val locationLink: Int,
    /** Latitude and longitude of object **/
    val geoLocation : LatLng
)
