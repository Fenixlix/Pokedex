package com.example.pokedex.detail_screen.model

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import com.example.pokedex.R

enum class PkTypeList(
    val typeName: String,
    @ColorRes val textColor: Int,
    @DrawableRes val image: Int
) {
    NORMAL(typeName = "normal", textColor = R.color.black, image = R.drawable.normal_icon),
    FIGHTING(typeName = "fighting", textColor = R.color.white, image = R.drawable.fighting_icon),
    FLYING(typeName = "flying", textColor = R.color.black, image = R.drawable.flying_icon),
    POISON(typeName = "poison", textColor = R.color.white, image = R.drawable.poison_icon),
    GROUND(typeName = "ground", textColor = R.color.black, image = R.drawable.ground_icon),
    ROCK(typeName = "rock", textColor = R.color.white, image = R.drawable.rock_icon),
    BUG(typeName = "bug", textColor = R.color.white, image = R.drawable.bug_icon),
    GHOST(typeName = "ghost", textColor = R.color.white, image = R.drawable.ghost_icon),
    STEEL(typeName = "steel", textColor = R.color.black, image = R.drawable.steel_icon),
    FIRE(typeName = "fire", textColor = R.color.white, image = R.drawable.fire_icon),
    WATER(typeName = "water", textColor = R.color.white, image = R.drawable.water_icon),
    GRASS(typeName = "grass", textColor = R.color.black, image = R.drawable.grass_icon),
    ELECTRIC(typeName = "electric", textColor = R.color.black, image = R.drawable.electric_icon),
    PSYCHIC(typeName = "psychic", textColor = R.color.white, image = R.drawable.psychic_icon),
    ICE(typeName = "ice", textColor = R.color.black, image = R.drawable.ice_icon),
    DRAGON(typeName = "dragon", textColor = R.color.white, image = R.drawable.dragon_icon),
    DARK(typeName = "dark", textColor = R.color.white, image = R.drawable.dark_icon),
    FAIRY(typeName = "fairy", textColor = R.color.black, image = R.drawable.fairy_icon),
    UNKNOWN(typeName = "unknown", textColor = R.color.black, image = R.drawable.default_type_icon),
    SHADOW(typeName = "shadow", textColor = R.color.white, image = R.drawable.dark_icon);

    companion object {
        fun getType(type: String): PkTypeList {
            return when (type) {
                NORMAL.typeName -> NORMAL
                FIGHTING.typeName -> FIGHTING
                FLYING.typeName -> FLYING
                POISON.typeName -> POISON
                GROUND.typeName -> GROUND
                ROCK.typeName -> ROCK
                BUG.typeName -> BUG
                GHOST.typeName -> GHOST
                STEEL.typeName -> STEEL
                FIRE.typeName -> FIRE
                WATER.typeName -> WATER
                GRASS.typeName -> GRASS
                ELECTRIC.typeName -> ELECTRIC
                PSYCHIC.typeName -> PSYCHIC
                ICE.typeName -> ICE
                DRAGON.typeName -> DRAGON
                DARK.typeName -> DARK
                FAIRY.typeName -> FAIRY
                SHADOW.typeName -> SHADOW
                else -> UNKNOWN
            }
        }
    }
}
