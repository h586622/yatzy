"use strict";

class validator {
    constructor(root) {
        this.root = root;
        this.run = this.run.bind(this);
        this.rootElement = document.getElementById(this.root);
        this.fornavn = this.rootElement.querySelector('input[id="fornavn"]');
        this.etternavn = this.rootElement.querySelector('input[id="etternavn"]');
        this.brukernavn = this.rootElement.querySelector('input[id="brukernavn"]');
        this.epost = this.rootElement.querySelector('input[id="epost"]');
        this.passord = this.rootElement.querySelector('input[id="passord"]');
        this.passordRepetert = this.rootElement.querySelector('input[id="passordRepetert"]');
        this.feilmeldingboks = this.rootElement.querySelector('div[id="feilmeldingboks"]');
        this.passordInfo = this.rootElement.querySelector('div[id="passordInfo"]');
        this.knapp = this.rootElement.querySelector('input[id="knapp"]');


    }

    run() {

        this.fornavn.addEventListener("input", this.fornavnSjekk);
        this.etternavn.addEventListener("input", this.etternavnSjekk);
        this.brukernavn.addEventListener("input", this.brukernavnSjekk);
        this.epost.addEventListener("input", this.epostSjekk);
        this.passord.addEventListener("input", this.passordSjekk);
        this.passordRepetert.addEventListener("input", this.passordLikt);
        this.knapp.addEventListener("click" , this.sjekkSkjema);
        this.passord.addEventListener("mouseover", this.musOver);
        this.passord.addEventListener("mouseout", this.musUt);


    }

    epostSjekk(){
        if (epost.value.match("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")){
            epost.classList.remove("formcontroller_redBorder")
            epost.classList.add("formcontroller_greenBorder")
        } else {
            epost.classList.remove("formcontroller_greenBorder")
            epost.classList.add("formcontroller_redBorder")
        }
    }

    brukernavnSjekk() {
        if (brukernavn.value.match("^[a-zA-Z0-9_]{1,}[a-zA-Z]+[0-9]*$")) {

            brukernavn.classList.remove("formcontroller_redBorder")
            brukernavn.classList.add("formcontroller_greenBorder")

        } else {

            brukernavn.classList.remove("formcontroller_greenBorder")
            brukernavn.classList.add("formcontroller_redBorder")
        }
        if (brukernavn.value.length === 0) {
            brukernavn.classList.remove("formcontroller_greenBorder")
            brukernavn.classList.remove("formcontroller_redBorder")
        }

    }

    fornavnSjekk() {
        if (fornavn.value.match("^[A-ZÆØÅ][A-Za-zÆØÅæøå\\-]{2,19}$")) {


            fornavn.classList.remove("formcontroller_redBorder")
            fornavn.classList.add("formcontroller_greenBorder")

        } else {

            fornavn.classList.remove("formcontroller_greenBorder")
            fornavn.classList.add("formcontroller_redBorder")
        }
        if (fornavn.value.length === 0) {
            fornavn.classList.remove("formcontroller_greenBorder")
            fornavn.classList.remove("formcontroller_redBorder")
        }

    }

    etternavnSjekk() {
        if (etternavn.value.match("^[A-ZÆØÅ][A-Za-zÆØÅæøå\\-]{2,19}$")) {
            etternavn.classList.remove("formcontroller_redBorder")
            etternavn.classList.add("formcontroller_greenBorder")
        } else {
            etternavn.classList.remove("formcontroller_greenBorder")
            etternavn.classList.add("formcontroller_redBorder")
        }
        if (etternavn.value.length === 0) {
            etternavn.classList.remove("formcontroller_greenBorder")
            etternavn.classList.remove("formcontroller_redBorder")
        }

    }

    passordSjekk() {
        if (passord.value.match("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})")) {
            passord.classList.remove("formcontroller_redBorder")
            passord.classList.remove("formcontroller_yellowBorder")
            passord.classList.add("formcontroller_greenBorder")
        } else if (passord.value.match("^(((?=.*[a-z])(?=.*[A-Z]))|((?=.*[a-z])(?=.*[0-9]))|((?=.*[A-Z])(?=.*[0-9])))(?=.{6,})")) {
            passord.classList.remove("formcontroller_redBorder")
            passord.classList.add("formcontroller_yellowBorder")

        } else {
            passord.classList.remove("formcontroller_greenBorder")
            passord.classList.add("formcontroller_redBorder")
        }
        if (passord.value.length === 0) {
            passord.classList.remove("formcontroller_greenBorder")
            passord.classList.remove("formcontroller_redBorder")
            passord.classList.remove("formcontroller_yellowBorder")
        }
    }

    passordLikt() {
        if (passordRepetert.value === passord.value) {
            passordRepetert.classList.remove("formcontroller_redBorder")
            passordRepetert.classList.add("formcontroller_greenBorder")
        } else {
            passordRepetert.classList.remove("formcontroller_greenBorder")
            passordRepetert.classList.add("formcontroller_redBorder")
        }
        if (passordRepetert.value.length === 0) {
            passordRepetert.classList.remove("formcontroller_greenBorder")
            passordRepetert.classList.remove("formcontroller_redBorder")
        }

    }

    musOver() {
        passordInfo.classList.remove("formcontroller_hidden")
        passordInfo.innerHTML = "Passord maa inneholde en stor bokstav, ett tall, ett tegn og maa vaere minst 6 tegn"
        console.log("mus inn")
    }

    musUt() {
        passordInfo.classList.add("formcontroller_hidden")
        console.log("mus ut")
    }

    sjekkSkjema() {

        var feilmelding = new String("");

        if (!fornavn.value.match("^[A-ZÆØÅ][A-Za-zÆØÅæøå\\-]{2,19}$")) {
            feilmelding += "Ugyldig fornavn \n"
        }
        if (!etternavn.value.match("^[A-ZÆØÅ][A-Za-zÆØÅæøå\\-]{2,19}$")) {
            feilmelding += "Ugyldig etternavn \n"
        }
        if (!epost.value.match("^\\S+@\\S+$")) {
            feilmelding += "Ugyldig epostadresse \n"
        }
        if (!passord.value.match("^(((?=.*[a-z])(?=.*[A-Z]))|((?=.*[a-z])(?=.*[0-9]))|((?=.*[A-Z])(?=.*[0-9])))(?=.{6,})")) {
            feilmelding += "Ugyldig passord \n"
        }
        if (!passordRepetert.value === passord.value) {
            feilmelding += "Passord er ikke likt"
        }
        if (feilmelding.length === 0) {
            console.log("submit gokjent")
        } else {
            console.log("stopper submit")
            feilmeldingboks.classList.remove("formcontroller_hidden")
            feilmeldingboks.innerHTML = feilmelding
            event.preventDefault()
        }
    }
}

    const validatorr = new validator("root")

    document.addEventListener("DOMContentLoaded", validatorr.run)
