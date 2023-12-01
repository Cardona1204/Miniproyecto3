package models;
public enum Partido {
    AGRUPACION_POLITICA_EN_MARCHA, INDEPENDIENTES, MOVIMIENTO_SALVACION_NACIONAL, MOVIMIENTO_ALIANZA_DEMOCRATICA_AMPLIA, MOVIMIENTO_ALTERNATIVO_INDIGENA_Y_SOCIAL, MOVIMIENTO_AUTORIDADES_INDIGENAS_DE_COLOMBIA, MOVIMIENTO_ESPERANZA_PAZ_Y_LIBERTAD, MOVIMIENTO_FUERZA_CIUDADANA, MOVIMIENTO_POLITICO_COLOMBIA_HUMANA, NUEVA_FUERZA_DEMOCRATICA, PARTIDO_ALIANZA_SOCIAL_INDEPENDIENTE, PARTIDO_ALIANZA_VERDE, PARTIDO_CAMBIO_RADICAL, PARTIDO_CENTRO_DEMOCRATICO, PARTIDO_COLOMBIA_JUSTA_LIBRES, PARTIDO_COLOMBIA_RENACIENTE, PARTIDO_COMUNES, PARTIDO_COMUNISTA_COLOMBIANO, PARTIDO_CONSERVADO_COLOMBIANO, PARTIDO_DE_LA_U,
    PARTIDO_DEL_TRABAJO_DE_COLOMBIA_PTC,
    PARTIDO_DEMOCRATA_COLOMBIANO, PARTIDO_ECOLOGISTA_COLOMBIANO, PARTIDO_LIBERAL_COLOMBIANO,
    PARTIDO_LIGA_GOBERNANTES_ANTICORRUPCIÓN,
    PARTIDO_NUEVO_LIBERALISMO,
    PARTIDO_POLO_DEMOCRATICO_ALTERNATIVO, PARTIDO_POLÍTICO_CREEMOS,
    PARTIDO_POLÍTICO_DIGNIDAD,
    PARTIDO_POLÍTICO_GENTE_EN_MOVIMIENTO,
    PARTIDO_POLÍTICO_LA_FUERZA_DE_LA_PAZ, PARTIDO_POLÍTICO_MIRA,
    PARTIDO_UNIÓN_PATRIÓTICA,
    PARTIDO_VERDE_OXIGENO,
    TODOS_SOMOS_COLOMBIA;

    @Override
    public String toString() {
   
    return super.toString().replaceAll("_", " " );
    }
}
