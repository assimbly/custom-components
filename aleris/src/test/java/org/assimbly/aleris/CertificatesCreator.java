package org.assimbly.aleris;

import org.assimbly.aleris.certificate.*;

import java.util.ArrayList;
import java.util.List;

public class CertificatesCreator {
    public Certificates create(int i, String issuerName, String issuerCode, String customerName, String customerCode,
                               List<String> elementNames, int numberOfStockUnits, int numberOfPropertyRowsPerStockUnit) {
        Certificates certificates = new Certificates();
        Company issuer = new Company(issuerName, issuerCode, "89977/0" + ++i);
        Company customer = new Company(customerName, customerCode, "31479" + ++i);
        Certificate certificate = new Certificate("V/008051706" + ++i, "2016-03-0" + ++i, issuer, customer);

        List<MechanicalProperty> properties = createMechanicalProperties(numberOfPropertyRowsPerStockUnit, i);

        Component baseMetal = new Component("Al", "Aluminium", null);
        for (int j = 0; j < numberOfStockUnits; ++j) {
            String stockUnitId = "89977" + pad(++i);

            ChemicalComposition chemicalComposition = new ChemicalComposition("% mass", baseMetal);
            for (String elementName : elementNames) {
                chemicalComposition.addComponent(new Component(elementName, null, "0." + ++i));
            }

            StockUnit stockUnit = new StockUnit(stockUnitId, "009568" + ++i, chemicalComposition);

            properties.forEach(stockUnit::addMechanicalProperty);

            certificate.addStockUnit(stockUnit);
        }

        certificates.addCertificate(certificate);

        return certificates;
    }

    private List<MechanicalProperty> createMechanicalProperties(int numberOfPropertyRows, int i) {
        List<MechanicalProperty> properties = new ArrayList<>();
        properties.addAll(createMechanicalProperties(numberOfPropertyRows, "ELO", "%", i));
        properties.addAll(createMechanicalProperties(numberOfPropertyRows, "PST", "N/mm2", ++i));
        properties.addAll(createMechanicalProperties(numberOfPropertyRows, "UTS", "N/mm2", ++i));
        return properties;
    }

    private List<MechanicalProperty> createMechanicalProperties(int numberOfPropertyRows, String code, String unit, int i) {
        List<MechanicalProperty> properties = new ArrayList<>();
        for (int k = 0; k < numberOfPropertyRows; ++k) {
            properties.add(new MechanicalProperty(code, null, String.valueOf(k + i), unit));
        }
        return properties;
    }

    private String pad(int i) {
        return String.format("%04d", i);
    }
}
