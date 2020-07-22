public class Result {
    private final boolean isInCollection;
    private final long timeOfSearching;

    public Result(Boolean isInCollection, long timeOfSearching) {
        this.isInCollection = isInCollection;
        this.timeOfSearching = timeOfSearching;
    }

    public Result(String s) {
        String[] parts = s.split(" ");
        this.isInCollection = Boolean.parseBoolean(parts[0]);
        this.timeOfSearching = Long.parseLong(parts[1]);
    }

    public boolean isFound() {
        return isInCollection;
    }

    public long getTime() {
        return timeOfSearching;
    }

    @Override
    public String toString() {
        return (isInCollection ? " номер найден" : " номер не найден") + ", поиск занял " + String.valueOf(timeOfSearching);
    }




}
