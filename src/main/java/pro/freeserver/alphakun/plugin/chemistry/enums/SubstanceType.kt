package pro.freeserver.alphakun.plugin.chemistry.enums

enum class SubstanceType(val friendlyName: String, val jpName: String) {
    SODIUM("Na", "ナトリウム"),
    SODIUM_HYDROXIDE("NaOH", "水酸化ナトリウム"),
    SODIUM_CHLORIDE("NaCl","塩化ナトリウム"),
    SALINE_WATER("SalineWater","食塩水"),
    HYDRO_CHLORIC_ACID("HCl","塩酸"),
    WATER("H2O","水")
}