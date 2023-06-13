package no.nav.bidrag.transport.dokument

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.string.shouldContain
import org.junit.jupiter.api.Test

class OpprettJournalpostRequestTest {

    @Test
    fun shouldFailWhenJournalforendeenhetIsEmpty() {
        val result = shouldThrow<IllegalStateException> {
            OpprettJournalpostRequest(
                avsenderMottaker = AvsenderMottakerDto(ident = "123123213"),
                journalposttype = JournalpostType.UTGÅENDE,
                journalførendeEnhet = "",
                gjelder = AktorDto("1321312312"),
                dokumenter = listOf(OpprettDokumentDto("Tittel på dokument", brevkode = "BI099", fysiskDokument = ByteArray(5))),
                tilknyttSaker = listOf("12312321"),
                tittel = "Journalpost tittel"
            )
        }

        result.message shouldContain "JournalførendeEnhet kan ikke være tom"
    }

    @Test
    fun shouldFailWhenNoDocuments() {
        val result = shouldThrow<IllegalStateException> {
            OpprettJournalpostRequest(
                avsenderMottaker = AvsenderMottakerDto(ident = "123123213"),
                journalposttype = JournalpostType.UTGÅENDE,
                journalfoerendeEnhet = "4806",
                gjelder = AktorDto("1321312312"),
                dokumenter = emptyList(),
                tilknyttSaker = listOf("12312321"),
                tittel = "Journalpost tittel"
            )
        }

        result.message shouldContain "Journalpost må knyttes til et dokument"
    }

    @Test
    fun shouldFailWhenMoreThanOneDocument() {
        val result = shouldThrow<IllegalStateException> {
            OpprettJournalpostRequest(
                avsenderMottaker = AvsenderMottakerDto(ident = "123123213"),
                journalposttype = JournalpostType.UTGÅENDE,
                journalfoerendeEnhet = "4806",
                gjelder = AktorDto("1321312312"),
                dokumenter = listOf(
                    OpprettDokumentDto("Tittel på dokument", brevkode = "BI099", fysiskDokument = ByteArray(5)),
                    OpprettDokumentDto("Tittel 2 på dokument", brevkode = "BI099", fysiskDokument = ByteArray(5))
                ),
                tilknyttSaker = listOf("12312321"),
                tittel = "Journalpost tittel"
            )
        }

        result.message shouldContain "Midlertidig brevlager støtter bare et dokument per journalpost"
    }

    @Test
    fun shouldFailWhenDocumentsHasNoTitle() {
        val result = shouldThrow<IllegalStateException> {
            OpprettJournalpostRequest(
                avsenderMottaker = AvsenderMottakerDto(ident = "123123213"),
                journalposttype = JournalpostType.UTGÅENDE,
                journalfoerendeEnhet = "4806",
                gjelder = AktorDto("1321312312"),
                dokumenter = listOf(OpprettDokumentDto("", brevkode = "BI099", fysiskDokument = ByteArray(5))),
                tilknyttSaker = listOf("12312321"),
                tittel = "Journalpost tittel"
            )
        }

        result.message shouldContain "Dokumentet journalpost knyttes må ha satt tittel"
    }

    @Test
    fun shouldFailWhenMissingSak() {
        val result = shouldThrow<IllegalStateException> {
            OpprettJournalpostRequest(
                avsenderMottaker = AvsenderMottakerDto(ident = "123123213"),
                journalposttype = JournalpostType.UTGÅENDE,
                journalfoerendeEnhet = "4806",
                gjelder = AktorDto("1321312312"),
                dokumenter = listOf(OpprettDokumentDto("Tittel på dokument", brevkode = "BI099", fysiskDokument = ByteArray(5))),
                tilknyttSaker = listOf(),
                tittel = "Journalpost tittel"
            )
        }

        result.message shouldContain "Journalpost må knyttes til minst en sak"
    }

    @Test
    fun shouldFailWhenGjelderIsMissing() {
        val result = shouldThrow<IllegalStateException> {
            OpprettJournalpostRequest(
                avsenderMottaker = AvsenderMottakerDto(ident = "123123213"),
                journalposttype = JournalpostType.UTGÅENDE,
                journalfoerendeEnhet = "4806",
                dokumenter = listOf(OpprettDokumentDto("Tittel på dokument", brevkode = "BI099", fysiskDokument = ByteArray(5))),
                tilknyttSaker = listOf("12312321"),
                tittel = "Journalpost tittel"
            )
        }

        result.message shouldContain "Gjelder ident kan ikke være tom"
    }

    @Test
    fun shouldFailWhenAvsenderMottakerIsMissingForUtgaaendeJournalpost() {
        val result = shouldThrow<IllegalStateException> {
            OpprettJournalpostRequest(
                journalposttype = JournalpostType.UTGÅENDE,
                journalfoerendeEnhet = "4806",
                dokumenter = listOf(OpprettDokumentDto("Tittel på dokument", brevkode = "BI099", fysiskDokument = ByteArray(5))),
                tilknyttSaker = listOf("213213213"),
                gjelder = AktorDto("1321312312"),
                tittel = "Journalpost tittel"
            )
        }

        result.message shouldContain "Mottaker ident kan ikke være tom for utgående journalpost"
    }

    @Test
    fun shouldNotFailWhenAvsenderMottakerIsMissingForUtgaaendeNotat() {
        shouldNotThrow<IllegalStateException> {
            OpprettJournalpostRequest(
                journalposttype = JournalpostType.NOTAT,
                journalfoerendeEnhet = "4806",
                dokumenter = listOf(OpprettDokumentDto("Tittel på dokument", brevkode = "BI099", fysiskDokument = ByteArray(5))),
                tilknyttSaker = listOf("13123213"),
                gjelder = AktorDto("1321312312"),
                tittel = "Journalpost tittel"
            )
        }
    }
}
