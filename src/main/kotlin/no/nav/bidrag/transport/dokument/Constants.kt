package no.nav.bidrag.transport.dokument

const val FARSKAP_UTELUKKET_PREFIKS = "FARSKAP UTELUKKET"

object BidragEnhet {
    const val ENHET_FARSKAP = "4860"
    const val ENHET_UTLAND = "4865"
}

enum class JournalpostStatus(val kode: String) {
    MOTTATT("M"),
    JOURNALFØRT("J"),
    EKSPEDERT("E"),
    UKJENT(""),
    DISTRIBUERT(""),
    AVBRUTT("A"),
    KLAR_FOR_DISTRIBUSJON("KP"),
    RETUR("RE"),
    FERDIGSTILT("FS"),
    FEILREGISTRERT("F"),
    RESERVERT("R"),
    UTGÅR("U"),
    UNDER_OPPRETTELSE("UO"),
    UNDER_PRODUKSJON("D");

    companion object {
        fun fraKode(kode: String?): JournalpostStatus? {
            return JournalpostStatus.values().firstOrNull { it.kode == kode }
        }
    }
//    companion object {
//        fun konverterStatus(status: String?): JournalpostStatus? {
//            return when (status) {
//                MOTTATT.name, Journalstatus.MOTTATT -> MOTTATT
//                FEILREGISTRERT.name, Journalstatus.FEILREGISTRERT -> FEILREGISTRERT
//                UNDER_PRODUKSJON.name, Journalstatus.UNDER_PRODUKSJON -> UNDER_PRODUKSJON
//                UNDER_OPPRETTELSE.name, Journalstatus.UNDER_OPPRETTELSE -> UNDER_OPPRETTELSE
//                FERDIGSTILT.name, Journalstatus.FERDIGSTILT -> FERDIGSTILT
//                EKSPEDERT.name, Journalstatus.EKSPEDERT -> EKSPEDERT
//                AVBRUTT.name, Journalstatus.AVBRUTT -> AVBRUTT
//                KLAR_FOR_DISTRIBUSJON.name, Journalstatus.KLAR_TIL_PRINT -> KLAR_FOR_DISTRIBUSJON
//                UTGÅR.name, Journalstatus.UTGAR -> UTGÅR
//                RETUR.name, Journalstatus.RETUR -> RETUR
//                RESERVERT.name, Journalstatus.RESERVERT -> RESERVERT
//                JOURNALFØRT.name, Journalstatus.JOURNALFORT -> JOURNALFØRT
//                DISTRIBUERT.name -> DISTRIBUERT
//                else -> null
//            }
//        }
//    }
}
