package com.company.example.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by michaeldecourci on 26/01/2016.
 */
@XmlRootElement
public class PrimeNumberRequest {
    private String algorithmType;
    private Integer upperBound;

    public PrimeNumberRequest() {
    }

    public PrimeNumberRequest(final String pAlgorithmType, final Integer pUpperBound) {
        algorithmType = pAlgorithmType;
        upperBound = pUpperBound;
    }

    public String getAlgorithmType() {
        return algorithmType;
    }

    public PrimeNumberRequest setAlgorithmType(final String pAlgorithmType) {
        algorithmType = pAlgorithmType;
        return this;
    }

    public Integer getUpperBound() {
        return upperBound;
    }

    public PrimeNumberRequest setUpperBound(final Integer pUpperBound) {
        upperBound = pUpperBound;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PrimeNumberRequest{");
        sb.append("algorithmType=").append(algorithmType);
        sb.append(", upperBound=").append(upperBound);
        sb.append('}');
        return sb.toString();
    }
}
