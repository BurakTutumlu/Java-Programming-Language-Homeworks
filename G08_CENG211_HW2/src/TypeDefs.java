
public final class TypeDefs {
	/* ARTWORK STYLES */
	public static final String STYLE_RENAISSANCE="Renaissance";
	public static final String STYLE_CUBISM="Cubism";
	public static final String STYLE_REALISM="Realism";
	public static final String STYLE_BAROQUE="Baroque";
	public static final String STYLE_SURREALISM="Surrealism";
	public static final String STYLE_GOTHIC="Gothic";
	public static final String STYLE_NEOCLASSICISM="Neoclassicism";
	public static final String STYLE_MODERNISM="Modernism";
	public static final String STYLE_IMPRESSIONISM="Impressionism";
	/* SCULPTURE MATERIALS */
	public static final String MATERIAL_MARBLE = "Marble";
	public static final String MATERIAL_BRONZE = "Bronze";
	/* UNIT COSTS */
	// Painting
	public static final double UNIT_COST_RENAISSANCE_PAINTING=		7.0;
	public static final double UNIT_COST_BAROQUE_PAINTING=			5.5;
	public static final double UNIT_COST_DEFAULT_PAINTING=			4.5;
	// Sculpture
	public static final double UNIT_COST_MARBLE_SCULPTURE=			15.0;
	public static final double UNIT_COST_BRONZE_SCULPTURE=			180.0;
	// Architecture
	public static final double UNIT_COST_GOTHIC_ARCHITECTURE = 		1.0; 
	public static final double UNIT_COST_BAROQUE_ARCHITECTURE = 	0.8;
	public static final double UNIT_COST_DEFAULT_ARCHITECTURE = 	0.6;
	// Wallet
	public static final double DEFAULT_MONEY=						5000000.0;
	// Sort Method
	enum SortMethod {
        NAME,
        STYLE,
        ARTIST,
        MATERIAL,
        BIRTHDAY,
        NATIONALITY
    }
	// Types that can be stored in vault
	enum VaultDataType {
		ARTIST,
		ARCHITECT,
        PAINTING,
        SCULPTURE,
        ARCHITECTURE
    }
}
