package com.example.dailyfacts.model

import com.example.dailyfacts.R

object FactRepository {
    val funFacts = listOf<FunFact>(
        FunFact(
            dayOfMonth = 1,
            title = R.string.fact_title_one,
            image = R.drawable.fact_one,
            shortDescription = R.string.fact_description_one,
            fact = R.string.fact_fact_one
        ),
        FunFact(
            dayOfMonth = 2,
            title = R.string.fact_title_two,
            image = R.drawable.fact_two,
            shortDescription = R.string.fact_description_two,
            fact = R.string.fact_fact_two
        ),
        FunFact(
            dayOfMonth = 3,
            title = R.string.fact_title_three,
            image = R.drawable.fact_three,
            shortDescription = R.string.fact_description_three,
            fact = R.string.fact_fact_three
        ),
        FunFact(
            dayOfMonth = 4,
            title = R.string.fact_title_four,
            image = R.drawable.fact_four,
            shortDescription = R.string.fact_description_four,
            fact = R.string.fact_fact_four
        ),
        FunFact(
            dayOfMonth = 5,
            title = R.string.fact_title_five,
            image = R.drawable.fact_five,
            shortDescription = R.string.fact_description_five,
            fact = R.string.fact_fact_five
        )

    )
}