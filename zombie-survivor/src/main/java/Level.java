public enum Level {
    RED(43, Integer.MAX_VALUE),
    ORANGE(19, 42),
    YELLOW(7, 18),
    BLUE(0, 6);

    private int lowerCota;

    private int higherCota;

    Level(int lowerCota, int higherCota) {
        this.lowerCota = lowerCota;
        this.higherCota = higherCota;
    }

    public static Level getLevelForExperience(int experience) {
        Level result = null;
        for (Level level : Level.values()) {
            if (level.lowerCota <= experience && level.higherCota >= experience) {
                result = level;
                break;
            }
        }
        return result;
    }

}
