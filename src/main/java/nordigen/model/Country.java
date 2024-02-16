package nordigen.model;

public enum Country {
    AT("Austria",       "DE"),
    BE("Belgium",       "FR"),
    BG("Bulgaria",      "BG"),
    CZ("Czech Republic","CS"),
    CY("Cyprus",        "EL"),
    DK("Denmark",       "DA"),
    DE("Germany",       "DE"),
    EE("Estonia",       "ET"),
    ES("Spain",         "ES"),
    FI("Finland",       "FI"),
    FR("France",        "FR"),
    GB("Great Britain", "EN"),
    GR("Greece",        "EL"),
    HU("Hungary",       "HU"),
    HR("Croatia",       "HR"),
    IE("Ireland",       "EN"),
    IS("Iceland",       "IS"),
    LI("Liechtenstein", "DE"),
    LT("Lithuania",     "LT"),
    LV("Latvia",        "LV"),
    LU("Luxembourg",    "DE"),
    MT("Malta",         "EN"),
    NL("Netherlands",   "NL"),
    NO("Norway",        "NO"),
    SE("Sweden",        "SV"),
    IT("Italy",         "IT"),
    PL("Poland",        "PL"),
    PT("Portugal",      "PT"),
    RO("Romania",       "RO"),
    SI("Slovenia",      "SL"),
    SK("Slovakia",      "SK"),
    XX("Unknown",      "XX"),
    XXX("Unknown",      "XXX"),
    XUS("Unknown",      "XUS");

    private String name;
    private String languageCode;

    Country(String name, String languageCode) {
        this.name           = name;
        this.languageCode   = languageCode;
    }

    public String getName() {
        return name;
    }

    public String getLanguageCode() {
        return languageCode;
    }
}
