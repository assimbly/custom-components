package org.assimbly.oriflame.details;

public enum EdiType {
    PII(EdiDetails.PII_DETAILS),
    PIOR(EdiDetails.PIOR_DETAILS),
    PIOR_CROSS(EdiDetails.PIOR_CROSS_DETAILS),
    PIT(EdiDetails.PIT_DETAILS),
    POOI(EdiDetails.POOI_DETAILS),
    PPOO(EdiDetails.PPOO_DETAILS);

    private final EdiDetails details;

    EdiType(EdiDetails details) {
         this.details = details;
    }

    public static EdiDetails details(String type) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        EdiType ediType = valueOf(type);
        return ediType.details;
    };

}
