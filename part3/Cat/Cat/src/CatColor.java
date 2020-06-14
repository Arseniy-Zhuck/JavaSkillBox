public enum CatColor {
    WHITE("white"),
    BLACK("black"),
    RED("red"),
    SIAM("siam"),
    GREY("grey");
    private final String code;
    CatColor(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }
}
