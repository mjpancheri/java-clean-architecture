package br.com.alura.codechella.domain;

public class Address {
    private String zipCode;
    private String number;
    private String complement;

    public Address(String zipCode, String number, String complement) {
        this.zipCode = zipCode;
        this.number = number;
        this.complement = complement;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }
}
